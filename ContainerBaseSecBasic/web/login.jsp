<%-- 
    Document   : login
    Created on : 11.01.2017, 11:58:54
    Author     : schulung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="loginBean" class="com.ibb.ctrl.LoginBean" />
<jsp:setProperty name="loginBean" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login mit der moderneren Art</h1><br />
        <form action="j_security_check" method="POST">
            Username:<input type="text" name="j_username"><br>
            Password:<input type="password" name="j_password">
            <input type="submit" value="Login">
        </form><br/>
        <h1>Login mit der moderneren Art</h1>
         <form  method="POST">
            Username:<input type="text" name="username"><br>
            Password:<input type="password" name="password">
            <input type="submit" value="Login">
        </form>
         <%
          if(!loginBean.getUsername().equals("")){ 
              loginBean.login(request);
          }  
             
             
             
         %>    
    </body>
</html>
