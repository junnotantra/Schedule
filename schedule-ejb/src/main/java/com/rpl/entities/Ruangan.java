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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ruangan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruangan.findAll", query = "SELECT r FROM Ruangan r"),
    @NamedQuery(name = "Ruangan.findByIdRuangan", query = "SELECT r FROM Ruangan r WHERE r.idRuangan = :idRuangan"),
    @NamedQuery(name = "Ruangan.findByNmRuangan", query = "SELECT r FROM Ruangan r WHERE r.nmRuangan = :nmRuangan")})
public class Ruangan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_ruangan")
    private String idRuangan;
    @Size(max = 100)
    @Column(name = "nm_ruangan")
    private String nmRuangan;
    @OneToMany(mappedBy = "idRuangan")
    private Collection<JdwlSmnSdg> jdwlSmnSdgCollection;

    public Ruangan() {
    }

    public Ruangan(String idRuangan) {
        this.idRuangan = idRuangan;
    }

    public String getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(String idRuangan) {
        this.idRuangan = idRuangan;
    }

    public String getNmRuangan() {
        return nmRuangan;
    }

    public void setNmRuangan(String nmRuangan) {
        this.nmRuangan = nmRuangan;
    }

    @XmlTransient
    public Collection<JdwlSmnSdg> getJdwlSmnSdgCollection() {
        return jdwlSmnSdgCollection;
    }

    public void setJdwlSmnSdgCollection(Collection<JdwlSmnSdg> jdwlSmnSdgCollection) {
        this.jdwlSmnSdgCollection = jdwlSmnSdgCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuangan != null ? idRuangan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruangan)) {
            return false;
        }
        Ruangan other = (Ruangan) object;
        if ((this.idRuangan == null && other.idRuangan != null) || (this.idRuangan != null && !this.idRuangan.equals(other.idRuangan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Ruangan[ idRuangan=" + idRuangan + " ]";
    }
    
}
