/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.HistoriaClinica;
import proceso.Paciente;

/**
 *
 * @author daniel
 */
public class DAOHistoria {
    private BaseDatos db;
    private Connection conn;
    private DaoPaciente daoPac;
    public DAOHistoria(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
        daoPac = new DaoPaciente(conn);
    }
    /**
     * Metodo que permite consultar la existencia de una historia clinica asignada a un paciente
     * @param cedula: cedula del paciente a validar
     * @return valor de existencia en la base de datos
     */
    public boolean existePaciente(String cedula){
        boolean resultado = false;
        String sql = "select count(*) from (select numhistoria from historiaclinica where idpaciente = '"+cedula+"') as a";
        //String tam = "SELECT COUNT(*) FROM historiaclinica";
        try {
          
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            table.next();
            int tamano = table.getInt(1);
            if(tamano!=0){
                resultado = true;
            }
            
            
            
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ojo que paso un error en la sentencia");
        return resultado;
    }
    /**
     * Metodo que permite crear una historia clinica en la base de datos
     * @param hc: historia clinica a almacenar
     * @param ccPaciente: cedula del paciente al cual corresponde dicha historia
     * @return numero de verificacion , 1ok , -1 sql error
     */
    public int crearHC(HistoriaClinica hc){
        Date fecha = hc.getFechaAper();
        String ccPaciente=hc.getPersona().getIdentificacion();
        int numRows=0;
        SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
        format.format(fecha);
        String datePSQL = fecha.toString();
            
        System.out.println("date one :"+datePSQL);
            
        String sql = "INSERT INTO historiaclinica VALUES(NEXTVAL('hist_seq'),'"+datePSQL+"','"+ccPaciente+"');";
        try {
            
            
            Statement sentencia = conn.createStatement();
            numRows = sentencia.executeUpdate(sql);            
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /**
     * Metodo que permite leer la historia clinica de una base de datos
     * @param cedula: cedula del paciente al cual pertenece la historia
     * @return historia clinica
     */
    public HistoriaClinica leerSimpleHC(String cedula){
        
        String sql = "SELECT numHistoria, fechaAper FROM HistoriaClinica WHERE idPaciente ='"+cedula+"'; ";
            
        HistoriaClinica nuevaHC = new HistoriaClinica();
        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            //String idPaciente = "";
            while(table.next()){
                    
                    nuevaHC.setNumHistoria(table.getString(1));
                    
                    Date fechaAper;
                    System.out.println("Antes de formatear la fecha");
                    fechaAper = format.parse(table.getString(2));
                    System.out.println("Despues de formatear la fecha");
                    nuevaHC.setFechaAper(fechaAper);
                    
                    //idPaciente = table.getString(3);
                }
            
            Paciente paciente = daoPac.leerPaciente(cedula);
            nuevaHC.setPersona(paciente);
            
            return nuevaHC;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
