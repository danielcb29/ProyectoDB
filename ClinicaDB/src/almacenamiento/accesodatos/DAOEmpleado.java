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
public class DAOEmpleado {
     /**
     * @param db objeto encargado de la conexión a la base de datos.
     * @param conn objeto para ejecutar las sentencias de SQL
     * 
     */
    private  BaseDatos db;
    Connection conn ;
    /**
     * constructor, inicializa los atributos.
     */
    public DAOEmpleado(){
        db=new BaseDatos();
        
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
        * crear o agregar un usuario a la tabla.
        * @param em el objeto Empleado a agregar.
        * @return devuelve el número de tuplas que se agregaron a la tabla.
        */
    public int createEmpleado(Empleado em){
        String sql_em,sql_per;
        int numRows=0;
        String cargo=em.getCargo();
        String jefe =em.getJefe();
        if(cargo.equals("Administrador")){
            if(jefe.equals("-1")){
                sql_em="INSERT INTO empleado (identificacion, salario, email, cargo, contrasena, jefe, codigoArea, estado) VALUES ('"+ em.getIdentificacion() + "', " + em.getSalario() + ", '" + em.getEmail() + "', '"  + cargo+  "', '" + em.getContrasena()+"', NULL, NULL,"+ em.getEstado() +")";                
            }else{
                sql_em="INSERT INTO empleado (identificacion, salario, email, cargo, contrasena, jefe, codigoArea, estado) VALUES ('"+ em.getIdentificacion() + "', " + em.getSalario() + ", '" + em.getEmail() + "', '"  + cargo+  "', '" + em.getContrasena()+"', '" + jefe + "', NULL"+ em.getEstado() +")";
            }
        }else{
            if(jefe.equals("-1")){
                sql_em="INSERT INTO empleado (identificacion, salario, email, cargo, contrasena, jefe, codigoArea) VALUES ('"+ em.getIdentificacion() + "', " + em.getSalario() + ", '" + em.getEmail() + "', '"  + cargo+ "', '" + em.getContrasena()+  "', NULL, "+ em.getArea().getCodigoArea() + ","+ em.getEstado() +")";
            }else{
                sql_em="INSERT INTO empleado (identificacion, salario, email, cargo, contrasena, jefe, codigoArea) VALUES ('"+ em.getIdentificacion() + "', " + em.getSalario() + ", '" + em.getEmail() + "', '"  + cargo+ "', '" + em.getContrasena() +"', '" + jefe + "', "+ em.getArea().getCodigoArea()+","+ em.getEstado()+  ")";
            }
        }
        
        sql_per="INSERT INTO persona (identificacion, nombres, apellidos, telefono, direccion) VALUES ('"+ em.getIdentificacion() +"', '"+ em.getNombres()+ "', '"+ em.getApellidos() +"', '"+ em.getTelefono()+ "', '"+ em.getDireccion() +")";
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(sql_per);
            numRows = st.executeUpdate(sql_em);
            
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
        * consultar el empleado que tiene como correo o identificacion el parametro.
        * @param req el correo o identificacion del empleado que se quiere consultar.
        * @param tipoCon 1 si es correo electronico, 2 si es identificacion
        * @return null si hay error en la consulta a la base de datos. Objeto tipo Empleado si el objeto del usuario que se consulto. 
        */
    public Empleado readEmpleado(String req, int tipoCon){
        Empleado em= new Empleado();
        String sql_select;
        if(tipoCon==1){
            //System.out.println("entramos al caso de username");
            sql_select="SELECT persona.identificacion, persona.nombres, persona.apellidos, persona.telefono, persona.direccion, empleado.salario, empleado.email ,  empleado.cargo , empleado.contrasena, empleado.jefe, empleado.codigoArea, empleado.estado FROM  persona, empleado WHERE empleado.identificacion=persona.identificacion AND empleado.email='" + req +  "'";        
        }else{
            sql_select="SELECT persona.identificacion, persona.nombres, persona.apellidos, persona.telefono, persona.direccion, empleado.salario, empleado.email ,  empleado.cargo , empleado.contrasena, empleado.jefe, empleado.codigoArea, empleado.estado FROM  persona, empleado WHERE empleado.identificacion=persona.identificacion AND empleado.identificacion='" + req +  "'";
        }
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            //System.out.println("antes de la ejecucion");
            ResultSet table = statement.executeQuery(sql_select);
            //System.out.println("despues de la ejecucion");
            
            while(table.next()){
                //System.out.println("dentro del while");
                em.setIdentificacion(table.getString(1));
               
                em.setNombres(table.getString(2));
                
                em.setApellidos(table.getString(3));
                
                em.setTelefono(table.getString(4));               

                em.setDireccion(table.getString(5));

                em.setSalario(table.getInt(6));
                
                em.setEmail(table.getString(7));
                
                em.setCargo(table.getString(8));
                
                em.setContrasena(table.getString(9));
                
                String jefe = table.getString(10);
                
                System.out.println("jefe "+jefe);
                
                if(jefe==null){
                    em.setJefe("-1");
                }else{
                    em.setJefe(jefe);
                }
                
                String area = table.getString(11);
                
                System.out.println(area);
                if(area==null){
                    em.setArea(null);
                }else{
                    DAOArea daoa= new DAOArea(conn);
                    Area ar = daoa.readArea(Integer.parseInt(area));
                    em.setArea(ar);
                }
                
                em.setEstado(table.getBoolean(12));
                
                System.out.println("ok");
            }
            return em;
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
/**    public int updateUser(Usuario us, String cedula){
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
    public Usuario[] listEmpleado(){
        
        String sql_select;
        sql_select="SELECT persona.identificacion, persona.nombres, persona.apellidos, persona.telefono, persona.direccion, empleado.salario, empleado.email ,  empleado.cargo , empleado.contrasena, empleado.jefe, empleado.codigoArea, empleado.estado FROM  persona, empleado WHERE empleado.identificacion=persona.identificacion ";
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            ResultSet table = statement.executeQuery(sql_select);
            ResultSet table2= table;
            int numRows=0;
            while(table.next()){
                numRows++;
            }
            System.out.println(numRows);
            Usuario us[]= new Usuario[numRows];
            for(int i=0; i<numRows; i++){
                us[i]=new Usuario();
            }
            String sql_conv="";
            int j=0;
            while(table2.next()){
                
                us[j].setCedula(table2.getString(1));
               
                us[j].setName(table.getString(2));
                
                us[j].setLastName(table.getString(3));
                
                us[j].setUserName(table.getString(4));               

                us[j].setPassword(table.getString(5));

                us[j].setMail(table.getString(6));
 
                us[j].setProfile(table.getString(7));
                
                us[j].setState(table.getBoolean(8));
                
                if(!us[j].getProfile().equals("Administrador")){
                    sql_conv= "SELECT convocatoria.nombre FROM convoUsuario, convocatoria WHERE cedula='"+us[j].getCedula() +"' AND estado=true AND convoUsuario.codigo=convocatoria.codigo";
                    ResultSet table3= statement.executeQuery(sql_conv);
                    String nom="";
                    while(table3.next()){
                
                        nom = table3.getString(1);
              
                        //System.out.println("ok");
                    }
                    DAOConvocatoria daoc=new DAOConvocatoria(conn);
                    Convocatoria conv = daoc.readConv(nom);
                    us[j].setConvocatoria(conv);
                }


                j++;
                System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
   /**
    * borrar un usuario de la tabla.
    * @param cedula la cedula del usuario que se quiere borrar.
    */
 /**   public int deleteUser(String cedula){	
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
