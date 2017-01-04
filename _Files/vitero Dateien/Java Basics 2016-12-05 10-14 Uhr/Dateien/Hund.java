/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiere;

/**
 *
 * @author Sanne
 */
public class Hund extends Wolf implements Haustier{
    public void bellen(){
        System.out.println("Wau Wau");
    }
    @Override
    public void willGefuettertWerden() {
        System.out.println("GIB MIT FLEISCH");
    }

    @Override
    public void meinSchlafplatz() {
        System.out.println("Egal,Hauptsache nah bei Chef");
    }
    
}
