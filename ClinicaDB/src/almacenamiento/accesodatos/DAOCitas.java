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
import java.sql.Time;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import proceso.HistoriaClinica;
import proceso.Medico;


/**
 *
 * @author alvaromartinez
 */
public class DAOCitas {
    
    private BaseDatos db;
    private Connection conn;
    ArrayList<ArrayList <String>> citasUsuario;
    ArrayList<ArrayList <String>> citasSistema;
    String[] horasCitas;
    //private Connection conn ;
    
    
    public DAOCitas(Connection conect){
        db = new BaseDatos();
        conn = conect;
        Integer numMed;
        numMed = 700;
        String hora;
        horasCitas = new String[30];
        for(int i = 0; i<30; i++){
            numMed = 700+i*20;
            hora = numMed.toString();
            horasCitas[i]= "0"+hora.charAt(0)+":"+hora.substring(1);
            System.out.println(horasCitas[i]);
        }
        
        
        
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear un cita en la base de datos
     * @param cita a ser almacenada
     * @return -1 en caso de error , -2 si hay error con la persona a la que se le asigna la cita y el numero de filas en caso contrario
     */
    
    public int crearCita(String nuevaCita){
        String sql_Cita;
        int numRows=0;
        
        
        //Insercion a la tabla cita
        sql_Cita = "INSERT INTO Cita VALUES ("+nuevaCita+");";
        System.out.println(sql_Cita);
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_Cita); 
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
     * Metodo que permite listar los pacientes de la clinica
     * @param fecha de las citas a consultar
     * @return: Arreglo con los pacientes en la base de datos, null en caso de error
     */
    public ArrayList<ArrayList<String>> listCita(String fecha){
        
        DAOMedico daoMed= new DAOMedico(conn);
        Medico[] medicosCitas = daoMed.listMedicos();        
        
        citasUsuario = new ArrayList<>();
        citasSistema = new ArrayList<>();
        ArrayList <String> medicoCitasS = new ArrayList<>();
        ArrayList <String> medicoCitasU = new ArrayList<>();
        for(int i = 0; i<medicosCitas.length; i++){
            for(int j= 0; j<30; j++){
                medicoCitasU.add(fecha+" "+horasCitas[i]+" "+medicosCitas[i].getNombres()+" "+medicosCitas[i].getApellidos());
                medicoCitasS.add("'"+fecha+"'"+horasCitas[i]+"'"+medicosCitas[i].getIdentificacion());
            }
            citasUsuario.add(medicoCitasU);
            citasSistema.add(medicoCitasS);
        }
        String sql_select, sql_selectC;
        sql_select="SELECT * FROM Citas WHERE fecha='"+fecha+"';";
        sql_selectC="SELECT COUNT(*) FROM Citas WHERE fecha='"+fecha+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_selectC);
            int numRows=0;
            table.next();
            numRows = table.getInt(1);
            ResultSet table2 = sentence.executeQuery(sql_select);
            String cita;
            cita = "";
            
            int j=0;
            while(table2.next())
            {
               
                cita += "'"+table2.getString(1);
                cita += "'"+table2.getString(2);
                cita += "'"+table2.getString(3);
                
                filtraCitas(cita);
                
                
              j++;
              System.out.println("ok");
            }
           
            return citasUsuario;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    private void filtraCitas(String comparacion){       
        int index;
        for(int i= 0; i<citasUsuario.size(); i++){
            index = citasUsuario.get(i).indexOf(comparacion);
            citasUsuario.get(i).remove(index);
            citasUsuario.get(i).remove(index);
        }
        
    }
    
     public int eliminarCita(String primKey) {
        String sql1;
	sql1 = "DELETE FROM Paciente WHERE ="+primKey+";";
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
    
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
    
    
/***************************************************METODOS DE PRUEBA**********************************/
    

}
