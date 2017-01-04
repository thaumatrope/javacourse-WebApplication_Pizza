/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

/**
 *
 * @author Sanne
 */
public class Einladung {
    public void einladen(String name) throws NichtEingeladen{
        if(name.equals("Gargamel")){          
            throw new NichtEingeladen();
        }
        System.out.println("Lieber "+name+"du bist herzlich zur Party eingeladen");
    }
}
