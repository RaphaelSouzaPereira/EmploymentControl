<%-- 
    Document   : login
    Created on : Feb 21, 2018, 2:13:29 PM
    Author     : RenanFontouraBoldrin
--%>

<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Login</title>
    </head>
    <body>
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row mb-5 py-0 px-5 ibmec-menu">
            <h1 class="navbar-brand mr-0 mr-md-2 m-0 ibmec-menu-logo"><span class="ibmec-menu-logo-ibm">IBM </span>Employment Control</h1>
            <ul class="navbar-nav flex-row ml-md-auto d-md-none d-md-flex">
                <li class="dropdown">
                    <a class="nav py-4 px-4">LOGIN</a>
                </li>
            </ul>
        </header>
        <div class="container">
            <div class="row">
                <div class="offset-1 col-md-10">
                    <h2 class="ibmec-title mb-3">Login</h2>
                    <hr>
                    <form class="cadastra-candidatos" action="./LoginServlet" method="post">                           
                        <div class="form-group col-xs-12 col-md-9">
                            <label for="inputEmail">Email:</label>
                            <input type="text" class="form-control" id="inputEmail" placeholder="Email do profissional" name="emailProfissional" required>
                        </div>
                        <div class="form-group col-xs-12 col-md-9">
                            <label for="inputSenha">Senha:</label>
                            <input type="password" class="form-control" id="inputSenha" placeholder="Senha do profissional" name="senhaProfissional" required>
                        </div>
                        <div class="form-group col-xs-12 col-md-9">
                            <button type="submit" class="btn ibmec-btn" id="btn-login" enable>Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page = "include/footer.jsp" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
    </body>
</html>
