<%-- 
    Document   : index
    Created on : 29.12.2016, 12:16:08
    Author     : User704
--%>

<%@page import="com.westfield.pizza.Pizza"%>
<%@page import="com.westfield.pizza.PizzaService"%>
<%@page import="java.util.List"%>
<%@page import="org.json.JSONArray"%>
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
        <script type="text/javascript">
            
            $(document).ready(
               
                $('#selection').bind('change',
                    function(){
                        var selection = $('option:selected',this).text();
                        alert(selection);
                        
                        if (selection == "<%= pizzaService.getPizzaName()[0] %>") {
                            $('#einzelpreis').text("<%= pizzaService.getPizzaPreise()[0] %>");   

                        } else if (selection == "<%= pizzaService.getPizzaName()[1] %>") {
                            $('#einzelpreis').text("<%= pizzaService.getPizzaPreise()[1] %>");  
                          
                        }} else if (selection == "<%= pizzaService.getPizzaName()[2] %>") {
                            $('#einzelpreis').text("<%= pizzaService.getPizzaPreise()[2] %>");  
                          
                        }} else if (selection == "<%= pizzaService.getPizzaName()[3] %>") {
                            $('#einzelpreis').text("<%= pizzaService.getPizzaPreise()[3] %>");  
                          
                        }} else if (selection == "<%= pizzaService.getPizzaName()[4] %>") {
                            $('#einzelpreis').text("<%= pizzaService.getPizzaPreise()[4] %>");  
                          
                        }

                    }
                )

            );
            
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
                         </tr>
                        <tr>
                            <td> <input style="width: 50px; text-align: right" type="number" min="1" max="10" value="1"> </td>
                            <td> <select id="selection" name="pizza">                                  
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
                            
                           
                            
                        </tr>
                        
                        
                    </table> 
                    
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
