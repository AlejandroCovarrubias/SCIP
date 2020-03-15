/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.PreexistingEntityException;
import entidades.Cliente;
import entidades.Insumo;
import entidades.Tarea;
import entidades.Trabajo;
import entidades.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Alejandro Galindo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FDatosTest {

    private IDatos instance;

    public FDatosTest() {
        instance = DatosSCIP.getFacade();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of agregarTrabajo method, of class FDatos.
     */
    @Test
    public void testAgregarTrabajo() throws Exception {
    }

    /**
     * Test of editarTrabajo method, of class FDatos.
     */
    @Test
    public void testEditarTrabajo() throws Exception {
        System.out.println("editarTrabajo");
        Trabajo trabajo = null;
        FDatos instance = new FDatos();
        instance.editarTrabajo(trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTrabajo method, of class FDatos.
     */
    @Test
    public void testEliminarTrabajo() throws Exception {
        System.out.println("eliminarTrabajo");
        Trabajo trabajo = null;
        FDatos instance = new FDatos();
        instance.eliminarTrabajo(trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrabajo method, of class FDatos.
     */
    @Test
    public void testGetTrabajo() throws Exception {
        System.out.println("getTrabajo");
        int folioTrabajo = 0;
        FDatos instance = new FDatos();
        Trabajo expResult = null;
        Trabajo result = instance.getTrabajo(folioTrabajo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrabajos method, of class FDatos.
     */
    @Test
    public void testGetTrabajos() throws Exception {
        System.out.println("getTrabajos");
        FDatos instance = new FDatos();
        List<Trabajo> expResult = null;
        List<Trabajo> result = instance.getTrabajos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrabajosFecha method, of class FDatos.
     */
    @Test
    public void testGetTrabajosFecha() throws Exception {
        System.out.println("getTrabajosFecha");
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrabajosCount method, of class FDatos.
     */
    @Test
    public void testGetTrabajosCount() throws Exception {
        System.out.println("getTrabajosCount");
        FDatos instance = new FDatos();
        int expResult = 0;
        int result = instance.getTrabajosCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarCliente method, of class FDatos.
     */
    @Test
    public void aClientes_Agregar() throws Exception {
        Cliente cliente = new Cliente(1, "CUPU800825569", "Tractomotores del Yaqui SA", "ulisescvpr@gmail.com");
        try {
            System.out.println("aClientes_Agregar");
            System.out.println("");
            instance.agregarCliente(cliente);
        } catch (Exception exception) {
            if (exception instanceof PreexistingEntityException) {
                System.out.println(exception.getMessage());
            } else {
                fail(exception.getMessage());
            }
        }
    }

    /**
     * Test of editarCliente method, of class FDatos.
     */
    @Test
    public void bClientes_Editar() throws Exception {
        Cliente cliente = new Cliente(1, "CUPU800825569", "TRACTOMOTORES DEL YAQUI SA DE CV", "ulisescvpr2020@gmail.com");
        Cliente clienteBuscado = instance.getClienteRFC("CUPU800825569");

        try {
            if (clienteBuscado != null) {
                cliente.setIdCliente(clienteBuscado.getIdCliente());
                instance.editarCliente(cliente);
                System.out.println("bClientes_Editar()");
                System.out.println("De: " + clienteBuscado);
                System.out.println("A: " + instance.getClienteRFC("CUPU800825569"));
                System.out.println("");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            fail(exception.getMessage());
        }
    }

    /**
     * Test of eliminarCliente method, of class FDatos.
     */
    @Test
    public void fClientes_Eliminar() throws Exception {
        Cliente cliente = instance.getClienteRFC("CUPU800825569");

        try {
            instance.eliminarCliente(cliente);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            fail(exception.getMessage());
        }
    }

    /**
     * Test of getCliente method, of class FDatos.
     */
    @Test
    public void cClientes_GetCliente() throws Exception {
        Cliente cliente = instance.getClienteRFC("CUPU800825569");

        Cliente clienteObtenido = instance.getCliente(cliente.getIdCliente());
        assertEquals(cliente, clienteObtenido);

        System.out.println("cClientes_GetCliente");
        System.out.println(cliente);
        System.out.println("");
    }

    /**
     * Test of getClientes method, of class FDatos.
     */
    @Test
    public void dClientes_GetClientes() throws Exception {
        List<Cliente> clientes = instance.getClientes();

        if (clientes == null) {
            fail("Se retorno una lista nula y no vacia");
        } else {
            System.out.println("d_testGetClientes()");
            System.out.println(clientes.toString());
        }
    }

    /**
     * Test of getClientesCount method, of class FDatos.
     */
    @Test
    public void eCliente_GetCount() throws Exception {
        int clientesCount = instance.getClientesCount();

        if (clientesCount <= 0) {
            fail("El orden de reproduccion de las pruebas no permite que "
                    + "existan menos de 1 cliente");
        }
    }

    /**
     * Test of agregarInsumo method, of class FDatos.
     */
    @Test
    public void testAgregarInsumo() throws Exception {
        System.out.println("agregarInsumo");
        Insumo insumo = null;
        FDatos instance = new FDatos();
        instance.agregarInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarInsumo method, of class FDatos.
     */
    @Test
    public void testEditarInsumo() throws Exception {
        System.out.println("editarInsumo");
        Insumo insumo = null;
        FDatos instance = new FDatos();
        instance.editarInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarInsumo method, of class FDatos.
     */
    @Test
    public void testEliminarInsumo() throws Exception {
        System.out.println("eliminarInsumo");
        Insumo insumo = null;
        FDatos instance = new FDatos();
        instance.eliminarInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarUsuario method, of class FDatos.
     */
    @Test
    public void testAgregarUsuario() throws Exception {
        System.out.println("agregarUsuario");
        Usuario usuario = null;
        FDatos instance = new FDatos();
        instance.agregarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTarea method, of class FDatos.
     */
    @Test
    public void testAgregarTarea() throws Exception {
        System.out.println("agregarTarea");
        Tarea tarea = null;
        FDatos instance = new FDatos();
        instance.agregarTarea(tarea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarTarea method, of class FDatos.
     */
    @Test
    public void testEditarTarea() throws Exception {
        System.out.println("editarTarea");
        Tarea tarea = null;
        FDatos instance = new FDatos();
        instance.editarTarea(tarea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTarea method, of class FDatos.
     */
    @Test
    public void testEliminarTarea() throws Exception {
        System.out.println("eliminarTarea");
        Tarea tarea = null;
        FDatos instance = new FDatos();
        instance.eliminarTarea(tarea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
