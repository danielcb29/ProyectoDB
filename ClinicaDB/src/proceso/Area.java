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
public class Area {
    
    private int codigoArea;
    private String nombre;
    private String descripcion;
    private boolean estado;
    

    public Area(int ca, String nom, String des, boolean est){
        codigoArea=ca;
        nombre=nom;
        descripcion=des;
        estado=est;
    }
    
    public Area(){}
    
    /**
     * @return the codigoArea
     */
    public int getCodigoArea() {
        return codigoArea;
    }

    /**
     * @param codigoArea the codigoArea to set
     */
    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
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
    
    @Override
    public String toString(){
        return nombre;
    }
}
