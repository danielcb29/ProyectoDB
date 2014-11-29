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
}
