/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rpl.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junta
 */
@Entity
@Table(name = "sidang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sidang.findAll", query = "SELECT s FROM Sidang s"),
    @NamedQuery(name = "Sidang.findByIdSidang", query = "SELECT s FROM Sidang s WHERE s.idSidang = :idSidang"),
    @NamedQuery(name = "Sidang.findByKetSidang", query = "SELECT s FROM Sidang s WHERE s.ketSidang = :ketSidang"),
    @NamedQuery(name = "Sidang.findByStatusLulus", query = "SELECT s FROM Sidang s WHERE s.statusLulus = :statusLulus")})
public class Sidang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sidang")
    private Long idSidang;
    @Size(max = 200)
    @Column(name = "ket_sidang")
    private String ketSidang;
    @Column(name = "status_lulus")
    private Integer statusLulus;
    @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")
    @ManyToOne
    private SeminarSidang idSmnsdg;

    public Sidang() {
    }

    public Sidang(Long idSidang) {
        this.idSidang = idSidang;
    }

    public Long getIdSidang() {
        return idSidang;
    }

    public void setIdSidang(Long idSidang) {
        this.idSidang = idSidang;
    }

    public String getKetSidang() {
        return ketSidang;
    }

    public void setKetSidang(String ketSidang) {
        this.ketSidang = ketSidang;
    }

    public Integer getStatusLulus() {
        return statusLulus;
    }

    public void setStatusLulus(Integer statusLulus) {
        this.statusLulus = statusLulus;
    }

    public SeminarSidang getIdSmnsdg() {
        return idSmnsdg;
    }

    public void setIdSmnsdg(SeminarSidang idSmnsdg) {
        this.idSmnsdg = idSmnsdg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSidang != null ? idSidang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sidang)) {
            return false;
        }
        Sidang other = (Sidang) object;
        if ((this.idSidang == null && other.idSidang != null) || (this.idSidang != null && !this.idSidang.equals(other.idSidang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Sidang[ idSidang=" + idSidang + " ]";
    }
    
}
