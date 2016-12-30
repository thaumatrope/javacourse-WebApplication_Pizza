/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quests;

import java.util.ArrayList;

/**
 *
 * @author John Westfield
 */
public class Quest {
    
    private ANSWERTYPE type;
    private ArrayList<QuestAnswer> answers;
    private String text;
    private String name;
    private int id;
    
    public Quest() {
        answers = new ArrayList();
        type = ANSWERTYPE.CheckBox; // pre-selected for new Quest        
    }
    
     public enum ANSWERTYPE {
        Integer("Integer"),
        Double("Double"),
        String("String"),
        CheckBox("CheckBox"),
        RadioButton("RadioButton");
        
        private final String name;
        ANSWERTYPE(String name){
            this.name = name;
        }
        static public boolean isMember(String aName) {
            ANSWERTYPE[] tmps = ANSWERTYPE.values();
            for (ANSWERTYPE tmp : tmps)
                if (tmp.name.equals(aName))
                    return true;
            return false;
        }
    }
     
    public ArrayList<QuestAnswer> getQuestAnswerList(){
        return this.answers;
    }
    
    public void setQuestAnswerList (ArrayList<QuestAnswer> temp){
        this.answers = temp;
    }
     
     
    
    public String getQuestname(){
        return name;
    }
    
    public void setQuestname (String name){
        this.name = name;      
        
    }
    
    public String getQuesttext(){
        return text;
    }
    
    public void setQuesttext (String text){
        this.text = text;
    }
    
    public ANSWERTYPE getAnswertype(){
        return type;
    }
    
    public void setAnswertype (ANSWERTYPE type){
        this.type = type;
    }
    
    public int getID(){
        return this.id;
    }

    public void setID (int tmp){
        this.id = tmp;
    }
    
         
    public class QuestAnswer {
    
        private String answer;
        private Boolean correct;
        
        
        
        public String getAnswer(){
           return this.answer;
        }

        public void setAnswer (String text){
           this.answer = text;
        }
       
        public Boolean getCorrect(){
            return this.correct;
        }

        public void setCorrect (Boolean tmp){
            this.correct = tmp;
        }
          
    }  
      
    
}


