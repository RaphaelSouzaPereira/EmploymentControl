/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCansiMatte
 */
public class AreaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private Collection<VagaBean> vagaCollection;

    public AreaBean(Integer id, String nome, Collection<VagaBean> vagaCollection) {
        this.id = id;
        this.nome = nome;
        this.vagaCollection = vagaCollection;
    }
    
    public AreaBean() {
    }

    public AreaBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<VagaBean> getVagaCollection() {
        return vagaCollection;
    }

    public void setVagaCollection(Collection<VagaBean> vagaCollection) {
        this.vagaCollection = vagaCollection;
    }
    
}
