/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication001;

import java.util.*;

/**
 *
 * @author User704
 */
public class JavaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String stringID1 = "Latte Macchiato";
        String stringID2 = "Cappuchino";
        String stringID3 = "Milchkaffee";
        
        String kundenName;
        int kundenBestellung;
        String kundenSorte;
        
        int id1 = 111;
        int id2 = 222;
        int id3 = 333;
        
        double preisID1 = 2.99;
        double preisID2 = 1.99;
        double preisID3 = 3.89;
        
        Random random = new Random();
        
        int startTEMP = random.nextInt(96);
        final int zielTEMP = 96;
        int aktTEMP = startTEMP;
        
        System.out.println("Hello Horld");
        System.out.println("Hello Developer");
        
        System.out.println("Willkommen in unserem virtuellen Kaffee \"Die Bohne\" ");
        
        Scanner consoleInput = new Scanner(System.in);
        int eingabe = consoleInput.nextInt();
        System.out.println("Eingabe war: " + eingabe);
        if(eingabe == id1){
            System.out.println("Bestellung - " + stringID1 + "(" + id1 + ") bestellt! Preis: " + preisID1);
        
        } else if(eingabe == id2){
            System.out.println("Bestellung - " + stringID2 + "(" + id2 + ") bestellt! Preis: " + preisID2);
        
        } else if(eingabe == id3){
            System.out.println("Bestellung - " + stringID3 + "(" + id3 + ") bestellt! Preis: " + preisID3);
        
        }else{
            System.out.println("Keine gültigen Informationen!");
        }
        
        System.out.println("Starttemperatur: " + startTEMP);
        while(aktTEMP < zielTEMP){
            System.out.println("Maschine heizt! aktuelle Temperatur: " + aktTEMP);
            aktTEMP += 5;
        }
        
        Kunde meinKunde1 = new Kunde();
        Kunde meinKunde2 = new Kunde("Jimmy");
        
        System.out.println("Wie ist dein Name");
        kundenName = consoleInput.next();
        meinKunde1 = new Kunde(kundenName);
        
        System.out.println("Wie lautet die Bestellung (111, 222, 333):");
        kundenBestellung = consoleInput.nextInt();
        
         if(kundenBestellung == id1){
            kundenSorte = stringID1;
        
        } else if(kundenBestellung == id2){
            kundenSorte = stringID2;
        
        } else if(kundenBestellung == id3){
            kundenSorte = stringID3;

        } else{
            kundenSorte = "";            
        }
            
        Kaffee meinKaffee1 = new Kaffee(kundenSorte, kundenBestellung);
        
        System.out.println(meinKunde1.getName() + " bestellt ein " + meinKaffee1.getName() + ", mit der ID " + meinKaffee1.getID());
    }
    
}
