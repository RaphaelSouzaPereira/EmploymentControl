<%-- 
    Document   : cadastro-candidato
    Created on : Jan 22, 2018, 12:04:03 PM
    Author     : Raphael de Souza Pereira <raphael.pereira@ibm.com>
--%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Cadastro de Candidatos</title>
    </head>
    <body>
        <jsp:include page = "include/header.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="ibmec-title mb-3">Cadastro de Candidatos</h2>
                    <hr>
                    <form class="cadastra-candidatos" action="./CandidatoServlet" method="post" onchange="validaCamposDeCadastroDeCandidatos()">
                        <div class="form-group col-xs-12 col-md-9">
                            <label for="inputNome">Nome:</label>
                            <input type="text" class="form-control" id="inputNome" placeholder="Nome do candidato" name="nomeCandidato" required>
                        </div>
                        <div class="form-group col-xs-12 col-md-9">
                            <label for="inputEmail">E-mail:</label>
                            <input type="email" class="form-control" id="inputEmail" placeholder="E-mail do candidato" name="emailCandidato" required>
                        </div>
                        <div class="form-group col-xs-12 col-md-9">
                            <button type="submit" class="btn ibmec-btn" id="btn-salvar-candidato" disabled>Salvar</button>
                            <button type="button" class="btn btn-default" id="reset" data-toggle="modal" data-target="#myModal">Cancelar</button>
                        </div>
                    </form>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Tem certeza?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Esta ação irá descartar os dados do formulário.</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn ibmec-btn" data-dismiss="modal" 
                                            onClick="redireciona('./')">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                                </div>
                            </div>
                        </div>
                    </div>
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