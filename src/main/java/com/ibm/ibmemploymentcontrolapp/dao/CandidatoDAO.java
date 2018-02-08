/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class CandidatoDAO {
    
    //Declaracão de variaveis para fazer conexão no banco e fazer a mudança de Bean para Entity.
    private EntityManager em;
    private final ModelMapper modelMapper;
    
    //Construtor
    public CandidatoDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }
    
    /**
     * Salva candidatos no banco de dados pegos do front.
     * @param candidato vindo do cadastro no front. 
     */
    public void salvarCandidato(CandidatoBean candidato) {
        Candidato destObject = modelMapper.map(candidato, Candidato.class);
        em.getTransaction().begin();
        em.persist(destObject);
        em.getTransaction().commit();
        em.close();
        em = null;
    }
    /**
     * Lista todos os candidatos existentes.
     * @return listCandidatos com todos os candidatos do banco.
     */
    public List<CandidatoBean> listarCandidatos() {

        Query query = em.createNamedQuery("Candidato.findAll");
        List<CandidatoBean> listCandidatos = new ArrayList<>();

        for (Candidato candidato : (List<Candidato>) query.getResultList()) {
            listCandidatos.add(modelMapper.map(candidato, CandidatoBean.class));
        }
        em.close();
        em = null;
        return listCandidatos;
    }

    /**
     * Busca candidatos a partid do nome.
     * @param nomeDoFiltro nome do candidato digitado no filtro.
     * @return Lista de candidato para mostrar apenas os com o mesmo nome.
     */
    public List<CandidatoBean> listarCandidatosComFiltro(String nomeDoFiltro) {
        List<Candidato> listCandidatos = new ArrayList<Candidato>();
        listCandidatos = em.createNamedQuery("Candidato.findByFilter").setParameter("nome", "%" + nomeDoFiltro + "%").getResultList();
        List<CandidatoBean> listCandidatosBean = new ArrayList<CandidatoBean>();

        for (Candidato candidato : listCandidatos) {
            listCandidatosBean.add(modelMapper.map(candidato, CandidatoBean.class));
        }

        em.close();
        em = null;

        return listCandidatosBean;
    }

    /**
     * Salva candidato novo e faz uma verificação para saber se ele já existe a partir do e-mail.
     * @param candidato objeto bean puxado do front para transformar em entity para salvar no banco. 
     */
    public void salvarCandidatoComVerificacao(CandidatoBean candidato) {
        List<Candidato> listCandidatos = new ArrayList<Candidato>();
        listCandidatos = em.createNamedQuery("Candidato.findByEmail").setParameter("email", candidato.getEmail()).getResultList();

        if (listCandidatos.isEmpty()) {
            Candidato destObject = modelMapper.map(candidato, Candidato.class);
            em.getTransaction().begin();
            em.persist(destObject);
            em.getTransaction().commit();
        } else {
            em.close();
            em = null;
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }

        em.close();
        em = null;
    }
    
    /**
     * Busca candidatos apartir do ID.
     * @param idCandidato recebe o id do candidato do front.
     * @return um candidato entity já transformado em um Candidado bean.
     */
    public CandidatoBean buscarCandidatoPorIdExistente(Integer idCandidato) {
        Candidato candidato = (Candidato) em.createNamedQuery("Candidato.findById").setParameter("id", idCandidato).getSingleResult();
        return modelMapper.map(candidato, CandidatoBean.class);
    }
    
    /**
     * Atualiza dados do candidato no banco.
     * @param candidato com dados atualizados do front.
     */
    public void atualizarCandidato(CandidatoBean candidato) {
        Candidato objDestino = modelMapper.map(candidato, Candidato.class);
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

}
