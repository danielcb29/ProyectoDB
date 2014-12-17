/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import proceso.*;
import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author Fernando
 */

public class ControlEmpleado {
    
    DAOArea daoAr;
    DAOEmpleado daoEm;
    ControlMedico controlMe;
    ControlEnfermera controlEnf;

    
    /**
     * constructor
     * **/
    public ControlEmpleado(){
        daoEm=new DAOEmpleado();
        
    }
    public void connectDB(){
        daoEm.connectDB();
        controlMe=new ControlMedico(daoEm.getConn());
        controlEnf=new ControlEnfermera(daoEm.getConn());
        daoAr = new DAOArea(daoEm.getConn());
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
     * @param cargo 0 si va a leer un empleado diferente de médico, 1 si va a leer un médico
     * @return null si hay error en la consulta a la base de datos. Objeto tipo Empleado si el objeto del usuario que se consulto. 
    */
    public Empleado   readEmpleado (String req, int tipoCon, int cargo){
        Empleado em;
        switch(cargo){
            case 0://Empleado
                em = daoEm.readEmpleado(req, tipoCon);
                break;
            case 1://Médico
                System.out.println("antes readEmplado");
                Empleado em1 = daoEm.readEmpleado(req, tipoCon);
                em= controlMe.readMedico(em1);
                break;
            case 2://Enfermera
                Empleado em2 = daoEm.readEmpleado(req, tipoCon);
                em= controlEnf.readEnfermera(em2);
                break;
            default:
                em=null;
                System.out.println("no existe cargo");
        }
        
        return em;

    }
    
    /**
     * listar todos los empleados por un area determinada por el parámetro
     * @return Empleados que pertenecen a esa área
     */
    public Vector<Empleado[]> listEmpleadoPorArea(){
        Area[] ars = daoAr.listArea();
        int numAreas = ars.length ;
        Vector<Empleado[]> todosEms = new Vector<Empleado[]>();
        for(int i=0; i<numAreas; i++){
            Empleado[] em = daoEm.listEmpleadoPorArea(ars[i].getCodigoArea());
            todosEms.addElement(em);
        }
        return todosEms;
    }
 
     
    /** metodo que llama al Dao para listar los empleados que existen
     * @return cantidad de usuarios existentes en la base de datos
     */
    public Empleado[] listEmpleado ()  
    {
        Empleado[] em = daoEm.listEmpleado();
        return em;
                
    }
    

    public int updateEmpleado(String id, String nombres, String apellidos, String telefono, String direccion, int sal, String email ,String cargo, String contrasena , String jefe, Area area, boolean estado) {
        
        Empleado em = new Empleado(id, nombres, apellidos, telefono, direccion, sal, email, cargo,  contrasena, jefe, area, estado);
        
        int result = daoEm.updateEmpleado(em, id);

        return result;
    }

    public int  deleteEmpleado(String id) {
        return daoEm.deleteEmpleado(id);
    }
    
    
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoEm.closeConectionDB();
    }

}//fin clase


