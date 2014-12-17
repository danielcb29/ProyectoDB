/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;


import almacenamiento.accesodatos.DAOCampana;
import java.sql.Connection;
import proceso.Campana;
import proceso.Medico;

/**
 *
 * @author daniel
 */
public class ControlCampana {
    private DAOCampana dao;
    
    public ControlCampana(Connection conn){
        dao = new DAOCampana(conn);
        
    }
    /**
     * Permite listar las campanas de un medico
     * @param tipo si se quieren las activas(true) o todas(false)
     * @param medico medico del cual se listaran las campañas
     * @return camapañas
     */
    public Campana[] listarCampanasMedico(boolean tipo,Medico medico) {
        Campana[] resul = dao.listarCampanasDeMedico(tipo,medico);
        return resul;
    }
    /**
     * Permite crear una campaña en la base de datos
     * @param nuevaCampana campaña a crear 
     * @return valor de confirmacion 
     */
    public int crearCampana(Campana nuevaCampana) {
        int resul = dao.crearCampana(nuevaCampana);
        return resul;
    }
    /**
     * Permite hacer borrado logico de una campaña en la base de datos 
     * @param seleccionada campaña a eliminar 
     * @return valor de confirmacion
     */
    public int eliminarCampana(Campana seleccionada) {
        String nombre = seleccionada.getNombre();
        String codigo = dao.codigoCampana(nombre);
        int resul = dao.eliminarCausa(codigo);
        return resul;
    }
    /**
     * Permite actualizar los datos de una campaña en la base de datos 
     * @param seleccionada campaña a actualizar 
     * @param nuevaCampana nuevos datos de campaña
     * @return valor de confirmacion
     */
    public int actualizarCampana(Campana seleccionada, Campana nuevaCampana) {
        String nombreExCampaña = seleccionada.getNombre();
        String codigo = dao.codigoCampana(nombreExCampaña);
        int resul = dao.actualizarCampana(codigo,nuevaCampana);
        return resul;
    }

    public Campana[] listarCampComp(boolean b) {
        return dao.listarCampanasCompletas(b);
    }

    public int asignarPacCam(String ident, String codigoCampana) {
        return dao.asignarPacCam(ident, codigoCampana);
    }

    public String[] listarUsuCamp(String codigoCampana) {
        return dao.listarUsuarioCamp(codigoCampana);
     }

    public int eliminarPacCamp(String docum, String codCamp) {
        return dao.eliminarPacCamp(docum, codCamp);
    }
}
