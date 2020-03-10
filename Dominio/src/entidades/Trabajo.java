/**
 * Trabajo.java
 */
package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author BerrySoft
 */
public class Trabajo {
    private int folioTrabajo;
    private Date fechaEstimada;
    private String fallaCliente;
    private String fallaEncontrada;
    private String razonDeEliminacion;
    private Cliente cliente;
    private Administrador administrador;
    private List<Concepto> conceptos;
    private List<Tarea> tareas;

    public Trabajo() {
    }

    public int getFolioTrabajo() {
        return folioTrabajo;
    }

    public void setFolioTrabajo(int folioTrabajo) {
        this.folioTrabajo = folioTrabajo;
    }

    public Date getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public String getFallaCliente() {
        return fallaCliente;
    }

    public void setFallaCliente(String fallaCliente) {
        this.fallaCliente = fallaCliente;
    }

    public String getFallaEncontrada() {
        return fallaEncontrada;
    }

    public void setFallaEncontrada(String fallaEncontrada) {
        this.fallaEncontrada = fallaEncontrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Concepto> getConceptos() {
        return conceptos;
    }

    public void setConceptos(List<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.folioTrabajo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajo other = (Trabajo) obj;
        if (this.folioTrabajo != other.folioTrabajo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajo{" + "folioTrabajo=" + folioTrabajo + ", fechaEstimada=" + fechaEstimada + ", fallaCliente=" + fallaCliente + ", fallaEncontrada=" + fallaEncontrada + ", razonDeEliminacion=" + razonDeEliminacion + ", cliente=" + cliente + ", administrador=" + administrador + ", conceptos=" + conceptos + ", tareas=" + tareas + '}';
    }  
}