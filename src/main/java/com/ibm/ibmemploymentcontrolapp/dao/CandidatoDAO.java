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
    
    public CandidatoDAO(EntityManager em){
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    public void salvarCandidato(CandidatoBean c){
   
        Candidato objDestino = modelMapper.map(c, Candidato.class); 
        em.persist(objDestino);
    }
    
    public List <CandidatoBean> listarCandidatos(){
        
        Query query = em.createNamedQuery("Candidato.findAll");
        List <CandidatoBean> listarCandidatosBean = new ArrayList<>();
        
        for (Candidato candidatos : (List <Candidato>)query.getResultList()){
            
            listarCandidatosBean.add(modelMapper.map(candidatos,CandidatoBean.class));
        }
        return listarCandidatosBean; 
   
   }
    
}