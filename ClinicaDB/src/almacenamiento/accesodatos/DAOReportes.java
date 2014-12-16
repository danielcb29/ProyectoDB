/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import proceso.CitasReporte;

/**
 *
 * @author daniel
 */
public class DAOReportes {
    private BaseDatos db;
    private Connection conn;
    public DAOReportes(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Permite consultar la agenda de un medico dado un año y un mes 
     * @param idMedico cedula del medico a consultar agenda
     * @param mes mes sobre el cual se consultara
     * @param year año sobre el cual se consulara
     * @return vector con citas en dicho mes y año
     */
    public Vector<CitasReporte> agendaMedico(String idMedico, String mes, String year){
        String sql = "select fecha,hora,idpaciente, nombres,apellidos from cita,persona where idpaciente=identificacion and estado=true and (select extract(year from fecha)) = '2014' and (select extract(month from fecha)) = '01' and idMedico='1';";
        System.out.println("consultando en la bd");
        Vector<CitasReporte> agenda = new Vector<CitasReporte>();   
        try {
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            while(table.next()){
               CitasReporte cita = new CitasReporte();
               String fecha = table.getString(1);
               cita.setFecha(fecha);
               String hora = table.getString(2);
               cita.setHora(hora);
               String idPaciente = table.getString(3);
               cita.setIdPaciente(idPaciente);
               String nombres = table.getString(4);
               cita.setNombrePaciente(nombres);
               String apellidos = table.getString(5);
               cita.setApellidosPaciente(apellidos);
               
               agenda.add(cita);
               
            }
            return agenda;
        } catch (SQLException ex) {
            Logger.getLogger(DAOReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Permite consultar la cantidad de citas atendidas por un medico en un mes y año particular
     * @param idMedico medico el cual atendio dichas citas
     * @param mes mes en el cual se atendieron las citas 
     * @param year año sobre l cual se van a consultar las citas
     * @return numero de citas atendidas
     */
    public int cantidadCitasPorMes(String idMedico, String mes, String year){
        String sql="select count(*) from cita where (select extract(year from fecha)) = '"+year+"' and (select extract(month from fecha)) = '"+mes+"' and idMedico='"+idMedico+"' and estado=true;";
        try {
            
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            table.next();
            int citas = table.getInt(1);
            return citas;
        } catch (SQLException ex) {
            Logger.getLogger(DAOReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    } 
    
}
