<%-- 
    Document   : kunden
    Created on : Jan 6, 2017, 12:38:55 PM
    Author     : John Westfield
--%>

<%-- 
    Document   : bestellung
    Created on : Jan 3, 2017, 8:35:36 AM
    Author     : John Westfield
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="myLieferung" class="com.westfield.pizza.Lieferung" scope="session"></jsp:useBean>
<%
    System.out.println("landing.jsp - session.getId(): " + session.getId());
    System.out.println("landing.jsp - request.getSession().getId(): " + request.getSession().getId());
    System.out.println("landing.jsp - myLieferung.getIP(): " +  myLieferung.getIp());
    System.out.println("landing.jsp - myLieferung.getSessionid(): " + myLieferung.getSessionid());
%>
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
                font: 15px arial, sans-serif;
           }
           span {margin-left: 10px}
           
           .bold-green {
                color: greenyellow;
                font-weight: bold;
                font: 15px arial, sans-serif;
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
            
            function check_kdnr(){
                
                if (Number(document.getElementById("kundennummer").value) > 0) {
                    document.getElementById("feedback_kdnr").innerHTML = "";
                    var query = 'kundennummer='+document.getElementById("kundennummer").value;                              
                    send(query);
                }else{
                    document.getElementById("feedback_kdnr").innerHTML = "Bitte gültige Nummer eingeben!";
                }                
            }
            
            function send(query){              
                
                var xmlhttp = new XMLHttpRequest();    
                xmlhttp.open("POST", 'kunden_update.jsp', true);
                  
                //Send the proper header information along with the request
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.setRequestHeader("Content-length", query.length);
                xmlhttp.setRequestHeader("Connection", "close");                
             
                xmlhttp.onreadystatechange = function() {//Call a function when the state changes.
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        //var text = xmlhttp.responseText; 
                        //alert(text);
                        document.getElementById("kundendaten").innerHTML = xmlhttp.responseText;
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
                    
                    <fieldset style="width:780px;">
                        <legend>Bereits Kunde:<span id="feedback_kdnr"></span></legend><br>
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:80px;">Kundennummer:</td>
                                <td style="width:150px;"><input id="kundennummer" name="kundennummer" type="text" value="" /></td>
                                <td style="width:200px;"><button onclick="check_kdnr()" />Kundennummer prüfen</button></td>

                            </tr> 
                        </table> 

                    </fieldset> 
                    <br>
                    
                    <div id="kundendaten">
                        
                        <fieldset style="width:780px;">     
                            <table border="0" style="table-layout:fixed">
                                <tr>
                                    <td style="width:400px;" class="bold-red">&nbsp;</td>
                                </tr>
                            </table> 
                        </fieldset>
                        
                        <br><hr><br>                                    

                        <form action="kunden_neu.jsp" method="post">
                            <table border="0" style="table-layout:fixed">                        
                                <tr>
                                    <td style="width:80px;"><input type="submit" value="Neuer Kunde" name="button"></td>
                                    <td style="width:400px;"></td>

                                </tr>
                            </table> 
                        </form>
                        
                    </div> 
            </fieldset>
            </div>
        </div>
    </body>
</html>
