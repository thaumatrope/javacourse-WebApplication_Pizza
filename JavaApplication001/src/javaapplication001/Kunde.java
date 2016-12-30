/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication001;

/**
 *
 * @author user704
 */
public class Kunde {
    
    private String name;
    private int bestellung;
    
    public static final String logo = "Die Bohne";
    
    public Kunde () {
        name = "";
                System.out.println("Kunde erzeugt. (" + name + ")");
    }
    
    public Kunde (String pname) {
        name = pname;
        System.out.println("Kunde erzeugt. (" + name + ")");
    }
     
    public String getName (){
         return name;
    }
    
    public int getBestellung (){
         return bestellung;
    }
     
    public void bestellen(int nummer){
        bestellung = nummer;
    }
    
    
    
    
}
