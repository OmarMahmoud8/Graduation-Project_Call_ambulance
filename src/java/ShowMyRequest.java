/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnotherPackage.Patient;
import AnotherPackage.Request;
import AnotherPackage.User;
import AnotherPackage.Visit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/ShowMyRequest"})
public class ShowMyRequest extends HttpServlet {

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
            out.println("<title>ShowMyRequest</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<center> <font size='6' color='green'> My Requests Data </font> </center> <br/> ");
            out.println("<center> <table border='4' style='border-color:blue'>");
             out.println("<tr> "
                    + "<td style='text-align: center'> <font size='4' color='blue'> My Request Turn </font> </td>"
                    + "<td style='padding: 15px;text-align=center'> <font size='4' color='blue'> Request Date </font> </td>"
                    + "<td style='padding: 85px;text-align: center'> <font size='4' color='blue'> My Location </font> </td>"
                    + "<td style='padding: 5px;text-align: center'> <font size='4' color='blue'> Request Status</font> </td>"
                    + "<td style='padding: 60px;text-align: center'> <font size='4' color='blue'> Hospital Name </font> </td>"
                    + "<td style='padding: 12px;text-align: center;'> <font size='4' color='blue'> Hospital Phone </font> </td>"
                    + "<td style='padding: 85px;text-align: center'> <font size='4' color='blue'> Hospital Location </font> </td>"
                    + "</tr>");
                   
                   
                  HttpSession session = request.getSession();
                  int x = (Integer) session.getAttribute("id");
//                  int y = (Integer) session.getAttribute("vid");
                  ArrayList<Request> AllMyRequest = new ArrayList<Request>();
                  User U2 = new User();
                  AllMyRequest = U2.ShowAllMyRequest(x);
            for(int i =0;i<AllMyRequest.size();i++)
            {
                String UserLoc = AllMyRequest.get(i).getHosLocation();
                String HospitalLoc=AllMyRequest.get(i).getUserLocation();
                String HospitalName=AllMyRequest.get(i).getHosName();
                String clean1 = UserLoc.replaceAll("[:]", " ");
                String clean2 = HospitalLoc.replaceAll("[:]", " ");
                String clean3 = HospitalName.replaceAll("[:]", " ");
                UserLoc = clean1;
                HospitalLoc = clean2;
                HospitalName = clean3;
                
                out.println("<tr> <td>" + AllMyRequest.get(i).getReqID()+ "</td>"
                        + "<td >" + AllMyRequest.get(i).getDate() + "</td>"
                        + "<td >" + UserLoc + "</td>"
                        + "<td>" + AllMyRequest.get(i).getStatus() + "</td>" 
                        + "<td>" + HospitalName+ "</td>"
                        + "<td>" + AllMyRequest.get(i).getHosPhone()+ "</td>"
                        + "<td>" + HospitalLoc+ "</td>"
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
