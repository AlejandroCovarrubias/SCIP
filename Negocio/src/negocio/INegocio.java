/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Cliente;
import entidades.Insumo;
import entidades.Trabajo;
import entidades.Usuario;
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
    List<Trabajo> getTrabajosTipo(String tipo);
    List<Trabajo> getTrabajosFecha(Date fecha);
    List<Trabajo> getTrabajosCliente(String cliente);
    int getTrabajosCount();
    
    //Clientes
    String agregarCliente(Cliente cliente);
    String editarCliente(Cliente cliente);
    String eliminarCliente(Cliente cliente);
    Cliente getCliente(int id);
    Cliente getClienteRFC(String RFC);
    List<Cliente> getClientes();
    List<Cliente> getClientesLike(String like);
    int getClientesCount();
    
    //Insumos
    String agregarInsumo(Insumo insumo);
    String editarInsumo(Insumo insumo);
    String eliminarInsumo(Insumo insumo);
    Insumo getInsumo(int idConcepto);
    List<Insumo> getInsumos();
    List<Insumo> getInsumosTrabajo(int idTrabajo);
    List<Insumo> getInsumosLike(String like);
    int getInsumosCount();
    
    //Usuarios
    Usuario getUsuario(int id);
}
