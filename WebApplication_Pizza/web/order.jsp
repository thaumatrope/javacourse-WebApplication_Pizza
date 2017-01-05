<%-- 
    Document   : bestellung
    Created on : Jan 3, 2017, 8:35:36 AM
    Author     : John Westfield
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css">
          
           table { border-collapse: separate;
                   border-spacing: 30px 2px;
           }
           
           div.bold-red {
                color: red;
                font-weight: bold;
           }
           
           div.bold-green {
                color: greenyellow;
                font-weight: bold;
           }
        </style>
        <script>
            
            function check_kdnr(){
                
                var query = 'kundennummer='+document.getElementById("kundennummer").value +
                            '&vorname='+document.getElementById("vorname").value +
                            '&nachname='+document.getElementById("nachname").value +
                            '&strasse='+document.getElementById("strasse").value +
                            '&ort='+document.getElementById("ort").value +
                            '&plz='+document.getElementById("plz").value;
                alert(query);
                send(query);
            }
            
            function send(query){              
                
                var xmlhttp = new XMLHttpRequest();    
                xmlhttp.open("POST", 'order_update.jsp', true);
                  
                //Send the proper header information along with the request
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.setRequestHeader("Content-length", query.length);
                xmlhttp.setRequestHeader("Connection", "close");                
             
                xmlhttp.onreadystatechange = function() {//Call a function when the state changes.
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var text = xmlhttp.responseText; 
                        alert(text);
                        document.getElementById("daten").innerHTML = xmlhttp.responseText;
                    }
                }                
                xmlhttp.send(query); 
            }
            
            
        </script>
    </head>
    <body>
        <h1>Hello Pizza World!</h1>
        <div>
            
            <fieldset style="width:850px;">
                <legend>Bitte ausfüllen:</legend><br>
                <div id="daten">
                    
                    <fieldset style="width:780px;">
                        <legend>Bereits Kunde:</legend><br>
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:80px;">Kundennummer:</td>
                                <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="" /></td>
                                <td style="width:200px;"><button onclick="check_kdnr()" />Kundennummer prüfen</button></td>
                                <td style="width:150px;"><span id="feedback_kdnr"></span></td>

                            </tr> 
                        </table> 

                    </fieldset>                    

                    <br><hr><br>                 

                    <form action="bestellung" method="post">                

                         <fieldset style="width:780px;">
                            <legend>Neukunde:</legend><br>
                            <div id="feedback" class="bold-red">

                            </div>
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



                        </div>

                        <br><hr><br> 
                                   

                        <table border="0" style="table-layout:fixed">                        
                            <tr>
                                <td style="width:80px;"><input type="submit" value="Bestellung abschliessen" name="button"></td>
                                <td style="width:400px;"></td>
                                <td style="width:80px;"><input type="submit" value="Bestellung löschen" name="button"></td>
                            </tr>

                        </table> 

                    </form>            
            </fieldset>
            </div>
        </div>
    </body>
</html>
