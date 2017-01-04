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
public class Licht {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lampe l=new Lampe();
        while(true){
            try{
                l.anschalten();
            }catch(BirneBrenntDurchException be){
                //Nächste Programmzeile nach Fehler
                try{
                    be.neueBirne();
                }catch(BirnenVorratLeerException bl){
                    System.out.println(bl.getMessage());
                    return;
                }
            }
            l.ausschalten();
        }
    }
    
}
