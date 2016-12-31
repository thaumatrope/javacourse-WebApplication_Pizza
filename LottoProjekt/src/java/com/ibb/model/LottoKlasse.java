/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.model;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Schulung_IBB
 */
public class LottoKlasse {
    private Set<Integer> mySet;
    
    private String myString;

    

    public Set<Integer> getMySet() {
        return mySet;
    }

    /**
     * mySet enthält die gezogenen Lottozahlen 6 an der Zahl
     * @param mySet 
     */
    public void setMySet(Set<Integer> mySet) {
        this.mySet = mySet;
    }
/**
 * Im Konstruktor werden die Lottozahlen gezogen
 */
    public LottoKlasse() {
        mySet=new TreeSet();
        Random myRandom = new Random();
         while(mySet.size()<6){
                mySet.add(myRandom.nextInt(49)+1);
            }
    }
    
    
    
}
