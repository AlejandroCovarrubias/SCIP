/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Cliente;
import entidades.Trabajo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public interface INegocio {
    //Trabajos
    String agregarTrabajo(Trabajo trabajo);
    String editarTrabajo(Trabajo trabajo);
    String eliminarTrabajo(Trabajo trabajo);
    Trabajo getTrabajo(int folioTrabajo);
    List<Trabajo> getTrabajos();
    List<Trabajo> getTrabajosFecha(Date fecha);
    int getTrabajosCount();
    
    //Clientes
    String agregarCliente(Cliente cliente);
    String editarCliente(Cliente cliente);
    String eliminarCliente(Cliente cliente);
    Cliente getCliente(int id);
    Cliente getClienteRFC(String RFC);
    List<Cliente> getClientes();
    int getClientesCount();
}
