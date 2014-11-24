/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOCausa;
import java.sql.Connection;
import proceso.Causa;

/**
 *
 * @author daniel
 */
public class ControlCausa {
    private DAOCausa dao;
    
    public ControlCausa(Connection conn){
        dao = new DAOCausa(conn);
        
    }
    /**
     * Metodo que permite almacenar una causa en la base de datos
     * @param nuevaCausa: causa a almacenar
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int crearCausa(Causa nuevaCausa){
        int resultado = dao.crearCausa(nuevaCausa);
        return resultado;
    }
    /**
     * Metodo que permite leer una causa de la base de datos
     * @param nombre nombre de la causa
     * @param tipo si se desea leer estando inactiva 
     * @return causa leida
     */
    public Causa leerCausa(String nombre, boolean tipo){
        Causa resultado = dao.leerCausa(nombre, tipo);
        return resultado;
    }
    /**
     * Metodo que permite actualizar las causas de una base de datos
     * @param nombre nombre de la causa a actualizar
     * @param nuevaCausa informacion de la nueva causa
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarCausa(String nombre , Causa nuevaCausa){
        int resultado = dao.actualizarCausa(nombre, nuevaCausa);
        return resultado;
    }
    /**
     * Metodo que permite inactivar una causa en la base de datos
     * @param nombre
     * @return 
     */
    public int eliminarCausa(String nombre){
        int resultado = dao.eliminarCausa(nombre);
        return resultado;
    }
    /**
     * Metodo que permite listar las causas registradas en la base de datos
     * @param tipo si se desea traer todas o solo las causas activas
     * @return arreglo de causas
     */
    public Causa[] listarCausas(boolean tipo){
        Causa[] resultado = dao.listCausa(tipo);
        return resultado;
    }
    //TEMPORAL PARA PRUEBAS
     public void connectDB(){
        dao.connectDB();
    }
    
}
