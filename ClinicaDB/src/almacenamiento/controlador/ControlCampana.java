/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;


import almacenamiento.accesodatos.DAOCampana;
import java.sql.Connection;
import proceso.Campana;

/**
 *
 * @author daniel
 */
public class ControlCampana {
    private DAOCampana dao;
    
    public ControlCampana(Connection conn){
        dao = new DAOCampana(conn);
        
    }

    public Campana[] listarCausas(boolean tipo) {
        Campana[] resul = dao.listarCampanas(tipo);
        return resul;
    }
}
