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
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar mb-5">
            <h1 class="navbar-brand mr-0 mr-md-2 logo"><span class="logo-ibm">IBM </span>Employment Control</h1>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./cadastro-vagas.jsp">Cadastrar Vagas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./cadastro-candidato.jsp">Cadastrar Candidato</a>
                </li>
            </ul>
        </header>
        <div class="container">
            <div class="row">
                <div class="offset-1 col-10">
                    <h2 class="title mb-3">Cadastro de Vagas</h2>
                    <hr>                   
                    <form class="cadastra-vagas" action="./ControlServlet" method="post" onchange="validaCamposDeCadastroDeVagas()">
                        <div class="form-row">
                            <div class="form-group col-3">
                                <label for="inputCategoria">Categoria:</label>
                                <select id="inputCategoria" class="form-control" name="categoria" required>
                                    <!-- TODO: pegar valores de um Enum? Ou deixamos chumbado aqui? -->
                                    <option value="">Selecione...</option>
                                    <option>Regular</option>
                                    <option>BTP</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputStatus">Status:</label>
                                <select id="inputStatus" class="form-control" name="status">
                                    <!-- TODO: pegar valores do Enum? Ou deixamos chumbado aqui? -->
                                    <option selected>Open</option>
                                    <option>Closed</option>
                                    <option>On hold</option>
                                    <option>Cancelada</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputDtAbertura">Data Abertura:</label>
                                <input type="date" class="form-control" id="inputDtAbertura" name="data_abertura" required>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputArea">Área:</label>
                                <select id="inputArea" class="form-control" name="area" required>
                                    <option value="">Selecione...</option>
                                    <!-- TODO: pegar valores do Enum? Ou deixamos chumbado aqui? -->
                                    <option>Arquitetura</option>
                                    <option>Canais</option>
                                    <option>Digital</option>
                                    <option>Especial</option>
                                    <option>Suporte</option>
                                    <option>CRM</option>
                                    <option>Legado</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-4">
                                <label for="inputTec">Tecnologia:</label>
                                <select id="inputTec" class="form-control" name="tecnologia" required>
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
                                <input type="date" class="form-control" id="inputDtExpecEntrada" name="data_exp_entrada" required>
                            </div>
                            <div class="form-group col-4">
                                <label for="inputTipo">Tipo:</label>
                                <select id="inputTipo" class="form-control" name="tipo" required>
                                    <option value="">Selecione...</option>
                                    <option>Backfill</option>
                                    <option>Growth</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-4">
                                <label for="inputBanda">Banda:</label>
                                <select id="inputBanda" class="form-control" name="banda" required>
                                    <option value="">Selecione...</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                </select>
                            </div>
                            <div class="form-group col-4">
                                <label for="inpuRate">Rate(R$):</label>
                                <input type="text" class="form-control inputRate" id="inputRate" placeholder="Rate(R$)" name="rate" maxlength="6">
                            </div>   
                            <div class="form-group col-4">
                                <label for="inputPmp">PMP:</label>
                                <input type="text" class="form-control" id="inputPmp" placeholder="Número PMP" name="pmp">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="inputDetalhe">Detalhe:</label>
                                <textarea class="form-control" id="inputDetalhe" rows="3" name="detalhe"></textarea>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-4">
                                <label for="inputDtAprovaBrasil">Aprovação Board Brasil:</label>
                                <input type="date" class="form-control" id="inputDtAprovaBrasil" name="aprovacao_board_brasil">
                            </div>
                            <div class="form-group col-4">
                                <label for="inputDtAprovaGlobal">Aprovação Board Global:</label>
                                <input type="date" class="form-control" id="inputDtAprovaGlobal" name="aprovacao_board_global">
                            </div>
                            <div class="form-group col-4">
                                <label for="inputDtEntrouOperac">Entrou na Operação:</label>
                                <input type="date" class="form-control" id="inputDtEntrouOperac" name="entrou_operacao">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="inputComentario">Comentários:</label>
                                <input type="text" class="form-control" id="inputComentario" placeholder="Comentários" name="comentarios">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" id="btn-salvar-cadastro" disabled>Salvar</button>                            
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
                                    <button type="button" class="btn btn-primary" data-dismiss="modal" 
                                            onClick="redireciona('./')">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.13/jquery.mask.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>