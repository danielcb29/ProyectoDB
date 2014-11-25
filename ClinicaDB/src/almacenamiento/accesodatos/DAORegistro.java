/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;

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
    
}
