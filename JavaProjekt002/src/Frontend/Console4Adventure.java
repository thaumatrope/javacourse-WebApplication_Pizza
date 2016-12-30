/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author John Westfield
 */
public class Console4Adventure extends Console {
    
    private String welcomeText;
    
    public Console4Adventure (String text){
       this.welcomeText = text; 
    }
    
    public void printHeader(){        
        this.cls();
        
        printStars(80);        
        printEmptyLine(1);
        
        System.out.println(welcomeText);
        printDashes(welcomeText.length());
        printEmptyLine(2);
        
    }  
    
    public void init(){          
        System.out.println("Möchten sie ein neues Adventure beginnen? (Bitte 'start' eingeben)");
        System.out.println("Möchten sie das Programm beenden. (Bitte 'exit' eingeben)");
        this.printDashes(60);       
    }  
    
    public void printEndQuest(){ 
        this.printEmptyLine(1);
        System.out.println("(Zum Beenden des Programms, bitte 'exit' eingeben)");
        System.out.println("(Zum Hauptmenue zurückkehren, bitte 'menu' eingeben)");
        System.out.println("(Zum Weiterspielen, bitte nur Enter drücken)");
        this.printDashes(60);
    }
    
    public void printEndQuestDEBUG(){ 
        this.printEmptyLine(1);
        System.out.println("(Zum Beenden des Programms, bitte 'exit' eingeben)");
        System.out.println("(Zum Hauptmenue zurückkehren, bitte 'menu' eingeben)");
        System.out.println("(Für einem weiteren Test, bitte nur Enter drücken)");
        this.printDashes(60);
    }
    
    
    
     
}
