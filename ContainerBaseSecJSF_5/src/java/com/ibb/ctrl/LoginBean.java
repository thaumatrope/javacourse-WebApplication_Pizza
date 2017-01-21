/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.ctrl;

import com.ibb.model.Person;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author schulung
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
  private Person myPerson;

    public LoginBean() {
        myPerson=new Person();
        
    }

    public Person getMyPerson() {
      
        return myPerson;
    }

    public void setMyPerson(Person myPerson) {
        this.myPerson = myPerson;
    }

    
    public void login(){
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=request.getSession();
        try {
            request.login(myPerson.getEmail(), myPerson.getPassword());
            //request.authenticate
        } catch (ServletException ex) {
            //username oder Passwort falsch
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean isLogedIn(){
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(request.isUserInRole("abteilungsleiter")){
            return true;
        }
        return false;
        
    }
    
    
    public String doSomething(){
        System.out.println("Eingegebenes Passwort::::::::" +myPerson.getPassword());
        //Anweisungen 
        myPerson=new Person();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Daten wurden entgegengenommen!", null));
       return "sprunkmarke2"; 
    }
}
