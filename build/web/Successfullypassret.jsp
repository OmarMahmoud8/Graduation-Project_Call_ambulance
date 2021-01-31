<%-- 
    Document   : Successfullypassret
    Created on : Dec 20, 2015, 6:38:38 PM
    Author     : Kareem
--%>

<%@page import="javax.faces.context.FacesContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Retrieved Successfully</title>
    </head>
    <body>
       
    </body>
</html>
<%
                   FacesContext context = FacesContext.getCurrentInstance();
                   //HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                   HttpSession httpSession = request.getSession(false);
                   String x = (String) session.getAttribute("pass");
                    out.println("<center><font color='blue' size='6'>Welcome ,Your Password is : "+x+" <br/> Login If You Want</font></center>");
                    
response.setHeader("Refresh", "5;url=index.xhtml");

%>