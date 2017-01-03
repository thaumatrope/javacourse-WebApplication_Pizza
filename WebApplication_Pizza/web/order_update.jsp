<%-- 
    Document   : order.jsp
    Created on : 29.12.2016, 13:02:58
    Author     : User704
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myBestellung" class="com.westfield.pizza.Bestellung" scope="request"></jsp:useBean> 
<jsp:setProperty property="*" name="myBestellung"/>
             
<table> 
    <tr>
        <th>
            Anzahl
        </th>  
        <th>
            Sorte
        </th> 
         <th>
            Einzelpreis
        </th>
        <th>
            Gesamtpreis
        </th>  
        <th style="width: 80px"> 

        </th>  

    </tr>
   
</table>