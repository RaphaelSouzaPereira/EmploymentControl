/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 * @param
 * @return
 */
@Entity
@Table(name = "vaga_aud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VagaAud.findAll", query = "SELECT v FROM VagaAud v")
    , @NamedQuery(name = "VagaAud.findById", query = "SELECT v FROM VagaAud v WHERE v.vagaAudPK.id = :id")
    , @NamedQuery(name = "VagaAud.findByRev", query = "SELECT v FROM VagaAud v WHERE v.vagaAudPK.rev = :rev")
    , @NamedQuery(name = "VagaAud.findByRevtype", query = "SELECT v FROM VagaAud v WHERE v.revtype = :revtype")
    , @NamedQuery(name = "VagaAud.findByAprovacaoBoardBrasil", query = "SELECT v FROM VagaAud v WHERE v.aprovacaoBoardBrasil = :aprovacaoBoardBrasil")
    , @NamedQuery(name = "VagaAud.findByAprovacaoBoardGlobal", query = "SELECT v FROM VagaAud v WHERE v.aprovacaoBoardGlobal = :aprovacaoBoardGlobal")
    , @NamedQuery(name = "VagaAud.findByArea", query = "SELECT v FROM VagaAud v WHERE v.area = :area")
    , @NamedQuery(name = "VagaAud.findByBanda", query = "SELECT v FROM VagaAud v WHERE v.banda = :banda")
    , @NamedQuery(name = "VagaAud.findByCategoria", query = "SELECT v FROM VagaAud v WHERE v.categoria = :categoria")
    , @NamedQuery(name = "VagaAud.findByComentario", query = "SELECT v FROM VagaAud v WHERE v.comentario = :comentario")
    , @NamedQuery(name = "VagaAud.findByDataDeAbertura", query = "SELECT v FROM VagaAud v WHERE v.dataDeAbertura = :dataDeAbertura")
    , @NamedQuery(name = "VagaAud.findByDesdeAberturaAprovacao", query = "SELECT v FROM VagaAud v WHERE v.desdeAberturaAprovacao = :desdeAberturaAprovacao")
    , @NamedQuery(name = "VagaAud.findByDesdeAberturaBrasil", query = "SELECT v FROM VagaAud v WHERE v.desdeAberturaBrasil = :desdeAberturaBrasil")
    , @NamedQuery(name = "VagaAud.findByDesdeAberturaGlobal", query = "SELECT v FROM VagaAud v WHERE v.desdeAberturaGlobal = :desdeAberturaGlobal")
    , @NamedQuery(name = "VagaAud.findByDesdeExpectativa", query = "SELECT v FROM VagaAud v WHERE v.desdeExpectativa = :desdeExpectativa")
    , @NamedQuery(name = "VagaAud.findByDetalhe", query = "SELECT v FROM VagaAud v WHERE v.detalhe = :detalhe")
    , @NamedQuery(name = "VagaAud.findByEntrouNaOperacao", query = "SELECT v FROM VagaAud v WHERE v.entrouNaOperacao = :entrouNaOperacao")
    , @NamedQuery(name = "VagaAud.findByExpectativaDeAbertura", query = "SELECT v FROM VagaAud v WHERE v.expectativaDeAbertura = :expectativaDeAbertura")
    , @NamedQuery(name = "VagaAud.findByExpectativaDeEntrada", query = "SELECT v FROM VagaAud v WHERE v.expectativaDeEntrada = :expectativaDeEntrada")
    , @NamedQuery(name = "VagaAud.findByImpactoFinanceiro", query = "SELECT v FROM VagaAud v WHERE v.impactoFinanceiro = :impactoFinanceiro")
    , @NamedQuery(name = "VagaAud.findByPmp", query = "SELECT v FROM VagaAud v WHERE v.pmp = :pmp")
    , @NamedQuery(name = "VagaAud.findByProfissionalSelecionado", query = "SELECT v FROM VagaAud v WHERE v.profissionalSelecionado = :profissionalSelecionado")
    , @NamedQuery(name = "VagaAud.findByRate", query = "SELECT v FROM VagaAud v WHERE v.rate = :rate")
    , @NamedQuery(name = "VagaAud.findByStatus", query = "SELECT v FROM VagaAud v WHERE v.status = :status")
    , @NamedQuery(name = "VagaAud.findByTecnologia", query = "SELECT v FROM VagaAud v WHERE v.tecnologia = :tecnologia")
    , @NamedQuery(name = "VagaAud.findByTipo", query = "SELECT v FROM VagaAud v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "VagaAud.findByDataAudit", query = "SELECT v FROM VagaAud v WHERE v.dataAudit = :dataAudit")
    , @NamedQuery(name = "VagaAud.findByMotivoAtualizacao", query = "SELECT v FROM VagaAud v WHERE v.motivoAtualizacao = :motivoAtualizacao")})
