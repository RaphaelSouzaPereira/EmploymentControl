/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.ibmemploymentcontrolapp.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findById", query = "SELECT c FROM Candidato c WHERE c.id = :id")
    , @NamedQuery(name = "Candidato.findByEmail", query = "SELECT c FROM Candidato c WHERE c.email = :email")
    , @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Candidato.findByFilter", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
//    @JoinTable(name = "vaga_candidato", joinColumns = {
//        @JoinColumn(name = "id_candidato", referencedColumnName = "id")}, inverseJoinColumns = {
//        @JoinColumn(name = "id_vaga", referencedColumnName = "id")})
//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "candidatoCollection", fetch = FetchType.EAGER)
    private Collection<Vaga> vagaCollection;

    public Candidato() {
    }

    public Candidato(Integer id) {
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
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.ibmemploymentcontrolapp.model.Candidato[ id=" + id + " ]";
    }

}
