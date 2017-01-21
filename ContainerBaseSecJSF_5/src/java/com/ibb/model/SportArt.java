/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.model;

/**
 *
 * @author Schulung
 */
public class SportArt {
    private Integer spId;
    private String bezeichnung;
    private String bewertung;

    public SportArt() {
        bezeichnung="";
        bewertung="0";
    }

    public SportArt(Integer spId, String bezeichnung, String bewertung) {
        this.spId = spId;
        this.bezeichnung = bezeichnung;
        this.bewertung = bewertung;
    }

    
    
    
    public SportArt(String bezeichnung, String bewertung) {
        this.bezeichnung = bezeichnung;
        this.bewertung = bewertung;
    }
    
    
    

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBewertung() {
        return bewertung;
    }

    public void setBewertung(String bewertung) {
        this.bewertung = bewertung;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }
    
    
}
