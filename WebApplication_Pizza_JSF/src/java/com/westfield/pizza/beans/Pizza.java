/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.dao.DataAccess;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author User704
 */
@ManagedBean
@SessionScoped
public class Pizza extends DataAccess {
    
    private String name;
    private String preis;
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreis() {
        return preis;
    }
    
    public double getPreisDouble() {
        double tmp;
        try {
           tmp = Double.parseDouble(this.preis);
        } catch (NumberFormatException e) {
            System.out.println("Pizza-getPreisDouble: NumberFormatException");
              return 0.0;
        } 
        
        return tmp;
    }

    public void setPreis(String preis) {        
        
        this.preis = preis;
    }
    
   
    
}
