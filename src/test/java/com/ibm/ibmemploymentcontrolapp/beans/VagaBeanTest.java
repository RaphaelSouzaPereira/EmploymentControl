package com.ibm.ibmemploymentcontrolapp.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 */
public class VagaBeanTest {

    VagaBean vagabean;
    String status = "TESTESTATUS";
    int pmp = 123456;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date dataDeAbertura;
    Date expectativaDeEntrada;
    int expectativaDeAbertura = 10;
    String area = "TESTEAREA";
    String banda = "T";
    String tipo = "TESTETIPO";
    String tecnologia = "TESTETECNOLOGIA";
    String detalhe = "TESTEDETALHE";
    Date aprovacaoBoardBrasil = Date.from(Instant.now());
    int desdeAberturaBrasil = 5;
    Date aprovacaoBoardGlobal = Date.from(Instant.now());
    int desdeAberturaGlobal = 6;
    String profissionalSelecionado = "TESTEPROFISSIONAL";
    Date entrouNaOperacao = Date.from(Instant.now());
    int desdeAberturaAprovacao = 10;
    Double rate = 5.00;
    int desdeExpectativa = 10;
    Double impactoFinanceiro = 1000.00;
    String comentario = "TESTECOMENTARIO";
    String categoria = "TESTECATEGORIA";

    public VagaBeanTest() throws ParseException {
        this.dataDeAbertura = formato.parse("23/11/2015");
        this.expectativaDeEntrada = formato.parse("23/11/2015");
        this.aprovacaoBoardBrasil = formato.parse("23/11/2015");
        this.aprovacaoBoardGlobal = formato.parse("23/11/2015");
        this.entrouNaOperacao = formato.parse("23/11/2015");
    }

    @Before
    public void setUp() {
        vagabean = new VagaBean();
    }

    @After
    public void tearDown() {
        vagabean = null;

    }

    @Test
    public void testConstrutors() {
        assertNotNull("VagaBean não foi criado", vagabean);
        VagaBean vagabean2 = new VagaBean(status, pmp,
                dataDeAbertura, expectativaDeEntrada,
                expectativaDeAbertura, area, banda, tipo,
                tecnologia, detalhe, aprovacaoBoardBrasil,
                desdeAberturaBrasil, aprovacaoBoardGlobal,
                desdeAberturaGlobal, profissionalSelecionado,
                entrouNaOperacao, desdeAberturaAprovacao, rate,
                desdeExpectativa, impactoFinanceiro, comentario,
                categoria, null);
        assertNotNull("VAGABEAN2 não foi criado.", vagabean2);
        assertEquals("STATUS não foi pego pelo construtor.", status, vagabean2.getStatus());
        assertEquals("PMP não foi pego pelo construtor", new Long(pmp), new Long(vagabean2.getPmp()));
        assertTrue("DATADEABERTURA não foi pego pelo construtor.", dataDeAbertura.equals(vagabean2.getDataDeAbertura()));
        assertTrue("EXPECTATIVADEENTRADA não foi pego pelo construtor.", expectativaDeEntrada.equals(vagabean2.getExpectativaDeEntrada()));
        assertEquals("EXPECTATIVADEABERTURA não foi pego pelo construtor.", new Long(expectativaDeAbertura), new Long(vagabean2.getExpectativaDeAbertura()));
        assertEquals("AREA não foi pego pelo construtor.", area, vagabean2.getArea());
        assertEquals("BANDA não foi pego pelo construtor.", banda, vagabean2.getBanda());
        assertEquals("TIPO não foi pego pelo construtor.", tipo, vagabean2.getTipo());
        assertEquals("TECNOLOGIA não foi pego pelo construtor.", tecnologia, vagabean2.getTecnologia());
        assertEquals("DETALHE não foi pego pelo construtor.", detalhe, vagabean2.getDetalhe());
        assertTrue("APROVACAOBOARDBRASIL não foi pego pelo construtor.", aprovacaoBoardBrasil.equals(vagabean2.getAprovacaoBoardBrasil()));
        assertEquals("DESDEABERTURABRASIL não foi pego pelo construtor.", new Long(desdeAberturaBrasil), new Long(vagabean2.getDesdeAberturaBrasil()));
        assertTrue("APROVACAOBOARDGLOBAL não foi pego pelo construtor.", aprovacaoBoardGlobal.equals(vagabean2.getAprovacaoBoardGlobal()));
        assertEquals("PROFISSIONALSELECIONADO não foi pego pelo construtor.", profissionalSelecionado, vagabean2.getProfissionalSelecionado());
        assertTrue("ENTROUNAOPERACAO não foi pego pelo construtor.", entrouNaOperacao.equals(vagabean2.getEntrouNaOperacao()));
        assertEquals("DESDEABERTURAAPROVACAO não foi pego pelo construtor.", new Long(desdeAberturaAprovacao), new Long(vagabean2.getDesdeAberturaAprovacao()));
        assertEquals("RATE não foi pego pelo construtor.", rate, vagabean2.getRate());
        assertEquals("DESDEEXPECTATIVA não foi pego pelo construtor.", new Long(desdeExpectativa), new Long(vagabean2.getDesdeExpectativa()));
        assertEquals("IMPACTOFINANCEIRO não foi pego pelo construtor.", impactoFinanceiro, vagabean2.getImpactoFinanceiro());
        assertEquals("COMENTARIO não foi pego pelo construtor.", comentario, vagabean2.getComentario());
        assertEquals("CATEGORIA não foi pego pelo construtor.", categoria, vagabean2.getCategoria());

    }

