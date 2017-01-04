/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licht;

/**
 *
 * @author Sanne
 */
public class BirnenVorratLeerException extends Exception {
    public BirnenVorratLeerException(){
        super("Bitte neue Birnen kaufen");
    }
}
