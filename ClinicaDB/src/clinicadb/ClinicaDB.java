/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadb;

import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.text.ParseException;

/**
 *
 * @author daniel
 */
public class ClinicaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        BaseDatos conect = new BaseDatos();
        DaoPaciente paciente = new DaoPaciente(conect.getConnetion());
        paciente.pruebaCrearPaciente();
        paciente.pruebaLeerPaciente();
        paciente.pruebaModif();
        paciente.pruebaList();
        
        // TODO code application logic here
    }
}
