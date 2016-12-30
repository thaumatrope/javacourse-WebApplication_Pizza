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
public class Krieger extends Spieler {
    
    protected int koerperkraft;
    
    public Krieger (String name, int kraft) {
        super(name);
        this.koerperkraft = kraft;
        
        
    }
    
    @Override
    public void verwunden (Charakter fremder){
        System.out.println("AUAAAA!!");
        fremder.wirdVerwundet(koerperkraft);
    }
    
    
}
