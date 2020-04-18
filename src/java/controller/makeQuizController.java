/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import entity.lastInputQues;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuizDAO;

/**
 *
 * @author Darkness_King
 */
public class makeQuizController extends HttpServlet {

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
            out.println("<title>Servlet makeQuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet makeQuizController at " + request.getContextPath() + "</h1>");
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
        // Enter number of question and answer
        ArrayList<String> Input = new ArrayList();
        request.setAttribute("done", null);
        ArrayList<String> ChooseAnswer = new ArrayList();
        int numberOfOption = 4;
        for (int i = 1; i <= numberOfOption; i++) {
            Input.add("");
            ChooseAnswer.add("");
        }
        request.setAttribute("doing", "makeQuiz");
        request.setAttribute("last", Input);
        request.setAttribute("lastAnser", ChooseAnswer);
        request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
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
        // Check user input

        ArrayList<String> err = new ArrayList();
        ArrayList<String> option = new ArrayList();
        ArrayList<String> lastInput = new ArrayList();
        ArrayList<String> lastChooseAnswer = new ArrayList();
        boolean check = true;
        // check question if wrong add err in to arraylist err
        String question = request.getParameter("question");
        if (question.length() <= 0) {
            err.add("Please enter a question");
            check = false;
        }
        // check option if wrong add to err. And add the lastInput into arraylist lastinput
        for (int i = 1; i <= 4; i++) {
            String uoption = request.getParameter(String.valueOf(i));
            if (uoption.length() > 0) {
                option.add(uoption);
            } else {
                err.add("Please enter Option" + i);
                check = false;
            }
            lastInput.add(uoption);
        }
        // check answer.
        String[] trueAnswer = request.getParameterValues("answer");
        int a = 0;
        // Th1: User don't choose any answer
        String xtrueQues = "";
        if (trueAnswer == null) {
            err.add("Please enter a anwer");
            for (int i = 1; i <= 4; i++) {
                lastChooseAnswer.add("no");
            }
            check = false;
            // Th2: User enter all answer
        } else if (trueAnswer.length == 4) {
            for (int i = 1; i <= 4; i++) {
                lastChooseAnswer.add("checked");
            }
            err.add("You can't choose 4 option");
            check = false;
            //Th3: User enter true then add last choose input lastChooseAnswer 
        } else {

            for (int i = 1; i <= 4; i++) {
                if (a < trueAnswer.length) {
                    if (Integer.parseInt(trueAnswer[a]) == i) {
                        xtrueQues += trueAnswer[a] + "-";
                        a++;
                        lastChooseAnswer.add("checked");
                    } else {
                        lastChooseAnswer.add("");
                    }
                } else {
                    lastChooseAnswer.add("");
                }
            }
        }
        // if have any err send back to makeQuiz.jsp with some mess to show err
        if (check == false) {
            request.setAttribute("question", question);
            request.setAttribute("err", err);
            request.setAttribute("last", lastInput);
            request.setAttribute("lastAnser", lastChooseAnswer);
            request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
        } else {
            // if don't have any err insert question to database
            Question q = new Question();
            q.setAnswer(option);
            q.setQuestion(question);
            q.setRightAnswer(xtrueQues.substring(0, xtrueQues.length() - 1));
            QuizDAO quiz = new QuizDAO();
            try {
                // if have any exception stop insert and show errPage
                quiz.inserQuiz(q);
                request.setAttribute("done", "Add question successfully");
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);

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
