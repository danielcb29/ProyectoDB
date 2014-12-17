/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlCampana;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proceso.Campana;

/**
 *
 * @author cenesis
 */
public class PanelPacCampa extends javax.swing.JFrame {

    
    Connection conn;
    ControlCampana controlCam;
    Campana[] misCamp;
    /**
     * Creates new form PanelPacCampa
     */
    public PanelPacCampa(Connection conn) {
        this.conn = conn;
        initComponents();
        controlCam = new ControlCampana(conn);
        misCamp = controlCam.listarCampComp(true);
        for(int i = 0; i<misCamp.length; i++){
            cmbCam.addItem(misCamp[i].getNombre());
        }
        this.setResizable(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLogo = new javax.swing.JLabel();
        lblCam = new javax.swing.JLabel();
        cmbCam = new javax.swing.JComboBox();
        lblTiDoc = new javax.swing.JLabel();
        cmbTipoDoc = new javax.swing.JComboBox();
        lblNumeroD = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        btAceptar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("<html>Asignacion de pacientes a campañas<html>");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Formulario para la asignacion de pacientes a campañas");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/logo2.png"))); // NOI18N

        lblCam.setText("Campaña: ");

        lblTiDoc.setText("Documento: ");

        cmbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));

        lblNumeroD.setText("Numero: ");

        btAceptar.setText("Asignar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTiDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumeroD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNum))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCam, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLogo))
                    .addComponent(btAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescripcion))
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCam)
                    .addComponent(cmbCam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiDoc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumeroD)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btAceptar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        String ident;
        ident = cmbTipoDoc.getSelectedItem()+txtNum.getText();
        if(txtNum.getText()==null){
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int resultado = controlCam.asignarPacCam(ident, misCamp[cmbCam.getSelectedIndex()].getCodigoCampana());
            if(resultado>0){
                JOptionPane.showMessageDialog(this, "Paciente asignado exitosamente", "mensaje de confirmacion", JOptionPane.OK_OPTION);
            }else{
                if(resultado==-1){
                    JOptionPane.showMessageDialog(this, "Error al asignar paciente revise los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Error al asignar paciente, si el problema continua contacte al administrador", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_btAceptarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAceptar;
    private javax.swing.JComboBox cmbCam;
    private javax.swing.JComboBox cmbTipoDoc;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCam;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNumeroD;
    private javax.swing.JLabel lblTiDoc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
