/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.dao.DataAccess;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author User704
 */
@ManagedBean
@SessionScoped
public class Bestellposten extends DataAccess {
    
    private String sorte;
    private String preis;
    private int bestellnummer;
    private int menge;
    private int position;
    private int id;

    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    }    
       
    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public String getPreis() {
        return preis;
    }
    
    public double getPreisDouble() {
        double tmp;
        try {
           tmp = Double.parseDouble(this.preis);
        } catch (NumberFormatException e) {
            System.out.println("Pizza-getPreisDouble: NumberFormatException");
              return 0.0;
        } 
        
        return tmp;
    }

    public void setPreis(String preis) {        
        
        this.preis = preis;
    }
    
   
    
}
