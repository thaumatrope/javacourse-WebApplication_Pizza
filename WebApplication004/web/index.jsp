<%--
    ocument   : index
    Created on : 10.01.2017, 12:16:36
    Author     : User704
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@include file="org.apache.derby.jdbc.EmbeddedDriver" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>JSTL-SQL - Example</title>
   </head>
   <body>
      
      <sql:setDataSource driver="org.apache.derby.jdbc.EmbeddedDriver" 
                         url="jdbc:derby://localhost:1527/sample"
                         user="app" 
                         password="" 
                         var="APP" 
                         scope="request" />
      
      <sql:query dataSource="${exampleDS}" 
                 var="javax_servlet_jsp_jstl_sql_Result" 
                 maxRows="10" 
                 startRow="0"
                 sql="SELECT * FROM customer WHERE ID > ?">
         <sql:param value="1" />
      </sql:query>
      
      <table cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
         <tr>            
            <c:forEach items="${javax_servlet_jsp_jstl_sql_Result.columnNames}" var="column">
               <th style="border: 1px solid #000000; padding: 5px;">${column}</th>
            </c:forEach>
         </tr>
         <c:forEach items="${javax_servlet_jsp_jstl_sql_Result.rows}" var="currRow">
            <tr>
               <c:forEach items="${javax_servlet_jsp_jstl_sql_Result.columnNames}" var="column">
                  <td style="border: 1px solid #000000; padding: 5px;">${currRow[column]}</td>
               </c:forEach>
            </tr>
         </c:forEach>
      </table>
      
   </body>
</html>