<%-- 
    Document   : index.jsp
    Created on : 16/01/2018, 14:53:23
    Author     : PriscilaRicardoArrud
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaBean"%>
<%@page import="java.util.List"%>
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
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar mb-5">
            <h1 class="navbar-brand mr-0 mr-md-2 logo"><span class="logo-ibm">IBM </span>Employment Control</h1>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./ConsultaServlet">Consultar Vagas</a>
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
                    <h2 class="title mb-3">Vagas Cadastradas</h2>
                    <hr>                
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Status</th>
                                <th>PMP</th>
                                <th>Expectativa de Entrada</th>
                                <th>Área</th>
                                <th>Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<VagaBean> listaDeVagas = (List<VagaBean>) request.getAttribute("listaVagas");
                                int i = 0;
                                for (VagaBean v : listaDeVagas) {
                                    i++;
                            %>

                            <tr>
                                <td><%= v.getStatus()%></td>
                                <td><%= v.getPmp()%></td>
                                <td><%= v.getExpectativaDeEntrada()%></td>
                                <td><%= v.getArea()%></td>
                                <td>
                                    <button
                                        class="btn btn-primary"
                                        type="button"
                                        data-toggle="collapse"
                                        data-target="#vaga-<%= i%>"
                                        aria-expanded="false"
                                        aria-controls="vaga-<%= i%>">
                                        +
                                    </button>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse" id="vaga-<%= i%>">
                                <td colspan="5">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value"><%= v.getCategoria()%></span> 
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tecnologia: </strong></span><span class="vaga-value"><%= v.getTecnologia()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Data de Abertura: </strong></span><span class="vaga-value"><%= v.getDataDeAbertura()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value"><%= v.getTipo()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value"><%= v.getBanda()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value"><%= v.getDetalhe()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value"><%= v.getAprovacaoBoardBrasil()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value"><%= v.getAprovacaoBoardGlobal()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value"><%= v.getEntrouNaOperacao()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value"><%= v.getProfissionalSelecionado()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value"><%= v.getRate()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value"><%= v.getImpactoFinanceiro()%></span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value"><%= v.getComentario()%></span>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <% }%>
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
