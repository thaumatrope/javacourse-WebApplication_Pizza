/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt002;

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
public class JavaProjekt002 {
    
    private static Console4Adventure myConsole;
    private static boolean active = true;
    private static Spieler aktiverSpieler;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    
    public static void main(String[] args) throws InterruptedException {
                   
        myConsole = new Console4Adventure("Willkommen zum Java Basics Adventure!");
        aktiverSpieler = null;
          
        //Game-Loop
        do{
                        
            if(aktiverSpieler == null){
                       
                doMenu_inaktiverSpieler();
                               
            } else if (aktiverSpieler.getDebug()){
                
                doMenu_Debug();
                
            } else if(aktiverSpieler.getAdventure().checkQuitfromAdventure())
                
                aktiverSpieler = null;
            
            else {   
                
                doMenu_aktiverSpieler();
            }
            
            Thread.sleep(1000);
            
        }while(active); 
        
        
    }
    
    private static void doMenu_inaktiverSpieler(){
        
        String antwortString;
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
    }
    
    public static void doMenu_Debug(){
        
        String antwortString;
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
            } else if (antwortString.equalsIgnoreCase("")) {

            } else {
                System.out.println("Falsche Eingabe, bitte nochmal:");
                loop = true;
            }

        }while(loop);
        
    }
    
    public static void doMenu_aktiverSpieler(){
        
        String antwortString;
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
            } else if (antwortString.equalsIgnoreCase("")) {

            } else {
                System.out.println("Falsche Eingabe, bitte nochmal:");
                loop = true;
            }

        }while(loop);             

    
    }
            
           
    
  
}
