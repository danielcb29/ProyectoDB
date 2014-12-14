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

public class ControlEnfermera {
    

    DAOEnfermera daoEnf;
    DAOEmpleado daoEm;
    
    /**
     * constructor
     * @param conn conexion base de datos
     * **/
    public ControlEnfermera(Connection conn){
        daoEnf=new DAOEnfermera(conn);
        daoEm= new DAOEmpleado();
        daoEm.connectDB();
    }
    public void connectDB(){
        daoEnf.connectDB();
    }
    public Connection getConn(){
        return daoEnf.getConn();
    }
     /**
     * metodo encargado de pasar el usuario a ingresar a la base de
     * satos al DAOusuario. 
     * @param id cedula del enfermera
     * @param nombres nombre del enfermera
     * @param apellidos  apellidos del enfermera
     * @param telefono telefono del enfermera
     * @param direccion direccion del enfermera
     * @param sal salario del enfermera
     * @param email email del enfermera
     * @param cargo cargo del enfermera
     * @param contrasena contrasena del enfermera
     * @param jefe jefe del enfermera, "-1" si no tiene jefe
     * @param area area del enfermera, objeto null si es administrador
     * @param estado estado del enfermera
     * @param anos años de experiencia del enfermera
     * @param habs habilidades de la enfermera
     * @return 0 si no fue posible crear el usuario. 1 si se creo satisfactoriamente la enfermera.
     */
    public int   createEnfermera (String id, String nombres, String apellidos, String telefono, String direccion, int sal, String email ,String cargo, String contrasena , String jefe, Area area, boolean estado, int anos, String[] habs)
    {
        Empleado em = new Empleado(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado);
        daoEm.createEmpleado(em);
        
        Enfermera enf = new Enfermera(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado, anos, habs);
        
        
        //Se llama al dao para guardar
        int result = daoEnf.createEnfermera(enf);
        
         
        
        return result;

    }
    /**
     * metodo encargado de pasar el username a Dao para que consulte si la enfermera existe
     * @param em objeto Empleado
     * @return null si hay error en la consulta a la base de datos. Objeto tipo Medico si el objeto del usuario que se consulto. 
    */
    public Enfermera   readEnfermera (Empleado em){

        
        System.out.println("antes readMedico");
        Enfermera enf= daoEnf.readEnfermera(em);
        return enf;

    }
    
    
 
     
    /** metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
  /* public Medico[] listMedico ()  
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
        daoEnf.closeConectionDB();
    }

}//fin clase


