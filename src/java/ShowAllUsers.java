


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.*;
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
 * @author Kareem
 */
@WebServlet(urlPatterns = {"/ShowAllUsers"})
public class ShowAllUsers extends HttpServlet {

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
            out.println("<title>Show All Users</title>");            
            out.println("</head>");
            out.println("<body><div id=\"body\">\n" +
"             <div style=\"width:100%;\n" +
"	height:40%;\n" +
" background-size:100%;\n" +
" margin-top:25px;\n" +
" margin-left: 0px\">");
            out.println("<center> <font size='6' color='green'> Users Data </font> </center> <br/> ");
            out.println("<center> <table border='4' style='border-color:blue'>");
            out.println("<tr> "
                    + "<td> <center> <font size='4' color='blue'> FName </center> </font> </td>"
                    + "<td> <center> <font size='4' color='blue'> LName </center> </font> </td>"
                    + "<td> <center> <font size='4' color='blue'> Age </font> </center> </td>"
                    + "<td> <center> <font size='4' color='blue'> City </font> </center> </td>"
                    + "<td> <center> <font size='4' color='blue'> Phone </font> </center> </td>"
                    + "<td> <center> <font size='4' color='blue'> Mail </font> </center> </td>"
                    + "<td> <center> <font size='4' color='blue'> UPDATE </font> </center>  </td>"
                    + "<td> <center> <font size='4' color='blue'> DELETE </font> </center>  </td> </tr>");
            ArrayList<User> AllUsers = new ArrayList<User>();
            Admin x2 = new Admin();
            AllUsers = x2.ShowAllUser();
            for(int i =0;i<AllUsers.size();i++)
            {
                out.println("<tr> <td>" + AllUsers.get(i).getfname() + "</td>"
                        + "<td>" + AllUsers.get(i).getlname() + "</td>"
                        + "<td>" + AllUsers.get(i).getage() + "</td>"
                        + "<td>" + AllUsers.get(i).getcity() + "</td>"
                        + "<td>" + AllUsers.get(i).getphone() + "</td>"
                        + "<td>" + AllUsers.get(i).getmail() + "</td>"
                        + "<td> <a href='UpdateAction.jsp?id=" + AllUsers.get(i).getuid() + " ' style='text-decoration:none;'> Update </a> </td>"
                        + "<td> <a href='DeleteAction?id=" + AllUsers.get(i).getuid()+ " ' style='text-decoration:none;'> Delete </a> </td>"
                        
                        + "</tr>");
            }
             
            out.println(" </center></table><br/> <br/>");
            out.println("<a href='Admin.jsp' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");        
            out.println("</div></body>");
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
