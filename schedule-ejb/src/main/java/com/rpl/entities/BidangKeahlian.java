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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "bidang_keahlian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BidangKeahlian.findAll", query = "SELECT b FROM BidangKeahlian b"),
    @NamedQuery(name = "BidangKeahlian.findByIdBidang", query = "SELECT b FROM BidangKeahlian b WHERE b.idBidang = :idBidang"),
    @NamedQuery(name = "BidangKeahlian.findByNamaBidang", query = "SELECT b FROM BidangKeahlian b WHERE b.namaBidang = :namaBidang")})
public class BidangKeahlian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bidang")
    private Integer idBidang;
    @Size(max = 100)
    @Column(name = "nama_bidang")
    private String namaBidang;
    @JoinTable(name = "bidang_dosen", joinColumns = {
        @JoinColumn(name = "id_bidang", referencedColumnName = "id_bidang")}, inverseJoinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")})
    @ManyToMany
    private Collection<Dosen> dosenCollection;

    public BidangKeahlian() {
    }

    public BidangKeahlian(Integer idBidang) {
        this.idBidang = idBidang;
    }

    public Integer getIdBidang() {
        return idBidang;
    }

    public void setIdBidang(Integer idBidang) {
        this.idBidang = idBidang;
    }

    public String getNamaBidang() {
        return namaBidang;
    }

    public void setNamaBidang(String namaBidang) {
        this.namaBidang = namaBidang;
    }

    @XmlTransient
    public Collection<Dosen> getDosenCollection() {
        return dosenCollection;
    }

    public void setDosenCollection(Collection<Dosen> dosenCollection) {
        this.dosenCollection = dosenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBidang != null ? idBidang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BidangKeahlian)) {
            return false;
        }
        BidangKeahlian other = (BidangKeahlian) object;
        if ((this.idBidang == null && other.idBidang != null) || (this.idBidang != null && !this.idBidang.equals(other.idBidang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.BidangKeahlian[ idBidang=" + idBidang + " ]";
    }
    
}
