/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;
import proceso.*;

import java.sql.*;

/**
 *
 * @author family
 */
public class DAOMedico {
     /**
     * @param db objeto encargado de la conexión a la base de datos.
     * @param conn objeto para ejecutar las sentencias de SQL
     * 
     */
    private  BaseDatos db;
    Connection conn ;
    DAOEmpleado daoEm;
    
    /**
     * constructor, inicializa los atributos.
     * @param conn conexion base de datos
     */
    public DAOMedico(Connection conn){
        db=new BaseDatos();
        this.conn=conn;
        daoEm=new DAOEmpleado();
        
    }//fin constructor
    /**
     * Metodo que permite realizar la conexion a la base de datos
     */
    public void connectDB(){
        conn = db.getConnetion();
    }
    public Connection getConn(){
        return conn;
    }
    /**
    * crear o agregar un medico a la tabla.
    * @param me el objeto Medico a agregar.
    * @return devuelve el número de tuplas que se agregaron a la tabla.
    */
    public int createMedico(Medico me){
        String sql_me;
        int numRows=0;
        
        sql_me="INSERT INTO medico (identificacion, numeroLicencia, especialidad, universidad) VALUES ('"+ me.getIdentificacion() +"', "+ me.getNumeroLicencia()+ ", '"+ me.getEspecialidad() + "', '"+ me.getUniversidad() + "')";
        try{

            Statement st = conn.createStatement();
            numRows = st.executeUpdate(sql_me);
            
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
    }//fin saveUser
    
        /**
        * consultar el medico que tiene identificacion el parametro.
        * @param em objeto Empleado con la informacion del medico a consultar
        * @return null si hay error en la consulta a la base de datos. Objeto tipo Medico si el objeto del usuario que se consulto. 
        */
    public Medico readMedico(Empleado em){
        Medico me= new Medico();
        String sql_select="SELECT medico.identificacion, medico.numeroLicencia, medico.especialidad, medico.universidad FROM  medico WHERE medico.identificacion='" + em.getIdentificacion()+ "'";
        
        
        try{
            
            
            System.out.println("consultando en la bd");
            
            Statement statement = conn.createStatement();
            
            ResultSet table = statement.executeQuery(sql_select);
            
            
            while(table.next()){
                
                me.setNombres(em.getNombres());
                
                me.setApellidos(em.getApellidos());
                
                me.setTelefono(em.getTelefono());
                
                me.setDireccion(em.getDireccion());
                
                me.setSalario(em.getSalario());
                
                me.setEmail(em.getEmail());
                
                me.setCargo(em.getCargo());
                
                me.setContrasena(em.getContrasena());
                
                me.setJefe(em.getJefe());
                
                me.setArea(em.getArea());
                
                me.setEstado(em.getEstado());
                
                me.setIdentificacion(table.getString(1));
                
                me.setNumeroLicencia(table.getInt(2));
                
                me.setEspecialidad(table.getString(3));
                
                me.setUniversidad(table.getString(4));
               
                System.out.println("ok");
            }
            return me;
        }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("excepcion del dao"); System.out.println(e); }
        return null;
    }//fin readUser

   
    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param us objeto de Usuario con los atributos a modificar en la base de datos.
     * @param cedula la cedula del usuario que se quiere actualizar.
     * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
     */
  /**  public int updateUser(Usuario us, String cedula){
        String sql_save1,  sql_save2,  sql_save3, sql_save4,  sql_save5,  sql_save6,  sql_save7;
	sql_save1="UPDATE usuario SET name='"+us.getName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save2="UPDATE usuario SET lastname='"+us.getLastName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save3="UPDATE usuario SET userName='"+us.getUserName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save4="UPDATE usuario SET contrasena='"+us.getPassword()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save5="UPDATE usuario SET email='"+us.getMail()+"' WHERE cedula='" + us.getCedula() + "'";
        
        sql_save7=null;
        switch(us.getProfile()){
            case "Digitador":   sql_save6="UPDATE usuario SET id_perfil='1' WHERE cedula='" + us.getCedula() + "'";
                                break;
            case "Coordinador": sql_save6="UPDATE usuario SET id_perfil='2' WHERE cedula='" + us.getCedula() + "'";
                                break;
            case "Administrador":   sql_save6="UPDATE usuario SET id_perfil='3' WHERE cedula='" + us.getCedula() + "'";
                                    sql_save7="UPDATE convousuario SET estado=false WHERE cedula='" + us.getCedula() + "' AND estado=true";
                                    break;
            default: return -3;
                       
        }
        
        
        

        try{
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql_save1);
            statement.executeUpdate(sql_save2);
            statement.executeUpdate(sql_save3);
            statement.executeUpdate(sql_save4);
            statement.executeUpdate(sql_save5);
            statement.executeUpdate(sql_save6);
            if(sql_save7!=null) statement.executeUpdate(sql_save7);
            
            if(!us.getProfile().equals("Administrador")){
                String sql_save= "SELECT codigo FROM convoUsuario WHERE cedula='"+us.getCedula()+"' AND estado=true";
                ResultSet table= statement.executeQuery(sql_save);
                String cod="";
                while(table.next()){
                    cod = table.getString(1);
                }
                String usCod=Integer.toString(us.getConvocatoria().getCode());
                if(!usCod.equals(cod)){
                    sql_save="UPDATE convoUsuario SET estado=false WHERE codigo= "+cod+" AND cedula = '"+us.getCedula()+"'";
                    statement.executeUpdate(sql_save);
                    sql_save= "SELECT codigo FROM convoUsuario WHERE cedula='"+us.getCedula()+"'";
                    table= statement.executeQuery(sql_save);
                    boolean flag=false;
                    while(table.next()){
                        cod = table.getString(1);
                        if(usCod.equals(cod)){
                            sql_save="UPDATE convoUsuario SET estado=true WHERE codigo= "+usCod+" AND cedula = '"+us.getCedula()+"'";
                            statement.executeUpdate(sql_save);
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        sql_save = "INSERT INTO convoUsuario VALUES('"+us.getCedula() +"', "+ usCod +", true )";
                        statement.executeUpdate(sql_save);
                    }
                }
            }
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
            return -1;
        }
        return 1;
    }//fin updateUser

   /**
     * listar todas las tuplas de los usuarios existentes.
     * @return los objetos tipo Medico enlistados en un arreglo.
     */ 
    public Medico[] listMedico(){
        
        String sql_select="SELECT persona.identificacion, persona.nombres, persona.apellidos, persona.telefono, persona.direccion, empleado.salario, empleado.email ,  empleado.cargo , empleado.contrasena, empleado.jefe, empleado.codigoArea, empleado.estado, medico.numeroLicencia, medico.especialidad, medico.universidad FROM  persona, empleado, medico WHERE empleado.identificacion=persona.identificacion AND medico.identificacion=persona.identificacion";
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            ResultSet table = statement.executeQuery(sql_select);
            
            int numRows=0;
            while(table.next()){
                numRows++;
            }
            System.out.println(numRows);
            Medico me[]= new Medico[numRows];
            for(int i=0; i<numRows; i++){
                me[i]=new Medico();
            }
            ResultSet table2= statement.executeQuery(sql_select);
            int j=0;
            
            while(table2.next()){
                
                me[j].setIdentificacion(table2.getString(1));
                
                me[j].setNombres(table2.getString(2));
                
                me[j].setApellidos(table2.getString(3));
                
                me[j].setTelefono(table2.getString(4));
                
                me[j].setDireccion(table2.getString(5));
                
                me[j].setSalario(table2.getInt(6));
                
                me[j].setEmail(table2.getString(7));
                
                me[j].setCargo(table2.getString(8));
                
                me[j].setContrasena(table2.getString(9));
                
                String jefe = table2.getString(10);
                
                System.out.println("jefe "+jefe);
                
                if(jefe==null){
                    me[j].setJefe("-1");
                }else{
                    me[j].setJefe(jefe);
                }
                
                String area = table2.getString(11);
                
                System.out.println(area);
                if(area==null){
                    me[j].setArea(null);
                }else{
                    DAOArea daoa= new DAOArea(conn);
                    Area ar = daoa.readArea(Integer.parseInt(area));
                    me[j].setArea(ar);
                }
                
                me[j].setEstado(table2.getBoolean(12));
                
                
                
                me[j].setNumeroLicencia(table2.getInt(13));
                
                me[j].setEspecialidad(table2.getString(14));
                
                me[j].setUniversidad(table2.getString(15));
               
                System.out.println("ok");
                
            }
           
            return me;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
   /**
    * borrar un usuario de la tabla.
    * @param cedula la cedula del usuario que se quiere borrar.
    */
/**    public int deleteUser(String cedula){	
        String sql_save;

        sql_save="UPDATE usuario SET estado=false WHERE cedula='" + cedula + "'";
        
        try{
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql_save);            
            return 1;
        }
        catch(SQLException e){
            System.out.println(e);
            return -1;
        }
        catch(Exception e){ 
            System.out.println(e);
            
        }
        return -2;
        
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }


}
