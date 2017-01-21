/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.ctrl;

import com.ibb.model.Person;
import com.ibb.model.SportArt;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Schulung
 */
@ManagedBean
@SessionScoped
public class MyBean implements Serializable {
    //Property, Membervariable, Attribut immer privat

    private List<SportArt> myList;
    private List<SportArt> myAuswahl;
    private Person kunde;
    private String ipAddress;
    private String sessId;
    private String imgPath;
    private Locale language;
    private String direction;

    /**
     * Das ist der Konstruktor der meine Order Objekt initialisiert
     */
    public MyBean() {
        language=new Locale("de");
        myList = new ArrayList();
        myAuswahl = new ArrayList();
        myList.add(new SportArt(1, "Tennis", "0"));
        myList.add(new SportArt(2, "Fußball", "0"));
        myList.add(new SportArt(3, "Kickboxen", "0"));
        myList.add(new SportArt(4, "Schach", "0"));
        myList.add(new SportArt(5, "Billiard", "0"));
        myList.add(new SportArt(6, "Basketball", "0"));
        myList.add(new SportArt(7, "Handball", "0"));

    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public String getDirection() {
        Locale l=FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if(l.getLanguage().equals("fa")||l.getLanguage().equals("hb")||l.getLanguage().equals("ar")){
            direction="rtl";
        }
        else{
            direction="ltr";
        }
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

   

    
    
    
    public Person getKunde() {
        return kunde;
    }

    public void setKunde(Person kunde) {
        this.kunde = kunde;
    }

    public List<SportArt> getMyList() {
        return myList;
    }

    public void setMyList(List<SportArt> myList) {
        this.myList = myList;
    }

    public List<SportArt> getMyAuswahl() {
        return myAuswahl;
    }

    public void setMyAuswahl(List<SportArt> myAuswahl) {
        this.myAuswahl = myAuswahl;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSessId() {
        return sessId;
    }

    //**************************** Meine Methoden
    public void addElement() {
        for (SportArt s : myList) {
            if (!s.getBewertung().equals("0")) {
                myAuswahl.add(s);
               
            }
        }
    }

    ;
    
    public void ipdAndSession(HttpServletRequest req) {
        ipAddress = req.getRemoteAddr();
        HttpSession sess = req.getSession();
        sessId = sess.getId();
        System.out.println("SessionId:::::::" + sessId);

    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public void respSenden(HttpServletResponse resp, String url) {
        try {
            resp.sendRedirect(url);
        } catch (IOException ex) {
            Logger.getLogger(MyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void switchLang(String l){
        language=new Locale(l);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(language);
        System.out.println("AusSystemgabe sprache:::::"+l + " " + language.getLanguage());    
    }

}
