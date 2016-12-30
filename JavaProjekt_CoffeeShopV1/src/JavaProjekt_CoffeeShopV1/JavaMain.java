/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProjekt_CoffeeShopV1;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class JavaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        Shop java = new Shop();
        java.unsereKaffees();
        java.anzeigen();
        
        System.out.println("Willkommen in unserem virtuellem Cafe \"Die Bohne\"");
        
        Kunde horst;
        System.out.println("Bitte gib deinen Namen ein:");
        horst = new Kunde(input.next());
        System.out.println("Welcher Kaffee darf es sein?");
        int bestellung = input.nextInt();
        Kaffee tasse = java.finde(bestellung);
        horst.setKaffee(tasse);
        System.out.println("Kaffee wirsd gekocht.");
        System.out.println("Kaffee ist fertig!");
        java.rechnungErstellen(horst);
        
        
        
        
        
        
    }
    
}
