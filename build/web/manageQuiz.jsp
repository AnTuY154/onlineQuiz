<%-- 
    Document   : manageQuiz
    Created on : Feb 25, 2020, 4:16:18 PM
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
        <link href="css/manageQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <%@include file="MenuBar.jsp"%>
                <div class="body">
                    <h1 class="red"> ${manageErr}</h1>
                    <c:if test="${manageErr==null}">
                        <div class="question"> <p class="item1">Number of question :  </p><p class="blue"> ${numberOfQuestions}</p></div>
                        <div class="managQues">
                            <div class="itemManage1">
                                <p class="blue"> Question</p>
                            </div>
                            <div class="itemManage2">
                                <p class="blue">Date Created </p>
                            </div>
                        </div>
                        <div>
                            <c:forEach begin="0" end="${quesManage.size()-1}" var="x">
                                <div class="managQues">
                                    <div class="itemManage1">
                                        ${quesManage.get(x).question}
                                    </div>
                                    <div class="itemManage2">
                                         ${quesManage.get(x).date}
                                    </div>
                                    <div  class="itemManafe3">
                                        <form id="delete${x}" action="manageQuiz" method="POST">
                                            <input type="hidden" value="${quesManage.get(x).question}" name="quesDelete"> 
                                            <button onclick="change()" type="submit">Delete</button>
                                        </form>
                                    </div>
                                    <br>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="paging">
                            <c:if test="${maxPage < 1}">
                                <h3>Not Found !!</h3>
                            </c:if>
                            <c:if test="${maxPage > 1}">
                                <a class="${1==pageindex?"active":""}" href="manageQuiz?page=1">${1==pageindex?pageindex:"First"}</a>
                                <c:forEach begin="2" end="${maxPage-1}" var="i">
                                    <a class="${i==pageindex?"active":""}" href="manageQuiz?page=${i}">${i}</a>
                                </c:forEach>
                                <a class="${maxPage==pageindex?"active":""}" href="manageQuiz?page=${maxPage}">${maxPage==pageindex?pageindex:"Last"}</a>
                            </c:if>                  
                        </div>
                    </c:if>
                </div>
            </div>

        </div>
    </body>
    <script src="js/menuBar.js" type="text/javascript"></script>
</html>
