<%-- 
    Document   : editar-candidato
    Created on : Feb 8, 2018, 12:27:16 PM
    Author     : Diego Cansi Matte <diego.cansi at ibm.com>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Alterar Candidato</title>
    </head>
       <%  //validacão momentanea para testes
            String validacaoUser = "usuario01";
            String validacaoPass = "1234";
            
            String login = (String) request.getSession().getAttribute("usuarioLogado");
            
            if (login != null && login.equals(validacaoUser)) {
                request.getSession().setAttribute("usuarioLogado", login);
        %>
    <jsp:include page = "include/header.jsp" />
    <div class="container">
        <div class="row"> <!---------- Vagas Cadastradas - Início ---------->
            <div class="col-md-12">
                <h2 class="title mb-3 offset-xs-1">Candidatos Cadastrados</h2>
                <div class="table-responsive">
                    <hr>
                    <table class="table table-bordered list-table-ibmec">
                        <thead class="list-thead-ibmec"> <!---------- Candidatos Cadastrados - Head da tabela - Início ---------->
                            <tr class="list-ibmec">
                                <th>Nome</th>
                                <th>E-mail</th>
                                <th>Editar</th>
                            </tr>
                        </thead> <!---------- Candidatos Cdastrados - Cabeçalho da tabela - Fim ---------->
                        <tbody>  <!---------- Candidatos Cadastrados - Corpo da tabela - Início ---------->
                            <%  ArrayList<CandidatoBean> listaDeCandidatos = (ArrayList<CandidatoBean>) request.getAttribute("listaCandidatosCompletos");
                            %>
                            <%
                            for (CandidatoBean c : listaDeCandidatos) {%>
                            <!---------- Candidatos Cadastrados - For da Lista de Candidatos - Início ---------->
                            <tr class="list-row-ibmec">
                                <td><%= c.getNome()%></td>
                                <td><%= c.getEmail()%></td>   
                                <td class="text-center"> <!---------- Candidatos Cadastrados - Botões das Opções - Início ---------->
                                    <span
                                        data-toggle="tooltip"
                                        data-placement="top"
                                        title="Editar candidato">
                                        <a
                                            class="btn btn-ibmec"
                                            data-toggle="collapse"                                        
                                            href="#editar_candidato-<%= c.getId()%>"
                                            role="button"
                                            aria-expanded="false"
                                            aria-controls="#editar_candidato-<%= c.getId()%>"
                                            >
                                            <i class="material-icons">mode_edit</i>
                                        </a>
                                    </span>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse list-row-content-ibmec"
                                id="editar_candidato-<%= c.getId()%>"
                                data-toggle="collapse">
                                <td colspan="5" class="edit-light-grey">
                                    <div class="row">
                                        <div class="col-6">
                                            <form class="atualizar-candidato" id="atualizar-candidato-form" action="./AtualizarCandidatoServlet" method="post" onchange="validaCamposDeCadastroDeCandidatos()">
                                                <div class="form-row">
                                                    <div class="form-group d-none">
                                                        <input value="<%= c.getId()%>" type="hidden" class="form-control" id="inputIdCandidato" name="id_candidato">
                                                    </div>
                                                    <div class="form-group col-xs-12 col-md-4">
                                                        <label for="inputNome">Nome:</label>
                                                        <input value="<%=c.getNome()%>" type="text" class="form-control" id="inputNome" placeholder="Nome" name="nome">
                                                    </div>   
                                                    <div class="form-group col-xs-12 col-md-4">
                                                        <label for="inputEmail">E-mail:</label>
                                                        <input value="<%=c.getEmail()%>" type="text" class="form-control" id="inputEmail" placeholder="E-mail" name="email">
                                                    </div>
                                                    <div class="form-group col-xs-12 col-md-9 text-xs-center">
                                                        <button type="submit" class="btn btn-ibmec" id="btn-editar-candidato">Salvar</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <jsp:include page = "include/footer.jsp" />
        <%} else {
                RequestDispatcher view = request.getRequestDispatcher("./login.jsp");
                view.forward(request, response);
            }
        %>
    
</html>
