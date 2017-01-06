<%-- 
    Document   : index
    Created on : 28.08.2013, 09:32:32
    Author     : Schulung_IBB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:useBean id="myBean" scope="session" class="com.daa.ctrl.MyBean" />
 <!-- Erfolg = Talent * Arbeit -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="img/Tulips.jpg">
        <h1>Hello World!</h1>
        <form action="zweite.jsp">
            <table>
                <tr><td>Vorname:</td><td><input type="text" name="kunde_vorname" value="" /></td></tr>
                <tr><td>Name:<td><input type="text" name="kunde_nachname" value="" /></td></tr>
            </table>
            <input type="submit" value="OK" />
        </form>
        <img href="data:image/" + request.getContextPath()+"/servlet/bilderservlet.jpg">
    </body>
</html>
