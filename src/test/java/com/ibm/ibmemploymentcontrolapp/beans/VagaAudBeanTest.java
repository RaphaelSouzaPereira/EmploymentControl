/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 */
public class VagaAudBeanTest {

    VagaAudBean vagaaudbean;
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
    String motivoAtualizacao = "MOTIVOATUALIZACAO";
    Date dataAudit;

    public VagaAudBeanTest() throws ParseException {
        this.dataDeAbertura = formato.parse("23/11/2015");
        this.expectativaDeEntrada = formato.parse("23/11/2015");
        this.aprovacaoBoardBrasil = formato.parse("23/11/2015");
        this.aprovacaoBoardGlobal = formato.parse("23/11/2015");
        this.entrouNaOperacao = formato.parse("23/11/2015");
        this.dataAudit = formato.parse("23/11/2015");
    }

    @Before
    public void setUp() {
        vagaaudbean = new VagaAudBean();
    }

    @After
    public void tearDown() {
        vagaaudbean = null;

    }

    @Test
    public void testConstrutors() {
        assertNotNull("VagaAudBean não foi criado", vagaaudbean);
        VagaAudBean vagaaudbean2 = new VagaAudBean(status, pmp,
                dataDeAbertura, expectativaDeEntrada,
                expectativaDeAbertura, area, banda, tipo,
                tecnologia, detalhe, aprovacaoBoardBrasil,
                desdeAberturaBrasil, aprovacaoBoardGlobal,
                desdeAberturaGlobal, profissionalSelecionado,
                entrouNaOperacao, desdeAberturaAprovacao, rate,
                desdeExpectativa, impactoFinanceiro, comentario,
                categoria, dataAudit, motivoAtualizacao);
        assertNotNull("VAGAAUDBEAN2 não foi criado.", vagaaudbean2);
        assertEquals("STATUS não foi pego pelo construtor.", status, vagaaudbean2.getStatus());
        assertEquals("PMP não foi pego pelo construtor", new Long(pmp), new Long(vagaaudbean2.getPmp()));
        assertTrue("DATADEABERTURA não foi pego pelo construtor.", dataDeAbertura.equals(vagaaudbean2.getDataDeAbertura()));
        assertTrue("EXPECTATIVADEENTRADA não foi pego pelo construtor.", expectativaDeEntrada.equals(vagaaudbean2.getExpectativaDeEntrada()));
        assertEquals("EXPECTATIVADEABERTURA não foi pego pelo construtor.", new Long(expectativaDeAbertura), new Long(vagaaudbean2.getExpectativaDeAbertura()));
        assertEquals("AREA não foi pego pelo construtor.", area, vagaaudbean2.getArea());
        assertEquals("BANDA não foi pego pelo construtor.", banda, vagaaudbean2.getBanda());
        assertEquals("TIPO não foi pego pelo construtor.", tipo, vagaaudbean2.getTipo());
        assertEquals("TECNOLOGIA não foi pego pelo construtor.", tecnologia, vagaaudbean2.getTecnologia());
        assertEquals("DETALHE não foi pego pelo construtor.", detalhe, vagaaudbean2.getDetalhe());
        assertTrue("APROVACAOBOARDBRASIL não foi pego pelo construtor.", aprovacaoBoardBrasil.equals(vagaaudbean2.getAprovacaoBoardBrasil()));
        assertEquals("DESDEABERTURABRASIL não foi pego pelo construtor.", new Long(desdeAberturaBrasil), new Long(vagaaudbean2.getDesdeAberturaBrasil()));
        assertTrue("APROVACAOBOARDGLOBAL não foi pego pelo construtor.", aprovacaoBoardGlobal.equals(vagaaudbean2.getAprovacaoBoardGlobal()));
        assertEquals("PROFISSIONALSELECIONADO não foi pego pelo construtor.", profissionalSelecionado, vagaaudbean2.getProfissionalSelecionado());
        assertTrue("ENTROUNAOPERACAO não foi pego pelo construtor.", entrouNaOperacao.equals(vagaaudbean2.getEntrouNaOperacao()));
        assertEquals("DESDEABERTURAAPROVACAO não foi pego pelo construtor.", new Long(desdeAberturaAprovacao), new Long(vagaaudbean2.getDesdeAberturaAprovacao()));
        assertEquals("RATE não foi pego pelo construtor.", rate, vagaaudbean2.getRate());
        assertEquals("DESDEEXPECTATIVA não foi pego pelo construtor.", new Long(desdeExpectativa), new Long(vagaaudbean2.getDesdeExpectativa()));
        assertEquals("IMPACTOFINANCEIRO não foi pego pelo construtor.", impactoFinanceiro, vagaaudbean2.getImpactoFinanceiro());
        assertEquals("COMENTARIO não foi pego pelo construtor.", comentario, vagaaudbean2.getComentario());
        assertEquals("CATEGORIA não foi pego pelo construtor.", categoria, vagaaudbean2.getCategoria());
        assertTrue("DATAAUDIT não foi pego pelo construtor.", dataAudit.equals(vagaaudbean2.getDataAudit()));
        assertEquals("MOTIVOATUALIZACAO não foi pego pelo construtor.", motivoAtualizacao, vagaaudbean2.getMotivoAtualizacao());
    }

