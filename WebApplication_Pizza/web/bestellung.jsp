<%-- 
    Document   : bestellung
    Created on : Jan 5, 2017, 2:14:41 PM
    Author     : John Westfield
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
            
                               
            function change(){
                
                var menge = parseInt(document.getElementById("select_menge").value);
                var selection = document.getElementById("select_sorte").value;
                 
                if(false){                    
                }              
<%              
                for(Pizza einePizza: pizzaService.getPizzaAngebot()){
%>
                else if (selection == "<%= einePizza.getName()%>") {
                    document.getElementById("einzelpreis").innerHTML  = "<%= einePizza.getPreis() %>";
                    var temp = "<%= einePizza.getPreis() %>";
                    document.getElementById("gesamtpreis").innerHTML = (parseFloat(temp) * menge).toFixed(2).toString();
                }
<%
                }
%>
              
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
        <h1>Hello Pizza World!</h1>
        <div>
        
            <fieldset style="width:780px;">
               <legend>Neukunde:<span class="bold-red" id="feedback_neukunde"></span></legend>
               <br>
               <div id="neukunde_daten">
               <table border="0" style="table-layout:fixed">
                   <tr>
                       <td style="width:80px;">Vorname:</td>
                       <td style="width:150px;"><input id="vorname" name="vorname" type="text" value="" /></td>
                       <td style="width:80px;">Nachname:</td>
                       <td style="width:150px;"><input id="nachname" name="nachname" type="text" value="" /></td>
                       <td style="width:80px;"></td>
                       <td style="width:80px;"></td>

                   </tr>
                   <tr>
                       <td style="width:80px;">Strasse:</td>
                       <td style="width:150px;"><input id="strasse" name="strasse" type="text" value="" /></td>
                       <td style="width:80px;">Stadt:</td>                           
                       <td style="width:150px;"><input id="ort" name="ort" type="text" value="" /></td>
                       <td style="width:80px;">PLZ:</td>
                       <td style="width:80px;"><input id="plz" style="width:80px;" name="plz" type="text" value="" /></td>
                   </tr>                     

               </table> 
               </div>
               </fieldset>
            
            <br><hr><br> 

           <div id="lieferung">

           <jsp:include page="order_bestellungen.jsp" />            

           </div>
            
           <br><hr><br>
           
           <form action="bestellung.jsp" method="post">
           </form> 

           <table border="0" style="table-layout:fixed">                        
               <tr>
                   <td style="width:80px;"><input type="submit" value="Bestellung abschliessen" name="button"></td>
                   <td style="width:400px;"></td>
                   <td style="width:80px;"><input type="submit" value="Bestellung löschen" name="button"></td>
               </tr>

           </table> 

        
        </div>
    </body>
</html>