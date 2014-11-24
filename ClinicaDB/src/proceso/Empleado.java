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
public class Empleado extends Persona{
    
    private int salario;
    private String email;
    private String cargo;
    private String jefe;//identificacion del empleado
    private Area area;
    
    public Empleado(String id, String nom, String ap, String tel, String dir, int sal, String mail, String car, String je, Area ar){
        identificacion = id;
        nombres = nom;
        apellidos=ap;
        telefono=tel;
        direccion=dir;
        salario=sal;
        email=mail;
        cargo=car;
        jefe=je;
        area=ar;
    }
    
    public Empleado(){}
    
    /**
     * @return the salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the jefe
     */
    public String getJefe() {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
    
    
    /**
     * @return la area
     */
    public Area getArea() {
        return area;
    }
    
    /**
     * @param area el area a cambiar
     */
    public void setArea(Area area) {
        this.area = area;
    }
    
}
