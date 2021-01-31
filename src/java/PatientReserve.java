/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 3MKO
 */
@WebServlet(urlPatterns = {"/Reserve"})
public class PatientReserve extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PatientReserve</title>");            
            out.println("</head> <link rel='stylesheet' href='Styles.css' type='text/css' /> ");
            out.println("<body>");
            out.println("<center><h1>Reservation Form</h1><br/> <br/> </center>");
            out.println("<font size='4' color='blue'>Physiotherapy Department Works in Monday and Thursday from 9 : 11<br/> <br/>"
                    + "Orthopaedic Department Works in Monday and Wednesday from 9 : 11 <br/><br/>"
                    + "Dentisty Department Works in Friday and Thursday from 9 : 11 <br/><br/>"
                    + "Surgery Department Works in Saturday and Sunday from 9 : 11 <br/><br/> <center> You Should Reserve in Department Work Days </center></font><br/><br/>");
            
            out.println("<center><form action='PatientResX' method='post'>");
            ///
            HttpSession session = request.getSession();
            int  P_id = (Integer) session.getAttribute("id");
            ///
            
            out.println("<font size='3' color='blue'> Choose The Department : </font> <select name=\"Dep\">\n" +
              "  <option value=\"Physiotherapy\">Physiotherapy</option>\n" +
              "  <option value=\"Orthopaedic\">Orthopaedic</option>\n" +
              "  <option value=\"Dentistry\">Dentistry</option>\n" +
              "  <option value=\"Surgery\">Surgery</option>\n" +
              "</select><br/><br/>");
            out.println("<font size='3' color='blue'> Choose The Day : </font> <select name=\"Day\">\n" +
              "  <option  value=\"Saturday\">Saturday</option>\n" +
              "  <option  value=\"Sunday\">Sunday</option>\n" +
              "  <option  value=\"Monday\">Monday</option>\n" +
              "  <option  value=\"Tuesday\">Tuesday</option>\n" +
              "  <option  value=\"Wednesday\">Wednesday</option>\n" +
              "  <option  value=\"Thursday\">Thursday</option>\n" +
              "  <option  value=\"Friday\">Friday</option>\n" +
              "</select><br/><br/>");
            out.println("<font size='3' color='blue'>Coose  Hour : </font> <select name=\"Hour\">\n" +
              "  <option  value=\"9\">9</option>\n" +
              "  <option  value=\"10\">10</option>\n" +
              "  <option  value=\"11\">11</option>\n" +
              "</select>");
            out.println("<font size='3' color='blue'> Min : </font><select name=\"Min\">\n" +
              "  <option  value=\"0\">00</option>\n" +
              "  <option  value=\"20\">20</option>\n" +
              "  <option  value=\"40\">40</option>\n" +
              "</select><br/>");
            out.println("<input type='hidden' name='PU_ID' value='"+P_id+"'><br/>");
            out.println("<input name='btn' type='submit' value='Reserve' class='sign'>");
            out.println("</form>");
            if(P_id != 0)
            {
                out.println("<font color='green'> </font><br/><br/>"); 
            }
             out.println("<a href='Patient.jsp' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");
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
