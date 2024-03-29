/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlRegistro;
import java.sql.Connection;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import proceso.Causa;
import proceso.HistoriaClinica;
import proceso.Medico;
import proceso.Paciente;
import proceso.Registro;


/**
 *
 * @author daniel
 */
public class PanelRegistros extends javax.swing.JFrame {

    private Date hoy; 
    private ControlRegistro controlReg;
    private Connection conn;
    private Causa[] causas;
    private String[] nomCausas;
    private HistoriaClinica historia;
    private boolean[] causasSeleccionadas;
    private Vector<Causa> causasDelRegistro;
    private Medico doctor;
    /**
     * Creates new form PanelRegistros
     */
    public PanelRegistros(Connection conn, Medico medico) {
        super("Panel de Registro de Historias Clinicas");
        setResizable(false);
        initComponents();
        hoy = new Date();
        String fecha = hoy.toString();
        lbFecha.setText(fecha);
        this.conn=conn;
        controlReg = new ControlRegistro(conn);
        causasDelRegistro = new Vector<Causa>();
        lbNombreApellido.setText("");
        historia=null;
        doctor=medico;
        btGuardar.setEnabled(false);
        mostrarCausas();
        
        
        
        
        
        
    }
   private void mostrarCausas(){
               
        causas = controlReg.listarCausas();
        
        int longitud=causas.length;
        nomCausas=new String[longitud];
        causasSeleccionadas = new boolean[longitud];
        for(int i=0; i<longitud; i++){
            String nombre=causas[i].getNombre();
            System.out.println(nombre);
            nomCausas[i]=nombre;
            causasSeleccionadas[i] = false;
        }
        cbCausas.setModel(new javax.swing.DefaultComboBoxModel(nomCausas));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCCPaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbNombreApellido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbCausas = new javax.swing.JComboBox();
        btAdicionar = new javax.swing.JButton();
        btQuitar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taRegistradas = new javax.swing.JTextArea();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfCosto = new javax.swing.JTextField();
        cbTipoId = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel1.setText("Registro Historia Clinica");

        jLabel2.setText("Este modulo le permite ingresar registros a una historia clinica de un paciente en la base de datos");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setText("Historia Clinica:");

        jLabel4.setText("Paciente:");

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel5.setText("Nombres y Apellidos:");

        lbNombreApellido.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        lbNombreApellido.setText("salida");

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel6.setText("Fecha:");

        lbFecha.setText("hoy");

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel7.setText("Causas:");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btQuitar.setText("Quitar");
        btQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuitarActionPerformed(evt);
            }
        });

        jLabel8.setText("Causas adicionadas al registro:");

        taRegistradas.setColumns(20);
        taRegistradas.setEditable(false);
        taRegistradas.setRows(5);
        jScrollPane1.setViewportView(taRegistradas);

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("Costo:");

        tfCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoActionPerformed(evt);
            }
        });

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));

        jLabel11.setText("Numero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(20, 20, 20)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbCausas, 0, 234, Short.MAX_VALUE)
                                            .addComponent(tfCosto))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNombreApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfCCPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tfCCPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreApellido)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btAdicionar)
                    .addComponent(btQuitar)
                    .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btGuardar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        
        String cedula = tfCCPaciente.getText();
        String tipo = cbTipoId.getSelectedItem().toString();
        String identificacion = tipo + cedula;
        historia = controlReg.buscarHistoria(identificacion);
        if(historia.getNumHistoria()==null){
            historia=null;
            JOptionPane.showMessageDialog(this, "No existe una HistoriaClinica para ese paciente\nDebe crear una","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            btGuardar.setEnabled(true);
            Paciente paciente = historia.getPersona();
            String nombre = paciente.getNombres().toUpperCase();
            String apellido = paciente.getApellidos().toUpperCase();
            lbNombreApellido.setText(nombre+" "+apellido);
            //lbNombreApellido.setText("");
        }
        
        
        
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
        int index = cbCausas.getSelectedIndex();
        
        if(causasSeleccionadas[index]){
            JOptionPane.showMessageDialog(this, "Esta causa ya esta adicionada en el registro","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            Causa seleccionada = causas[index];
            causasSeleccionadas[index]=true;
            causasDelRegistro.add(seleccionada);
            taRegistradas.append(nomCausas[index]+"\n");
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuitarActionPerformed
        // TODO add your handling code here:
        int index = cbCausas.getSelectedIndex();
        if(!causasSeleccionadas[index]){
            JOptionPane.showMessageDialog(this, "Esta causa no esta adicionada en el registro","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            Causa seleccionada = causas[index];
            causasSeleccionadas[index]=false;
            causasDelRegistro.remove(seleccionada);
            taRegistradas.setText("");
            escribirTxtArea();
        }
    }//GEN-LAST:event_btQuitarActionPerformed
    private boolean validarVacios(){
        boolean vacio = false;
        if(causasDelRegistro.isEmpty() || tfCosto.getText().length() == 0 || historia==null)
        {
            vacio=true;
        }        
        return vacio;
    }
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        if(validarVacios()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios\nNo puede crearse un registro vacio","Error",JOptionPane.ERROR_MESSAGE);
            
        }else{
            double costo = Double.parseDouble(tfCosto.getText());
            Registro reg = new Registro(doctor, hoy, costo, causasDelRegistro, historia);
            int resul = controlReg.crearRegitro(reg);
            
            if(resul ==1){
                String id = historia.getPersona().getIdentificacion();
                JOptionPane.showMessageDialog(this, "Registro adicionado exitosamente a la historia clinica del paciente "+id,"Registro Exitoso",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void tfCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCostoActionPerformed

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         *//*
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PanelRegistros().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btQuitar;
    private javax.swing.JComboBox cbCausas;
    private javax.swing.JComboBox cbTipoId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNombreApellido;
    private javax.swing.JTextArea taRegistradas;
    private javax.swing.JTextField tfCCPaciente;
    private javax.swing.JTextField tfCosto;
    // End of variables declaration//GEN-END:variables

    private void escribirTxtArea() {
        int size = causasDelRegistro.size();
        for(int i =0;i<size;i++){
            taRegistradas.append(causasDelRegistro.get(i).getNombre() +"\n");
        }
    }
}
