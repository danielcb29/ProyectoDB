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
class Causa {
    
    private String codigoCausa;
    private String nombre;
    private String descripcion;

    /**
     * @return the codigoCausa
     */
    public String getCodigoCausa() {
        return codigoCausa;
    }

    /**
     * @param codigoCausa the codigoCausa to set
     */
    public void setCodigoCausa(String codigoCausa) {
        this.codigoCausa = codigoCausa;
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
