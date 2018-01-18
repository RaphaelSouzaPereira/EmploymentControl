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
 *
 * @author FabioHenriqueGoulart
 */
public class VagaDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public VagaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

    public void salvarVaga(VagaBean v) {
        Vaga objDestino = modelMapper.map(v,Vaga.class);
        em.getTransaction().begin();
        em.persist(objDestino);
        em.getTransaction().commit();
    }

    public List<VagaBean> listarVagas() {

        Query query = em.createNamedQuery("Vaga.findAll");
        List<VagaBean> listarVagasBean = new ArrayList<>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {

            listarVagasBean.add(modelMapper.map(vagas, VagaBean.class));

        }
        return listarVagasBean;

    }

}
