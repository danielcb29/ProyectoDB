/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlPaciente;
import java.sql.Connection;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import proceso.Paciente;

/**
 *
 * @author alvaromartinez
 */
public class PanelCrearPaciente extends javax.swing.JFrame {

    
    private ControlPaciente controladorPaciente;
    private Connection conn;
    /**
     * Creates new form PanelCrearPaciente
     */
    public PanelCrearPaciente(Connection connPadre) {
        conn = connPadre;
        controladorPaciente = new ControlPaciente(conn);
        initComponents();
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
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        lblIdent = new javax.swing.JLabel();
        jComboBoxId = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        textNumeroId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSegSoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtActEcon = new javax.swing.JTextField();
        lblDir = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblFecNac = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jButCrear = new javax.swing.JButton();
        jButCanc = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Crear Paciente");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Formulario de la creación de pacientes");

        lblNombres.setText("Nombres:");

        lblApellidos.setText("Apellidos:");

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        lblTelefono.setText("Telefono:");

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });

        lblIdent.setText("Identificacion:");

        jComboBoxId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));
        jComboBoxId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero: ");

        textNumeroId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumeroIdActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Seguro Social: ");

        txtSegSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegSocActionPerformed(evt);
            }
        });

        jLabel3.setText("Actividad Economica: ");

        txtActEcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActEconActionPerformed(evt);
            }
        });

        lblDir.setText("Direccion: ");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblFecNac.setText("Fecha Nacimiento: ");

        jDateChooserFecha.setDoubleBuffered(false);
        jDateChooserFecha.setRequestFocusEnabled(false);
        jDateChooserFecha.setVerifyInputWhenFocusTarget(false);

        jButCrear.setText("Crear");
        jButCrear.setMaximumSize(new java.awt.Dimension(74, 30));
        jButCrear.setMinimumSize(new java.awt.Dimension(74, 30));
        jButCrear.setPreferredSize(new java.awt.Dimension(74, 30));
        jButCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCrearActionPerformed(evt);
            }
        });

        jButCanc.setText("Cancelar");
        jButCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCancActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/logo2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButCanc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblDir)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblNombres)
                                    .addComponent(jLabel3)
                                    .addComponent(lblFecNac)
                                    .addComponent(lblApellidos)
                                    .addComponent(lblIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSegSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtActEcon)
                                    .addComponent(textNumeroId)
                                    .addComponent(jComboBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo)))
                .addGap(32, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdent)
                    .addComponent(jComboBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDir)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSegSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtActEcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFecNac)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButCanc)
                    .addComponent(jButCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void jComboBoxIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIdActionPerformed

    private void textNumeroIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumeroIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumeroIdActionPerformed

    private void txtSegSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegSocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegSocActionPerformed

    private void txtActEconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActEconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActEconActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void jButCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCrearActionPerformed
        
        String identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono;
        Date fechaNac;

        identificacion = jComboBoxId.getSelectedItem() + textNumeroId.getText();
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        telefono = txtTelefono.getText();
        direccion = txtDir.getText();
        numeroSegSocial = txtSegSoc.getText();
        actividadEcono = txtActEcon.getText();
        fechaNac = jDateChooserFecha.getDate();

        if (validarInfo(identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono, fechaNac)) {
            Paciente nuevoPaciente = new Paciente(identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono, fechaNac, true);
            int resultado = controladorPaciente.crearPaciente(nuevoPaciente);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(this, "Paciente creado", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                if (resultado == -2) {
                    JOptionPane.showMessageDialog(this, "Por favor revise la información del paciente, ya que la identificacion ya existe en la base de datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al crear el usuario, si el problema persiste contacte al administrador", "Mensaje de error", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error, exiten campos vacios por favor revise que todos los campos esten completos");
        }

        
    }//GEN-LAST:event_jButCrearActionPerformed

    private void jButCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButCancActionPerformed
        dispose();
    }//GEN-LAST:event_jButCancActionPerformed


    
    private boolean validarInfo(String identificacion, String nombres, String apellidos, 
                                String telefono, String direccion, String numeroSegSocial, String actividadEcono,
                                Date fechaNac){
        return !((identificacion.length()==0)||(nombres.length()==0)||(apellidos.length()==0)||(telefono.length()==0)
                ||(direccion.length()==0)||(numeroSegSocial.length()==0)||(actividadEcono.length()==0)||(fechaNac== null));
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButCanc;
    private javax.swing.JButton jButCrear;
    private javax.swing.JComboBox jComboBoxId;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblFecNac;
    private javax.swing.JLabel lblIdent;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField textNumeroId;
    private javax.swing.JTextField txtActEcon;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSegSoc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
