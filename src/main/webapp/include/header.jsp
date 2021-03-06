<%-- 
    Document   : header
    Created on : 09/02/2018, 10:36:53
    Author     : PriscilaRicardoArrud
--%>

<header class="navbar navbar-expand navbar-dark flex-column flex-md-row mb-5 py-0 px-5 ibmec-menu">
    <h1 class="navbar-brand mr-0 mr-md-2 m-0 ibmec-menu-logo"><span class="ibmec-menu-logo-ibm">IBM </span>Employment Control</h1>
    <ul class="navbar-nav flex-row ml-md-auto d-md-none d-md-flex">
        <li class="nav-item">
            <a class="col-xs-4 text-xs-center nav-link py-4 px-4 menu-link ibmec-menu-link" href="./">Home</a>
        </li>
        <li class="nav-item">
            <a class="col-xs-4 text-xs-center nav-link py-4 px-4 menu-link ibmec-menu-link" href="./cadastro-vagas.jsp">Cadastrar Vagas</a>
        </li>
        <li class="dropdown">
            <a class="nav-link py-4 px-4 menu-link ibmec-menu-link" data-toggle="dropdown">Candidato</a>
            <ul class="dropdown-menu mt-0 ibmec-menu-dropdown">
                <li><a class="nav-link py-2 px-3 menu-link ibmec-menu-link" href="./cadastro-candidato.jsp">Cadastrar</a></li>
                <li><a class="nav-link py-2 px-3 menu-link ibmec-menu-link" href="./ListaCandidatoServlet">Atualizar</a></li>
            </ul>
        </li>
    </ul>
</header>
