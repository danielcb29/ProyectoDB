/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;

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
}
