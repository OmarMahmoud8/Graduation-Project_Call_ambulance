<%-- 
    Document   : logout
    Created on : Dec 20, 2015, 6:41:08 PM
    Author     : GIG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
  <% 
    HttpSession s = request.getSession(false);
    s.invalidate();
   %>
 

    <center> <h3>You are now logged out. </h3> </center>
 
</body>


</html>
<%
response.setHeader("Refresh", "2;url=index.xhtml");
%>