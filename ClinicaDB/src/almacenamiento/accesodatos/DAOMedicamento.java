/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import proceso.Medicamento;

/**
 *
 * @author daniel
 */
public class DAOMedicamento {
    private BaseDatos db;
    private Connection conn;
    public DAOMedicamento(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Metodo que permite almacenar un medicamento en la base de datos
     * @param nuevo medicamento a almacenar
     * @return numero de confirmacion , 1ok , -1 error , -2 sql error
     */
    public int crearMedicamento(Medicamento nuevo) {
        String sql_save;
        int numRows=0;
      
        String codigo = nuevo.getCodigoMedicamento();
        String nombre = nuevo.getNombre();
        String descripcion = nuevo.getDescripcion();
        double costo = nuevo.getCosto();
        

        sql_save="INSERT INTO Medicamentos VALUES ( '"+codigo+"'  , '" + nombre +  "', '" + costo + "','"+descripcion+"',true);";
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);            
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            
            System.out.println(e);
        }
        return -1;
    }
}
