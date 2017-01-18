/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.controller;

import com.westfield.pizza.beans.Kunde;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author John Westfield
 */
@ManagedBean
@SessionScoped
public class PizzaLogin implements Serializable {
    
    private Kunde myKunde;
    private String myEmail;
    private String myPassword;
    
    private final String buttonLogin = "Login";
    private final String buttonLogout = "Logout";
    private final String buttonRegister = "Register";
    
    static final long serialVersionUID = 1L;
    
    
    public PizzaLogin(){
        
        myKunde = new Kunde();
        
    }

    public String getButtonLogin() {
        return buttonLogin;
    }

    public String getButtonRegister() {
        return buttonRegister;
    }
    
    public String getButtonLogout() {
        return buttonLogout;
    }

    public Kunde getMyKunde() {
        return myKunde;
    }

    public void setMyKunde(Kunde myKunde) {
        this.myKunde = myKunde;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {        
        this.myEmail = myEmail.trim();
        System.out.println("kunde: setMyEmail: " + this.myEmail);
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword.trim();
        System.out.println("kunde: setMyPassword: " + this.myPassword);
        
    }
    
    public boolean isLoggedIn(){        
        return false;
    }
   
    public void doRegister(){
        
    }    
    
    
    public String doLogin(){
        
        System.out.println("PizzaLogin -- doLogin() start...");
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();       
        
        try {
            
            request.login(this.getMyEmail(), this.getMyPassword());
            //request.authenticate
            //myKunde.snatch(this.getMyEmail());
            
            System.out.println("PizzaLogin -- doLogin() -> Logged In");
            
        } catch (ServletException ex) {
            //username oder Passwort falsch
            System.out.println("PizzaLogin -- doLogin() -> NOT Logged In -- username oder password falsch");
            Logger.getLogger(PizzaLogin.class.getName()).log(Level.SEVERE, null, ex);
            return "outcomeBadLogin";
        }
        
        return "outcomeGoodLogin";
    }  
    
    public String doLogout(){
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                
        try {
            request.logout(); 
            request.getSession().invalidate();         
            myKunde = null;
            
            System.out.println("PizzaLogin -- doLogout() -> Logged Out");
            
        } catch (ServletException ex) {
            //username oder Passwort falsch
            System.out.println("PizzaLogin -- doLogout() -> NOT Logged Out -- error");
            Logger.getLogger(PizzaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "outcomeLogout";
    }
}
