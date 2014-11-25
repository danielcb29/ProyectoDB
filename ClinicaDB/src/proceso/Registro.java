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
class Registro {
    
    private Medico medicoRegistro;
    private Date fecha;
    private double precio;
    private Causa[] causasPaciente;
    //private HistoriaClinica historiaPaciente;

    public Registro(){
        
    }    
    /**
     * @return the medicoRegistro
     */
    public Medico getMedicoRegistro() {
        return medicoRegistro;
    }

    /**
     * @param medicoRegistro the medicoRegistro to set
     */
    public void setMedicoRegistro(Medico medicoRegistro) {
        this.medicoRegistro = medicoRegistro;
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
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio, double descuento) {
        this.precio = precio*descuento;
    }

    /**
     * @return the causasPaciente
     */
    public Causa[] getCausasPaciente() {
        return causasPaciente;
    }

    /**
     * @param causasPaciente the causasPaciente to set
     */
    public void setCausasPaciente(Causa[] causasPaciente) {
        this.causasPaciente = causasPaciente;
    }
    
}
