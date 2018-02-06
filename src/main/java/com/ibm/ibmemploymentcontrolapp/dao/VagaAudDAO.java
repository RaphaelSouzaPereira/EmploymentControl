/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.VagaAudBean;
import com.ibm.ibmemploymentcontrolapp.model.VagaAud;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class VagaAudDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public VagaAudDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

    public List<VagaAudBean> listarHistVagas() {

        Query query = em.createNamedQuery("VagaAud.findAll");
        List<VagaAudBean> listarHistoricoBean = new ArrayList<VagaAudBean>();

        for (VagaAud histVagas : (List<VagaAud>) query.getResultList()) {

            listarHistoricoBean.add(modelMapper.map(histVagas, VagaAudBean.class));
        }
        return listarHistoricoBean;
    }
}
