/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.proyectoprueba;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "TRABAJADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t"),
    @NamedQuery(name = "Trabajadores.findById", query = "SELECT t FROM Trabajadores t WHERE t.id = :id"),
    @NamedQuery(name = "Trabajadores.findByNombre", query = "SELECT t FROM Trabajadores t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Trabajadores.findByPuesto", query = "SELECT t FROM Trabajadores t WHERE t.puesto = :puesto"),
    @NamedQuery(name = "Trabajadores.findBySalario", query = "SELECT t FROM Trabajadores t WHERE t.salario = :salario")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "PUESTO")
    private String puesto;
    @Column(name = "SALARIO")
    private BigDecimal salario;

    public Trabajadores() {
    }

    public Trabajadores(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
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
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.proyectoprueba.Trabajadores[ id=" + id + " ]";
    }
    
}
