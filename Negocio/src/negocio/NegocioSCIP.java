/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Alejandro Galindo
 */
public class NegocioSCIP {
    static INegocio getFacade(){
        return new FNegocio();
    }
}
