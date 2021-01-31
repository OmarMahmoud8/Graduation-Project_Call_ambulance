<%-- 
    Document   : Patient
    Created on : Dec 15, 2015, 2:23:16 PM
    Author     : GIG
--%>


<%@page import="javax.faces.context.FacesContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Page</title>
     <link rel='stylesheet' href='Styles.css' type='text/css' />
        
    </head>
    <body>
        <div id="body">
            <div class="content">
                <div style="margin-left: 200px; margin-top: -20px;">
                    <button style="color: darkblue;">
                        Patient Panel
                    </button>
                </div>
                <%
                    FacesContext context = FacesContext.getCurrentInstance();
                    //HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                    HttpSession httpSession = request.getSession(false);
                    String x = (String) session.getAttribute("fname");
                    out.println(" <center><font color='green' size='5'>Welcome  " + x + "</font></center><br/>");
                %>
                <div style="margin-right:-500px;">
         <form action="../ShowMyRequest" method="post">
             <input type="submit" value="Show My Requests" class="sign"/>
        </form>
                </div>
                <div style="margin-left: 300px; margin-top:-85px;">
                    <form action="AddComment.jsp" method="post">
                        <input type="submit" value="Add Comment" class="sign"/>
                    </form>
                </div>
                
         
      <div style="margin-left:150px;margin-top: 80px;">          
                    <form action="logout.jsp" method="post">
                        <input type="submit" value="Logout" class="sign" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
