/**
 * Trabajador.java
 */
package entidades;

/**
 *
 * @author BerrySoft
 */
public class Trabajador extends Usuario{    

    public Trabajador(int idusuario, String nombreUsuario, String nombre, String apellidos, String contrasenia, AreaDeTrabajo adt) {
        super(idusuario, nombreUsuario, nombre, apellidos, contrasenia, adt);
    }
}