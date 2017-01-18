/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.dao.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jwest
 */
@ManagedBean
@SessionScoped
public class Bestellung extends DataAccess {
    
    private int menge;
    private String preis;
    private int position;
    private String sorte;
    private int bestellnummer;

    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getPreis() {
        return preis;
    }
    
     public double getPreisDouble() {  
         
        double tmp;
        try {
            tmp = Double.parseDouble(this.preis);
            //System.out.println("Bestellung - getPreisDouble double: " + Double.parseDouble(this.preis));
        } catch (NumberFormatException e) {
            // System.out.println("Bestellung-getPreisDouble: NumberFormatException");
            return 0.0;
        }         
        return tmp;        
        
    }

    public void setPreis(String preis) {        
        this.preis = preis;
        //System.out.println("Bestellung: preis gesetzt - " + this.preis);
    }   

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
        //System.out.println("Bestellung: sorte gesetzt - " + this.sorte);
    }   

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
        //System.out.println("Bestellung: menge gesetzt - " + this.menge);
    }

     public boolean store(){        
        return this.insertBestellung();          
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
            stm = con.prepareStatement("INSERT INTO bestellung (bestellnummer, menge, position, preis, sorte) VALUES(?,?,?,?,?)");
            stm.setInt(1, this.getBestellnummer());
            stm.setInt(2, this.getMenge());
            stm.setInt(3, this.getPosition());
            stm.setString(4, this.getPreis()); 
            stm.setString(5, this.getSorte()); 
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
     
      public List<Bestellung> snatch(int nummer) { 
    
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;
        
        List<Bestellung> tempList = new ArrayList<>();

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM Lieferung WHERE bestellnummer = " + nummer + " ORDER BY position ASC'");
            
            while (rs.next()) { 
                Bestellung tempBest = new Bestellung();
                tempBest.bestellnummer = rs.getInt("bestellnummer"); 
                tempBest.menge = rs.getInt("menge");                
                tempBest.position = rs.getInt("position");
                tempBest.preis = rs.getString("preis");
                tempBest.preis = rs.getString("sorte");   
                tempList.add(tempBest);
            }
            
            return tempList;
            
        } catch (SQLException ex) {
            
            return null;
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}           
           
        }
        
    }
     
   
}
