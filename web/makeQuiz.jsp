<%-- 
    Document   : makeQuiz
    Created on : Feb 24, 2020, 8:11:25 AM
    Author     : Darkness_King
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <%@include file="MenuBar.jsp"%>
                <div class="body">
                    <h1 class="blue">${done}</h1>
                    <c:if test="${done==null}">
                        <form id="makeQues" action="makeQuiz" method="POST">
                            <div class="question">
                                <div class="item1">Question:</div>
                                <div class="item2"> <textarea class="area"  name="question" >${question}</textarea></div>
                            </div>
                            <c:forEach begin="0" end="${last.size()-1}" var="i">         
                                <div class="question">
                                    <div class="item1">Option ${i+1}:</div>
                                    <div class="item2"> <textarea  class="optionArea" name="${i+1}">${last.get(i)}</textarea></div>
                                </div>
                            </c:forEach>
                            <div class="question">
                                <div class="item1">Answers:</div>
                                <div class="item3">
                                    <c:forEach begin="0" end="${lastAnser.size()-1}" var="i">
                                        <div><input type="checkbox" name="answer" value="${i+1}" ${lastAnser.get(i)}> Option ${i+1} </div>
                                        </c:forEach>
                                </div>
                            </div>

                            <div class="question">
                                <div class="item1"></div>
                                <div class="item3">
                                    <button id="makeQuizButton" type =submit">Save</button>
                                </div>
                            </div>
                        </form>

                        <c:forEach items="${err}" var="i">
                            <div class="red">${i}</div>
                        </c:forEach>
                    </c:if>

                </div>
            </div>

        </div>
    </body>
    <script src="js/makeQuiz.js" type="text/javascript"></script>
</html>
