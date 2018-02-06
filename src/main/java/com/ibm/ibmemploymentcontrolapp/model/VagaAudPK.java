/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.ibmemploymentcontrolapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 * @param
 * @return   
 */
@Embeddable
public class VagaAudPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REV")
    private int rev;

    public VagaAudPK() {
    }

    public VagaAudPK(int id, int rev) {
        this.id = id;
        this.rev = rev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) rev;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagaAudPK)) {
            return false;
        }
        VagaAudPK other = (VagaAudPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.rev != other.rev) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.ibmemploymentcontrolapp.model.VagaAudPK[ id=" + id + ", rev=" + rev + " ]";
    }

}
