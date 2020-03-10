/**
 * Servicio.java
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "servicios")
public class Servicio extends Concepto implements Serializable{

    public Servicio() {
    }

    public Servicio(int idConcepto, String descripcion, double costo) {
        super(idConcepto, descripcion, costo);
    }
}