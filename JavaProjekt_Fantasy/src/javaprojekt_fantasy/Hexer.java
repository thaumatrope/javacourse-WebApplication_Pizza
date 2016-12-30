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
public class Hexer extends Spieler {
    
    protected int zauberkraft;
    protected int hexenLeben;
    
    public Hexer(String name, int zauberkraft){
        super("Mein Superheld");
        this.Spielername = name;
        this.zauberkraft = zauberkraft;
        this.schadenrate = this.zauberkraft * 5;
        this.hexenLeben = super.leben / 5;
        
    }
    
    public Hexer(String name){
        super("Mein Superheld");
        this.Spielername = name;
        this.zauberkraft = 3;
        this.schadenrate = this.zauberkraft * 5;
        this.hexenLeben = super.leben / 5;
        
    }
    
    public void anzeigen() {
        
        System.out.println("Namen: " + this.Spielername);
        System.out.println("Leben: " + this.leben);
        System.out.println("Schadenrate: " + this.schadenrate);
    }
    
    public void verwunden (int schaden){
        leben -= schaden;
        zauberkraft += schaden;
        
    }
    
}
