/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import com.ibm.ibmemploymentcontrolapp.model.Candidato;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class VagaBean implements Serializable {

    private static final long serialVersionUID = -4160396633631037368L;

    private Integer id;
    private String status;
    private Integer pmp;
    private Date dataDeAbertura;
    private Date expectativaDeEntrada;
    private Integer expectativaDeAbertura;
    private String area;
    private String banda;
    private String tipo;
    private String tecnologia;
    private String detalhe;
    private Date aprovacaoBoardBrasil;
    private Integer desdeAberturaBrasil;
    private Date aprovacaoBoardGlobal;
    private Integer desdeAberturaGlobal;
    private String profissionalSelecionado;
    private Date entrouNaOperacao;
    private Integer desdeAberturaAprovacao;
    private Double rate;
    private Integer desdeExpectativa;
    private Double impactoFinanceiro;
    private String comentario;
    private String categoria;
    private Date dataAudit;
    private String motivoAtualizacao;
    private Collection<Candidato> candidatoCollection;

    public VagaBean(String status, Integer pmp, Date dataDeAbertura, Date expectativaDeEntrada,
            Integer expectativaDeAbertura, String area, String banda, String tipo, String tecnologia,
            String detalhe, Date aprovacaoBoardBrasil, Integer desdeAberturaBrasil, Date aprovacaoBoardGlobal,
            Integer desdeAberturaGlobal, String profissionalSelecionado, Date entrouNaOperacao,
            Integer desdeAberturaAprovacao, Double rate, Integer desdeExpectativa,
            Double impactoFinanceiro, String comentario, String categoria, Collection<Candidato> candidatoCollection,
            Date dataAudit, String motivoAtualizacao) {
        this.status = status;
        this.pmp = pmp;
        this.dataDeAbertura = dataDeAbertura;
        this.expectativaDeEntrada = expectativaDeEntrada;
        this.expectativaDeAbertura = expectativaDeAbertura;
        this.area = area;
        this.banda = banda;
        this.tipo = tipo;
        this.tecnologia = tecnologia;
        this.detalhe = detalhe;
        this.aprovacaoBoardBrasil = aprovacaoBoardBrasil;
        this.desdeAberturaBrasil = desdeAberturaBrasil;
        this.aprovacaoBoardGlobal = aprovacaoBoardGlobal;
        this.desdeAberturaGlobal = desdeAberturaGlobal;
        this.profissionalSelecionado = profissionalSelecionado;
        this.entrouNaOperacao = entrouNaOperacao;
        this.desdeAberturaAprovacao = desdeAberturaAprovacao;
        this.rate = rate;
        this.desdeExpectativa = desdeExpectativa;
        this.impactoFinanceiro = impactoFinanceiro;
        this.comentario = comentario;
        this.categoria = categoria;
        this.dataAudit = dataAudit;
        this.motivoAtualizacao = motivoAtualizacao;
        this.candidatoCollection = candidatoCollection;
    }

    public VagaBean() {
    }

    public VagaBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPmp() {
        return pmp;
    }

    public void setPmp(Integer pmp) {
        this.pmp = pmp;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Date getExpectativaDeEntrada() {
        return expectativaDeEntrada;
    }

    public void setExpectativaDeEntrada(Date expectativaDeEntrada) {
        this.expectativaDeEntrada = expectativaDeEntrada;
    }

    public Integer getExpectativaDeAbertura() {
        return expectativaDeAbertura;
    }

    public void setExpectativaDeAbertura(Integer expectativaDeAbertura) {
        this.expectativaDeAbertura = expectativaDeAbertura;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Date getAprovacaoBoardBrasil() {
        return aprovacaoBoardBrasil;
    }

    public void setAprovacaoBoardBrasil(Date aprovacaoBoardBrasil) {
        this.aprovacaoBoardBrasil = aprovacaoBoardBrasil;
    }

    public Integer getDesdeAberturaBrasil() {
        return desdeAberturaBrasil;
    }

    public void setDesdeAberturaBrasil(Integer desdeAberturaBrasil) {
        this.desdeAberturaBrasil = desdeAberturaBrasil;
    }

    public Date getAprovacaoBoardGlobal() {
        return aprovacaoBoardGlobal;
    }

    public void setAprovacaoBoardGlobal(Date aprovacaoBoardGlobal) {
        this.aprovacaoBoardGlobal = aprovacaoBoardGlobal;
    }

    public Integer getDesdeAberturaGlobal() {
        return desdeAberturaGlobal;
    }

    public void setDesdeAberturaGlobal(Integer desdeAberturaGlobal) {
        this.desdeAberturaGlobal = desdeAberturaGlobal;
    }

    public String getProfissionalSelecionado() {
        return profissionalSelecionado;
    }

    public void setProfissionalSelecionado(String profissionalSelecionado) {
        this.profissionalSelecionado = profissionalSelecionado;
    }

    public Date getEntrouNaOperacao() {
        return entrouNaOperacao;
    }

    public void setEntrouNaOperacao(Date entrouNaOperacao) {
        this.entrouNaOperacao = entrouNaOperacao;
    }

    public Integer getDesdeAberturaAprovacao() {
        return desdeAberturaAprovacao;
    }

    public void setDesdeAberturaAprovacao(Integer desdeAberturaAprovacao) {
        this.desdeAberturaAprovacao = desdeAberturaAprovacao;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getDesdeExpectativa() {
        return desdeExpectativa;
    }

    public void setDesdeExpectativa(Integer desdeExpectativa) {
        this.desdeExpectativa = desdeExpectativa;
    }

    public Double getImpactoFinanceiro() {
        return impactoFinanceiro;
    }

    public void setImpactoFinanceiro(Double impactoFinanceiro) {
        this.impactoFinanceiro = impactoFinanceiro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Collection<Candidato> getCandidatoCollection() {
        return candidatoCollection;
    }

    public void setCandidatoCollection(Collection<Candidato> candidatoCollection) {
        this.candidatoCollection = candidatoCollection;
    }
    
     public Date getDataAudit() {
        return dataAudit;
    }

    public void setDataAudit(Date dataAudit) {
        this.dataAudit = dataAudit;
    }

    public String getMotivoAtualizacao() {
        return motivoAtualizacao;
    }

    public void setMotivoAtualizacao(String motivoAtualizacao) {
        this.motivoAtualizacao = motivoAtualizacao;
    }
}
