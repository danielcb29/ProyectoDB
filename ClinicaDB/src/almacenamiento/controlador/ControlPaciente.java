/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;


import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.Paciente;

/**
 *
 * @author alvaromartinez
 */
public class ControlPaciente {
    
    private DaoPaciente dao;
    
    public ControlPaciente(Connection conn){
        dao = new DaoPaciente(conn);
        try {
            System.out.println("creando paciente NEW");
            dao.pruebaCrearPaciente();
        } catch (ParseException ex) {
            Logger.getLogger(ControlPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * Metodo que permite almacenar un paciente en la base de datos
     * @param nuevoPaciente: paciente a almacenar
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int crearPaciente(Paciente nuevoPaciente){
        int resultado = dao.crearPaciente(nuevoPaciente);
        return resultado;
    }
    /**
     * Metodo que permite leer un paciente de la base de datos
     * @param identificacion de la causa
     * @return paciente leido
     */
    public Paciente leerPaciente(String identificacion){
        Paciente resultado = dao.leerPaciente(identificacion);
        return resultado;
    }
    /**
     * Metodo que permite actualizar los pacientes de una base de datos
     * @param identificacion de la causa a actualizar
     * @param modPaciente informacion del paciente modificado
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarPaciente(String identificacion , Paciente modPaciente){
        int resultado = dao.modificarPaciente(identificacion, modPaciente);
        return resultado;
    }
    /**
     * Metodo que permite inactivar un paciente en la base de datos
     * @param identificacion identificacion  del paciente a eliminar
     * @return 1 si se pudo desactivar -1 si no se pudo
     */
    public int eliminarPaciente(String nombre){
        int resultado = dao.eliminarPaciente(nombre);
        return resultado;
    }
    /**
     * Metodo que permite listar los pacientes registrados en la base de datos
     * @return arreglo de pacientes
     */
    public Paciente[] listarPaciente(){
        Paciente[] resultado = dao.listPacientes();
        return resultado;
    }

}
