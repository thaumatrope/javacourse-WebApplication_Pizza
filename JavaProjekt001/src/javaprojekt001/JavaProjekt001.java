/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt001;

import Actors.Spieler;
import Frontend.Console4Adventure;

/**
 *
 * @author jwest
 * 
 * Improvements:
 * Timer
 * SuperStage
 * Review
 */
public class JavaProjekt001 {
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    
    public static void main(String[] args) throws InterruptedException {
               
        boolean active = true;
        Console4Adventure myConsole = new Console4Adventure("Willkommen zum Java Basics Adventure!");
        Spieler aktiverSpieler = null;
                
        String antwortString;
                
        
        do{
                        
            if(aktiverSpieler == null){
                       
                myConsole.printHeader();
                myConsole.init();
                               
                antwortString = myConsole.getInputString();
                
                if(antwortString.equalsIgnoreCase("start")){
                    myConsole.printEmptyLine(1);
                    System.out.println("Du beginnst ein neues Adventure!");
                    System.out.println("Wie heisst du?");
                    System.out.println("--------------");
                    antwortString = myConsole.getInputString();
                    
                    aktiverSpieler = new Spieler(antwortString);
                    aktiverSpieler.newAdventure();
                                    
                    
                }else if (antwortString.equalsIgnoreCase("exit")){
                    myConsole.printEmptyLine(1);
                    System.out.println("Programm wird beendet.");
                    active = false;
                    
                    
                }else if (antwortString.equalsIgnoreCase("test")){
                    myConsole.printEmptyLine(1);
                    System.out.println("Debugmode");
                    aktiverSpieler = new Spieler("DEBUG");
                    aktiverSpieler.newAdventure("DEBUG");
                    
                    
                }else {
                    System.out.println("Ungültige Antwort!");

                }                  
                
                               
            } else if (aktiverSpieler.getDebug()){
                
                myConsole.printHeader();
                
                
                myConsole.printDashes(60);
                System.out.println("(Debugmode - Bitte Quest-Name zum Testen eingeben:)");
                antwortString = myConsole.getInputString();
                
                
                myConsole.printEmptyLine(1);
                myConsole.printDashes(60);
                                
                aktiverSpieler.playNextQuest(antwortString);   
                                
                myConsole.printEndQuestDEBUG();          
               

                boolean loop;
                
                do{                  
                     loop = false;
                     antwortString = myConsole.getInputString();
                   

                    if (antwortString.equalsIgnoreCase("exit")) {
                        aktiverSpieler = null;
                        active = false;
                        
                    } else if (antwortString.equalsIgnoreCase("menu")){
                        aktiverSpieler = null;
                    } else if (antwortString.equalsIgnoreCase("test")) {
                        
                    } else {
                        System.out.println("Falsche Eingabe, bitte nochmal:");
                        loop = true;
                    }

                }while(loop);
                
            } else {   
                myConsole.printHeader();
                
                aktiverSpieler.playNextQuest();
                
                myConsole.printEndQuest();

                boolean loop;
                
                do{                  
                     loop = false;
                     antwortString = myConsole.getInputString();
                   

                    if (antwortString.equalsIgnoreCase("exit")){
                        aktiverSpieler = null;
                        active = false;
                    } else if (antwortString.equalsIgnoreCase("menu")) {
                        aktiverSpieler = null;
                    } else if (antwortString.equalsIgnoreCase("next")) {
                        
                    } else {
                        System.out.println("Falsche Eingabe, bitte nochmal:");
                        loop = true;
                    }

                }while(loop);             
                
            }  
            
            Thread.sleep(1000);
            
        }while(active); 
        
        
    }
    
  
}
