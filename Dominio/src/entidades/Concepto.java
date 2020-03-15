/**
 * Concepto.java
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "conceptos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = STRING, length = 20)
public class Concepto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idConcepto")
    private int idConcepto;
    
    @ManyToOne
    @JoinColumn(name = "foliotrabajo", nullable = false)
    private Trabajo trabajo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "costo")
    private double costo;

    public Concepto() {
    }

    public Concepto(Trabajo trabajo, String descripcion, double costo) {
        this.trabajo = trabajo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Concepto(int idConcepto, Trabajo trabajo, String descripcion, double costo) {
        this.idConcepto = idConcepto;
        this.trabajo = trabajo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
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
        hash = 79 * hash + this.idConcepto;
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
        return true;
    }

    @Override
    public String toString() {
        return "Concepto{" + "idConcepto=" + idConcepto + ", trabajo=" + trabajo + ", descripcion=" + descripcion + ", costo=" + costo + '}';
    }

    
}