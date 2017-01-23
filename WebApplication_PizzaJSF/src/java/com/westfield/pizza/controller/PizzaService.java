package com.westfield.pizza.controller;


import com.westfield.pizza.beans.Bestellposten;
import com.westfield.pizza.beans.Bestellung;
import com.westfield.pizza.dao.DataAccess;
import com.westfield.pizza.beans.Pizza;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@ManagedBean
@ApplicationScoped
public class PizzaService extends DataAccess implements AutoCloseable {
    
    private static List<Bestellposten> pizzaAngebot;
    
    private final String OUTCOME_SUCCESS_ORDER = "success_order";
    private final String OUTCOME_FAILED_ORDER = "failed_order";

    public PizzaService(){ 
            
        pizzaAngebot = getPizzaAngebot(); 
    
    }

  
    @Override
    public void close() throws Exception {
        System.out.println("PizzaExpress: Applikation closes.");
    }
    
    public List<Bestellposten> getPizzaAngebot() {
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;
        List<Bestellposten> tempPizzaBox = new ArrayList<>();
        
        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM pizza ORDER BY sorte ASC");
            
            while (rs.next()) {
                Bestellposten coldPizza = new Bestellposten();
                coldPizza.setSorte(rs.getString("sorte"));
                coldPizza.setPreis(rs.getString("preis"));
                coldPizza.setImage(rs.getString("image"));
                tempPizzaBox.add(coldPizza);
            }

        } catch (SQLException ex) {
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}            
           
        }
        return tempPizzaBox;
    }
   
    public String getCurrentDateTimeString(){
        
        LocalDateTime myDateTime = LocalDateTime.now();
        //LocalDate myDate = LocalDate.now();
        //LocalTime myTime = LocalTime.now();
        //Locale myLocale = new Locale("de","DE");
        //DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern(pattern, Locale.GERMANY);
       
        System.out.println("PizzaService - getCurrentDateTimeString:" + myDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        return myDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
    
    
    // ????
    public double getPizzaPreis (String sorte){
        
        for (Bestellposten myPizza : this.pizzaAngebot){
            
            if(myPizza.getSorte().equals(sorte)){
                return myPizza.getPreisDouble();
            }
        }
        return 0;
    }
    
    public String checkBestellung() {
        
        System.out.println("PizzaService -- checkBestellung() start...");
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        Bestellung myBestellung = new Bestellung();
        PizzaService myService  = (PizzaService) session.getAttribute("pizzaService");        
        myBestellung.setPizzaBestellung(myService.getPizzaAngebot());
        
        session.setAttribute("bestellung", myBestellung);
        

        
        
        return OUTCOME_SUCCESS_ORDER;
    }
    
    public String doBestellung() {
        
        System.out.println("PizzaService -- checkBestellung() start...");
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        
        return OUTCOME_SUCCESS_ORDER;
    }
}
