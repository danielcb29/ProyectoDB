/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;


import almacenamiento.accesodatos.DAOMedicamento;
import java.sql.Connection;

/**
 *
 * @author daniel
 */
public class ControlMedicamento {
    private DAOMedicamento dao;
    
    public ControlMedicamento(Connection conn){
        dao = new DAOMedicamento(conn);
        
    }
}
