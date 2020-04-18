<%-- 
    Document   : MenuBar
    Created on : Jan 11, 2020, 11:06:19 AM
    Author     : Darkness_King
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <script src="js/menuBar.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
      
            <div class="preheader"></div>
<!--            <input type="hidden">-->
            <div class="header">
                <a  id="Home" href="Home">Home</a>
                <a  id="takeQuiz"  href="takeQuiz">Take Quiz</a>
                <a  id="makeQuiz" href="makeQuiz">Make Quiz</a>
                <a  id="manageQuiz"  href="manageQuiz" >Manage Quiz</a>
                <a  id="logOut" class="${type==null?"hidden":""}" href="Login">Log Out</a>
            </div>
       
        </div>
    </body>
    
</html>
