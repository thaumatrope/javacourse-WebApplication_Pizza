package com.westfield.pizza.controller;


import com.westfield.pizza.beans.Bestellposten;
import com.westfield.pizza.beans.Bestellung;
import com.westfield.pizza.dao.DataAccess;
import com.westfield.pizza.beans.Pizza;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@ManagedBean
@SessionScoped
public class PizzaService implements Serializable {

    private Bestellung myBestellung;
    
    private final String OUTCOME_SUCCESS_ORDER = "success_order";
    private final String OUTCOME_FAILED_ORDER = "failed_order";
    
    private static final long serialVersionUID = 1L;

    public PizzaService(){
        
        this.myBestellung = new Bestellung();
    
    }
    
    public Bestellung getMyBestellung() {
        return myBestellung;
    }

    public void setMyBestellung(Bestellung myBestellung) {
        this.myBestellung = myBestellung;
    }
    
    public String getOUTCOME_SUCCESS_ORDER() {
        return OUTCOME_SUCCESS_ORDER;
    }

    public String getOUTCOME_FAILED_ORDER() {
        return OUTCOME_FAILED_ORDER;
    }

       
    // ????
    public double getPizzaPreis (String sorte){
        
        for (Bestellposten myPizza : myBestellung.snatchPizzaAngebot()){
            
            if(myPizza.getSorte().equals(sorte)){
                return myPizza.getPreisDouble();
            }
        }
        return 0;
    }
    
    public String checkBestellung() {
        
        System.out.println("PizzaService -- checkBestellung() start...");
             
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session = request.getSession();
       
//        for(int i = 0; i < this.myBestellung.getPizzaBestellung().size(); i++){
//            if(this.myBestellung.getPizzaBestellung().get(i).getMenge() != 0){
//                anzahl += this.myBestellung.getPizzaBestellung().get(i).getMenge();
//                this.myBestellung.getPizzaBestellung().get(i).setPosition(i);
//            }
//            
//        }

        int position = 0;
        this.myBestellung.getPizzaBestellung().clear();
        for (Bestellposten myPizza : this.myBestellung.getPizzaAngebot()){
            
            if(myPizza.getMenge() > 0){
                position++;                

                myPizza.setPosition(position);
                System.out.println("PizzaService -- checkBestellung() added to displayBestellung Menge: " + myPizza.getMenge() + " / Position :" + position);
                
                this.myBestellung.getPizzaBestellung().add(myPizza);
                
            } else {
                 myPizza.setPosition(0);
            }
        }
        
        if(this.myBestellung.getPizzaBestellung().size() == 0){
            
            System.out.println("PizzaService -- checkBestellung() failed menge: 0 -- end... ");
            return OUTCOME_FAILED_ORDER;
            
        }else{
            
            System.out.println("PizzaService -- checkBestellung() success menge: " + this.myBestellung.getPizzaBestellung().size() + " -- end...");
            return OUTCOME_SUCCESS_ORDER;
            
        }   
        
    }
    
    public String doBestellung() {
        
        System.out.println("PizzaService -- checkBestellung() start...");
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        // Persitieren und PDF, Button Abbruch, Button Einstellungen, Admin infoseiten
        
        //Bestellung und Bestellposten speichern
        if (this.getMyBestellung().store()) {
            
            System.out.println("PizzaService -- doBestellung() suceess...");
            
            try {
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("/kunden/generate/do.pdf");
                return OUTCOME_SUCCESS_ORDER;
           
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }     
            
        } else{
            
            System.out.println("PizzaService -- doBestellung() failed...");
            
        }
        
        return OUTCOME_SUCCESS_ORDER;
    }
}
