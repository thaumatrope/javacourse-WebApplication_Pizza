/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.http.HttpSession;

/**
 * doPost
 * web.xml
 * @author Schulung
 */
public class MyHttpSession {
    private HttpSession mySession;
    private String userAgent;

    public HttpSession getMySession() {
        return mySession;
    }

    public void setMySession(HttpSession mySession) {
        this.mySession = mySession;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    
    
}
