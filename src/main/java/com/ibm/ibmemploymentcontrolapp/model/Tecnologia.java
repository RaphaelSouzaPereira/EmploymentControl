/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.treinamento.exercicio.ibmemploymentcontrolapp.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 * @param
 * @return   
 */
@Entity
@Table(name = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnologia.findAll", query = "SELECT t FROM Tecnologia t")
    , @NamedQuery(name = "Tecnologia.findById", query = "SELECT t FROM Tecnologia t WHERE t.id = :id")
    , @NamedQuery(name = "Tecnologia.findByNome", query = "SELECT t FROM Tecnologia t WHERE t.nome = :nome")})
public class Tecnologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "tecnologia")
    private Collection<Vaga> vagaCollection;

    public Tecnologia() {
    }

    public Tecnologia(Integer id) {
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
    public Collection<Vaga> getVagaCollection() {
        return vagaCollection;
    }

    public void setVagaCollection(Collection<Vaga> vagaCollection) {
        this.vagaCollection = vagaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnologia)) {
            return false;
        }
        Tecnologia other = (Tecnologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.treinamento.exercicio.ibmemploymentcontrolapp.model.Tecnologia[ id=" + id + " ]";
    }

}
