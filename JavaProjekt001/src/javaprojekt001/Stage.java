/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt001;

import java.util.Scanner;

/**
 *
 * @author jwest
 */
public class Stage extends Console {
    
    private int stageNumber = 0;
    private int subStageNumber = 0;
    private String [] myText;
    
    public Stage(int num1, int num2){
        
        this.stageNumber = num1;
        this.subStageNumber = num2;
        
    }
    
    public void init_stage(int health){
       
        this.init();
        
        System.out.println("Du bist in Stage " + stageNumber + " , " + subStageNumber);
        System.out.println("Deine Gesundheit beträgt noch " + health + " Punkte.");
        this.printEmptyLine(1);   

        
    }
    
    public void setText (String[] text){        
        
        for (String myText1 : text) {
            System.out.println(myText1);
        }
        printEmptyLine(1);
    }
    
    public void setQuestion (String[] question){        
        
        for (String myText1 : question) {
            System.out.println(myText1);
        }
        
        printEmptyLine(1);
    }
    
    public void setAnswer (String[] answer){
        int lengthText = 0;
        
        for (String myText1 : answer) {
            System.out.println(myText1);  
            if (lengthText < myText1.length())
                lengthText = myText1.length();
        }
        
        printDashes(lengthText);
    }
    
        
    
    
}
