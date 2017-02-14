/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication001;

/**
 *
 * @author user704
 */
public class Kaffee {
    
    private String sorte;
    private int sorteID;
    
    public Kaffee (String name, int id){
       sorte = name;
       sorteID = id;
   }
    
    public String getName() {
        return sorte;
    }   
    
    public void setName(String name) {
        sorte = name;
    }
           
    public int getID() {
        return sorteID;
    }
    
    public void setID(int zahl) {
        sorteID = zahl;
    }
    
}
