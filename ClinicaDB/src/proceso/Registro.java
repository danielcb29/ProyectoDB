/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author cenesis
 */
public class Registro {
    
    private Medico medicoRegistro;
    private Date fecha;
    private double precio;
    private Vector<Causa> causasPaciente;
    private HistoriaClinica historiaPaciente;
    private String idMedico; //TEMPORAL MIENTRAS DAOMEDICO
    private String codigoRegistro;
    private String numHistoria;

    public Registro(){
        
    }
    public Registro(Medico medico,Date fecha,double precio, Vector<Causa> causas,HistoriaClinica hist){
        medicoRegistro=medico;
        this.fecha=fecha;
        this.precio=precio;
        causasPaciente=causas;
        historiaPaciente=hist;
                
        
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
    //=====================================EDITADO CAMILO ===================
    /**
     * @return the codighoRgistro
     */
    public String getCodigo() {
        return codigoRegistro;
    }
    
    /**
     * @return the numHistoria
     */
    public String getnumHistoria() {
        return numHistoria;
    }
    
    /**
     * @return the numHistoria
     */
    public String getCausas() {
        String respuesta = "";
        for(int i = 0 ; i < causasPaciente.size() ; i++){
            respuesta += causasPaciente.get(i).getNombre() + ", ";
        }
        //return respuesta.substring(0, respuesta.length()-2);
        return respuesta;
    }
    
    
    //=========================================================================
    

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
        this.setPrecio(precio*descuento);
    }

    /**
     * @return the causasPaciente
     */
    public Vector<Causa> getCausasPaciente() {
        return causasPaciente;
    }

    /**
     * @param causasPaciente the causasPaciente to set
     */
    public void setCausasPaciente(Vector<Causa> causasPaciente) {
        this.causasPaciente = causasPaciente;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the historiaPaciente
     */
    public HistoriaClinica getHistoriaPaciente() {
        return historiaPaciente;
    }

    /**
     * @param historiaPaciente the historiaPaciente to set
     */
    public void setHistoriaPaciente(HistoriaClinica historiaPaciente) {
        this.historiaPaciente = historiaPaciente;
    }

    /**
     * @return the idMedico
     */
    public String getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public void setCodigo(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public void setNumHistori(String numHistoria) {
        this.numHistoria = numHistoria;
    }
    
}
