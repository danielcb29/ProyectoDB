/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author alvaromartinez
 */
public class ControlCitas {
    
    
    private DAOCitas dao;
    
    public ControlCitas(Connection conn){
        dao = new DAOCitas(conn);
        
    }
    /**
     * Metodo que permite almacenar una cita en la base de datos
     * @param nuevoCita: cita a almacenar
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int crearCita(String nuevaCita){
        int resultado = dao.crearCita(nuevaCita);
        return resultado;
    }


    /**
     * Metodo que permite eliminar una cita en la base de datos
     * @param   del paciente a eliminar
     * @return 1 si se pudo desactivar -1 si no se pudo
     */
    public int eliminarCita(String pkCita){
        int resultado = dao.eliminarCita(pkCita);
        return resultado;
    }
    /**
     * Metodo que permite listar las citas registradas en la base de datos
     * @return arreglo de citas
     */
    public String[][] listarCita(String fecha){
        ArrayList<ArrayList <String>> resultado = dao.listCita(fecha);
        String[][] resultadoAr = new String[resultado.size()][resultado.get(1).size()];
        for(int i= 0; i<resultado.size(); i++){
            resultadoAr[i] = resultado.get(i).toArray(resultadoAr[i]);
        }
        return resultadoAr;
    }
    
}
