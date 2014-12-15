/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.accesodatos.BaseDatos;
import almacenamiento.controlador.ControlGerente;
import almacenamiento.controlador.ControlHistoria;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proceso.Paciente;
import proceso.Registro;

/**
 *
 * @author Alkomprar
 */
public class PanelBusquedaHojasDeVida extends javax.swing.JFrame {
    ControlGerente miGerente;
    ControlHistoria miControlHistoria;
    BaseDatos miBD;
    /**
     * Creates new form PanelBusquedaHojasDeVida
     */
    public PanelBusquedaHojasDeVida() {
        initComponents();
        miBD = new BaseDatos();
        Connection con = miBD.conectar();
        miGerente = new ControlGerente(con);
        miControlHistoria = new ControlHistoria(con);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBusquedaHojasDeVida = new javax.swing.JLabel();
        labelPaciente = new javax.swing.JLabel();
        tfCedulaPaciente = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        panelInformacionGenerla = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        nombrePaciente = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        apellidosPaciente = new javax.swing.JLabel();
        labelCedula = new javax.swing.JLabel();
        cedulaPaciente = new javax.swing.JLabel();
        labelNumeroDeSeguro = new javax.swing.JLabel();
        numeroDeSeguroPaciente = new javax.swing.JLabel();
        labelActividadEconomica = new javax.swing.JLabel();
        labelFechaNacimiento = new javax.swing.JLabel();
        fechaNacimiento = new javax.swing.JLabel();
        actividadEconomicaPaciente = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        telefonoPaciente = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        direccionPaciente = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        estadoPaciente = new javax.swing.JLabel();
        panelRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        labelRegistro = new javax.swing.JLabel();
        labelInformacionGeneral = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelBusquedaHojasDeVida.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelBusquedaHojasDeVida.setText("BUSQUEDA HOJAS DE VIDA");

        labelPaciente.setText("Paciente :");

        tfCedulaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaPacienteActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        panelInformacionGenerla.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        labelNombre.setText("Nombre :");

        labelApellidos.setText("Apellido(s) : ");

        labelCedula.setText("Cedula de Ciudadania : ");

        labelNumeroDeSeguro.setText("Numero de Seguro Social :");

        labelActividadEconomica.setText("Actividad Economica : ");

        labelFechaNacimiento.setText("Fecha de nacimiento : ");

        labelTelefono.setText("Telefono : ");

        labelDireccion.setText("Direccion : ");

        labelEstado.setText("Estado : ");

        javax.swing.GroupLayout panelInformacionGenerlaLayout = new javax.swing.GroupLayout(panelInformacionGenerla);
        panelInformacionGenerla.setLayout(panelInformacionGenerlaLayout);
        panelInformacionGenerlaLayout.setHorizontalGroup(
            panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                        .addComponent(labelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoPaciente))
                    .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                        .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInformacionGenerlaLayout.createSequentialGroup()
                                    .addComponent(labelNumeroDeSeguro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numeroDeSeguroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInformacionGenerlaLayout.createSequentialGroup()
                                    .addComponent(labelNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInformacionGenerlaLayout.createSequentialGroup()
                                    .addComponent(labelCedula)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cedulaPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                                .addComponent(labelTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefonoPaciente)))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                                .addComponent(labelDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(direccionPaciente))
                            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                                .addComponent(labelActividadEconomica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actividadEconomicaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                                .addComponent(labelFechaNacimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                                .addComponent(labelApellidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelInformacionGenerlaLayout.setVerticalGroup(
            panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionGenerlaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(nombrePaciente)
                    .addComponent(labelApellidos)
                    .addComponent(apellidosPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(cedulaPaciente)
                    .addComponent(labelFechaNacimiento)
                    .addComponent(fechaNacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeroDeSeguro)
                    .addComponent(numeroDeSeguroPaciente)
                    .addComponent(labelActividadEconomica)
                    .addComponent(actividadEconomicaPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(telefonoPaciente)
                    .addComponent(labelDireccion)
                    .addComponent(direccionPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInformacionGenerlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado)
                    .addComponent(estadoPaciente))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelRegistros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        panelRegistros.setLayout(new java.awt.GridLayout());

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero Historia", "ID Medico", "Fecha", "Precio", "Causas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaResultados);

        panelRegistros.add(jScrollPane1);

        labelRegistro.setForeground(new java.awt.Color(153, 153, 153));
        labelRegistro.setText("REGISTROS:");

        labelInformacionGeneral.setForeground(new java.awt.Color(153, 153, 153));
        labelInformacionGeneral.setText("INFORMACION GENERAL:");

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInformacionGeneral)
                    .addComponent(labelRegistro)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(labelBusquedaHojasDeVida))
                    .addComponent(panelInformacionGenerla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(labelBusquedaHojasDeVida)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPaciente)
                    .addComponent(botonBuscar)
                    .addComponent(tfCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(labelInformacionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInformacionGenerla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelRegistro)
                .addGap(18, 18, 18)
                .addComponent(panelRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLimpiar)
                    .addComponent(botonSalir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(tfCedulaPaciente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No se ha digitado los datos necesarios para la busqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String cedula = tfCedulaPaciente.getText();
            Paciente miPaciente = miGerente.buscarPaciente(cedula);
            String[] nombresColumnas = {"Identificacion","Nombres","Apellidos","Telefono","Direccion","Numero Social","Actividad Economica","Fecha de nacimiento","Estado"};
            Object[][] datos = {{miPaciente.getIdentificacion(), miPaciente.getNombres(), miPaciente.getApellidos(),miPaciente.getTelefono(), miPaciente.getDireccion(), miPaciente.getNumeroSocial(),miPaciente.getActEcon(), miPaciente.getFechaNac(), miPaciente.getEstado()}};
            cedulaPaciente.setText(miPaciente.getIdentificacion());
            nombrePaciente.setText( miPaciente.getNombres());
            apellidosPaciente.setText( miPaciente.getApellidos());
            telefonoPaciente.setText( miPaciente.getTelefono());
            direccionPaciente.setText( miPaciente.getDireccion());
            numeroDeSeguroPaciente.setText( miPaciente.getNumeroSocial());
            actividadEconomicaPaciente.setText( miPaciente.getActEcon());
            fechaNacimiento.setText( miPaciente.getFechaNac().toString());
            if(miPaciente.getEstado()){
                estadoPaciente.setText("true");
            }else{
                estadoPaciente.setText("false");
            }
            
            Vector<Registro> registrosPaciente = miControlHistoria.consultarRegistros(cedula);
            System.out.println(registrosPaciente.isEmpty());

            DefaultTableModel dfRegistros = new DefaultTableModel();
            tablaResultados.setModel(dfRegistros);
            dfRegistros.setColumnIdentifiers(new Object[] {"Codigo", "Numero Historia", "ID Medico", "Fecha", "Precio", "Causas"});
            for(int i = 0 ; i < registrosPaciente.size(); i++){
                dfRegistros.addRow(new Object[]{registrosPaciente.get(i).getCodigo(),registrosPaciente.get(i).getnumHistoria(),registrosPaciente.get(i).getIdMedico(),registrosPaciente.get(i).getFecha(),registrosPaciente.get(i).getPrecio(), registrosPaciente.get(i).getCausas()});
            }
            
            repaint();
            pack();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tfCedulaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaPacienteActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.hide(); 
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelBusquedaHojasDeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelBusquedaHojasDeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelBusquedaHojasDeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelBusquedaHojasDeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelBusquedaHojasDeVida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actividadEconomicaPaciente;
    private javax.swing.JLabel apellidosPaciente;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel cedulaPaciente;
    private javax.swing.JLabel direccionPaciente;
    private javax.swing.JLabel estadoPaciente;
    private javax.swing.JLabel fechaNacimiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelActividadEconomica;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelBusquedaHojasDeVida;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelInformacionGeneral;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumeroDeSeguro;
    private javax.swing.JLabel labelPaciente;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel nombrePaciente;
    private javax.swing.JLabel numeroDeSeguroPaciente;
    private javax.swing.JPanel panelInformacionGenerla;
    private javax.swing.JPanel panelRegistros;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JLabel telefonoPaciente;
    private javax.swing.JTextField tfCedulaPaciente;
    // End of variables declaration//GEN-END:variables
}
