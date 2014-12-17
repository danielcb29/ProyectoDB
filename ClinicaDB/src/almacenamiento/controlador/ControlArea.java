/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import proceso.*;
import almacenamiento.accesodatos.*;
import java.sql.Connection;

/**
 *
 * @author Fernando
 */

public class ControlArea {
    

    DAOArea daoAr;
    

    
    /**
     * constructor
     * @param conn conexion base de datos
     * **/
    public ControlArea(Connection conn){
        daoAr=new DAOArea(conn);
    }
    public void connectDB(){
        daoAr.connectDB();
    }
    public Connection getConn(){
        return daoAr.getConn();
    }
     /**
     * metodo encargado de pasar el area a ingresar a la base de datos al DAOArea. 
     * @param codigoArea: codigo del area
     * @param nombre: nombre del area
     * @param descripcion: descripcion del area
     * @param estado: estado del area
     * @return result: 0 si no fue posible crear el Area. 1 si se creo satisfactoriamente el Area.
     */
    public int   createArea (int codigoArea, String nombre, String descripcion, boolean estado)
    {
        
        Area ar = new Area(codigoArea,nombre, descripcion, estado);
        
        //Se llama al dao para guardar
        int result =daoAr.createArea(ar);
        
        return result;

    }
    /**
     * pasa el codigo al Dao para que consulte si el area existe y diga cual es
     * @param cod : codigo del area a consultar
     * @return objeto con los atributos del area
     * es objeto es nulo en caso de no existir el usuario.
     */
    public Area   readArea (int cod){
        Area ar = daoAr.readArea(cod);
        
        return ar;

    }
    
 
     
    /** metodo que llama al Dao para listar las areas que existen
     * @return arreglo de Area
     */
    public Area[] listArea ()  
    {
        Area [] ar = daoAr.listArea();
        
        return ar;
                
    }
    
    
    
    public int updateArea(int codigoArea, String nombre, String descripcion, boolean estado){
        Area ar = new Area(codigoArea, nombre, descripcion, estado);
        
        int result = daoAr.updateArea(ar, codigoArea);

        return result;
    }
    /**
    * borrar un usuario de la tabla.
    * @param cod el codigo del area que se quiere borrar.
    * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
    */
    public int  deleteArea(int cod) {
        return daoAr.deleteArea(cod);
    }
    
    
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoAr.closeConectionDB();
    }

}//fin clase


