/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOCausa;
import almacenamiento.accesodatos.DAOReportes;
import java.sql.Connection;
import java.util.Vector;
import proceso.CitasReporte;

/**
 *
 * @author daniel
 */
public class ControlReporte {
    private DAOReportes dao;
    
    public ControlReporte(Connection conn){
        dao = new DAOReportes(conn);
        
    }
    /**
     * Permite constar el numero de citas que tiene un medico en una mes y un año dado
     * @param cedula cedula del medico a consultar
     * @param mes mes el cual se consultara
     * @param year año sobre el cual se consultara 
     * @return numero de citas encontras para dicho medico
     */
    public int numeroDeCitasMedico(String cedula, String mes , String year){
        int resultado = dao.cantidadCitasPorMes(cedula, mes, year);
        return resultado;
    }
    /**
     * Permire consultar la agenda de un medico en un mes y año especifico
     * @param cedula cedula del medico a consultar
     * @param mes mes sobre el cual consultara
     * @param year año sobre el cual se consultara
     * @return vector con las respectivas citas del medico
     */
    public Vector<CitasReporte> agendaMedico(String cedula, String mes , String year){
        Vector<CitasReporte> agenda = dao.agendaMedico(cedula, mes, year);
        return agenda;
    }
}
