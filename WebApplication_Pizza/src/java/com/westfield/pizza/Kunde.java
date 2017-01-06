/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Westfield
 */
public class Kunde extends DataAccess {
    
    private int kundennummer;
    private String vorname;
    private String nachname;
    private String ort;
    private String plz;
    private String strasse;

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String nummer){
        int kundennummer;
        try {
           kundennummer = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
            System.out.println("Kunde: NumberFormatException - keine Zahl aus 'String nummer': " + nummer);
            return;
        }
        this.kundennummer = kundennummer;  
    }       
    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    
    public int getNewKundennummer(){
        Set kdnr = snatchKundennummern();
        int length = kdnr.size();
        int newkdnr = 0;
        Random rand = new Random();
        while (length == kdnr.size()){
            newkdnr = rand.nextInt(Integer.MAX_VALUE);
            kdnr.add(new Integer(newkdnr));              
        }
        return newkdnr;
        
    }
     
    public boolean checkKundennummer(int nummer){    
        Set kdnr = snatchKundennummern();
        if(kdnr.contains(new Integer(nummer))){
            return true;
        }else{
            return false;
        }        
    }
    
    public boolean checkKundennummer(String nummer){ 
        
        int kundennummer;
        try {
           kundennummer = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
              return false;
        }
        return this.checkKundennummer(kundennummer); 
    }
    
    public boolean checkKundennummer(){  
        
        return this.checkKundennummer(this.kundennummer);
       
    }
   
    public Set<Integer> snatchKundennummern(){
        Connection con = null;
        Statement stm = null;
        Set kdnr = new HashSet();
        ResultSet rs = null;

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT kundennummer FROM kunde");
            
            while (rs.next()) {
                kdnr.add((Integer)rs.getInt("kundennummer"));                   
            }

        } catch (SQLException ex) {
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                
            }
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception e) {
               
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
              
            }
        }
        return kdnr;
    }
    
    public boolean store(){
        
         if(this.checkKundennummer(this.getKundennummer())){ 
             return this.insertKunde();
         } else {
            return this.updateKunde();
         }
    }
    
     public boolean updateKunde(){
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        try {
            System.out.println("Kunde update() - start");
            con = this.getConnectionPool();
            if(con == null) {
                System.out.println("Kunde update() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("UPDATE kunde SET vorname = ?, nachname = ?, strasse = ?, ort = ?, plz = ? WHERE kundennummer = ?");
            stm.setString(1, this.getVorname());
            stm.setString(2, this.getNachname());
            stm.setString(3, this.getStrasse());
            stm.setString(4, this.getOrt());
            stm.setString(5, this.getPlz());
            stm.setInt(6, this.getKundennummer());
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
     
     
    public boolean insertKunde(){
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        try {
            System.out.println("Kunde store() - start");
            con = this.getConnectionPool();
            if(con == null) {
                System.out.println("Kunde store() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("INSERT INTO kunde (kundennummer, vorname, nachname, strasse, ort, plz) VALUES(?,?,?,?,?,?)");
            stm.setInt(1, this.getKundennummer());
            stm.setString(2, this.getVorname());
            stm.setString(3, this.getNachname());
            stm.setString(4, this.getStrasse());
            stm.setString(5, this.getOrt());
            stm.setString(6, this.getPlz());
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
    
    public Kunde snatch (String nummer) {
        
        int kundennummer;
        try {
           kundennummer = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
              return new Kunde();
        }
        return this.snatch(kundennummer); 
    }
    
    public Kunde snatch (int kundennummer) {
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM kunde WHERE kundennummer = '" + kundennummer + "'");
            
            while (rs.next()) {
                
                this.kundennummer = rs.getInt("kundennummer");
                this.vorname = rs.getString("vorname");
                this.nachname = rs.getString("nachname");
                this.ort = rs.getString("ort");
                this.plz = rs.getString("plz");
                this.strasse = rs.getString("strasse");
                                   
            }

        } catch (SQLException ex) {
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}            
           
        }
        return this;
    }
    
    
}
