<%-- 
    Document   : validator
    Created on : Jan 12, 2017, 6:18:31 AM
    Author     : John Westfield
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<%-- Importieren der Java-Klasse 'List' zur Fehler-Ausgabe --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator"%>

<%-- Binden der JavaBean an den symbolischen Name 'form' --%>
<jsp:useBean id="form" class="de.akdabas.javaee.beans.FormBean" scope="session"/>

<%-- Übernehmen der HTTP-Parameter in die JavaBean --%>
<jsp:setProperty name="form" property="name" value="<%= request.getParameter("name") %>"/>

<jsp:setProperty name="form" property="email" value="<%= request.getParameter("email") %>"/>
<%
   // Aufruf der Geschäftslogik um die eingegebenen Daten zu prüfen
   form.validate();

   // Weiterleiten des Requestes, wenn Daten gültig sind
   if (form.isValid()) {
      response.sendRedirect("beanOutput.jsp");
   }
%>
<html>
   <body>

      <%-- Kodieren des URLs (Siehe 2.7.4) --%>
      <form action='<%= response.encodeURL("beanInput.jsp") %>'>
         Bitte füllen Sie das folgende Formular aus !

         <%-- ggf. Ausgabe von aufgetretenen Fehlern --%>
         <% if (! form.isValid()) {
               out.println("<ul>");
               Iterator i = form.getErrors().iterator();
               while (i.hasNext()) {
                 out.println("<li>"+i.next()+"</li>") ;
               }
               out.println("</ul>");
            } %>

         Name : <input type="text" name="name" /> <br/>
         eMail: <input type="text" name="email" /> <br/>

         <input type="reset" value="Reset" />
         <input type="submit" value="Absenden" />
      </form>
   </body>
</html>

