/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAORegistro;
import java.sql.Connection;
import proceso.Causa;
import proceso.HistoriaClinica;


/**
 *
 * @author daniel
 */
public class ControlRegistro {
    DAORegistro daoReg;
    ControlCausa controlCausa;
    ControlHistoria controlHis;
    public ControlRegistro(Connection conn){
        daoReg = new DAORegistro(conn);
        controlCausa=new ControlCausa(conn);
        controlHis = new ControlHistoria(conn);
    }
    /**
     * Metodo que permite listar las causas almacenadas en la base de datos
     * @return arreglo de causas del sistema
     */
    public Causa[] listarCausas(){
        Causa[] resul = controlCausa.listarCausas(true);
        return resul;
    }
    
    public HistoriaClinica buscarHistoria(String cedula){
        //Se de debe hacer la conexion con el control paciente para obtener el paciente
        HistoriaClinica result = controlHis.buscarHistoria(cedula);
        return result;
    }
}
