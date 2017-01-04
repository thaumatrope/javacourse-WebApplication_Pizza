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
public class Katze extends Saeugetiere implements Haustier{

    @Override
    public void willGefuettertWerden() {
        System.out.println("Milch oder Maeuse");
    }

    @Override
    public void meinSchlafplatz() {
        System.out.println("Egal, Hautsache warm!");
    }
    
}
