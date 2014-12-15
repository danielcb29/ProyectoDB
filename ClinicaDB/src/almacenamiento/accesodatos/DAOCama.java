/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import proceso.Cama;

/**
 *
 * @author cenesis
 */
public class DAOCama {
    
    
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
    public DAOCama(Connection conn) {
        db=new BaseDatos();
        this.conn=conn;
    }

    public int crearCama(Cama nuevaCama) {
        String sql_ar;
        int numRows=0;
        
        
        sql_ar="INSERT INTO Cama VALUES ('"+ nuevaCama.getNumeroCama() +"', '"+ nuevaCama.isEstado()+ "', '"+ nuevaCama.getDescripcion() + "',"+ nuevaCama.getArea() + ",  ''true');";
        System.out.println(sql_ar);
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
    }

   /* public Cama leerCama(String identificacion, boolean tipo) {
        Cama camaEdit= new Cama();
        String sql_select;
        sql_select="SELECT * FROM cama WHERE numeroCama= '" +identificacion+"';";        
        
        
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            
            ResultSet table = statement.executeQuery(sql_select);
            
            
            while(table.next()){
                
                camaEdit.setNumeroCama(table.getString(1));
                camaEdit.setEstado(table.getBoolean(2));
                camaEdit.setDescripcion(table.getString(3));
                camaEdit.setArea(table.getInt(4));
                camaEdit.setActiva(table.getBoolean(5));
               
                
                System.out.println("ok"+camaEdit.getArea());
            }
            if(camaEdit.getDescripcion()==null){
                return null;
            }
            if(tipo){
                if(camaEdit.isActiva()){
                    return camaEdit;
                }else{
                    return null;
                }
                
            }else{
                return camaEdit;
            }
        }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("excepcion del dao"); System.out.println(e); }
        return null;
    }

    public int modificarCama(String identificacion, Cama modCama) {
        String sql1,sql2,sql3,sql4;
	sql1 = "UPDATE Cama SET descripcion='"+modCama.getDescripcion()+"' WHERE numeroCama='" + identificacion + "';";
        sql2 = "UPDATE Cama SET estado='"+modCama.isEstado()+"' WHERE numeroCama='" + identificacion + "';";
        sql3 = "UPDATE Cama SET codigoArea="+modCama.getArea()+" WHERE numeroCama='" + identificacion + "';";
        sql4 = "UPDATE Cama SET activa='"+modCama.isActiva()+"' WHERE numeroCama='" + identificacion + "';";

        
        try{
            System.out.println(sql3);
                Statement sentencia = conn.createStatement();

                sentencia.executeUpdate(sql1);
                System.err.println("first");
                sentencia.executeUpdate(sql2);
                sentencia.executeUpdate(sql3);
                sentencia.executeUpdate(sql4);

                return 1;
            }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
            }
        catch(Exception e){ 
            System.out.println(e);
            return -1;
        }    }

    public int eliminarCama(String numeroCama) {
        String sql1;
	sql1 = "UPDATE cama SET activa='false' WHERE numeroCama='" +numeroCama + "';";
        try{
                Statement sentencia = conn.createStatement();

                sentencia.executeUpdate(sql1);

                return 1;
            }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
            }
        catch(Exception e){ 
            System.out.println(e);
            return -1;
        } 
    }

    public Cama[] listCama(Boolean tipo) {

        String sql_select, sql_selectC;
        if(tipo){
            sql_select = "SELECT * FROM cama WHERE activa='true' AND estado='true';";
            sql_selectC = "SELECT COUNT(*) FROM cama WHERE activa='true' AND estado='true';";
        }else{
            sql_select = "SELECT * FROM cama;";
            sql_selectC = "SELECT COUNT(*) FROM cama;";
        }
        
        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_selectC);
            int numRows = 0;
            table.next();
            numRows = table.getInt(1);
            ResultSet table2 = sentence.executeQuery(sql_select);
            System.out.println(numRows);
            Cama listCamas[] = new Cama[numRows];

            int j = 0;
            while (table2.next()) {
                                    

                
                    System.out.println("ok");
                    listCamas[j] = new Cama();
                    listCamas[j].setNumeroCama(table2.getString(1));
                    listCamas[j].setEstado(table2.getBoolean(2));
                    listCamas[j].setDescripcion(table2.getString(3));
                    listCamas[j].setArea(table2.getInt(4));
                    listCamas[j].setActiva(table2.getBoolean(5));
               

                j++;
                
            }

            return listCamas;
        } catch (SQLException e) {
            System.out.println("Un"+e);
        } catch (Exception e) {
            System.out.println("dos"+e);
        }
        return null;
    }

    public int asignarCama(String numeroCama, String cedulaPac, Date fechaAsig) {
        String sql_ar1, sql_ar2;
        int numRows=0;
        
        
        sql_ar1="INSERT INTO camas_paciente VALUES ('"+cedulaPac+"', '"+ numeroCama+ "', '"+fechaAsig.toString()+"');";
        sql_ar2 = "UPDATE Cama SET estado='false' WHERE numeroCama='" + numeroCama + "';";

        System.out.println(sql_ar1);
        try{
            Statement st = conn.createStatement();
            numRows = st.executeUpdate(sql_ar1);
            numRows = st.executeUpdate(sql_ar2);
            
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
    }*/
    
}
