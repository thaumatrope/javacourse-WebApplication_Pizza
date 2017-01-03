package com.westfield.pizza;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User704
 */
public class PizzaService implements AutoCloseable {
    
    private Set<Integer> kundennummern;
    private final String saveFile = "Kundennummern.sav";


     public PizzaService(){
                
        new Pizza("Pizza Tonno", 13.50);
        new Pizza("Pizza Diavolo", 6.66);
        new Pizza("Pizza Hawaii", 12.30);
        new Pizza("Pizza Calzone", 11.00);
        new Pizza("Pizza Quattro Stagioni", 14.00);
         
       
        //pizzaName[0] = pizzaAngebot.get(0).getName();
       
        
        //pizzaPreise = new String[pizzaAngebot.size()]; 
       
      
        
        this.checkAndLoadKundennummern();
        
    }

  

    public Set<Integer> getKundennummern() {
        return kundennummern;
    }

    public void setKundennummern(Set kundennummern) {
        this.kundennummern = kundennummern;
    }
    
    private void saveKundennummern(){
        
         // Serialize / save it
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(saveFile));
             oos.writeObject(this.getKundennummern());
             oos.flush(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PizzaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PizzaService.class.getName()).log(Level.SEVERE, null, ex);
        }       
          
    }
   
    private void checkAndLoadKundennummern(){
        
        File save = new File(saveFile);
        if(save.isFile()){           
    
            // Deserialize / load it
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(new FileInputStream(saveFile));
                this.setKundennummern((HashSet<Integer>) ois.readObject());
            } catch (IOException ex) {
                Logger.getLogger(PizzaService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PizzaService.class.getName()).log(Level.SEVERE, null, ex);
            }          
         
            
        }else{            
            
            this.setKundennummern(new HashSet()); 
            
        }
       
        
    }

    @Override
    public void close() throws Exception {
        this.saveKundennummern();
        System.out.println("Kundennummern gespeichert.");
    }
    
    
    
    
    
    private void addPosition2Lieferung(Lieferung lieferung, Bestellung bestellung){
        
        
        
        
    }
    
}
