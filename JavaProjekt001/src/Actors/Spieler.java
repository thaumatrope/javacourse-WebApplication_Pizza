/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actors;

import Adventures.Adventure;

/**
 *
 * @author John Westfield
 */
public class Spieler extends Actor{
    
    private Adventure myAdventure;
    private boolean debug;
    
    
    /**
    *
    * @author John Westfield
    * 
    * @param String
    * 
    * Konstruktor
    */
    public Spieler(String name){
        
        this.setName(name);
        this.setHealth(100);
                
    }  
    
    /**
    *
    * @author John Westfield
    * 
    */
    public void newAdventure(){
        debug = false;
        this.myAdventure = new Adventure(this);
    }
    
    /**
    *
    * @author John Westfield
    * 
    * @param String
    */
    public void newAdventure(String mode){
        
        if (mode.equals("DEBUG")){
            debug = true;
            this.myAdventure = new Adventure(this);
        }
        
    }
    
    /**
    *
    * @author John Westfield
    * 
    */
    public void playNextQuest(){        
        
        this.myAdventure.playQuest();
    } 
    
    /**
    *
    * @author John Westfield
    * 
    * @param String
    */
    public void playNextQuest(String questname){        
        
        this.setHealth(100);
        this.myAdventure.playQuest(questname);
    } 
    
    
    /**
    *
    * @author John Westfield
    * 
    * Getter
    */
    public boolean getDebug(){
        return this.debug;
    }
    
}
