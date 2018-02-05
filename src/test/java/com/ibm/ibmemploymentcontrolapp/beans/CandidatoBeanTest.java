/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import com.ibm.ibmemploymentcontrolapp.model.Vaga;
import java.text.ParseException;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PedroFranceschinideF
 */
public class CandidatoBeanTest {
    
    CandidatoBean candBean;
    String email = "tonhao@gmail.com";
    String nome = "Tonhao";
    String observacao = "Observacao do Tonhao";
    
    public CandidatoBeanTest(){
        
    }
    
   
    
    @Before
    public void setUp() {
        candBean = new CandidatoBean();
    }
    
    @After
    public void tearDown() {
        candBean = null;
    }

    
    @Test
    public void testConstrutor(){
        assertNotNull("CandidatoBean não foi criado", candBean);
        CandidatoBean candBean2 = new CandidatoBean(email, nome, observacao, null);
        assertNotNull("CandidatoBean2 não foi criado");
        assertEquals("E-mail não foi pego pelo construtor.", email, candBean2.getEmail());
        assertEquals("Nome não foi pego pelo construtor.", nome, candBean2.getNome());
        assertEquals("Observacao não foi pego pelo construtor.", observacao, candBean2.getObservacao());
    }
    
    
    @Test
    public void testSetAndGetEmail() {
        System.out.println("setEmail and getEmail");
        String expResult = "TESTEEMAIL";
        String email = "TESTEEMAIL";
        CandidatoBean instance = new CandidatoBean();
        instance.setEmail(email);
        String result = instance.getEmail();
        assertEquals("GET EMAIL NÃO FUNCIONOU", expResult, result);
    }
    
    @Test
    public void testSetAndGetNome(){
        System.out.println("setNome and getNome");
        String expResult = "TESTENOME";
        String nome = "TESTENOME";
        CandidatoBean instance = new CandidatoBean();
        instance.setNome(nome);
        String result = instance.getNome();
        assertEquals("GET NOME NÃO FUNCIONOU", expResult, result);
    }
    
    @Test
    public void testSetAndGetObservacao(){
        System.out.println("setObservacao and getObservacao");
        String expResult = "TESTEOBSERVACAO";
        String observacao = "TESTEOBSERVACAO";
        CandidatoBean instance = new CandidatoBean();
        instance.setObservacao(observacao);
        String result = instance.getObservacao();
        assertEquals("GET OBSERVACAO NÃO FUNCIONOU", expResult, result);
    }
    
@Test
    public void testSetAndGetVagaCollection() {
        System.out.println("set and getCandidatoCollection");
        Collection<Vaga> expResult = null;
        CandidatoBean instance = new CandidatoBean();
        Collection<Vaga> vagaCollection = null;
        instance.setVagaCollection(vagaCollection);
        Collection<Vaga> result = instance.getVagaCollection();
        assertEquals("GET VAGA NÃO FUNCIONOU", expResult, result);
    }
}
