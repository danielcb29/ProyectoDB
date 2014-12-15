/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proceso.Causa;

/**
 *
 * @author daniel
 */
public class DAOCausa {
    private BaseDatos db;
    private Connection conn;
    public DAOCausa(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Metodo que permite crear una causa en la base de datos
     * @param causa : causa a crear
     * @return Valor de insersion correcta , 1 para ok , -1 error , -2 sql error
     */
    public int crearCausa(Causa causa){
        String sql_save;
        int numRows=0;
      
        String nombre = causa.getNombre();
        String descripcion = causa.getDescripcion();

        sql_save="INSERT INTO Causa VALUES ( NEXTVAL('causa_seq')  , '" + nombre +  "', '" + descripcion + "',true);";
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);            
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
    } 
    /**
     * Metodo que permite leer una causa de la base de datos dado el nombre de la misma
     * @param nombre: nombre de la causa a leer
     * @param tipo : en caso verdadero solo se traen las causas activas , en caso falso se traen todas las causas
     * @return causa leida
     */
    public Causa leerCausa(String nombre, boolean tipo){
        Causa causa = new Causa();
        String sql_select;
        if(tipo){
            sql_select="SELECT codigoCausa,nombre,descripcion,estado FROM Causa WHERE  nombre = '"+nombre+"' AND estado=true;";
        }else{
            sql_select="SELECT codigoCausa,nombre,descripcion,estado FROM Causa WHERE  nombre = '"+nombre+"';";
        }
        
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                causa.setCodigoCausa(table.getString(1));
                                
                causa.setNombre(table.getString(2));
                
                causa.setDescripcion(table.getString(3));
                
                causa.setEstado(table.getBoolean(4));
                
            }
           
            return causa;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao causa");System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite actualizar una causa en la base de datos dado su antiguo nombre
     * @param exCausa: nombre de la causa a actualizar
     * @param causa : datos de la nueva causa
     * @return numero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarCausa(String exCausa, Causa causa){
        String sql1,sql2,sql3;
        String nuevoNombre = causa.getNombre();
        String nuevaDescripcion = causa.getDescripcion();
        boolean nuevoEstado =  causa.getEstado();
	sql1="UPDATE Causa SET nombre='"+nuevoNombre+"' WHERE nombre='" + exCausa + "';";
        sql2 = "UPDATE Causa SET descripcion='"+nuevaDescripcion+"' WHERE nombre='" + exCausa + "';";
        sql3 = "UPDATE Causa SET estado='"+nuevoEstado+"' WHERE nombre='" + exCausa + "';";
        
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql1);
            
            
            return 1;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
            
        }
        return -1;
    }
    /**
     * Metodo que permite listar las causas en la base de datos
     * @param tipo: para saber si se listan solo las causas activas o todas las causas
     * @return un arreglo con las causas 
     */
    public Causa[] listCausa(boolean tipo){
        String sql_select,sql_count;
        if(tipo){
            sql_select="SELECT codigoCausa,nombre,descripcion,estado FROM Causa WHERE estado= true;";
            sql_count = "SELECT COUNT(*) FROM Causa WHERE estado=true";
        }else{
            sql_select="SELECT codigoCausa,nombre,descripcion,estado FROM Causa ;";
            sql_count = "SELECT COUNT(*) FROM Causa ";
        }
        
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);
                  
            System.out.println(tamano);
            Causa causas[]= new Causa[tamano];
            for(int i=0; i<tamano; i++){
                causas[i]=new Causa();
            }
            
            int j=0;
            
         
            while(table.next()){
               
                causas[j].setCodigoCausa(table.getString(1));
                
                causas[j].setNombre(table.getString(2));
                
                causas[j].setDescripcion(table.getString(3));
                
                causas[j].setEstado(table.getBoolean(4));               

                j++;
              System.out.println("ok");
            }
           
            return causas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite cambiar el estado de una causa de activa a no activa 
     * @param name 
     * @return numero de confirmacion, 1 ok , -1 error , -2 sql error
     */
    public int eliminarCausa(String name){
        String sql_save;
	sql_save="UPDATE Causa SET estado=false WHERE nombre='" + name + "'";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql_save);            
            return 1;
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    //TEMPORAL PARA PRUEBAS
    public void connectDB(){
        conn = db.getConnetion();
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
    
}
