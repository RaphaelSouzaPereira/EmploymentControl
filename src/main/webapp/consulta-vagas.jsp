<%-- 
    Document   : consultar-vagas
    Created on : 18/01/2018, 10:19:24
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
        <title>Consulta de Vagas</title>
    </head>
    <body>
        <header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar mb-5">
            <h1 class="navbar-brand mr-0 mr-md-2 logo"><span class="logo-ibm">IBM </span>Employment Control</h1>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link py-4 px-4 menu-link" href="./consulta-vagas.jsp">Consultar Vagas</a>
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
                    <h2 class="title mb-3">Consulta de Vagas</h2>
                    <hr>
                    <form class="consulta-vagas" action="" method="post">
                        <div class="form-row">
                            <div class="form-group col-5">
                                <label for="inputStatus">Área:</label>
                                <select id="inputAreaConsulta" class="form-control" name="area-consulta">
                                    <option>Arquitetura</option>
                                    <option selected>Canais</option>
                                    <option>Digital</option>
                                    <option>Especial</option>
                                    <option>Suporte</option>
                                </select>
                            </div>
                            <div class="form-group col-5">
                                <label for="inputStatus">Status:</label>
                                <select id="inputStatusConsulta" class="form-control" name="status-consulta">
                                    <option selected>Open</option>
                                    <option>Closed</option>
                                    <option>On hold</option>
                                    <option>Cancelada</option>
                                </select>
                            </div>
                            <div class="form-group col-2">
                                <button type="submit" class="btn btn-primary btn-block" id="btn-consulta-vaga" style="margin-top:32px">Consultar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="offset-1 col-10">
                    <table class="table table-bordered" style="margin-top:45px">
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
                            <tr>
                                <td>Open</td>
                                <td>123456</td>
                                <td>01/02/2018</td>
                                <td>Canais</td>
                                <td>
                                    <button
                                        class="btn btn-primary"
                                        type="button"
                                        data-toggle="collapse"
                                        data-target="#vaga-1"
                                        aria-expanded="false"
                                        aria-controls="vaga-1">
                                        +
                                    </button>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse" id="vaga-1">
                                <td colspan="5">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value">BTP</span> 
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tecnologia: </strong></span><span class="vaga-value">Java</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Data de Abertura: </strong></span><span class="vaga-value">18/01/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value">Backfill</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value">Banda</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value">Detalhe</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value">16/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value">17/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value">03/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value">Marcos Eduardo</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value">129.0</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value">4000.00</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value">comentários</span>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td>Open</td>
                                <td>654321</td>
                                <td>19/01/2018</td>
                                <td>Canais</td>
                                <td>
                                    <button
                                        class="btn btn-primary"
                                        type="button"
                                        data-toggle="collapse"
                                        data-target="#vaga-2"
                                        aria-expanded="false"
                                        aria-controls="vaga-2">
                                        +
                                    </button>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse" id="vaga-2">
                                <td colspan="5">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value">BTP</span> 
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tecnologia: </strong></span><span class="vaga-value">Java</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Data de Abertura: </strong></span><span class="vaga-value">18/01/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value">Backfill</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value">Banda</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value">Detalhe</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value">16/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value">17/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value">03/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value">Marcos Eduardo</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value">129.0</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value">4000.00</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value">comentários</span>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td>Open</td>
                                <td>78901</td>
                                <td>20/01/2018</td>
                                <td>Canais</td>
                                <td>
                                    <button
                                        class="btn btn-primary"
                                        type="button"
                                        data-toggle="collapse"
                                        data-target="#vaga-3"
                                        aria-expanded="false"
                                        aria-controls="vaga-3">
                                        +
                                    </button>
                                </td>
                            </tr>
                            <tr class="collapse multi-collapse" id="vaga-3">
                                <td colspan="5">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Categoria: </strong></span><span class="vaga-value">BTP</span> 
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tecnologia: </strong></span><span class="vaga-value">Java</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Data de Abertura: </strong></span><span class="vaga-value">18/01/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Tipo: </strong></span><span class="vaga-value">Backfill</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Banda: </strong></span><span class="vaga-value">Banda</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Detalhe: </strong></span><span class="vaga-value">Detalhe</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Brasil: </strong></span><span class="vaga-value">16/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Aprovação Board Global: </strong></span><span class="vaga-value">17/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Entrou na Operação: </strong></span><span class="vaga-value">03/02/2018</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Profissional Selecionado: </strong></span><span class="vaga-value">Marcos Eduardo</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Rate: </strong></span><span class="vaga-value">129.0</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Impacto Financeiro: </strong></span><span class="vaga-value">4000.00</span>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="vaga-item"><strong>Comentários: </strong></span><span class="vaga-value">comentários</span>
                                        </li>
                                    </ul>
                                </td>
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