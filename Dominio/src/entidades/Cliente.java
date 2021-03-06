/**
 * Cliente.java
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BerrySoft
 */

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;
    
    @Column(name = "RFC", length = 16)
    private String RFC;
    
    @Column(name = "razonSocial", length = 100)
    private String razonSocial;
    
    @Column(name = "correo", length = 30)
    private String correo;
    
    @Column(name = "telefono", length = 30)
    private String telefono;

    public Cliente() {
    }

    public Cliente(String RFC, String razonSocial, String correo, String telefono) {
        this.RFC = RFC;
        this.razonSocial = razonSocial;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(int idCliente, String RFC, String razonSocial, String correo, String telefono) {
        this.idCliente = idCliente;
        this.RFC = RFC;
        this.razonSocial = razonSocial;
        this.correo = correo;
        this.telefono = telefono;
    }  

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idCliente;
        hash = 13 * hash + Objects.hashCode(this.RFC);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.RFC, other.RFC)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", RFC=" + RFC + ", razonSocial=" + razonSocial + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
}