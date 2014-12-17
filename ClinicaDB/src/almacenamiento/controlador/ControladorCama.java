/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOCama;
import java.sql.Connection;
import java.util.Date;
import proceso.Cama;

/**
 *
 * @author cenesis
 */
public class ControladorCama {
    
    private DAOCama dao;
    
    public ControladorCama(Connection conn){
        dao = new DAOCama(conn);
        
    }
    /**
     * Metodo que permite almacenar un cama en la base de datos
     * @param nuevaCama: cama a almacenar
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int crearCama(Cama nuevaCama){
        int resultado = dao.crearCama(nuevaCama);
        return resultado;
    }
    /**
     * Metodo que permite leer un paciente de la base de datos
     * @param identificacion de la causa
     * @return paciente leido
     */
    public Cama leerCama(String identificacion, boolean tipo){
        Cama resultado = dao.leerCama(identificacion, tipo);
        return resultado;
    }
    /**
     * Metodo que permite actualizar los pacientes de una base de datos
     * @param identificacion de la causa a actualizar
     * @param modCama informacion de la cama modificada
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarCama(String identificacion , Cama modCama){
        int resultado;
        resultado = dao.modificarCama(identificacion, modCama);
        return resultado;
    }
    /**
     * Metodo que permite inactivar un paciente en la base de datos
     * @param numeroCama identificacion  de la cama a eliminar
     * @return 1 si se pudo desactivar -1 si no se pudo
     */
    public int eliminarCama(String numeroCama){
        int resultado = dao.eliminarCama(numeroCama);
        return resultado;
    }
    /**
     * Metodo que permite listar los pacientes registrados en la base de datos
     * @return arreglo de pacientes
     */
    public Cama[] listarCamas(Boolean tipo){
        Cama[] resultado;
        resultado = dao.listCama(tipo);
        return resultado;
    }

    public int asignarPaciente(String numeroCama, String cedulaPac, Date fechaAsig) {
        int resultado;
        resultado = dao.asignarCama(numeroCama, cedulaPac, fechaAsig);
        return resultado;    
    }
    
}
