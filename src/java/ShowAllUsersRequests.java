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
import javax.servlet.http.HttpSession;


/**
 *
 * @author GIG
 */
@WebServlet(urlPatterns = {"/ShowAllUsersRequests"})
public class ShowAllUsersRequests extends HttpServlet {

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
            out.println("<title>Show Pending Requests</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center> <font size='6' color='green'> Requests Pending Information </font> </center> <br/> ");
            out.println("<center> <table border='4' style='border-color:blue;border-collapse: collapse' >");
            out.println("<tr> "
                    + "<td style='text-align: center'> <font size='4' color='blue'> User Name </font> </td>"
                    + "<td style='text-align: center'> <font size='4' color='blue'> User Phone </font> </td>"
                    + "<td style='text-align: center'> <font size='4' color='blue'> User Mail </font> </td>"
                    + "<td style='text-align: center'> <font size='4' color='blue'> Request Turn </font> </td>"
                    + "<td style='padding: 15px;text-align=center'> <font size='4' color='blue'> Request Date </font> </td>"
                    + "<td style='padding: 85px;text-align: center'> <font size='4' color='blue'> User Location </font> </td>"
                    + "<td style='padding: 5px;text-align: center'> <font size='4' color='blue'> Request Status</font> </td>"
                    + "<td style='padding: 60px;text-align: center'> <font size='4' color='blue'> Hospital Name </font> </td>"
                    + "<td style='padding: 12px;text-align: center;'> <font size='4' color='blue'> Hospital Phone </font> </td>"
                    + "<td style='padding: 85px;text-align: center'> <font size='4' color='blue'> Hospital Location </font> </td>"
                    + "<td style='padding: 8px;text-align: center'> <font size='4' color='blue'> Approve </font> </td>"
                    + "<td style='padding: 5px;text-align: center'> <font size='4' color='blue'> Decline </font> </td>"
                    + "</tr>");

            ArrayList<Request> AllRequest = new ArrayList<Request>();
           
            Admin A1 = new Admin();
            AllRequest = A1.ShowAllRequest();
            for (int i = 0; i < AllRequest.size(); i++) {
                String UserLoc = AllRequest.get(i).getHosLocation();
                String HospitalLoc=AllRequest.get(i).getUserLocation();
                String HospitalName=AllRequest.get(i).getHosName();
                String clean1 = UserLoc.replaceAll("[:]", " ");
                String clean2 = HospitalLoc.replaceAll("[:]", " ");
                String clean3 = HospitalName.replaceAll("[:]", " ");
                UserLoc = clean1;
                HospitalLoc = clean2;
                HospitalName = clean3;
                int ReqID = AllRequest.get(i).getReqID();
                String Email = AllRequest.get(i).getmail();
                
                out.println("<tr> <td>" + AllRequest.get(i).getfname()+ "</td>"
                        + "<td>" + AllRequest.get(i).getphone()+ "</td>"
                        + "<td>" + AllRequest.get(i).getmail()+ "</td>"
                        + "<td>" + AllRequest.get(i).getReqID()+ "</td>"
                        + "<td >" + AllRequest.get(i).getDate() + "</td>"
                        + "<td >" + UserLoc + "</td>"
                        + "<td>" + AllRequest.get(i).getStatus() + "</td>" 
                        + "<td>" + HospitalName+ "</td>"
                        + "<td>" + AllRequest.get(i).getHosPhone()+ "</td>"
                        + "<td>" + HospitalLoc+ "</td>"
                        //+ "<td> <a href='Approve.jsp?rid=" + AllRequest.get(i).getReqID()+ " ' style='text-decoration:none;'> Approve </a> </td>"
                        + "<td> <a href='ApproveRequest?rid="+ReqID+"&mail="+Email+" ' style='text-decoration:none;'> Approve </a> </td>"
                        + "<td> <a href='DeclineRequest?rid="+ReqID+"&mail="+Email+" ' style='text-decoration:none;'> Decline </a> </td>"
                        + "</tr>");
            }
            out.println("</table>");
             out.println("</br></br>");
            out.println("<a href='Admin.jsp' style='text-decoration:none;'> <font size='5' color='blue'>BACK</font> </a>");
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
