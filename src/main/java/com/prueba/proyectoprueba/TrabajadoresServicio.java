package com.prueba.proyectoprueba;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class TrabajadoresServicio {

    @PersistenceContext(unitName = "trabajadoresPU")
    private EntityManager em;

    public void crear(Trabajadores trabajador) {
        em.persist(trabajador);
    }

    public void actualizar(Trabajadores trabajador) {
        em.merge(trabajador);
    }

    public List<Trabajadores> listarTodos() {
        return em.createQuery("SELECT t FROM Trabajadores t", Trabajadores.class).getResultList();
    }

    public Trabajadores buscarPorId(BigDecimal id) {
        return em.find(Trabajadores.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void eliminar(BigDecimal id) {
        Trabajadores trabajador = em.find(Trabajadores.class, id);
        if (trabajador != null) {
            em.remove(trabajador);
        }
    }
}
