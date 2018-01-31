///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.ibm.ibmemploymentcontrolapp.dao;
//
//import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
//import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
//import com.ibm.ibmemploymentcontrolapp.model.Candidato;
//import java.util.ArrayList;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import org.modelmapper.ModelMapper;
//
///**
// *
// * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
// * @param
// * @return
// */
//public class CandidatoVagaDAO {
//
//    private EntityManager em;
//    private final ModelMapper modelMapper;
//
//    public CandidatoVagaDAO(EntityManager em) {
//        this.em = em;
//        this.modelMapper = new ModelMapper();
//    }
//
//    /**
//     * Metodo para vincular candidato a uma vaga salvando na tabela do banco os
//     * ids.
//     *
//     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
//     * @param vaga
//     * @param lista
//     */
//    public void salvarCandidatoNaVagaComVerificacao(VagaBean vaga, ArrayList<CandidatoBean> lista) {
//        ArrayList<CandidatoBean> listaVerificada = validaCandidato(lista, vaga);
//        Collection<Candidato> candidatos = vaga.getCandidatoCollection();
//        for (CandidatoBean candidatoBean : listaVerificada) {
////            vaga.getCandidatoCollection().add(modelMapper.map(candidatoBean, Candidato.class));
////            vaga.setCandidatoCollection(vaga.getCandidatoCollection());
//              candidatos.add(modelMapper.map(candidatoBean, Candidato.class));
//        }
//        vaga.setCandidatoCollection(candaditos);
//        for (Candidato candidato : vaga.getCandidatoCollection()) {
//            System.out.println(candidato.getId() + "  " + candidato.getNome() + " BBBBBBBBBBBBBBBBBBBBBBBBBB");
//        }
//        
//        em.getTransaction().begin();
//        em.merge(vaga);
//        em.getTransaction().commit();
//
//        em.close();
//        em = null;
//    }
//
//    /**
//     * Metodo feito para validar se candidato ja esta ou nao vinculado a vaga
//     *
//     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
//     * @param candidatoBeanVinculado
//     * @param vaga
//     * @return valor boleano onde false significa que ja exista algum candidato
//     * com mesmo id e true para quando nao tem
//     */
//    public ArrayList<CandidatoBean> validaCandidato(ArrayList<CandidatoBean> candidatoBeanVinculado, VagaBean vaga) {
//        ArrayList<CandidatoBean> listCandidatosBean = listarCandidatosNaVaga(vaga);
//
//        for (CandidatoBean candidatoFront : candidatoBeanVinculado) {
//            for (CandidatoBean cand : listCandidatosBean) {
//                if (candidatoFront.getId() == cand.getId()) {
//                    //AINDA NAO FUNCIONA
//                    System.out.println(candidatoFront.getId() + "RETIRAAAAAAAAAAAAADOOOOOOOOOOOOOOOOOO");
//                    candidatoBeanVinculado.remove(candidatoFront);
//                }
//            }
//        }
//        for (CandidatoBean candidatoFront : candidatoBeanVinculado) {
//            System.out.println(candidatoFront.getNome() + "AINDAAAAA NA LISTA");
//        }
//        return candidatoBeanVinculado;
//    }
//
//    /**
//     * Metodo para listar todos os candidatos ligados há vaga
//     *
//     * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
//     * @param vaga
//     * @return uma lista de candidatos que estão na vaga
//     */
//    public ArrayList<CandidatoBean> listarCandidatosNaVaga(VagaBean vaga) {
//
//        Query query = em.createNamedQuery("Vaga.findById").setParameter("id", vaga.getId());
//
//        ArrayList<CandidatoBean> listCandidatosNaVaga = new ArrayList<CandidatoBean>();
//
//        vaga = modelMapper.map(query.getSingleResult(), VagaBean.class);
//
//        for (Candidato candidato : vaga.getCandidatoCollection()) {
//            listCandidatosNaVaga.add(modelMapper.map(candidato, CandidatoBean.class));
//        }
//        em.close();
//        em = null;
//        return listCandidatosNaVaga;
//    }
//
//}
