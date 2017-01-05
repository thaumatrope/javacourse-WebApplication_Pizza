<%-- 
    Document   : order_update
    Created on : Jan 5, 2017, 2:42:20 PM
    Author     : John Westfield
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.Bestellung" scope="page"></jsp:useBean>
<jsp:useBean id="myKunde" class="com.westfield.pizza.Kunde" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="myKunde"/>
<%
   System.out.println("order_update.jsp reached!");
   if(myKunde.checkKundennummer()){ 
    
        myKunde = myKunde.snatch(myKunde.getKundennummer());
       
 %>
    <fieldset style="width:780px;">
        <legend>Bereits Kunde:</legend><br>
        <table border="0" style="table-layout:fixed">
            <tr>
                <td style="width:80px;">Kundennummer:</td>
                <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="<%= myKunde.getKundennummer()%>" /></td>
                <td style="width:200px;"><button onclick="check_kdnr();" />Kundennummer prüfen</button></td>
                <td style="width:150px;"><span class="bold-green" id="feedback_kdnr">Kundennummer gefunden!</span></td>

            </tr> 
        </table> 

    </fieldset>                    

    <br><hr><br>                 

    <form action="bestellung" method="post">                

         <fieldset style="width:780px;">
            <legend>Neukunde:</legend><br>
            <div id="feedback" class="bold-red">

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

%>
<fieldset style="width:780px;">
    <legend>Bereits Kunde:</legend><br>
    <table border="0" style="table-layout:fixed">
        <tr>
            <td style="width:80px;">Kundennummer:</td>
            <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="<%= myKunde.getKundennummer()%>" /></td>
            <td style="width:200px;"><button onclick="check_kdnr();" />Kundennummer prüfen</button></td>
            <td style="width:150px;"><span class="bold-red" id="feedback_kdnr">Kundennummer nicht gefunden!</span></td>

        </tr> 
    </table> 

    </fieldset>                    

    <br><hr><br>                 

    <form action="bestellung" method="post">                

         <fieldset style="width:780px;">
            <legend>Neukunde:</legend><br>
            <div id="feedback" class="bold-red">
<%
    List<String> fieldsmissing = new ArrayList();
    String message = "";    
    if (myKunde.getVorname().isEmpty()){
        fieldsmissing.add("Vorname");
    }
    if (myKunde.getNachname().isEmpty()){
        fieldsmissing.add("Nachname");
    }
    if (myKunde.getStrasse().isEmpty()){
        fieldsmissing.add("Strasse");
    }
    if (myKunde.getOrt().isEmpty()){
        fieldsmissing.add("Ort");
    }
    if (myKunde.getPlz().isEmpty()){
        fieldsmissing.add("PLZ");
    }
    for(String temp: fieldsmissing){
        if(fieldsmissing.indexOf(temp) < (fieldsmissing.size() - 1)){
            message += temp + " ,";
        }else{
            message += temp + " fehlt."; 
        }
    
    }
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
%> 
       
   }  

%>
