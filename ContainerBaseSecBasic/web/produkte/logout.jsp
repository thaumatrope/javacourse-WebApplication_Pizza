<%-- 
    Document   : logout
    Created on : 11.01.2017, 12:04:27
    Author     : schulung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          ///session.invalidate();
          request.logout();
         
          response.sendRedirect("../index.jsp");
        %>    
    </body>
</html>
