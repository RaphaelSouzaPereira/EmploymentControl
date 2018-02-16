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

    /**
     * Método que salva uma nova vaga.
     * @param v 
     */
    public void salvarVaga(VagaBean v) {
        Vaga objDestino = modelMapper.map(v, Vaga.class);
        try {
            em.getTransaction().begin();
            em.persist(objDestino);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    /* metodo UPDATE com merge() conforme aqui:
    https://www.devmedia.com.br/crud-completo-com-hibernate-e-jpa/32711 */
    
    /**
     * Método que atualiza vagas existentes.
     * @param v 
     */
    public void atualizarVaga(VagaBean v) {
        Vaga objDestino = modelMapper.map(v, Vaga.class);
        try {
            em.getTransaction().begin();
            em.merge(objDestino);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
        em.close();
        em = null;
    }

    // Exclusao logica (seta status como "Excluida")
    /**
     * Método que faz a exclusão lógica de uma vaga.
     * @param v 
     */
    public void removerVaga(VagaBean v) {
        v.setStatus("Excluida");
        Vaga objDestino = modelMapper.map(v, Vaga.class);
        try {
            em.getTransaction().begin();
            em.merge(objDestino);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    /**
     * Método que lista todas as vagas existentes.
     * @return lista das vagas existents
     */
    public List<VagaBean> listarVagas() {

        Query query = em.createNamedQuery("Vaga.findAll");
        List<VagaBean> listarVagasBean = new ArrayList<VagaBean>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {

            listarVagasBean.add(modelMapper.map(vagas, VagaBean.class));

        }
        return listarVagasBean;
    }

    /**
     * Método que lista as vagas ordenada por área e data
     * @param emExterno
     * @return lista ordenada das vagas por área e data
     */
    public List<VagaBean> listarPorAreaData(EntityManager emExterno) {

        Query query = emExterno.createNamedQuery("Vaga.findOpenOnHoldByAreaExpectativa");
        List<VagaBean> listarVagaAreaData = new ArrayList<VagaBean>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {

            listarVagaAreaData.add(modelMapper.map(vagas, VagaBean.class));
        }
        emExterno.close();
        emExterno = null;
        return listarVagaAreaData;
    }

    /**
     * Método que lista as vagas por ordem cronológica.
     * @return lista ordenada cronologicamente
     */
    public List<VagaBean> listarPorOrdemCronologica() {

        Query query = em.createNamedQuery("Vaga.findOpenOnHoldByOrdemCronologica");
        List<VagaBean> listarOrdemCronologica = new ArrayList<>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {

            listarOrdemCronologica.add(modelMapper.map(vagas, VagaBean.class));
        }
        return listarOrdemCronologica;
    }
    
    public VagaBean buscarVagaPorIdExistente(Integer idVaga, EntityManager emExterno) {
        Vaga vaga = (Vaga) emExterno.createNamedQuery("Vaga.findById").setParameter("id", idVaga).getSingleResult();
        emExterno.close();
        emExterno = null;
        return modelMapper.map(vaga, VagaBean.class);
    }
    
    /**
     * Método que lista as vagas por páginas.
     * @param emExterno
     * @param maxResults
     * @param offset
     * @return vagas por páginas
     */
    public List<VagaBean> listarPorPagina(EntityManager emExterno, int maxResults, int offset) {
        Query query = emExterno.createNamedQuery("Vaga.findOpenOnHoldByAreaExpectativa").setMaxResults(maxResults).setFirstResult(offset);
        List<VagaBean> listarPorPagina = new ArrayList<VagaBean>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {
            listarPorPagina.add(modelMapper.map(vagas, VagaBean.class));
        }
        
        emExterno.close();
        emExterno = null;
        
        return listarPorPagina;
    } 
    
    /**
     * Método que listas as vagas com os filtros "area", "status" e "tecnologia".
     * @param emExterno
     * @param area
     * @param status
     * @param tecnologia
     * @return lista com os filtros aplicados
     */
    public List<VagaBean> listarComFiltro(EntityManager emExterno, String area, String status, String tecnologia) {
        Query query = emExterno.createNamedQuery("Vaga.findByAreaStatusAndTecnologia").setParameter("area", area).setParameter("status", status).setParameter("tecnologia", tecnologia);
        List<VagaBean> listarPorPagina = new ArrayList<VagaBean>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {
            listarPorPagina.add(modelMapper.map(vagas, VagaBean.class));
        }
        
        emExterno.close();
        emExterno = null;
        
        return listarPorPagina;
    }
    
    /**
     * Método que lista as vagas por página e filtro.
     * @param emExterno
     * @param maxResults
     * @param offset
     * @param area
     * @param status
     * @param tecnologia
     * @return lissta com os filtros aplicados e por página
     */
    public List<VagaBean> listarPorPaginaComFiltro(EntityManager emExterno, int maxResults, int offset, String area, String status, String tecnologia) {
        Query query = emExterno.createNamedQuery("Vaga.findByAreaStatusAndTecnologia").setMaxResults(maxResults).setFirstResult(offset).setParameter("area", area).setParameter("status", status).setParameter("tecnologia", tecnologia);
        List<VagaBean> listarPorPagina = new ArrayList<VagaBean>();

        for (Vaga vagas : (List<Vaga>) query.getResultList()) {
            listarPorPagina.add(modelMapper.map(vagas, VagaBean.class));
        }
        
        emExterno.close();
        emExterno = null;
        
        return listarPorPagina;
    } 

}