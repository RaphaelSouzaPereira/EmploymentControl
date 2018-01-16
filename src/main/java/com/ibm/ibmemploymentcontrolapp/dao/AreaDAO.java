/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ibm.ibmemploymentcontrol.dao;

import br.com.ibm.ibmemploymentcontrol.beans.AreaBean;
import br.com.ibm.ibmemploymentcontrol.models.Area;
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

    private ModelMapper modelMapper;
    private EntityManager em;
    private Query query;

    public AreaDAO(EntityManager em, Query query) {
        this.em = em;
        this.query = query;
    }

    public void save(AreaBean ab) {
        Area destObject = modelMapper.map(ab, Area.class);
        em.persist(destObject);
    }

    public void delete(AreaBean ab) {
        Area destObject = modelMapper.map(ab, Area.class);
        em.remove(destObject);
    }

    public List<AreaBean> list() {
        query = em.createNamedQuery("Area.findAll");
        List<AreaBean> listAreaBean = new ArrayList<AreaBean>();

        for (Area itemLst : (List<Area>) query.getResultList()) {
            listAreaBean.add(modelMapper.map(itemLst, AreaBean.class));
        }

        return listAreaBean;

    }

}
