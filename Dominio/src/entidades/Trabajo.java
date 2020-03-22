/**
 * Trabajo.java
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "folioTrabajo")
    private int folioTrabajo;
    
    @OneToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
    
    @Column(name = "nombreDeQuienEntrega")
    private String nombreDeQuienEntrega;
    
    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = true)
    private Administrador administrador;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaEstimada")
    private Date fechaEstimada;
    
    @Column(name = "fallaCliente")
    private String fallaCliente;
    
    @Column(name = "fallaEncontrada")
    private String fallaEncontrada;
    
    @Column(name = "razonEliminacion")
    private String razonDeEliminacion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoTrabajo", length = 15)
    private TipoTrabajo tipoTrabajo;
    
    @OneToMany(mappedBy = "trabajo")
    private List<Concepto> conceptos = new ArrayList<>();
    
    @OneToMany(mappedBy = "trabajo")
    private List<Tarea> tareas = new ArrayList<>();
    
    public Trabajo() {
    }

    public Trabajo(int folioTrabajo, Cliente cliente, String nombreDeQuienEntrega, Administrador administrador, Date fechaCreacion, Date fechaEstimada, String fallaCliente, String fallaEncontrada, String razonDeEliminacion, TipoTrabajo tt, List<Concepto> conceptos, List<Tarea> tareas) {
        this.folioTrabajo = folioTrabajo;
        this.cliente = cliente;
        this.nombreDeQuienEntrega = nombreDeQuienEntrega;
        this.administrador = administrador;
        this.fechaCreacion = fechaCreacion;
        this.fechaEstimada = fechaEstimada;
        this.fallaCliente = fallaCliente;
        this.fallaEncontrada = fallaEncontrada;
        this.razonDeEliminacion = razonDeEliminacion;
        this.tipoTrabajo = tt;
        this.conceptos = conceptos;
        this.tareas = tareas;
    }

    public Trabajo(Cliente cliente, String nombreDeQuienEntrega, Administrador administrador, Date fechaCreacion, Date fechaEstimada, String fallaCliente, String fallaEncontrada, String razonDeEliminacion, TipoTrabajo tt, List<Concepto> conceptos, List<Tarea> tareas) {
        this.cliente = cliente;
        this.nombreDeQuienEntrega = nombreDeQuienEntrega;
        this.administrador = administrador;
        this.fechaCreacion = fechaCreacion;
        this.fechaEstimada = fechaEstimada;
        this.fallaCliente = fallaCliente;
        this.fallaEncontrada = fallaEncontrada;
        this.razonDeEliminacion = razonDeEliminacion;
        this.tipoTrabajo = tt;
        this.conceptos = conceptos;
        this.tareas = tareas;
    }

    public Trabajo(int folioTrabajo, Cliente cliente, String nombreDeQuienEntrega, Administrador administrador, Date fechaCreacion, Date fechaEstimada, String fallaCliente, String fallaEncontrada, String razonDeEliminacion, TipoTrabajo tt) {
        this.folioTrabajo = folioTrabajo;
        this.cliente = cliente;
        this.nombreDeQuienEntrega = nombreDeQuienEntrega;
        this.administrador = administrador;
        this.fechaCreacion = fechaCreacion;
        this.fechaEstimada = fechaEstimada;
        this.fallaCliente = fallaCliente;
        this.fallaEncontrada = fallaEncontrada;
        this.razonDeEliminacion = razonDeEliminacion;
        this.tipoTrabajo = tt;
    }

    public int getFolioTrabajo() {
        return folioTrabajo;
    }

    public void setFolioTrabajo(int folioTrabajo) {
        this.folioTrabajo = folioTrabajo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreDeQuienEntrega() {
        return nombreDeQuienEntrega;
    }

    public void setNombreDeQuienEntrega(String nombreDeQuienEntrega) {
        this.nombreDeQuienEntrega = nombreDeQuienEntrega;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public String getRazonDeEliminacion() {
        return razonDeEliminacion;
    }

    public void setRazonDeEliminacion(String razonDeEliminacion) {
        this.razonDeEliminacion = razonDeEliminacion;
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

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }
    
    public boolean estaEliminado(){
        if(razonDeEliminacion == null){
            return false;
        }else{
            if(razonDeEliminacion.equals("")){
                return false;
            }
            return true;
        }
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