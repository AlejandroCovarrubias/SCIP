/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Concepto;
import java.util.ArrayList;
import java.util.List;
import entidades.Tarea;
import entidades.Trabajo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alejandro Galindo
 */
public class TrabajoController implements Serializable {

    public TrabajoController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Trabajo trabajo) {
        if (trabajo.getConceptos() == null) {
            trabajo.setConceptos(new ArrayList<Concepto>());
        }
        if (trabajo.getTareas() == null) {
            trabajo.setTareas(new ArrayList<Tarea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Concepto> attachedConceptos = new ArrayList<Concepto>();
            for (Concepto conceptosConceptoToAttach : trabajo.getConceptos()) {
                conceptosConceptoToAttach = em.getReference(conceptosConceptoToAttach.getClass(), conceptosConceptoToAttach.getIdConcepto());
                attachedConceptos.add(conceptosConceptoToAttach);
            }
            trabajo.setConceptos(attachedConceptos);
            List<Tarea> attachedTareas = new ArrayList<Tarea>();
            for (Tarea tareasTareaToAttach : trabajo.getTareas()) {
                tareasTareaToAttach = em.getReference(tareasTareaToAttach.getClass(), tareasTareaToAttach.getIdTarea());
                attachedTareas.add(tareasTareaToAttach);
            }
            trabajo.setTareas(attachedTareas);
            em.persist(trabajo);
            for (Concepto conceptosConcepto : trabajo.getConceptos()) {
                Trabajo oldTrabajoOfConceptosConcepto = conceptosConcepto.getTrabajo();
                conceptosConcepto.setTrabajo(trabajo);
                conceptosConcepto = em.merge(conceptosConcepto);
                if (oldTrabajoOfConceptosConcepto != null) {
                    oldTrabajoOfConceptosConcepto.getConceptos().remove(conceptosConcepto);
                    oldTrabajoOfConceptosConcepto = em.merge(oldTrabajoOfConceptosConcepto);
                }
            }
            for (Tarea tareasTarea : trabajo.getTareas()) {
                Trabajo oldTrabajoOfTareasTarea = tareasTarea.getTrabajo();
                tareasTarea.setTrabajo(trabajo);
                tareasTarea = em.merge(tareasTarea);
                if (oldTrabajoOfTareasTarea != null) {
                    oldTrabajoOfTareasTarea.getTareas().remove(tareasTarea);
                    oldTrabajoOfTareasTarea = em.merge(oldTrabajoOfTareasTarea);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trabajo trabajo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Trabajo persistentTrabajo = em.find(Trabajo.class, trabajo.getFolioTrabajo());
            List<Concepto> conceptosOld = persistentTrabajo.getConceptos();
            List<Concepto> conceptosNew = trabajo.getConceptos();
            List<Tarea> tareasOld = persistentTrabajo.getTareas();
            List<Tarea> tareasNew = trabajo.getTareas();
            List<String> illegalOrphanMessages = null;
            for (Concepto conceptosOldConcepto : conceptosOld) {
                if (!conceptosNew.contains(conceptosOldConcepto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Concepto " + conceptosOldConcepto + " since its trabajo field is not nullable.");
                }
            }
            for (Tarea tareasOldTarea : tareasOld) {
                if (!tareasNew.contains(tareasOldTarea)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tarea " + tareasOldTarea + " since its trabajo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Concepto> attachedConceptosNew = new ArrayList<Concepto>();
            for (Concepto conceptosNewConceptoToAttach : conceptosNew) {
                conceptosNewConceptoToAttach = em.getReference(conceptosNewConceptoToAttach.getClass(), conceptosNewConceptoToAttach.getIdConcepto());
                attachedConceptosNew.add(conceptosNewConceptoToAttach);
            }
            conceptosNew = attachedConceptosNew;
            trabajo.setConceptos(conceptosNew);
            List<Tarea> attachedTareasNew = new ArrayList<Tarea>();
            for (Tarea tareasNewTareaToAttach : tareasNew) {
                tareasNewTareaToAttach = em.getReference(tareasNewTareaToAttach.getClass(), tareasNewTareaToAttach.getIdTarea());
                attachedTareasNew.add(tareasNewTareaToAttach);
            }
            tareasNew = attachedTareasNew;
            trabajo.setTareas(tareasNew);
            trabajo = em.merge(trabajo);
            for (Concepto conceptosNewConcepto : conceptosNew) {
                if (!conceptosOld.contains(conceptosNewConcepto)) {
                    Trabajo oldTrabajoOfConceptosNewConcepto = conceptosNewConcepto.getTrabajo();
                    conceptosNewConcepto.setTrabajo(trabajo);
                    conceptosNewConcepto = em.merge(conceptosNewConcepto);
                    if (oldTrabajoOfConceptosNewConcepto != null && !oldTrabajoOfConceptosNewConcepto.equals(trabajo)) {
                        oldTrabajoOfConceptosNewConcepto.getConceptos().remove(conceptosNewConcepto);
                        oldTrabajoOfConceptosNewConcepto = em.merge(oldTrabajoOfConceptosNewConcepto);
                    }
                }
            }
            for (Tarea tareasNewTarea : tareasNew) {
                if (!tareasOld.contains(tareasNewTarea)) {
                    Trabajo oldTrabajoOfTareasNewTarea = tareasNewTarea.getTrabajo();
                    tareasNewTarea.setTrabajo(trabajo);
                    tareasNewTarea = em.merge(tareasNewTarea);
                    if (oldTrabajoOfTareasNewTarea != null && !oldTrabajoOfTareasNewTarea.equals(trabajo)) {
                        oldTrabajoOfTareasNewTarea.getTareas().remove(tareasNewTarea);
                        oldTrabajoOfTareasNewTarea = em.merge(oldTrabajoOfTareasNewTarea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = trabajo.getFolioTrabajo();
                if (findTrabajo(id) == null) {
                    throw new NonexistentEntityException("The trabajo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Trabajo trabajo;
            try {
                trabajo = em.getReference(Trabajo.class, id);
                trabajo.getFolioTrabajo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trabajo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Concepto> conceptosOrphanCheck = trabajo.getConceptos();
            for (Concepto conceptosOrphanCheckConcepto : conceptosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Trabajo (" + trabajo + ") cannot be destroyed since the Concepto " + conceptosOrphanCheckConcepto + " in its conceptos field has a non-nullable trabajo field.");
            }
            List<Tarea> tareasOrphanCheck = trabajo.getTareas();
            for (Tarea tareasOrphanCheckTarea : tareasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Trabajo (" + trabajo + ") cannot be destroyed since the Tarea " + tareasOrphanCheckTarea + " in its tareas field has a non-nullable trabajo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(trabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Trabajo> findTrabajoEntities() {
        return findTrabajoEntities(true, -1, -1);
    }

    public List<Trabajo> findTrabajoEntities(int maxResults, int firstResult) {
        return findTrabajoEntities(false, maxResults, firstResult);
    }

    private List<Trabajo> findTrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trabajo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Trabajo> findTrabajoEntititiesType(String type){
        List<Trabajo> ftes = findTrabajoEntities();
        List<Trabajo> aux = new ArrayList<>();
        
        for (Trabajo fte : ftes) {
            if(fte.getTipoTrabajo().toString().equals(type)){
                aux.add(fte);
            }
        }
        
        return aux; 
    }

    public Trabajo findTrabajo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Trabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trabajo> rt = cq.from(Trabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
