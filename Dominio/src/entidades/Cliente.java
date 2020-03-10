/**
 * Cliente.java
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author BerrySoft
 */
public class Cliente {
    private String RFC;
    private String razonSocial;
    private String correo;

    public Cliente() {
    }

    public Cliente(String RFC, String razonSocial, String correo) {
        this.RFC = RFC;
        this.razonSocial = razonSocial;
        this.correo = correo;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.RFC);
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
        if (!Objects.equals(this.RFC, other.RFC)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "RFC=" + RFC + ", razonSocial=" + razonSocial + ", correo=" + correo + '}';
    }
}