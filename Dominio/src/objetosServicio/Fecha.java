/**
 * Fecha.java
 * Creada el 15 de marzo de 2018, a las 12:02
 */
package objetosServicio;
import java.util.GregorianCalendar;
/**
 *  Clase que gestiona fechas, extiende de Gregorian Calendar
 * 
 * @author Alejandro Galindo
 */
public class Fecha extends GregorianCalendar{
    
    /**
     * Constructor que inicializa la fecha a la establecida en el sistema,
     * excepto el tiempo, el cual se establece a 0
     */
    public Fecha(){
        super();
        super.set(HOUR, 0);
        super.set(MINUTE, 0);
        super.set(SECOND, 0);
        super.set(MILLISECOND, 0);
    }
    
    /**
     *  Constructor que inicializa la fecha con un dia, un mes y un año
     * 
     * @param dia Día de la fecha
     * @param mes Mes de la fecha
     * @param anho Anio de la fecha
     */
    public Fecha(int dia, int mes, int anho){
        super.set(anho, mes-1, dia);
        super.set(HOUR, 0);
        super.set(MINUTE, 0);
        super.set(SECOND, 0);
        super.set(MILLISECOND, 0);
    }
    
    /**
     * Constructor que inicializa una fecha con otra fecha
     * 
     * @param fecha Fecha enviada
     */
    public Fecha(Fecha fecha){
        super.set(fecha.get(YEAR), fecha.get(MONTH), fecha.get(DAY_OF_MONTH));
        super.set(HOUR, 0);
        super.set(MINUTE, 0);
        super.set(SECOND, 0);
        super.set(MILLISECOND, 0);
    }
    
    /**
     * Constructor que inicializa una fecha con un string con el formato
     * dd/mm/aaaa
     * 
     * @param s String con la fecha
     */
    public Fecha(String s) {
        int dia, mes, anio;
        String aux;
        if (s.length() == 10) {
            
            aux = s.substring(0,2);
            dia = Integer.parseInt(aux);
            super.set(DAY_OF_MONTH,dia);
            
            aux = s.substring(3,5);
            mes = Integer.parseInt(aux);
            super.set(MONTH,mes-1);
            
            aux = s.substring(6,10);
            anio = Integer.parseInt(aux);
            super.set(YEAR,anio);
            
            super.set(HOUR, 0);
            super.set(MINUTE, 0);
            super.set(SECOND, 0);
            super.set(MILLISECOND, 0);
        } else {
            System.out.println("Error. No sigue el formato dd/mm/aaaa");
        }
    }
    
    /**
     * Regresa el día
     * 
     * @return día
     */
    public int getDia(){
        return this.get(DAY_OF_MONTH);
    }
    
    /**
     * Establece el día
     * 
     * @param dia Día de la fecha
     */
    public void setDia(int dia){
        this.set(DAY_OF_MONTH,dia);
    }
    
    /**
     * Regresa el mes
     * 
     * @return mes
     */
    public int getMes(){
        return this.get(MONTH)+1;
    }
    
    /**
     * Establece el mes
     * 
     * @param mes Mes de la fecha 
     */
    public void setMes(int mes){
        this.set(MONTH, mes-1);
    }
    
    /**
     * Regresa el anio
     * 
     * @return anio
     */
    public int getAnho(){
        return this.get(YEAR);
    }
    
    /**
     * Establece el anio
     * 
     * @param anho Anio del mes
     */
    public void setAnho(int anho){
        this.set(YEAR, anho);
    }
    
    /**
     * Método que establece la fecha
     * 
     * @param dia Día de la fecha
     * @param mes Mes de la fecha
     * @param anho Anio de la fecha
     */
    public void setFecha(int dia, int mes, int anho){
        super.set(anho, mes-1, dia);
    }
    
    public String getMesString(){
        switch(this.getMes()-1){
            case 0:
                return "ENERO";
            case 1:
                return "FEBRERO";
            case 2:
                return "MARZO";
            case 3:
                return "ABRIL";
            case 4:
                return "MAYO";
            case 5:
                return "JUNIO";
            case 6:
                return "JULIO";
            case 7:
                return "AGOSTO";
            case 8:
                return "SEPTIEMBRE";
            case 9:
                return "OCTUBRE";
            case 10:
                return "NOVIEMBRE";
            case 11:
                return "DICIEMBRE";
            default:
                return "";
        }
    }
    
    public int getDiaDeLaSemana(){
        return this.get(DAY_OF_WEEK);
    }
    
    public int getDiasDelMes(){
        return this.getActualMaximum(DAY_OF_MONTH);
    }
    
    public int getPrimerAnho(){
        return this.getActualMinimum(YEAR);
    }
    
    public int getUltimoAnho(){
        return this.getActualMaximum(YEAR);
    }
    
    /**
     * Establece un vencimiento agregando días, meses y años
     * 
     * @param dias Días a agregar
     * @param meses Meses a agregar
     * @param anhos Anios a agregar
     * @return Fecha de vencimiento 
     */
    public Fecha vencimiento(int dias, int meses, int anhos){
        Fecha vencimiento = new Fecha(this.get(DAY_OF_MONTH), this.get(MONTH) + 1, this.get(YEAR));
        vencimiento.add(DAY_OF_MONTH, dias);
        vencimiento.add(MONTH, meses);
        vencimiento.add(YEAR, anhos);
        return vencimiento;
    }
    
    /**
     * Establece un vencimiento con días y meses
     * 
     * @param dias Días a agregar
     * @param meses Meses a agregar
     * @return Fecha de vencimiento
     */
    public Fecha vencimiento(int dias, int meses){
        Fecha vencimiento = new Fecha(this.get(DAY_OF_MONTH), this.get(MONTH) + 1, this.get(YEAR));
        vencimiento.add(DAY_OF_MONTH, dias);
        vencimiento.add(MONTH, meses);
        return vencimiento;
    }
    
    /**
     * Establece un vencimiento con días
     * 
     * @param dias Días a agregar
     * @return Fecha de vencimiento
     */
    public Fecha vencimiento(int dias){
        Fecha vencimiento = new Fecha(this.get(DAY_OF_MONTH), this.get(MONTH) + 1, this.get(YEAR));
        vencimiento.add(DAY_OF_MONTH, dias);
        return vencimiento;
    }
    
    /**
     * Lapso de tiempo entre el periodo
     * 
     * @param desde Fecha desde
     * @return Lapso de tiempo
     */
    public int lapso(Fecha desde){
        long tiempoInicio = desde.getTimeInMillis();
        long tiempoFin = this.getTimeInMillis();
        long tiempoDif = tiempoFin - tiempoInicio;
        long diasDif = tiempoDif / (1000 * 60 * 60 * 24);
        return (int) diasDif;
    }
    
    /**
     * Concatena los atributos de una instancia
     * 
     * @return Cadena con atributos concatenados
     */
    @Override
    public String toString(){
        String toString = this.get(DAY_OF_MONTH) + "/" + (this.get(MONTH) + 1)  + "/" + this.get(YEAR);
        return toString;
    }       
}