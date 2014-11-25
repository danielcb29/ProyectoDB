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
    
 
     
    /** metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
 /**   public int countUsers ()  
    {
        Usuario [] users = new Usuario [5];
        int size =  users.length;
        return size;
                
    }
    

    public int editUser(String cedula, String name, String lastName, String userName, String password, String email, String perfil, Convocatoria convo,boolean estado) {
        int result;
        result = 0;
        Usuario user = new Usuario(name,lastName,userName,password,email,perfil,cedula,convo);
        user.setState(estado);
        result = daoUser.updateUser(user, cedula);

        return result;
    }

    public int  deleteUser(String text) {
        return daoUser.deleteUser(text);
    }
    
    
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoAr.closeConectionDB();
    }

}//fin clase


