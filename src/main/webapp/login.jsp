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

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Login</title>
    </head>
    <body>
        <div class="ibmec-login-wrapper">
            <div class="ibmec-login">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center ">
                            <i class="material-icons ibmec-login-logo">business_center</i>
                            <h2 class="mb-3 ibmec-title-login">IBM Employment Control</h2>
                            <hr class="ibmec-login-hr">
                        </div>
                        <div class="col-md-12">
                            <form class="cadastra-candidatos" action="./LoginServlet" method="post">
                                <div class="form-group col-xs-12 col-md-12">
                                    <input type="text" class="form-control ibmec-login-input" id="inputEmail" placeholder="Usuário" name="emailProfissional" required>
                                </div>
                                <div class="form-group col-xs-12 col-md-12">
                                    <input type="password" class="form-control ibmec-login-input" id="inputSenha" placeholder="Senha" name="senhaProfissional" required>
                                </div>
                                <div class="form-group col-xs-12 col-md-12">
                                    <button type="submit" class="btn btn-block ibmec-btn-login" id="btn-login" enable>Login</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
    </body>
</html>
