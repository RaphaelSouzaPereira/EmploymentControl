/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 */
public class CandidatoVagaDAOTest {

    private EntityManager em;
    private EntityManagerFactory emf;
    private CandidatoVagaDAO candidatoVagaDao;
    private ModelMapper modelMapper;

    public CandidatoVagaDAOTest(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

//    @Before
//    public void setUp() {
//        emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");
//        em = emf.createEntityManager();
//        modelMapper = new ModelMapper();
//        candidatoVagaDao = new CandidatoVagaDAO(em);
//    }
//
//    @After
//    public void tearDown() {
//        em = null;
//        emf = null;
//        modelMapper = null;
//        candidatoVagaDao = null;
//    }

    /**
     * Test of salvarCandidatoNaVagaComVerificacao method, of class
     * CandidatoVagaDAO.
     */
    @Test
    public void testSalvarCandidatoNaVagaComVerificacao() {
        emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        modelMapper = new ModelMapper();
        candidatoVagaDao = new CandidatoVagaDAO(em);
        System.out.println("salvarCandidatoNaVagaComVerificacao");
        VagaBean vaga = new VagaBean();
        vaga.setId(11);
        Candidato cand1 = new Candidato();
        cand1.setId(1);
        Candidato cand2 = new Candidato();
        cand2.setId(11);
        Candidato cand3 = new Candidato();
        cand3.setId(21);
        ArrayList<Candidato> lista = new ArrayList<Candidato>();
        ArrayList<CandidatoBean> listabean = new ArrayList<CandidatoBean>();
        lista.add(cand1);
        lista.add(cand2);
        lista.add(cand3);
        for (Candidato candidato : lista) {
            listabean.add(modelMapper.map(candidato, CandidatoBean.class));
        }
        System.out.println("CHEGUEI AQUI");
        candidatoVagaDao.salvarCandidatoNaVagaComVerificacao(vaga, listabean);
        System.out.println("VAI TERMINARRRRRRRRRRRRR");
        em.close();
        em = null;
        emf = null;
    }

//    /**
//     * Test of listarCandidatosNaVaga method, of class CandidatoVagaDAO.
//     */
//    @Test
//    public void testListarCandidatosNaVaga() {
//        System.out.println("listarCandidatosNaVaga");
//        VagaBean vaga = null;
//        CandidatoVagaDAO instance = null;
//        List<CandidatoBean> expResult = null;
//        List<CandidatoBean> result = instance.listarCandidatosNaVaga(vaga);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validaCandidato method, of class CandidatoVagaDAO.
//     */
//    @Test
//    public void testValidaCandidato() {
//        System.out.println("validaCandidato");
//        CandidatoBean candidatoBeanVinculado = null;
//        VagaBean vaga = null;
//        CandidatoVagaDAO instance = null;
//        boolean expResult = false;
//        boolean result = instance.validaCandidato(candidatoBeanVinculado, vaga);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
