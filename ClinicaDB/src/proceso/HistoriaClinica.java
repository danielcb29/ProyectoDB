/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import java.util.Date;

/**
 *
 * @author cenesis
 */
public class HistoriaClinica {
    
    private String numHistoria;
    private Date fechaAper;
    //private Registro[] registrosConsultasPacientes;
    private Paciente persona;
    public HistoriaClinica(Date fechaAper,Paciente paciente){
        
        this.fechaAper=fechaAper;
        persona=paciente;
    }
    public HistoriaClinica(){
        
    }
    /**
     * @return the numHistoria
     */
    public String getNumHistoria() {
        return numHistoria;
    }

    /**
     * @param numHistoria the numHistoria to set
     */
    public void setNumHistoria(String numHistoria) {
        this.numHistoria = numHistoria;
    }

    /**
     * @return the fechaAper
     */
    public Date getFechaAper() {
        return fechaAper;
    }

    /**
     * @param fechaAper the fechaAper to set
     */
    public void setFechaAper(Date fechaAper) {
        this.fechaAper = fechaAper;
    }

    /**
     * @return the registrosConsultasPacientes
     *//*
    public Registro[] getRegistrosConsultasPacientes() {
        return registrosConsultasPacientes;
    }

    /**
     * @param registrosConsultasPacientes the registrosConsultasPacientes to set
     *//*
    public void setRegistrosConsultasPacientes(Registro[] registrosConsultasPacientes) {
        this.registrosConsultasPacientes = registrosConsultasPacientes;
    }*/

    /**
     * @return the persona
     */
    public Paciente getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Paciente persona) {
        this.persona = persona;
    }
    
}
