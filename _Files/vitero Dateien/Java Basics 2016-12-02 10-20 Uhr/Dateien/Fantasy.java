/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasy;

/**
 *
 * @author Sanne
 */
public class Fantasy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Willkommen");
        System.out.println("Neuer Spieler;");
        Hexer spieler1=new Hexer("TestSpieler",5);
       spieler1.anzeigen();
        
    }
    
}
