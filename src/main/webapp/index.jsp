<%-- 
    Document   : index.jsp
    Created on : 16/01/2018, 14:53:23
    Author     : PriscilaRicardoArrud
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Locale"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.dao.VagaAudDAO"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaAudBean"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Home</title>
    </head>
    <body>
        <%  //validacão momentanea para testes
            String validacaoUser = "usuario01";
            String validacaoPass = "1234";
            
            String login = (String) request.getSession().getAttribute("usuarioLogado");
            
            if (login != null && login.equals(validacaoUser)) {
                request.getSession().setAttribute("usuarioLogado", login);
        %>
        <jsp:include page = "include/header.jsp" />
        <div class="container"> <!---------- Container - Início ---------->
            <div class="panel-group" id="accordion">
                <!---------- Consulta de Vagas - Início ---------->
                <%
                    String currentFilter = (String) session.getAttribute("currentFilter");
                    String currentArea = (String) session.getAttribute("currentArea");
                    String currentStatus = (String) session.getAttribute("currentStatus");
                    String currentTechnology = (String) session.getAttribute("currentTechnology");
                %>
                <div class="row">
                    <div class="col-12">
                        <h2 class="ibmec-title mb-3">Consultar Vagas Cadastradas</h2>
                        <hr>
                        <h3 class="mb-3 ibmec-subtitle">Filtrar por...</h2>
                            <form class="consulta-vagas" action="./" method="post">
                                <div class="form-row mb-4">
                                    <div class="form-group col-xs-12 col-md-12">
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="OpenAndOnHoldOption" name="sf" class="custom-control-input" value="Status Open e On Hold" <%= currentFilter.equals("Status Open e On Hold") ? "checked" : ""%>>
                                            <label class="custom-control-label" for="OpenAndOnHoldOption">Status Open e On Hold</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">

                                            <input type="radio" id="AreaOption" name="sf" class="custom-control-input" value="Area" <%= currentFilter.equals("Area") ? "checked" : ""%>>
                                            <label class="custom-control-label" for="AreaOption">Area</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="StatusOption" name="sf" class="custom-control-input" value="Status" <%= currentFilter.equals("Status") ? "checked" : ""%>>
                                            <label class="custom-control-label" for="StatusOption">Status</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="TecnologiaOption" name="sf" class="custom-control-input" value="Tecnologia" <%= currentFilter.equals("Tecnologia") ? "checked" : ""%>>
                                            <label class="custom-control-label" for="TecnologiaOption">Tecnologia</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="AllOptions" name="sf" class="custom-control-input" value="Area, Status e Tecnologia" <%= currentFilter.equals("Area, Status e Tecnologia") ? "checked" : ""%>>
                                            <label class="custom-control-label" for="AllOptions">Area, Status e Tecnologia</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row mb-4">
                                    <div class="form-group col-xs-12 col-md-3">
                                        <label for="inputStatus">Área:</label>
                                        <select id="inputAreaConsulta" class="form-control" name="sa">
                                            <option <%= currentArea.equals("Arquitetura") ? "selected" : ""%>>Arquitetura</option>
                                            <option <%= currentArea.equals("Canais") ? "selected" : ""%>>Canais</option>
                                            <option <%= currentArea.equals("Digital") ? "selected" : ""%>>Digital</option>
                                            <option <%= currentArea.equals("Especial") ? "selected" : ""%>>Especial</option>
                                            <option <%= currentArea.equals("Suporte") ? "selected" : ""%>>Suporte</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-xs-12 col-md-3">
                                        <label for="inputStatus">Status:</label>
                                        <select id="inputStatusConsulta" class="form-control" name="ss">
                                            <option <%= currentStatus.equals("Open") ? "selected" : ""%>>Open</option>
                                            <option <%= currentStatus.equals("Closed") ? "selected" : ""%>>Closed</option>
                                            <option <%= currentStatus.equals("On hold") ? "selected" : ""%>>On hold</option>
                                            <option <%= currentStatus.equals("Cancelada") ? "selected" : ""%>>Cancelada</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-xs-12 col-md-3">
                                        <label for="inputStatus">Tecnologia:</label>
                                        <select id="inputTecnologiaConsulta" class="form-control" name="st">
                                            <option <%= currentTechnology.equals("Java") ? "selected" : ""%>>Java</option>
                                            <!--TODO - Tratar acentuacao-->
                                            <option <%= currentTechnology.equals("Analista de Automacao") ? "selected" : ""%>>Analista de Automação</option>
                                            <option <%= currentTechnology.equals("Especialista Mobilidade") ? "selected" : ""%>>Especialista Mobilidade</option>
                                            <option <%= currentTechnology.equals("Designer UX") ? "selected" : ""%>>Designer UX</option>
                                            <option <%= currentTechnology.equals("Dev. ODI") ? "selected" : ""%>>Dev. ODI</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-xs-12 col-md-3">
                                        <button type="submit" class="btn btn-block ibmec-btn" style="margin-top:32px" name="botao-de-consulta" value="Consultar">Consultar</button>
                                    </div>
                                </div>
                            </form>
                    </div>
                </div>
                <!---------- Consulta de Vagas - Fim ---------->
                <div class="row"> <!---------- Vagas Cadastradas - Início ---------->
                    <div class="col-md-9">
                        <h2 class="ibmec-title my-2">Vagas Filtradas</h2>
                    </div>
                    <div class="col-xs-12 offset-xs-1 col-md-3 pl-md-0">
                        <a href="./VacancyReport?rf=<%=currentFilter%>&ra=<%=currentArea%>&rs=<%=currentStatus%>&rt=<%=currentTechnology%>" class="btn btn-block ibmec-btn">Gerar Relatório de Vagas</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <hr>
                            <table class="table table-bordered list-table-ibmec">
                                <thead class="list-thead-ibmec"> <!---------- Vagas Cadastradas - Head da tabela - Início ---------->
                                    <tr class="list-ibmec">
                                        <th>Status</th>
                                        <th>PMP</th>
                                        <th>Área</th>
                                        <th>Tecnologia</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead> <!---------- Vagas Cadastradas - Cabeçalho da tabela - Fim ---------->
                                <!------ Vagas Cadastradas - Corpo da tabela - Início ---------->
                                <%
                                    List<VagaBean> listaDeVagasPorPagina = (List<VagaBean>) session.getAttribute("listaDeVagasPorPagina");
                                    for (VagaBean v : listaDeVagasPorPagina) {%> <!---------- Vagas Cadastradas - For da Lista de Vagas - Início ---------->

                                <% Object expectativaDeEntrada = request.getAttribute("expectativaDeEntrada" + v.getId()); %>
                                <% Object desdeAberturaEntrouNaOperacao = request.getAttribute("desdeAberturaEntrouNaOperacao" + v.getId()); %>
                                <% Object desdeAberturaGlobal = request.getAttribute("desdeAberturaGlobal" + v.getId()); %>
                                <% Object desdeAberturaBrasil = request.getAttribute("desdeAberturaBrasil" + v.getId()); %>
                                <% Object impactoFinanceiro = request.getAttribute("impactoFinanceiro" + v.getId()); %>
                                <% Object expectativaVsAbertura = request.getAttribute("expectativaVsAbertura" + v.getId());%>
                                <% VagaAudDAO vagaAudDAO;%>

                                <tr class="list-row-ibmec"> 
                                    <td><%= v.getStatus()%></td>
                                    <td><%= v.getPmp()%></td>
                                    <td><%= v.getArea()%></td>
                                    <td><%= v.getTecnologia()%></td>
                                    <td class="text-center"> <!---------- Vagas Cadastradas - Botões das Opções - Início ---------->
                                        <span
                                            data-toggle="tooltip"
                                            data-placement="top"
                                            title="Mais detalhes">
                                            <a
                                                class="btn ibmec-btn"
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
                                                class="btn ibmec-btn"
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
                                                class="btn ibmec-btn"
                                                data-toggle="collapse"
                                                href="#incluir_candidato-<%= v.getId()%>"
                                                role="button"
                                                aria-expanded="false"
                                                aria-controls="#incluir_candidato-<%= v.getId()%>"
                                                >
                                                <i class="material-icons">person_add</i>
                                            </a>
                                        </span>
                                        <span
                                            data-toggle="tooltip"
                                            data-placement="rigt"
                                            title="Listar Histórico">
                                            <a
                                                class="btn ibmec-btn"
                                                data-toggle="collapse"
                                                href="#listar-historico-<%= v.getId()%>"
                                                role="button"
                                                aria-expanded="false"
                                                aria-controls="#listar-historico-<%= v.getId()%>"
                                                >
                                                <i class="material-icons">description</i>
                                            </a>
                                        </span>                                       
                                    </td> <!---------- Vagas Cadastradas - Botões das Opções - Fim ----------> 
                                </tr>
                                <tr 
                                    class="collapse multi-collapse list-row-content-ibmec"
                                    id="vaga-<%= v.getId()%>"
                                    data-toggle="collapse"
                                    data-parent="#accordion"
                                    > <!---------- Vagas Cadastradas - Mais Detalhes da Vaga - Início ---------->                 
                                    <td colspan="5">  
                                        <div class="row">
                                            <div class="col-6">
                                                <ul class="list-group">
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value"><%= v.getCategoria()%></span> 
                                                    </li>  
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value"><%= v.getTipo()%></span>
                                                    </li> 
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value"><%= v.getBanda()%></span>
                                                    </li>                                                 
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Data de Abertura da Vaga: </strong></span><span class="vaga-value"><%= v.getDataDeAbertura()%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Expectativa de Entrada: </strong></span><span class="vaga-value"><%= v.getExpectativaDeEntrada()%></span>
                                                    </li> 
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Expectativa / Abertura: </strong></span><span class="vaga-value"><%= expectativaVsAbertura%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value"><%= v.getRate()%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value"><%= v.getAprovacaoBoardBrasil() == null ? "" : v.getAprovacaoBoardBrasil()%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value"><%= v.getAprovacaoBoardGlobal() == null ? "" : v.getAprovacaoBoardGlobal()%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value"><%= v.getDetalhe()%></span>
                                                    </li>                                                        
                                                </ul>
                                            </div>
                                            <div class="col-6">
                                                <ul class="list-group"> 
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value"><%= v.getProfissionalSelecionado() == null ? "" : v.getProfissionalSelecionado()%></span>
                                                    </li>    
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value"><%= v.getEntrouNaOperacao() == null ? "" : v.getEntrouNaOperacao()%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Desde Expectativa: </strong></span><span class="vaga-value"><%= expectativaDeEntrada%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Desde Abertura (Brasil): </strong></span><span class="vaga-value"><%= desdeAberturaBrasil%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Desde Abertura (Global): </strong></span><span class="vaga-value"><%= desdeAberturaGlobal%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Desde Abertura (Operação): </strong></span><span class="vaga-value"><%= desdeAberturaEntrouNaOperacao%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value"><%= impactoFinanceiro%></span>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value"><%= v.getComentario()%></span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </td>
                                </tr> <!---------- Vagas Cadastradas - Mais Detalhes da Vaga - Fim ---------->
                                <tr
                                    class="collapse multi-collapse list-row-content-ibmec"
                                    id="atualizar_vaga-<%= v.getId()%>"
                                    data-toggle="collapse"
                                    data-parent="#accordion"
                                    > <!---------- Vagas Cadastradas - Editar Vaga - Início ----------> 
                                    <td colspan="5" class="edit-light-grey">                                  
                                        <form class="atualizar-vaga-form" action="./AtualizacaoServlet" method="post">
                                            <div class="form-row">
                                                <div class="form-group d-none">
                                                    <input value="<%= v.getId()%>" type="hidden" class="form-control" id="inputIdVaga" name="id_vaga">
                                                    <input value="<%=impactoFinanceiro%>" type="hidden" class="form-control" id="inputImpactoFinanceiro" name="id_ImpactoFinanceiro">
                                                </div>
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <label for="inputCategoria">Categoria:</label>
                                                    <select id="inputCategoria" class="form-control" name="categoria" required>
                                                        <option value="<%=v.getCategoria()%>"><%=v.getCategoria()%></option>
                                                        <option>Regular</option>
                                                        <option>BTP</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <label for="inputStatus">Status:</label>
                                                    <select id="inputStatus" class="form-control" name="status">
                                                        <option value="<%=v.getStatus()%>"><%=v.getStatus()%></option>
                                                        <option>Open</option>
                                                        <option>Closed</option>
                                                        <option>On hold</option>
                                                        <option>Cancelada</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <label for="inputDtAbertura">Data Abertura:</label>
                                                    <input value="<%=v.getDataDeAbertura()%>" type="date" class="form-control" id="inputDtAbertura" name="data_abertura" required>
                                                </div>
                                                <div class="form-group col-xs-12 col-md-3">
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
                                                <div class="form-group col-xs-12 col-md-4">
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
                                                <div class="form-group col-xs-12 col-md-4">
                                                    <label for="inputDtExpecEntrada">Expectativa Entrada:</label>
                                                    <input value="<%=v.getExpectativaDeEntrada()%>" type="date" class="form-control" id="inputDtExpecEntrada" name="data_exp_entrada" required>
                                                </div>
                                                <div class="form-group col-xs-12 col-md-4">
                                                    <label for="inputTipo">Tipo:</label>
                                                    <select id="inputTipo" class="form-control" name="tipo" required>
                                                        <option value="<%=v.getTipo()%>"><%=v.getTipo()%></option>
                                                        <option>Backfill</option>
                                                        <option>Growth</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-xs-12 col-md-3">
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
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <label for="inpuRate">Rate(R$):</label>
                                                    <input value="<%=v.getRate()%>" type="text" class="form-control inputRate" id="inputRate" placeholder="Rate(R$)" name="rate" maxlength="6">
                                                </div>   
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <label for="inputPmp">PMP:</label>
                                                    <input value="<%=v.getPmp()%>" type="text" class="form-control" id="inputPmp" placeholder="Número PMP" name="pmp">
                                                </div>
                                                <div class="form-group col-xs-12 col-md-3">
                                                    <%ArrayList<CandidatoBean> CandidatosVinculadosNaVaga = (ArrayList<CandidatoBean>) request.getAttribute("listaCandidatosVagas" + v.getId());%>
                                                    <label for="inputProfissionalSelecionado">Profissional Selecionado:</label>
                                                    <select id="inputProfissionalSelecionado" class="form-control" name="profissionalSelecionado" required>
                                                        <option value="<%=v.getProfissionalSelecionado() == null ? "" : v.getProfissionalSelecionado()%>"><%=v.getProfissionalSelecionado() == null ? "NENHUM SELECIONADO" : v.getProfissionalSelecionado()%></option>
                                                        <% for (CandidatoBean cand : CandidatosVinculadosNaVaga) {%>
                                                        <option> <%= cand.getNome()%> </option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group  col-xs-12 col-md-12">
                                                    <label for="inputDetalhe">Detalhe:</label>
                                                    <textarea class="form-control" id="inputDetalhe" rows="3" name="detalhe"><%=v.getDetalhe()%></textarea>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-xs-12 col-md-4">
                                                    <label for="inputDtAprovaBrasil">Aprovação Board Brasil:</label>
                                                    <input value="<%=v.getAprovacaoBoardBrasil()%>" type="date" class="form-control" id="inputDtAprovaBrasil" name="aprovacao_board_brasil">
                                                </div>
                                                <div class="form-group col-xs-12 col-md-4">
                                                    <label for="inputDtAprovaGlobal">Aprovação Board Global:</label>
                                                    <input value="<%=v.getAprovacaoBoardGlobal()%>" type="date" class="form-control" id="inputDtAprovaGlobal" name="aprovacao_board_global">
                                                </div>
                                                <div class="form-group col-xs-12 col-md-4">
                                                    <label for="inputDtEntrouOperac">Entrou na Operação:</label>
                                                    <input value="<%=v.getEntrouNaOperacao()%>" type="date" class="form-control" id="inputDtEntrouOperac" name="entrou_operacao">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-xs-12 col-md-12">
                                                    <label for="inputComentario">Comentários:</label>
                                                    <input value="<%=v.getComentario()%>" type="text" class="form-control" id="inputComentario" name="comentarios">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-xs-12 col-md-12">
                                                    <label for="motivo-id">Motivo alteração:</label>
                                                    <input type="text" class="form-control" id="motivo-id" name="motivo" required />
                                                </div>
                                            </div>
                                            <div class="form-group text-xs-center">
                                                <button type="submit" class="btn ibmec-btn btn-editar-vaga" id="btn-editar-vaga" >Salvar</button>                            
                                            </div>
                                        </form>
                                    </td>                            
                                </tr> <!---------- Vagas Cadastradas - Editar Vaga - Fim ---------->
                                <tr
                                    class="collapse multi-collapse list-row-content-ibmec"
                                    id="incluir_candidato-<%= v.getId()%>"
                                    data-toggle="collapse"
                                    data-parent="#accordion"
                                    > <!---------- Vagas Cadastradas - Adicionar Candidatos na Vaga - Início ---------->
                                    <td colspan="5" class="edit-light-grey">                        
                                        <form class="atualizar-vaga" action="./CandidatosNaVaga" method="post">                                        
                                            <div class="form-row">
                                                <div class="form-group col-5">
                                                    <label for="inputFiltro">Filtro:</label>
                                                    <input value="" type="text" class="form-control" id="inputFiltro" placeholder="Filtro pesquisa" name="filtro" />
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-5">
                                                    <input value="<%= v.getId()%>" type="hidden" class="form-control" id="inputVagaCandidato" name="id_vaga_candidato" />
                                                    <%  List<CandidatoBean> listaDeCandidatos = (List<CandidatoBean>) request.getAttribute("listaCandidatos");
                                                    %>
                                                    <select name="candidatosAll" id="candidatosAll" class="form-control" multiple="multiple" size="5">
                                                        <%  for (CandidatoBean c : listaDeCandidatos) {%>
                                                        <option value=<%= c.getId()%>> <%= c.getNome()%> </option>                                                        
                                                        <% }%>
                                                    </select>                                                   
                                                </div>
                                                <div class="form-group col-2">
                                                    <input type="submit" class="btn btn-block ibmec-btn" id="vincula" name="opcaoDeVinculo" value="Vincular" />
                                                    <input type="submit" class="btn btn-block ibmec-btn" id="desvincula" name="opcaoDeVinculo" value="Desvincular" />
                                                </div>
                                                <div class="form-group col-5">
                                                    <%ArrayList<CandidatoBean> listaDeCandidatosVinculadosNaVaga = (ArrayList<CandidatoBean>) request.getAttribute("listaCandidatosVagas" + v.getId());%>
                                                    <select name="candidatosNaVagaAll" id="candidatosVaga" class="form-control" multiple="multiple" size="5">                                                        
                                                        <% for (CandidatoBean cv : listaDeCandidatosVinculadosNaVaga) {%>       
                                                        <option value=<%= cv.getId()%>> <%= cv.getNome()%> </option>
                                                        <% }%>
                                                    </select>
                                                </div>
                                            </div>
                                        </form>
                                    </td>
                                </tr> <!---------- Vagas Cadastradas - Adicionar Candidatos na Vaga - Fim ---------->
                                <tr class="collapse multi-collapse list-row-content-ibmec" id="listar-historico-<%= v.getId()%>" data-toggle="collapse" data-parent="#accordion">
                                    <td colspan="5" class="edit-light-grey">                        
                                        <form class="listar-historico" action="./HistoricoServlet" method="post">                                        
                                            <div class="historico-ibmec">                                                    
                                                <% List<VagaAudBean> listaVagaAud = (List<VagaAudBean>) request.getAttribute("listaHistoricoVagas" + v.getId()); %>
                                                <%int i = 0;%>
                                                <% for (VagaAudBean vagaAud : listaVagaAud) {%>
                                                <div class="form-group col-12">
                                                    <span id="dataModificacao" class="historico-ibmec-data" name="dataModificacao">                                                        
                                                        <%=vagaAud.getDataAudit()%></span>
                                                </div>
                                                <div class="form-group col-12">
                                                    <div id="motivo" name="motivo" class="motivo-ibmec"><%=vagaAud.getMotivoAtualizacao() == null ? "Vaga Cadastrada" : vagaAud.getMotivoAtualizacao()%></div>                                                       
                                                    <a class="historico-ibmec-ver-mais" href="./HistoricoServlet?indiceLista=<%=i%>&idVaga=<%=vagaAud.getVagaAudBeanPK().getId()%>">Ver mais</a>                                                 
                                                </div>
                                                <hr>
                                                <%i++;%>
                                                <%}%>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                <% }%> <!---------- Vagas Cadastradas - For da Lista de Vagas - Fim ---------->
                                <!----agas Cadastradas - Corpo da tabela - Fim ---------->
                            </table>                            
                        </div>
                    </div>
                </div> <!---------- Vagas Cadastradas - Fim ---------->
                <div class="row"> <!---------- Paginação - Início ---------->
                    <div class="offset-1 col-10">
                        <nav>
                            <ul class="pagination justify-content-center"> 
                                <%
                                    List pageNumbers = (List) session.getAttribute("pageNumbers");
                                    String cP = (String) session.getAttribute("currentPage");
                                    int currentPage = Integer.parseInt(cP);
                                    int previousPage = currentPage == 1 ? 1 : currentPage - 1;
                                    int nextPage = pageNumbers.size() == currentPage ? currentPage : currentPage + 1;
                                %>
                                <li class="page-item"><a class="page-link" href="./?pn=<%=previousPage%>&sf=<%=currentFilter%>&sa=<%=currentArea%>&ss=<%=currentStatus%>&st=<%=currentTechnology%>">Previous</a></li>
                                    <%for (int i = 0; i < pageNumbers.size(); i++) {%>                           
                                <li class="page-item"><a class="page-link" href="./?pn=<%=pageNumbers.get(i)%>&sf=<%=currentFilter%>&sa=<%=currentArea%>&ss=<%=currentStatus%>&st=<%=currentTechnology%>"><%=pageNumbers.get(i)%></a></li>
                                    <%}%>
                                <li class="page-item"><a class="page-link" href="./?pn=<%=nextPage%>&sf=<%=currentFilter%>&sa=<%=currentArea%>&ss=<%=currentStatus%>&st=<%=currentTechnology%>">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div><!---------- Paginação - Fim ---------->
            </div> 
        </div> <!---------- Container - Fim ---------->      
        <jsp:include page = "include/footer.jsp" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
        <%} else {
                RequestDispatcher view = request.getRequestDispatcher("./login.jsp");
                view.forward(request, response);
            }
        %>
    </body>
</html>
