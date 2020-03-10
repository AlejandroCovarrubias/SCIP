/**
 * Trabajo.java
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "trabajos")
public class Trabajo implements Serializable {
    
    @Id
    @GeneratedValue()
    @Column(name = "folioTrabajo")
    private int folioTrabajo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaEstimada")
    private Date fechaEstimada;
    
    @Column(name = "fallaCliente")
    private String fallaCliente;
    
    @Column(name = "fallaEncontrada")
    private String fallaEncontrada;
    
    @Column(name = "razonEliminacion")
    private String razonDeEliminacion;
    
    @ManyToOne
    @JoinColumn(name = "RFC")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Administrador administrador;
    
    @OneToMany()
    @JoinColumn(name = "idConcepto")
    private List<Concepto> conceptos;
    
    @OneToMany()
    @JoinColumn(name = "idTarea")
    private List<Tarea> tareas;

    public Trabajo() {
    }

    public Trabajo(int folioTrabajo, Date fechaEstimada, String fallaCliente, String fallaEncontrada, Cliente cliente, Administrador administrador, List<Concepto> conceptos, List<Tarea> tareas) {
        this.folioTrabajo = folioTrabajo;
        this.fechaEstimada = fechaEstimada;
        this.fallaCliente = fallaCliente;
        this.fallaEncontrada = fallaEncontrada;
        this.cliente = cliente;
        this.administrador = administrador;
        this.conceptos = conceptos;
        this.tareas = tareas;
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
    
    public boolean estaEliminado(){
        return razonDeEliminacion.equals("");
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