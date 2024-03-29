/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import almacenamiento.controlador.ControlMedico;
import almacenamiento.controlador.ControlEmpleado;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author family
 */
public class VistaAdmin extends javax.swing.JFrame {
    ControlEmpleado ce;
    Connection conn;
    VistaCrearUsuario cvu;
    VistaEditarUsuario veu;
    
    /**
     * Creates new form GestionUsuarios
     * @param controlEm control de empleado (usuario)
     */
    public VistaAdmin(ControlEmpleado controlEm) {
        initComponents();
        this.setTitle("Panel Administrador");
        ce= controlEm;
        conn = ce.getConn();
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

        lbBienvenido = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbSubGu = new javax.swing.JLabel();
        lbGU = new javax.swing.JLabel();
        btCrearUsuario = new javax.swing.JButton();
        btEditarUsuario = new javax.swing.JButton();
        btEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbBienvenido.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbBienvenido.setText("Bienvenido");

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        lbSubGu.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbSubGu.setForeground(new java.awt.Color(102, 102, 102));
        lbSubGu.setText("<html><i> Recuerde que para crear usuarios debe haber creado como mínimo un área</i></html>");

        lbGU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGU.setText("Gestión de usuarios");

        btCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCrearUsuario.setText("Crear Usuario");
        btCrearUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearUsuarioActionPerformed(evt);
            }
        });

        btEditarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/edit-user-icon.png"))); // NOI18N
        btEditarUsuario.setText("Editar Usuario");
        btEditarUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarUsuarioActionPerformed(evt);
            }
        });

        btEliminarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/delete-user-icon.png"))); // NOI18N
        btEliminarUsuario.setText("Eliminar Usuario");
        btEliminarUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSubGu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lbGU)))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbBienvenido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbBienvenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGU)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubGu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearUsuarioActionPerformed
        // TODO add your handling code here:
        cvu = new VistaCrearUsuario(ce);
        cvu.setVisible(true);
    }//GEN-LAST:event_btCrearUsuarioActionPerformed

    private void btEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarUsuarioActionPerformed
        // TODO add your handling code here:

        if(ce.listEmpleado().length== 0){
            JOptionPane.showMessageDialog(null, "No hay Usuarios para editar","", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            veu = new VistaEditarUsuario(ce, 1);
            veu.setVisible(true);
        }
    }//GEN-LAST:event_btEditarUsuarioActionPerformed

    private void btEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        if(ce.listEmpleado().length== 0){
            JOptionPane.showMessageDialog(null, "No hay Usuarios para eliminar","", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //System.out.println("Por ahora no se ha implementado :)");
            veu = new VistaEditarUsuario(ce,2);
            veu.setVisible(true);
        }
    }//GEN-LAST:event_btEliminarUsuarioActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        ce.cerrarConexionBD();
        System.exit(0); 
    }//GEN-LAST:event_btSalirActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCrearUsuario;
    private javax.swing.JButton btEditarUsuario;
    private javax.swing.JButton btEliminarUsuario;
    private javax.swing.JButton btSalir;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbGU;
    private javax.swing.JLabel lbSubGu;
    // End of variables declaration//GEN-END:variables
}
