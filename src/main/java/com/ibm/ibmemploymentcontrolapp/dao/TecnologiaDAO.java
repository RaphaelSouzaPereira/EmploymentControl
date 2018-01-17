/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.TecnologiaBean;
import com.ibm.ibmemploymentcontrolapp.model.Tecnologia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author DiegoCansiMatte
 */
public class TecnologiaDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public TecnologiaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    public void salvarTecnologia(TecnologiaBean c){
        Tecnologia destObject = modelMapper.map(c, Tecnologia.class); 
        em.persist(destObject);
    }
    
    public List<TecnologiaBean> listarTecnologias() {

        Query query = em.createNamedQuery("Tecnologia.findAll");
        List<TecnologiaBean> listTecnologias = new ArrayList<TecnologiaBean>();
                
        for (Tecnologia candidato : (List<Tecnologia>) query.getResultList()) {
            listTecnologias.add(modelMapper.map(candidato, TecnologiaBean.class));
        }

        return listTecnologias;
    }
}
