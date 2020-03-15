/**
 * Trabajador.java
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "trabajadores")
public class Trabajador extends Usuario{    

    public Trabajador() {
    }

    public Trabajador(String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(nombreUsuario, nombre, apellidos, contrasenia, adt);
    }

    public Trabajador(int idusuario, String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(idusuario, nombreUsuario, nombre, apellidos, contrasenia, adt);
    }
}