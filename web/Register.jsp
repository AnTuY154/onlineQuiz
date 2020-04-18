<%-- 
    Document   : Register
    Created on : Feb 25, 2020, 3:11:33 PM
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
                    
                    <div><h3>${done}</h3></div>
                    <c:if test="${done==null}">
                        <form action="register" method="POST">
                            <div class="question">
                                <div class="item1">User Name:</div>
                                <div class="item2"><input name="userName" value="${lastRegister.name}" required></div>
                            </div>
                            <div class="question">
                                <div class="item1">Password :</div>
                                <div class="item2"><input type="password" name="pass" required></div>
                            </div>
                            <div class="question">
                                <div class="item1">User Type :</div>
                                <div class="item2">
                                    <select name="type">
                                        <option value="student"  ${lastRegister.type=='student'?"selected":""}>Student</option>
                                        <option value="teacher"  ${lastRegister.type=='teacher'?"selected":""}>Teacher</option>
                                    </select></div>
                            </div>   
                            <div class="question">
                                <div class="item1">Email :</div>
                                <div class="item2"><input type="email" name="email"  value="${lastRegister.email}" required></div>
                            </div>  
                            <c:forEach items="${err}" var="x">
                                <div><h3>${x}</h3> </div>

                            </c:forEach>

                            <button class="button" type="submit">Register</button>

                        </form>
                    </c:if>
                   
                </div>
            </div>

        </div>
    </body>
</html>
