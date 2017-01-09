<%-- 
    Document   : deletesession
    Created on : 24.04.2015, 10:35:13
    Author     : Schulung
--%>

<%@page import="listeners.ActiveSessionsListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        HttpSession delSession=ActiveSessionsListener.getActiveSessions().get(session.getId());
         // session.invalidate();
        //  response.sendRedirect("index.jsp");
         %>   
    </body>
</html>
