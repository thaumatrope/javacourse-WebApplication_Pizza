package com.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;

import com.model.Essen;
import com.model.EssenConverter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PreDestroy;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Named;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
//@Named
//@SessionScoped
public class MyController implements Serializable {

    private Essen bestell;
    private List<Essen> speisekarte;
    private List<Essen> bestellungen;
    private Integer anzahl;
    private double fullPrice;

//    @PostConstruct
//    public void init() {
//        speisekarte = EssenConverter.myEssen;
//    }
//  CallBack Methoden werden durch den Container aufgerufen    
//    @PreDestroy
//    private void delete(){
//        
//    }
    
    public MyController() {
       
         speisekarte=new ArrayList();   
                speisekarte.add(new Essen("Pizza Napoli", 3.00,111111));
                speisekarte.add(new Essen("Pizza Frutti di Mare", 7.50,2345));
                speisekarte.add(new Essen("Pizza Funghi", 5.00,3456));
                speisekarte.add(new Essen("Pizza Calzone", 6.00,4567));
                speisekarte.add(new Essen("Spaghetti Bolognese", 4.00,56789));
                speisekarte.add(new Essen("Spaghetti Carbonara", 4.50,6980));
           	
          
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public List<Essen> getBestellungen() {
        if (bestellungen == null) {
            bestellungen = new ArrayList();
        }
        return bestellungen;
    }

    public void setBestellungen(List<Essen> bestellungen) {
        this.bestellungen = bestellungen;
    }

    public Essen getBestell() {
        return bestell;
    }

    public void setBestell(Essen bestell) {
        this.bestell = bestell;
    }

    public  List<Essen> getSpeisekarte() {
        return speisekarte;
    }

    public void setSpeisekarte(List<Essen> speisekarte) {
        this.speisekarte = speisekarte;;
    }

    public void tue() {
        if (bestell != null||anzahl!=0) {
            bestell.setAnzahl(anzahl);
            bestellungen.add(bestell);
        }
        System.out.println("Anzeige:::" + this.bestell.getName());
        System.out.println("Anzeige Preis:::" + this.bestell.getPreis());
        bestell = null;
        anzahl=null;
    }

    public double getFullPrice() {
        for (Essen t : bestellungen) {
            fullPrice += t.getPreis() * t.getAnzahl();
        }
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

}
