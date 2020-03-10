/**
 * Usuario.java
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author BerrySoft
 */
public class Usuario {
    private int idusuario;
    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String contrasenia;
    private AreaDeTrabajo adt;

    public Usuario() {
    }
    
    public Usuario(int idusuario, String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        this.idusuario = idusuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.adt = adt;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public AreaDeTrabajo getAdt() {
        return adt;
    }

    public void setAdt(AreaDeTrabajo adt) {
        this.adt = adt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 83 * hash + Objects.hashCode(this.contrasenia);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return true;
    }
}