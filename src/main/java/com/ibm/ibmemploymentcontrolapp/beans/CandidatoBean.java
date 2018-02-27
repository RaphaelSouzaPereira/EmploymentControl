/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import com.ibm.ibmemploymentcontrolapp.model.Vaga;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class CandidatoBean implements Serializable{

    private static final long serialVersionUID = -175123748682980746L;
        
    private Integer id;
    private String email;
    private String nome;
    private String comentarios;
    private Collection<Vaga> vagaCollection;

    public CandidatoBean(String email, String nome, String comentarios, Collection<Vaga> vagaCollection) {
        this.email = email;
        this.nome = nome;
        this.comentarios = comentarios;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Collection<Vaga> getVagaCollection() {
        return vagaCollection;
    }

    public void setVagaCollection(Collection<Vaga> vagaCollection) {
        this.vagaCollection = vagaCollection;
    }

}
