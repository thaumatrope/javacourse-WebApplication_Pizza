<%-- 
    Document   : kunde_update
    Created on : Jan 6, 2017, 12:42:05 PM
    Author     : John Westfield
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.westfield.pizza.controller.PizzaService"%>
<%@page import="com.westfield.pizza.beans.Lieferung"%>
<%@page import="com.westfield.pizza.beans.Bestellung"%>
<%@page import="com.westfield.pizza.beans.Kunde"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.controller.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myKunde" class="com.westfield.pizza.beans.Kunde" scope="session"></jsp:useBean>
<%
   System.out.println("kunden_update.jsp reached!");
   if(myKunde.checkKundennummer(request.getParameter("kundennummer"))){ 
           
        myKunde = myKunde.snatch(request.getParameter("kundennummer"));
 
// <div id="kundendaten">     
%>
<form action="order.jsp" method="post" id="order">                

    <fieldset style="width:780px;">
       <legend>Kundendaten:<span class="bold-red" id="feedback_daten"></span></legend>
       <br>      
       <table border="0" style="table-layout:fixed">
           <tr>
               <td style="width:80px;">Vorname:</td>
               <td style="width:150px;"><input id="vorname" name="vorname" type="text" value="<%= myKunde.getVorname()%>" /></td>
               <td style="width:80px;">Nachname:</td>
               <td style="width:150px;"><input id="nachname" name="nachname" type="text" value="<%= myKunde.getNachname()%>" /></td>
               <td style="width:80px;"></td>
               <td style="width:80px;"></td>
           </tr>
           <tr>
               <td style="width:80px;">Strasse:</td>
               <td style="width:150px;"><input id="strasse" name="strasse" type="text" value="<%= myKunde.getStrasse()%>" /></td>
               <td style="width:80px;">Stadt:</td>                           
               <td style="width:150px;"><input id="ort" name="ort" type="text" value="<%= myKunde.getOrt()%>" /></td>
               <td style="width:80px;">PLZ:</td>
               <td style="width:80px;"><input id="plz" style="width:80px;" name="plz" type="text" value="<%= myKunde.getPlz()%>" /></td>
           </tr> 
       </table>      
    </fieldset> 
</form>
<br><hr><br>
<table border="0" style="table-layout:fixed">                        
    <tr>
        <td style="width:400px;"><button onclick="check_daten()">&gt;&gt;&gt; Bestätigung der Bestellung</button></td>
        <td style="width:200px;"></td>

    </tr>
</table>
<%
// </div>  
} else {
// <div id="kundendaten"> 
%>                        
<fieldset style="width:780px;">     
    <table border="0" style="table-layout:fixed">
        <tr>
            <td style="width:400px;" class="bold-red">Kundennummer nicht gefunden!</td>
        </tr>
    </table> 
</fieldset>
<br><hr><br>
<form action="kunden_neu.jsp" method="post">
    <table border="0" style="table-layout:fixed">                        
        <tr>
            <td style="width:80px;"><input type="submit" value="Neuer Kunde" name="button"></td>
            <td style="width:400px;"></td>

        </tr>
    </table> 
</form>
<%
// </div>  
}
%> 