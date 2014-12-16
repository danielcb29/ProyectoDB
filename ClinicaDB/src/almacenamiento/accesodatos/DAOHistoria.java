/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.Causa;
import proceso.HistoriaClinica;
import proceso.Medico;
import proceso.Paciente;
import proceso.Registro;

/**
 *
 * @author daniel
 */
public class DAOHistoria {

    private BaseDatos db;
    private Connection conn;
    private DaoPaciente daoPac;

    public DAOHistoria(Connection conn) {
        db = new BaseDatos();
        this.conn = conn;
        daoPac = new DaoPaciente(conn);
    }

    /**
     * Metodo que permite consultar la existencia de una historia clinica
     * asignada a un paciente
     *
     * @param cedula: cedula del paciente a validar
     * @return valor de existencia en la base de datos
     */
    public boolean existePaciente(String cedula) {
        boolean resultado = false;
        String sql = "select count(*) from (select numhistoria from historiaclinica where idpaciente = '" + cedula + "') as a";
        //String tam = "SELECT COUNT(*) FROM historiaclinica";
        try {

            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            table.next();
            int tamano = table.getInt(1);
            if (tamano != 0) {
                resultado = true;
            }

            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ojo que paso un error en la sentencia");
        return resultado;
    }

    /**
     * Metodo que permite crear una historia clinica en la base de datos
     *
     * @param hc: historia clinica a almacenar
     * @param ccPaciente: cedula del paciente al cual corresponde dicha historia
     * @return numero de verificacion , 1ok , -1 sql error
     */
    public int crearHC(HistoriaClinica hc) {
        Date fecha = hc.getFechaAper();
        String ccPaciente = hc.getPersona().getIdentificacion();
        int numRows = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
        format.format(fecha);
        String datePSQL = fecha.toString();

        System.out.println("date one :" + datePSQL);

        String sql = "INSERT INTO historiaclinica VALUES(NEXTVAL('hist_seq'),'" + datePSQL + "','" + ccPaciente + "');";
        try {

            Statement sentencia = conn.createStatement();
            numRows = sentencia.executeUpdate(sql);
            System.out.println("numRowsDAO: " + numRows);
            return numRows;

        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * Metodo que permite leer la historia clinica de una base de datos
     *
     * @param cedula: cedula del paciente al cual pertenece la historia
     * @return historia clinica
     */
    public HistoriaClinica leerSimpleHC(String cedula) {

        String sql = "SELECT numHistoria, fechaAper FROM HistoriaClinica WHERE idPaciente ='" + cedula + "'; ";

        HistoriaClinica nuevaHC = new HistoriaClinica();
        try {
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            //String idPaciente = "";
            while (table.next()) {

                nuevaHC.setNumHistoria(table.getString(1));

                Date fechaAper;
                System.out.println("Antes de formatear la fecha");
                fechaAper = format.parse(table.getString(2));
                System.out.println("Despues de formatear la fecha");
                nuevaHC.setFechaAper(fechaAper);

                //idPaciente = table.getString(3);
            }

            Paciente paciente = daoPac.leerPaciente(cedula);
            nuevaHC.setPersona(paciente);

            return nuevaHC;

        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /**
     * Metodo que permite leer los registros de una historia clinica
     * @param idHistoria numero de registro a obtener historia
     * @return registros en un vector
     */
    
    //==========================EDITADO POR CAMILO ======================================================= 
    public Vector<Registro> leerRegistrosHistoria(String cedula) {

        String sqlRegistro = "SELECT * FROM registrohc WHERE numhistoria=(SELECT numHistoria  FROM HistoriaClinica WHERE idPaciente = '" + cedula + "');";
        Vector<Registro> registros = new Vector<Registro>();
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        try {

            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sqlRegistro);

            while (table.next()) {
                Registro dbReg = new Registro();
                String codigoRegistro = table.getString(1);
                String numHistoria = table.getString(2);
                String idMedico = table.getString(3);
                //Medico medico = new Medico();
                Date fecha;
                fecha = format.parse(table.getString(4));
                double precio = table.getDouble(5);

                Vector<Causa> causasRegistro = causasRegistro(codigoRegistro);
                
                dbReg.setCodigo(codigoRegistro);
                dbReg.setNumHistori(numHistoria);
                dbReg.setCausasPaciente(causasRegistro);
                dbReg.setFecha(fecha);
                dbReg.setPrecio(precio);
                dbReg.setIdMedico(idMedico);
                
                registros.add(dbReg);
            }
            
            return registros;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Double[] consultarCostoAnio(String cedula , String anio) {

        String sqlCostosFormula = "SELECT SUM(costo) FROM formula F,Medicamentos M WHERE M.codigoMedicamento=F.idMedicamento AND (select extract (year from F.fechaasignacion))='"+anio+"' AND F.numHistoria = (SELECT numHistoria FROM HistoriaClinica WHERE idPaciente = '"+cedula+"');";
        String sqlCostosCitas = "SELECT SUM(precio) FROM registrohc WHERE (select (extract year from fecha))='"+anio+"' AND numHistoria=(SELECT numHistoria  FROM HistoriaClinica WHERE idPaciente = '" + cedula + "');";
        Double[] resultado = new Double[2];
        System.out.println("consulta Paciente " + sqlCostosFormula+"\n "+sqlCostosCitas);
        try {

            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sqlCostosFormula);
            //if(table.getRow()!=0){
                while (table.next()) {
                    resultado[0] = table.getDouble(1);
                    System.out.println("RESULTADO DESDE DAO0:"+resultado[0]);
                }
                ResultSet table2 = sentence.executeQuery(sqlCostosCitas);
                while (table2.next()) {
                    resultado[1] = table2.getDouble(1);
                    System.out.println("RESULTADO DESDE DAO1:"+resultado[1]);
                }
            
            return resultado;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Double[] consultarCostoAnioMes(String cedula , String anio, String mes) {
     
        String sqlCostosFormula = "SELECT SUM(costo) FROM formula AS F, Medicamentos AS M WHERE M.codigoMedicamento=F.idMedicamento AND (select (extract year from F.fechaasignacion))='"+anio+"' AND (select (extract month from F.fechaasignacion))='"+mes+"' AND F.numHistoria = (SELECT numHistoria FROM HistoriaClinica WHERE idPaciente = '"+cedula+"');";
        String sqlCostosCitas = "SELECT SUM(precio) FROM registrohc WHERE (select extract(year from fecha))='"+anio+"' AND (select extract(month from fecha))='"+mes+"' AND numHistoria=(SELECT numHistoria  FROM HistoriaClinica WHERE idPaciente = '" + cedula + "');";
        Double[] resultado = new Double[2];
        System.out.println("consulta Paciente " + sqlCostosFormula+"\n "+sqlCostosCitas);
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        try {

            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sqlCostosFormula);
            
            if(table.getRow()!=0){
                while (table.next()) {
                    resultado[0] = Double.parseDouble(table.getString(1));

                }
                ResultSet table2 = sentence.executeQuery(sqlCostosCitas);
                while (table2.next()) {
                    resultado[1] = Double.parseDouble(table2.getString(1));

                }
            }
            
            return resultado;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //=========================================================================================================
    /**
     * Metodo que permite obtener las causas de un registro dado 
     * @param codigoRegistro codigo del registro a obtener causas
     * @return causas de dicho registro
     */
    private Vector<Causa> causasRegistro(String codigoRegistro) {
        String sqlCausa = "select codigocausa,nombre,descripcion,estado from causas_registro natural join causa where codigoregistro='" + codigoRegistro + "';";
        Vector<Causa> causasRegistro = new Vector<Causa>();
        try {
            
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sqlCausa);
            while(table.next()){
                Causa causa = new Causa();
                causa.setCodigoCausa(table.getString(1));
                causa.setNombre(table.getString(2));
                causa.setDescripcion(table.getString(3));
                causa.setEstado(table.getBoolean(4));
                causasRegistro.add(causa);
            }
            return causasRegistro;
        } catch (SQLException ex) {
            Logger.getLogger(DAOHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
