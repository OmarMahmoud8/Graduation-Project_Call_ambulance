package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.faces.context.FacesContext;

public final class Patient_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Patient Page</title>\n");
      out.write("         <link rel='stylesheet' href='Styles.css' type='text/css' /> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"body\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div style=\"margin-left: 200px; margin-top: -20px;\">\n");
      out.write("                    <button style=\"color: darkblue;\">\n");
      out.write("                        Patient Panel\n");
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
      out.write("         <form action=\"../ShowAllVisits\" method=\"post\">\n");
      out.write("             <input type=\"submit\" value=\"Show My Visits\" class=\"sign\"/>\n");
      out.write("        </form>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"margin-left: 300px; margin-top:-85px;\">\n");
      out.write("                    <form action=\"./Reserve\" method=\"post\">\n");
      out.write("                        <input type=\"submit\" value=\"Reserve a Visit\" class=\"sign\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("         \n");
      out.write("      <div style=\"margin-left:150px;margin-top: 80px;\">          \n");
      out.write("                    <form action=\"logout.jsp\" method=\"post\">\n");
      out.write("                        <input type=\"submit\" value=\"Logout\" class=\"sign\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
