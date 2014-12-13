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
public class DAOArea {
     /**
     * @param db objeto encargado de la conexión a la base de datos.
     * @param conn objeto para ejecutar las sentencias de SQL
     * 
     */
    private  BaseDatos db;
    Connection conn ;
    /**
     * constructor, inicializa los atributos.
     * @param conn conexion base de datos
     */
    public DAOArea(Connection conn){
        db=new BaseDatos();
        this.conn=conn;
        
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
        * crear o agregar un area a la tabla.
        * @param ar el objeto Area a agregar.
        * @return devuelve el número de tuplas que se agregaron a la tabla.
        */
    public int createArea(Area ar){
        String sql_ar;
        int numRows=0;
        
        
        sql_ar="INSERT INTO area (codigoArea, nombre, descripcion, estado) VALUES ("+ ar.getCodigoArea() +", '"+ ar.getNombre()+ "', '"+ ar.getDescripcion() + ","+ ar.getEstado() + ")";
        try{
            Statement st = conn.createStatement();
            numRows = st.executeUpdate(sql_ar);
            
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
        * consultar el area que tiene codigo el parametro.
        * @param cod el correo o identificacion del empleado que se quiere consultar.
        * @return null si hay error en la consulta a la base de datos. Objeto tipo Area si el objeto del area que se consulto existe. 
        */
    public Area readArea(int cod){
        Area ar= new Area();
        String sql_select;
        sql_select="SELECT codigoArea, nombre, descripcion, estado FROM  area WHERE codigoArea=" + cod ;        
        
        
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            
            ResultSet table = statement.executeQuery(sql_select);
            
            
            while(table.next()){
                
                ar.setCodigoArea(table.getInt(1));
                
                ar.setNombre(table.getString(2));
                
                ar.setDescripcion(table.getString(3));
                
                ar.setEstado(table.getBoolean(4));
               
                System.out.println("ok");
            }
            return ar;
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
     * @return los objetos tipo Usuario enlistados en un arreglo.
     */ 
    public Area[] listArea(){
        
        String sql_select;
        sql_select="SELECT codigoArea, nombre, descripcion, estado FROM  area ";        
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            ResultSet table = statement.executeQuery(sql_select);
            
            int numRows=0;
            while(table.next()){
                numRows++;
            }
            System.out.println(numRows);
            Area ar[]= new Area[numRows];
            for(int i=0; i<numRows; i++){
                ar[i]=new Area();
            }
            ResultSet table2= statement.executeQuery(sql_select);
            String sql_conv="";
            int j=0;
            while(table2.next()){
                
                ar[j].setCodigoArea(table2.getInt(1));
                
                ar[j].setNombre(table2.getString(2));
                
                ar[j].setDescripcion(table2.getString(3));
                
                ar[j].setEstado(table2.getBoolean(4));
               
                System.out.println("ok");
                j++;
            }
           
            return ar;
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