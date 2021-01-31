package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.faces.context.FacesContext;
import AnotherPackage.Admin;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    if (session.getAttribute("fname") == null) {
        response.setHeader("Refresh", "0;url=index.xhtml");
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <!-- <link rel='stylesheet' href='Styles.css' type='text/css' />-->\n");
      out.write("        <!-- core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"font/css/font-awesome.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"sample-registration-form-validation.js\"></script>  \n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"js/html5shiv.js\"></script>\n");
      out.write("        <script src=\"js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->       \n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"document.registration.email.focus();\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"body\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div style=\"margin-left: 200px; margin-top: -20px;\">\n");
      out.write("                    <button style=\"color: darkblue;\">\n");
      out.write("                        Admin Panel\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                ");

                    FacesContext context = FacesContext.getCurrentInstance();
                    //HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                    HttpSession httpSession = request.getSession(false);
                    String x = (String) session.getAttribute("fname");
                    out.println(" <center><font color='green' size='5'>Welcome  " + x + "</font></center><br/>");
                
      out.write("\n");
      out.write("                <div style=\"margin-right:-500px;\">\n");
      out.write("                    <form action=\"AddUsers.jsp\" method=\"post\">\n");
      out.write("                        <input type=\"submit\" value=\"AddUsers\" class=\"sign\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div style=\"margin-left: 300px; margin-top:-85px;\">\n");
      out.write("                    <form action=\"./ShowAllUsers\" method=\"post\">\n");
      out.write("                        <input type=\"submit\" value=\"ShowAllUsers\" class=\"sign\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div style=\"margin-left: 600px; margin-top:-85px;\">\n");
      out.write("                    <form action=\"./ShowAllUsersVisits\" method=\"post\">\n");
      out.write("                        <input type=\"submit\" value=\"ShowAllVisits\" class=\"sign\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div style=\"margin-left:150px;margin-top: 80px;\">          \n");
      out.write("                    <form action='logout.jsp' method='post'>\n");
      out.write("                        <input type=\"submit\" value=\"Logout\" class=\"sign\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <section id=\"content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12 col-sm-8 wow fadeInDown\">\n");
      out.write("                        <div class=\"tab-wrap\"> \n");
      out.write("                            <div class=\"media\">\n");
      out.write("                                <div class=\"parrent pull-left\">\n");
      out.write("                                    <ul class=\"nav nav-tabs nav-stacked\">\n");
      out.write("                                        <li class=\"active\"><a href=\"#tab1\" data-toggle=\"tab\" class=\"analistic-01\">Admin Panel</a></li>\n");
      out.write("                                        <li class=\"\"><a href=\"#tab2\" data-toggle=\"tab\" class=\"analistic-02\">Add Users</a></li>\n");
      out.write("                                        <li class=\"\"><a href=\"#tab3\" data-toggle=\"tab\" class=\"tehnical\">Manage All Users</a></li>\n");
      out.write("                                        <li class=\"\"><a href=\"#tab4\" data-toggle=\"tab\" class=\"tehnical\">Manage Comments</a></li>\n");
      out.write("                                        <li class=\"\"><a href=\"#tab5\" data-toggle=\"tab\" class=\"tehnical\">Manage Feedback</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"parrent media-body\">\n");
      out.write("                                    <div class=\"tab-content\">\n");
      out.write("                                        <div  class=\"tab-pane fade active in\" id=\"tab1\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <div class=\"pull-left\">\n");
      out.write("                                                    <!--<img class=\"img-responsive\" src=\"images/tab2.png\">-->\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <h2>Adipisicing elit</h2>\n");
      out.write("                                                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use.</p>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"tab-pane fade\" id=\"tab2\">\n");
      out.write("                                            <div class=\"media\">\n");
      out.write("                                                <div class=\"pull-left\">\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"media-body\">\n");
      out.write("                                                    <h2>Add User Form</h2>\n");
      out.write("                                                    <br/>\n");
      out.write("                                                    <div id=\"body\">\n");
      out.write("                                                        <div class=\"content\">\n");
      out.write("                                                            <form name='registration' onSubmit=\"return formValidation();\" method=\"post\" action=\"./AddAction\">  \n");
      out.write("\n");
      out.write("                                                                <label for=\"firstname\"> <span>First Name : </span>\n");
      out.write("                                                                    <input type=\"text\" name=\"firstname\" size=\"50\" required/>\n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"lastname\"> <span> Last Name : </span>\n");
      out.write("                                                                    <input type=\"text\" name=\"lastname\" size=\"50\" required/>\n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"email\"><span> Email : </span>\n");
      out.write("                                                                    <input type=\"text\" name=\"email\" size=\"50\" required/>\n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"phone\"><span> Phone No. : </span>\n");
      out.write("                                                                    <input type=\"number\" name=\"phone\" size=\"12\" required />  \n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"age\"><span> Age : </span>\n");
      out.write("                                                                    <input type=\"number\" name=\"age\" size=\"4\" required/>  \n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"city\"><span> City : </span>\n");
      out.write("                                                                    <input type=\"text\" name=\"city\" required/>  \n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label for=\"passid\"><span> Password : </span>\n");
      out.write("                                                                    <input type=\"password\" name=\"passid\" size=\"16\" required/>  \n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <label id=\"gender\">  <span> Gender : </span> </label>\n");
      out.write("                                                                <div style=\"margin-left:140px;margin-top: -32px; \">\n");
      out.write("                                                                    <input type=\"radio\" name=\"sex\" value=\"M\" checked=\"true\"/>Male\n");
      out.write("                                                                    <input type=\"radio\" name=\"sex\" value=\"F\" />Female\n");
      out.write("                                                                </div>\n");
      out.write("\n");
      out.write("                                                                <label for=\"utype\"><span> User Type : </span>\n");
      out.write("\n");
      out.write("                                                                    <select name=\"utype\">   \n");
      out.write("\n");
      out.write("                                                                        <option selected=\"\" value=\"2\">Admin</option>  \n");
      out.write("                                                                        <option value=\"1\">Patient</option>  \n");
      out.write("                                                                        <option value=\"3\">Doctor</option> \n");
      out.write("\n");
      out.write("                                                                    </select> \n");
      out.write("                                                                </label>\n");
      out.write("\n");
      out.write("                                                                <div class=\"con\"> \n");
      out.write("\n");
      out.write("                                                                    <input type=\"submit\" name=\"submit\" value=\"ADD\"/>                \n");
      out.write("                                                                </div>\n");
      out.write("                                                            </form> \n");
      out.write("                                                        </div> </div>            \n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"tab-pane fade\" id=\"tab3\">\n");
      out.write("                                            <h2>Manage Users</h2>\n");
      out.write("                                           \n");
      out.write("                                            <p>\n");
      out.write("                                                ");

                                                Admin show = new Admin();
                                                show.ShowAllUser();
                                            
      out.write("\n");
      out.write("                                            </p>\n");
      out.write("                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit.</p>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"tab-pane fade\" id=\"tab4\">\n");
      out.write("                                            <h2>Comments</h2>\n");
      out.write("                                            <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words</p>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"tab-pane fade\" id=\"tab5\">\n");
      out.write("                                            <h2>Users Feedback</h2>\n");
      out.write("                                            <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures,</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div> <!--/.tab-content-->  \n");
      out.write("                                </div> <!--/.media-body--> \n");
      out.write("                            </div> <!--/.media-->     \n");
      out.write("                        </div><!--/.tab-wrap-->               \n");
      out.write("                    </div><!--/.col-sm-6-->\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-12 col-sm-4 wow fadeInDown\">\n");
      out.write("                        <div class=\"testimonial\">\n");
      out.write("                            <h2>Testimonials</h2>\n");
      out.write("                            <div class=\"media testimonial-inner\">\n");
      out.write("                                <div class=\"pull-left\">\n");
      out.write("                                    <img class=\"img-responsive img-circle\" src=\"images/testimonials1.png\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"media-body\">\n");
      out.write("                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</p>\n");
      out.write("                                    <span><strong>-John Doe/</strong> Director of corlate.com</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"media testimonial-inner\">\n");
      out.write("                                <div class=\"pull-left\">\n");
      out.write("                                    <img class=\"img-responsive img-circle\" src=\"images/testimonials1.png\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"media-body\">\n");
      out.write("                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</p>\n");
      out.write("                                    <span><strong>-John Doe/</strong> Director of corlate.com</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div><!--/.row-->\n");
      out.write("            </div><!--/.container-->\n");
      out.write("        </section><!--/#content-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("        <script src=\"js/jquery.isotope.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"js/wow.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
