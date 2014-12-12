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
import java.text.SimpleDateFormat;
import java.util.Date;
import proceso.Campana;


/**
 *
 * @author daniel
 */
public class DAOCampana {
    private BaseDatos db;
    private Connection conn;
    public DAOCampana(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }

    public Campana[] listarCampanas(boolean tipo) {
        String sql_select,sql_count;
        if(tipo){
            sql_select="SELECT codigoCampana,nombre,fecha,objetivo,estado,idResponsable FROM Campana WHERE estado= true;";
            sql_count = "SELECT COUNT(*) FROM Campana WHERE estado=true";
        }else{
            sql_select="SELECT codigoCampana,nombre,fecha,objetivo,estado FROM Campana ;";
            sql_count = "SELECT COUNT(*) FROM Campana ";
        }
        
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);
                  
            System.out.println(tamano);
            Campana campanas[]= new Campana[tamano];
            for(int i=0; i<tamano; i++){
                campanas[i]=new Campana();
            }
            
            int j=0;
            
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            while(table.next()){
               
                campanas[j].setCodigoCampana(table.getString(1));
                
                campanas[j].setNombre(table.getString(2));
                
                Date fecha;
                fecha = format.parse(table.getString(3));
                campanas[j].setFecha(fecha);
                
                campanas[j].setObjetivo(table.getString(4));
                
                campanas[j].setEstado(table.getBoolean(5));               

                //Medico 
                
                String idMedico = table.getString(6);
                //Medico responsable = daoMedico.leerMedico(idMedico);
                
                j++;
              System.out.println("ok");
            }
           
            return campanas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
}
