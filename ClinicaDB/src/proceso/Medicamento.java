/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author cenesis
 */
public class Medicamento{
    
    private String codigoMedicamento;
    private String nombre;
    private double costo;
    private String descripcion;

    public Medicamento(){
        
    }
    public Medicamento(String codigo , String nombre , double costo, String descripcion){
        codigoMedicamento=codigo;
        this.nombre=nombre;
        this.costo=costo;
        this.descripcion=descripcion;
    }
    /**
     * @return the codigoMedicamento
     */
    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    /**
     * @param codigoMedicamento the codigoMedicamento to set
     */
    public void setCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
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
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
