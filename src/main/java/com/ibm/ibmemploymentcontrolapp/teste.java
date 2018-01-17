/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp;

import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author PriscilaRicardoArrud
 */
public class teste {

    private static EntityManager em;

    public static void main(String args[]) {
        
        VagaDAO vagaDao = new VagaDAO(em);
        VagaBean vagabean = new VagaBean();

        vagabean.setStatus("ABERTO");
        vagabean.setPmp(1234456);
        vagabean.setExpectativaDeAbertura(10);
        vagabean.setBanda("10");
        vagabean.setTipo("BACKFILL");
        vagabean.setDetalhe("DETALHETESTE1");
        vagabean.setDesdeAberturaBrasil(10);
        vagabean.setDesdeAberturaGlobal(16);
        vagabean.setProfissionalSelecionado("JAO TESTE");
        vagabean.setDesdeAberturaAprovacao(16);
        vagabean.setRate(200.00);
        vagabean.setDesdeExpectativa(30);
        vagabean.setImpactoFinanceiro(999.99);
        vagabean.setComentario("COMENTTESTE386273256");
        vagabean.setCategoria("categoriateste123");
        
        
        vagaDao.salvarVaga(vagabean);
        
    }
}
