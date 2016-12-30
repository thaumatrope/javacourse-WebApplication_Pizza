<%-- 
    Document   : zweite.jsp
    Created on : 29.12.2016, 10:05:01
    Author     : User704
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= request.getParameter("firstname") %>
        <br>
        <%= request.getParameter("lastname") %>
        
    </body>
</html>
