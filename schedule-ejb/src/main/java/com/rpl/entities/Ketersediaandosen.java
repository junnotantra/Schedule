/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rpl.entities;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junta
 */
@Entity
@Table(name = "ketersediaandosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ketersediaandosen.findAll", query = "SELECT k FROM Ketersediaandosen k"),
    @NamedQuery(name = "Ketersediaandosen.findByIdKetersediaan", query = "SELECT k FROM Ketersediaandosen k WHERE k.idKetersediaan = :idKetersediaan"),
    @NamedQuery(name = "Ketersediaandosen.findByWaktuAwal", query = "SELECT k FROM Ketersediaandosen k WHERE k.waktuAwal = :waktuAwal"),
    @NamedQuery(name = "Ketersediaandosen.findByWaktuAkhir", query = "SELECT k FROM Ketersediaandosen k WHERE k.waktuAkhir = :waktuAkhir")})
public class Ketersediaandosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ketersediaan")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ktsdn_seq")
    @SequenceGenerator(name = "ktsdn_seq",sequenceName = "seq_ketersediaan_dosen",allocationSize = 1)
    private Long idKetersediaan;
    @Column(name = "waktu_awal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuAwal;
    @Column(name = "waktu_akhir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuAkhir;
    @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")
    @ManyToOne
    private Dosen nikDosen;

    public Ketersediaandosen() {
    }

    public Ketersediaandosen(Long idKetersediaan) {
        this.idKetersediaan = idKetersediaan;
    }

    public Long getIdKetersediaan() {
        return idKetersediaan;
    }

    public void setIdKetersediaan(Long idKetersediaan) {
        this.idKetersediaan = idKetersediaan;
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

    public Dosen getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(Dosen nikDosen) {
        this.nikDosen = nikDosen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKetersediaan != null ? idKetersediaan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ketersediaandosen)) {
            return false;
        }
        Ketersediaandosen other = (Ketersediaandosen) object;
        if ((this.idKetersediaan == null && other.idKetersediaan != null) || (this.idKetersediaan != null && !this.idKetersediaan.equals(other.idKetersediaan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Ketersediaandosen[ idKetersediaan=" + idKetersediaan + " ]";
    }
    
}
