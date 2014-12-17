/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlCampana;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import proceso.Campana;
import proceso.Medico;

/**
 *
 * @author daniel
 */
public class PanelCampana extends javax.swing.JFrame {

    private Medico medico;
    private Connection conn;
    private ControlCampana controlador;
    private int tipo;
    private Campana[] campanas;
    private Campana seleccionada;
    private String[] nomCampanas;
    private Date fecha;
    private boolean estadoCambioFecha = false; //permite saber si se desea cambiar la fecha
    private Date fechaNueva;
            
    /**
     * Creates new form PanelCampana
     */
    public PanelCampana(int tipo,Medico doctor,Connection conn) {
        super("Panel de Gestion de Campañas");
        initComponents();
        setResizable(false);
        medico=doctor;
        this.conn=conn;
        controlador = new ControlCampana(conn);
        this.tipo=tipo;
        fecha = new Date();
        lbFecha.setText(fecha.toString());
        if(tipo==1){
            //crear
            lbBuscar.setVisible(false);
            cbCampanas.setVisible(false);
            btAccion.setText("Crear");
            lbEstado.setVisible(false);
            cbEstado.setVisible(false);
            chbCambiarFecha.setVisible(false);
            lbNewHoy.setVisible(false);
        }else{
            btAccion.setEnabled(false);
            mostrarCampanas();
            if(tipo==2){
                //editar
                lbTitulo.setText("Gestion de Campañas: Editar");
                lbMensaje.setText("Este modulo le permite realizar la gestion de campañas, para esta caso : editar");
                lbEstado.setVisible(false);
                cbEstado.setVisible(false);
                chbCambiarFecha.setEnabled(false);
                btAccion.setText("Editar");
            }else{
                //eliminar
                lbTitulo.setText("Gestion de Campañas: Eliminar");
                lbMensaje.setText("Este modulo le permite realizar la gestion de campañas, para esta caso : eliminar");
                tfNombre.setEnabled(false);
                taObjetivo.setEnabled(false);
                lbEstado.setVisible(false);
                cbEstado.setVisible(false);
                chbCambiarFecha.setVisible(false);
                lbNewHoy.setVisible(false);
                btAccion.setText("Eliminar");
            }
            
        }
    }
    public int tamCampanas(){
        return campanas.length;
    }
    private void mostrarCampanas(){
        if(tipo==2){
            campanas = controlador.listarCampanasMedico(false,medico);
        }else{
            campanas = controlador.listarCampanasMedico(true,medico);
        }
        
        int longitud=campanas.length;
        nomCampanas=new String[longitud];
        for(int i=0; i<longitud; i++){
            String nombre=campanas[i].getNombre();
            System.out.println(nombre);
            nomCampanas[i]=nombre;
        }
        cbCampanas.setModel(new javax.swing.DefaultComboBoxModel(nomCampanas));
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
        lbMensaje = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbBuscar = new javax.swing.JLabel();
        cbCampanas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObjetivo = new javax.swing.JTextArea();
        btAccion = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        chbCambiarFecha = new javax.swing.JCheckBox();
        lbNewHoy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        lbTitulo.setText("Registro de Campañas");

        lbMensaje.setText("Este modulo le permite realizar la gestion de campañas, para esta caso : accion");

        lbBuscar.setText("Campaña :");

        cbCampanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCampanasActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre :");

        jLabel5.setText("Fecha :");

        lbFecha.setText("hoy");

        jLabel7.setText("Objetivo: ");

        taObjetivo.setColumns(20);
        taObjetivo.setRows(5);
        jScrollPane1.setViewportView(taObjetivo);

        btAccion.setText("Accion");
        btAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAccionActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbEstado.setText("Estado:");

        chbCambiarFecha.setText("Cambiar fecha a hoy:");
        chbCambiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCambiarFechaActionPerformed(evt);
            }
        });

        lbNewHoy.setText("newHoy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chbCambiarFecha)
                                .addGap(18, 18, 18)
                                .addComponent(lbNewHoy))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lbFecha)
                                .addGap(119, 119, 119)
                                .addComponent(lbEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNombre))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCampanas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMensaje)
                            .addComponent(jLabel7))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensaje)
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBuscar)
                    .addComponent(cbCampanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbFecha)
                    .addComponent(lbEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbCambiarFecha)
                    .addComponent(lbNewHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAccion))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbCampanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCampanasActionPerformed
        // TODO add your handling code here:
        btAccion.setEnabled(true);
        chbCambiarFecha.setEnabled(true);
        int index = cbCampanas.getSelectedIndex();
        seleccionada = campanas[index];
        String nombre = seleccionada.getNombre();
        String objetivo = seleccionada.getObjetivo();
        String fecha = seleccionada.getFecha().toString();
        
        
        tfNombre.setText(nombre);
        taObjetivo.setText(objetivo);
        lbFecha.setText(fecha);
        
        fechaNueva = new Date();
        lbNewHoy.setText(fechaNueva.toString());
        
        boolean estado = seleccionada.getEstado();
        if(tipo==2 && estado==false){
            lbEstado.setVisible(true);
            cbEstado.setVisible(true);
            cbEstado.addItem("Inactivo");
            cbEstado.addItem("Activo");
            
        }
        
    }//GEN-LAST:event_cbCampanasActionPerformed

    private boolean validarVacios(){
        if(tfNombre.getText().length() == 0 || taObjetivo.getText().length()==0){
            return true;
        }else{
            return false;
        }
        
    }
    private void btAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAccionActionPerformed
        // TODO add your handling code here:
        if(validarVacios()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios , no se puede procesar","Error",JOptionPane.ERROR_MESSAGE);
            
        }else{
            String nombre = tfNombre.getText();
            String objetivo = taObjetivo.getText();
            Campana nuevaCampana = new Campana(fecha, nombre, objetivo, medico);
            if(tipo==1){
                //crear
                
                int result = controlador.crearCampana(nuevaCampana);
                if(result==1){
                    JOptionPane.showMessageDialog(this, "Campaña registrada exitosamente","Regitro Existoso",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Ocurrio un error , no se puede procesar\nVuelve a intentarlo","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(tipo==2){
                    //editar
                    //String exCampana = seleccionada.getNombre();
                    
                    if(!seleccionada.getEstado()){
                            Object item = cbEstado.getSelectedItem();
                            String value = item.toString();
                            
                            if(value.equals("Inactivo")){
                                nuevaCampana.setEstado(false);
                                
                            }
                    }
                    
                    if(estadoCambioFecha){
                        nuevaCampana.setFecha(fechaNueva);
                    }
                    int result = controlador.actualizarCampana(seleccionada, nuevaCampana);
                    if(result==1){
                        JOptionPane.showMessageDialog(this, "Causa Actualizada exitosamente","Regitro Existoso",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Ocurrio un error , no se puede procesar\nVuelve a intentarlo","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                    
                }else{
                    if(tipo==3){
                        //eliminar
                        
                        int result = controlador.eliminarCampana(seleccionada);
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
    }//GEN-LAST:event_btAccionActionPerformed

    private void chbCambiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCambiarFechaActionPerformed
        // TODO add your handling code here:
        estadoCambioFecha = chbCambiarFecha.isSelected();
    }//GEN-LAST:event_chbCambiarFechaActionPerformed

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelCampana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelCampana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelCampana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelCampana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelCampana().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccion;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox cbCampanas;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JCheckBox chbCambiarFecha;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JLabel lbNewHoy;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextArea taObjetivo;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
