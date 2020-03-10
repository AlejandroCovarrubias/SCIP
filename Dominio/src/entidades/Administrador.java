/**
 * Administrador.java
 */
package entidades;

/**
 *
 * @author BerrySoft
 */
public class Administrador extends Usuario{

    public Administrador(int idusuario, String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(idusuario, nombreUsuario, nombre, apellidos, contrasenia, adt);
    }
}