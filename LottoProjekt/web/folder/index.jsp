<%-- 
    Document   : index
    Created on : 03.04.2013, 10:47:11
    Author     : Schulung_IBB
--%>

<%@page import="myPackage.LottoKlasse"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
            
        <%            //Collections.sort();
            for (int i = 1; i <= 12; i++) {
                
                out.print("<tr>");
                LottoKlasse myKlasse = new LottoKlasse();

                //Set<Integer> myTempSet = myKlasse.getMySet();
                //Iterator myIt = myTempSet.iterator();
                for(Integer j: myKlasse.getMySet()) {
                    out.print("<td>"+ j + "</td>");
                }
                out.print("</tr>");
            }
        %> 
        </table>
        <a href="zweite.jsp">zur Zweiten Seite</a>
    </body>
</html>
