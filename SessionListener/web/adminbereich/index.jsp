<%-- 
    Document   : index
    Created on : 01.10.2014, 11:53:31
    Author     : Schulung
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="listeners.ActiveSessionsListener"%>
<%@page import="java.util.Collection"%>
<jsp:useBean id="mySessionBean" scope="session" class="listeners.MyHttpSession" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Session Listener</h1>
        <%
           Map<String, HttpSession> mySessions = ActiveSessionsListener.getActiveSessions();
           //out.print(request.getHeader("user-Agent"));
            //Collection<HttpSession> mySessions=ActiveSessionsListener.getActiveSessions().values();
           out.println("<br/>anzahl:"+mySessions.size()+"<br/>");
         
            for (HttpSession tmp : mySessions.values()) {
                if (!session.getId().equals(tmp.getId())) {
                    
                    Date creationDate = new Date(tmp.getCreationTime());
                    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss") ;
                    Date inactive =new Date(tmp.getLastAccessedTime());
                    out.print("<h3>" + tmp.getId() + "--------" + df.format(creationDate) + "--------"+ inactive +"---</h3><br/>");
                }
            }


        %>
       <!-- <a href='deletesession.jsp'>Session löschen</a> --!>
    </body>
</html>
