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
import javax.xml.ws.Service;
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
        int resultado = dao.cantidadCitasPorMes(cedula, sacarMes(mes), year);
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
        Vector<CitasReporte> agenda = dao.agendaMedico(cedula, sacarMes(mes), year);
        return agenda;
    }
    /**
     * Permite obtener el numero de mes dado un mes 
     * @param mes mes a convertir
     * @return mes en numero
     */
    private String sacarMes(String mes){
        String mesSalida ="";
        switch(mes){
            case "Enero":
                mesSalida="1";
                break;
            case "Febrero":
                mesSalida="2";
                break;
            case "Marzo":
                mesSalida="3";
                break;
            case "Abril":
                mesSalida="4";
                break;
            case "Mayo":
                mesSalida="5";
                break;
            case "Junio":
                mesSalida="6";
                break;
            case "Julio":
                mesSalida="7";
                break;
            case "Agosto":
                mesSalida="8";
                break;
            case "Septiembre":
                mesSalida="9";
                break;
            case "Octubre":
                mesSalida="10";
            case "Noviembre":
                mesSalida="11";
                break;
            case "Diciembre":
                mesSalida="12";
                break;
             
        }
        return mesSalida;
            
                
    }
    
}
