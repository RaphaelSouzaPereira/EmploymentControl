/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.model.Vaga;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author DiegoCansiMatte
 */
public class VagaDAO {
    
    private ModelMapper modelMapper;
    private EntityManager em;
    private Query query;

    public VagaDAO(EntityManager em, Query query) {
        this.em = em;
        this.query = query;
    }

    public void save(VagaBean tb) {
        Vaga destObject = modelMapper.map(tb, Vaga.class);
        em.persist(destObject);
    }

    public void delete(VagaBean tb) {
        Vaga destObject = modelMapper.map(tb, Vaga.class);
        em.remove(destObject);
    }

    public List<VagaBean> list() {
        query = em.createNamedQuery("Vaga.findAll");
        List<VagaBean> listTecnologiaBean = new ArrayList<VagaBean>();

        for (Vaga itemLst : (List<Vaga>) query.getResultList()) {
            listTecnologiaBean.add(modelMapper.map(itemLst, VagaBean.class));
        }

        return listTecnologiaBean;
    }
    
}
