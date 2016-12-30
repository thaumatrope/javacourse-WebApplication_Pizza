/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quests;

import Adventures.Adventure;
import Interfaces.IQuestJGUI;

/**
 *
 * @author John Westfield
 */
public class Quest4JGUI extends Quest implements IQuestJGUI{
    
    private static final String richtig = "Deine Antwort war richtig.";
    private static final String falsch = "Deine Antwort war falsch.";
    
    private Adventure myAdventure;
    
    private int questNumber;    
    private int spielerHealthbefore;  
    private int spielerHealthafter;  
    
    public Quest4JGUI (){
        
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
//    public Quest4JGUI(Adventure adventure, String name, String[] text, String[] question, String[] answer, String[] correct){
//        this.myAdventure = adventure;
//        this.name = name;
//        this.text = text;
//        this.question = question;
//        this.answer = answer;
//        this.correctAnswerString = correct;
//        this.answerType = ANSWERTYPE.STRING;
//    }
       
    @Override
    public void printQuest () {
        
        this.spielerHealthbefore = myAdventure.getSpieler().getHealth(); 
        this.questNumber = myAdventure.getStage();
        
        System.out.println("Dies ist die Quest \"" + this.getQuestname() + "\" ( Level: " + this.questNumber + " )");
        System.out.println("Deine Gesundheit beträgt noch " + spielerHealthbefore + " Punkte.");
 
//        
//        this.printText();
//        this.printQuestion();
//        this.printAnswer();

    }
        
    
    @Override
    public void getAnswer() throws InterruptedException{
        
        switch(this.getAnswertype()){
            case Integer:
               
//                double myDouble = this.getInputDouble();
//
//                if(Double.compare(myDouble, correctAnswerDouble) == 0) {  
//                    System.out.println(richtig);
//                    spielerHealthafter = spielerHealthbefore;
//                }else {
//                    System.out.println(falsch);
//                    spielerHealthafter = spielerHealthbefore - questNumber;
//                }
//                break;
            
            case Double:
                    
//                int myInt = this.getInputInteger();
//
//                if(myInt == correctAnswerInteger){      
//                    System.out.println(richtig);
//                    spielerHealthafter = spielerHealthbefore;
//                }else {
//                    System.out.println(falsch);
//                    spielerHealthafter = spielerHealthbefore - questNumber;
//                }
//                break;
        
            case String:
       
//                boolean treffer = false;
//        
//                String myString = this.getInputString();
//                for (String item : correctAnswerString){
//                    if(myString.equalsIgnoreCase(item)){   
//                        System.out.println(richtig);
//                        spielerHealthafter = spielerHealthbefore;
//                        treffer = true;
//                        break;
//                    }
//                }
//
//                if (!treffer) {
//                    System.out.println(falsch);
//                    spielerHealthafter = spielerHealthbefore - questNumber;
//                }
//                break;
        }
        
//        if(!questName.equals("Final")){
//            myAdventure.getSpieler().setHealth(spielerHealthafter);
//            this.printEmptyLine(1);
//            if(spielerHealthafter < spielerHealthbefore){
//                System.out.println("Du verlierst " + questNumber + " Punkt(e) an Gesundheit.");
//            }
//        }else
//        {
//            this.printEmptyLine(1);
//            System.out.println("Du beendest das Adventure mit " + myAdventure.getSpieler().getHealth() + " Punkt(e) Gesundheit.");
//        }        
//        
//        Thread.sleep(3000);
        
    }    
  
    
   
    // GETTER - SETTER
    
    public void setAdventure(Adventure adventure){
         this.myAdventure =  adventure;
    }
    public Adventure getAdventure(){
         return this.myAdventure;
    }
    public void setQuestNumber(int number){
         this.questNumber =  number;
    }
    public int getQuestNumber(){
         return this.questNumber;
    }
    
    public void setspielerHealthbefore(int number){
         this.spielerHealthbefore =  number;
    }
    public int getspielerHealthbefore(){
         return this.spielerHealthbefore;
    }
    
    public void setspielerHealthafter(int number){
         this.spielerHealthafter =  number;
    }
    public int getspielerHealthafter(){
         return spielerHealthafter;
    }
    
}
