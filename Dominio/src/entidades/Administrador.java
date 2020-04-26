/**
 * Administrador.java
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "administradores")
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(nombreUsuario, nombre, apellidos, contrasenia, adt);
    }

    public Administrador(int idusuario, String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(idusuario, nombreUsuario, nombre, apellidos, contrasenia, adt);
    }
}