<%-- 
    Document   : Registered
    Created on : Dec 15, 2015, 6:36:57 PM
    Author     : GIG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Registration</title>
        
    </head>
    <body>
        
    </body>
</html>
<%
   out.println("<center> <font color='red' size='5'>Registered Successfully </font> </center>");
   response.setHeader("Refresh", "4;url=index.xhtml");
%>
