/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jwest
 */
public class Lieferung extends DataAccess {
    
    private List<Bestellung> myBestellungen;
    private int bestellnummer;

    public List<Bestellung> getMyBestellungen() {
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
    
    public double getGesamtsumme(int pos){  
        System.out.println("Lieferung - Gesamtsumme: positions" + pos);
        double summe = 0;
        for(Bestellung best : this.myBestellungen){            
            if(this.myBestellungen.indexOf(best) < pos){
                System.out.println("Lieferung - Gesamtsumme: check - best.getPosition() <= pos : " + this.myBestellungen.indexOf(best) + " <= " + pos);
                summe += best.getPreisDouble();
            }
        }
        System.out.println("Lieferung - Gesamtsumme: " + summe);
        return summe;
    }
    
    public void deletePosition(int pos) {        
        this.myBestellungen.remove(pos - 1);
    }
    
    public void addPosition(Bestellung bestell) { 
        
        this.myBestellungen.add(bestell);
    }
    
}
