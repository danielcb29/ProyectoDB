/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;


import almacenamiento.accesodatos.DAOMedicamento;
import java.sql.Connection;
import proceso.Medicamento;

/**
 *
 * @author daniel
 */
public class ControlMedicamento {
    private DAOMedicamento dao;
    
    public ControlMedicamento(Connection conn){
        dao = new DAOMedicamento(conn);
        
    }
    /**
     * Metodo que permite crear un medicamento en la base de datos
     * @param nuevo: Medicamento a ingresar 
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int crearMedicamento(Medicamento nuevo) {
        int resul = dao.crearMedicamento(nuevo);
        return resul;
    }
    /**
     * Permite leer un medicamento de la base de datos
     * @param codigo codigo del medicamento
     * @param tipo discriminante para tener en cuenta los inactivos (false) o solo los activos (true)
     * @return Medicamento almacenado en la base de datos
     */
    public Medicamento leerMedicamento(String codigo, boolean tipo){
        Medicamento resultado = dao.leerMedicamento(codigo, tipo);
        return resultado;
    }
    /**
     * Permite actualizar un medicamento en la base de datos
     * @param codigo : codigo del medicamento a actualizar
     * @param nuevoMed : nuevo medicamento
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarMedicamento(String codigo , Medicamento nuevoMed){
        int resultado = dao.actualizarMedicamento(codigo, nuevoMed);
        return resultado;
    }
    /**
     * Permite hacer el borrado logico de un medicamento
     * @param codigo codigo del medicamento
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int eliminarMedicamento(String codigo){
        int resultado = dao.eliminarMedicamento(codigo);
        return resultado;
    }
    /**
     * Permite listar los medicamentos en la base de datos 
     * @param tipo discriminante para tener en cuenta los inactivos (false) o solo los activos (true)
     * @return arreglo de medicamentos almacenados en la base de datos
     */
    public Medicamento[] listarMedicamentos(boolean tipo){
        Medicamento[] resultado = dao.listMedicamentos(tipo);
        return resultado;
    }
}
