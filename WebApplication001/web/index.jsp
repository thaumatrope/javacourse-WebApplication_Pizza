<%-- 
    Document   : index
    Created on : Dec 27, 2016, 2:03:14 PM
    Author     : John Westfield
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hallo Lotto-World!</h1>
        
            <%
                Random rand = new Random();
                HashMap<Integer, Boolean> lotto = new HashMap(); 

                for (int i = 1; i < 50; i++){
                    lotto.put(i, true);
                }
                
                String output = "";
                int tmp, i = 6;
                while (i > 0){
                   tmp = rand.nextInt(49) + 1;
                   if(lotto.get(tmp)){
                       lotto.replace(tmp, false);
                       output += tmp + "  ";
                       i--;
                   }  
                       
                }
                out.print(output + " sind die Zahlen heute.<br>");
    
                %>
                <p><%= output %> <br> </p>
                  
        
    </body>
</html>
