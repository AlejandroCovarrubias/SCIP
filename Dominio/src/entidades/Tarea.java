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
    @GeneratedValue()
    @Column(name = "idTarea")
    private int idTarea;
    
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
    
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Trabajador asignado;

    public Tarea() {
    }

    public Tarea(int idTarea, String descripcion, Date fechaInicio, Date fechaTerminacion, int duracion, Trabajador asignado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.duracion = duracion;
        this.asignado = asignado;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.descripcion);
        hash = 23 * hash + Objects.hashCode(this.fechaInicio);
        hash = 23 * hash + this.duracion;
        hash = 23 * hash + Objects.hashCode(this.asignado);
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
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.asignado, other.asignado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaTerminacion=" + fechaTerminacion + ", duracion=" + duracion + ", asignado=" + asignado + '}';
    }  
}