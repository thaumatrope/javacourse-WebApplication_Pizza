/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Quests.Quest;
import Quests.Quest.QuestAnswer;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author John Westfield
 */
public class DataAccess {
    
    private final String verbindung = "jdbc:mysql://localhost:3306/mydb_01?zeroDateTimeBehavior=convertToNull";
    private Connection myConnection;
    private Statement myStatement;
        
  
    public DataAccess() {
        
        this.getConnection();      
        
    }
    
    private boolean getConnection(){        
              
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: ClassNotFoundException - " + ex.getMessage());
            return false;
        }              
       
        try {
            myConnection = DriverManager.getConnection(verbindung, "root", "");
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
             return false;
        }      
        
        return true;
        
    }
    
    private Boolean doesQuestNameExist(String name){
        
        System.out.println("doesQuestNameExist - entered, Quest Name: " + name);
        
        String[] myQuestnames = this.getQuestData("Questname");
        for(String questname : myQuestnames){
            if(questname.equalsIgnoreCase(name)){
                 return true;
            }
        }
                   
        return false;    
            
    }   
    
    private Boolean doesQuestIDExist(int id){
        
        System.out.println("doesQuestIDExist - entered, Quest ID: " + id);
        
        String[] myQuestIDs = this.getQuestData("ID");
        for(String questID : myQuestIDs){
            if(id == Integer.parseInt(questID)){
                 return true;
            }
        }
                   
        return false;    
            
    }   
    
    private int getIDFromQuestname (String name){
        
        System.out.println("getIDFromQuestname - entered, Quest Name: " + name);
        
        ResultSet myResult;
        int id = 0;
                
        String abfrage = "SELECT ID from adventure WHERE Questname = '" + name + "'";
        
        try {
            myStatement = myConnection.createStatement();
        } catch (SQLException ex) {
             System.out.println("Exception: SQLException - " + ex.getMessage());
             return -1;
        }       
        
        try {
            myResult = myStatement.executeQuery(abfrage);
        } catch (SQLException ex) {
             System.out.println("Exception: SQLException - " + ex.getMessage());
             return -1;
        }     
       
        try {
            while(myResult.next()){
                id = myResult.getInt("ID");  
            }
            
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
            return -1;
        }         
        
        
       return id;
    }
    
    private String[] getQuestData(String column){
         
        System.out.println("getQuestData: entered - column: " + column);
         
        ResultSet myResult;
        ArrayList arrayResult = new ArrayList<String>();
                
        String abfrage = "SELECT * from adventure";
        
        try {
            myStatement = myConnection.createStatement();
        } catch (SQLException ex) {
             System.out.println("Exception: SQLException - " + ex.getMessage());
             return new String[0];
        }       
        
        try {
            myResult = myStatement.executeQuery(abfrage);
        } catch (SQLException ex) {
             System.out.println("Exception: SQLException - " + ex.getMessage());
             return new String[0];
        }     
       
        try {
            while(myResult.next()){
                String myID = myResult.getString(column);
                System.out.println("String-ID extracted: " + myID);
                arrayResult.add(myID);  
            }
            
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
            return new String[0];
        }         
        
        Collections.sort(arrayResult);
        String[] temp = (String[]) arrayResult.toArray(new String[arrayResult.size()]);
        
        System.out.println("getQuestData: returned - String[] size: " + temp.length);
        
        return temp;

        
      
    }
    
    
    private void alterQuest(Quest myQuest){          
       
        try {
            myStatement = myConnection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
        }

        String anfrage = "UPDATE adventure SET Questname = '"
                + myQuest.getQuestname() + "', Text = '"
                + myQuest.getQuesttext() + "', AnswerType = '"
                + myQuest.getAnswertype().name() + "' WHERE ID = '"
                + myQuest.getID() + "'"; 
                
        try {
            int iTemp = myStatement.executeUpdate(anfrage);
            System.out.println("UPDATE returns: " + iTemp);
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
        }      
        
     
     }
    
    private Quest addQuest(Quest myQuest){ 
         
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {        
            String query = "INSERT INTO adventure (Questname, Text, AnswerType) VALUES (?,?,?)";
            pstmt = myConnection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, myQuest.getQuestname());
            pstmt.setString(2, myQuest.getQuesttext());
            pstmt.setString(3, myQuest.getAnswertype().name());
      
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());

        }       
              
        try {
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                myQuest.setID(rs.getInt(1));
                System.out.println("INSERT returns - Generated Quest ID: "+myQuest.getID());
            }          
       
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());

        } finally{
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                //if(con != null) con.close();
            } catch(Exception ex){}
        }  
        
        return myQuest;
       
     }
    
    
    private void addQuestAnswers (Quest myQuest){
        
        int iTemp;
        this.deleteQuestAnswers(myQuest);
        
        try {
            myStatement = myConnection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
        }
        
        for (QuestAnswer myQA : myQuest.getQuestAnswerList()){
            try {
                System.out.println("addQuestAnswers Answer: " + myQA.getAnswer());
                System.out.println("addQuestAnswers Correct: " + myQA.getCorrect().toString() + " -- " + ((myQA.getCorrect()) ? 1 : 0));
                
                String anfrage = "INSERT INTO adventure_answers (ID, Answer, Correct) VALUES ( '"
                + myQuest.getID() + "', '"
                + myQA.getAnswer()+ "', '"
                + ((myQA.getCorrect()) ? 1 : 0) + "')";   
                iTemp = myStatement.executeUpdate(anfrage);
                System.out.println("addQuestAnswers: INSERT returns: " + iTemp);

            } catch (SQLException ex) {
                System.out.println("Exception: SQLException - " + ex.getMessage());
               
            }
        }        
     
    }
  
    private void deleteQuestAnswers(Quest myQuest){ 
         
        String anfrage = "DELETE FROM adventure_answers WHERE ID = '" + myQuest.getID() + "'";   
         
        try {
            myStatement = myConnection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
        }
        
        try {
            myStatement.executeUpdate(anfrage);
        } catch (SQLException ex) {
            System.out.println("Exception: SQLException - " + ex.getMessage());
        }   
        
        System.out.println("deleteQuestAnswers: succesfull ");
   
    }
    
       
    
             
    public String saveQuest(Quest myQuest){
        
        System.out.println("saveQuest - entered, Quest ID: " + myQuest.getID());
        
        if(this.doesQuestIDExist(myQuest.getID())){

            this.alterQuest(myQuest);
            this.addQuestAnswers(myQuest);
             
        } else {

            myQuest = this.addQuest(myQuest);
            this.addQuestAnswers(myQuest);
        }
        
        return myQuest.getQuestname();
       
    }
    
    public void deleteQuest(Quest myQuest){ 
         
        if(this.doesQuestIDExist(myQuest.getID())){
            
            String anfrage = "DELETE FROM adventure WHERE ID = '" +  myQuest.getID() + "'";   

            try {
                myStatement = myConnection.createStatement();
            } catch (SQLException ex) {
                System.out.println("Exception: SQLException - " + ex.getMessage());
            }

            try {
                myStatement.executeUpdate(anfrage);
            } catch (SQLException ex) {
                System.out.println("Exception: SQLException - " + ex.getMessage());
            }
            
            
        }
        //deleteQuestAnswers(myQuest);
        
      
    }
          
    public Quest getQuestbyQuestname(String name){
        
        System.out.println("getQuestData: entered for getting Quest from Questname: " + name);
        
        Quest myQuest = new Quest();
        int searchID = getIDFromQuestname(name);       
        
        
        if(getIDFromQuestname(name) > 0){           

            ResultSet myResult = null;           

            String abfrage = "SELECT * from adventure WHERE ID = '" + searchID + "'";

            try {
                myStatement = myConnection.createStatement();
            } catch (SQLException ex) {
                 System.out.println("Exception: SQLException - " + ex.getMessage());
            }       

            try {
                myResult = myStatement.executeQuery(abfrage);
            } catch (SQLException ex) {
                 System.out.println("Exception: SQLException - " + ex.getMessage());
            }     

            try {
                while(myResult.next()){
                    myQuest.setID(Integer.parseInt(myResult.getString("ID")));
                    myQuest.setQuestname(myResult.getString("Questname"));
                    myQuest.setQuesttext(myResult.getString("Text"));
                    if(myResult.getString("AnswerType").equalsIgnoreCase("Integer")){
                        myQuest.setAnswertype(Quest.ANSWERTYPE.Integer);
                    }else if(myResult.getString("AnswerType").equalsIgnoreCase("Double")){
                        myQuest.setAnswertype(Quest.ANSWERTYPE.Double);
                    }if(myResult.getString("AnswerType").equalsIgnoreCase("String")){
                        myQuest.setAnswertype(Quest.ANSWERTYPE.String);
                    }if(myResult.getString("AnswerType").equalsIgnoreCase("RadioButton")){
                        myQuest.setAnswertype(Quest.ANSWERTYPE.RadioButton);
                    }if(myResult.getString("AnswerType").equalsIgnoreCase("CheckBox")){
                        myQuest.setAnswertype(Quest.ANSWERTYPE.CheckBox);
                    }           
                    
                    System.out.println("DataAccess: returned - Quest found - Quest object[]: " + myQuest);
                }

            } catch (SQLException ex) {
                System.out.println("Exception: SQLException - " + ex.getMessage());
            }         
            
            // get QuestAnswer Object
            
            System.out.println("getQuestAnswerData: entered");

            myResult = null;           

            abfrage = "SELECT * from adventure_answers WHERE ID = '" + myQuest.getID() + "'";

            try {
                myStatement = myConnection.createStatement();
            } catch (SQLException ex) {
                 System.out.println("Exception: SQLException - " + ex.getMessage());
            }       

            try {
                myResult = myStatement.executeQuery(abfrage);
            } catch (SQLException ex) {
                 System.out.println("Exception: SQLException - " + ex.getMessage());
            }     

            try {
                while(myResult.next()){
                    
                    QuestAnswer myQA = myQuest.new QuestAnswer(); 
                    myQA.setAnswer(myResult.getString("Answer"));
                    System.out.println("getQuestData: QuestAnswer Correct - set: " + (myResult.getString("Correct")));
                    myQA.setCorrect(myResult.getString("Correct").equals("1"));
                    myQuest.getQuestAnswerList().add(myQA);
                }
                
                System.out.println("DataAccess: returned - QuestAnswer found - QuestAnswer object[]: " + myQuest.getQuestAnswerList());
           

            } catch (SQLException ex) {
                System.out.println("Exception: SQLException - " + ex.getMessage());
               
            }
        } 
            
        return myQuest;
               
       
    }
    
    public String[] getQuestnames(){
        
        System.out.println("getQuestnames: entered for getting Questnames");
        
        return this.getQuestData("Questname"); 
      
    }
    
    public Boolean checkQuestname (String name, int id) {
        
        if(this.doesQuestNameExist(name)){
            
           if(this.getIDFromQuestname(name) != id) {
               return true;
           }
        }
        
        return false;
             
    }
     
         
}
