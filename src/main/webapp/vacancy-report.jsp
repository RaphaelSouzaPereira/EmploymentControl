<%-- 
    Document   : vacancy-report
    Created on : 21/02/2018, 13:08:07
    Author     : PriscilaRicardoArrud
--%>

<%@page import="com.ibm.ibmemploymentcontrolapp.beans.VagaBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Relatório de Vagas</title>
    </head>
    <body>
        <jsp:include page = "include/header.jsp" />
        <div class="container"> <!---------- Container - Beginning ---------->
            <div class="row"> <!---------- Vacancy Report - Beginning ---------->
                <div class="offset-1 col-10">
                    <h2 class="ibmec-title mb-3">Relatório de Vagas</h2>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-bordered list-table-ibmec">
                            <thead class="list-thead-ibmec"> <!---------- Vacancy Report - thead - Beginning ---------->
                                <tr class="list-ibmec">
                                    <th>Status</th>
                                    <th>PMP</th>
                                    <th>Área</th>
                                    <th>Banda</th>
                                    <th>Tipo</th>
                                    <th>Tecnologia</th>
                                    <th>Detalhe</th>
                                    <th>Aprovação Board Brasil</th>
                                    <th>Aprovação Board Global</th>
                                    <th>Comentários</th>
                                </tr>
                            </thead> <!---------- Vacancy Report - thead - End ---------->
                            <tbody> <!---------- Vacancy Report - tbody - Beginning ---------->
                                <% List<VagaBean> listOfVacancies = (List<VagaBean>) session.getAttribute("listOfVacancies");
                                    for (VagaBean lov : listOfVacancies) {%>
                                <tr class="list-row-ibmec"> 
                                    <td><%= lov.getStatus()%></td>
                                    <td><%= lov.getPmp()%></td>
                                    <td><%= lov.getArea()%></td>
                                    <td><%= lov.getBanda()%></td>
                                    <td><%= lov.getTipo()%></td>
                                    <td><%= lov.getTecnologia()%></td>
                                    <td><%= lov.getDetalhe()%></td>
                                    <td><%= lov.getAprovacaoBoardBrasil() == null ? "" : lov.getAprovacaoBoardBrasil()%></td>
                                    <td><%= lov.getAprovacaoBoardGlobal() == null ? "" : lov.getAprovacaoBoardGlobal()%></td>
                                    <td><%= lov.getComentario()%></td>
                                </tr>
                                <%}%>
                            </tbody> <!---------- Vacancy Report - tbody - End ---------->
                        </table>
                    </div>
                </div>
            </div> <!---------- Vacancy Report - End ---------->
        </div> <!---------- Container - End ---------->
        <jsp:include page = "include/footer.jsp" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
