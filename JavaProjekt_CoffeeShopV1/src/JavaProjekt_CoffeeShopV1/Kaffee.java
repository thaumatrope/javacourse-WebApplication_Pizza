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
public class Kaffee {
    
    private String sorte;
    private double preis;
    private int id;
    
    public Kaffee(String sorte, double preis, int id){
        this.sorte = sorte;
        this.preis = preis;
        this.id = id;
    }
    
    public int getID (){
        return id;
    }
    
    public String getSorte(){
        return sorte;
    }
    
    public double getPreis(){
        return preis;
    }
    
    
    
}
