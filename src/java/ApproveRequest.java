/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.Admin;
import AnotherPackage.MailSenderBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIG
 */
@WebServlet(urlPatterns = {"/ApproveRequest"})
public class ApproveRequest extends HttpServlet {
     @EJB
    private MailSenderBean mailsender;
  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
           String mail = request.getParameter("mail"); 
        
        String toEmail = request.getParameter("mail");
        String subject = "Call Ambulance Status";
        String message = "Request Approved Successfully, we are happy for helping you ";
        
        //Properties to be read from external file or DB or server properties
        String fromEmail = "call.ambulance.app@gmail.com";
        String username = "call.ambulance.app@gmail.com";
        String password = "01092665711";  
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       mailsender.sendEmail(fromEmail, username, password, toEmail, subject, message);            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApproveRequest</title>");            
            //out.println("</head>");
            out.println("</head><meta http-equiv=\"Refresh\" content=\"2;url='./ShowAllUsersRequests'\">");
            out.println("<body>");
            
            
             String ID = request.getParameter("rid");
             //String mail = request.getParameter("mail"); 
             Admin A2 = new Admin();
            if(A2.ApproveRequest(ID))
            {
                 out.println("<center><font color='green' size='5'> Requst Approved, Email had been sent to inform you </font></center>");
            }
            else
            {
                out.println("<center><font color='green' size='5'> Requst Approved, Email had been sent to inform you</font></center>");
            }
            
            out.println("</br> </br>");
            //out.println("<center><font color='green' size='5'> <a href='Approve.jsp?mail="+mail+"' style='text-decoration:none;'> Send Email </a> </font></center>");
            //out.println("<a href='ShowAllUsersRequests' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
