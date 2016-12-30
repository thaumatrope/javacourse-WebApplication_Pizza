<%-- 
    Document   : index
    Created on : 29.12.2016, 12:16:08
    Author     : User704
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
            <fieldset style="width:700px;">
                 <legend>Bitte ausfüllen:</legend><br>
                
                <form action="bestellung" method="post">                
                   
                    <table border="0" style="table-layout:fixed">
                        <tr>
                            <td style="width:80px;">Name:</td>
                            <td style="width:150px;"><input name="nachname" type="text" value=""></td>
                            <td style="width:80px;">Strasse:</td>
                            <td style="width:150px;"><input name="strasse" type="text" value=""></td>
                        </tr>
                        <tr>
                            <td style="width:80px;">Vorname:</td>
                            <td style="width:150px;"><input name="vorname" type="text" value=""></td>
                            <td style="width:80px;">PLZ</td>
                            <td style="width:150px;"><input name="plz" type="text" value=""></td>
                        </tr>                     
                   
                    </table> 
                    
                    <br><hr><br>
                    
                    <select name="pizza">
                        <option>Pizza Tonno</option>
                        <option>Pizza Diavolo</option>
                        <option>Pizza Hawaii</option>
                        <option>Pizza Calzone</option>
                        <option>Pizza Quattro Stagioni</option>                        
                    </select>
                    
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
