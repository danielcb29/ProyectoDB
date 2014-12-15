/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadb;

import almacenamiento.accesodatos.BaseDatos;
import java.sql.Connection;

/**
 *
 * @author daniel
 */
public class ClinicaDB {

    BaseDatos db;
    Connection conn;
    public ClinicaDB(){
        db = new BaseDatos();
        
    }
    public Connection conectar(){
        conn = db.getConnetion();
        return conn;
                
    }
    public void cerrar(){
        db.closeConection(conn);
    }
    /**
     * @param args the command line arguments
     *//*
    public static void main(String[] args) {
        // TODO code application logic here
    }*/
}
