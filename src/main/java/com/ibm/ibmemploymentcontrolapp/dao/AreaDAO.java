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
 * @author DiegoCansiMatte
 */
public class AreaDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public AreaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    public void salvarArea(AreaBean c){
        Area destObject = modelMapper.map(c, Area.class); 
        em.persist(destObject);
    }
    
    public List<AreaBean> listarAreas() {

        Query query = em.createNamedQuery("Area.findAll");
        List<AreaBean> listAreas = new ArrayList<AreaBean>();
                
        for (Area candidato : (List<Area>) query.getResultList()) {
            listAreas.add(modelMapper.map(candidato, AreaBean.class));
        }

        return listAreas;
    }

}