    /**
     * Test of set and getStatus method, of class VagaBean.
     */
    @Test
    public void testSetAndGetStatus() {
        System.out.println("set and getStatus");
        String expResult = "TESTESTATUS";
        String status = "TESTESTATUS";
        VagaBean instance = new VagaBean();
        instance.setStatus(status);
        String result = instance.getStatus();
        assertEquals("GET STATUS NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getPmp method, of class VagaBean.
     */
    @Test
    public void testSetAndGetPmp() {
        System.out.println("set and getPmp");
        Integer expResult = 123456;
        VagaBean instance = new VagaBean();
        Integer pmp = 123456;
        instance.setPmp(pmp);
        Integer result = instance.getPmp();
        assertEquals("GET PMP NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDataDeAbertura method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDataDeAbertura() throws ParseException {
        System.out.println("set and getDataDeAbertura");
        Date expResult = formato.parse("23/11/2015");
        Date dataDeAbertura = formato.parse("23/11/2015");
        VagaBean instance = new VagaBean();
        instance.setDataDeAbertura(dataDeAbertura);
        Date result = instance.getDataDeAbertura();
        assertEquals("GET DATA DE ABERTURA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getExpectativaDeEntrada method, of class VagaBean.
     */
    @Test
    public void testSetAndGetExpectativaDeEntrada() throws ParseException {
        System.out.println("set and getExpectativaDeEntrada");
        Date expResult = formato.parse("23/11/2015");
        Date expectativaDeEntrada = formato.parse("23/11/2015");
        VagaBean instance = new VagaBean();
        instance.setExpectativaDeEntrada(expectativaDeEntrada);
        Date result = instance.getExpectativaDeEntrada();
        assertEquals("GET EXPECTATIVA DE ENTRADA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getExpectativaDeAbertura method, of class VagaBean.
     */
    @Test
    public void testSetAndGetExpectativaDeAbertura() {
        System.out.println("set and getExpectativaDeAbertura");
        Integer expResult = 10;
        Integer expectativaDeAbertura = 10;
        VagaBean instance = new VagaBean();
        instance.setExpectativaDeAbertura(expectativaDeAbertura);
        Integer result = instance.getExpectativaDeAbertura();
        assertEquals("GET EXPECTATIVA DE ABERTURA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getArea method, of class VagaBean.
     */
    @Test
    public void testSetAndGetArea() {
        System.out.println("set and getArea");
        String expResult = "TESTEAREA";
        String area = "TESTEAREA";
        VagaBean instance = new VagaBean();
        instance.setArea(area);
        String result = instance.getArea();
        assertEquals("GET AREA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getBanda method, of class VagaBean.
     */
    @Test
    public void testSetAndGetBanda() {
        System.out.println("set and getBanda");
        String expResult = "T";
        VagaBean instance = new VagaBean();
        String banda = "T";
        instance.setBanda(banda);
        String result = instance.getBanda();
        assertEquals("GET BANDA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getTipo method, of class VagaBean.
     */
    @Test
    public void testSetAndGetTipo() {
        System.out.println("set and getTipo");
        String expResult = "TESTETIPO";
        VagaBean instance = new VagaBean();
        String tipo = "TESTETIPO";
        instance.setTipo(tipo);
        String result = instance.getTipo();
        assertEquals("GET TIPO NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getTecnologia method, of class VagaBean.
     */
    @Test
    public void testSetAndGetTecnologia() {
        System.out.println("set and getTecnologia");
        String expResult = "TESTETECNOLOGIA";
        VagaBean instance = new VagaBean();
        String tecnologia = "TESTETECNOLOGIA";
        instance.setTecnologia(tecnologia);
        String result = instance.getTecnologia();
        assertEquals("GET TECNOLOGIA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDetalhe method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDetalhe() {
        System.out.println("set and getDetalhe");
        String expResult = "TESTEDETALHE";
        VagaBean instance = new VagaBean();
        String detalhe = "TESTEDETALHE";
        instance.setDetalhe(detalhe);
        String result = instance.getDetalhe();
        assertEquals("GET DETALHE NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getAprovacaoBoardBrasil method, of class VagaBean.
     */
    @Test
    public void testSetAndGetAprovacaoBoardBrasil() throws ParseException {
        System.out.println("set and getAprovacaoBoardBrasil");
        Date expResult = formato.parse("23/11/2015");
        VagaBean instance = new VagaBean();
        Date aprovacaoBoardBrasil = formato.parse("23/11/2015");
        instance.setAprovacaoBoardBrasil(aprovacaoBoardBrasil);
        Date result = instance.getAprovacaoBoardBrasil();
        assertEquals("GET APROVAÇÃO BOARD BRASIL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaBrasil method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaBrasil() {
        System.out.println("set and getDesdeAberturaBrasil");
        Integer expResult = 5;
        VagaBean instance = new VagaBean();
        Integer desdeAberturaBrasil = 5;
        instance.setDesdeAberturaBrasil(desdeAberturaBrasil);
        Integer result = instance.getDesdeAberturaBrasil();
        assertEquals("GET DESDE ABERTURA BRASIL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getAprovacaoBoardGlobal method, of class VagaBean.
     */
    @Test
    public void testSetAndGetAprovacaoBoardGlobal() throws ParseException {
        System.out.println("set and getAprovacaoBoardGlobal");
        Date expResult = formato.parse("23/11/2015");
        VagaBean instance = new VagaBean();
        Date aprovacaoBoardGlobal = formato.parse("23/11/2015");
        instance.setAprovacaoBoardGlobal(aprovacaoBoardGlobal);
        Date result = instance.getAprovacaoBoardGlobal();
        assertEquals("GET APROVAÇÃO BOARD GLOBAL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaGlobal method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaGlobal() {
        System.out.println("getDesdeAberturaGlobal");
        Integer expResult = 6;
        VagaBean instance = new VagaBean();
        Integer desdeAberturaGlobal = 6;
        instance.setDesdeAberturaGlobal(desdeAberturaGlobal);
        Integer result = instance.getDesdeAberturaGlobal();
        assertEquals("GET DESDE ABERTURA GLOBAL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getProfissionalSelecionado method, of class VagaBean.
     */
    @Test
    public void testSetAndGetProfissionalSelecionado() {
        System.out.println("set and getProfissionalSelecionado");
        String expResult = "TESTEPROFISSIONAL";
        VagaBean instance = new VagaBean();
        String profissionalSelecionado = "TESTEPROFISSIONAL";
        instance.setProfissionalSelecionado(profissionalSelecionado);
        String result = instance.getProfissionalSelecionado();
        assertEquals("GET PROFISSIONAL SELECIONADO NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getEntrouNaOperacao method, of class VagaBean.
     */
    @Test
    public void testSetAndGetEntrouNaOperacao() throws ParseException {
        System.out.println("set and getEntrouNaOperacao");
        Date expResult = formato.parse("23/11/2015");
        VagaBean instance = new VagaBean();
        Date entrouNaOperacao = formato.parse("23/11/2015");
        instance.setEntrouNaOperacao(entrouNaOperacao);
        Date result = instance.getEntrouNaOperacao();
        assertEquals("GET ENTROU NA OPERAÇÃO NAO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaAprovacao method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaAprovacao() {
        System.out.println("set and getDesdeAberturaAprovacao");
        Integer expResult = 10;
        VagaBean instance = new VagaBean();
        Integer desdeAberturaAprovacao = 10;
        instance.setDesdeAberturaAprovacao(desdeAberturaAprovacao);
        Integer result = instance.getDesdeAberturaAprovacao();
        assertEquals("GET DESDE ABERTURA APROVAÇÃO NÃO FUNCIONOU", expResult, result);
    }
    
    /**
     * Test of set and getRate method, of class VagaBean.
     */
    @Test
    public void testSetAndGetRate() {
        System.out.println("set and getRate");
        Double expResult = 5.00;
        VagaBean instance = new VagaBean();
        Double rate = 5.00;
        instance.setRate(rate);
        Double result = instance.getRate();
        assertEquals("GET RATE NÃO FUNCIONOU", expResult, result);

    }


    /**
     * Test of set and getDesdeExpectativa method, of class VagaBean.
     */
    @Test
    public void testSetAndGetDesdeExpectativa() {
        System.out.println("set and getDesdeExpectativa");
        Integer expResult = 10;
        VagaBean instance = new VagaBean();
        Integer desdeExpectativa = 10;
        instance.setDesdeExpectativa(desdeExpectativa);
        Integer result = instance.getDesdeExpectativa();
        assertEquals("GET DESDE EXPECTATIVA NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getImpactoFinanceiro method, of class VagaBean.
     */
    @Test
    public void testSetAndGetImpactoFinanceiro() {
        System.out.println("getImpactoFinanceiro");
        VagaBean instance = new VagaBean();
        Double impactoFinanceiro = 1000.00;
        instance.setImpactoFinanceiro(impactoFinanceiro);
        Double expResult = 1000.00;
        Double result = instance.getImpactoFinanceiro();
        assertEquals("GET IMPACTO FINANCEIRO NÃO FUNCIONOU", expResult, result);

    }


    /**
     * Test of set and getComentario method, of class VagaBean.
     */
    @Test
    public void testSetAndGetComentario() {
        System.out.println("getComentario");
        String expResult = "TESTECOMENTARIO";
        VagaBean instance = new VagaBean();
        String comentario = "TESTECOMENTARIO";
        instance.setComentario(comentario);
        String result = instance.getComentario();
        assertEquals("GET COMENTARIO NÃO FUNCIONOU", expResult, result);

    }


    /**
     * Test of set and getCategoria method, of class VagaBean.
     */
    @Test
    public void testSetAndGetCategoria() {
        System.out.println("getCategoria");
        String expResult = "TESTECATEGORIA";
        VagaBean instance = new VagaBean();
        String categoria = "TESTECATEGORIA";
        instance.setCategoria(categoria);
        String result = instance.getCategoria();
        assertEquals("GET CATEGORIA NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getCandidatoCollection method, of class VagaBean.
     */
    @Test
    public void testSetAndGetCandidatoCollection() {
        System.out.println("set and getCandidatoCollection");
        Collection<Candidato> expResult = null;
        VagaBean instance = new VagaBean();
        Collection<Candidato> candidatoCollection = null;
        instance.setCandidatoCollection(candidatoCollection);
        Collection<Candidato> result = instance.getCandidatoCollection();
        assertEquals("GET CANDIDATO NÃO FUNCIONOU", expResult, result);

    }

}