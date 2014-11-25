/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOHistoria;
import java.sql.Connection;
import proceso.HistoriaClinica;
import proceso.Paciente;

/**
 *
 * @author daniel
 */
public class ControlHistoria {
    
    DAOHistoria dao;
    
    public ControlHistoria(Connection conn){
        dao = new DAOHistoria(conn);
    }
    /**
     * Metodo que permite consultar la existencia de una historia clinica 
     * @param cedula: cedula del paciente al cual corresponde la hc
     * @return valor de verdad sobre la existencia
     */
    public boolean existePaciente(String cedula){
        boolean resultado = dao.existePaciente(cedula);
        return resultado;
    }
    /**
     * Metodo que permite buscar a un paciente en la base de datos
     * @param cedula cedula del paciente a buscar
     * @return paciente 
     */
    public Paciente buscarPaciente(String cedula){
        //CONEXION CON CONTROL PACIENTE PARA LA BUSQUEDA DEL TIPO
        return null;
    }
    /**
     * Metodo que permite almacenar una historia clinica en la base de datos
     * @param hc: historia clinica a almacenar
     * @param paciente: paciente al cual corresponde
     * @return numero de verificacion , 1 ok , -1 sql error
     */
    public int crearHistoria(HistoriaClinica  hc){
        //String cedula = hc.getPersona().getIdentificacion();
        int resultado = dao.crearHC(hc);
        return resultado;
    }
    
    public HistoriaClinica buscarHistoria(String cedula){
        //Falta implementacion
        HistoriaClinica resul = null;
        return resul;
    }
    
    
    
    
}
