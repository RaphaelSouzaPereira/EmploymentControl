<%-- 
    Document   : cadastro.jsp
    Created on : 16/01/2018, 15:09:31
    Author     : PriscilaRicardoArrud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Cadastro de Vagas</title>
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
                    <!-- TODO: Ajustar o action do form para a camada de inserção no banco -->
                    <form class="cadastra-vagas">
                        <div class="form-row">
                            <div class="form-group col-3">
                                <label for="inputCategoria">Categoria:</label>
                                <select id="inputCategoria" class="form-control" required>
                                    <!-- TODO: pegar valores de um Enum? Ou deixamos chumbado aqui? -->
                                    <option value="">Selecione...</option>
                                    <option>Regular</option>
                                    <option>BTP</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputStatus">Status:</label>
                                <select id="inputStatus" class="form-control">
                                    <!-- TODO: pegar valores do Enum? Ou deixamos chumbado aqui? -->
                                    <option>Open</option>
                                    <option>Closed</option>
                                    <option selected>On hold</option>
                                    <option>Cancelada</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputDtAbertura">Data Abertura:</label>
                                <input type="date" class="form-control" id="inputDtAbertura" required>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputArea">Área:</label>
                                <select id="inputArea" class="form-control" required>
                                    <option value="">Selecione...</option>
                                    <!-- TODO: pegar valores do Enum? Ou deixamos chumbado aqui? -->
                                    <option>Arquitetura</option>
                                    <option>Canais</option>
                                    <option>Digital</option>
                                    <option>Especial</option>
                                    <option>Suporte</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-4">
                                <label for="inputTec">Tecnologia:</label>
                                <select id="inputTec" class="form-control" required>
                                    <option value="">Selecione...</option>
                                    <!-- TODO: pegar valores da tabela Tecnologia -->
                                    <option>Java</option>
                                    <option>Analista de Automação</option>
                                    <option>Especialista Mobilidade</option>
                                    <option>Designer UX</option>
                                    <option>Dev. ODI</option>
                                    <option>...</option>
                                </select>
                            </div>

                            <div class="form-group col-4">
                                <label for="inputDtExpecEntrada">Expectativa Entrada:</label>
                                <input type="date" class="form-control" id="inputDtExpecEntrada" required>
                            </div>

                            <div class="form-group col-4">
                                <label for="inputTipo">Tipo:</label>
                                <select id="inputTipo" class="form-control" required>
                                    <option value="">Selecione...</option>
                                    <option>Backfill</option>
                                    <option>Growth</option>
                                </select>
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="form-group col-3">
                                <label for="inputBanda">Banda:</label>
                                <input type="text" class="form-control" id="inputBanda" required>
                            </div>
                            <div class="form-group col-9">
                                <label for="inputDetalhe">Detalhe:</label>
                                <input type="text" class="form-control" id="inputDetalhe" placeholder="Detalhes da vaga" required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-3">
                                <label for="inputPmp">PMP:</label>
                                <input type="text" class="form-control" id="inputPmp" placeholder="Número PMP">
                            </div>
                            <div class="form-group col-3">
                                <label for="inputDtAprovaBrasil">Aprovação Board Brasil:</label>
                                <input type="date" class="form-control" id="inputDtAprovaBrasil">
                            </div>
                            <div class="form-group col-3">
                                <label for="inputDtAprovaGlobal">Aprovação Board Global:</label>
                                <input type="date" class="form-control" id="inputDtAprovaGlobal">
                            </div>
                            <div class="form-group col-3">
                                <label for="inputDtEntrouOperac">Entrou na Operação:</label>
                                <input type="date" class="form-control" id="inputDtEntrouOperac">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-7">
                                <label for="inputProfSel">Profissional selecionado:</label>
                                <!-- TODO: Substituir por um Select com dados da tabela Candidatos -->
                                <input type="text" class="form-control" id="inputProfSel" placeholder="Nome do Profissional">
                            </div>
                            <div class="form-group col-2">
                                <label for="inpuRate">Rate:</label>
                                <input type="number" min="1" step="any" class="form-control" id="inputRate" placeholder="Rate">
                            </div>
                            <div class="form-group col-3">
                                <label for="inputImpacto">Impacto Financeiro:</label>
                                <input type="number" min="1" step="any" class="form-control" id="inputImpacto" placeholder="Impacto">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="inputComentario">Comentários:</label>
                                <input type="text" class="form-control" id="inputComentario" placeholder="Comentários">
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <!-- TODO: Ajustar o botão Cancelar -->
                            <button type="button" class="btn btn-default" id="reset" data-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
</body>
</html>
