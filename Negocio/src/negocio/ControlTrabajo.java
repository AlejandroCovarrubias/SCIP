/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controladores.*;
import controladores.exceptions.*;
import entidades.Trabajo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class ControlTrabajo {
    IDatos instance;
    
    ControlTrabajo(IDatos facade){
        instance = facade;
    }
    
    String agregar(Trabajo trabajo){    
        try {
            instance.agregarTrabajo(trabajo);         
        } catch (Exception ex) {
            if(ex instanceof PreexistingEntityException){
                ex.printStackTrace();
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "El trabajo ha sido agregado con exito.";
    }
    
    String editar(Trabajo trabajo){
        try {
            instance.editarTrabajo(trabajo);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo editar. Intente nuevamente.";
            }
        }
        return "El trabajo con folio: " + trabajo.getFolioTrabajo() + " ha sido editado.";
    }
    
    String eliminar(Trabajo trabajo){
        try {
            instance.eliminarTrabajo(trabajo);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "El trabajo con folio: " + trabajo.getFolioTrabajo() + " ha sido eliminado.";
    }
    
    Trabajo getTrabajo(int id){
        return instance.getTrabajo(id);
    }
    
    List<Trabajo> getTrabajos(){
        return instance.getTrabajos();
    }
    
    List<Trabajo> getTrabajosTipo(String tipo){
        return instance.getTrabajosTipo(tipo);
    }
    
    List<Trabajo> getTrabajosFecha(Date fecha){
        return instance.getTrabajos();
    }
    
    List<Trabajo> getTrabajosCliente(String cliente){
        return instance.getTrabajosCliente(cliente);
    }
    
    int getTrabajosCount(){
        return instance.getTrabajosCount();
    }
}
