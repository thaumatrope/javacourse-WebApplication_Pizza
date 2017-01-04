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
public class Charakter {
    protected int leben=3;
    protected boolean darfSpielen;
    protected int schadenRate;
    public Charakter(){
        schadenRate=10;
        leben=100;
        darfSpielen=true;
    }
    public void wirdGeheilt(int heilung){
        leben+=heilung;
    }
    public void wirdVerwundet(int schaden){
        if(schaden<= leben){
            leben-=schaden;
        }
        else{
            System.out.println("Das was's");
            darfSpielen=false;
        }
    }
    public void verwunden(Charakter fremder){
        fremder.wirdVerwundet(this.schadenRate);
    }
}
