<%-- 
    Document   : Home
    Created on : Feb 25, 2020, 3:43:16 PM
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
                    <div class="question"> <p class="item1">Welcome </p><p class="blue"> ${name}</p></div>
                </div>
            </div>

        </div>
    </body>
</html>
