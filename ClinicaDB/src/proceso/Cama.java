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
public class Cama {
    
    private String numeroCama;
    private boolean estado;
    private String descripcion;
    private int area;
    private boolean activa;

    public Cama(String numeroCama, boolean estado, String descripcion, int area, boolean activa) {
        this.numeroCama = numeroCama;
        this.estado = estado;
        this.descripcion = descripcion;
        this.area = area;
        this.activa = activa;
    }

    public Cama() {
       
    }

    /**
     * @return the numeroCama
     */
    public String getNumeroCama() {
        return numeroCama;
    }

    /**
     * @param numeroCama the numeroCama to set
     */
    public void setNumeroCama(String numeroCama) {
        this.numeroCama = numeroCama;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
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
        
    /**
     * @return the descripcion
     */
    public int getArea() {
        return area;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setArea(int area) {
        this.area = area;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    
    public String toString(){
        
        
        return ""+numeroCama+" "+area;
    }
}
