/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.controller.PizzaLogin;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

public class Bestellung extends DataAccess {
    
    private List<Bestellposten> pizzaAngebot;
    private List<Bestellposten> pizzaBestellung;
    
    private int bestellnummer;
    private int kundennummer;
    private String gesamtpreis;  
    private String datum;
    private String ip;
    private String sessionid;  
    
    private static final long serialVersionUID = 1L;
    
    public Bestellung(){   
        
        //Sessionscope        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        PizzaService myService = (PizzaService)session.getAttribute("pizzaService");
        
        System.out.println("Bestellung() - Constructor - this.datum() init");        
        this.datum = this.getCurrentDateTimeString();  
        
        System.out.println("Bestellung() - Constructor - this.sessionid() init");
        this.sessionid = session.getId();
        
        System.out.println("Bestellung() - Constructor - this.kundennummer() init");
        this.kundennummer = ((PizzaLogin)session.getAttribute("pizzaLogin")).getMyKunde().getKundennummer();
        
        System.out.println("Bestellung() - Constructor - this.ip() init");
        this.ip = request.getRemoteAddr();      
   
        pizzaAngebot = this.snatchPizzaAngebot(); 
        pizzaBestellung = new ArrayList<>();
        
        System.out.println("Bestellung() - Constructor - end");
   
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
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
    
    public List<Bestellposten> getPizzaAngebot() {
        return pizzaAngebot;
    }

    public void setPizzaAngebot(List<Bestellposten> pizzaAngebot) {
        this.pizzaAngebot = pizzaAngebot;
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

    public String getGesamtpreis() {
        return gesamtpreis;
    }
            
    public void setGesamtpreis(String preis) {        
        this.gesamtpreis = preis;
    }
    
      
    public boolean store(){  
        
        boolean done = false;
        
        this.calculateGesamtpreis();
        
        if (! this.insertBestellung()){            
            System.out.println("Bestellung store() - after insertBestellung() - failed");            
            
        } else {
            
            if(!this.fetchLastBestellnummer(this.getKundennummer())) {            
                System.out.println("Bestellung fetchLastBestellnummer() - failed");
                
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
            System.out.println("Bestellung: insertBestellung() - getKundennummer - " + this.getKundennummer());
            stm.setInt(1, this.getKundennummer());
            System.out.println("Bestellung: insertBestellung() - getGesamtpreis - " + this.getGesamtpreis());
            stm.setString(2, this.getGesamtpreis());
            System.out.println("Bestellung: insertBestellung() - getDatum - " + this.getDatum());
            stm.setString(3, this.getDatum());
            System.out.println("Bestellung: insertBestellung() - getIp - " + this.getIp());
            stm.setString(4, this.getIp());
            System.out.println("Bestellung: insertBestellung() - getSessionid - " + this.getSessionid());
            stm.setString(5, this.getSessionid());   
            
            int rows = stm.executeUpdate();
            con.commit();
            System.out.println("Bestellung: insertBestellung() - rows - " + rows);
            stored = rows == 1;
        } catch (SQLException ex) {  
            System.out.println("Bestellung insert() - failed");
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        return stored;
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
            stm = con.prepareStatement("INSERT INTO bestellposten (lieferung_bestellnummer, position, sorte, einzelpreis, menge) VALUES(?,?,?,?,?)");
            
            for (Bestellposten hotPizza : this.pizzaBestellung) {
                position++;
                
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
    
         
    // get Offer   
    public List<Bestellposten> snatchPizzaAngebot() {
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
    
    
    public boolean fetchLastBestellnummer(int kdnnummer) { 
    
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
    
    public boolean snatchLastBestellung(){  
        
        if(snatchLastBestellung(this.getKundennummer())){            
            this.pizzaAngebot = snatchPizzaBestellung(this.getBestellnummer());
            return true;
        } else {
           return false; 
        }
        
    }
     
    public boolean snatchLastBestellung(int nummer) { 
    
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
                tempBest.setPreis(rs.getString("einzelpreis"));
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
    
    // utility methods
    public String getCurrentDateTimeString(){
        
        LocalDateTime myDateTime = LocalDateTime.now();
        //LocalDate myDate = LocalDate.now();
        //LocalTime myTime = LocalTime.now();
        //Locale myLocale = new Locale("de","DE");
        //DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern(pattern, Locale.GERMANY);
       
        System.out.println("PizzaService - getCurrentDateTimeString:" + myDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        return myDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
     
    public double getPartialGesamtsumme(int pos){  
        System.out.println("Lieferung - Gesamtsumme: positions" + pos);
        double summe = 0;
        for(Bestellposten best : this.pizzaBestellung){            
            if((this.pizzaBestellung.indexOf(best) < pos)){
                System.out.println("Lieferung - Gesamtsumme: check - best.getPosition() <= pos : " + this.pizzaAngebot.indexOf(best) + " <= " + pos);
                summe += (best.getPreisDouble() * best.getMenge());
            }
        }
        System.out.println("Lieferung - Gesamtsumme: " + summe);
        return summe;
    }
    
    public String printPreisFormatted(double preis) {
        
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.'); 
        NumberFormat formatter = new DecimalFormat(".00", otherSymbols);
        
        //NumberFormat formatter = new DecimalFormat();        
        return formatter.format(preis);
  
    }   

    // calculate and set string gesamtpreis
    public void calculateGesamtpreis(){
        
        double gp = this.getPartialGesamtsumme(this.pizzaBestellung.size());
            
        this.setGesamtpreis(this.printPreisFormatted(gp));
        
    }
    
}