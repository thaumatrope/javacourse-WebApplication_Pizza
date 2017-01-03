/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author User704
 */
public class Pizza {
    
    private static ArrayList<Pizza> pizzaAngebot = new ArrayList();
    public String[] pizzaPreise;
    public String[] pizzaNamen;

    public static ArrayList<Pizza> getPizzaAngebot() {
        return pizzaAngebot;
    }
    
    private String name;
    private Double preis;
    
    public Pizza(String name, Double preis){
        this.name = name;
        this.preis = preis;
        this.pizzaAngebot.add(this);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }
    
    public String getPreisFormatted() {
        
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.'); 
        NumberFormat formatter = new DecimalFormat(".00", otherSymbols);
        
        //NumberFormat formatter = new DecimalFormat();        
        return formatter.format(this.preis);
  
    }    
    
    public double getPizzaPreis (String name){
        
        for (Pizza myPizza : this.pizzaAngebot){
            
            if(myPizza.getName().equals(name)){
                return myPizza.getPreis();
            }
        }
        return 0;
    }
    
}
