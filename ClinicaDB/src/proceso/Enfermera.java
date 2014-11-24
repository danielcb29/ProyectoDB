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
    private String[] misHabilidades;
    
    public Enfermera(String id, String nom, String ap, String tel, String dir, int sal, String mail, String car, Empleado je, Area ar, int aExp, String[] habs){
        super(id,nom,ap,tel,dir,sal,mail,car,je,ar);
        anosExp=aExp;
        misHabilidades=habs;
    }

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
