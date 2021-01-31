<%-- 
    Document   : UnSuccessfullyFP
    Created on : Dec 20, 2015, 6:41:36 PM
    Author     : Kareem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No Found Password</title>
    </head>
    <body>
    <center> <h3>Invalid Mail Or Phone .. Go Back And Try Again !</h3>
    </body>
</html>

<%
response.setHeader("Refresh", "4;url=forgetpass.xhtml");
%>