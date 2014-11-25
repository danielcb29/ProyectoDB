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
public class Medico extends Empleado{
    
    private int numeroLicencia;
    private String especialidad;
    private String universidad;
    
    
    public Medico(String id, String nom, String ap, String tel, String dir, int sal, String mail, String car, String con, String je, Area ar, boolean est, int nL, String esp, String u){
        super(id,nom,ap,tel,dir,sal,mail,car,con,je,ar,est);
        
        numeroLicencia=nL;
        especialidad=esp;
        universidad=u;
    }

    /**
     * @return the numeroLicencia
     */
    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    /**
     * @param numeroLicencia the numeroLicencia to set
     */
    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the universidad
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     * @param universidad the universidad to set
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

  
    
    
    
}
