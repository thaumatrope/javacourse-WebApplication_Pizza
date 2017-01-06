package com.westfield.pizza;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PizzaService extends DataAccess implements AutoCloseable {
    
    private Set<Integer> kundennummern;
    private static List<Pizza> pizzaAngebot;

    public PizzaService(){
            
        pizzaAngebot = getPizzaAngebot(); 
    
    }

  
    @Override
    public void close() throws Exception {
        System.out.println("PizzaExpress: Applikation closes.");
    }
    
        
    public String printPreisFormatted(double preis) {
        
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.'); 
        NumberFormat formatter = new DecimalFormat(".00", otherSymbols);
        
        //NumberFormat formatter = new DecimalFormat();        
        return formatter.format(preis);
  
    }  
    
   
    public List<Pizza> getPizzaAngebot() {
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;
        List<Pizza> tempPizzaBox = new ArrayList();
        
        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM pizza ORDER BY sorte ASC");
            
            while (rs.next()) {
                Pizza coldPizza = new Pizza(rs.getString("sorte"), rs.getString("preis"));
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
    
    public double getPizzaPreis (String name){
        
        for (Pizza myPizza : this.pizzaAngebot){
            
            if(myPizza.getName().equals(name)){
                return myPizza.getPreisDouble();
            }
        }
        return 0;
    }
}
