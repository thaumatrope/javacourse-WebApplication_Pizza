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
        <title>JSP Page</title>
        <style type="text/css">
          
           table { border-collapse: separate;
                   border-spacing: 30px 2px;
           }

        </style>
    </head>
    <body>
        <h1>Hello Pizza World!</h1>
        <div>
            <jsp:scriptlet>
                
            </jsp:scriptlet>
            <fieldset style="width:850px;">
                <legend>Bitte ausfüllen:</legend><br>
                
                <form action="bestellung" method="post">                
                   
                     <fieldset style="width:680px;">
                        <legend>Neukunde:</legend><br>
                        
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:80px;">Vorname:</td>
                                <td style="width:150px;"><input name="vorname" type="text" value="" /></td>
                                <td style="width:80px;">Nachname:</td>
                                <td style="width:150px;"><input name="nachname" type="text" value="" /></td>
                                <td style="width:80px;"></td>
                                <td style="width:80px;"></td>

                            </tr>
                            <tr>
                                <td style="width:80px;">Strasse:</td>
                                <td style="width:150px;"><input name="strasse" type="text" value="" /></td>
                                <td style="width:80px;">Stadt:</td>                           
                                <td style="width:150px;"><input name="stadt" type="text" value="" /></td>
                                <td style="width:80px;">PLZ</td>
                                <td style="width:80px;"><input style="width:80px;" name="plz" type="text" value="" /></td>
                            </tr>                     

                        </table> 
                        
                        </fieldset>
                    
                    <br><hr><br>
                    
                    <fieldset style="width:680px;">
                        <legend>Bereits Kunde:</legend><br>
                        <table border="0" style="table-layout:fixed">
                            <tr>
                                <td style="width:80px;">Kundennummer:</td>
                                <td style="width:150px;"><input name="kundennummer" type="text" value="" /></td>
                            </tr> 
                        </table> 
                        
                    </fieldset>                    
                    
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
