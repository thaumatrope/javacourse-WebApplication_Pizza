/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.beans;

import com.westfield.pizza.dao.DataAccess;
import java.io.Serializable;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author John Westfield
 */

public class Kunde extends DataAccess implements Serializable {
    
     /*** Validation ***/
    private List<String> errors = new LinkedList<String>();
    private boolean valid = false;
    
    private int kundennummer;
    private String email;
    private String password;
    private String vorname;
    private String nachname;
    private String ort;
    private String plz;
    private String strasse;
    
    private static final long serialVersionUID = 1L;
    
    public Kunde(){        
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }
       
    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String nummer){
        int kundennummer;
        try {
            kundennummer = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
            System.out.println("Kunde: NumberFormatException - keine Zahl aus 'String nummer': " + nummer);
            this.kundennummer = 0; 
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
        this.vorname = vorname.trim();
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname.trim();
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort.trim();
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz.trim();
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse.trim();
    }
    
    public int getNewKundennummer(){
        Set<Integer> kdnr = snatchKundennummern();
        int length = kdnr.size();
        int newkdnr = 0;
        Random rand = new Random();
        while (length == kdnr.size()){
            newkdnr = rand.nextInt(Integer.MAX_VALUE);
            kdnr.add(new Integer(newkdnr));              
        }
        return newkdnr;
        
    }
     
    public boolean checkEmail(String email){    
        Set<String> emailAdressen = snatchEmail();
        if(emailAdressen.contains(email)){
            
            if(this.kundennummer != 0){
                Kunde testKunde = this.fetchKunde(email);
                if (this.kundennummer == testKunde.getKundennummer()){
                    
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }        
    }
    
    public boolean checkEmail(){  
        
        return this.checkEmail(this.email);
       
    }
    
    public boolean checkKundennummer(int nummer){    
        Set kdnr = snatchKundennummern();
        if(kdnr.contains(new Integer(nummer))){
            return true;
        }else{
            return false;
        }        
    }
    
    public boolean checkKundennummer(){  
        
        return this.checkKundennummer(this.kundennummer);
       
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
   
    public Set<Integer> snatchKundennummern(){
        Connection con = null;
        Statement stm = null;
        Set<Integer> kdnr = new HashSet<>();
        ResultSet rs = null;

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT kundennummer FROM benutzer");
            
            while (rs.next()) {
                kdnr.add((Integer)rs.getInt("kundennummer"));                   
            }

        } catch (SQLException ex) {
            
        } finally {
            try { if (rs != null) { rs.close(); } } catch (Exception e) {}
            try { if (stm != null) { stm.close(); } } catch (Exception e) {}
            try { if (con != null) { con.close(); } } catch (Exception e) {}
        }
        return kdnr;
    }
    
    public Set<String> snatchEmail(){
        Connection con = null;
        Statement stm = null;
        Set<String> kdnemail = new HashSet<>();
        ResultSet rs = null;

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT email FROM benutzer");
            
            while (rs.next()) {
                kdnemail.add(rs.getString("email").trim());                   
            }

        } catch (SQLException ex) {
            
        } finally {
            try { if (rs != null) { rs.close(); } } catch (Exception e) {}
            try { if (stm != null) { stm.close(); } } catch (Exception e) {}
            try { if (con != null) { con.close(); } } catch (Exception e) {}
        }
        return kdnemail;
    }
    
    public boolean updatePassword(String pw) {
        
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        try {
            System.out.println("Kunde updatePassword() - start");
            con = this.getConnectionPool();
            if(con == null) {
                //System.out.println("Kunde update() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("UPDATE benutzer SET password = ? WHERE kundennummer = ?");
            stm.setString(1, this.sha256(pw.trim()));
            stm.setInt(2, this.getKundennummer());
            int rows = stm.executeUpdate();
            con.commit();
            stored = rows == 1;
        } catch (SQLException ex) { 
            System.out.println("Kunde updatePassword() - failed");
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        System.out.println("Kunde updatePassword() - success"); 
        return stored;
        
    }
    
    public boolean store(){
        
        if(this.getKundennummer() == 0){
            System.out.println("Kunde: insertKunde() choosen");
            this.setKundennummer(this.getNewKundennummer());        
            return this.insertKunde(); 
            
        } else {
            System.out.println("Kunde: updateKunde() choosen");
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
                //System.out.println("Kunde update() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("UPDATE benutzer SET email = ?, vorname = ?, nachname = ?, strasse = ?, ort = ?, plz = ? WHERE kundennummer = ?");
            stm.setString(1, this.getEmail());
            stm.setString(2, this.getVorname());
            stm.setString(3, this.getNachname());
            stm.setString(4, this.getStrasse());
            stm.setString(5, this.getOrt());
            stm.setString(6, this.getPlz());
            stm.setInt(7, this.getKundennummer());
            int rows = stm.executeUpdate();
            con.commit();
            stored = rows == 1;
        } catch (SQLException ex) { 
            System.out.println("Kunde update() - failed");
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        System.out.println("Kunde update() - success"); 
        return stored;
    }
          
    public boolean insertKunde(){
        Connection con = null;
        PreparedStatement stm = null;
        boolean stored = false;
        try {
            //System.out.println("Kunde store() - start");
            con = this.getConnectionPool();
            if(con == null) {
                //System.out.println("Kunde store() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("INSERT INTO benutzer (email, password, vorname, nachname, strasse, ort, plz, kundennummer) VALUES(?,?,?,?,?,?,?,?)");
           
            stm.setString(1, this.getEmail());
            stm.setString(2, this.sha256(this.getPassword()));
            stm.setString(3, this.getVorname());
            stm.setString(4, this.getNachname());
            stm.setString(5, this.getStrasse());
            stm.setString(6, this.getOrt());
            stm.setString(7, this.getPlz());
            stm.setInt(8, this.getKundennummer());
            int rows = stm.executeUpdate();
            con.commit();
            stored = rows == 1;
        } catch (SQLException ex) {          
            stored = false;
        } finally {
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}
        }
        
        try {
            //System.out.println("Kunde store() - start");
            con = this.getConnectionPool();
            if(con == null) {
                //System.out.println("Kunde store() - no Connection Pool");
                return false;
            }
            stm = con.prepareStatement("INSERT INTO gruppe (name, email) VALUES (?,?)");
           
            stm.setString(1, "user");
            stm.setString(2, this.getEmail());            
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
    
    
    
//    public Kunde snatchKunde (String nummer) {
//        
//        int kundennummer;
//        try {
//           kundennummer = Integer.parseInt(nummer);
//        } catch (NumberFormatException e) {
//              return new Kunde();
//        }
//        return this.snatchKunde(kundennummer); 
//    }
    
    public void snatchKunde (String email) {
        
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;  
        
        System.out.println("Kunde:snatch ("+ email + ")");
        
        try {
            
            con = getConnectionPool();
            
             if (con == null) {
               
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM benutzer WHERE email = '" + email + "'");
            
            while (rs.next()) {
                
                this.kundennummer = rs.getInt("kundennummer");
                this.vorname = rs.getString("vorname");
                this.nachname = rs.getString("nachname");
                this.ort = rs.getString("ort");
                this.plz = rs.getString("plz");
                this.strasse = rs.getString("strasse");
                this.email = rs.getString("email");
                this.password = rs.getString("password");     
            }

        } catch (SQLException ex) {
            ex.printStackTrace();       
            System.out.println("Kunde:snatch ("+ email + ") - ERROR");
          
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}  
               
        }
        
        System.out.println("Kunde:snatch ("+ this.email + ") + SUCCESS");
        
      
    }
    
    public Kunde fetchKunde (String email) {
        
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null; 
        Kunde newKunde = new Kunde();
        
        System.out.println("Kunde:fetch ("+ email + ")");
        
        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM benutzer WHERE email = '" + email + "'");
            
            while (rs.next()) {
                
                newKunde.setKundennummer(rs.getInt("kundennummer"));
                newKunde.setVorname(rs.getString("vorname"));
                newKunde.setNachname(rs.getString("nachname"));
                newKunde.setOrt(rs.getString("ort"));
                newKunde.setPlz(rs.getString("plz"));
                newKunde.setStrasse(rs.getString("strasse"));
                newKunde.setEmail(rs.getString("email"));
                newKunde.setPassword(rs.getString("password"));     
            }

        } catch (SQLException ex) {
            
            ex.printStackTrace();       
            System.out.println("Kunde:fetch ("+ newKunde.getEmail() + ") - ERROR");
            return this;
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}  
               
        }
        
        System.out.println("Kunde:fetch ("+ newKunde.getEmail() + ") + SUCCESS");
        
        return newKunde;
    }
    
    public Kunde snatchKunde (int kundennummer) {
        Connection con = null;
        Statement stm = null;        
        ResultSet rs = null;

        try {
            
            con = getConnectionPool();
            
             if (con == null) {
                return null;
            }
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM benutzer WHERE kundennummer = '" + kundennummer + "'");
            
            while (rs.next()) {
                
                this.kundennummer = rs.getInt("kundennummer");
                this.vorname = rs.getString("vorname");
                this.nachname = rs.getString("nachname");
                this.ort = rs.getString("ort");
                this.plz = rs.getString("plz");
                this.strasse = rs.getString("strasse");
                this.email = rs.getString("email");
                this.password = rs.getString("password");     
            }

        } catch (SQLException ex) {
            
        } finally {
            
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if( stm != null) stm.close(); } catch(Exception e) {}
            try { if( con != null) con.close(); } catch(Exception e) {}            
           
        }
        return this;
    }
      
    public String sha256(String base) {
        
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
            
        } catch(Exception ex){
           System.out.println("Kunde - sha256(String base) failed!");
           throw new RuntimeException(ex);
        }
    }
    
        
   
    
}
