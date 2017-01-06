<%-- 
    Document   : bestellung
    Created on : Jan 5, 2017, 2:14:41 PM
    Author     : John Westfield
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="bestellung.jsp" method="post">  
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


   <table border="0" style="table-layout:fixed">                        
       <tr>
           <td style="width:80px;"><input type="submit" value="Bestellung abschliessen" name="button"></td>
           <td style="width:400px;"></td>
           <td style="width:80px;"><input type="submit" value="Bestellung löschen" name="button"></td>
       </tr>

   </table> 

</form>            