/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    //private DaoPaciente daoPac;
    public DAOHistoria(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Metodo que permite consultar la existencia de una historia clinica asignada a un paciente
     * @param cedula: cedula del paciente a validar
     * @return valor de existencia en la base de datos
     */
    public boolean existePaciente(String cedula){
        boolean resultado = false;
        String sql = "SELECT numhistoria FROM historiaclinica where idpaciente = '"+cedula+"'";
        String tam = "SELECT COUNT(*) FROM historiaclinica";
        try {
          
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tableTam = sentence.executeQuery(tam);
            tableTam.next();
            int tamano = tableTam.getInt(1);
            if(tamano!=0){
                ResultSet table = sentence.executeQuery(sql);
                String numero = "";
                table.next();
                numero  = table.getString(1);
                /*while(table.next()){
                    System.out.println("entramos al while");
                    numero  = table.getString(1);
                }*/

                if(numero != null){
                    resultado = true;
                }
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
    
    public HistoriaClinica leerHC(String cedula){
        
        String sql = "SELECT numHistoria, fechaAper FROM HistoriaClinica WHERE idPaciente ='"+cedula+"'; ";
            
        HistoriaClinica nuevaHC = new HistoriaClinica();
        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm");    
            //String idPaciente = "";
            while(table.next()){
                    
                    nuevaHC.setNumHistoria(table.getString(1));
                                    
                    Date fechaAper;
                    fechaAper = format.parse(table.getString(2));
                    nuevaHC.setFechaAper(fechaAper);
                    
                    //idPaciente = table.getString(3);
                }
            
            //Paciente paciente = daoPac.leerPaciente(cedula);
            //nuevaHC.setPersona(paciente);
            
            return nuevaHC;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