    /**
     * Test of set and getStatus method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetStatus() {
        System.out.println("set and getStatus");
        String expResult = "TESTESTATUS";
        String status = "TESTESTATUS";
        VagaAudBean instance = new VagaAudBean();
        instance.setStatus(status);
        String result = instance.getStatus();
        assertEquals("GET STATUS NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getPmp method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetPmp() {
        System.out.println("set and getPmp");
        Integer expResult = 123456;
        VagaAudBean instance = new VagaAudBean();
        Integer pmp = 123456;
        instance.setPmp(pmp);
        Integer result = instance.getPmp();
        assertEquals("GET PMP NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDataDeAbertura method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDataDeAbertura() throws ParseException {
        System.out.println("set and getDataDeAbertura");
        Date expResult = formato.parse("23/11/2015");
        Date dataDeAbertura = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        instance.setDataDeAbertura(dataDeAbertura);
        Date result = instance.getDataDeAbertura();
        assertEquals("GET DATA DE ABERTURA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getExpectativaDeEntrada method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetExpectativaDeEntrada() throws ParseException {
        System.out.println("set and getExpectativaDeEntrada");
        Date expResult = formato.parse("23/11/2015");
        Date expectativaDeEntrada = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        instance.setExpectativaDeEntrada(expectativaDeEntrada);
        Date result = instance.getExpectativaDeEntrada();
        assertEquals("GET EXPECTATIVA DE ENTRADA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getExpectativaDeAbertura method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetExpectativaDeAbertura() {
        System.out.println("set and getExpectativaDeAbertura");
        Integer expResult = 10;
        Integer expectativaDeAbertura = 10;
        VagaAudBean instance = new VagaAudBean();
        instance.setExpectativaDeAbertura(expectativaDeAbertura);
        Integer result = instance.getExpectativaDeAbertura();
        assertEquals("GET EXPECTATIVA DE ABERTURA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getArea method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetArea() {
        System.out.println("set and getArea");
        String expResult = "TESTEAREA";
        String area = "TESTEAREA";
        VagaAudBean instance = new VagaAudBean();
        instance.setArea(area);
        String result = instance.getArea();
        assertEquals("GET AREA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getBanda method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetBanda() {
        System.out.println("set and getBanda");
        String expResult = "T";
        VagaAudBean instance = new VagaAudBean();
        String banda = "T";
        instance.setBanda(banda);
        String result = instance.getBanda();
        assertEquals("GET BANDA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getTipo method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetTipo() {
        System.out.println("set and getTipo");
        String expResult = "TESTETIPO";
        VagaAudBean instance = new VagaAudBean();
        String tipo = "TESTETIPO";
        instance.setTipo(tipo);
        String result = instance.getTipo();
        assertEquals("GET TIPO NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getTecnologia method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetTecnologia() {
        System.out.println("set and getTecnologia");
        String expResult = "TESTETECNOLOGIA";
        VagaAudBean instance = new VagaAudBean();
        String tecnologia = "TESTETECNOLOGIA";
        instance.setTecnologia(tecnologia);
        String result = instance.getTecnologia();
        assertEquals("GET TECNOLOGIA NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDetalhe method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDetalhe() {
        System.out.println("set and getDetalhe");
        String expResult = "TESTEDETALHE";
        VagaAudBean instance = new VagaAudBean();
        String detalhe = "TESTEDETALHE";
        instance.setDetalhe(detalhe);
        String result = instance.getDetalhe();
        assertEquals("GET DETALHE NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getAprovacaoBoardBrasil method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetAprovacaoBoardBrasil() throws ParseException {
        System.out.println("set and getAprovacaoBoardBrasil");
        Date expResult = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        Date aprovacaoBoardBrasil = formato.parse("23/11/2015");
        instance.setAprovacaoBoardBrasil(aprovacaoBoardBrasil);
        Date result = instance.getAprovacaoBoardBrasil();
        assertEquals("GET APROVAÇÃO BOARD BRASIL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaBrasil method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaBrasil() {
        System.out.println("set and getDesdeAberturaBrasil");
        Integer expResult = 5;
        VagaAudBean instance = new VagaAudBean();
        Integer desdeAberturaBrasil = 5;
        instance.setDesdeAberturaBrasil(desdeAberturaBrasil);
        Integer result = instance.getDesdeAberturaBrasil();
        assertEquals("GET DESDE ABERTURA BRASIL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getAprovacaoBoardGlobal method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetAprovacaoBoardGlobal() throws ParseException {
        System.out.println("set and getAprovacaoBoardGlobal");
        Date expResult = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        Date aprovacaoBoardGlobal = formato.parse("23/11/2015");
        instance.setAprovacaoBoardGlobal(aprovacaoBoardGlobal);
        Date result = instance.getAprovacaoBoardGlobal();
        assertEquals("GET APROVAÇÃO BOARD GLOBAL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaGlobal method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaGlobal() {
        System.out.println("getDesdeAberturaGlobal");
        Integer expResult = 6;
        VagaAudBean instance = new VagaAudBean();
        Integer desdeAberturaGlobal = 6;
        instance.setDesdeAberturaGlobal(desdeAberturaGlobal);
        Integer result = instance.getDesdeAberturaGlobal();
        assertEquals("GET DESDE ABERTURA GLOBAL NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getProfissionalSelecionado method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetProfissionalSelecionado() {
        System.out.println("set and getProfissionalSelecionado");
        String expResult = "TESTEPROFISSIONAL";
        VagaAudBean instance = new VagaAudBean();
        String profissionalSelecionado = "TESTEPROFISSIONAL";
        instance.setProfissionalSelecionado(profissionalSelecionado);
        String result = instance.getProfissionalSelecionado();
        assertEquals("GET PROFISSIONAL SELECIONADO NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getEntrouNaOperacao method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetEntrouNaOperacao() throws ParseException {
        System.out.println("set and getEntrouNaOperacao");
        Date expResult = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        Date entrouNaOperacao = formato.parse("23/11/2015");
        instance.setEntrouNaOperacao(entrouNaOperacao);
        Date result = instance.getEntrouNaOperacao();
        assertEquals("GET ENTROU NA OPERAÇÃO NAO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getDesdeAberturaAprovacao method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDesdeAberturaAprovacao() {
        System.out.println("set and getDesdeAberturaAprovacao");
        Integer expResult = 10;
        VagaAudBean instance = new VagaAudBean();
        Integer desdeAberturaAprovacao = 10;
        instance.setDesdeAberturaAprovacao(desdeAberturaAprovacao);
        Integer result = instance.getDesdeAberturaAprovacao();
        assertEquals("GET DESDE ABERTURA APROVAÇÃO NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getRate method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetRate() {
        System.out.println("set and getRate");
        Double expResult = 5.00;
        VagaAudBean instance = new VagaAudBean();
        Double rate = 5.00;
        instance.setRate(rate);
        Double result = instance.getRate();
        assertEquals("GET RATE NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getDesdeExpectativa method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDesdeExpectativa() {
        System.out.println("set and getDesdeExpectativa");
        Integer expResult = 10;
        VagaAudBean instance = new VagaAudBean();
        Integer desdeExpectativa = 10;
        instance.setDesdeExpectativa(desdeExpectativa);
        Integer result = instance.getDesdeExpectativa();
        assertEquals("GET DESDE EXPECTATIVA NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getImpactoFinanceiro method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetImpactoFinanceiro() {
        System.out.println("getImpactoFinanceiro");
        VagaAudBean instance = new VagaAudBean();
        Double impactoFinanceiro = 1000.00;
        instance.setImpactoFinanceiro(impactoFinanceiro);
        Double expResult = 1000.00;
        Double result = instance.getImpactoFinanceiro();
        assertEquals("GET IMPACTO FINANCEIRO NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getComentario method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetComentario() {
        System.out.println("getComentario");
        String expResult = "TESTECOMENTARIO";
        VagaAudBean instance = new VagaAudBean();
        String comentario = "TESTECOMENTARIO";
        instance.setComentario(comentario);
        String result = instance.getComentario();
        assertEquals("GET COMENTARIO NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getCategoria method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetCategoria() {
        System.out.println("getCategoria");
        String expResult = "TESTECATEGORIA";
        VagaAudBean instance = new VagaAudBean();
        String categoria = "TESTECATEGORIA";
        instance.setCategoria(categoria);
        String result = instance.getCategoria();
        assertEquals("GET CATEGORIA NÃO FUNCIONOU", expResult, result);

    }

    /**
     * Test of set and getDataAudir method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetDataAudit() throws ParseException {
        System.out.println("set and getDataAudit");
        Date expResult = formato.parse("23/11/2015");
        Date dataAudit = formato.parse("23/11/2015");
        VagaAudBean instance = new VagaAudBean();
        instance.setDataDeAbertura(dataAudit);
        Date result = instance.getDataDeAbertura();
        assertEquals("GET DATA AUDIT NÃO FUNCIONOU", expResult, result);
    }

    /**
     * Test of set and getMotivo method, of class VagaAudBean.
     */
    @Test
    public void testSetAndGetMotivo() {
        System.out.println("set and getMotivo");
        String expResult = "MOTIVOATUALIZACAO";
        String motivo = "MOTIVOATUALIZACAO";
        VagaAudBean instance = new VagaAudBean();
        instance.setMotivoAtualizacao(motivo);
        String result = instance.getMotivoAtualizacao();
        assertEquals("GET STATUS NÃO FUNCIONOU", expResult, result);
    }

}
