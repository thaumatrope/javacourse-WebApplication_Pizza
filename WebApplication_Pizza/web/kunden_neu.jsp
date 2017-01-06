<%-- 
    Document   : kunde_neu
    Created on : Jan 6, 2017, 12:48:23 PM
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
           
           .bold-red {
                color: red;
                font-weight: bold;
           }
           span {margin-left: 10px}
           
           .bold-green {
                color: greenyellow;
                font-weight: bold;
           }
        </style>
        <script>
            function check_daten(){
                
                var temp;
                
                temp = document.getElementById("vorname").value;
                if(!temp.match(/\S/)){
                    alert(document.getElementById("vorname").name + " Feld ist leer!");
                    return;
                }
                temp = document.getElementById("nachname").value;
                if(!temp.match(/\S/)){
                    alert(document.getElementById("nachname").name + " Feld ist leer!");
                    return;
                }
                temp = document.getElementById("strasse").value;
                if(!temp.match(/\S/)){
                    alert(document.getElementById("strasse").name + " Feld ist leer!");
                    return;
                }
                temp = document.getElementById("ort").value;
                if(!temp.match(/\S/)){
                    alert(document.getElementById("ort").name + " Feld ist leer!");
                    return;
                }
                temp = document.getElementById("plz").value;
                if(!temp.match(/\S/)){
                    alert(document.getElementById("plz").name + " Feld ist leer!");
                    return;
                }
                
                document.getElementById("order").submit();        
                
            }     
            
            
        </script>
    </head>
    <body>
        <h1>Hello Pizza World!</h1>
        <div>
            
            <fieldset style="width:850px;">
                <legend>Bitte ausfüllen:</legend><br>
                <div id="daten">  

                    <form action="order.jsp" method="post" id="order">                

                         <fieldset style="width:780px;">
                            <legend>Kundendaten:<span class="bold-red" id="feedback_daten"></span></legend>
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
                    </form>
                    
                    <br><hr><br>  

                    <table border="0" style="table-layout:fixed">                        
                        <tr>
                            <td style="width:400px;"><button onclick="check_daten()">&gt;&gt;&gt; Bestätigung der Bestellung</button></td>
                            <td style="width:200px;"></td>

                        </tr>
                    </table>   
                                
            </fieldset>
            </div>
        </div>
    </body>
</html>

