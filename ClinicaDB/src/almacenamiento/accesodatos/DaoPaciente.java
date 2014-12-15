/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;


import proceso.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alvaromartinez
 */
public class DaoPaciente {
    
    private BaseDatos db;
    private Connection conn;
    //private Connection conn ;
    
    
    public DaoPaciente(Connection conect){
        db = new BaseDatos();
        conn = conect; 
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear un paciente en la base de datos
     * @param paciente a ser almacenado
     * @return -1 en caso de error , -2 si el Paciente ya existe y el numero de filas en caso contrario
     */
    
    public int crearPaciente(Paciente nuevoPaciente){
        String sql_Persona;
        String sql_Paciente;
        int numRows=0;
        
        
        //Insercion a la tabla persona
        sql_Persona = "INSERT INTO Persona VALUES ('"+nuevoPaciente.getIdentificacion()+ "','" + nuevoPaciente.getNombres() + "','" + nuevoPaciente.getApellidos() + "','" +
                    nuevoPaciente.getTelefono() + " ','" +  nuevoPaciente.getDireccion()+ "');";
        //Inserccion a la tabla paciente
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNac = formatter.format(nuevoPaciente.getFechaNac());
        sql_Paciente = "INSERT INTO Paciente VALUES ('"+nuevoPaciente.getIdentificacion()+ "','" + nuevoPaciente.getNumeroSocial() + "','" + nuevoPaciente.getActEcon() + "','" +
                    fechaNac+"','"+nuevoPaciente.getEstado()+"');";
        System.out.println(sql_Persona);
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_Persona); 
            numRows = sentencia.executeUpdate(sql_Paciente); 
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
    
    /*
    /**
     * Metodo que permite consultar la informacion de un paciente
     * @param document: identificacion del paciente a consultar 
     * @return: el paciente encontrado , con atributos null si no existe o null en caso de error
     */
    public Paciente leerPaciente(String document){
        Paciente pacienteCon = new Paciente();
        HistoriaClinica historia = new HistoriaClinica();
        
        String sql_selectPersona;
        String sql_selectPaciente;
        sql_selectPersona="SELECT * FROM persona WHERE persona.identificacion= '"+document+"';";
        sql_selectPaciente="SELECT * FROM paciente WHERE paciente.identificacion= '"+document+"';";
        System.out.println("consulta Paciente " + sql_selectPersona+" "+sql_selectPaciente);
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table1 = sentence.executeQuery(sql_selectPersona);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
            while(table1.next()){
                
                pacienteCon.setIdentificacion(table1.getString(1));
                pacienteCon.setNombres(table1.getString(2));
                pacienteCon.setApellidos(table1.getString(3));
                pacienteCon.setTelefono(table1.getString(4));
                pacienteCon.setDireccion(table1.getString(5));       
            }
            ResultSet table2 = sentence.executeQuery(sql_selectPaciente);
            while(table2.next()){
                
                pacienteCon.setNumeroSocial(table2.getString(2));
                pacienteCon.setActEcon(table2.getString(3));
                pacienteCon.setFechaNac(format.parse(table2.getString(4)));
                pacienteCon.setEstado(table2.getBoolean(5));
     
            }
            if(pacienteCon.getNombres()==null){
                return null;
            }else{
                return pacienteCon;
            }
            
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    /**
     * 
     * @param documento identificacion del paciente
     * @param Paciente los nuevos datos personales del Paciente.
     */
    
    public int modificarPaciente(String documento, Paciente pacienteMod){
        String sql1,sql2,sql3,sql4,sql5,sql6,sql7, sql8;
	sql1 = "UPDATE Persona SET nombres='"+pacienteMod.getNombres()+"' WHERE identificacion='" + documento + "';";
        sql2 = "UPDATE Persona SET apellidos ='"+pacienteMod.getApellidos()+"' WHERE identificacion='" + documento + "';";
        sql3 = "UPDATE Persona SET telefono ='"+pacienteMod.getTelefono()+"'WHERE identificacion='" + documento + "';";
        sql4 = "UPDATE Persona SET direccion ='"+pacienteMod.getDireccion()+"' WHERE identificacion='" + documento + "';";
        sql5 = "UPDATE Paciente SET numerosegsocial ='"+pacienteMod.getNumeroSocial()+"' WHERE identificacion='" + documento + "';";
        sql6 = "UPDATE Paciente SET actecon ='"+pacienteMod.getActEcon()+"' WHERE identificacion='" + documento + "';";
        sql7 = "UPDATE Paciente SET fechaNac ='"+pacienteMod.getFechaNac().toString()+"' WHERE identificacion='" + documento + "';";
        sql8 = "UPDATE Paciente SET estado ='"+pacienteMod.getEstado()+"' WHERE identificacion='" + documento + "';";
      
        
        try{
                Statement sentencia = conn.createStatement();

                sentencia.executeUpdate(sql1);
                System.err.println("first");
                sentencia.executeUpdate(sql2);
                sentencia.executeUpdate(sql3);
                sentencia.executeUpdate(sql4);
                sentencia.executeUpdate(sql5);
                sentencia.executeUpdate(sql6);
                sentencia.executeUpdate(sql7);
                sentencia.executeUpdate(sql8);
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
     * Metodo que permite listar los pacientes de la clinica
     * @return: Arreglo con los pacientes en la base de datos, null en caso de error
     */
    public Paciente[] listPacientes(){
        String sql_select, sql_selectC;
        sql_select="SELECT * FROM Persona NATURAL JOIN paciente;";
        sql_selectC="SELECT COUNT(*) FROM Persona NATURAL JOIN paciente;";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_selectC);
            int numRows=0;
            table.next();
            numRows = table.getInt(1);
            ResultSet table2 = sentence.executeQuery(sql_select);
            System.out.println(numRows);
            Paciente listPacientes[]= new Paciente[numRows];
            for(int i=0; i<numRows; i++){
                listPacientes[i]= new Paciente();
            }
            
            int j=0;
            while(table2.next())
            {
               
                listPacientes[j].setIdentificacion(table2.getString(1));
                listPacientes[j].setNombres(table2.getString(2));
                listPacientes[j].setApellidos(table2.getString(3));
                listPacientes[j].setTelefono(table2.getString(4));
                listPacientes[j].setDireccion(table2.getString(5));
                listPacientes[j].setNumeroSocial(table2.getString(6));
                listPacientes[j].setActEcon(table2.getString(7));
                listPacientes[j].setFechaNac(table2.getDate(8));
                listPacientes[j].setEstado(table2.getBoolean(9));
                
              j++;
              System.out.println("ok");
            }
           
            return listPacientes;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
     public int eliminarPaciente(String identificacion) {
        String sql1;
	sql1 = "UPDATE Persona SET estado='false' WHERE identificacion='" + identificacion + "';";
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
    
    /**
     * Metodo que prueba el crear paciente
     * @throws ParseException 
     */
    public void pruebaCrearPaciente() throws ParseException{
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        fecha = format.parse("2010-05-02");
        Paciente ejemPaciente = new Paciente("4425", "Alvaro", "Martinez", "55524878", "cl 57#32a-24", "44512", "Est", fecha, true );
        fecha = format.parse("2011-05-02");
        Paciente ejemPaciente1 = new Paciente("4427", "Daniel", "Kant", "55524878", "cr 57#32a-24", "44512", "Est", fecha, true );

        System.out.println(crearPaciente(ejemPaciente));
        System.out.println(crearPaciente(ejemPaciente1));
        
    }
    
    
    /**
     * Metodo de prueba de paciente
     */
    public void pruebaLeerPaciente(){
        Paciente nuevoPaciente = leerPaciente("425");
        if(nuevoPaciente == null){
            System.out.println("nulo");
        }else{
            System.out.println(nuevoPaciente.getIdentificacion()+ "','" + nuevoPaciente.getNombres() + "','" + nuevoPaciente.getApellidos() + "','" +
                    nuevoPaciente.getTelefono() + " ','" +  nuevoPaciente.getDireccion()+", "+nuevoPaciente.getIdentificacion()+ "','" + nuevoPaciente.getNumeroSocial() + "','" + nuevoPaciente.getActEcon() + "','" +
                    nuevoPaciente.getFechaNac().toString());
        }
        
    }
    
    /**
     * Prueba de modificar paciente
     */
    public void pruebaModif(){
        Paciente nuevoPaciente = leerPaciente("4425");
        nuevoPaciente.setDireccion("cr 44 #22-65");
        System.out.println(modificarPaciente("4425", nuevoPaciente));
    }
    
    
    /**
     * Prueba listar pacientes
     */
    public void pruebaList(){
       Paciente[] list = listPacientes();       
       System.out.println(list.length);
    }

   
}

    

