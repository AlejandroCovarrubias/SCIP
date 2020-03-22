/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controladores.DatosSCIP;
import controladores.IDatos;
import entidades.Cliente;
import entidades.Trabajo;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class FNegocio implements INegocio{
    
    IDatos instance;
    ControlCliente ctrlCliente;
    ControlTrabajo ctrlTrabajo;
    ControlUsuario ctrlUsuario;
    
    public FNegocio(){
        instance = DatosSCIP.getFacade();
        ctrlCliente = new ControlCliente(instance);
        ctrlTrabajo = new ControlTrabajo(instance);
        ctrlUsuario = new ControlUsuario(instance);
    }

    @Override
    public String agregarTrabajo(Trabajo trabajo) {
        return ctrlTrabajo.agregar(trabajo);
    }

    @Override
    public String editarTrabajo(Trabajo trabajo) {
        return ctrlTrabajo.editar(trabajo);
    }

    @Override
    public String eliminarTrabajo(Trabajo trabajo) {
        return ctrlTrabajo.eliminar(trabajo);
    }

    @Override
    public Trabajo getTrabajo(int folioTrabajo) {
        return ctrlTrabajo.getTrabajo(folioTrabajo);
    }

    @Override
    public List<Trabajo> getTrabajos() {
        List<Trabajo> trabajos = ctrlTrabajo.getTrabajos();
        List<Trabajo> aux = new ArrayList<>();
        
        for (Trabajo trabajo : trabajos) {
            if(!trabajo.estaEliminado()){
                aux.add(trabajo);
            }
        }
        
        return aux;
    }
    
    @Override
    public List<Trabajo> getTrabajosTipo(String tipo) {
        List<Trabajo> trabajos = ctrlTrabajo.getTrabajosTipo(tipo);
        List<Trabajo> aux = new ArrayList<>();
        
        for (Trabajo trabajo : trabajos) {
            if(!trabajo.estaEliminado()){
                aux.add(trabajo);
            }
        }
        
        return aux;
    }

    @Override
    public List<Trabajo> getTrabajosFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTrabajosCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String agregarCliente(Cliente cliente) {
        return ctrlCliente.agregar(cliente);
    }

    @Override
    public String editarCliente(Cliente cliente) {
        return ctrlCliente.editar(cliente);
    }

    @Override
    public String eliminarCliente(Cliente cliente) {
        return ctrlCliente.eliminar(cliente);
    }

    @Override
    public Cliente getCliente(int id) {
        return ctrlCliente.getCliente(id);
    }

    @Override
    public Cliente getClienteRFC(String RFC) {
        return ctrlCliente.getClienteRFC(RFC);
    }

    @Override
    public List<Cliente> getClientes() {
        return ctrlCliente.getClientes();
    }

    @Override
    public int getClientesCount() {
        return ctrlCliente.getClientesCount();
    } 

    @Override
    public Usuario getUsuario(int id) {
        return ctrlUsuario.getUsuario(id);
    }
}