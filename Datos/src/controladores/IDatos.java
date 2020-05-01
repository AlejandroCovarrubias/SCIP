/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.*;
import entidades.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public interface IDatos {
    
    //Trabajos
    void agregarTrabajo(Trabajo trabajo) throws PreexistingEntityException, Exception;
    void editarTrabajo(Trabajo trabajo) throws NonexistentEntityException, Exception;
    void eliminarTrabajo(Trabajo trabajo) throws NonexistentEntityException, Exception;
    Trabajo getTrabajo(int folioTrabajo);
    List<Trabajo> getTrabajos();
    List<Trabajo> getTrabajosTipo(String tipo);
    List<Trabajo> getTrabajosFecha(Date fecha);
    List<Trabajo> getTrabajosCliente(String cliente);
    int getTrabajosCount();
    
    //Clientes
    void agregarCliente(Cliente cliente) throws PreexistingEntityException, Exception;
    void editarCliente(Cliente cliente) throws NonexistentEntityException, Exception;
    void eliminarCliente(Cliente cliente) throws NonexistentEntityException, Exception;
    Cliente getCliente(int idCliente);
    Cliente getClienteRFC(String RFC);
    List<Cliente> getClientes();
    int getClientesCount();
    
    //Conceptos
    void agregarConcepto(Concepto concepto) throws PreexistingEntityException, Exception;
    void editarConcepto(Concepto concepto) throws NonexistentEntityException, Exception;
    void eliminarConcepto(Concepto concepto) throws NonexistentEntityException, Exception;
    Concepto getConcepto(int idConcepto);
    List<Concepto> getConceptos();
    List<Insumo> getConceptosInsumos();
    List<Insumo> getConceptosInsumosTrabajo(int folioTrabajo);
    int getConceptosCount();
    int getConceptosInsumosCount();
    
    //Usuarios
    void agregarUsuario(Usuario usuario) throws PreexistingEntityException, Exception;
    Usuario getUsuario(int idUsuario);
    
    //Tareas
    void agregarTarea(Tarea tarea) throws PreexistingEntityException, Exception;
    void editarTarea(Tarea tarea) throws NonexistentEntityException, Exception;
    void eliminarTarea(Tarea tarea) throws NonexistentEntityException, Exception;
}
