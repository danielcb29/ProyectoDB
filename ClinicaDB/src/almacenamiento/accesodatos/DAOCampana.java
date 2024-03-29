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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.Campana;
import proceso.Empleado;
import proceso.Medico;

/**
 *
 * @author daniel
 */
public class DAOCampana {

    private BaseDatos db;
    private Connection conn;
    private DAOMedico daoMedico;
    private DAOEmpleado daoEmpleado;

    public DAOCampana(Connection conn) {
        db = new BaseDatos();
        daoMedico=new DAOMedico(conn);
        daoEmpleado=new DAOEmpleado();
        
        this.conn = conn;
    }

    /**
     * Permite listar todas las campañas del sistema sin importar de que doctor
     * son
     *
     * @param tipo si se quieren las activas o todas
     * @return campanas
     */
    public Campana[] listarCampanasCompletas(boolean tipo) {
        String sql_select, sql_count;
        if (tipo) {
            sql_select = "SELECT codigoCampana,nombre,fecha,objetivo,estado,idResponsable FROM Campana WHERE estado= true;";
            sql_count = "SELECT COUNT(*) FROM Campana WHERE estado=true";
        } else {
            sql_select = "SELECT codigoCampana,nombre,fecha,objetivo,estado,idResponsable FROM Campana ;";
            sql_count = "SELECT COUNT(*) FROM Campana ";
        }

        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);

            System.out.println(tamano);
            Campana campanas[] = new Campana[tamano];
            for (int i = 0; i < tamano; i++) {
                campanas[i] = new Campana();
            }

            int j = 0;

            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            daoEmpleado.connectDB();
            while (table.next()) {

                campanas[j].setCodigoCampana(table.getString(1));

                campanas[j].setNombre(table.getString(2));

                Date fecha;
                fecha = format.parse(table.getString(3));
                campanas[j].setFecha(fecha);

                campanas[j].setObjetivo(table.getString(4));

                campanas[j].setEstado(table.getBoolean(5));

                //Medico 
                String idMedico = table.getString(6);
                
                Empleado empleado = daoEmpleado.readEmpleado(idMedico, 0);
                Medico responsable = daoMedico.readMedico(empleado);
                campanas[j].setResponsable(responsable);

                j++;
                System.out.println("ok");
            }
            daoEmpleado.closeConectionDB();

            return campanas;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Permite listar las campañas de un medico en especifico
     *
     * @param tipo si se quieren las activas (true) o todas
     * @param doctor medico al cual corresponden las campañas
     * @return campañas
     */
    public Campana[] listarCampanasDeMedico(boolean tipo, Medico doctor) {
        String sql_select, sql_count;
        String idMedico = doctor.getIdentificacion();
        if (tipo) {
            sql_select = "SELECT codigoCampana,nombre,fecha,objetivo,estado FROM Campana WHERE estado= true AND idResponsable='" + idMedico + "';";
            sql_count = "SELECT COUNT(*) FROM Campana WHERE estado=true AND idResponsable='" + idMedico + "';";
        } else {
            sql_select = "SELECT codigoCampana,nombre,fecha,objetivo,estado FROM Campana WHERE idResponsable='" + idMedico + "';";
            sql_count = "SELECT COUNT(*) FROM Campana WHERE idResponsable='" + idMedico + "';";
        }

        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);

            System.out.println(tamano);
            Campana campanas[] = new Campana[tamano];
            for (int i = 0; i < tamano; i++) {
                campanas[i] = new Campana();
            }

            int j = 0;

            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            while (table.next()) {

                campanas[j].setCodigoCampana(table.getString(1));

                campanas[j].setNombre(table.getString(2));

                Date fecha;
                fecha = format.parse(table.getString(3));
                campanas[j].setFecha(fecha);

                campanas[j].setObjetivo(table.getString(4));

                campanas[j].setEstado(table.getBoolean(5));

                campanas[j].setResponsable(doctor);

                j++;
                System.out.println("ok");
            }

