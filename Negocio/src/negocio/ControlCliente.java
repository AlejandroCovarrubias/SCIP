/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controladores.*;
import controladores.exceptions.*;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
class ControlCliente {
    IDatos instance;
    
    ControlCliente(IDatos facade){
        instance = facade;
    }
    
    String agregar(Cliente cliente){
        try {
            instance.agregarCliente(cliente);
        } catch (Exception ex) {
            if(ex instanceof PreexistingEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "El cliente ha sido agregado con exito.";
    }
    
    String editar(Cliente cliente){
        try {
            instance.editarCliente(cliente);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo editar. Intente nuevamente.";
            }
        }
        return "El cliente con RFC: " + cliente.getRFC() + " ha sido editado.";
    }
    
    String eliminar(Cliente cliente){
        try {
            instance.eliminarCliente(cliente);
        } catch (Exception ex) {
            if(ex instanceof NonexistentEntityException){
                return ex.getMessage();
            }else{
                return "No se pudo agregar. Intente nuevamente.";
            }
        }
        return "El cliente con RFC: " + cliente.getRFC() + " ha sido eliminado.";
    }
    
    Cliente getCliente(int id){
        return instance.getCliente(id);
    }
    
    Cliente getClienteRFC(String RFC){
        return instance.getClienteRFC(RFC);
    }
    
    List<Cliente> getClientes(){
        return instance.getClientes();
    }
    
    List<Cliente> getClientesLike(String like){
        return instance.getClientesLike(like);
    }
    
    int getClientesCount(){
        return instance.getClientesCount();
    }
}
