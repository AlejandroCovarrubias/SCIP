/**
 * Concepto.java
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author BerrySoft
 */
public class Concepto {
    private int idConcepto;
    private String descripcion;
    private double costo;

    public Concepto() {
    }

    public Concepto(int idConcepto, String descripcion, double costo) {
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idConcepto;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
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
        final Concepto other = (Concepto) obj;
        if (this.idConcepto != other.idConcepto) {
            return false;
        }
        if (Double.doubleToLongBits(this.costo) != Double.doubleToLongBits(other.costo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Concepto{" + "idConcepto=" + idConcepto + ", descripcion=" + descripcion + ", costo=" + costo + '}';
    }
}