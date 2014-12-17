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
public class Campana {
    
    private String codigoCampana;
    private Date fecha;
    private String nombre;
    private String objetivo;
    private Paciente[] pacientesCampana;
    private boolean estado;
    private Medico responsable;
    
    public Campana(){
        
    }
    
    public Campana(Date fechaIn , String nombre , String objetivo, Medico doctor){
        fecha=fechaIn;
        this.nombre=nombre;
        this.objetivo=objetivo;
        estado=true;
        responsable=doctor;
    }
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
        return getPacientesCampana();
    }

    /**
     * @param misPacientes the misPacientes to set
     */
    public void setMisPacientes(Paciente[] misPacientes) {
        this.setPacientesCampana(misPacientes);
    }

    /**
     * @return the pacientesCampana
     */
    public Paciente[] getPacientesCampana() {
        return pacientesCampana;
    }

    /**
     * @param pacientesCampana the pacientesCampana to set
     */
    public void setPacientesCampana(Paciente[] pacientesCampana) {
        this.pacientesCampana = pacientesCampana;
    }

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    /**
     * @return the responsable
     */
    public Medico getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(Medico responsable) {
        this.responsable = responsable;
    }
    
    
}