public class VagaAud implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VagaAudPK vagaAudPK;
    @Column(name = "REVTYPE")
    private Short revtype;
    @Column(name = "aprovacao_board_brasil")
    @Temporal(TemporalType.DATE)
    private Date aprovacaoBoardBrasil;
    @Column(name = "aprovacao_board_global")
    @Temporal(TemporalType.DATE)
    private Date aprovacaoBoardGlobal;
    @Size(max = 255)
    @Column(name = "area")
    private String area;
    @Size(max = 255)
    @Column(name = "banda")
    private String banda;
    @Size(max = 255)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 255)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "data_de_abertura")
    @Temporal(TemporalType.DATE)
    private Date dataDeAbertura;
    @Column(name = "desde_abertura_aprovacao")
    private Integer desdeAberturaAprovacao;
    @Column(name = "desde_abertura_brasil")
    private Integer desdeAberturaBrasil;
    @Column(name = "desde_abertura_global")
    private Integer desdeAberturaGlobal;
    @Column(name = "desde_expectativa")
    private Integer desdeExpectativa;
    @Size(max = 255)
    @Column(name = "detalhe")
    private String detalhe;
    @Column(name = "entrou_na_operacao")
    @Temporal(TemporalType.DATE)
    private Date entrouNaOperacao;
    @Column(name = "expectativa_de_abertura")
    private Integer expectativaDeAbertura;
    @Column(name = "expectativa_de_entrada")
    @Temporal(TemporalType.DATE)
    private Date expectativaDeEntrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impacto_financeiro")
    private Double impactoFinanceiro;
    @Column(name = "pmp")
    private Integer pmp;
    @Size(max = 255)
    @Column(name = "profissional_selecionado")
    private String profissionalSelecionado;
    @Column(name = "rate")
    private Double rate;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "tecnologia")
    private String tecnologia;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "data_audit")
    @Temporal(TemporalType.DATE)
    private Date dataAudit;
    @Size(max = 255)
    @Column(name = "motivo_atualizacao")
    private String motivoAtualizacao;
    @JoinColumn(name = "REV", referencedColumnName = "REV", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Revinfo revinfo;

    public VagaAud() {
    }

    public VagaAud(VagaAudPK vagaAudPK) {
        this.vagaAudPK = vagaAudPK;
    }

    public VagaAud(int id, int rev) {
        this.vagaAudPK = new VagaAudPK(id, rev);
    }

    public VagaAudPK getVagaAudPK() {
        return vagaAudPK;
    }

    public void setVagaAudPK(VagaAudPK vagaAudPK) {
        this.vagaAudPK = vagaAudPK;
    }

    public Short getRevtype() {
        return revtype;
    }

    public void setRevtype(Short revtype) {
        this.revtype = revtype;
    }

    public Date getAprovacaoBoardBrasil() {
        return aprovacaoBoardBrasil;
    }

    public void setAprovacaoBoardBrasil(Date aprovacaoBoardBrasil) {
        this.aprovacaoBoardBrasil = aprovacaoBoardBrasil;
    }

    public Date getAprovacaoBoardGlobal() {
        return aprovacaoBoardGlobal;
    }

    public void setAprovacaoBoardGlobal(Date aprovacaoBoardGlobal) {
        this.aprovacaoBoardGlobal = aprovacaoBoardGlobal;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Integer getDesdeAberturaAprovacao() {
        return desdeAberturaAprovacao;
    }

    public void setDesdeAberturaAprovacao(Integer desdeAberturaAprovacao) {
        this.desdeAberturaAprovacao = desdeAberturaAprovacao;
    }

    public Integer getDesdeAberturaBrasil() {
        return desdeAberturaBrasil;
    }

    public void setDesdeAberturaBrasil(Integer desdeAberturaBrasil) {
        this.desdeAberturaBrasil = desdeAberturaBrasil;
    }

    public Integer getDesdeAberturaGlobal() {
        return desdeAberturaGlobal;
    }

    public void setDesdeAberturaGlobal(Integer desdeAberturaGlobal) {
        this.desdeAberturaGlobal = desdeAberturaGlobal;
    }

    public Integer getDesdeExpectativa() {
        return desdeExpectativa;
    }

    public void setDesdeExpectativa(Integer desdeExpectativa) {
        this.desdeExpectativa = desdeExpectativa;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Date getEntrouNaOperacao() {
        return entrouNaOperacao;
    }

    public void setEntrouNaOperacao(Date entrouNaOperacao) {
        this.entrouNaOperacao = entrouNaOperacao;
    }

    public Integer getExpectativaDeAbertura() {
        return expectativaDeAbertura;
    }

    public void setExpectativaDeAbertura(Integer expectativaDeAbertura) {
        this.expectativaDeAbertura = expectativaDeAbertura;
    }

    public Date getExpectativaDeEntrada() {
        return expectativaDeEntrada;
    }

    public void setExpectativaDeEntrada(Date expectativaDeEntrada) {
        this.expectativaDeEntrada = expectativaDeEntrada;
    }

    public Double getImpactoFinanceiro() {
        return impactoFinanceiro;
    }

    public void setImpactoFinanceiro(Double impactoFinanceiro) {
        this.impactoFinanceiro = impactoFinanceiro;
    }

    public Integer getPmp() {
        return pmp;
    }

    public void setPmp(Integer pmp) {
        this.pmp = pmp;
    }

    public String getProfissionalSelecionado() {
        return profissionalSelecionado;
    }

    public void setProfissionalSelecionado(String profissionalSelecionado) {
        this.profissionalSelecionado = profissionalSelecionado;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Revinfo getRevinfo() {
        return revinfo;
    }

    public void setRevinfo(Revinfo revinfo) {
        this.revinfo = revinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vagaAudPK != null ? vagaAudPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagaAud)) {
            return false;
        }
        VagaAud other = (VagaAud) object;
        if ((this.vagaAudPK == null && other.vagaAudPK != null) || (this.vagaAudPK != null && !this.vagaAudPK.equals(other.vagaAudPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.ibmemploymentcontrolapp.model.VagaAud[ vagaAudPK=" + vagaAudPK + " ]";
    }

}
