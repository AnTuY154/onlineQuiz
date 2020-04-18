/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.QuizDAO;

/**
 *
 * @author Darkness_King
 */
public class registerController extends HttpServlet {

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
            out.println("<title>Servlet registerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerController at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("done", null);
        request.getRequestDispatcher("Register.jsp").forward(request, response);
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
        try {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("pass");
            String email = request.getParameter("email");
            String type = request.getParameter("type");
            QuizDAO q = new QuizDAO();
            User userLast = new User();
            userLast.setName(userName);
            userLast.setEmail(email);
            userLast.setType(type);
            ArrayList err = new ArrayList();
            // check normal input 
            if (userName != null && passWord != null && email != null && type != null) {
                if (q.getUserName(userName) == true) {
                    err.add("Your user name exited");
                }
                if (q.checkmail(email) == true) {
                    err.add("Your email have exited");
                }
                if (err.size() == 0) {
                    User u = new User();
                    u.setName(userName);
                    u.setEmail(email);
                    u.setPassword(passWord);
                    u.setType(type);
                    q.inserUser(u);
//                    response.sendRedirect("Login");
                    request.setAttribute("done", "Register successfully");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else {
                    request.setAttribute("err", err);
                    request.setAttribute("lastRegister", userLast);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                // check exception user change html
            } else {
                request.setAttribute("lastRegister", userLast);
                err.add("Something wrong please enter aagin!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("ErrPage.jsp").forward(request, response);
        }

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
