<%-- 
    Document   : bestellung
    Created on : Jan 5, 2017, 2:14:41 PM
    Author     : John Westfield
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.westfield.pizza.beans.Pizza"%>
<%@page import="com.westfield.pizza.beans.PizzaService"%>
<%@page import="java.util.List"%>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.beans.PizzaService" scope="application"></jsp:useBean>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.beans.Lieferung" scope="session"></jsp:useBean>
<jsp:useBean id="myKunde" class="com.westfield.pizza.beans.Kunde" scope="session"></jsp:useBean>
<%
    myLieferung.setKundennummer(myKunde.getKundennummer());
    myLieferung.setDatum(pizzaService.getCurrentDateTimeString());
    if(myLieferung.store()){
        System.out.println("bestellung.jsp: myLieferung - saved");
%>
        <jsp:forward page="/generate/do.pdf" />
<%
    } else{
        System.out.println("bestellung.jsp: myLieferung - NOT saved");
    }

%>