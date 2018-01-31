/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import com.ibm.ibmemploymentcontrolapp.model.Vaga;
import java.util.List;
import javax.persistence.EntityManager;
import org.modelmapper.ModelMapper;

/**
 *
 * @author PriscilaRicardoArrud
 */
public class VagaCandidatoDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public VagaCandidatoDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    public void salvarCandidatoNaVaga(List<CandidatoBean> novosCandidatos, VagaBean vagaBean) {
        Vaga vaga = modelMapper.map(vagaBean, Vaga.class);
        Candidato candidato = new Candidato();
        for (CandidatoBean candidatoBean : novosCandidatos) {
            candidato = modelMapper.map(candidatoBean, Candidato.class);
            candidato.getVagaCollection().add(vaga);
            //vaga.getCandidatoCollection().add(candidato);
        }
        
        System.out.println("TransactionTeste");
        em.getTransaction().begin();
        em.merge(candidato);
        em.getTransaction().commit(); 
    }
}
