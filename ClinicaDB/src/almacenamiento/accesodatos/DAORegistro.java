/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.Causa;
import proceso.Registro;

/**
 *
 * @author daniel
 */
public class DAORegistro {
    private BaseDatos db;
    private Connection conn;
    public DAORegistro(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Metodo que permite crear un registro en la base de datos 
     * @param reg: Registro a almacenar
     * @return indice del registro
     */
    public int crearRegistro(Registro reg) {
        String numHistoria = reg.getHistoriaPaciente().getNumHistoria();
        String idMedico = reg.getMedicoRegistro().getIdentificacion();
        double costo = reg.getPrecio();
        String fecha = reg.getFecha().toString();
        String sql = "INSERT INTO registrohc VALUES(NEXTVAL('registro_seq'),'"+numHistoria+"','"+idMedico+"','"+fecha+"',"+costo+")";
        String selectInd = "SELECT codigoregistro FROM registrohc WHERE numHistoria='"+numHistoria+"' AND fecha='"+fecha+"' AND idMedico='"+idMedico+"'";
        try {
            
            
            Statement sentencia = conn.createStatement();
            sentencia.executeUpdate(sql);
            ResultSet table = sentencia.executeQuery(selectInd);
            int indice =-1;
            while(table.next()){
                indice=table.getInt(1);
            }
            return indice;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAORegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /**
     * Metodo que permite insertar las causas de un registro
     * @param indice : indice del registro
     * @param causas : vector de causas del registro
     * @return numero de confirmacion, 1 ok 
     */
    public int insertarCausasDelRegistro(int indice, Vector<Causa> causas){
        int size = causas.size();
        int insert = 1;
        for(int i = 0 ; i<size;i++){
            int resul = insertarUnaCausaAlRegistro(indice, causas.get(i));
            if(resul == -1){
                insert=-1;
                break;
            }
        }
        return insert;
    }
    /**
     * Metodo que permite insertar una causa a un registro
     * @param indice indice del registro
     * @param causa causa a insertar
     * @return 
     */
    private int insertarUnaCausaAlRegistro(int indice , Causa causa){
        String codigoCausa = causa.getCodigoCausa();
        String sql = "INSERT INTO causas_registro VALUES('"+codigoCausa+"','"+indice+"')";
        int numRow = 0;
        try {
            Statement sentencia = conn.createStatement();
            numRow = sentencia.executeUpdate(sql);
            return numRow;
        } catch (SQLException ex) {
            Logger.getLogger(DAORegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /**
     * Permite consultar la cantidad de campañas a las cuales esta asignado un paciente
     * @param identificacion identificacion del paciente 
     * @return numero de campañas al cual esta asginado
     */
    public int consultarCantidadCampanas(String identificacion) {
        String sql = "select count(*) from pacientes_campana where idpaciente='"+identificacion+"';";
        try {
            
            Statement sentencia = conn.createStatement();
            ResultSet table = sentencia.executeQuery(sql);
            int cantidad=0;
            while(table.next()){
                cantidad= table.getInt(1);
            } 
            return cantidad;
        } catch (SQLException ex) {
            Logger.getLogger(DAORegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
