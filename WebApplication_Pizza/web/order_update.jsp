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
            <th>
                <%= temp.getPosition()%>
            </th>  
            <th>
                <%= temp.getMenge()%>
            </th> 
             <th style="width: 250px">
                <%= temp.getSorte()%>
            </th>
            <th>
                <%= temp.getPreis()%>
            </th>  
            <th style="width: 80px"> 
                <%= pizzaService.printPreisFormatted(gesamtpreis)%>
            </th> 
        </tr>      
    <%       
        }    
    %>
</table>