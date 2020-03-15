/**
 * Insumo.java
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "insumos")
public class Insumo extends Concepto implements Serializable{
    
    @Column(name = "cantidad")
    private int cantidad;

    public Insumo() {
    }

    public Insumo(Trabajo trabajo, String descripcion, double costo) {
        super(trabajo, descripcion, costo);
    }

    public Insumo(int cantidad, int idConcepto, Trabajo trabajo, String descripcion, double costo) {
        super(idConcepto, trabajo, descripcion, costo);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Insumo{" + "cantidad=" + cantidad + '}';
    }
}