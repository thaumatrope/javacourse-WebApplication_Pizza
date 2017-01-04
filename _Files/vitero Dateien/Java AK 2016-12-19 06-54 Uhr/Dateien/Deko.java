/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deko;

/**
 *
 * @author Sanne
 */
public class Deko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wohnzimmmer wo=new Wohnzimmmer();
       
        wo.setTisch("Mein toller Tisch");
        wo.setFenster("Mein schönes Fenster");
        System.out.println("Tisch: "+wo.getTisch());
        
        Weihnachtszimmer wz=new Weihnachtszimmer(wo);
        wz.dekorierenTisch();
        wz.dekorierenFenster();
        System.out.println("Tisch: "+wz.getTisch());
        System.out.println("Fenster: "+wz.getFenster());
    }
    
}
