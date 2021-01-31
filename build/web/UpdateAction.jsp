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
        <title>Update Data Form</title>
        <link rel='stylesheet' href='Styles.css' type='text/css' />  
        <script src="sample-registration-form-validation.js"></script>  
    </head>
    <body onload="document.registration.email.focus();">
        <%
            User x = new User();
            String x1 = "";
            String x2 = "";
            String x3 = "";
            HttpSession sessionx = request.getSession();
            String y = request.getParameter("id");
            sessionx.setAttribute("id", request.getParameter("id"));
            DbConnection C = new DbConnection();
            x = C.GetDataforS("", y);
            x1 = x.getfname();
            x2 = x.getlname();
            x3 = x.getphone();
        %>
        <div id="body">
            <div class="content" style="margin-left: 0px;">

                <button style="color: darkblue;font-size: 23px;">
                    Update Form
                </button>

                <form action="Updatedata" name='registration' onSubmit="return formValidation();">

                    <label for="firstname"><span> First Name : </span>
                        <input type="text" name="firstname" value="<%= x1%>" required style="height: 30px;"/>
                    </label> 

                    <label for="lastname"><span> Last Name : </span>
                        <input type="text" name="lastname" value="<%=x2%>" required style="height: 30px;"/>
                    </label>

                    <label for="phone"><span> Phone No. : </span>
                        <input type="number" name="phone" value="<%= x3%>" required style="height: 30px;"/>
                    </label>

                    <input type="submit" name="submit" value="Update" class="sign"/></li> 

                </form> <br/> <br/>
                <a href="Admin.jsp" class="link"> BACK </a>
            </div> </div>

    </body>
</html>
