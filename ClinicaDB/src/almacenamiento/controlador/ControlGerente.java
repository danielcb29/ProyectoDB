/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOHistoria;
import almacenamiento.accesodatos.DAORegistro;
import almacenamiento.accesodatos.DaoPaciente;
import java.sql.Connection;
import java.util.Vector;
import proceso.Paciente;
import proceso.Registro;

/**
 *
 * @author Alkomprar
 */
public class ControlGerente {
    DaoPaciente daoPaciente;
    DAORegistro daoRegistro;
    DAOHistoria daoHistoria;
    
    public ControlGerente(Connection con){
        daoPaciente = new DaoPaciente(con);
        daoRegistro = new DAORegistro(con);
        daoHistoria = new DAOHistoria(con);
        
    }
    
    public Paciente buscarPaciente(String cedula){
        //System.out.println("Antes de leer paciente");
        Paciente miPaciente = daoPaciente.leerPaciente(cedula);
        //System.out.println("Despues leer paciente");
        return miPaciente;
    }
    
     public Vector<Registro> buscarRegistros(String cedula){
        //System.out.println("Antes de leer paciente");
        Vector<Registro> registros = daoHistoria.leerRegistrosHistoria(cedula);
        //System.out.println("Despues leer paciente");
        return registros;
    }
    

}
