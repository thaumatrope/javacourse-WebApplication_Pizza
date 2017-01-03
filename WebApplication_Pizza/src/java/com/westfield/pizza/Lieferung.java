/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

import java.util.ArrayList;

/**
 *
 * @author jwest
 */
public class Lieferung {
    
    private ArrayList<Bestellung> myBestellungen;
    private int bestellnummer;

    public ArrayList<Bestellung> getMyBestellungen() {
        return myBestellungen;
    }  

    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }    
    
    public Lieferung(){        
        myBestellungen = new ArrayList();
    }
    
}
