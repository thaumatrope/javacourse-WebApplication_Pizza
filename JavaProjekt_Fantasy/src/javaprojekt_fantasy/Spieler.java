/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt_fantasy;

/**
 *
 * @author jwest
 */
public class Spieler extends Charakter {
    
    protected String Spielername;
    
    public Spieler(String name){
        this.Spielername = name;
        System.out.println("Neuer Spieler:" + name);
    }
    
    public String getName(){
        return Spielername;
    }
    
    
}
