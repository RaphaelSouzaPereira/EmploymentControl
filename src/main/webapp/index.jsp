<%-- 
    Document   : index.jsp
    Created on : 16/01/2018, 14:53:23
    Author     : PriscilaRicardoArrud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Home</title>
    </head>
    <body>
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar">
            <h1 class="navbar-brand mr-0 mr-md-2 logo"><span class="logo-ibm">IBM </span>Employment Control</h1>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="#">Consultar Vagas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./cadastro-vagas.jsp">Cadastrar Vagas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="#">Cadastrar Candidato</a>
                </li>
            </ul>
        </header>
        <div class="container">
            <div class="row">
                <div class="offset-1 col-10">
                    <table class="table table-bordered" style="margin-top:45px">
                        <thead>
                            <tr>
                                <th>PMP</th>
                                <th>Data de Abertura</th>
                                <th>Área</th>
                                <th>Tipo</th>
                                <th>Tecnologia</th>
                                <th>Categoria</th>
                                <th ></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>123456</td>
                                <td>00/00/0000</td>
                                <td>exemploAr</td>
                                <td>exemploTip</td>
                                <td>exemploTec</td>
                                <td>exemploCat.</td>
                                <td align='center'><button type="button" class="btn btn-primary">Visualizar</button></td>
                            </tr>
                            <tr>
                                <td>123456</td>
                                <td>00/00/0000</td>
                                <td>exemploAr</td>
                                <td>exemploTip</td>
                                <td>exemploTec</td>
                                <td>exemploCat.</td>
                                <td align='center'><button type="button" class="btn btn-primary">Visualizar</button></td>
                            </tr>
                            <tr>
                                <td>123456</td>
                                <td>00/00/0000</td>
                                <td>exemploAr</td>
                                <td>exemploTip</td>
                                <td>exemploTec</td>
                                <td>exemploCat.</td>
                                <td align='center'><button type="button" class="btn btn-primary">Visualizar</button></td>
                            </tr>
                            <tr>
                                <td>123456</td>
                                <td>00/00/0000</td>
                                <td>exemploAr</td>
                                <td>exemploTip</td>
                                <td>exemploTec</td>
                                <td>exemploCat.</td>
                                <td align='center'><button type="button" class="btn btn-primary">Visualizar</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
    </body>
</html>
