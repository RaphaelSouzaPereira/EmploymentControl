/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import com.ibm.ibmemploymentcontrolapp.model.Vaga;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 * @param
 * @return
 */
public class CandidatoVagaDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public CandidatoVagaDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

    /**
     * Metodo para vincular candidato a uma vaga salvando na tabela do banco os
     * ids.
     *
     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
     * @param vaga
     * @param lista
     */
    public void salvarCandidatoNaVagaComVerificacao(VagaBean vaga, ArrayList<CandidatoBean> lista) {
        ArrayList<CandidatoBean> listaVerificada = validaCandidato(lista, vaga);
        Collection<Candidato> candidatos = vaga.getCandidatoCollection();
        String candidatosString = "";
        for (CandidatoBean candidatoBean : listaVerificada) {
            candidatosString = candidatosString.concat(" " + candidatoBean.getNome());
            candidatos.add(modelMapper.map(candidatoBean, Candidato.class));
        }
        vaga.setCandidatoCollection(candidatos);        
        try {
            vaga.setMotivoAtualizacao("Candidato(s)" + candidatosString + " vinculado(s).");

            Vaga entity = modelMapper.map(vaga, Vaga.class);
            em.getTransaction().begin();

            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
        em.close();
    }

    /**
     * Metodo feito para validar se candidato ja esta ou nao vinculado a vaga
     *
     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
     * @param candidatoBeanVinculado
     * @param vaga
     * @return valor boleano onde false significa que ja exista algum candidato
     * com mesmo id e true para quando nao tem
     */
    public ArrayList<CandidatoBean> validaCandidato(ArrayList<CandidatoBean> candidatoBeanVinculado, VagaBean vaga) {
        Collection<Candidato> listCandidatosEntity = vaga.getCandidatoCollection();
        ArrayList<CandidatoBean> listaCandidadoBeanNoBanco = new ArrayList<CandidatoBean>();
        for (Candidato candidatoEntity : listCandidatosEntity) {
            listaCandidadoBeanNoBanco.add(modelMapper.map(candidatoEntity, CandidatoBean.class));
        }
        for (CandidatoBean cand : listaCandidadoBeanNoBanco) {
            for (int i = 0; i < candidatoBeanVinculado.size(); i++) {
                if (cand.getId().intValue() == candidatoBeanVinculado.get(i).getId().intValue()) {
                    candidatoBeanVinculado.remove(i);
                }
            }
        }
        return candidatoBeanVinculado;
    }

    /**
     * Metodo para listar todos os candidatos ligados há vaga
     *
     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
     * @param vaga
     * @return uma lista de candidatos que estão na vaga
     */
    public ArrayList<CandidatoBean> listarCandidatosNaVaga(VagaBean vaga, EntityManager emExterno) {
        Query query = emExterno.createNamedQuery("Vaga.findById").setParameter("id", vaga.getId());
        ArrayList<CandidatoBean> listCandidatosNaVaga = new ArrayList<CandidatoBean>();
        vaga = modelMapper.map(query.getSingleResult(), VagaBean.class);
        for (Candidato candidato : vaga.getCandidatoCollection()) {
            listCandidatosNaVaga.add(modelMapper.map(candidato, CandidatoBean.class));
        }
        emExterno.close();
        emExterno = null;
        return listCandidatosNaVaga;
    }

    /**
     * Metodo remove candidato da vaga
     *
     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
     * @param vaga que é uma bean de vaga para buscar a collection
     * @param candidato que é uma lista de Bean da Vaga
     */
    public void removerCandidatoDaVaga(VagaBean vaga, ArrayList<CandidatoBean> lista) {
        Collection<Candidato> listCandidatosEntity = vaga.getCandidatoCollection();
        String candidatosString = "";
        ArrayList<CandidatoBean> listaCandidadoBeanNoBanco = new ArrayList<CandidatoBean>();
        for (Candidato candidatoEntity : listCandidatosEntity) {
            listaCandidadoBeanNoBanco.add(modelMapper.map(candidatoEntity, CandidatoBean.class));
        }
        for (CandidatoBean candidatoDoFront : lista) {
            for (int i = 0; i < listaCandidadoBeanNoBanco.size(); i++) {
                if (candidatoDoFront.getId().intValue() == listaCandidadoBeanNoBanco.get(i).getId().intValue()) {
                    candidatosString = candidatosString.concat(" " + listaCandidadoBeanNoBanco.get(i).getNome());
                    listaCandidadoBeanNoBanco.remove(i);
                }
            }
        }
        listCandidatosEntity.clear();
        for (CandidatoBean candidatoBean : listaCandidadoBeanNoBanco) {
            listCandidatosEntity.add(modelMapper.map(candidatoBean, Candidato.class));
        }
        vaga.setCandidatoCollection(listCandidatosEntity);
        
        try {
            Vaga entity = modelMapper.map(vaga, Vaga.class);
            entity.setMotivoAtualizacao("Candidato(s)" + candidatosString + " removido(s) da vaga.");
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
        em.close();

    }

}
