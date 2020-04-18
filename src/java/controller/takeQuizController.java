/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuizDAO;
import java.util.Date;

/**
 *
 * @author Darkness_King
 */
public class takeQuizController extends HttpServlet {

    private int xtime;

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
            out.println("<title>Servlet takeQuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet takeQuizController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
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
        String numberOfQuestion = request.getParameter("numberOfQuestion");
        // get Quiz
        if (numberOfQuestion != null) {
            try {
                QuizDAO q = new QuizDAO();
                int dataQues = q.countQuestion();
                //check user input about numberOfQuestion
                //TH1 enter number smaller than 0 TH2 : enter number bigger than data have
                if (numberOfQuestion.matches("[0-9]+") == true) {
                    if (Integer.parseInt(numberOfQuestion) <= 0) {
                        request.setAttribute("takeQuizErr", "Your can't enter" + numberOfQuestion);
                        request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
                    } else if (Integer.parseInt(numberOfQuestion) > dataQues) {
                        String err = "Don't have enough question. We have only " + dataQues + " questions";
                        request.setAttribute("takeQuizErr", err);
                        request.setAttribute("lastUserInput", numberOfQuestion);
                        request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
                    } else {
                        // if don't have err set time to do quiz
                        int time = Integer.parseInt(numberOfQuestion) * 60;
                        xtime = time;
                        ArrayList<Question> question = null;
                        question = q.getQuiz(Integer.parseInt(numberOfQuestion));
                        HttpSession session = request.getSession();
                        session.setAttribute("listQuestion", question);
                        request.setAttribute("time", time * 1000);
                        request.setAttribute("doing", "doQuiz");
                        request.getRequestDispatcher("doQuiz.jsp").forward(request, response);
                    }
                    //Th user change html
                } else {
                    String err = "You can't enter string";
                    request.setAttribute("takeQuizErr", err);
                    request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                request.getRequestDispatcher("ErrPage.jsp").forward(request, response);
            }
        } else {
            // when user type submit or when timeout
            HttpSession session = request.getSession();
            Date d = new Date();
            long time = (d.getTime() - session.getLastAccessedTime()) / (1000);
            ArrayList<Question> question = (ArrayList<Question>) session.getAttribute("listQuestion");
            // check time user doing quiz then get user answer and caculate score
            if (time <= xtime) {
                float count = 0;
                for (int i = 0; i < question.size(); i++) {
                    String[] trueAnswer = request.getParameterValues("answer" + i);
                    if (trueAnswer != null) {
                        String result = "";
                        for (int j = 0; j < trueAnswer.length; j++) {
                            result += trueAnswer[j] + "-";
                        }
                        result = result.substring(0, result.length() - 1);
                        if (result.compareTo(question.get(i).getRightAnswer()) == 0) {
                            count++;
                        }
                    }
                }
                float finalResult = (count / question.size()) * 10;
                finalResult = (float) Math.round(finalResult * 100) / 100;
                float persen = finalResult * 10;
                String pass = "";
                if (finalResult >= 5) {
                    pass = "Passed";
                } else {
                    pass = "Not Passed";
                }
                request.setAttribute("pass", pass);
                request.setAttribute("score", finalResult);
                request.setAttribute("persen", persen);
                request.getRequestDispatcher("resultPage.jsp").forward(request, response);
            } else {
                request.setAttribute("errSubmit", "Your are over time");
                request.getRequestDispatcher("resultPage.jsp").forward(request, response);
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
