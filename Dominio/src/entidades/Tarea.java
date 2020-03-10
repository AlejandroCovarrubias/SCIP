/**
 * Tarea.java
 */
package entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BerrySoft
 */
public class Tarea {
    private int idTarea;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaTerminacion;
    private int duracion;
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