/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOHistoria;
import java.sql.Connection;
import java.util.Vector;
import proceso.HistoriaClinica;
import proceso.Paciente;
import proceso.Registro;

/**
 *
 * @author daniel
 */
public class ControlHistoria {
    
    private DAOHistoria dao;
    private ControlPaciente controlPac;
    
    public ControlHistoria(Connection conn){
        dao = new DAOHistoria(conn);
        //System.out.println("creado control pac");
        controlPac = new ControlPaciente(conn);
        
    }
    /**
     * Metodo que permite consultar la existencia de una historia clinica 
     * @param cedula: cedula del paciente al cual corresponde la hc
     * @return valor de verdad sobre la existencia
     */
    public boolean existePaciente(String cedula){
        boolean resultado = dao.existePaciente(cedula);
        return resultado;
    }
    /**
     * Metodo que permite buscar a un paciente en la base de datos
     * @param cedula cedula del paciente a buscar
     * @return paciente 
     */
    public Paciente buscarPaciente(String cedula){
        Paciente paciente = controlPac.leerPaciente(cedula);
        return paciente;
    }
    /**
     * Metodo que permite almacenar una historia clinica en la base de datos
     * @param hc: historia clinica a almacenar
     * @param paciente: paciente al cual corresponde
     * @return numero de verificacion , 1 ok , -1 sql error
     */
    public int crearHistoria(HistoriaClinica  hc){
        //String cedula = hc.getPersona().getIdentificacion();
        int resultado = dao.crearHC(hc);
        return resultado;
    }
    /**
     * Permite buscar la informacion general de una historia clinica, sin registros
     * @param cedula: cedula del paciente
     * @return Historia sin registros
     */
    public HistoriaClinica buscarHistoria(String cedula){
        
        HistoriaClinica resul = dao.leerSimpleHC(cedula);
        return resul;
    }
    /**
     * Permite buscar una historia cilinica completa con registros y causas 
     * @param cedula: cedula del paciente
     * @return Historia completa
     */
    public HistoriaClinica buscarHistoriaCompleta(String cedula){
        
        HistoriaClinica hist = buscarHistoria(cedula);
        String idHistoria = hist.getNumHistoria();
        if(idHistoria!=null){
            Vector<Registro> registros = dao.leerRegistrosHistoria(idHistoria);
            hist.setRegistrosConsultasPacientes(registros);
            return hist;
        }else{
            return null;
        }
        
        
    }
    
    
    
    
}
