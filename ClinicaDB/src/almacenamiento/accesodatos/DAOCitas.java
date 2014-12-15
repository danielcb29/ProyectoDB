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

   
   
    /**
     * Constructor del DAOCItas, que inicializa atributos
     * @param conect 
     */
    public DAOCitas(Connection conect){
        db = new BaseDatos();
        conn = conect;
        Integer numMed;
        int hora;
        int min; 
        hora = 7;
        min = 0;
        horasCitas = new String[29];
        String horaArr;
        for(int i = 0; i<29; i++){
            min+= 20;
            if(min==60){
               hora ++;
               min = 0;
            }
            if(hora<10){
                horaArr ="0"+hora+":";
            }else{
                horaArr =""+hora+":";
            }
            if(min==0){
                horaArr = horaArr+min+"0";
            }else{
                horaArr = horaArr+min;
            }
            
            horasCitas[i]= horaArr ;
        }
        
        
        
        //conn = db.getConnetion();
    }
    
    /**
     * Devuleve las citas disponibles de forma sql
     * @return citasSistema arreglo ArrayList con las citas ordenadas por doctor 
     */
     public ArrayList<ArrayList<String>> getCitasSistema() {
        return citasSistema;
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
     * Metodo que permite listar las citas disponibles del sistema
     * @param fecha de las citas a consultar
     * @return: ArrayList con las citas disponibles, null en caso de error
     */
    public ArrayList<ArrayList<String>> listCita(String fecha){
        
        DAOMedico daoMed= new DAOMedico(conn);
        Medico[] medicosCitas =  daoMed.listMedico();
       
        
        citasUsuario = new ArrayList<>();
        citasSistema = new ArrayList<>();
       
        System.out.println("total med"+medicosCitas.length);
        
        
        for(int i = 0; i<medicosCitas.length; i++){
            ArrayList <String> medicoCitasS = new ArrayList<>();
            ArrayList <String> medicoCitasU = new ArrayList<>();
            for(int j= 0; j<horasCitas.length; j++){
                medicoCitasU.add(fecha+" "+horasCitas[j]+" "+medicosCitas[i].getNombres()+" "+medicosCitas[i].getApellidos());
                medicoCitasS.add("'"+fecha+"', '"+horasCitas[j]+"', '"+medicosCitas[i].getIdentificacion()+"',");
            }
            citasUsuario.add(medicoCitasU);
            citasSistema.add(medicoCitasS);

        }
        String sql_select, sql_selectC;
        sql_select="SELECT * FROM Cita WHERE fecha='"+fecha+"';";
        sql_selectC="SELECT COUNT(*) FROM Cita WHERE fecha='"+fecha+"';";
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
                cita += "', '"+table2.getString(2).substring(0, 5);
                cita += "', '"+table2.getString(3)+"',";
                System.out.println(cita);
                filtraCitas(cita);
     
              System.out.println("ok");
            }
           
            return citasUsuario;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    /**
     * Metodo que permite listar las citas de un usuario 
     * @param documento del usuario a listar
     * @return Arreglo con las citas del usuario 
     */
    public String[] listCitasU(String documento){
        String[] citasUsuario;
        String sql_select, sql_selectC;
        sql_select="SELECT * FROM Cita WHERE idpaciente='"+documento+"';";
        sql_selectC="SELECT COUNT(*) FROM Cita WHERE idpaciente='"+documento+"';";
         try{
            
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_selectC);
            int numRows=0;
            table.next();
            numRows = table.getInt(1);
            citasUsuario = new String [numRows];
            ResultSet table2 = sentence.executeQuery(sql_select);
            int j=0;
            while(table2.next())
            {
               
                citasUsuario[j] = "'"+table2.getString(1);
                citasUsuario[j] += "', '"+table2.getString(2).substring(0, 5);
                citasUsuario[j] += "', '"+table2.getString(3)+"'";
                
            }
           
            return citasUsuario;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    private void filtraCitas(String comparacion){       
        for(int i= 0; i<citasUsuario.size(); i++){
            for(int j=0; j<citasUsuario.get(i).size(); j++){
               System.out.println(citasSistema.get(i).get(j)+"Comp exit"+comparacion);

                if(citasSistema.get(i).get(j).equalsIgnoreCase(comparacion)){
                    citasSistema.get(i).remove(j);
                    citasUsuario.get(i).remove(j);
                }
            }
            
        }
        
    }
    
     public int eliminarCita(String primKey) {
        String sql1;
        String [] values = primKey.split(",");
	sql1 = "DELETE FROM cita WHERE fecha="+values[0]+" AND hora ="+values[1]+" AND idMedico="+values[2]+";";
                System.out.println(sql1);

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
