/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.AreaBean;
import com.ibm.ibmemploymentcontrolapp.model.Area;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author PedroFranceschinideF
 */
public class AreaDAO {

    private final ModelMapper modelMapper;
    private final EntityManager em;

    public AreaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

    public void salvarArea(AreaBean a) {

        Area objDestino = modelMapper.map(a, Area.class);
        em.persist(objDestino);
    }

    public List<AreaBean> listarAreas() {

        Query query = em.createNamedQuery("Area.findAll");
        List<AreaBean> listarAreaBean = new ArrayList<>();

        for (Area itemLst : (List<Area>) query.getResultList()) {

            listarAreaBean.add(modelMapper.map(itemLst, AreaBean.class));
        }
        return listarAreaBean;
    }

}
