<%--
    Document   : order_update
    Created on : Jan 5, 2017, 2:42:20 PM
    Author     : John Westfield
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.westfield.pizza.PizzaService"%>
<%@page import="com.westfield.pizza.Lieferung"%>
<%@page import="com.westfield.pizza.Bestellung"%>
<%@page import="com.westfield.pizza.Kunde"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.Bestellung" scope="page"></jsp:useBean>
<jsp:useBean id="myKunde" class="com.westfield.pizza.Kunde" scope="session"></jsp:useBean>
<jsp:setProperty property="kundennummer" name="myKunde"/>
<%
   System.out.println("order_update.jsp reached!");
   //if(myKunde.checkKundennummer()){ 
   if(false){     
    
        myKunde = myKunde.snatch(myKunde.getKundennummer());
       
 %>
    <fieldset style="width:780px;">
        <legend>Bereits Kunde:<span class="bold-green" id="feedback_kdnr">Kundennummer gefunden!</span></legend>
        <br>
        <table border="0" style="table-layout:fixed">
            <tr>
                <td style="width:80px;">Kundennummer:</td>
                <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="<%= myKunde.getKundennummer()%>" /></td>
                <td style="width:200px;"><button onclick="check_kdnr();" />Kundennummer prüfen</button></td>
            </tr> 
        </table> 

    </fieldset>                    

    <br><hr><br>                 

    <form action="bestellung" method="post">                

         <fieldset style="width:780px;">
            <legend>Neukunde:<span class="bold-red" id="feedback_neukunde"></span></legend>
            <br>          
            <div id="neukunde_daten">
             <table border="0" style="table-layout:fixed">
                <tr>
                    <td style="width:80px;">Vorname:</td>
                    <td style="width:150px;"><input name="vorname" type="text" value="<%= myKunde.getVorname()%>" /></td>
                    <td style="width:80px;">Nachname:</td>
                    <td style="width:150px;"><input name="nachname" type="text" value="<%= myKunde.getNachname()%>" /></td>
                    <td style="width:80px;"></td>
                    <td style="width:80px;"></td>
                </tr>
                <tr>
                    <td style="width:80px;">Strasse:</td>
                    <td style="width:150px;"><input name="strasse" type="text" value="<%= myKunde.getStrasse()%>" /></td>
                    <td style="width:80px;">Ort:</td>                           
                    <td style="width:150px;"><input name="ort" type="text" value="<%= myKunde.getOrt()%>" /></td>
                    <td style="width:80px;">PLZ:</td>
                    <td style="width:80px;"><input style="width:80px;" name="plz" type="text" value="<%= myKunde.getPlz()%>" /></td>
                </tr>                     

            </table>  
            </div>
            </fieldset>

        <br><hr><br>        
        <div id="lieferung">
            
            <jsp:include page="order_bestellungen.jsp" />   
            
        </div>
        <br><hr><br> 
        
        <table border="0" style="table-layout:fixed">                        
            <tr>
                <td style="width:80px;"><input type="submit" value="Bestellung abschliessen" name="button"></td>
                <td style="width:400px;"></td>
                <td style="width:80px;"><input type="submit" value="Bestellung löschen" name="button"></td>
            </tr>

        </table> 

    </form>
</fieldset>
<%
        
   }else{
    System.out.println("order_update: negative kundennummer check!");
%>
<fieldset style="width:780px;">
    <legend>Bereits Kunde:<span class="bold-red" id="feedback_kdnr">Kundennummer nicht gefunden!</span></legend>
    <br>
    <table border="0" style="table-layout:fixed">
        <tr>
            <td style="width:80px;">Kundennummer:</td>
            <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="<%= myKunde.getKundennummer()%>" /></td>
            <td style="width:200px;"><button onclick="check_kdnr()" />Kundennummer prüfen</button></td>
        </tr> 
    </table> 
 </fieldset>                    

<br><hr><br>                 

<form action="bestellung.jsp" method="post">                

     <fieldset style="width:780px;">
        <legend>Neukunde:</legend>
        <br>
        <div id="feedback" class="bold-red">
<%
    List<String> fieldsmissing = new ArrayList();
    String message = "";    
    if ((myKunde.getVorname() == null) || myKunde.getVorname().isEmpty()){
        System.out.println("myKunde.getVorname().isEmpty()");
        fieldsmissing.add("Vorname");
    }
    if ((myKunde.getNachname() == null) || (myKunde.getNachname().isEmpty())){
        fieldsmissing.add("Nachname");
        System.out.println("myKunde.getNachname().isEmpty()");
    }
    if ((myKunde.getStrasse() == null) || (myKunde.getStrasse().isEmpty())){
        fieldsmissing.add("Strasse");
        System.out.println("myKunde.getStrasse().isEmpty()");
    }
    if ((myKunde.getOrt() == null) || (myKunde.getOrt().isEmpty())){
        fieldsmissing.add("Ort");
        System.out.println("myKunde.getOrt().isEmpty()");
    }
    if ((myKunde.getPlz() == null) || (myKunde.getPlz().isEmpty())){
        fieldsmissing.add("PLZ");
        System.out.println("myKunde.getPlz().isEmpty()");
    }
    for(String temp: fieldsmissing){        
        message += temp + " ,";          
    }
    
    message = message.trim();  
    message = message.substring(0,message.length() - 1); 
    if(fieldsmissing.size() > 1)
        message += "fehlen.";
    else
        message += "fehlt.";

   
    System.out.println("message is: " + message);
    out.print(message);
%>
            
            </div>
            <div id="neukunde_daten">
                <table border="0" style="table-layout:fixed">
                   <tr>
                       <td style="width:80px;">Vorname:</td>
                       <td style="width:150px;"><input name="vorname" type="text" value="<%= myKunde.getVorname()%>" /></td>
                       <td style="width:80px;">Nachname:</td>
                       <td style="width:150px;"><input name="nachname" type="text" value="<%= myKunde.getNachname()%>" /></td>
                       <td style="width:80px;"></td>
                       <td style="width:80px;"></td>
                   </tr>
                   <tr>
                       <td style="width:80px;">Strasse:</td>
                       <td style="width:150px;"><input name="strasse" type="text" value="<%= myKunde.getStrasse()%>" /></td>
                       <td style="width:80px;">Ort:</td>                           
                       <td style="width:150px;"><input name="ort" type="text" value="<%= myKunde.getOrt()%>" /></td>
                       <td style="width:80px;">PLZ:</td>
                       <td style="width:80px;"><input style="width:80px;" name="plz" type="text" value="<%= myKunde.getPlz()%>" /></td>
                   </tr>                     

               </table>  
            </div>
            </fieldset>

        <br><hr><br> 
        
        <div id="lieferung">
            
            <jsp:include page="order_bestellungen.jsp" />   
            
        </div>
        
        <br><hr><br> 
        
        <table border="0" style="table-layout:fixed">                        
            <tr>
                <td style="width:80px;"><input type="submit" value="Bestellung abschliessen" name="button"></td>
                <td style="width:400px;"></td>
                <td style="width:80px;"><input type="submit" value="Bestellung löschen" name="button"></td>
            </tr>

        </table> 

    </form>
</fieldset>                
<%      
   }  

%>