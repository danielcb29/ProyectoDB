/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOFormula;
import java.sql.Connection;
import java.util.Vector;
import proceso.Formula;
import proceso.HistoriaClinica;
import proceso.Medicamento;

/**
 *
 * @author daniel
 */
public class ControlFormula {
    private DAOFormula dao;
    private ControlMedicamento controlMedicamento;
    private ControlHistoria controlHistoria;
    public ControlFormula(Connection conn){
        dao = new DAOFormula(conn);
        controlMedicamento = new ControlMedicamento(conn);
        controlHistoria = new ControlHistoria(conn);
    }
    /**
     * Metodo que permite listar los medicamentos para mostrarlos en la formula medica
     * @return Arreglo con los medicamentos almacenados en la base de datos
     */
    public Medicamento[] listarMedicamentos(){
        Medicamento[] resultado = controlMedicamento.listarMedicamentos(true);
        return resultado;
    }
    /**
     * Metodo que permite consultar una historia clinica ingresando una cedula
     * @param cedula cedula del paciente a consultar historia
     * @return Hisotria almacenada en la base de datos
     */
    public HistoriaClinica buscarHistoria(String cedula) {
        HistoriaClinica resultado = controlHistoria.buscarHistoria(cedula);
        return resultado;
    }
    /**
     * Metodo que permite crear una formula medica en la base de datos
     * @param formula formula a almacenar
     * @return valor de confirmacion , 1ok , -2 sql error , -1 error
     */
    public int crearFormula(Formula formula) {
        
        int resul = dao.crearFormula(formula);
        
        return resul;
        
    }
    
}
