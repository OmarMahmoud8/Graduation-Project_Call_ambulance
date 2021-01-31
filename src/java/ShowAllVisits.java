/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIG
 */
@WebServlet(urlPatterns = {"/ShowAllVisits"})
public class ShowAllVisits extends HttpServlet {

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
            out.println("<title>Show Patient Visits</title>");            
            out.println("</head>");
            out.println("</body>");
            out.println("<center> <font size='6' color='green'> Visits Data </font> </center> <br/> ");
            out.println("<center> <table border='4' style='border-color:blue'>");
            out.println("<tr> "
                    + "<td> <font size='4' color='blue'> Visit Turn </font> </td>"
                    + "<td> <font size='4' color='blue'> Visit Day </font> </td>"
                    + "<td> <font size='4' color='blue'> Visit Time Reserve </font> </td>"
                    + "<td> <font size='4' color='blue'> Visit Start Hour : </font> </td>"
                    + "<td> <font size='4' color='blue'> Visit Start Min </font> </td>"
                    + "<td> <font size='4' color='blue'> Duration </font> </td>"
                    + "<td> <font size='4' color='blue'> Cancel Visit</font> </td> "
                    + "<td> <font size='4' color='blue'> Change Visit </font> </td></tr>");
                   
                   
                  HttpSession session = request.getSession();
                  int x = (Integer) session.getAttribute("id");
//                  int y = (Integer) session.getAttribute("vid");
                  ArrayList<Visit> AllVisit = new ArrayList<Visit>();
                  Patient p2 = new Patient();
                  AllVisit = p2.ShowAllVisit(x);
            for(int i =0;i<AllVisit.size();i++)
            {
                out.println("<tr> <td>" + AllVisit.get(i).GetVisID() + "</td>"
                        + "<td>" + AllVisit.get(i).getVDay() + "</td>"
                        + "<td>" + AllVisit.get(i).GetTimeRes() + "</td>"
                        + "<td>" + AllVisit.get(i).getVstart_Hour() +  " : </td>"
                        + "<td>" + AllVisit.get(i).getVstart_min() + "</td>"
                        + "<td>" + AllVisit.get(i).GetDuration() + " mins</td>"
                        + "<td> <a href='DeleteVisitAction?vid=" + AllVisit.get(i).GetVisID()+ " ' style='text-decoration:none;'> Cancel </a> </td>"
                        + "<td> <a href='UpdateVisitAction?vid=" + AllVisit.get(i).GetVisID()+ " ' style='text-decoration:none;'> Change </a> </td>"
                        + "</tr>");
            }
            out.println("</table>");
              out.println("<a href='Patient.jsp' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");
            out.println("</center></body>");
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
