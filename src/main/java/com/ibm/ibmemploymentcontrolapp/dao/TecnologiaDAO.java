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

    private ModelMapper modelMapper;
    private EntityManager em;
    private Query query;

    public TecnologiaDAO(EntityManager em, Query query) {
        this.em = em;
        this.query = query;
    }

    public void save(TecnologiaBean tb) {
        Tecnologia destObject = modelMapper.map(tb, Tecnologia.class);
        em.persist(destObject);
    }

    public void delete(TecnologiaBean tb) {
        Tecnologia destObject = modelMapper.map(tb, Tecnologia.class);
        em.remove(destObject);
    }

    public List<TecnologiaBean> list() {
        query = em.createNamedQuery("Tecnologia.findAll");
        List<TecnologiaBean> listTecnologiaBean = new ArrayList<TecnologiaBean>();

        for (Tecnologia itemLst : (List<Tecnologia>) query.getResultList()) {
            listTecnologiaBean.add(modelMapper.map(itemLst, TecnologiaBean.class));
        }

        return listTecnologiaBean;
    }
}