            return campanas;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Permite crear una nueva campaña en la base de datos
     *
     * @param nuevaCampana campaña a almacenar
     * @return
     */
    public int crearCampana(Campana nuevaCampana) {
        String sql_save;
        int numRows = 0;

        String nombre = nuevaCampana.getNombre();
        String objetivo = nuevaCampana.getObjetivo();
        String fecha = nuevaCampana.getFecha().toString();
        String responsable = nuevaCampana.getResponsable().getIdentificacion();

        sql_save = "INSERT INTO Campana VALUES ( NEXTVAL('camp_seq')  , '" + fecha + "', '" + nombre + "','" + objetivo + "','" + responsable + "',true);";
        try {
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);
            System.out.println("numRowsDAO: " + numRows);
            return numRows;

        } catch (SQLException e) {

            System.out.println(e);
            return -2;
        } catch (Exception e) {

            System.out.println(e);
        }
        return -1;
    }

    /**
     * Permite hacer borrado logico de una campaña en la base de datos
     *
     * @param codigoCampana codigo de la campana a eliminar
     * @return
     */
    public int eliminarCausa(String codigoCampana) {
        String sql_save;
	sql_save="UPDATE Campana SET estado=false WHERE codigo='" + codigoCampana + "'";
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
    /**
     * Permite conocer el codigo de una campaña de acuerdo a su nombre
     * @param nombre nombre de la campaña
     * @return codigo
     */
    public String codigoCampana(String nombre) {
        String sql = "SELECT codigoCampana FROM campana WHERE nombre = '" + nombre + "'";

        ResultSet table;
        try {
            Statement sentence = conn.createStatement();
            table = sentence.executeQuery(sql);
            String codigo = "";
            while (table.next()) {
                codigo = table.getString(1);
            }
            return codigo;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCampana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /**
     * Permite actualizar los datos de una campaña en la base de datos 
     * @param codigo codigo de la campaña a actualizar
     * @param nuevaCampana nuevos datos de la campaña
     * @return valor de confirmacion
     */
    public int actualizarCampana(String codigo, Campana nuevaCampana) {
        String sql1,sql2,sql3,sql4;
        String nuevoNombre = nuevaCampana.getNombre();
        String nuevoObjetivo = nuevaCampana.getObjetivo();
        boolean nuevoEstado =  nuevaCampana.getEstado();
        String nuevaFecha = nuevaCampana.getFecha().toString();
        
	sql1="UPDATE Campana SET nombre='"+nuevoNombre+"' WHERE codigoCampana='" + codigo + "';";
        sql2 = "UPDATE Campana SET objetivo='"+nuevoObjetivo+"' WHERE codigoCampana='" + codigo + "';";
        sql3 = "UPDATE Campana SET estado='"+nuevoEstado+"' WHERE codigoCampana='" + codigo + "';";
        sql4 = "UPDATE Campana SET fecha='"+nuevaFecha+"' WHERE codigoCampana='" + codigo + "';";
        
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
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

    public int asignarPacCam(String ident, String codigoCampana) {
        String sql_save;
        int numRows = 0;

        sql_save = "INSERT INTO pacientes_campana VALUES ('"+ident+"', '"+codigoCampana+"');";
        try {
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);
            System.out.println("numRowsDAO: " + numRows);
            return numRows;

        } catch (SQLException e) {

            System.out.println(e);
            return -1;
        } catch (Exception e) {

            System.out.println(e);
        }
        return -2; 
    }

    public String[] listarUsuarioCamp(String codigoCampana) {
            
    
            String sql_select, sql_count;
        
            sql_select = "SELECT idpaciente FROM pacientes_campana WHERE idCampana ='"+codigoCampana+"';";
            sql_count = "SELECT COUNT(*) FROM pacientes_campana WHERE idCampana ='"+codigoCampana+"';";



        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet tablaTam = sentence.executeQuery(sql_count);
            tablaTam.next();
            int tamano = tablaTam.getInt(1);
            ResultSet table = sentence.executeQuery(sql_select);

            System.out.println(tamano);
            String usuarioCamp[] = new String[tamano];
            
            int j = 0;

            while (table.next()) {
                
                usuarioCamp[j] = table.getString(1);
                j++;
                System.out.println("ok");
            }

            return usuarioCamp;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;    }

    public int eliminarPacCamp(String docum, String codCamp) {
        String sql1;
	sql1 = "DELETE FROM pacientes_campana WHERE idpaciente='"+docum+"' AND idcampana ='"+codCamp+"';";
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
}
