/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.sql.Connection;

/**
 *
 * @author alvaromartinez
 */
public class PanelSecretaria extends javax.swing.JFrame {

    
    PanelCrearPaciente panelCreaPaciente;
    PanelCRUDCitas panelCitas;
    PanelElimModificarPaciente panelElimModPaciente;
   private Connection conn;
    /**
     * Creates new form PanelSecretaria
     */
    public PanelSecretaria(Connection connPad) {
        conn = connPad;
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

        lbTitulo = new javax.swing.JLabel();
        infoPanel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tituPaci = new javax.swing.JLabel();
        btModfPac = new javax.swing.JButton();
        btEliminarPac = new javax.swing.JButton();
        btAsigCit = new javax.swing.JButton();
        tituloCita = new javax.swing.JLabel();
        btCrearPac = new javax.swing.JButton();
        btCancelarCitas = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btCerrarSe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 350));
        setResizable(false);

        lbTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lbTitulo.setText("Bienvenido");

        infoPanel.setText("En este panel usted podra gestionar la información de los pacientes y sus citas");

        jSeparator1.setMaximumSize(new java.awt.Dimension(290, 290));

        tituPaci.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        tituPaci.setText("Gestion de Pacientes");

        btModfPac.setText("Modificar");
        btModfPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModfPacActionPerformed(evt);
            }
        });

        btEliminarPac.setText("Eliminar");
        btEliminarPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarPacActionPerformed(evt);
            }
        });

        btAsigCit.setText("Asignar");
        btAsigCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAsigCitActionPerformed(evt);
            }
        });

        tituloCita.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        tituloCita.setText("Gestion de Citas");

        btCrearPac.setText("Crear");
        btCrearPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearPacActionPerformed(evt);
            }
        });

        btCancelarCitas.setText("Cancelar");
        btCancelarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarCitasActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/logo2.png"))); // NOI18N

        btCerrarSe.setText("Cerrar sesion");
        btCerrarSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEliminarPac, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(tituPaci, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(74, 74, 74))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btCrearPac, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(92, 92, 92)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btModfPac, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(92, 92, 92)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btCancelarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAsigCit, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tituloCita, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitulo)
                                    .addComponent(infoPanel))
                                .addGap(59, 59, 59)
                                .addComponent(lblLogo))
                            .addComponent(btCerrarSe)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituPaci)
                    .addComponent(tituloCita))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCrearPac)
                    .addComponent(btAsigCit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btModfPac)
                    .addComponent(btCancelarCitas))
                .addGap(18, 18, 18)
                .addComponent(btEliminarPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCerrarSe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModfPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModfPacActionPerformed
        panelElimModPaciente = new PanelElimModificarPaciente(conn, 1);
        panelElimModPaciente.setVisible(true);
        
    }//GEN-LAST:event_btModfPacActionPerformed

    private void btEliminarPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarPacActionPerformed
        panelElimModPaciente = new PanelElimModificarPaciente(conn, 2);
        panelElimModPaciente.setVisible(true);
    }//GEN-LAST:event_btEliminarPacActionPerformed

    private void btAsigCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAsigCitActionPerformed
        panelCitas = new PanelCRUDCitas(1, conn);
        panelCitas.setVisible(true);
    }//GEN-LAST:event_btAsigCitActionPerformed

    private void btCrearPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearPacActionPerformed
        panelCreaPaciente = new PanelCrearPaciente(conn);
        panelCreaPaciente.setVisible(true);
    }//GEN-LAST:event_btCrearPacActionPerformed

    private void btCancelarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarCitasActionPerformed
        panelCitas = new PanelCRUDCitas(2, conn);
        panelCitas.setVisible(true);
    }//GEN-LAST:event_btCancelarCitasActionPerformed

    private void btCerrarSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarSeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAsigCit;
    private javax.swing.JButton btCancelarCitas;
    private javax.swing.JButton btCerrarSe;
    private javax.swing.JButton btCrearPac;
    private javax.swing.JButton btEliminarPac;
    private javax.swing.JButton btModfPac;
    private javax.swing.JLabel infoPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel tituPaci;
    private javax.swing.JLabel tituloCita;
    // End of variables declaration//GEN-END:variables
}
