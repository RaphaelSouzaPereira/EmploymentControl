/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class VagaDAOTest {

    private EntityManagerFactory emf;
    private VagaDAO vagaDao;

    public VagaDAOTest() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory(""
                + "com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");
        vagaDao = new VagaDAO(emf.createEntityManager());
    }

    @After
    public void tearDown() {
        emf = null;
        vagaDao = null;
    }

    /**
     * Test of salvarVaga method, of class VagaDAO.
     */
    @Test
    public void testSalvarVaga() {
        System.out.println("salvarVaga");
        VagaBean v = new VagaBean();
        v.setArea("teste");
        VagaDAO vagaDao = new VagaDAO(emf.createEntityManager());
        vagaDao.salvarVaga(v);
    }

    /**
     * Test of listarVagas method, of class VagaDAO.
     */
//    @Test
//    public void testListarVagas() {
//        System.out.println("listarVagas");
//        VagaDAO instance = null;
//        List<VagaBean> expResult = null;
//        List<VagaBean> result = instance.listarVagas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
