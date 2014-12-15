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
public class DAOEnfermera {
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
    public DAOEnfermera(Connection conn){
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
    public int createEnfermera(Enfermera en){
        String sql_en ;
        String sql_hab[];
        int numRows=0;
        int numHabs = en.getMisHabilidades().length;
        sql_hab= new String[numHabs];
        for(int i=0; i<numHabs ; i++){
            sql_hab[i]= "INSERT INTO habilidades_enfermera (identificacion, habilidad) VALUES ('"+en.getIdentificacion() + "', '"+ en.getMisHabilidades()[i] +"')";
        }
        sql_en="INSERT INTO enfermera (identificacion, anosexp) VALUES ('"+ en.getIdentificacion() +"', "+ en.getAnosExp()  +")";
        try{

            Statement st = conn.createStatement();
            numRows = st.executeUpdate(sql_en);
            for(int i=0; i<numHabs ; i++){
                st.executeUpdate(sql_hab[i]);
            }
            
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            
            System.out.println("createEnfermera"+e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println("createEnfermera "+e);
        }
        return -1;
    }//fin saveUser
    
        /**
        * consultar la enfermera de acuerdo al objeto Empleado
        * @param em objeto Empleado con la informacion del medico a consultar
        * @return null si hay error en la consulta a la base de datos. Objeto tipo Medico si el objeto del usuario que se consulto. 
        */
    public Enfermera readEnfermera(Empleado em){
        Enfermera enf= new Enfermera();
        String sql_select="SELECT enfermera.identificacion, enfermera.anosexp FROM  enfermera WHERE enfermera.identificacion='" + em.getIdentificacion()+ "'";
        String sql_hab= "SELECT habilidades_enfermera.identificacion, habilidades_enfermera.habilidad FROM  habilidades_enfermera WHERE habilidades_enfermera.identificacion='" + em.getIdentificacion()+ "'";
        
        try{
            
            
            System.out.println("consultando en la bd");
            
            Statement statement = conn.createStatement();
            
            ResultSet table = statement.executeQuery(sql_select);
            
            while(table.next()){
                enf.setNombres(em.getNombres());
                
                enf.setApellidos(em.getApellidos());
                
                enf.setTelefono(em.getTelefono());
                
                enf.setDireccion(em.getDireccion());
                
                enf.setSalario(em.getSalario());
                
                enf.setEmail(em.getEmail());
                
                enf.setCargo(em.getCargo());
                
                enf.setContrasena(em.getContrasena());
                
                enf.setJefe(em.getJefe());
                
                enf.setArea(em.getArea());
                
                enf.setEstado(em.getEstado());
                
                enf.setIdentificacion(table.getString(1));
                
                enf.setAnosExp(table.getInt(2));
            
                
                System.out.println("ok");
            }
            
            ResultSet table2 = statement.executeQuery(sql_hab);
        
            String habs [];
            int numHabs=0;
            while(table2.next()){
                numHabs++;
            }
                
            ResultSet table3 = statement.executeQuery(sql_hab);
            habs = new String [numHabs];
            int i=0;
            while(table3.next()){
                habs[i] = table3.getString(2);
                i++;
            }
                
            enf.setMisHabilidades(habs);
            
            
            return enf;
            
        }
        catch(SQLException e){ System.out.println("readEnf "+e); }
        catch(Exception e){ System.out.println("excepcion del dao"); System.out.println(e); }
        return null;
    }//fin readUser

   
    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param en objeto de Enfermera con los atributos a modificar en la base de datos.
     * @param identificacion la cedula del usuario que se quiere actualizar.
     * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
     */
    public int updateEnfermera(Enfermera en, String identificacion){
        String sql_save1;
	sql_save1="UPDATE enfermera SET anosExp="+en.getAnosExp()+" WHERE identificacion='" + en.getIdentificacion()+ "'";
        String sql_deHabs=  "DELETE FROM habilidades_enfermera WHERE identificacion='"+ en.getIdentificacion() +"'";
        try{
            Statement statement = conn.createStatement();

            int rowCount = statement.executeUpdate(sql_save1);
            
            statement.executeUpdate(sql_deHabs);
            
            String [] habs = en.getMisHabilidades();
            String [] sql_hab = new String[habs.length];
            for(int i=0; i<habs.length;i++){
                sql_hab[i]= "INSERT INTO habilidades_enfermera (identificacion, habilidad) VALUES ('"+en.getIdentificacion() + "', '"+ habs[i] +"')";
            }
            
            
            System.out.println("ok");
            return rowCount;
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
            return -1;
        }
    }//fin updateUser

   
   
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }


}
