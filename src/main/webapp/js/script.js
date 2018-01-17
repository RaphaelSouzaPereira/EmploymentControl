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
            || verificaSeCampoEstaVazio(detalhe))? true : false;
    var btnDisabled = document.getElementById("btn-salvar-cadastro");
    if(disabled === true) {
        btnDisabled.disabled = true;
    } else {
        btnDisabled.disabled = false;
    }
}

function redirectToHome() {
    window.location.replace("./teste");
}


