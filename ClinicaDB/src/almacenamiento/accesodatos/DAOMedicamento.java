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
import proceso.Medicamento;

/**
 *
 * @author daniel
 */
public class DAOMedicamento {
    private BaseDatos db;
    private Connection conn;
    public DAOMedicamento(Connection conn){
        db = new BaseDatos();
        this.conn=conn;
    }
    /**
     * Metodo que permite almacenar un medicamento en la base de datos
     * @param nuevo medicamento a almacenar
     * @return numero de confirmacion , 1ok , -1 error , -2 sql error
     */
    public int crearMedicamento(Medicamento nuevo) {
        String sql_save;
        int numRows=0;
      
        String codigo = nuevo.getCodigoMedicamento();
        String nombre = nuevo.getNombre();
        String descripcion = nuevo.getDescripcion();
        double costo = nuevo.getCosto();
        

        sql_save="INSERT INTO Medicamentos VALUES ( '"+codigo+"'  , '" + nombre +  "', " + costo + ",'"+descripcion+"',true);";
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
     * Permite leer un medicamento de la base de datos , el tipo es si se quiere traer sin importar que este inactivo o solo si esta activo
     * @param codigo codigo del medicamento a leer
     * @param tipo si se quiere acotar a los activos (true) o traer todos (false)
     * @return medicamento almacenado en la base de datos
     */
    public Medicamento leerMedicamento(String codigo, boolean tipo){
        Medicamento medicamento = new Medicamento();
        String sql_select;
        if(tipo){
            sql_select="SELECT codigomedicamento,nombre,costo,descripcion,estado FROM Medicamentos WHERE  codigomedicamento = '"+codigo+"' AND estado=true;";
        }else{
            sql_select="SELECT codigomedicamento,nombre,costo,descripcion,estado FROM Medicamentos WHERE  codigomedicamento = '"+codigo+"';";
        }
        
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                medicamento.setCodigoMedicamento(table.getString(1));
                                
                medicamento.setNombre(table.getString(2));
                
                //String costoArray[] = table.getString(3).split(",");
                //double costo = Double.parseDouble(costoArray[0]);
                medicamento.setCosto(table.getDouble(3));
                
                medicamento.setDescripcion(table.getString(4));
                
                medicamento.setEstado(table.getBoolean(5));
                
            }
           
            return medicamento;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao causa");System.out.println(e); }
        return null;
    }
    /**
     * Permite actualizar la informacion de un medicamento en la base de datos 
     * @param exMed: codigo del medicamento a actualizar
     * @param medicamento: datos actualizados del medicamento
     * @return nuemero de confirmacion , 1 ok , -1 error , -2 sql error
     */
    public int actualizarMedicamento(String exMed, Medicamento medicamento){
        String sql1,sql2,sql3,sql4,sql5;
        String nuevoCodigo = medicamento.getCodigoMedicamento();
        String nuevoNombre = medicamento.getNombre();
        double nuevoCosto = medicamento.getCosto();
        String nuevaDescripcion = medicamento.getDescripcion();
        boolean nuevoEstado =  medicamento.getEstado();
	sql1="UPDATE Medicamentos SET nombre='"+nuevoNombre+"' WHERE codigomedicamento='" + exMed + "';";
        sql2 = "UPDATE Medicamentos SET descripcion='"+nuevaDescripcion+"' WHERE codigomedicamento='" + exMed + "';";
        sql3 = "UPDATE Medicamentos SET estado='"+nuevoEstado+"' WHERE codigomedicamento='" + exMed + "';";
        sql4 = "UPDATE Medicamentos SET costo="+nuevoCosto+" WHERE codigomedicamento='" + exMed + "';";
        sql5 = "UPDATE Medicamentos SET codigomedicamento='"+nuevoCodigo+"' WHERE codigomedicamento='" + exMed + "';";
        
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            sentencia.executeUpdate(sql5);
            
            
            
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
     * Permite listar los medicamentos de la base de datos discriminando los inactivos o teniendolos en cuenta a todos de acuerdo al tipo
     * @param tipo : discriminante para inactivos (true) o traerlos todos (false)
     * @return Arreglo de medicamentos almacenados en la base de datos
     */
    public Medicamento[] listMedicamentos(boolean tipo){
        String sql_select,sql_count;
        if(tipo){
            sql_select="SELECT codigomedicamento,nombre,costo,descripcion,estado FROM Medicamentos WHERE estado=true;";
            sql_count = "SELECT COUNT(*) FROM Medicamentos WHERE estado=true";
        }else{
            sql_select="SELECT codigomedicamento,nombre,costo,descripcion,estado FROM Medicamentos ;";
            sql_count = "SELECT COUNT(*) FROM Medicamentos ";
        }
        
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);
                  
            System.out.println(tamano);
            Medicamento medicamentos[]= new Medicamento[tamano];
            for(int i=0; i<tamano; i++){
                medicamentos[i]=new Medicamento();
            }
            
            int j=0;
            
         
            while(table.next()){
               
                medicamentos[j].setCodigoMedicamento(table.getString(1));
                
                medicamentos[j].setNombre(table.getString(2));
                
                //String costoArray[] = table.getString(3).split(",");
                //String costoString = costoArray[0].substring(1);
                //System.out.println("Costo sin formato:"+costoString);
                //double costo = Double.parseDouble(costoString);
                medicamentos[j].setCosto(table.getDouble(3));
                
                medicamentos[j].setDescripcion(table.getString(4));
                
                medicamentos[j].setEstado(table.getBoolean(5));
                System.out.println("estado en dao:"+medicamentos[j].getEstado());

                j++;
              System.out.println("ok");
            }
           
            return medicamentos;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    /**
     * Permite hacer el borrado logico de un medicamento en la base de datos
     * @param codigo : codigo del medicamento
     * @return numero de verificacion, 1ok , -1 error, -2 sql error
     */
    public int eliminarMedicamento(String codigo){
        String sql_save;
	sql_save="UPDATE Medicamentos SET estado=false WHERE codigomedicamento='" + codigo + "'";
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
