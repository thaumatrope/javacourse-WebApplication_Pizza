<%-- 
    Document   : zweite
    Created on : 22.04.2015, 10:33:25
    Author     : Schulung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="myBean" scope="session" class="com.daa.ctrl.MyBean" />
<jsp:useBean id="person" scope="request" class="com.daa.model.Kunde" />
<jsp:setProperty name="person" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% myBean.setMyKunde(person);
        //Cookie myCookie=new Cookie("MeineTrackingCookie", "Wert");
       
       // response.addCookie(myCookie);
        // myCookie.setMaxAge(0);
         //myBean.setName(request.getParameter("name"));
         //myBean.setVorname(request.getParameter("vorname")); 
        out.print(myBean.getMyKunde().getKunde_nachname()+"<br/>");
        %>
        <a href="generate/myPdf.pdf" > zum pdf dokument</a> <br/>
       
    </body>
</html>
