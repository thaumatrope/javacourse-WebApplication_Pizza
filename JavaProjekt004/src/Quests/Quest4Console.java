/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quests;

import Adventures.Adventure;
import Frontend.Console;
import Interfaces.IQuestConsole;

/**
 *
 * @author John Westfield
 */
public class Quest4Console extends Console implements IQuestConsole{
    
    private String[] text;
    private String[] question;
    private String[] answer;
    private String questName;
        
    private Adventure myAdventure;
    
    private int questNumber;    
    private int spielerHealthbefore;  
    private int spielerHealthafter;
    private ANSWERTYPE answerType;
    private String[] correctAnswerString;
    private int correctAnswerInteger;
    private double correctAnswerDouble;
    
    private final String richtig = "Deine Antwort war richtig.";
    private final String falsch = "Deine Antwort war falsch.";
    
    public enum ANSWERTYPE {
        STRING, INTEGER, DOUBLE 
    }
    
    public Quest4Console (){
        
    }
            
    /**
    *
    * @author John Westfield
    * 
    * Constructor
     * @param adventure
     * @param name
     * @param text
     * @param question
     * @param answer
     * @param correct
    */
    public Quest4Console(Adventure adventure, String name, String[] text, String[] question, String[] answer, int correct){
        this.myAdventure = adventure;
        this.questName = name;        
        this.text = text;
        this. question = question;
        this.answer = answer;
        this.correctAnswerInteger = correct;
        answerType = ANSWERTYPE.INTEGER;
    }
    
    /**
    *
    * @author John Westfield
    * 
    * Constructor
     * @param adventure
     * @param name
     * @param text
     * @param question
     * @param answer
     * @param correct
    */
    public Quest4Console(Adventure adventure, String name, String[] text, String[] question, String[] answer, double correct){
        this.myAdventure = adventure;
        this.questName = name;
        this.text = text;
        this.question = question;
        this.answer = answer;
        this.correctAnswerDouble = correct;
        answerType = ANSWERTYPE.DOUBLE;
    }
    
    /**
    *
    * @author John Westfield
    * 
    * Constructor
     * @param adventure
     * @param name
     * @param text
     * @param question
     * @param answer
     * @param correct
    */
    public Quest4Console(Adventure adventure, String name, String[] text, String[] question, String[] answer, String[] correct){
        this.myAdventure = adventure;
        this.questName = name;
        this.text = text;
        this.question = question;
        this.answer = answer;
        this.correctAnswerString = correct;
        this.answerType = ANSWERTYPE.STRING;
    }
       
    @Override
    public void printQuest () {
        
        this.spielerHealthbefore = myAdventure.getSpieler().getHealth(); 
        this.questNumber = myAdventure.getStage();
        
        System.out.println("Dies ist die Quest \"" + questName + "\" ( Level: " + this.questNumber + " )");
        System.out.println("Deine Gesundheit beträgt noch " + spielerHealthbefore + " Punkte.");
        this.printEmptyLine(1);   
        
        this.printText();
        this.printQuestion();
        this.printAnswer();

    }
        
    
    @Override
    public void getAnswer() throws InterruptedException{
        
        switch(answerType){
            case DOUBLE:
               
                double myDouble = this.getInputDouble();

                if(Double.compare(myDouble, correctAnswerDouble) == 0) {  
                    System.out.println(richtig);
                    spielerHealthafter = spielerHealthbefore;
                }else {
                    System.out.println(falsch);
                    spielerHealthafter = spielerHealthbefore - questNumber;
                }
                break;
            
            case INTEGER:
                    
                int myInt = this.getInputInteger();

                if(myInt == correctAnswerInteger){      
                    System.out.println(richtig);
                    spielerHealthafter = spielerHealthbefore;
                }else {
                    System.out.println(falsch);
                    spielerHealthafter = spielerHealthbefore - questNumber;
                }
                break;
        
            case STRING:
       
            boolean treffer = false;
        
                String myString = this.getInputString();
                for (String item : correctAnswerString){
                    if(myString.equalsIgnoreCase(item)){   
                        System.out.println(richtig);
                        spielerHealthafter = spielerHealthbefore;
                        treffer = true;
                        break;
                    }
                }

                if (!treffer) {
                    System.out.println(falsch);
                    spielerHealthafter = spielerHealthbefore - questNumber;
                }
                break;
        }
        
        if(!questName.equals("Final")){
            myAdventure.getSpieler().setHealth(spielerHealthafter);
            this.printEmptyLine(1);
            if(spielerHealthafter < spielerHealthbefore){
                System.out.println("Du verlierst " + questNumber + " Punkt(e) an Gesundheit.");
            }
        }else
        {
            this.printEmptyLine(1);
            System.out.println("Du beendest das Adventure mit " + myAdventure.getSpieler().getHealth() + " Punkt(e) Gesundheit.");
        }        
        
        Thread.sleep(3000);
        
    }    
  
    
    private void printText (){        
        
        if(text != null){
            for (String myText1 : text) {
                System.out.println(myText1);
            }
            printEmptyLine(1);
        }
    }
    
   
    private void printQuestion (){        
        
         if(text != null){
            for (String myText1 : question) {             
                System.out.println(myText1);
            }        
            printEmptyLine(1);
         }
    }
    
    
    private void printAnswer (){
        int lengthText = 0;
        
        for (String myText1 : answer) {
            System.out.println(myText1);  
            if (lengthText < myText1.length())
                lengthText = myText1.length();
        }
        
        printDashes(lengthText);
    }
    
    public String getquestName(){
        return questName;
    }
           
    public int getspielerHealthafter(){
         return spielerHealthafter;
    }
    
}
