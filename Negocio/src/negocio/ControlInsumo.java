/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controladores.IDatos;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.Insumo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Galindo
 */
public class ControlInsumo {
    
    IDatos instance;
    
    ControlInsumo(IDatos facade){
        instance = facade;
    }
    
    
    String agregar(Insumo insumo){
        try {
            instance.agregarConcepto(insumo);
        } catch (Exception ex) {
            if(ex instanceof PreexistingEntityException){
                ex.printStackTrace();
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "La compra de insumo ha sido realizada con exito.";
    }
    
    String editar(Insumo insumo){
        try {
            instance.editarConcepto(insumo);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo editar. Intente nuevamente.";
            }
        }
        return "El insumo: " + insumo.getDescripcion() + " ha sido editado.";
    }
    
    String eliminar(Insumo insumo){
        try {
            instance.eliminarConcepto(insumo);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "El insumo: " + insumo.getDescripcion() + " ha sido eliminado.";
    }
    
    Insumo getInsumo(int id){
        return (Insumo) instance.getConcepto(id);
    }
    
    List<Insumo> getInsumos(){
        return instance.getConceptosInsumos();
    }
    
    List<Insumo> getInsumosTrabajo(int folioTrabajo){
        return instance.getConceptosInsumosTrabajo(folioTrabajo);
    }
    
    List<Insumo> getInsumosLike(String like){
        return instance.getConceptosLike(like);
    }
    
    int getInsumosCount(){
        return instance.getConceptosCount();
    }
}
