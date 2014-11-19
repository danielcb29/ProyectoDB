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
public class Paciente extends Persona{
    
    private String numeroSocial;
    private String actEcon;
    private Date fechaNac;
    private Cama camaAsignada;
    private HistoriaClinica historiaPaciente;

    /**
     * @return the numeroSocial
     */
    public String getNumeroSocial() {
        return numeroSocial;
    }

    /**
     * @param numeroSocial the numeroSocial to set
     */
    public void setNumeroSocial(String numeroSocial) {
        this.numeroSocial = numeroSocial;
    }

    /**
     * @return the actEcon
     */
    public String getActEcon() {
        return actEcon;
    }

    /**
     * @param actEcon the actEcon to set
     */
    public void setActEcon(String actEcon) {
        this.actEcon = actEcon;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the camaAsignada
     */
    public Cama getCamaAsignada() {
        return camaAsignada;
    }

    /**
     * @param camaAsignada the camaAsignada to set
     */
    public void setCamaAsignada(Cama camaAsignada) {
        this.camaAsignada = camaAsignada;
    }
    
    
    
    
}
