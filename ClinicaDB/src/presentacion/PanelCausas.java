/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlCausa;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proceso.Causa;

/**
 *
 * @author daniel
 */
public class PanelCausas extends javax.swing.JFrame {

    private ControlCausa controlCausa;
    private String[] nomCausas;
    private Causa[] causas;
    private int tipo;
    private Causa seleccionada;
    /**
     * Creates new form PanelCausas
     */
    public PanelCausas(int tipo, Connection conn) {
        super("Gestion de Causas");
        setResizable(false);
        initComponents();
        controlCausa = new ControlCausa(conn);
        this.tipo=tipo;
        if(tipo==1){
            //Crear
            lbDescrip.setText("Este modulo le permite crear causas en el sistema");
            //lbInfoCausa.setVisible(false);
            //cbCausas.setVisible(false);
            lbInfoCausa.disable();
            cbCausas.disable();
            btProceso.setText("Crear");
            lbEstado.setVisible(false);
            cbEstado.setVisible(false);
            
        }else{
            btProceso.setEnabled(false);
            mostrarCausas();
            if(tipo==2){
                //Editar
                lbTtitulo.setText("Registro de Causas: Editar");
                lbDescrip.setText("Este modulo le permite editar causas en el sistema");
                btProceso.setText("Editar");
                lbEstado.setVisible(false);
                cbEstado.setVisible(false);
            }else{
                if(tipo==3){
                    //Eliminar
                    lbTtitulo.setText("Registro de Causas: Eliminar");
                    lbDescrip.setText("Este modulo le eliminar causas en el sistema");
                    btProceso.setText("Eliminar");
                    lbEstado.setVisible(false);
                    cbEstado.setVisible(false);
                    tfNombre.setEditable(false);
                    taDescrip.setEditable(false);
                    
                }
            }
        }
    }
    public int tamCausas(){
        return causas.length;
    }
    private void mostrarCausas(){
        if(tipo==2){
            causas = controlCausa.listarCausas(false);
        }else{
            causas = controlCausa.listarCausas(true);
        }
        
        int longitud=causas.length;
        nomCausas=new String[longitud];
        for(int i=0; i<longitud; i++){
            String nombre=causas[i].getNombre();
            System.out.println(nombre);
            nomCausas[i]=nombre;
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

        lbTtitulo = new javax.swing.JLabel();
        lbDescrip = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbInfoCausa = new javax.swing.JLabel();
        cbCausas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescrip = new javax.swing.JTextArea();
        btCancel = new javax.swing.JButton();
        btProceso = new javax.swing.JButton();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        tfNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTtitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lbTtitulo.setText("Registro de Causas: Crear");

        lbDescrip.setText("Este modulo le permite ");

        lbInfoCausa.setText("Causas: ");

        cbCausas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCausasActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Descripcion: ");

        taDescrip.setColumns(20);
        taDescrip.setRows(5);
        jScrollPane1.setViewportView(taDescrip);

        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btProceso.setText("Guardar");
        btProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcesoActionPerformed(evt);
            }
        });

        lbEstado.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btProceso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancel)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescrip)
                            .addComponent(lbTtitulo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfNombre))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbInfoCausa)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbTtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInfoCausa)
                    .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancel)
                            .addComponent(btProceso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEstado)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void cbCausasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCausasActionPerformed
        // TODO add your handling code here:
        btProceso.setEnabled(true);
        int index = cbCausas.getSelectedIndex();
        seleccionada = causas[index];
        String nombre = seleccionada.getNombre();
        String descripcion = seleccionada.getDescripcion();
        
        
        tfNombre.setText(nombre);
        taDescrip.setText(descripcion);
        boolean estado = seleccionada.getEstado();
        if(tipo==2 && estado==false){
            lbEstado.setVisible(true);
            cbEstado.setVisible(true);
            cbEstado.addItem("Inactivo");
            cbEstado.addItem("Activo");
            
        }
        
        
        
        
                
    }//GEN-LAST:event_cbCausasActionPerformed
    private boolean validarVacios(){
        if(tfNombre.getText().length() == 0 || taDescrip.getText().length()==0){
            return true;
        }else{
            return false;
        }
        
    }
    private void btProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesoActionPerformed
        // TODO add your handling code here:
        if(validarVacios()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios , no se puede procesar","Error",JOptionPane.ERROR_MESSAGE);
            
        }else{
            String nombre = tfNombre.getText();
            String descrip = taDescrip.getText();
            Causa nuevaCausa = new Causa(nombre, descrip);
            if(tipo==1){
                //crear
                
                int result = controlCausa.crearCausa(nuevaCausa);
                if(result==1){
                    JOptionPane.showMessageDialog(this, "Causa registrada exitosamente","Regitro Existoso",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Ocurrio un error , no se puede procesar\nVuelve a intentarlo","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(tipo==2){
                    //editar
                    String exCausa = seleccionada.getNombre();
                    
                    if(!seleccionada.getEstado()){
                            Object item = cbEstado.getSelectedItem();
                            String value = item.toString();
                            
                            if(value.equals("Inactivo")){
                                nuevaCausa.setEstado(false);
                                
                            }else{
                                nuevaCausa.setEstado(true);
                            }
                        }else{
                            nuevaCausa.setEstado(true);
                        }
                    int result = controlCausa.actualizarCausa(exCausa, nuevaCausa);
                    if(result==1){
                        JOptionPane.showMessageDialog(this, "Causa Actualizada exitosamente","Regitro Existoso",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Ocurrio un error , no se puede procesar\nVuelve a intentarlo","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                    
                }else{
                    if(tipo==3){
                        //eliminar
                        
                        int result = controlCausa.eliminarCausa(nombre);
                        if(result==1){
                            JOptionPane.showMessageDialog(this, "Causa Eliminada exitosamente","Regitro Existoso",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(this, "Ocurrio un error , no se puede procesar\nVuelve a intentarlo","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        dispose();
        
        
    }//GEN-LAST:event_btProcesoActionPerformed

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
            java.util.logging.Logger.getLogger(PanelCausas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelCausas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelCausas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelCausas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         *//*
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PanelCausas().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btProceso;
    private javax.swing.JComboBox cbCausas;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDescrip;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbInfoCausa;
    private javax.swing.JLabel lbTtitulo;
    private javax.swing.JTextArea taDescrip;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
