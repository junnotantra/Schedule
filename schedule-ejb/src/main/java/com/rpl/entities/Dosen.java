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
import javax.persistence.ManyToOne;
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
@Table(name = "dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosen.findAll", query = "SELECT d FROM Dosen d"),
    @NamedQuery(name = "Dosen.findByNikDosen", query = "SELECT d FROM Dosen d WHERE d.nikDosen = :nikDosen"),
    @NamedQuery(name = "Dosen.findByNmDosen", query = "SELECT d FROM Dosen d WHERE d.nmDosen = :nmDosen"),
    @NamedQuery(name = "Dosen.findByAlamatDsn", query = "SELECT d FROM Dosen d WHERE d.alamatDsn = :alamatDsn"),
    @NamedQuery(name = "Dosen.findByJnsKlmnDsn", query = "SELECT d FROM Dosen d WHERE d.jnsKlmnDsn = :jnsKlmnDsn")})
public class Dosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nik_dosen")
    private String nikDosen;
    @Size(max = 100)
    @Column(name = "nm_dosen")
    private String nmDosen;
    @Size(max = 200)
    @Column(name = "alamat_dsn")
    private String alamatDsn;
    @Column(name = "jns_klmn_dsn")
    private Integer jnsKlmnDsn;
    @ManyToMany(mappedBy = "dosenCollection")
    private Collection<BidangKeahlian> bidangKeahlianCollection;
    @JoinTable(name = "penguji", joinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")}, inverseJoinColumns = {
        @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")})
    @ManyToMany
    private Collection<SeminarSidang> seminarSidangCollection;
    @ManyToMany(mappedBy = "dosenCollection")
    private Collection<KaryaAkhir> karyaAkhirCollection;
    @OneToMany(mappedBy = "nikDosen")
    private Collection<Ketersediaandosen> ketersediaandosenCollection;
    @JoinColumn(name = "id_koordinator", referencedColumnName = "id_koordinator")
    @ManyToOne
    private Koordinator idKoordinator;

    public Dosen() {
    }

    public Dosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNmDosen() {
        return nmDosen;
    }

    public void setNmDosen(String nmDosen) {
        this.nmDosen = nmDosen;
    }

    public String getAlamatDsn() {
        return alamatDsn;
    }

    public void setAlamatDsn(String alamatDsn) {
        this.alamatDsn = alamatDsn;
    }

    public Integer getJnsKlmnDsn() {
        return jnsKlmnDsn;
    }

    public void setJnsKlmnDsn(Integer jnsKlmnDsn) {
        this.jnsKlmnDsn = jnsKlmnDsn;
    }

    @XmlTransient
    public Collection<BidangKeahlian> getBidangKeahlianCollection() {
        return bidangKeahlianCollection;
    }

    public void setBidangKeahlianCollection(Collection<BidangKeahlian> bidangKeahlianCollection) {
        this.bidangKeahlianCollection = bidangKeahlianCollection;
    }

    @XmlTransient
    public Collection<SeminarSidang> getSeminarSidangCollection() {
        return seminarSidangCollection;
    }

    public void setSeminarSidangCollection(Collection<SeminarSidang> seminarSidangCollection) {
        this.seminarSidangCollection = seminarSidangCollection;
    }

    @XmlTransient
    public Collection<KaryaAkhir> getKaryaAkhirCollection() {
        return karyaAkhirCollection;
    }

    public void setKaryaAkhirCollection(Collection<KaryaAkhir> karyaAkhirCollection) {
        this.karyaAkhirCollection = karyaAkhirCollection;
    }

    @XmlTransient
    public Collection<Ketersediaandosen> getKetersediaandosenCollection() {
        return ketersediaandosenCollection;
    }

    public void setKetersediaandosenCollection(Collection<Ketersediaandosen> ketersediaandosenCollection) {
        this.ketersediaandosenCollection = ketersediaandosenCollection;
    }

    public Koordinator getIdKoordinator() {
        return idKoordinator;
    }

    public void setIdKoordinator(Koordinator idKoordinator) {
        this.idKoordinator = idKoordinator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nikDosen != null ? nikDosen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosen)) {
            return false;
        }
        Dosen other = (Dosen) object;
        if ((this.nikDosen == null && other.nikDosen != null) || (this.nikDosen != null && !this.nikDosen.equals(other.nikDosen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Dosen[ nikDosen=" + nikDosen + " ]";
    }
    
}
