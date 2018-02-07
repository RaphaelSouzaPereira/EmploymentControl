/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.ibmemploymentcontrolapp.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 * @param
 * @return   
 */
@Entity
@Table(name = "revinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revinfo.findAll", query = "SELECT r FROM Revinfo r")
    , @NamedQuery(name = "Revinfo.findByRev", query = "SELECT r FROM Revinfo r WHERE r.rev = :rev")
    , @NamedQuery(name = "Revinfo.findByRevtstmp", query = "SELECT r FROM Revinfo r WHERE r.revtstmp = :revtstmp")})
public class Revinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REV")
    private Integer rev;
    @Column(name = "REVTSTMP")
    private BigInteger revtstmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revinfo", fetch = FetchType.EAGER)
    private Collection<VagaAud> vagaAudCollection;

    public Revinfo() {
    }

    public Revinfo(Integer rev) {
        this.rev = rev;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public BigInteger getRevtstmp() {
        return revtstmp;
    }

    public void setRevtstmp(BigInteger revtstmp) {
        this.revtstmp = revtstmp;
    }

    @XmlTransient
    public Collection<VagaAud> getVagaAudCollection() {
        return vagaAudCollection;
    }

    public void setVagaAudCollection(Collection<VagaAud> vagaAudCollection) {
        this.vagaAudCollection = vagaAudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rev != null ? rev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revinfo)) {
            return false;
        }
        Revinfo other = (Revinfo) object;
        if ((this.rev == null && other.rev != null) || (this.rev != null && !this.rev.equals(other.rev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.ibmemploymentcontrolapp.model.Revinfo[ rev=" + rev + " ]";
    }

}
