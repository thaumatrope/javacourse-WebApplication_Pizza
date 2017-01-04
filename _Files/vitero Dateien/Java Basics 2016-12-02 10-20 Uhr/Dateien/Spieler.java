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
public class Spieler extends Charakter{
    protected String wirdGespieltVon;
    public Spieler (String neuerSpieler){
        wirdGespieltVon=neuerSpieler;
    }
    public String getName(){
        return wirdGespieltVon;
    }
}
