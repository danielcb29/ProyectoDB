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
public class Formula {
    
    private Medico medicoForm;
    private Vector<Medicamento> medicamentosForm;
    private HistoriaClinica historiaPaciente;
    private Date fecha;
    private double costo;
    
    public Formula(){
        
    }
    public Formula(Medico paramMed,Vector<Medicamento> paramMedicamentos, HistoriaClinica paramHistoria, Date paramFecha){
        medicoForm=paramMed;
        medicamentosForm=paramMedicamentos;
        historiaPaciente=paramHistoria;
        fecha=paramFecha;
        
    }

    /**
     * @return the medicoForm
     */
    public Medico getMedicoForm() {
        return medicoForm;
    }

    /**
     * @param medicoForm the medicoForm to set
     */
    public void setMedicoForm(Medico medicoForm) {
        this.medicoForm = medicoForm;
    }

    /**
     * @return the medicamentosForm
     */
    public Vector<Medicamento> getMedicamentosForm() {
        return medicamentosForm;
    }

    /**
     * @param medicamentosForm the medicamentosForm to set
     */
    public void setMedicamentosForm(Vector<Medicamento> medicamentosForm) {
        this.medicamentosForm = medicamentosForm;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que calcula el costo de la formula basandose en los medicamentos formulados
     * @return the costo
     */
    public double getCosto() {
        
        costo=0;
        
        for(int i=0;  i<medicamentosForm.size(); i++){
            costo +=medicamentosForm.get(i).getCosto();
        }
        return costo;
    }
    
}
