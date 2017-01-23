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
    
    private final String OUTCOME_SUCCESS_LOGIN = "success_login";
    private final String OUTCOME_FAILED_LOGIN = "failed_login";
    private final String OUTCOME_SUCCESS_LOGOUT = "success_logout";
    private final String OUTCOME_FAILED_LOGOUT = "failed_logout";
    private final String OUTCOME_REGISTER_ME = "forward_register";
    private final String OUTCOME_SUCCESS_REGISTER = "success_register";
    private final String OUTCOME_FAILED_REGISTER = "failed_register";

    static final long serialVersionUID = 1L;
    
    public PizzaLogin(){        
        myKunde = new Kunde();        
    }
     
    public String getOUTCOME_SUCCESS_REGISTER() {
        return OUTCOME_SUCCESS_REGISTER;
    }

    public String getOUTCOME_FAILED_REGISTER() {
        return OUTCOME_FAILED_REGISTER;
    }
     
    public String getOUTCOME_REGISTER_ME() {
        return OUTCOME_REGISTER_ME;
    }


    public String getOUTCOME_SUCCESS_LOGIN() {
        return OUTCOME_SUCCESS_LOGIN;
    }

    public String getOUTCOME_FAILED_LOGIN() {
        return OUTCOME_FAILED_LOGIN;
    }

    public String getOUTCOME_SUCCESS_LOGOUT() {
        return OUTCOME_SUCCESS_LOGOUT;
    }

    public String getOUTCOME_FAILED_LOGOUT() {
        return OUTCOME_FAILED_LOGOUT;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        System.out.println("PizzaLogin: setMyEmail: " + this.myEmail);
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword.trim();
        System.out.println("PizzaLogin: setMyPassword: " + this.myPassword);
        
    }    
       
    public boolean isLoggedInAsAdmin(){  
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        if(request.isUserInRole("adminRolle")){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLoggedInAsBenutzer(){
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        if(request.isUserInRole("kundenRolle")){
            return true;
        } else {
            return false;
        }
    }    
  
    public boolean isLoggedIn(){  
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        if(request.isUserInRole("adminRolle") || request.isUserInRole("kundenRolle")){
            return true;
        } else {
            return false;
        }
    }
   
    public String goRegister(){
        
        System.out.println("PizzaLogin -- goRegister() start...");
        
        return OUTCOME_REGISTER_ME;
        
    }  
    
    public String doRegister(){
        
        String outcome = null;
        
        System.out.println("PizzaLogin -- doRegister() start...");  
        
        this.setMyPassword(myKunde.getPassword());
        this.setMyEmail(myKunde.getEmail());
        
        if (!myKunde.store()){            
            System.out.println("PizzaLogin -- myKunde.store() not stored...");
            return OUTCOME_FAILED_REGISTER;
        }else {
            
            System.out.println("PizzaLogin -- myKunde.store() stored...");
        }        
        
        outcome = this.doLogin();
        
        if(outcome.equals(OUTCOME_FAILED_LOGIN)){           
            outcome = OUTCOME_FAILED_REGISTER;
        } else {            
            outcome = OUTCOME_SUCCESS_REGISTER;
        }         
        
        return outcome;
        
    }  
    
    public String doLogin(){
        
        System.out.println("PizzaLogin -- doLogin() start...");
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        if(request.getRemoteUser() != null){
            System.out.println("PizzaLogin -- doLogin() already logged in...");
            return OUTCOME_SUCCESS_LOGIN;
        }              
        
        try {
            
            request.login(this.getMyEmail(), this.getMyPassword());
            //request.authenticate ???
            this.myKunde.snatch(this.getMyEmail());

            
            System.out.println("PizzaLogin -- doLogin() -> Logged In");
            
        } catch (ServletException ex) {
            //username oder Passwort falsch
            System.out.println("PizzaLogin -- doLogin() -> NOT Logged In -- username oder password falsch");
            Logger.getLogger(PizzaLogin.class.getName()).log(Level.SEVERE, null, ex);
            return OUTCOME_FAILED_LOGIN;
        }
        
        return OUTCOME_SUCCESS_LOGIN;
    }  
    
    public String doLogout(){
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                
        try {
            request.logout(); 
            request.getSession().invalidate();         
            myKunde = null;
            
            //System.out.println(FacesContext.getCurrentInstance().getViewRoot().getViewId());
            
            System.out.println("PizzaLogin -- doLogout() -> Logged Out");
            
            
        } catch (ServletException ex) {
            //username oder Passwort falsch
            System.out.println("PizzaLogin -- doLogout() -> NOT Logged Out -- error");
            Logger.getLogger(PizzaLogin.class.getName()).log(Level.SEVERE, null, ex);
            return OUTCOME_FAILED_LOGOUT;
        }
        
        return OUTCOME_SUCCESS_LOGOUT;
        
    }
    
}
