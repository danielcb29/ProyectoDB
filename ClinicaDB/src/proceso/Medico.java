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
    //private Campana[] miCampanas;

    public Medico(String nombres, String apellidos, String telefono, String direccion, int salario, String email, String cargo, String identificacion, int licencia, String especialidad, String universidad) {
        super(nombres, apellidos, telefono, direccion, salario, email, cargo, identificacion);
        numeroLicencia=licencia;
        this.especialidad=especialidad;
        this.universidad=universidad;
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
