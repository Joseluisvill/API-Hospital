/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.proyectojic.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jose Luis
 */
@Entity
@Table(name = "hospital")
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findById", query = "SELECT h FROM Hospital h WHERE h.id = :id"),
    @NamedQuery(name = "Hospital.findByNombre", query = "SELECT h FROM Hospital h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hospital.findByProvincia", query = "SELECT h FROM Hospital h WHERE h.provincia = :provincia"),
    @NamedQuery(name = "Hospital.findByDistrito", query = "SELECT h FROM Hospital h WHERE h.distrito = :distrito"),
    @NamedQuery(name = "Hospital.findByCorregimiento", query = "SELECT h FROM Hospital h WHERE h.corregimiento = :corregimiento")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "distrito")
    private String distrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "corregimiento")
    private String corregimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhospital")
    private Collection<Medicamentos> medicamentosCollection;

    public Hospital() {
    }

    public Hospital(Integer id) {
        this.id = id;
    }

    public Hospital(Integer id, String nombre, String provincia, String distrito, String corregimiento) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.distrito = distrito;
        this.corregimiento = corregimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(String corregimiento) {
        this.corregimiento = corregimiento;
    }

    public Collection<Medicamentos> getMedicamentosCollection() {
        return medicamentosCollection;
    }

    public void setMedicamentosCollection(Collection<Medicamentos> medicamentosCollection) {
        this.medicamentosCollection = medicamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jose.consumidora.controllers.Hospital[ id=" + id + " ]";
    }
    
}
