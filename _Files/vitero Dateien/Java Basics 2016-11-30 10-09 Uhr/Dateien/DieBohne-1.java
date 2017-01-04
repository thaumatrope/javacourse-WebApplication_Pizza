
package diebohne;

import java.util.Scanner;

public class DieBohne {
    
    public static void main(String[] args) {
       Scanner eingabe=new Scanner(System.in);
        System.out.println("Willkommen");
       Shop java=new Shop();
       java.unsereKaffees();
       java.anzeigen();
       
       Kunde horst;
        System.out.println("Bitte gib deinen Namen ein");
        horst=new Kunde(eingabe.next());
        System.out.println("Welche Kaffee darf es sein?");
        int bestellung=eingabe.nextInt();
        Kaffee tasse=java.finde(bestellung);
        horst.setKaffee(tasse);
        System.out.println("Kaffee wird gekocht");
        System.out.println("Kaffee ist fertig");
        java.rechnungErstellen(horst);
        
       
    }
    
}