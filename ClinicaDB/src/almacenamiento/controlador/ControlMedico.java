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

public class ControlMedico {
    

    DAOMedico daoMe;
    DAOEmpleado daoEm;
    
    /**
     * constructor
     * @param conn conexion base de datos
     * **/
    public ControlMedico(Connection conn){
        daoMe=new DAOMedico(conn);
        daoEm= new DAOEmpleado();
    }
    public void connectDB(){
        daoMe.connectDB();
    }
    public Connection getConn(){
        return daoMe.getConn();
    }
     /**
     * metodo encargado de pasar el usuario a ingresar a la base de
     * satos al DAOusuario. 
     * @param id cedula del medico
     * @param nombres nombre del medico
     * @param apellidos  apellidos del medico
     * @param telefono telefono del medico
     * @param direccion direccion del medico
     * @param sal salario del medico
     * @param email email del medico
     * @param cargo cargo del medico
     * @param contrasena contrasena del medico
     * @param jefe jefe del medico, "-1" si no tiene jefe
     * @param area area del medico, objeto null si es administrador
     * @param estado estado del medico
     * @param numeroLicencia  el numero de licencia del medico
     * @param especialidad especialidad del medico
     * @param universidad universidad del medico
     * @return 0 si no fue posible crear el usuario. 1 si se creo satisfactoriamente el usuario.
     */
    public int   createMedico (String id, String nombres, String apellidos, String telefono, String direccion, int sal, String email ,String cargo, String contrasena , String jefe, Area area, boolean estado, int numeroLicencia, String especialidad, String universidad)
    {
        Empleado em = new Empleado(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado);
        daoEm.createEmpleado(em);
        
        Medico med = new Medico(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado, numeroLicencia, especialidad, universidad);
        
        
        //Se llama al dao para guardar
        int result = daoMe.createMedico(med);
        
         
        
        return result;

    }
    /**
     * metodo encargado de pasar el username a Dao para que consulte si el 
     * usuario existe
     * @param req el correo o identificacion del medico que se quiere consultar.
     * @param tipoCon 1 si es correo electronico, 2 si es identificacion
     * @return null si hay error en la consulta a la base de datos. Objeto tipo Medico si el objeto del usuario que se consulto. 
    */
    public Medico   readMedico (Empleado em){

        
        System.out.println("antes readMedico");
        Medico me= daoMe.readMedico(em);
        return me;

    }
    
    
 
     
    /** metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
    public Medico[] listMedico ()  
    {
        Medico [] me = daoMe.listMedico();
        return  me;
                
    }
    /**

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
        daoMe.closeConectionDB();
    }

}//fin clase


