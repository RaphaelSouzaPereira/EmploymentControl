/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *

 * @author PedroFranceschinideF

 */
public class CandidatoDAO {
    
    private EntityManager em;
    private final ModelMapper modelMapper;


    public CandidatoDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    public void salvarCandidato(CandidatoBean c){
        Candidato destObject = modelMapper.map(c, Candidato.class); 
        em.persist(destObject);
    }
    
    public void deletarCandidato(CandidatoBean cb) {
        Candidato destObject = modelMapper.map(cb, Candidato.class);
        em.remove(destObject);
    }

    public List<CandidatoBean> listarCandidatos() {

        Query query = em.createNamedQuery("Candidato.findAll");
        List<CandidatoBean> listCandidatos = new ArrayList<>();
                
        for (Candidato candidato : (List<Candidato>) query.getResultList()) {
            listCandidatos.add(modelMapper.map(candidato, CandidatoBean.class));
        }

        return listCandidatos;
    }

}

    