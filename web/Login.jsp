<%-- 
    Document   : Login
    Created on : Feb 25, 2020, 2:59:27 PM
    Author     : Darkness_King
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="title">Login Form</div>
                    <form action="Login" method="POST">
                        <div class="question">
                            <div class="item1">User Name:</div>
                            <div class="item2"><input name="userName" value="${lastInputUserName}" required></div>
                        </div>
                        <div class="question">
                            <div class="item1">Password :</div>
                            <div class="item2"><input type="password" name="pass" required></div>
                        </div>
                        <div class="question">
                            <div class="item1"></div>
                            <div class="item2"> <button class="button" type="submit">Sign In</button>
                                <a class="item2" href="register">Register</a></div>
                        </div>




                    </form>
                    <div><h3>${err}</h3></div>
                </div>
            </div>
        </div>
    </body>
</html>
