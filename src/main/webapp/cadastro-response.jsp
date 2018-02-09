<%-- 
    Document   : cadastro-response
    Created on : Jan 19, 2018, 10:09:27 AM
    Author     : Leandro Paz <leandro.paz at ibm.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Cadastro Vaga</title>        
    </head>
    <body>
        <jsp:include page = "include/header.jsp" />
        <!-- Modal -->
        <div class="modal fade in" id="myModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Cadastro realizado com sucesso!</h4>
                    </div>
                    <div class="modal-body">
                        <p>Deseja cadastrar mais vagas?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn ibmec-btn" data-dismiss="modal" 
                                onClick="redireciona('cadastro-vagas.jsp')">Sim</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                onClick="redireciona('./')">Não</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
        <script type="text/javascript">
                                    $(window).on('load', function () {
                                        $('#myModal').modal('show');
                                    });
        </script>
    </body>
</html>
