<%-- 
    Document   : myinclude
    Created on : 07.10.2014, 11:14:52
    Author     : Schulung
--%>

<%@page import="com.ibb.model.LottoKlasse"%>
<%@page import="java.util.Set"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            LottoKlasse myKlasse= new LottoKlasse();
            
            
            Set<Integer> myTempSet = myKlasse.getMySet();
            myKlasse=null;
        %>
    </body>
</html>
