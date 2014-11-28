/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import almacenamiento.controlador.*;
import proceso.*;
import java.sql.Connection;

import javax.swing.JOptionPane;
/**
 *
 * @author family
 */
public class Login extends javax.swing.JFrame {
    
    ControlEmpleado ce;
    ControlMedico cm;
    private Connection conn;
    /**
     * Creates new form GestionUsuario
     */
    public Login() {
        initComponents();
        ce=new ControlEmpleado();
        ce.connectDB();
        conn= ce.getConn();
        cm = new ControlMedico(conn);
        this.setTitle("Clínica 2014 Universidad del Valle");
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

        lbCE = new javax.swing.JLabel();
        tfCE = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        lbCon = new javax.swing.JLabel();
        tfCon = new javax.swing.JTextField();
        lbLogo = new javax.swing.JLabel();
        lbEISC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbCE.setText("Correo electrónico");

        tfCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCEActionPerformed(evt);
            }
        });

        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        lbCon.setText("Contraseña");

        tfCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfConActionPerformed(evt);
            }
        });

        lbLogo.setIcon(new javax.swing.ImageIcon("/home/family/Proyectos/ProyectoDB/ClinicaDB/src/presentacion/logo2.png")); // NOI18N

        lbEISC.setText("Escuela de Ingeniería de Sistemas y Computación");

        jLabel2.setText("Universidad del Valle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addComponent(lbEISC)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCE, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(tfCon))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(lbLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(lbCE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(lbCon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbEISC)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCEActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        String email=tfCE.getText();
        String contrasena=tfCon.getText();
        
        Empleado em = ce.readEmpleado(email, 1);
        
        if (em==null){ 
            JOptionPane.showMessageDialog(this, "Lo sentimos ha ocurrido un error en la conexion con la base de datos", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }else{
             if(em.getContrasena()==null || !(em.getContrasena() .equals(contrasena))){
                 JOptionPane.showMessageDialog(this, "Correo electrónico o contraseña invalida", "¡Error!", JOptionPane.ERROR_MESSAGE);
             }else{
                 boolean state = em.getEstado();
                 
                //Validacion de estado de usuario , activo o eliminado
                if(state){
                    String cargo  = em.getCargo();
                    switch(cargo){
                        case "Administrador":
                            System.out.println("admin");
                            break;
                        case "Medico":
                            System.out.println("Medico");
                            Medico me = cm.readMedico(email, 1);
                            break;
                        default:
                            System.out.println("default");
                    }
                 //Caso usuario eliminado   
                }else{
                    JOptionPane.showMessageDialog(this, "Lo sentimos, el usuario "+em.getEmail()+" fue eliminado por el administrador","Contacta al admin",JOptionPane.ERROR_MESSAGE);
                }
             }
             
         }
    }//GEN-LAST:event_btIngresarActionPerformed

    private void tfConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfConActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCE;
    private javax.swing.JLabel lbCon;
    private javax.swing.JLabel lbEISC;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JTextField tfCE;
    private javax.swing.JTextField tfCon;
    // End of variables declaration//GEN-END:variables
}
