/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Adventures.Adventure;

/**
 *
 * @author John Westfield
 */
public interface IQuestConsole {
    
    /**
    *
    * @author John Westfield
    * 
    */
    public void getAnswer() throws InterruptedException;
    
    /**
    *
    * @author John Westfield
    * 
    * @param Adventure, Int
    */
    public void printQuest (Adventure myAdventure, int num);    
    
    
}
