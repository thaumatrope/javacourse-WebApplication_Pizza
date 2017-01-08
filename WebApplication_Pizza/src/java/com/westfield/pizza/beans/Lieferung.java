/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

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

/**
 *
 * @author jwest
 */
public class Lieferung extends DataAccess {
    
    private List<Bestellung> myBestellungen;
    private int kundennummer;
    private int bestellnummer;
    private String datum;
    private String ip;
    private String sessionid;

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

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }
    

    public List<Bestellung> getMyBestellungen() {
        return myBestellungen;
    }  

    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }    
    
    public Lieferung(){        
        myBestellungen = new ArrayList();
    }
    
    public double getGesamtsumme(int pos){  
        System.out.println("Lieferung - Gesamtsumme: positions" + pos);
        double summe = 0;
        for(Bestellung best : this.myBestellungen){            
            if(this.myBestellungen.indexOf(best) < pos){
                System.out.println("Lieferung - Gesamtsumme: check - best.getPosition() <= pos : " + this.myBestellungen.indexOf(best) + " <= " + pos);
                summe += best.getPreisDouble();
            }
        }
        System.out.println("Lieferung - Gesamtsumme: " + summe);
        return summe;
    }
    
    public void deletePosition(int pos) {        
        this.myBestellungen.remove(pos - 1);
    }
    
    public void addPosition(Bestellung bestell) { 
        
        this.myBestellungen.add(bestell);
    }
    
    
    public boolean store(){
        
        if(this.insertLieferung()){           
            
            if(snatchLast(this.getKundennummer())){ 
            
                for(Bestellung best : this.getMyBestellungen()){

                    best.setBestellnummer(this.getBestellnummer());

                    if(!best.store()){ 
                        System.out.println("Bestellung - store failed!");
                        return false;
                    }
                }
            
                return true;
            }
        } 
        
        return false;
                         
    }
    
     public boolean insertLieferung(){
         
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        
        try {
            //System.out.println("Lieferung insert() - start");
            con = this.getConnectionPool();
            if(con == null) {
                //System.out.println("Lieferung insert() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("INSERT INTO lieferung (kundennummer, datum, ip, sessionid) VALUES (?,?,?,?)");
            System.out.println("Lieferung insert() - getKundennummer: " + this.getKundennummer());
            stm.setInt(1, this.getKundennummer());
            System.out.println("Lieferung insert() - getDatum: " + this.getDatum());
            stm.setString(2, this.getDatum());  
            System.out.println("Lieferung insert() - getIp: " + this.getIp());
            stm.setString(3, this.getIp()); 
            System.out.println("Lieferung insert() - getSessionid: " + this.getSessionid());
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
        //System.out.println("Lieferung insert() - return: stored = " + stored);
        return stored;
    } 
     
    public boolean snatchLast(){  
        
        if(snatchLast(this.getKundennummer())){            
            this.myBestellungen = new Bestellung().snatch(this.getBestellnummer());
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
            rs = stm.executeQuery("SELECT * FROM lieferung WHERE kundennummer = " + nummer + " ORDER BY bestellnummer DESC LIMIT 1");
            
            while (rs.next()) {                
                this.kundennummer = rs.getInt("kundennummer");
                this.bestellnummer = rs.getInt("bestellnummer");
                this.datum = rs.getString("datum");
                this.ip = rs.getString("ip");
                this.sessionid = rs.getString("sessionid");  
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
    
    public String printPreisFormatted(double preis) {
        
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.'); 
        NumberFormat formatter = new DecimalFormat(".00", otherSymbols);
        
        //NumberFormat formatter = new DecimalFormat();        
        return formatter.format(preis);
  
    }  
    
    
}
