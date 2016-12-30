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
public class Oger extends Charakter{
    
    public Oger() {
        this.leben = 200;
        this.schadenrate = 20;
        
    }
    
    public void anzeigen() {
        
        System.out.println("Leben: " + this.leben);
        System.out.println("Schadenrate: " + this.schadenrate);
    }
    
    
}
