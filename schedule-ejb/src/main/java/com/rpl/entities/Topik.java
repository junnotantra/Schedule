/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rpl.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junta
 */
@Entity
@Table(name = "topik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topik.findAll", query = "SELECT t FROM Topik t"),
    @NamedQuery(name = "Topik.findByIdTopik", query = "SELECT t FROM Topik t WHERE t.idTopik = :idTopik"),
    @NamedQuery(name = "Topik.findByNmTopik", query = "SELECT t FROM Topik t WHERE t.nmTopik = :nmTopik")})
public class Topik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_topik")
    private Integer idTopik;
    @Size(max = 150)
    @Column(name = "nm_topik")
    private String nmTopik;
    @ManyToMany(mappedBy = "topikCollection")
    private Collection<KaryaAkhir> karyaAkhirCollection;

    public Topik() {
    }

    public Topik(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public Integer getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public String getNmTopik() {
        return nmTopik;
    }

    public void setNmTopik(String nmTopik) {
        this.nmTopik = nmTopik;
    }

    @XmlTransient
    public Collection<KaryaAkhir> getKaryaAkhirCollection() {
        return karyaAkhirCollection;
    }

    public void setKaryaAkhirCollection(Collection<KaryaAkhir> karyaAkhirCollection) {
        this.karyaAkhirCollection = karyaAkhirCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTopik != null ? idTopik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topik)) {
            return false;
        }
        Topik other = (Topik) object;
        if ((this.idTopik == null && other.idTopik != null) || (this.idTopik != null && !this.idTopik.equals(other.idTopik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Topik[ idTopik=" + idTopik + " ]";
    }
    
}
