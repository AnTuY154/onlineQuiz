/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class manageQuizController extends HttpServlet {

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
            out.println("<title>Servlet manageQuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet manageQuizController at " + request.getContextPath() + "</h1>");
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
        // check if student :show mess don't have permission else show all question
        String type = (String) request.getSession().getAttribute("type");
        if (type == null) {
            String mangeQuizErr = "You don't have permision";
            request.setAttribute("manageErr", mangeQuizErr);

        } else if (type.compareTo("teacher") != 0) {
            String mangeQuizErr = "You don't have permision";
            request.setAttribute("manageErr", mangeQuizErr);

        } else {
            // Paging 
            try {
                QuizDAO q = new QuizDAO();
                int count = q.countQuestion();
                if (count != 0) {
                    int pagesize = 2;
                    String raw_pageindex = request.getParameter("page");

                    if (raw_pageindex == null) {
                        raw_pageindex = "1";
                    }
                    if (raw_pageindex.matches("[0-9]+")) {
                        if (raw_pageindex.compareTo("0") == 0) {
                            request.setAttribute("manageErr", "Don't have page 0");

                        } else {
                            int pageindex = Integer.parseInt(raw_pageindex);
                            int pagecount = (count % pagesize == 0) ? count / pagesize : count / pagesize + 1;
                            ArrayList<Question> quesManage = q.getAllQuestion(pageindex, pagesize);
                            if (quesManage == null) {
                                request.setAttribute("manageErr", "Don't have data");

                            } else if (quesManage.size() == 0) {
                                request.setAttribute("manageErr", "Don't have data");

                            } else {
                                //set
                                request.setAttribute("pageindex", pageindex);
                                //set all question
                                request.setAttribute("quesManage", quesManage);
                                request.setAttribute("maxPage", pagecount);
                                request.setAttribute("numberOfQuestions", count);
                            }

                        }
                    } else {
                        request.setAttribute("manageErr", "Don't have page " + raw_pageindex);
                    }
                } else {
                    request.setAttribute("manageErr", "Don't have data");
                }
                request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
            } catch (Exception ex) {
                request.getRequestDispatcher("ErrPage.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
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
        String delete = request.getParameter("quesDelete");
        if (delete != null && delete != "") {
            try {
                QuizDAO q = new QuizDAO();
                q.DeleteQuiz(delete);
                response.sendRedirect("manageQuiz");
            } catch (Exception ex) {
                request.getRequestDispatcher("ErrPage.jsp").forward(request, response);
            }
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
