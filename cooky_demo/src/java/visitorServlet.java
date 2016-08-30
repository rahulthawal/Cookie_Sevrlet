/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahulthawal
 */
public class visitorServlet extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // writing html
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Cookie Example </h2>");
        String msg = "";
        boolean repeatVisitor = false;
        // reading cookies
        Cookie[] cookies = request.getCookies();
        // if cookies are returned from reques t object
        
        if (cookies != null) 
        {//search for cookie -- repeat
            for (int i = 0; i < cookies.length; i++) 
            {
                    // retrieving one cookie out of array
                    Cookie c = cookies[i];
                    // retrieving name & value of the co okie
                    String name = c.getName();
                    String val = c.getValue();
                    // confirming if cookie name equals “repeat” and
                    // value equals “yes”
        
                    if( name.equals("repeat") && val.equals("yes"))
                    {
                        msg= "Welcome Back";repeatVisitor = true;
                        break;
                    }
        
            }
        }
        
        // if no cookie with name “repeat” is found
        if (repeatVisitor == false)
        {
        // create a new cookie
        Cookie c1 = new Cookie("repeat", "yes");
        // setting time after which cookies expires
        c1.setMaxAge(60);
        // adding cookie to the response
        response.addCookie(c1);
        msg = "Welcome Aboard";
        
        }
    // displaying message value
    out.println("<h2>" + msg + "</ h2>");
    out.println("</body>");
    out.println("</html>");
    
    
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
