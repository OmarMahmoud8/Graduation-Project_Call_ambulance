/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 3MKO
 */
@WebServlet(urlPatterns = {"/PatientResX"})
public class PatientResX extends HttpServlet {

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
            //
            String Dep ,Day,P_IDx,hourx,minx;
            Dep = request.getParameter("Dep");
            Day = request.getParameter("Day");
            P_IDx=request.getParameter("PU_ID");
            hourx=request.getParameter("Hour");
            minx=request.getParameter("Min");
            int Hour=0,Min=0 ,P_id=0;//initial val
            //--------------->
            Hour = Integer.parseInt(hourx);
            Min = Integer.parseInt(minx);
            P_id = Integer.parseInt(P_IDx);
            
            //
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PatientReserveAction</title>");            
            out.println("</head><meta http-equiv=\"Refresh\" content=\"6;url=Reserve\">");
            out.println("<body>");
  
            Patient x = new Patient();
            if(Hour !=0 && !Dep.equals("")&& !Day.equals("")){
               if(x.Reserve(P_id, Day, Dep, Hour, Min))
                 out.println("<center><font color='green' size='4'> Your Reservation Added Successfully <br/>"
                         + "Reserva Another Date If You Want .. </font></center>");
               else 
                out.println("<center><font color='green' size='4'> You are Selected a reserved date OR <br/> "
                        + "You Reserved in Date not found and Department don't Work in this Day !!<br/>"
                        + "Reserva Another Date If You Want .. </font></center><br/><br/>");
               }
           
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
