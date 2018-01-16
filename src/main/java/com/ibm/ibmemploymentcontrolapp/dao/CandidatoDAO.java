/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ibm.ibmemploymentcontrol.dao;

import br.com.ibm.ibmemploymentcontrol.beans.CandidatoBean;
import br.com.ibm.ibmemploymentcontrol.models.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author DiegoCansiMatte
 */
public class CandidatoDAO {

    private ModelMapper modelMapper;
    private EntityManager em;
    private Query query;

    public CandidatoDAO(EntityManager em, Query query) {
        this.em = em;
        this.query = query;
    }

    public void save(CandidatoBean ab) {
        Candidato destObject = modelMapper.map(ab, Candidato.class);
        em.persist(destObject);
    }

    public void delete(CandidatoBean ab) {
        Candidato destObject = modelMapper.map(ab, Candidato.class);
        em.remove(destObject);
    }

    public List<CandidatoBean> list() {
        query = em.createNamedQuery("Candidato.findAll");
        List<CandidatoBean> listCandidatoBean = new ArrayList<CandidatoBean>();

        for (Candidato itemLst : (List<Candidato>) query.getResultList()) {
            listCandidatoBean.add(modelMapper.map(itemLst, CandidatoBean.class));
        }

        return listCandidatoBean;

    }

}
