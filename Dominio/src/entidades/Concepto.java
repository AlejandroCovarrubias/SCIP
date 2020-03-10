/**
 * Concepto.java
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "conceptos")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = STRING, length = 20)
public class Concepto implements Serializable {
    
    @Id
    @GeneratedValue()
    @Column(name = "idConcepto")
    private int idConcepto;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "costo")
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