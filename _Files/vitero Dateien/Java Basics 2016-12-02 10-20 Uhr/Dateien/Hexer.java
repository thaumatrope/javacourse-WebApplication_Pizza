/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasy;

/**
 *
 * @author Sanne
 */
public class Hexer extends Spieler{
    protected int zauberkraft;
    protected float hexenLeben;
    public Hexer(String name, int zauberkraft){
        super("Nur damit  der Konstruktor zufrieden ist");
        this.wirdGespieltVon=name;
        this.zauberkraft=zauberkraft;
        this.schadenRate=this.zauberkraft*5;
        this.hexenLeben=super.leben/5;
    }
    public void anzeigen(){
        System.out.println("Namen:"+this.wirdGespieltVon);
        System.out.println("Leben: "+this.leben);
        System.out.println("Mach Schaden:"+this.schadenRate);
        System.out.println("Mit Leben: "+leben);
    }
}
