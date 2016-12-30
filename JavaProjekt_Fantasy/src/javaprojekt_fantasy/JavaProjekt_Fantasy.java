/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt_fantasy;

/**
 *
 * @author jwest
 */
public class JavaProjekt_Fantasy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Willkommen zu Fantasy!");
        
        double pi = Math.PI;
        System.out.println("PI ist: " + pi);
        
        System.out.println("Initialisierung");
        Hexer spieler1 = new Hexer("Hexer", 5);
        System.out.println("Erstellt: " + spieler1.getName());
        spieler1.anzeigen();
        //spieler1.verwunden(6);
        //spieler1.anzeigen
        Oger feind1 = new Oger();
        feind1.anzeigen();
        
        spieler1.verwunden(feind1);
        feind1.verwunden(spieler1);
        
        
        Charakter a1 = new Hexer("Die Hexe");
        Spieler x = new Hexer("XXX");
        x = new Hexer("YYY");
        Charakter a2 = new Oger();
        Charakter a3 = new Krieger("Hau Drauf", 20);
        Charakter a4= new Spieler("Hans im Glück");
        
        System.out.println("*************");
        
        a1.anzeigen();
        a2.anzeigen();
        a3.anzeigen();
        a4.anzeigen();
        
        x.getName();
        
        
        
        
        
        
        
        
    }
    
}
