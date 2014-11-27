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
public class Enfermera extends Empleado{
    
    private int anosExp;

    public Enfermera(String nombres, String apellidos, String telefono, String direccion, int salario, String email, String cargo, String identificacion) {
        super(nombres, apellidos, telefono, direccion, salario, email, cargo, identificacion);
    }
    private String[] misHabilidades;

    /**
     * @return the anosExp
     */
    public int getAnosExp() {
        return anosExp;
    }

    /**
     * @param anosExp the anosExp to set
     */
    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    /**
     * @return the misHabilidades
     */
    public String[] getMisHabilidades() {
        return misHabilidades;
    }

    /**
     * @param misHabilidades the misHabilidades to set
     */
    public void setMisHabilidades(String[] misHabilidades) {
        this.misHabilidades = misHabilidades;
    }
       
    
}
