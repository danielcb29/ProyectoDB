/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import proceso.Formula;
import proceso.Medicamento;

/**
 *
 * @author daniel
 */
public class DAOFormula {

    private BaseDatos db;
    private Connection conn;

    public DAOFormula(Connection conn) {
        db = new BaseDatos();
        this.conn = conn;
    }

    /**
     * Metodo que permite insertar una formlula a la base de datos
     *
     * @param formula formula a almacenar
     * @return valor de confirmacion , 1ok , -1 error , -2 sql error
     */
    public int crearFormula(Formula formula) {
        String numHistoria = formula.getHistoriaPaciente().getNumHistoria();
        String idMedico = formula.getMedicoForm().getIdentificacion();
        String fecha = formula.getFecha().toString();
        Vector<Medicamento> medicamentos = formula.getMedicamentosForm();
        int numMedicamentos = medicamentos.size();
        String sql = "";
        int numRow = -1;
        //System.out.println("tamano " + numMedicamentos);
        try {
            for (int i = 0; i < numMedicamentos; i++) {
                sql = "INSERT INTO Formula VALUES('" + medicamentos.get(i).getCodigoMedicamento() + "','" + idMedico + "','" + numHistoria + "','" + fecha + "');";
                //System.out.println("Entramos a adicionar la primara formula y :" + sql);

                Statement sentencia = conn.createStatement();
                numRow = sentencia.executeUpdate(sql);
                //System.out.println("se inserto: " + medicamentos.get(i).getNombre());
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numRow;
    }

}
