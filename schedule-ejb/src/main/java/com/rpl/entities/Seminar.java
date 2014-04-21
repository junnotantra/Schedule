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
@Table(name = "seminar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seminar.findAll", query = "SELECT s FROM Seminar s"),
    @NamedQuery(name = "Seminar.findByIdSeminar", query = "SELECT s FROM Seminar s WHERE s.idSeminar = :idSeminar"),
    @NamedQuery(name = "Seminar.findByKetSeminar", query = "SELECT s FROM Seminar s WHERE s.ketSeminar = :ketSeminar")})
public class Seminar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_seminar")
    private Long idSeminar;
    @Size(max = 150)
    @Column(name = "ket_seminar")
    private String ketSeminar;
    @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")
    @ManyToOne
    private SeminarSidang idSmnsdg;

    public Seminar() {
    }

    public Seminar(Long idSeminar) {
        this.idSeminar = idSeminar;
    }

    public Long getIdSeminar() {
        return idSeminar;
    }

    public void setIdSeminar(Long idSeminar) {
        this.idSeminar = idSeminar;
    }

    public String getKetSeminar() {
        return ketSeminar;
    }

    public void setKetSeminar(String ketSeminar) {
        this.ketSeminar = ketSeminar;
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
        hash += (idSeminar != null ? idSeminar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seminar)) {
            return false;
        }
        Seminar other = (Seminar) object;
        if ((this.idSeminar == null && other.idSeminar != null) || (this.idSeminar != null && !this.idSeminar.equals(other.idSeminar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Seminar[ idSeminar=" + idSeminar + " ]";
    }
    
}
