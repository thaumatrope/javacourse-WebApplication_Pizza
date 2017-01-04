<%-- 
    Document   : order.jsp
    Created on : 29.12.2016, 13:02:58
    Author     : User704
--%>
<%@page import="com.westfield.pizza.Bestellung"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.Bestellung" scope="page"></jsp:useBean> 
<jsp:setProperty property="*" name="myBestellung"/>
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
        <th style="width: 80px"> 

        </th> 
    </tr>  
    <% 
        ArrayList<Bestellung> orders = myLieferung.getMyBestellungen();
        orders.add(myBestellung);
        int i = 1;
        double gesamtpreis = 0;
        for(Bestellung temp : orders){
            temp.setPosition(i++);
            gesamtpreis += Double.parseDouble(temp.getPreis());
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
                <%= pizzaService.printPreisFormatted(gesamtpreis)%>
            </th>           
             <td style="width: 150px; text-align: right">
                <button id="delete" onclick="delete_item()" />Löschen</button>
            </td>
        </tr>      
    <%       
        }    
    %>
</table>