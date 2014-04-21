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
@Table(name = "Karya Akhir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KaryaAkhir.findAll", query = "SELECT k FROM KaryaAkhir k"),
    @NamedQuery(name = "KaryaAkhir.findByIdKa", query = "SELECT k FROM KaryaAkhir k WHERE k.idKa = :idKa"),
    @NamedQuery(name = "KaryaAkhir.findByJudulKa", query = "SELECT k FROM KaryaAkhir k WHERE k.judulKa = :judulKa"),
    @NamedQuery(name = "KaryaAkhir.findByStatusKa", query = "SELECT k FROM KaryaAkhir k WHERE k.statusKa = :statusKa")})
public class KaryaAkhir implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ka")
    private Long idKa;
    @Size(max = 300)
    @Column(name = "judul_ka")
    private String judulKa;
    @Column(name = "status_ka")
    private Integer statusKa;
    @JoinColumn(name = "nim", referencedColumnName = "nim")
    @ManyToOne
    private Mahasiswa nim;
    @JoinColumn(name = "id_jenis_ka", referencedColumnName = "id_jenis_ka")
    @ManyToOne
    private JenisKa idJenisKa;
    @OneToMany(mappedBy = "idKa")
    private Collection<Mahasiswa> mahasiswaCollection;

    public KaryaAkhir() {
    }

    public KaryaAkhir(Long idKa) {
        this.idKa = idKa;
    }

    public Long getIdKa() {
        return idKa;
    }

    public void setIdKa(Long idKa) {
        this.idKa = idKa;
    }

    public String getJudulKa() {
        return judulKa;
    }

    public void setJudulKa(String judulKa) {
        this.judulKa = judulKa;
    }

    public Integer getStatusKa() {
        return statusKa;
    }

    public void setStatusKa(Integer statusKa) {
        this.statusKa = statusKa;
    }

    public Mahasiswa getNim() {
        return nim;
    }

    public void setNim(Mahasiswa nim) {
        this.nim = nim;
    }

    public JenisKa getIdJenisKa() {
        return idJenisKa;
    }

    public void setIdJenisKa(JenisKa idJenisKa) {
        this.idJenisKa = idJenisKa;
    }

    @XmlTransient
    public Collection<Mahasiswa> getMahasiswaCollection() {
        return mahasiswaCollection;
    }

    public void setMahasiswaCollection(Collection<Mahasiswa> mahasiswaCollection) {
        this.mahasiswaCollection = mahasiswaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKa != null ? idKa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KaryaAkhir)) {
            return false;
        }
        KaryaAkhir other = (KaryaAkhir) object;
        if ((this.idKa == null && other.idKa != null) || (this.idKa != null && !this.idKa.equals(other.idKa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.KaryaAkhir[ idKa=" + idKa + " ]";
    }
    
}
