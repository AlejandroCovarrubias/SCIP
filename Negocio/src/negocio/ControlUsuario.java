/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import controladores.IDatos;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class ControlUsuario {
    IDatos instance;
    
    ControlUsuario(IDatos facade){
        instance = facade;
    }
    
    String agregar(Usuario cliente){
        return "";
    }
    
    Usuario getUsuario(int id){
        return instance.getUsuario(id);
    }
}
