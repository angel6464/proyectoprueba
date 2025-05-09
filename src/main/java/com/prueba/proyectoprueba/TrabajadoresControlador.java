package com.prueba.proyectoprueba;

import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.math.BigDecimal;

@Named("trabajadoresControlador")
@SessionScoped
public class TrabajadoresControlador implements Serializable {

    private Trabajadores trabajador = new Trabajadores();
    private boolean editando = false;

    @Inject
    private TrabajadoresServicio servicio;

    public Trabajadores getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajadores trabajador) {
        this.trabajador = trabajador;
    }

    public boolean isEditando() {
        return editando;
    }

    public List<Trabajadores> getTrabajadores() {
        return servicio.listarTodos();
    }

    public String guardar() {
        if (!editando) {
            // Validar si el ID ya existe
            if (servicio.buscarPorId(trabajador.getId()) != null) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error YA EXISTE trabajador", " "));
                return null;
            }
            servicio.crear(trabajador);
        } else {
            servicio.actualizar(trabajador);
        }

        trabajador = new Trabajadores(); // Limpiar
        editando = false;
        return null;
    }

    public String eliminar(BigDecimal id) {
        servicio.eliminar(id);
        return null;
    }

    public String editar(BigDecimal id) {
        trabajador = servicio.buscarPorId(id);
        editando = true;
        return null;
    }
}
