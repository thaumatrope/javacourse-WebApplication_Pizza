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
    
    private String sorte;
    private String preis;
    private String image;
   
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }   
    
    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
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
