/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.Admin;
import AnotherPackage.Message;
import AnotherPackage.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIG
 */
@WebServlet(urlPatterns = {"/ShowComments"})
public class ShowComments extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ShowComments</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center> <font size='6' color='green'> Comments Data </font> </center> <br/> ");
            out.println("<center> <table border='3' style='border-color:blue; border-spacing: 6px; border-collapse: collapse;'>");
            out.println("<tr> "
                    + "<td> <center> <font size='4' color='blue'> Comment </center> </font> </td>"
                    + "<td> <center> <font size='4' color='blue'> Sender Name </center> </font> </td>"
                    + "<td> <center> <font size='4' color='blue'> Sender Email </font> </center> </td>"
                    +"</tr>");
            ArrayList<Message> AllComments = new ArrayList<Message>();
            Admin x2 = new Admin();
            AllComments = x2.ShowComments();
            for(int i =0;i<AllComments.size();i++)
            {
                out.println("<tr> <td>" + AllComments.get(i).getContent() + "</td>"
                        + "<td>" + AllComments.get(i).getName() + "</td>"
                        + "<td>" + AllComments.get(i).getEmail() + "</td>"
                        + "</tr>");
            }
             
            out.println(" </center></table><br/> <br/>");
            out.println("<a href='Admin.jsp' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");    
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
