<%-- 
    Document   : index
    Created on : 09.01.2017, 13:02:27
    Author     : schulung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="www.meinefirma.de/taglib" prefix="meinLib"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <meinLib:myDate attribut="" />
        <!--String test ="Hallo World" 
        session.setAttribute("sessTest",test)
        -->
        <c:set var="test" value=" Hallo Welt sessionscope" scope="session" />
         <c:set var="test" value="Hallo Welt aus applicationscope" scope="application" />
        <c:out value="${test}" />
        <c:forEach begin="1" end="10" var="i" step="2">
            <br />
            ${sessionScope.test}  ${i}
        </c:forEach>
        
    </body>
</html>
