/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function verificaSeCampoEstaVazio(campo) {
    return (campo === "" || campo === undefined || campo === null) ? true : false;
}

function validaCamposDeCadastroDeVagas() {
    var categoria = document.getElementById("inputCategoria").value;
    var data_abertura = document.getElementById("inputDtAbertura").value;
    var area = document.getElementById("inputArea").value;
    var tecnologia = document.getElementById("inputTec").value;
    var data_exp_entrada = document.getElementById("inputDtExpecEntrada").value;
    var tipo = document.getElementById("inputTipo").value;
    var banda = document.getElementById("inputBanda").value;
    var detalhe = document.getElementById("inputDetalhe").value;

    var disabled = (verificaSeCampoEstaVazio(categoria)
            || verificaSeCampoEstaVazio(data_abertura)
            || verificaSeCampoEstaVazio(area)
            || verificaSeCampoEstaVazio(tecnologia)
            || verificaSeCampoEstaVazio(data_exp_entrada)
            || verificaSeCampoEstaVazio(tipo)
            || verificaSeCampoEstaVazio(banda)
            || verificaSeCampoEstaVazio(detalhe)) ? true : false;
    var btnDisabled = document.getElementById("btn-salvar-cadastro");
    if (disabled === true) {
        btnDisabled.disabled = true;
    } else {
        btnDisabled.disabled = false;
    }
}

function validaCamposDeEditarVagas() {
    var categoria = document.getElementById("inputCategoria").value;
    var data_abertura = document.getElementById("inputDtAbertura").value;
    var area = document.getElementById("inputArea").value;
    var tecnologia = document.getElementById("inputTec").value;
    var data_exp_entrada = document.getElementById("inputDtExpecEntrada").value;
    var tipo = document.getElementById("inputTipo").value;
    var banda = document.getElementById("inputBanda").value;
    var detalhe = document.getElementById("inputDetalhe").value;

    var disabled = (verificaSeCampoEstaVazio(categoria)
            || verificaSeCampoEstaVazio(data_abertura)
            || verificaSeCampoEstaVazio(area)
            || verificaSeCampoEstaVazio(tecnologia)
            || verificaSeCampoEstaVazio(data_exp_entrada)
            || verificaSeCampoEstaVazio(tipo)
            || verificaSeCampoEstaVazio(banda)
            || verificaSeCampoEstaVazio(detalhe)) ? true : false;
    var btnDisabled = document.getElementById("btn-editar-vaga");
    if (disabled === true) {
        btnDisabled.disabled = true;
    } else {
        btnDisabled.disabled = false;
    }
}

function validaCamposDeCadastroDeCandidatos() {
    //campos obrigatorios: email, nome
    var email = document.getElementById("inputEmail").value;
    var nome = document.getElementById("inputNome").value;
    var disabled = (verificaSeCampoEstaVazio(email)
            || verificaSeCampoEstaVazio(nome)) ? true : false;
    var btnDisabled = document.getElementById("btn-salvar-candidato");
    if (disabled === true) {
        btnDisabled.disabled = true;
    } else {
        btnDisabled.disabled = false;
    }
}

function redirectToHome() {
    window.location.replace("./teste");
}

function redireciona(url) {
    window.location.href = url;

}


function vincula(origin, dest) {
    $(origin).find(':selected').appendTo(dest);
    $('#inputFiltro').val(''); //limpa o campo de pesquisa
}

function desvincula(origin, dest) {
    $(origin).find(':selected').appendTo(dest);
    $('#inputFiltro').val(''); //limpa o campo de pesquisa
}

// Funcao pra limpar o texto para comparar
function sanitize(string) {
    return $.trim(string).replace(/\s+/g, ' ').toLowerCase();
}

$(document).ready(function () {
    /* Máscara do campo de cadastro 
     * 
     * http://igorescobar.github.io/jQuery-Mask-Plugin/
     */
    $('.inputRate').mask("#.##0,00", {reverse: true});

    /* Filtro de pesquisa de candidatos
     * 
     */
    var candidatoSelect = $('#candidatosAll'),
            procura = $('#inputFiltro'),
            options = candidatoSelect.find('option').clone(); // clone into memory

    // ajusta as opcoes para ser
    // um nome "procuravel" no elemento
    options.each(function () {
        var option = $(this);
        option.data('sanitized', sanitize(option.text()));
    });

    // trata o evento keyup
    procura.on('keyup', function (event) {
        var term = sanitize($(this).val()),
                matches;

        // se nao achar, mostra todos os options do select
        if (!term) {
            candidatoSelect.empty().append(options.clone());
            return;
        }

        // ou entao soh mostra o que achou
        matches = options.filter(function () {
            return $(this).data("sanitized").indexOf(term) !== -1;
        }).clone();
        candidatoSelect.empty().append(matches);
    });
});

