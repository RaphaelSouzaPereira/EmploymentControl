<%-- 
    Document   : index.jsp
    Created on : 16/01/2018, 14:53:23
    Author     : PriscilaRicardoArrud
--%>

<%@page import="com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaBean"%>
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
        <title>Home</title>
    </head>
    <body>
        <jsp:include page = "html/header.html" />
        <div class="container">
            <div class="row">
                <div class="offset-1 col-10">
                    <h2 class="title mb-3">Consultar Cadastradas</h2>
                    <hr>
                    <form class="consulta-vagas" action="" method="post">
                        <div class="form-row mb-4">
                            <div class="form-group col-3">
                                <label for="inputStatus">Área:</label>
                                <select id="inputAreaConsulta" class="form-control" name="area-consulta">
                                    <option>Arquitetura</option>
                                    <option selected>Canais</option>
                                    <option>Digital</option>
                                    <option>Especial</option>
                                    <option>Suporte</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputStatus">Status:</label>
                                <select id="inputStatusConsulta" class="form-control" name="status-consulta">
                                    <option selected>Open</option>
                                    <option>Closed</option>
                                    <option>On hold</option>
                                    <option>Cancelada</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label for="inputStatus">Tecnologia:</label>
                                <select id="inputTecnologiaConsulta" class="form-control" name="status-consulta">
                                    <option>Java</option>
                                    <!--TODO - Tratar acentuacao-->
                                    <option>Analista de Automacao</option>
                                    <option>Especialista Mobilidade</option>
                                    <option>Designer UX</option>
                                    <option>Dev. ODI</option>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <button type="submit" class="btn btn-ibmec btn-block" id="btn-consulta-vaga" style="margin-top:32px">Consultar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="offset-1 col-10">
                    <h2 class="title mb-3">Vagas Cadastradas</h2>
                    <hr>
                    <table class="table table-bordered list-table-ibmec">
                        <thead class="list-thead-ibmec">
                            <tr class="list-ibmec">
                                <th>Status</th>
                                <th>PMP</th>
                                <th>Tecnologia</th>
                                <th>Área</th>
                                <th>Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  List<VagaBean> listaDeVagas = (List<VagaBean>) request.getAttribute("listaVagas");
                                for (VagaBean v : listaDeVagas) {%>

                            <tr class="list-row-ibmec">
                                <td><%= v.getStatus()%></td>
                                <td><%= v.getPmp()%></td>
                                <td><%= v.getTecnologia()%></td>
                                <td><%= v.getArea()%></td>
                                <td>
                                    <span
                                        data-toggle="tooltip"
                                        data-placement="top"
                                        title="Mais detalhes">
                                        <a
                                            class="btn btn-ibmec"
                                            data-toggle="collapse"                                        
                                            href="#vaga-<%= v.getId()%>"
                                            role="button"
                                            aria-expanded="false"
                                            aria-controls="#vaga-<%= v.getId()%>"
                                            >
                                            <i class="material-icons">expand_more</i>
                                        </a>
                                    </span>
                                    <span
                                        data-toggle="tooltip"
                                        data-placement="bottom"
                                        title="Editar vaga">
                                        <a
                                            class="btn btn-ibmec"
                                            data-toggle="collapse"
                                            href="#atualizar_vaga-<%= v.getId()%>"
                                            role="button"
                                            aria-expanded="false"
                                            aria-controls="#atualizar_vaga-<%= v.getId()%>"
                                            >
                                            <i class="material-icons">mode_edit</i>
                                        </a>
                                    </span>
                                    <span
                                        data-toggle="tooltip"
                                        data-placement="rigt"
                                        title="Vincular candidato">
                                        <a
                                            class="btn btn-ibmec"
                                            data-toggle="collapse"
                                            href="#incluir_candidato-<%= v.getId()%>"
                                            role="button"
                                            aria-expanded="false"
                                            aria-controls="#incluir_candidato-<%= v.getId()%>"
                                            >
                                            <i class="material-icons">person_add</i>
                                        </a>
                                    </span>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse list-row-content-ibmec" id="vaga-<%= v.getId()%>">
                                <td colspan="5">
                                    <div class="row">
                                        <div class="col-6">
                                            <ul class="list-group">
                                                <li class="list-group-item">
                                                    <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value"><%= v.getCategoria()%></span> 
                                                </li>
                                                <li class="list-group-item">
                                                    <span class="vaga-item"><strong>Expectativa de Entrada: </strong></span><span class="vaga-value"><%= v.getExpectativaDeEntrada()%></span>
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
                                            </ul>
                                        </div>
                                        <div class="col-6">
                                            <ul class="list-group">
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
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse list-row-content-ibmec" id="atualizar_vaga-<%= v.getId()%>">
                                <td colspan="5" class="edit-light-grey">                                  
                                    <form class="atualizar-vaga" action="./AtualizacaoServlet" method="post">
                                        <div class="form-row">
                                            <div class="form-group d-none">
                                                <input value="<%= v.getId()%>" type="hidden" class="form-control" id="inputIdVaga" name="id_vaga">
                                            </div>
                                            <div class="form-group col-3">
                                                <label for="inputCategoria">Categoria:</label>
                                                <select id="inputCategoria" class="form-control" name="categoria" required>
                                                    <option value="<%=v.getCategoria()%>"><%=v.getCategoria()%></option>
                                                    <option>Regular</option>
                                                    <option>BTP</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-3">
                                                <label for="inputStatus">Status:</label>
                                                <select id="inputStatus" class="form-control" name="status">
                                                    <option value="<%=v.getStatus()%>"><%=v.getStatus()%></option>
                                                    <option>Open</option>
                                                    <option>Closed</option>
                                                    <option>On hold</option>
                                                    <option>Cancelada</option>
                                                </select>
                                            </div>
                                            <div class="form-group col-3">
                                                <label for="inputDtAbertura">Data Abertura:</label>
                                                <input value="<%=v.getDataDeAbertura()%>" type="date" class="form-control" id="inputDtAbertura" name="data_abertura" required>
                                            </div>
                                            <div class="form-group col-3">
                                                <label for="inputArea">Área:</label>
                                                <select id="inputArea" class="form-control" name="area" required>
                                                    <option value="<%=v.getArea()%>"><%=v.getArea()%></option>
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
                                                    <option value="<%=v.getTecnologia()%>"><%=v.getTecnologia()%></option>
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
                                                <input value="<%=v.getExpectativaDeEntrada()%>" type="date" class="form-control" id="inputDtExpecEntrada" name="data_exp_entrada" required>
                                            </div>
                                            <div class="form-group col-4">
                                                <label for="inputTipo">Tipo:</label>
                                                <select id="inputTipo" class="form-control" name="tipo" required>
                                                    <option value="<%=v.getTipo()%>"><%=v.getTipo()%></option>
                                                    <option>Backfill</option>
                                                    <option>Growth</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-4">
                                                <label for="inputBanda">Banda:</label>
                                                <select id="inputBanda" class="form-control" name="banda" required>
                                                    <option value="<%=v.getBanda()%>"><%=v.getBanda()%></option>
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
                                                <input value="<%=v.getRate()%>" type="text" class="form-control inputRate" id="inputRate" placeholder="Rate(R$)" name="rate" maxlength="6">
                                            </div>   
                                            <div class="form-group col-4">
                                                <label for="inputPmp">PMP:</label>
                                                <input value="<%=v.getPmp()%>" type="text" class="form-control" id="inputPmp" placeholder="Número PMP" name="pmp">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-12">
                                                <label for="inputDetalhe">Detalhe:</label>
                                                <textarea class="form-control" id="inputDetalhe" rows="3" name="detalhe"><%=v.getDetalhe()%></textarea>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-4">
                                                <label for="inputDtAprovaBrasil">Aprovação Board Brasil:</label>
                                                <input value="<%=v.getAprovacaoBoardBrasil()%>" type="date" class="form-control" id="inputDtAprovaBrasil" name="aprovacao_board_brasil">
                                            </div>
                                            <div class="form-group col-4">
                                                <label for="inputDtAprovaGlobal">Aprovação Board Global:</label>
                                                <input value="<%=v.getAprovacaoBoardGlobal()%>" type="date" class="form-control" id="inputDtAprovaGlobal" name="aprovacao_board_global">
                                            </div>
                                            <div class="form-group col-4">
                                                <label for="inputDtEntrouOperac">Entrou na Operação:</label>
                                                <input value="<%=v.getEntrouNaOperacao()%>" type="date" class="form-control" id="inputDtEntrouOperac" name="entrou_operacao">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-12">
                                                <label for="inputComentario">Comentários:</label>
                                                <input value="<%=v.getComentario()%>" type="text" class="form-control" id="inputComentario" placeholder="Comentários" name="comentarios">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-ibmec" id="btn-editar-vaga">Salvar</button>                            
                                        </div>
                                        </div>
                                    </form>

                                </td>                            
                            </tr>
                            <tr class="collapse multi-collapse list-row-content-ibmec" id="incluir_candidato-<%= v.getId()%>">
                                <%  List<CandidatoBean> listaDeCandidatos = (List<CandidatoBean>) request.getAttribute("listaCandidatos");
                                %>
                                <td colspan="5" class="edit-light-grey">                        
                                    <form class="atualizar-vaga" action="./VinculaCandidatoServlet" method="post">                                        
                                        <div class="form-row">
                                            <div class="form-group col-4">
                                                <label for="inputFiltro">Filtro:</label>
                                                <input value="" type="text" class="form-control" id="inputFiltro" placeholder="Filtro pesquisa" name="filtro">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-4">
                                                <select id="candidatosAll" class="form-control" multiple="multiple" size="5">
                                                    <%  for (CandidatoBean c : listaDeCandidatos) {%>
                                                    <option> <%= c.getNome()%> </option>
                                                    <% }%>
                                                </select>
                                            </div>
                                            <div class="form-group col-3">
                                                <input type="button" class="btn btn-ibmec btn-block" id="vincula" value="Vincular" />
                                                <input type="button" class="btn btn-ibmec btn-block" id="desvincula" value="Desvincular" />
                                            </div>
                                            <div class="form-group col-4">
                                                <select id="candidatosVaga" class="form-control" multiple="multiple" size="5">

                                                </select>
                                            </div>
                                        </div>
                                    </form>                                   

                                </td>
                            </tr>
                            <% }%>       
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page = "html/footer.html" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.13/jquery.mask.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
        <script src="js/script.js"></script>
    </body>
</html>
