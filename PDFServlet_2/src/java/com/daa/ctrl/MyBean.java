/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daa.ctrl;

import com.daa.model.Kunde;
import java.io.Serializable;






/**
 *
 * @author Schulung_IBB
 */

public class MyBean implements Serializable{
    private Kunde myKunde;
    private String name;
    private String vorname;

    public MyBean() {
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Kunde getMyKunde() {
        if(myKunde==null){
            myKunde=new Kunde();
        }
        return myKunde;
    }

    public void setMyKunde(Kunde myKunde) {
        this.myKunde = myKunde;
    }
    
    
    
}
