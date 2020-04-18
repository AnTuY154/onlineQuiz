<%-- 
    Document   : takeQuiz
    Created on : Feb 24, 2020, 9:55:35 AM
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
    </head>
    <body>
        <div class="container">
            <div class="content">
                <%@include file="MenuBar.jsp"%>
                <div class="body">
                    <div class="question"> <p class="item1">Welcome </p><p class="blue"> ${name}</p></div>
                        <form action="takeQuiz" method="POST">
                            <div class="item1">Enter number of question:</div><br >
                            <input type="number" name="numberOfQuestion" value="${lastUserInput}" required>
                            <button class="center" type="submit">Start</button>                       
                        </form>
                    
                    <div class="red"><h3>${takeQuizErr}</h3></div>
                </div>
            </div>

        </div>
    </body>
</html>
