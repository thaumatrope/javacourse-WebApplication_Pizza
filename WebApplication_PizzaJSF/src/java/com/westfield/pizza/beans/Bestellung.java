/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.controller.PizzaService;
import com.westfield.pizza.dao.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jwest
 */
@ManagedBean
@SessionScoped
public class Bestellung extends DataAccess {
    
    private List<Bestellposten> pizzaBestellung;
    
    private int bestellnummer;
    private int kundennummer;
    private String gesamtpreis;  
    private String datum;
    private String ip;
    private String sessionid;
    
    public Bestellung(){   
        
        //Sessionscope        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        this.datum = ((PizzaService)session.getAttribute("pizzaService")).getCurrentDateTimeString();        
        this.sessionid = session.getId();
        this.kundennummer = ((Kunde)session.getAttribute("kunde")).getKundennummer();
        this.ip = request.getRemoteAddr();      
   
        pizzaBestellung = new ArrayList<>();        
   
    }
    
    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int nummer) {
        this.kundennummer = nummer;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getBestellnummer() {
        return bestellnummer;
    }
    
    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }
    
    public List<Bestellposten> getPizzaBestellung() {
        return pizzaBestellung;
    }

    public void setPizzaBestellung(List<Bestellposten> pizzaBestellung) {
        this.pizzaBestellung = pizzaBestellung;
    }

    public double getGesamtpreisDouble() {  
         
        double tmp;
        try {
            tmp = Double.parseDouble(this.gesamtpreis);
            //System.out.println("Bestellung - getPreisDouble double: " + Double.parseDouble(this.preis));
        } catch (NumberFormatException e) {
            // System.out.println("Bestellung-getPreisDouble: NumberFormatException");
            return 0.0;
        }         
        return tmp;  
    }
    
    public double calculateGesamtpreis(){
        
        double gp = 0.0;
        for (Bestellposten cheapPizza : this.pizzaBestellung) {
            gp += cheapPizza.getPreisDouble();
        } 
        this.setGesamtpreis(this.printPreisFormatted(gp));
        return gp;
    }

    public String getGesamtpreis() {
        return gesamtpreis;
    }
            
    public void setGesamtpreis(String preis) {        
        this.gesamtpreis = preis;
        //System.out.println("Bestellung: preis gesetzt - " + this.preis);
    }
    
    public String printPreisFormatted(double preis) {
        
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.'); 
        NumberFormat formatter = new DecimalFormat(".00", otherSymbols);
        
        //NumberFormat formatter = new DecimalFormat();        
        return formatter.format(preis);
  
    }   
  
    public boolean store(){  
        
        boolean done = false;
        
        if (! this.insertBestellung()){            
            System.out.println("Bestellung insert() - failed");            
            
        } else {
            
            if(!this.fetchBestellnummer(this.getKundennummer())) {            
                System.out.println("Bestellung fetchkdn() - failed");
                
            } else {  
                
                if(!this.insertBestellposten()) {
                    System.out.println("Bestellposten insert() - failed");
                } else {                    
                    done = true;
                }
            } 
        }
        
        return done;
    }
    
    
     public boolean insertBestellposten(){
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        
        try {
            System.out.println("Bestellposten insert() - start");
            con = this.getConnectionPool();
            if(con == null) {
                System.out.println("Bestellposten insert() - no Connection Pool");
                return false;
            }
            
            int position = 0;
            for (Bestellposten hotPizza : this.pizzaBestellung) {
                position++;
                stm = con.prepareStatement("INSERT INTO bestellposten (lieferung_bestellnummer, position, sorte, menge, preis) VALUES(?,?,?,?,?)");
                stm.setInt(1, this.getBestellnummer());
                stm.setInt(2, hotPizza.getPosition());
                stm.setString(3, hotPizza.getSorte());
                stm.setString(4, hotPizza.getPreis());
                stm.setInt(5, hotPizza.getMenge()); 
                stm.addBatch();
            }
            
            int rows[] = stm.executeBatch();
            con.commit();
            
            int count = 0;
            for (int i : rows){
                count += i;                
            }
            
            System.out.println("Bestellposten insert() - count: " + count + ", position: " + position);
            
            if (count == position){
                stored = true;
            }
        } catch (SQLException ex) {          
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        return stored;
    }
    
    public boolean insertBestellung(){
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        try {
            System.out.println("Bestellung insert() - start");
            con = this.getConnectionPool();
            if(con == null) {
                System.out.println("Bestellung insert() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("INSERT INTO bestellung (kundennummer, gesamtpreis, datum, ip, sessionid) VALUES(?,?,?,?,?)");
            stm.setInt(1, this.getKundennummer());
            stm.setString(2, this.getGesamtpreis());
            stm.setString(3, this.getDatum());
            stm.setString(4, this.getIp());
            stm.setString(4, this.getSessionid());   
            
            int rows = stm.executeUpdate();
            con.commit();
            stored = rows == 1;
        } catch (SQLException ex) {          
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        return stored;
    }
     
      public List<Bestellposten> snatchPizzaBestellung(int nummer) { 
    
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;
        
        List<Bestellposten> tempBestellung = new ArrayList<>();

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM bestellposten WHERE bestellnummer = " + nummer + " ORDER BY position ASC'");
            
            while (rs.next()) { 
                Bestellposten tempBest = new Bestellposten();
                tempBest.setId(rs.getInt("id")); 
                tempBest.setBestellnummer(rs.getInt("lieferung_bestellnummer")); 
                tempBest.setPosition(rs.getInt("position"));
                tempBest.setSorte(rs.getString("sorte"));   
                tempBest.setPreis(rs.getString("preis"));
                tempBest.setMenge(rs.getInt("menge"));
                tempBestellung.add(tempBest);
            }
            
            return tempBestellung;
            
        } catch (SQLException ex) {
            
            return null;
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}           
           
        }
        
    }
      
    public boolean fetchBestellnummer(int kdnnummer) { 
    
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;

        try {            
            
            con = getConnectionPool();            
            if (con == null) {                
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT bestellnummer FROM bestellung WHERE kundennummer = " + kdnnummer + " ORDER BY bestellnummer DESC LIMIT 1");
            
            while (rs.next()) {                 
                this.bestellnummer = rs.getInt("bestellnummer");                
            }        
            
        } catch (SQLException ex) {            
            
            System.out.println("Bestellung fetchBestellnummer() - bestellnummer:  failed!");
            return false;
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}           
           
        }   
        
        return true;
        
    }  
      
    public double getPartialGesamtsumme(int pos){  
        System.out.println("Lieferung - Gesamtsumme: positions" + pos);
        double summe = 0;
        for(Bestellposten best : this.pizzaBestellung){            
            if(this.pizzaBestellung.indexOf(best) < pos){
                System.out.println("Lieferung - Gesamtsumme: check - best.getPosition() <= pos : " + this.pizzaBestellung.indexOf(best) + " <= " + pos);
                summe += best.getPreisDouble();
            }
        }
        System.out.println("Lieferung - Gesamtsumme: " + summe);
        return summe;
    }
    
    public void deletePosition(int pos) {        
        this.pizzaBestellung.remove(pos - 1);
    }
    
    public void addPosition(Bestellposten bestell) { 
        
        this.pizzaBestellung.add(bestell);
    }
    
      
    public boolean snatchLast(){  
        
        if(snatchLast(this.getKundennummer())){            
            this.pizzaBestellung = snatchPizzaBestellung(this.getBestellnummer());
            return true;
        } else {
           return false; 
        }
        
    }
     
    public boolean snatchLast(int nummer) { 
    
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;

        try {
            
            //System.out.println("Lieferung snatchLast() - return: entry");
            con = getConnectionPool();
            
             if (con == null) {
                return false;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM bestellung WHERE kundennummer = " + nummer + " ORDER BY bestellnummer DESC LIMIT 1");
            
            while (rs.next()) {                
                this.kundennummer = rs.getInt("kundennummer");
                this.bestellnummer = rs.getInt("bestellnummer");
                this.datum = rs.getString("datum");
                this.ip = rs.getString("ip");
                this.sessionid = rs.getString("sessionid"); 
                this.gesamtpreis = rs.getString("gesamtpreis");
            }
            
//            System.out.println("Lieferung snatchLast() - kundennummer: " + this.getKundennummer());
//            System.out.println("Lieferung snatchLast() - bestellnummer: " + this.getBestellnummer());
//            System.out.println("Lieferung snatchLast() - datum: " + this.getDatum());
//            System.out.println("Lieferung snatchLast() - ip: " + this.getIp());
//            System.out.println("Lieferung snatchLast() - sessionid: " + this.getSessionid());
              
            return true;
            
        } catch (SQLException ex) {
            
            return false;
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}           
           
        }
        
    }
    
     
     
   
}
