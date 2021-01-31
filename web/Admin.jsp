<%-- 
    Document   : Admin
    Created on : Dec 15, 2015, 2:22:02 PM
    Author     : GIG
--%>
<%
    if (session.getAttribute("fname") == null) {
        response.setHeader("Refresh", "0;url=index.xhtml");
    }
%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "AnotherPackage.Admin" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <!-- <link rel='stylesheet' href='Styles.css' type='text/css' />-->
        <!-- core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font/css/font-awesome.min.css" rel="stylesheet"/>
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="sample-registration-form-validation.js"></script>  
        <link href="css/responsive.css" rel="stylesheet">
        
        
          
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen" />
        <link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
        <link href="css/animate.css" rel="stylesheet" media="screen"/>
        <!-- Owl Carousel Assets -->
        <link href="js/owl-carousel/owl.carousel.css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/styles.css" />
        <!-- Font Awesome -->
        <link href="font/css/font-awesome.min.css" rel="stylesheet"/>
        
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head>
    <body onload="document.registration.email.focus();">


        <div id="body">
             <div style="width:100%;
	height:100%;
 background-image:url(banner-bg.jpg);
 background-size:150%;
 opacity:0.9;
 margin-top:20px;
 margin-left: 0px">
            
                 <div id="body" style="margin-left:80px;">
            <div class="content">
                <div style="margin-left: 200px; margin-top:30px;">
                    <button style="color: darkblue;font-size: 20px">
                        <font style="font-style: oblique;"> Admin Panel</font>
                    </button>
                </div>
                <%
                    FacesContext context = FacesContext.getCurrentInstance();
                    //HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                    HttpSession httpSession = request.getSession(false);
                    String x = (String) session.getAttribute("fname");
                    out.println(" <center><font color='green' size='6' style='margin-left:110px'>Welcome  " + x + "</font></center><br/>");
                %>
               

               
            </div>
        </div>



        <section id="content">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-8 wow fadeInDown">
                        <div class="tab-wrap"> 
                            <div class="media">
                                <div class="parrent pull-left">
                                    <ul class="nav nav-tabs nav-stacked">
                                        <li class="active"><a href="#tab1" data-toggle="tab" class="analistic-01">Admin Panel</a></li>
                                        <li class=""><a href="#tab2" data-toggle="tab" class="analistic-02">Add Users</a></li>
                                        <li class=""><a href="#tab3" data-toggle="tab" class="tehnical">Manage All Users</a></li>
                                        <li class=""><a href="#tab4" data-toggle="tab" class="tehnical">Manage Pending Requests</a></li>
                                        <li class=""><a href="#tab5" data-toggle="tab" class="tehnical">Show Requests Approved or Rejected</a></li>
                                        <li class=""><a href="#tab6" data-toggle="tab" class="tehnical">Manage Comments</a></li>
                                        <li class=""><a href="logout.jsp" class="tehnical" style="color: blue;font-size: 20px">Logout</a></li>
                                    </ul>
                                </div>

                                <div class="parrent media-body">
                                    <div class="tab-content" style="margin-left: 50px;">
                                        <div  class="tab-pane fade active in" id="tab1" >
                                            <div class="media" style="margin-left: -50px;">
                                                
                                                <div class="media-body" >
                                                    <h2>Admin Panel</h2>
                                                    <p>This panel help you manage several functions of the site and our APP as the next tabs and all do into the DB (Web service).</p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="tab-pane fade" id="tab2">
                                            <div class="media" style="margin-left: -50px;">
                                                <div class="pull-left">

                                                </div>
                                                <div class="media-body">
                                                     <h2>Add Users</h2> <a href="AddUsers.jsp"> (Click here) </a> 
                                                    <p> This form help you add more users to our DB such as admins or normal users </p>
                                            </div>
                                        </div>
                                        </div>

                                        <div class="tab-pane fade" id="tab3" style="margin-left: -50px;">
                                             <h2>Manage Users</h2> <a href="./ShowAllUsers"> (Click here) </a>
                                         
                                             <p> Manage users panel help you more functionalities to users like update or delete and show all registered users</p>
                                        </div>

                                        <div class="tab-pane fade" id="tab4" style="margin-left: -50px;">
                                          <h2>Manage Pending Requests</h2> <a href="./ShowAllUsersRequests"> (Click here) </a>
                                      <p>This panel to show and manage all pending requests that wait for approve or reject and confirm user with an email</p>
                                        </div>

                                        <div class="tab-pane fade" id="tab5" style="margin-left: -50px;">
                                           <h2>Show Requests</h2> <a href="./ShowRequests"> (Click here) </a>
                                              <p>This to help you show requests that had been approved or rejected by admins to make statistics about the using of the APP</p>
                                        </div>
                                        
                                        <div class="tab-pane fade" id="tab6" style="margin-left: -50px;">
                                            <h2>Show Comments</h2> <a href="./ShowComments"> (Click here) </a>
                                           <p>This panel to show comments and feedbacks of users</p>
                                        </div>
                                    </div> <!--/.tab-content-->  
                                </div> <!--/.media-body--> 
                            </div> <!--/.media-->     
                        </div><!--/.tab-wrap-->               
                    </div><!--/.col-sm-6-->
                    
              

                    <div class="col-xs-12 col-sm-4 wow fadeInDown">
                        <div class="testimonial">
                            <h2>Information about us</h2>
                            <div class="media testimonial-inner">
                                <div class="pull-left">
                                    <!-- <img class="img-responsive img-circle" src="Android-logo.png">-->
                                <i class="fa fa-android"></i>
                                </div>
                                <div class="media-body">
                                    <p> Hospital consists of more than one health care, all is ready to help you </p>
                                    <span><strong>-DR/Mohamed/</strong> Manager of Hospital</span>
                                </div>
                            </div>

                            <div class="media testimonial-inner">
                                <div class="pull-left">
                                    <!--<img class="img-responsive img-circle" src="Android-logo.png">-->
                                    <i class="fa fa-android"></i>
                                </div>
                                <div class="media-body">
                                    <p>Fastest help is what we look for our patients and users </p>
                                    <span><strong>-Karim/</strong> Director of this section</span>
                                </div>
                            </div>

                        </div>
                    </div>

                </div><!--/.row-->
            </div><!--/.container-->
        </section><!--/#content-->
  </div></div>
                <br/>
                <div class="container">
                    <div class="social text-center"> 
                        <a href="#"><i class="fa fa-twitter"></i></a> 
                        <a href="#"><i class="fa fa-facebook"></i></a> 
                        <a href="#"><i class="fa fa-dribbble"></i></a> 
                        <a href="#"><i class="fa fa-flickr"></i></a> 
                        <a href="#"><i class="fa fa-github"></i></a> 
                        <a href="#"><i class="fa fa-android"></i></a>
                    </div>
                    <!--CLEAR FLOATS--> 
                  </div>
                <!--/.container--> 
            </div>
        </section>
    
        <!--/.page-section-->
        <section class="copyright">
            <div class="container">
                <div class="row">
                   
  <div class="col-sm-12 text-center"> Copyright 2015 | All Rights Reserved --Made by <a href="##">Call Ambulance Team </a> </div>
                </div>
                <!-- / .row --> 
            </div>
        </section>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/jquery.isotope.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/wow.min.js"></script>
         <script src="js/modernizr-latest.js"></script> 
        <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script> 
        <script src="js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="js/jquery.isotope.min.js" type="text/javascript"></script> 
        <script src="js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script> 
        <script src="js/jquery.nav.js" type="text/javascript"></script> 
        <script src="js/jquery.fittext.js"></script> 
        <script src="js/waypoints.js"></script> 
        <script src="js/custom.js" type="text/javascript"></script> 
        <script src="js/owl-carousel/owl.carousel.js"></script>
    </body>
</html>

<%--
<% 
            if(request.getParameter("logout")!= null) 
{ 
session.removeAttribute("uid");
            session.invalidate();
        response.sendRedirect("index.xhtml");
        %>
--%>