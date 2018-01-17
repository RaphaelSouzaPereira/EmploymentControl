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
 * @author PedroFranceschinideF
 */
public class TecnologiaDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public TecnologiaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }


    public void salvarTecnologia(TecnologiaBean t) {

        Tecnologia objDestino = modelMapper.map(t, Tecnologia.class);
        em.persist(objDestino);
    }

    public List<TecnologiaBean> listarTecnologias() {

        Query query = em.createNamedQuery("Tecnologia.findAll");
        List<TecnologiaBean> listarTecsBean = new ArrayList<>();

        for (Tecnologia tecs : (List<Tecnologia>) query.getResultList()) {

            listarTecsBean.add(modelMapper.map(tecs, TecnologiaBean.class));
        }
        return listarTecsBean;

    }

}
