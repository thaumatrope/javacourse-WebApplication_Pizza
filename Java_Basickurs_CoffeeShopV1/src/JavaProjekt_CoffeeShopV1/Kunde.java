/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProjekt_CoffeeShopV1;

/**
 *
 * @author Administrator
 */
public class Kunde {
    
    private String name;
    private int bestellung;
    private Kaffee cafe;
    
    public final String logo = "Die Bohne";
    
    public Kunde (String name){
        
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void bestellen(int best){
        
        bestellung = best;        
    }
    
     public int getBestellung(){
        
        return bestellung;        
    }
     
     public void setKaffee(Kaffee kaffee){
        
        cafe = kaffee;        
    }
    
     public Kaffee getKaffee(){
        
        return cafe;        
    }
     
     
    
}
