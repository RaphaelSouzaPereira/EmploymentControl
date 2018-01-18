/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.beans;

import java.io.Serializable;

/**
 *
 * @author FabioHenriqueGoulart
 */

public class AreaBean implements Serializable {

    private static final long serialVersionUID = -4824536645530013029L;

    private Integer id;
    private String nome;

    public AreaBean(String nome) {
        this.nome = nome;
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
}
