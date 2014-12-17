/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAORegistro;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JOptionPane;
import proceso.Causa;
import proceso.HistoriaClinica;
import proceso.Paciente;
import proceso.Registro;


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
    /**
     * Metodo que permite traer la informacion general de una historia clinica (sin registros)
     * @param cedula: cedula del paciente
     * @return Historia sin registros
     */
    public HistoriaClinica buscarHistoria(String cedula){
        //Se de debe hacer la conexion con el control historia para obtener el paciente
        HistoriaClinica result = controlHis.buscarHistoria(cedula);
        return result;
    }
    /**
     * Metdo que permite crear un registro de una historia clinica en la base de datos
     * @param reg: registro a almacenar 
     * @return valor de confirmacion del registro , 1ok , -1 error , -2 sql error
     */
    public int crearRegitro(Registro reg) {
        String id = reg.getHistoriaPaciente().getPersona().getIdentificacion();
        boolean dcto = hayDescuento(id);
        if(dcto){
            double exVal = reg.getPrecio();
            double valDcto = (exVal * 0.20);
            double newVal = (exVal - valDcto);
            reg.setPrecio(newVal);
            //PONER EN VISTA APENAS SE TENGAN TERMINADAS
            JOptionPane.showMessageDialog(null, "El clinte tiene un descuento del 20% equivalente a "+valDcto+"\nValor del registro queda en "+newVal,"Descuento otorgado",JOptionPane.INFORMATION_MESSAGE);
        }
        
        Vector<Causa> causas = reg.getCausasPaciente();
        int indice = daoReg.crearRegistro(reg);
        int result = daoReg.insertarCausasDelRegistro(indice, causas);
            //controlCausa.crearCausa(causas.get(i));
        
        
        return result;
    }
    /**
     * Permite verificar si el paciente tiene descuento por participar en almenos una campaña
     * @param identificacion id del paciente a verificar
     * @return si tiene o no descuento
     */
    public boolean hayDescuento(String identificacion){
        boolean result = false;
        int cantidad = daoReg.consultarCantidadCampanas(identificacion);
        if(cantidad != 0){
            result = true;
        }
        return result;
    }
    
}
