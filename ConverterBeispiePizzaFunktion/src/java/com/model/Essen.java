package com.model;

import java.io.Serializable;

public class Essen implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private Double preis;
    private Integer anzahl;

    public Essen() {
       // super();
    }

    public Essen(int id, String name, Double preis) {
        this.id = id;
        this.name = name;
        this.preis = preis;
    }

    public Essen(String name, Double preis, Integer anzahl) {
        super();
        this.name = name;
        this.preis = preis;
        this.anzahl=anzahl;


    }

    public Essen(int id, String name, Double preis, Integer anzahl) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.anzahl = anzahl;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {

        return this.anzahl + "," + this.preis + "," + this.name;
    }
}
