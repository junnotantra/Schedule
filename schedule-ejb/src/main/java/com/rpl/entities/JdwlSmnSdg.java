/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rpl.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junta
 */
@Entity
@Table(name = "jdwl_smn_sdg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JdwlSmnSdg.findAll", query = "SELECT j FROM JdwlSmnSdg j"),
    @NamedQuery(name = "JdwlSmnSdg.findByIdJdwSs", query = "SELECT j FROM JdwlSmnSdg j WHERE j.idJdwSs = :idJdwSs"),
    @NamedQuery(name = "JdwlSmnSdg.findByWaktuAwal", query = "SELECT j FROM JdwlSmnSdg j WHERE j.waktuAwal = :waktuAwal"),
    @NamedQuery(name = "JdwlSmnSdg.findByWaktuAkhir", query = "SELECT j FROM JdwlSmnSdg j WHERE j.waktuAkhir = :waktuAkhir")})
public class JdwlSmnSdg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jdw_ss")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "jadwal_seq")
    @SequenceGenerator(name = "jadwal_seq",sequenceName = "seq_jdwl_smn_sdg",allocationSize = 1)
    private Long idJdwSs;
    @Column(name = "waktu_awal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuAwal;
    @Column(name = "waktu_akhir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuAkhir;
    @OneToMany(mappedBy = "idJdwSs")
    private Collection<SeminarSidang> seminarSidangCollection;
    @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")
    @ManyToOne
    private SeminarSidang idSmnsdg;
    @JoinColumn(name = "id_ruangan", referencedColumnName = "id_ruangan")
    @ManyToOne
    private Ruangan idRuangan;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne
    private Periode idPeriode;

    public JdwlSmnSdg() {
    }

    public JdwlSmnSdg(Long idJdwSs) {
        this.idJdwSs = idJdwSs;
    }

    public Long getIdJdwSs() {
        return idJdwSs;
    }

    public void setIdJdwSs(Long idJdwSs) {
        this.idJdwSs = idJdwSs;
    }

    public Date getWaktuAwal() {
        return waktuAwal;
    }

    public void setWaktuAwal(Date waktuAwal) {
        this.waktuAwal = waktuAwal;
    }

    public Date getWaktuAkhir() {
        return waktuAkhir;
    }

    public void setWaktuAkhir(Date waktuAkhir) {
        this.waktuAkhir = waktuAkhir;
    }

    @XmlTransient
    public Collection<SeminarSidang> getSeminarSidangCollection() {
        return seminarSidangCollection;
    }

    public void setSeminarSidangCollection(Collection<SeminarSidang> seminarSidangCollection) {
        this.seminarSidangCollection = seminarSidangCollection;
    }

    public SeminarSidang getIdSmnsdg() {
        return idSmnsdg;
    }

    public void setIdSmnsdg(SeminarSidang idSmnsdg) {
        this.idSmnsdg = idSmnsdg;
    }

    public Ruangan getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(Ruangan idRuangan) {
        this.idRuangan = idRuangan;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJdwSs != null ? idJdwSs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JdwlSmnSdg)) {
            return false;
        }
        JdwlSmnSdg other = (JdwlSmnSdg) object;
        if ((this.idJdwSs == null && other.idJdwSs != null) || (this.idJdwSs != null && !this.idJdwSs.equals(other.idJdwSs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.JdwlSmnSdg[ idJdwSs=" + idJdwSs + " ]";
    }
    
}
