<%-- 
    Document   : resultPage
    Created on : Feb 26, 2020, 9:02:11 AM
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
                    <c:if test="${errSubmit ==null}">
                        <form action="takeQuiz" method="GET">
                            <div class="question">
                                <div class="item1"><p>Your score</p> </div>
                                <div class="item2"><p class="${pass=="Passed"?"blue":"red"}">${score} (${persen}%) - ${pass} </p></div>
                            </div>
                            <div class="question">
                                <div class="item1"><p>Take another test </p> </div>
                                <div class="item1"><p><button type="submit"> Start</button></p></div>
                            </div>
                        </form>  
                    </c:if>
                    <div><h3>${errSubmit}</h3></div>
                </div>
            </div>
        </div>
    </body>
</html>
