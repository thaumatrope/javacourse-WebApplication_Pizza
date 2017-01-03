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
    
    private List<Pizza> pizzaAngebot;
    private Set<Integer> kundennummern;
    private final String saveFile = "Kundennummern.sav";
    private String[] pizzaPreise;
    private String[] pizzaName;

     public PizzaService(){
        pizzaAngebot = new ArrayList();        
        pizzaAngebot.add(new Pizza("Pizza Tonno", 13.50));
        pizzaAngebot.add(new Pizza("Pizza Diavolo", 6.66));
        pizzaAngebot.add(new Pizza("Pizza Hawaii", 12.30));
        pizzaAngebot.add(new Pizza("Pizza Calzone", 11.00));
        pizzaAngebot.add(new Pizza("Pizza Quattro Stagioni", 14.00));
         
        pizzaName = new String[pizzaAngebot.size()];  
        pizzaName[0] = pizzaAngebot.get(0).getName();
        pizzaName[1] = pizzaAngebot.get(1).getName(); 
        pizzaName[2] = pizzaAngebot.get(2).getName();
        pizzaName[3] = pizzaAngebot.get(3).getName();
        pizzaName[4] = pizzaAngebot.get(4).getName();
        
        pizzaPreise = new String[pizzaAngebot.size()]; 
        NumberFormat formatter = new DecimalFormat(".00");  
        pizzaPreise[0] = formatter.format(pizzaAngebot.get(0).getPreis());
        pizzaPreise[1] = formatter.format(pizzaAngebot.get(1).getPreis()); 
        pizzaPreise[2] = formatter.format(pizzaAngebot.get(2).getPreis());
        pizzaPreise[3] = formatter.format(pizzaAngebot.get(3).getPreis());
        pizzaPreise[4] = formatter.format(pizzaAngebot.get(4).getPreis());
        
        this.checkAndLoadKundennummern();
        
    }

    public String[] getPizzaPreise() {
        return pizzaPreise;
    }

    public void setPizzaPreise(String[] pizzaPreise) {
        this.pizzaPreise = pizzaPreise;
    }

    public String[] getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String[] pizzaName) {
        this.pizzaName = pizzaName;
    }
     
     
    public List<Pizza> getPizzaAngebot() {
        return pizzaAngebot;
    }

    public void setPizzaAngebot(List<Pizza> pizzaAngebot) {
        this.pizzaAngebot = pizzaAngebot;
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
    
    
}
