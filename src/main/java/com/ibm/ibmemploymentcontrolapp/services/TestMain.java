/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.services;

import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leandro
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        VagaBean vaga = new VagaBean();
        vaga.setStatus("OPEN");
        vaga.setCategoria("REGULAR");
        vaga.setStatus("BEM DE BOA");
        //    vaga.setDataDeAbertura(dateAbertura);
        vaga.setArea("AQUELA AREA");
        vaga.setTecnologia("TECNOLOGICO");
        //      vaga.setExpectativaDeEntrada(dateExpectativaEntrada);
        vaga.setTipo("TIPO BICHO");
        vaga.setBanda("AIC");
        vaga.setDetalhe("VAMOS INSERIR PRA DEPOIS REMOVER E COISA E TAL");

        vagaDAO.salvarVaga(vaga);

    /*    System.out.println("A banda da vaga: " + vaga.getBanda());

        System.out.println("Tentanto atualizar...");
        vaga.setBanda("NIN");
        vagaDAO.atualizarVaga(vaga);
        System.out.println("A banda da vaga agora: " + vaga.getBanda());
        
        System.out.println("REMOVER!");
        vagaDAO.removerVaga(vaga);
        */
        List<VagaBean> vagas = vagaDAO.listarVagas();
        for (VagaBean v : vagas) {
            System.out.println("v.getNome() = " + v.getBanda());
        }
        emf.close();
        emf = null;
    }

}
