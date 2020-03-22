/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.Cliente;
import entidades.Concepto;
import entidades.Insumo;
import entidades.Tarea;
import entidades.Trabajo;
import entidades.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alejandro Galindo
 */
public class FDatos implements IDatos {

    private EntityManagerFactory emf;
    private TrabajoController trabajoCtrl;
    private ClienteController clienteCtrl;
    private UsuarioController usuarioCtrl;
    private ConceptoController conceptoCtrl;

    public FDatos() {
        emf = Persistence.createEntityManagerFactory("db_scip");
        this.trabajoCtrl = new TrabajoController(emf);
        this.clienteCtrl = new ClienteController(emf);
        this.usuarioCtrl = new UsuarioController(emf);
        this.conceptoCtrl = new ConceptoController(emf);
    }

    @Override
    public void agregarTrabajo(Trabajo trabajo) throws PreexistingEntityException, Exception {
        int antes = conceptoCtrl.getConceptoCount();
        for (Concepto concepto : trabajo.getConceptos()) {
            conceptoCtrl.create(concepto);
        }
        
        List<Concepto> temp = conceptoCtrl.findConceptoEntities(trabajo.getConceptos().size(), antes);
        
        trabajo.setConceptos(temp);
        
        trabajoCtrl.create(trabajo);
    }

    @Override
    public void editarTrabajo(Trabajo trabajo) throws NonexistentEntityException, Exception {
        trabajoCtrl.edit(trabajo);
    }

    @Override
    public void eliminarTrabajo(Trabajo trabajo) throws NonexistentEntityException, Exception {
        trabajoCtrl.destroy(trabajo.getFolioTrabajo());
    }

    @Override
    public Trabajo getTrabajo(int folioTrabajo) {
        return trabajoCtrl.findTrabajo(folioTrabajo);
    }

    @Override
    public List<Trabajo> getTrabajos() {
        List<Trabajo> fte = trabajoCtrl.findTrabajoEntities();
        
        for (Trabajo trabajo : fte) {
            trabajo.setConceptos(conceptoCtrl.findConceptoEntitiesFolioTrabajo(trabajo.getFolioTrabajo()));
        }
        
        return fte;
    }
    
    @Override
    public List<Trabajo> getTrabajosTipo(String tipo) {
        List<Trabajo> fte = trabajoCtrl.findTrabajoEntititiesType(tipo);
        
        for (Trabajo trabajo : fte) {
            trabajo.setConceptos(conceptoCtrl.findConceptoEntitiesFolioTrabajo(trabajo.getFolioTrabajo()));
        }
        
        return fte;
    }

    @Override
    public List<Trabajo> getTrabajosFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTrabajosCount() {
        return trabajoCtrl.getTrabajoCount();
    }

    @Override
    public void agregarCliente(Cliente cliente) throws PreexistingEntityException, Exception {
        clienteCtrl.create(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) throws NonexistentEntityException, Exception {
        clienteCtrl.edit(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) throws NonexistentEntityException, Exception {
        clienteCtrl.destroy(cliente.getIdCliente());
    }

    @Override
    public Cliente getCliente(int idCliente) {
        return clienteCtrl.findCliente(idCliente);
    }

    @Override
    public Cliente getClienteRFC(String RFC) {
        return clienteCtrl.findClienteRFC(RFC);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteCtrl.findClienteEntities();
    }

    @Override
    public int getClientesCount() {
        return clienteCtrl.getClienteCount();
    }

    @Override
    public void agregarConcepto(Concepto concepto) throws PreexistingEntityException, Exception {
        conceptoCtrl.create(concepto);
    }

    @Override
    public void editarConcepto(Concepto concepto) throws NonexistentEntityException, Exception {
        conceptoCtrl.edit(concepto);
    }

    @Override
    public void eliminarConcepto(Concepto concepto) throws NonexistentEntityException, Exception {
        conceptoCtrl.destroy(concepto.getIdConcepto());
    }

    @Override
    public Concepto getConcepto(int idConcepto) {
        return conceptoCtrl.findConcepto(idConcepto);
    }

    @Override
    public Concepto getConceptoTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> getConceptos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> getConceptosTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> getConceptosTrabajo(int folioTrabajo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarUsuario(Usuario usuario) throws PreexistingEntityException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario getUsuario(int idUsuario) {
        return usuarioCtrl.findUsuario(idUsuario);
    }

    @Override
    public void agregarTarea(Tarea tarea) throws PreexistingEntityException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarTarea(Tarea tarea) throws NonexistentEntityException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTarea(Tarea tarea) throws NonexistentEntityException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
