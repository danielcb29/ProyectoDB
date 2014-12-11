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

public class ControlEmpleado {
    

    DAOEmpleado daoEm;
    ControlMedico controlMe;

    
    /**
     * constructor
     * **/
    public ControlEmpleado(){
        daoEm=new DAOEmpleado();
        
    }
    public void connectDB(){
        daoEm.connectDB();
        controlMe=new ControlMedico(daoEm.getConn());
    }
    public Connection getConn(){
        return daoEm.getConn();
    }
     /**
     * metodo encargado de pasar el usuario a ingresar a la base de
     * satos al DAOusuario. 
     * @param id cedula del empleado
     * @param nombres nombre del empleado
     * @param apellidos  apellidos del empleado
     * @param telefono telefono del empleado 
     * @param direccion direccion del empleado
     * @param sal salario del empleado
     * @param email email del empleado
     * @param cargo cargo del empleado
     * @param contrasena contrasena del empleado
     * @param jefe jefe del empleado, "-1" si no tiene jefe
     * @param area area del empleado, objeto null si es administrador
     * @param estado estado del empleado
     * @return 0 si no fue posible crear el usuario. 1 si se creo satisfactoriamente el usuario.
     */
    public int   createEmpleado (String id, String nombres, String apellidos, String telefono, String direccion, int sal, String email ,String cargo, String contrasena , String jefe, Area area, boolean estado)
    {
        
        
        Empleado em = new Empleado(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado);
        
        //Se llama al dao para guardar
        int result =daoEm.createEmpleado(em);
        
        return result;

    }
    /**
     * metodo encargado de pasar el username a Dao para que consulte si el 
     * usuario existe
     * @param req el correo o identificacion del empleado que se quiere consultar.
     * @param tipoCon 1 si es correo electronico, 2 si es identificacion
     * @return null si hay error en la consulta a la base de datos. Objeto tipo Empleado si el objeto del usuario que se consulto. 
    */
    public Empleado   readEmpleado (String req, int tipoCon, int cargo){
        Empleado em;
        switch(cargo){
            case 0:
                em = daoEm.readEmpleado(req, tipoCon);
                break;
            /*case 1:
                System.out.println("antes readEmplado");
                Empleado em1 = daoEm.readEmpleado(req, tipoCon);
                em= controlMe.readMedico(em1);
                break;*/
            default:
                em=null;
                System.out.println("no existe cargo");
        }
        
        return em;

    }
    
 
     
    /** metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
   /** public int countUsers ()  
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
        daoEm.closeConectionDB();
    }

}//fin clase


