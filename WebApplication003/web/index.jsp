<%-- 
    Document   : index
    Created on : Jan 2, 2017, 8:06:02 AM
    Author     : John Westfield
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        
    </header>
    <body style="text-align:center; color:green">
        Dies ist eine dynamische JSP.<br>
        Es ist jetzt genau: <%= new java.util.Date() %><br>
        
        ContextPath: <%= request.getContextPath()%><br>
        Local Address: <%= request.getLocalAddr()%><br>
    </body>
        
</html>