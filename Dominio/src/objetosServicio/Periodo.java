/**
 * Periodo.java
 * Creado el 15 de marzo de 2018, a las 11:58PM
 */
package objetosServicio;
/**
 * Clase que determina periodos entre fechas
 * @author Alejandro Galindo
 */
public class Periodo {
    /**
     * Fecha desde
     */
    private Fecha desde;
    /**
     * Fecha hasta
     */
    private Fecha hasta;

    /**
     * Constructor que inicializa el periodo entre dos fechas
     * 
     * @param desde Primer fecha
     * @param hasta Segunda fecha
     */
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * Regresa desde
     * @return desde
     */
    public Fecha getDesde() {
        return desde;
    }
    
    /**
     * Establece desde
     * 
     * @param desde Fecha desde
     */
    public void setDesde(Fecha desde) {
        this.desde = desde;
    }
    
    /**
     * Regresa desde
     * @return desde
     */
    public Fecha getHasta() {
        return hasta;
    }
    
    /**
     * Establece desde
     * 
     * @param hasta 
     */
    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }
    
    /**
     * Verifica si una fecha está entre dos periodos
     * 
     * @param fecha
     * @return true o false
     */
    public boolean contiene(Fecha fecha){
        if(fecha.getTimeInMillis() <= hasta.getTimeInMillis() && fecha.getTimeInMillis() >= desde.getTimeInMillis()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Concatena los atributos de una instancia
     * 
     * @return Cadena con atributos concatenados
     */
    @Override
    public String toString(){
        String toString = "Desde " + desde.toString() + " hasta " + hasta.toString();
        return toString;
    }
}