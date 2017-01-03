<%-- 
    Document   : index
    Created on : 29.12.2016, 12:16:08
    Author     : User704
--%>

<%@page import="com.westfield.pizza.Pizza"%>
<%@page import="com.westfield.pizza.PizzaService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="pizzaService" class="com.westfield.pizza.PizzaService" scope="application"></jsp:useBean> 


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
            
            function toNumberString(num) { 
                if (Number.isInteger(num)) { 
                  return num + ".00"
                } else {
                  return num.toString(); 
                }
            }
                     
            function change(){
                
                var menge = parseInt(document.getElementById("select_menge").value);
                var selection = document.getElementById("select_sorte").value;
                  
                if (selection == "<%= pizzaService.getPizzaName()[0] %>") {
                    document.getElementById("einzelpreis").innerHTML = "<%= pizzaService.getPizzaPreise()[0] %>".replace(',','.');
                    var temp = "<%= pizzaService.getPizzaPreise()[0] %>".replace(',','.');
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();           

                } else if (selection == "<%= pizzaService.getPizzaName()[1] %>") {
                    document.getElementById("einzelpreis").innerHTML  = "<%= pizzaService.getPizzaPreise()[1] %>".replace(',','.');
                    var temp = "<%= pizzaService.getPizzaPreise()[1] %>".replace(',','.');
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();

                } else if (selection == "<%= pizzaService.getPizzaName()[2] %>") {
                    document.getElementById("einzelpreis").innerHTML = "<%= pizzaService.getPizzaPreise()[2] %>".replace(',','.');
                    var temp = "<%= pizzaService.getPizzaPreise()[2] %>".replace(',','.');
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();

                } else if (selection == "<%= pizzaService.getPizzaName()[3] %>") {
                    document.getElementById("einzelpreis").innerHTML = "<%= pizzaService.getPizzaPreise()[3] %>".replace(',','.'); 
                    var temp = "<%= pizzaService.getPizzaPreise()[3] %>".replace(',','.');
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();

                } else if (selection == "<%= pizzaService.getPizzaName()[4] %>") {
                    document.getElementById("einzelpreis").innerHTML = "<%= pizzaService.getPizzaPreise()[4] %>".replace(',','.'); 
                    var temp = "<%= pizzaService.getPizzaPreise()[4] %>".replace(',','.');
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();

                }
                
                 
                 
            }       
            
            function add_item(){
            
            
            
            }

            function send(){  
                var xhr = new XMLHttpRequest();
                xhr.open("POST", '/order_update.jsp', true);

                //Send the proper header information along with the request
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                xhr.onreadystatechange = function() {//Call a function when the state changes.
                    if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
                        // Request finished. Do processing here.
                    }
                }
                xhr.send(""); 
            }
            
            
        </script>
    </head>
    <body>
        <h1>Hello Pizza World!</h1>
        <div>
         
            <fieldset style="width:850px;">
                <legend>Bitte ausfüllen:</legend><br>
                
                
                <form action="bestellung" method="post">                  
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
                            <td style="">
                                <button id="add" value="Hinzufügen" onclick="add_item()" />

                            </td>
                            
                            
                           
                            
                        </tr>
                        
                        
                    </table> 
                    <br><hr><br>        
                    <div>
                        
                        
                        
                        
                        
                    </div>
                    <br><hr><br>                  
                    
                    <table border="0" style="table-layout:fixed">                        
                        <tr>
                            <td style="width:80px;"><input type="submit" value="Abschicken"></td>
                            <td style="width:150px;"></td>
                            <td style="width:80px;"></td>
                            <td style="width:150px;"></td>
                        </tr>
                   
                    </table> 
                    
                </form> 
            </fieldset>
        </div>
    </body>
</html>
