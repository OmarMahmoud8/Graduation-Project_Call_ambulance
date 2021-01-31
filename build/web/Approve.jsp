<%-- 
    Document   : Updatedata
    Created on : Dec 17, 2015, 6:46:38 AM
    Author     : GIG
--%>

<%@page import="AnotherPackage.User"%>
<%@page import="java.sql.*"%>
<%@page import="DbConnection.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href=""></a>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Message</title>
        <link rel='stylesheet' href='Styles.css' type='text/css' />  
        <script src="sample-registration-form-validation.js"></script>  
    </head>
    <body onload="document.registration.email.focus();">
        <%
            User x = new User();
            String x1 = "";
            HttpSession sessionx = request.getSession();
            String y = request.getParameter("mail");
            sessionx.setAttribute("id", request.getParameter("rid"));
            DbConnection C = new DbConnection();
            x = C.GetDataforS("", y);
            x1 = x.getmail();
        %>
        
        <%
        String ID = request.getParameter("rid");
        String Mail = request.getParameter("mail");  
        %>
        
       
        
           <div style="width:90%;
	height:70%;
 background-image: url(logo2.png);
 background-size: 100%;
 opacity:0.8;
 margin-left: 0px">
        
        
        <div id="body">
            <div class="content" style="margin-left: 0px;">

                <button style="color: darkblue;font-size: 20px;margin-top: 30px" >
                    Send Message
                </button>
               
                <form action="ApproveMail" name='registration' onSubmit="return formValidation();">

                    <label for="email"><span> To : </span>
                        <input type="text" name="email" size="75" value="<%=Mail%>" required style="height: 30px;"/>
                    </label> 

                    <label for="subject"><span> Subject : </span>
                        <input type="text" name="subject" value="" required style="height: 30px;"/>
                    </label>
                    
                     <label for="message"><span> Message : </span>
                     
                      <textarea name="message" rows="6" cols="75>"> </textarea>
                    </label>

                    <input type="submit" name="submit" value="Send" class="sign"/> 

                </form> 
                    <br/> <br/>
                <a href="Admin.jsp" class="link"> BACK </a>
            </div> </div>
           </div>
    </body>
</html>
