<%-- 
    Document   : cadastro.jsp
    Created on : 16/01/2018, 15:09:31
    Author     : PriscilaRicardoArrud
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaAudBean"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Histórico da Vaga</title>
    </head>
    <body>
        <%
            VagaAudBean vagaAudBean = (VagaAudBean) request.getAttribute("historico_selecionado");
            DecimalFormat formatoNumero = new DecimalFormat("#.00");
        %>
        <jsp:include page = "include/header.jsp" />
        <div class="container">
            <div class="row">
                <div class="offset-1 col-10">
                    <h2 class="ibmec-title mb-3">Histórico da Vaga - <%= vagaAudBean.getDataAudit()%></h2>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="offset-1 col-5 mb-3">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value"><%= vagaAudBean.getCategoria()%></span> 
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Expectativa de Entrada: </strong></span><span class="vaga-value"><%= vagaAudBean.getExpectativaDeEntrada()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Data de Abertura: </strong></span><span class="vaga-value"><%= vagaAudBean.getDataDeAbertura()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value"><%= vagaAudBean.getTipo()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value"><%= vagaAudBean.getBanda()%></span>
                        </li>
                    </ul>
                </div>
                <div class="col-5">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value"><%= vagaAudBean.getAprovacaoBoardGlobal() == null ? "" : vagaAudBean.getAprovacaoBoardGlobal()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value"><%= vagaAudBean.getEntrouNaOperacao() == null ? "" : vagaAudBean.getEntrouNaOperacao()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value"><%= vagaAudBean.getAprovacaoBoardBrasil() == null ? "" : vagaAudBean.getAprovacaoBoardBrasil()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value"><%= vagaAudBean.getRate()%></span>
                        </li>
                        <li class="list-group-item">                                
                            <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value"><%= "R$ "
                                        + (vagaAudBean.getImpactoFinanceiro() == null ? "0" : formatoNumero.format(vagaAudBean.getImpactoFinanceiro()))%></span>
                        </li>
                    </ul>
                </div>
                <div class="offset-1 col-10">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value"><%= vagaAudBean.getProfissionalSelecionado() == null ? "" : vagaAudBean.getProfissionalSelecionado()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value"><%= vagaAudBean.getDetalhe()%></span>
                        </li>
                        <li class="list-group-item">
                            <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value"><%= vagaAudBean.getComentario()%></span>
                        </li>
                        <li class="list-group-item">
                                <span class="vaga-item"><strong>Motivo(s) da(s) Alteração(ões): </strong></span><span class="vaga-value"><%=vagaAudBean.getMotivoAtualizacao() == null ? "" : vagaAudBean.getMotivoAtualizacao()%></span>
                        </li>
                    </ul>
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