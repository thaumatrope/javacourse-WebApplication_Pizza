<%-- 
    Document   : list_bestellungen
    Created on : Jan 6, 2017, 12:20:32 AM
    Author     : John Westfield
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.westfield.pizza.Bestellung"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.Bestellung" scope="page"></jsp:useBean> 
<table> 
    <tr>
        <th>
            Position
        </th>
        <th>
            Anzahl
        </th>  
        <th>
            Sorte
        </th> 
         <th>
            Postenpreis
        </th>
        <th>
            Gesamtpreis
        </th>  
       
    </tr>  
    <% 
        List<Bestellung> orders = myLieferung.getMyBestellungen();       
        for(Bestellung temp : orders){
            temp.setPosition(orders.indexOf(temp) + 1);            
    %>        
    <tr> 
        <td>
            <%= temp.getPosition()%>
        </td>  
        <td>
            <%= temp.getMenge()%>
        </td> 
         <td style="width: 250px">
            <%= temp.getSorte()%>
        </td>
        <td>
            <%= temp.getPreis()%>
        </td>  
        <th style="width: 80px"> 
            <%= pizzaService.printPreisFormatted(myLieferung.getGesamtsumme(temp.getPosition()))%>
        </th>           

    </tr> 
    <%           
        }    
    %>
</table>