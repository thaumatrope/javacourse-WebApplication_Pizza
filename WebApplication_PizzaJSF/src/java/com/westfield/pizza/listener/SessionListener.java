/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author John Westfield
 */
@WebListener
public class SessionListener implements HttpSessionListener{
    
    /**
    * Enthält die aktiven Sessions <Session ID, Session>
    */
    private static Map<String, HttpSession> activeSessions =new HashMap<String, HttpSession>();

    public  List<HttpSession> getActiveSessions() {
        
        List<HttpSession> tmpSessions;
        
        if(activeSessions.isEmpty()){
            
            tmpSessions = new ArrayList<>(); 
        } else {
        
            tmpSessions = new ArrayList<>(activeSessions.values());
       
        }        
        return tmpSessions;
    }

    public static void setActiveSessions(Map<String, HttpSession> activeSessions) {
        SessionListener.activeSessions = activeSessions;
    } 
    

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        // Ermitteln der Session ID       
        String sessionId = event.getSession().getId();

        // Debug-Ausgabe auf der Kommandozeile
        System.out.println("Session: " + sessionId + " erzeugt.");

        // Speichern der Session in den aktiven Sessions
        activeSessions.put(sessionId, event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

         // Ermitteln der Session ID
        String sessionId = event.getSession().getId();

        // Debug-Ausgabe auf der Kommandozeile
        System.out.println("Session: " + sessionId + " verfallen.");

        // Entfernen der Session aus den aktiven Sessions
        activeSessions.remove(sessionId);
   }

  
   
}
