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
public class Charakter {
    
    protected boolean gameOver = false;
    protected int leben = 3;
    protected int schadenrate;
    
    public Charakter (){
        this.leben = 100;
        this.schadenrate = 10;
        this.gameOver = false;
        System.out.println("Neuer Charakter!");
    }
    
    public void wirdVerwundet(int schaden){
        if (schaden <= leben){
            leben -= schaden;
        }else {
            System.out.println("Das bist tot!");
            gameOver = true;
        }
    }    
        
    public void verwunden(Charakter fremder){
        fremder.wirdVerwundet(schadenrate);
    }
    
    public void wirdGeheilt (int heilung) {
        this.leben += heilung;
    }
    
    public void anzeigen() {
        
        System.out.println("Leben: " + this.leben);
        System.out.println("Schadenrate: " + this.schadenrate);
    }
    

    
}
