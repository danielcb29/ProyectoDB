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
class Campana {
    
    private String codigoCampana;
    private Date fecha;
    private String nombre;
    private String objetivo;
    private Paciente[] pacientesCampana;

    /**
     * @return the codigoCampana
     */
    public String getCodigoCampana() {
        return codigoCampana;
    }

    /**
     * @param codigoCampana the codigoCampana to set
     */
    public void setCodigoCampana(String codigoCampana) {
        this.codigoCampana = codigoCampana;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the misPacientes
     */
    public Paciente[] getMisPacientes() {
        return pacientesCampana;
    }

    /**
     * @param misPacientes the misPacientes to set
     */
    public void setMisPacientes(Paciente[] misPacientes) {
        this.pacientesCampana = misPacientes;
    }
    
    
    
}
