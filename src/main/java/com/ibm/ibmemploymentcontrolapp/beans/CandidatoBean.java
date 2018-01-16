/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ibm.ibmemploymentcontrol.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCansiMatte
 */
public class CandidatoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    private String email;
    private String nome;
    private String observacao;
    private Collection<VagaBean> vagaCollection;

    public CandidatoBean(Integer id, String email, String nome, String observacao, Collection<VagaBean> vagaCollection) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.observacao = observacao;
        this.vagaCollection = vagaCollection;
    }

    public CandidatoBean() {
    }

    public CandidatoBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public Collection<VagaBean> getVagaCollection() {
        return vagaCollection;
    }

    public void setVagaCollection(Collection<VagaBean> vagaCollection) {
        this.vagaCollection = vagaCollection;
    }

}
