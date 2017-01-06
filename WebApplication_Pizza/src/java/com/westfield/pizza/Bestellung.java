/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

/**
 *
 * @author jwest
 */
public class Bestellung extends DataAccess {
    
    private int menge;
    private String preis;
    private int position;
    private String sorte;

    public String getPreis() {
        return preis;
    }
    
     public double getPreisDouble() {  
         
        double tmp;
        try {
           tmp = Double.parseDouble(this.preis);
           System.out.println("Bestellung - getPreisDouble double: " + Double.parseDouble(this.preis));
        } catch (NumberFormatException e) {
            System.out.println("Bestellung-getPreisDouble: NumberFormatException");
            return 0.0;
        }         
        return tmp;        
        
    }

    public void setPreis(String preis) {        
        this.preis = preis;
        System.out.println("Bestellung: preis gesetzt - " + this.preis);
    }   

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
        System.out.println("Bestellung: sorte gesetzt - " + this.sorte);
    }
    
    

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
        System.out.println("Bestellung: menge gesetzt - " + this.menge);
    }

   
}
