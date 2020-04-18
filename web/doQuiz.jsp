<%-- 
    Document   : doQuiz
    Created on : Feb 24, 2020, 10:07:09 AM
    Author     : Darkness_King
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
        <link href="css/doQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input id="time" type="hidden" value="${time}">
        <input type="hidden" id="nowQues" value="0">
        <input type="hidden" id="numberOfQues" value="${listQuestion.size()-1}">
        <div class="container">
            <div class="content">
                <%@include file="MenuBar.jsp"%>
                <div class="body">
                    <div class="question"> <p class="item1">Welcome </p><p class="blue"> ${name}</p></div>
                    <div class="countDown"> <p>Time remaining </p>  <p class="red" id="demo"></p></div>
                    <div>
                        <form id="takeQuizSubmit" action="takeQuiz" method="POST">                 
                            <c:forEach begin="0" end="${listQuestion.size()-1}" var="x">
                                <div id="${x}" class="${x!=0?"hidden":""}">
                                    <div class="showQues">${listQuestion.get(x).question}</div> 
                                    <c:forEach begin="0" end="${listQuestion.get(x).answer.size() -1}" var="i">
                                        <input type="checkbox"  name="answer${x}" value="${i+1}">${listQuestion.get(x).answer.get(i)}<br>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </form>                 
                        <button class="countDown" id="xbutton" value="Next">${listQuestion.size()==1?"Submit":"Next"}</button>
                    </div>

                </div>
            </div>

        </div>
    </body>
    <script src="js/countDown.js" type="text/javascript"></script>
    <script src="js/doQuiz.js" type="text/javascript"></script>

</html>
