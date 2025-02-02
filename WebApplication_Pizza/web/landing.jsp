<%-- 
    Document   : index
    Created on : 29.12.2016, 12:16:08
    Author     : User704
--%>
<%@page import="com.westfield.pizza.beans.Lieferung"%>
<%@page import="com.westfield.pizza.beans.Pizza" %>
<%@page import="com.westfield.pizza.controller.PizzaService" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="pizzaService" class="com.westfield.pizza.controller.PizzaService" scope="application"></jsp:useBean>
<%
    try
    {             
        if(!request.getSession(true).isNew()){            
            session.invalidate();                   
        }
    } catch (IllegalStateException ex){
        out.println("Shitty");
    }
    session.setMaxInactiveInterval(900);
    Lieferung myLieferung = new Lieferung();
    myLieferung.setIp(request.getRemoteAddr());
    System.out.println("landing.jsp - myLieferung.getIP(): " +  myLieferung.getIp());
    myLieferung.setSessionid(request.getSession(true).getId()); 
    System.out.println("landing.jsp - myLieferung.getSessionid(): " + myLieferung.getSessionid());
    request.getSession().setAttribute("myLieferung", myLieferung);
      
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Pizza World</title>
        <style type="text/css">
          
           table { border-collapse: separate;
                   border-spacing: 30px 2px;
           }
           
           th {font: bold 15px arial, sans-serif;
               margin: 10px 5px 10px 5px;
               text-align: left
           }           

        </style>
        <script>
            window.onload = function (){
               change();
            };
            
                               
            function change(){
                
                var menge = parseInt(document.getElementById("select_menge").value);
                var selection = document.getElementById("select_sorte").value;
                 
                if(false){}                              
              
                <% for(Pizza einePizza: pizzaService.getPizzaAngebot()){ %>

                    else if (selection == "<%= einePizza.getName()%>"){
                        document.getElementById("einzelpreis").innerHTML  = "<%= einePizza.getPreis() %>";
                        var temp = "<%= einePizza.getPreis() %>";
                        document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();
                    }

                <% } %>
 
            }     
            
            function delete_item(pos){
            
                var query = 'mode=delete' +
                        '&pos='+pos;  
                send(query);
            }
            
             function add_item(){
            
                var query = 'mode=add' +
                        '&menge='+document.getElementById("select_menge").value +
                        '&sorte='+document.getElementById("select_sorte").value +
                        '&preis='+document.getElementById("gesamtpreis").innerHTML;                
                send(query);
            }

            function send(query){              
                
                var xmlhttp = new XMLHttpRequest();    
                xmlhttp.open("POST", 'landing_update.jsp', true);
                  
                //Send the proper header information along with the request
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.setRequestHeader("Content-length", query.length);
                xmlhttp.setRequestHeader("Connection", "close");                
             
                xmlhttp.onreadystatechange = function() {//Call a function when the state changes.
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        //var text = xmlhttp.responseText; 
                        //alert(text);
                        document.getElementById("bestellungen").innerHTML = xmlhttp.responseText;
                    }
                }                
                xmlhttp.send(query); 
            }
            
        </script>
    </head>
    <body>
        <%-- <h1>Hello Pizza World!<%= //" - SessionID: " + currentSessionID ;%></h1> --%>
        <h1>Hello Pizza World!</h1>
        <div>
         
            <fieldset style="width:850px;">
                <legend>Bitte ausfüllen:</legend><br>                                
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
                        <tr>
                            <td> <input style="width: 50px; text-align: right" type="number" min="1" max="10" value="1" id="select_menge" onchange="change()"> </td>
                            <td> <select id="select_sorte" name="pizza" onchange="change();">                               
                            <%      
                                List<Pizza> sorten = pizzaService.getPizzaAngebot();
                                for(Pizza myPizza : sorten){
                                    out.print("<option value=\"" + myPizza.getName() + "\">"+ myPizza.getName() + "</option>");
                                
                                }
                            %>  
                                     
                            </select>
                            </td>
                            <td id="einzelpreis">

                            </td>
                            <td id="gesamtpreis">

                            </td>
                            <td style="width: 80px">
                                <button id="add" onclick="add_item()" />Hinzufügen</button>

                            </td>  
                            
                        </tr>
                        
                    </table> 
                    <br><hr><br>        
                    <div id="bestellungen">
                     
                        
                        
                        
                    </div>
                    <br><hr><br>                  
                    <form action="kunden.jsp" method="post"> 
                        <table border="0">                        
                            <tr>
                                <td style="width:80px;"><input type="submit" value="Bestellung überprüfen"></td>
                                <td style="width:350px;"></td>                                
                            </tr>
                        </table>                     
                    </form> 
            </fieldset>
        </div>
    </body>
</html>
