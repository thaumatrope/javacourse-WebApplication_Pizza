<%-- 
    Document   : order.jsp
    Created on : 29.12.2016, 13:02:58
    Author     : User704
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.westfield.pizza.beans.Bestellung"%>
<%@page import="com.westfield.pizza.beans.Lieferung"%>

<%@page import="java.util.ArrayList"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.beans.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.beans.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.beans.Bestellung" scope="page"></jsp:useBean> 
<jsp:setProperty property="*" name="myBestellung"/>
<%
    
    System.out.println("landing_update.jsp - session.getId(): " + session.getId());
    System.out.println("landing_update.jsp - request.getSession().getId(): " + request.getSession().getId());
    System.out.println("landing_update.jsp - myLieferung.getIP(): " +  myLieferung.getIp());
    System.out.println("landing_update.jsp - myLieferung.getSessionid(): " + myLieferung.getSessionid());

%>
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
        
        String mode = request.getParameter("mode");
        System.out.println("order_update: mode - " + mode);
        if(mode.equals("delete")){
            System.out.println("order_update: Delete Mode - Position: " + Integer.parseInt(request.getParameter("pos")));
            myLieferung.deletePosition(Integer.parseInt(request.getParameter("pos")));
        }else{     
            System.out.println("order_update: add Mode");
            myLieferung.addPosition(myBestellung);            
        }
        
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
                <%= myLieferung.printPreisFormatted(myLieferung.getGesamtsumme(temp.getPosition()))%>
            </th>           
             <td style="width: 150px; text-align: right">
                <button id="delete" onclick="delete_item(<%= temp.getPosition()%>)" />Löschen</button>
            </td>
        </tr>      
    <%           
        }    
    %>
</table>