/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author User704
 */
@ManagedBean
@SessionScoped
public class Bestellposten extends Pizza implements Serializable {
  
//    inherited
//    private String sorte;
//    private String preis;
//    private String image;
    
    private int bestellnummer;
    private int menge;
    private int position;
    private int id;
    private String image;
    
    private static final long serialVersionUID = 1L;
    
    public Bestellposten(){        
        
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
    
    public boolean evaluatePosition(int num){
        System.out.println("Bestellposten - evaluatePosition(" + num + ") -- evaluates: " + (num > 0) );
        return (num > 0);
    }
     
   
    
}
