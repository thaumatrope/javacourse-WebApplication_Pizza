/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.daa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author IBB Teilnehmer
 */

public class Kunde  {
    //private static int anzahl = 0;

    //public static int getAnzahl() {
    //    return anzahl;
    //}
    
    private int kunde_id ;
    private String kunde_vorname;
    private String kunde_nachname ;
    private String kunde_strasse ;
    private String kunde_hausnummer;
    private String kunde_plz;
    private String kunde_ort;

    /**
     *
     */
    public Kunde() {
        //kunde_id = anzahl;
        //anzahl = anzahl + 1;
        //kunde_vorname = "Kunde-Vorname mit ID: " + kunde_id;
        //kunde_nachname = "Kunde-Nachname mit ID: " + kunde_id;
        //kunde_strasse = "Kunde-Strasse mit ID: " + kunde_id;
        //kunde_hausnummer = "Kunde-Hausnummer mit ID: " + kunde_id;
        //kunde_plz = "Kunde-PLZ mit ID: " + kunde_id;
        //kunde_ort = "Kunde-Ort mit ID: " + kunde_id;
    }
    
    /**
     *
     * @param setID
     * @param setVorname
     * @param setNachname
     * @param setStrasse
     * @param setHausnummer
     * @param setPlz
     * @param setOrt
     */
    public Kunde(int setID, String setVorname, String setNachname, String setStrasse, String setHausnummer, String setPlz, String setOrt){
        //kunde_id = anzahl;
        //anzahl = anzahl + 1;
        kunde_id = setID;
        kunde_vorname = setVorname;//!setVorname.equals("") ? setVorname : "Kunde-Vorname mit ID: " + kunde_id;
        kunde_nachname = setNachname;//!setNachname.equals("") ? setNachname : "Kunde-Nachname mit ID: " + kunde_id;
        kunde_strasse = setStrasse;//!setStrasse.equals("") ? setStrasse : "Kunde-Strasse mit ID: " + kunde_id;
        kunde_hausnummer = setHausnummer;//!setHausnummer.equals("") ? setHausnummer : "Kunde-Hausnummer mit ID: " + kunde_id;
        kunde_plz = setPlz;//!setPlz.equals("") ? setPlz : "Kunde-PLZ mit ID: " + kunde_id;
        kunde_ort = setOrt;//!setOrt.equals("") ? setOrt : "Kunde-Ort mit ID: " + kunde_id;
    }

    /**
     *
     * @return
     */
    public int getKunde_id() {
        return kunde_id;
    }

    /**
     *
     * @return
     */
    public String getKunde_vorname() {
        return kunde_vorname;
    }

    /**
     *
     * @return
     */
    public String getKunde_nachname() {
        return kunde_nachname;
    }

    /**
     *
     * @return
     */
    public String getKunde_strasse() {
        return kunde_strasse;
    }

    /**
     *
     * @return
     */
    public String getKunde_hausnummer() {
        return kunde_hausnummer;
    }

    /**
     *
     * @return
     */
    public String getKunde_plz() {
        return kunde_plz;
    }

    /**
     *
     * @return
     */
    public String getKunde_ort() {
        return kunde_ort;
    }

    /**
     *
     * @param kunde_id
     */
    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }

    /**
     *
     * @param kunde_vorname
     */
    public void setKunde_vorname(String kunde_vorname) {
        this.kunde_vorname = kunde_vorname;
    }

    /**
     *
     * @param kunde_nachname
     */
    public void setKunde_nachname(String kunde_nachname) {
        this.kunde_nachname = kunde_nachname;
    }

    /**
     *
     * @param kunde_strasse
     */
    public void setKunde_strasse(String kunde_strasse) {
        this.kunde_strasse = kunde_strasse;
    }

    /**
     *
     * @param kunde_hausnummer
     */
    public void setKunde_hausnummer(String kunde_hausnummer) {
        this.kunde_hausnummer = kunde_hausnummer;
    }

    /**
     *
     * @param kunde_plz
     */
    public void setKunde_plz(String kunde_plz) {
        this.kunde_plz = kunde_plz;
    }

    /**
     *
     * @param kunde_ort
     */
    public void setKunde_ort(String kunde_ort) {
        this.kunde_ort = kunde_ort;
    }
    
    
}
