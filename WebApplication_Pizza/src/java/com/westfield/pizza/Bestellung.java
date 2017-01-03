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
public class Bestellung {
    
    private int menge;
    private Pizza myPizza;
    private int position;

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

    public Pizza getMyPizza() {
        return myPizza;
    }

    public void setMyPizza(Pizza myPizza) {
        this.myPizza = myPizza;
    }
    
}
