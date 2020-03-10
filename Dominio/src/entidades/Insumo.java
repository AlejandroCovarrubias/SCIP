/**
 * Insumo.java
 */
package entidades;

/**
 *
 * @author BerrySoft
 */
public class Insumo extends Concepto{
    private int cantidad;

    public Insumo(int idConcepto, String descripcion, double costo) {
        super(idConcepto, descripcion, costo);
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