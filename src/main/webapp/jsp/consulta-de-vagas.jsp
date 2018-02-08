<%-- 
    Document   : consulta-de-vagas
    Created on : 05/02/2018, 12:49:34
    Author     : PriscilaRicardoArrud
--%>

<div class="row">
    <div class="offset-1 col-10">
        <h2 class="title mb-3">Consultar Cadastradas</h2>
        <hr>
        <form class="consulta-vagas" action="" method="post">
            <div class="form-row mb-4">
                <div class="form-group col-xs-12 col-md-3">
                    <label for="inputStatus">Área:</label>
                    <select id="inputAreaConsulta" class="form-control" name="area-consulta">
                        <option>Arquitetura</option>
                        <option selected>Canais</option>
                        <option>Digital</option>
                        <option>Especial</option>
                        <option>Suporte</option>
                    </select>
                </div>
                <div class="form-group col-xs-12 col-md-3">
                    <label for="inputStatus">Status:</label>
                    <select id="inputStatusConsulta" class="form-control" name="status-consulta">
                        <option selected>Open</option>
                        <option>Closed</option>
                        <option>On hold</option>
                        <option>Cancelada</option>
                    </select>
                </div>
                <div class="form-group col-xs-12 col-md-3">
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
                <div class="form-group col-xs-12 col-md-3">
                    <button type="submit" class="btn btn-ibmec btn-block" id="btn-consulta-vaga" style="margin-top:32px">Consultar</button>
                </div>
            </div>
        </form>
    </div>
</div>
