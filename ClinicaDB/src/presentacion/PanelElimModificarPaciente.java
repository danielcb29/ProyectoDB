/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlPaciente;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import proceso.Paciente;

/**
 *
 * @author cenesis
 */
public class PanelElimModificarPaciente extends javax.swing.JFrame {

    
    private ControlPaciente controladorPaciente;
    private Connection conn;
    String oper;
    int tipo;
    /**
     * Creates new form PanelModificarPaciente
     */
    public PanelElimModificarPaciente(Connection connPadre, int tipo) {
        this.conn = connPadre;
        controladorPaciente = new ControlPaciente(conn);
        initComponents();
        this.tipo=tipo;
        
        if(tipo==2){
            oper = "eliminar";
            lblTitulo.setText("Eliminar Paciente");
            lblDescripcion.setText("Formulario para la eliminación de pacientes");
            lbInfo.setText("Busque el paciente a eliminar por cedula, confirme antes de cualquier operación");
            txtNombres.setEditable(false);
            txtApellidos.setEditable(false);
            txtDir.setEditable(false);
            txtTelefono.setEditable(false);
            txtSegSoc.setEditable(false);
            txtActEcon.setEditable(false);
            jDateChooserFecha.setEnabled(false);
            jComboEstado.setEnabled(false);
            jButtMod.setText("Eliminar");
            
        }else{
            oper= "modificar";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdent = new javax.swing.JLabel();
        jComboBoxId = new javax.swing.JComboBox();
        textNumeroId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLogo = new javax.swing.JLabel();
        lblIdent1 = new javax.swing.JLabel();
        jComboBoxId1 = new javax.swing.JComboBox();
        textNumeroId1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblDir = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSegSoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtActEcon = new javax.swing.JTextField();
        lblFecNac = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jButtBuscar = new javax.swing.JButton();
        jButtMod = new javax.swing.JButton();
        jButCanc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox();

        lblIdent.setText("Identificacion:");

        jComboBoxId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));
        jComboBoxId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIdActionPerformed(evt);
            }
        });

        textNumeroId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumeroIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Modificar Paciente");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Formulario para la modificación de pacientes");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/logo2.png"))); // NOI18N

        lblIdent1.setText("Identificacion:");

        jComboBoxId1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));
        jComboBoxId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxId1ActionPerformed(evt);
            }
        });

        textNumeroId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumeroId1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero: ");

        lbInfo.setText("Busque el paciente a editar, haga las ediciones y guarde para modificar");

        lblNombres.setText("Nombres:");

        lblApellidos.setText("Apellidos:");

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        lblTelefono.setText("Telefono:");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblDir.setText("Direccion: ");

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Seguro Social: ");

        txtSegSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegSocActionPerformed(evt);
            }
        });

        jLabel4.setText("Actividad Economica: ");

        txtActEcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActEconActionPerformed(evt);
            }
        });

        lblFecNac.setText("Fecha Nacimiento: ");

        jDateChooserFecha.setDoubleBuffered(false);
        jDateChooserFecha.setRequestFocusEnabled(false);
        jDateChooserFecha.setVerifyInputWhenFocusTarget(false);

        jButtBuscar.setText("Buscar");
        jButtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtBuscarActionPerformed(evt);
            }
        });

        jButtMod.setText("Modificar");
        jButtMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtModActionPerformed(evt);
            }
        });

        jButCanc.setText("Cancelar");
        jButCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButCancActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(115, 115, 115))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(lblDir)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblNombres)
                                            .addComponent(lblApellidos)
                                            .addComponent(lblTelefono))
                                        .addComponent(jLabel4))
                                    .addGap(41, 41, 41))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblFecNac)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButCanc, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDir, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSegSoc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtActEcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                                .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblIdent1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBoxId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textNumeroId1))
                                .addComponent(lbInfo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescripcion))
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdent1)
                    .addComponent(jComboBoxId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textNumeroId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtBuscar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSegSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtActEcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecNac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtMod)
                    .addComponent(jButCanc)
                    .addComponent(jLabel5)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIdActionPerformed

    private void textNumeroIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumeroIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumeroIdActionPerformed

    private void jComboBoxId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxId1ActionPerformed

    private void textNumeroId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumeroId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumeroId1ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void txtSegSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegSocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegSocActionPerformed

    private void txtActEconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActEconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActEconActionPerformed

    private void jButtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtBuscarActionPerformed
        Paciente conPaciente = controladorPaciente.leerPaciente(jComboBoxId1.getSelectedItem() + textNumeroId1.getText());
        if (conPaciente == null) {
            JOptionPane.showMessageDialog(this, "El paciente buscado no existe, por favor revise el documento", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String estado="";
            if(conPaciente.getEstado()){
                estado = "Activo";
            }else{
                estado = "Inactivo";
            }
            txtNombres.setText(conPaciente.getNombres());
            txtApellidos.setText(conPaciente.getApellidos());
            txtDir.setText(conPaciente.getDireccion());
            txtTelefono.setText(conPaciente.getTelefono());
            txtSegSoc.setText(conPaciente.getNumeroSocial());
            txtActEcon.setText(conPaciente.getActEcon());
            jDateChooserFecha.setDate(conPaciente.getFechaNac());
            jComboEstado.setSelectedItem(estado);
        }
    }//GEN-LAST:event_jButtBuscarActionPerformed

    private void jButtModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtModActionPerformed
        String identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono;
        boolean estado;
        int resultado = 0;
        Date fechaNac;
        identificacion = jComboBoxId.getSelectedItem() + textNumeroId1.getText();
        if (tipo == 1) {

            nombres = txtNombres.getText();
            apellidos = txtApellidos.getText();
            telefono = txtTelefono.getText();
            direccion = txtDir.getText();
            numeroSegSocial = txtSegSoc.getText();
            actividadEcono = txtActEcon.getText();
            fechaNac = jDateChooserFecha.getDate();
            if (jComboEstado.getSelectedItem().toString().equalsIgnoreCase("Activo")) {
                estado = true;
            } else {
                estado = false;
            }
            System.out.println(identificacion);

            if (validarInfo(identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono, fechaNac)) {
                Paciente modPaciente = new Paciente(identificacion, nombres, apellidos, telefono, direccion, numeroSegSocial, actividadEcono, fechaNac, true);
                resultado = controladorPaciente.actualizarPaciente(identificacion, modPaciente);

            } else {
                JOptionPane.showMessageDialog(this, "Error, exiten campos vacios por favor revise que todos los campos esten completos");
            }

        } else {
            resultado = controladorPaciente.eliminarPaciente(identificacion);
        }
        if (resultado > 0) {
            JOptionPane.showMessageDialog(this, "Operacion de " + oper + "  exitosa", "Mensaje de confirmacion", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            if (resultado == -2) {
                JOptionPane.showMessageDialog(this, "Por favor revise la información del paciente", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al " + oper + " el usuario, si el problema persiste contacte al administrador", "Mensaje de error", JOptionPane.ERROR_MESSAGE);

            }
        }

        
    }//GEN-LAST:event_jButtModActionPerformed

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
    private javax.swing.JButton jButtBuscar;
    private javax.swing.JButton jButtMod;
    private javax.swing.JComboBox jComboBoxId;
    private javax.swing.JComboBox jComboBoxId1;
    private javax.swing.JComboBox jComboEstado;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblFecNac;
    private javax.swing.JLabel lblIdent;
    private javax.swing.JLabel lblIdent1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField textNumeroId;
    private javax.swing.JTextField textNumeroId1;
    private javax.swing.JTextField txtActEcon;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSegSoc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
