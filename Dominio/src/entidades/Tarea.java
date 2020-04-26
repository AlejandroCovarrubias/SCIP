/**
 * Tarea.java
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tareas")
public class Tarea implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idTarea")
    private int idTarea;
    
    @ManyToOne
    @JoinColumn(name = "foliotrabajo")
    private Trabajo trabajo;
    
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Trabajador asignado;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaTerminacion")
    private Date fechaTerminacion;
    
    @Column(name = "duracion")
    private int duracion;

    public Tarea() {
    }

    public Tarea(Trabajo trabajo, Trabajador asignado, String descripcion, Date fechaInicio, Date fechaTerminacion, int duracion) {
        this.trabajo = trabajo;
        this.asignado = asignado;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.duracion = duracion;
    }

    public Tarea(int idTarea, String descripcion, Date fechaInicio, Date fechaTerminacion, int duracion, Trabajador asignado, Trabajo trabajo) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.duracion = duracion;
        this.asignado = asignado;
        this.trabajo = trabajo;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Trabajador getAsignado() {
        return asignado;
    }

    public void setAsignado(Trabajador asignado) {
        this.asignado = asignado;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idTarea;
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
        final Tarea other = (Tarea) obj;
        if (this.idTarea != other.idTarea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaTerminacion=" + fechaTerminacion + ", duracion=" + duracion + ", asignado=" + asignado + ", trabajo=" + trabajo + '}';
    }
}