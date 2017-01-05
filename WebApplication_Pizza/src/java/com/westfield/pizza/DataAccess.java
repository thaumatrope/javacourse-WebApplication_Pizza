/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author John Westfield
 */
public class DataAccess {   
    
    public Connection getConnectionPool() {
        try {            
            Context ctx=new InitialContext();
            
            //Get a connection
            DataSource ds = (DataSource) ctx.lookup("jdbc/pizzaWorld");//
           
            Connection conn=ds.getConnection();
            conn.setAutoCommit(false);
           
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
       
        } catch (NamingException ex) { 
        
        }

        return null;
    }
    
    public Connection getConnectionString() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //Get a connection            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaWorld?zeroDateTimeBehavior=convertToNull", "root", "root");
            
            
            conn.setAutoCommit(false);
            //Connection  conn = ds.getConnection();
            return conn;

        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();       
        }
//            catch (NamingException ex) {
//            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (ClassNotFoundException ex) {
//            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (InstantiationException ex) {
//            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (NamingException ex) {
//            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
}
