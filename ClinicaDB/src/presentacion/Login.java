/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import almacenamiento.controlador.*;
import proceso.*;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JOptionPane;
/**
 *
 * @author family
 */
public class Login extends javax.swing.JFrame {
    
    private ControlEmpleado ce;
    private ControlMedico cm;
    private ControlEnfermera cEnf;
    private Connection conn;
    private String email;
    private String contrasena;
    private VistaAdmin va;
    private PanelBodega pb;
    private PanelMedico pm;
    private PanelEnfermera pEnf;
    private PanelGerente pg;
    private PanelSecretaria pSec;
    /**
     * Creates new form GestionUsuario
     */
    public Login() {
        email="";
        contrasena="";
        initComponents();
        ce=new ControlEmpleado();
        ce.connectDB();
        conn= ce.getConn();
        cm = new ControlMedico(conn);
        cEnf = new ControlEnfermera(conn);
        
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
        lbLogo = new javax.swing.JLabel();
        lbEISC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        tfCon = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbCE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCE.setForeground(new java.awt.Color(153, 153, 153));
        lbCE.setText("Correo electrónico:");

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

        lbCon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCon.setForeground(new java.awt.Color(153, 153, 153));
        lbCon.setText("Contraseña:");

        lbEISC.setText("Escuela de Ingeniería de Sistemas y Computación");

        jLabel2.setText("Universidad del Valle");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbEISC)
                        .addGap(56, 56, 56))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(lbCon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)
                                .addGap(112, 112, 112)
                                .addComponent(lbLogo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfCon, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(tfCE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lbCE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(tfCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbEISC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCEActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        email=tfCE.getText();
        contrasena=tfCon.getText();
        
        Empleado em = ce.readEmpleado(email, 1,0);
        
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
                            Vector<Empleado[]> todosEms =ce.listEmpleadoPorArea();
                            for(int i= 0; i<todosEms.size(); i++){
                                Empleado[] emInterno = todosEms.get(i);
                                //System.out.println(emInterno[0].getArea().getNombre());
                                for(int j=0;j<emInterno.length;j++){
                                    System.out.println(emInterno[j].getEmail());
                                }
                                
                            }
                            va=new VistaAdmin(ce);
                            va.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
                            break;
                        case "Medico":
                            System.out.println("Medico");
                            Medico me1 = cm.readMedico(em);
                            System.out.println("dentro de la vista1" + me1.getNombres());
                            pm = new PanelMedico(conn, me1);
                            pm.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
                            break;
                        case "Enfermera":
                            System.out.println("Medico");
                            Enfermera enf1 = cEnf.readEnfermera(em);
                            System.out.println("dentro de la vista1" + enf1.getNombres());
                            pEnf= new PanelEnfermera(conn);
                            pEnf.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
                            break;
                        case "Bodeguero":
                            System.out.println("Bodeguero");
                            pb = new PanelBodega(conn, em.getNombres());
                            pb.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
                            break;
                        case "Gerente":
                            System.out.println("Gerente");
                            pg = new PanelGerente(conn,ce);
                            pg.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
                            break;
                        case "Secretaria":
                            System.out.println("Secretaria");
                            pSec = new PanelSecretaria(conn);
                            pSec.setVisible(true);
                            this.setEnabled(false);
                            this.dispose();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCE;
    private javax.swing.JLabel lbCon;
    private javax.swing.JLabel lbEISC;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JTextField tfCE;
    private javax.swing.JPasswordField tfCon;
    // End of variables declaration//GEN-END:variables
}
