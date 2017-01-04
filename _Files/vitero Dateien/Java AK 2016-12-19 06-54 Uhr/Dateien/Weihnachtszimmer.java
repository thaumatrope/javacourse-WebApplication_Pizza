/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deko;

/**
 *
 * @author Sanne
 */
public class Weihnachtszimmer {
    private String tisch;
    private String fenster;
    public Weihnachtszimmer(Wohnzimmmer wz){
        tisch=wz.getTisch();
        fenster=wz.getFenster();
    }
    public void setTisch(String str){
        tisch=str;
    }
    public String getTisch(){
        return tisch;
    }
    public void setFenster(String str){
        fenster=str;
    }
    public String getFenster(){
        return fenster;
    }
    public void dekorierenFenster(){
        fenster+=" mit Elch";
    }
    public void dekorierenTisch(){
        tisch+=" mit Kerzen";
    }
}
