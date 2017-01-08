<%-- 
    Document   : bestellung
    Created on : Jan 3, 2017, 8:35:36 AM
    Author     : John Westfield
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.westfield.pizza.PizzaService"%>
<%@page import="com.westfield.pizza.Lieferung"%>
<%@page import="com.westfield.pizza.Kunde"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myKunde" class="com.westfield.pizza.Kunde" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="myKunde"/>
<%   
    if(myKunde.getKundennummer() == 0){
        myKunde.setKundennummer(myKunde.getNewKundennummer());
        System.out.println("Neue Kundenummer gesetzt!");
    }

    if(myKunde.store()){
        System.out.println("Kunde gespeichert!");
    }else{
        System.out.println("Fehler: Kunde nicht gespeichert!");
    }    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css">
          
           table { border-collapse: separate;
                   border-spacing: 30px 2px;
           }
           
           .bold-red {
                color: red;
                font-weight: bold;
           }
           span {margin-left: 10px}
           
           .bold-green {
                color: greenyellow;
                font-weight: bold;
           }
        </style>
       
    </head>
    <body>
        <h1>Hello Pizza World!</h1>
        <div>
            
            <fieldset style="width:850px;">
                <legend>Ihre Bestellung:</legend><br>
                <div id="daten">
                    
                    <fieldset style="width:780px;">
                        <legend>Kundennummer:<span id="feedback_kdnr"></span></legend><br>
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:100px;">Kundennummer:</td>
                                <td style="width:200px;"><input id="kundennummer" name="kundennummer" type="text" value="<%= myKunde.getKundennummer()%>" readonly/></td>
                            </tr> 
                        </table> 

                    </fieldset>               

                    <br>

                    <fieldset style="width:780px;">
                        <legend>Lieferdaten:</legend>
                        <br>                     
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:80px;">Vorname:</td>
                                <td style="width:150px;"><input id="vorname" name="vorname" type="text" value="<%= myKunde.getVorname()%>" readonly/></td>
                                <td style="width:80px;">Nachname:</td>
                                <td style="width:150px;"><input id="nachname" name="nachname" type="text" value="<%= myKunde.getNachname()%>" readonly/></td>
                                <td style="width:80px;"></td>
                                <td style="width:80px;"></td>

                            </tr>
                            <tr>
                                <td style="width:80px;">Strasse:</td>
                                <td style="width:150px;"><input id="strasse" name="strasse" type="text" value="<%= myKunde.getStrasse()%>" readonly/></td>
                                <td style="width:80px;">Stadt:</td>                           
                                <td style="width:150px;"><input id="ort" name="ort" type="text" value="<%= myKunde.getOrt()%>" readonly/></td>
                                <td style="width:80px;">PLZ:</td>
                                <td style="width:80px;"><input id="plz" style="width:80px;" name="plz" type="text" value="<%= myKunde.getPlz()%>" readonly/></td>
                            </tr>                     

                        </table>                      
                    </fieldset>

                    <br><hr><br> 
        
                    <div id="lieferung">
                        
                    <jsp:include page="order_lieferung.jsp" />            

                    </div>

                    <br><hr><br>  

                    <table border="0" style="table-layout:fixed">                        
                        <tr>
                            <td style="width:80px;">
                                <form action="bestellung.jsp" method="post">                      
                                    <input type="submit" value="Bestellung abschliessen" name="button">
                                </form>
                            </td>
                            <td style="width:400px;"></td>
                            <td style="width:80px;">
                                <form action="landing.jsp" method="post">                      
                                    <input type="submit" value="Bestellung löschen" name="button">
                                </form>
                            </td>    
                        </tr>
                    </table>                     
            </fieldset>
            </div>
        </div>
    </body>
</html>
