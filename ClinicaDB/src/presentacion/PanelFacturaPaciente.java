/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.accesodatos.BaseDatos;
import almacenamiento.controlador.ControlGerente;
import almacenamiento.controlador.ControlHistoria;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proceso.Paciente;
import proceso.Registro;

/**
 *
 * @author Alkomprar
 */
public class PanelFacturaPaciente extends javax.swing.JFrame {
    ControlGerente miGerente;
    ControlHistoria miControlHistoria;
    BaseDatos miBD;
    /**
     * Creates new form panelFacturaPaciente
     */
    public PanelFacturaPaciente() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        labelPaciente = new javax.swing.JLabel();
        labelPacienteFac = new javax.swing.JLabel();
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
        labelInformacionGeneral = new javax.swing.JLabel();
        labelFacturas = new javax.swing.JLabel();
        radioButonMes = new javax.swing.JRadioButton();
        radioButonAnio = new javax.swing.JRadioButton();
        comboMeses = new javax.swing.JComboBox();
        tfAnioMes = new javax.swing.JTextField();
        labelMes = new javax.swing.JLabel();
        labelAnioMes = new javax.swing.JLabel();
        labelAnio = new javax.swing.JLabel();
        tfAnio = new javax.swing.JTextField();
        labelResultados = new javax.swing.JLabel();
        panelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonLimpiar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        cbTipoId = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelPaciente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelPaciente.setText("FACTURAS  PACIENTE");

        labelPacienteFac.setText("Paciente : ");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        labelInformacionGeneral.setForeground(new java.awt.Color(153, 153, 153));
        labelInformacionGeneral.setText("INFORMACION GENERAL:");

        labelFacturas.setForeground(new java.awt.Color(153, 153, 153));
        labelFacturas.setText("FACTURA(S) PACIENTE:");

        radioButonMes.setText(" Listar por mes");
        radioButonMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButonMesActionPerformed(evt);
            }
        });

        radioButonAnio.setText(" Listar por año");
        radioButonAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButonAnioActionPerformed(evt);
            }
        });

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        comboMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesesActionPerformed(evt);
            }
        });

        tfAnioMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAnioMesActionPerformed(evt);
            }
        });

        labelMes.setText("Mes : ");

        labelAnioMes.setText("Año : ");

        labelAnio.setText("Año : ");

        tfAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAnioActionPerformed(evt);
            }
        });

        labelResultados.setForeground(new java.awt.Color(153, 153, 153));
        labelResultados.setText("RESULTADOS: ");

        panelResultados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Costos por Formula", "Costos por Cita"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelResultadosLayout.setVerticalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C.C", "T.I", "C.E", "R.C" }));

        jLabel1.setText("Numero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelResultados)
                    .addComponent(labelFacturas)
                    .addComponent(labelInformacionGeneral)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButonMes)
                            .addComponent(radioButonAnio))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAnio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAnio))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAnioMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAnioMes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelResultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInformacionGenerla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelPaciente)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPacienteFac)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel1)
                                    .addGap(37, 37, 37)
                                    .addComponent(tfCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelPaciente)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPacienteFac)
                    .addComponent(tfCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInformacionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacionGenerla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelFacturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButonMes)
                        .addComponent(tfAnioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMes)
                        .addComponent(labelAnioMes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButonAnio)
                    .addComponent(labelAnio)
                    .addComponent(tfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(botonLimpiar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(tfCedulaPaciente.getText().isEmpty() && ((tfAnioMes.getText().isEmpty()&& radioButonMes.isSelected())|| (tfAnio.getText().isEmpty()&& radioButonAnio.isSelected()))){
            JOptionPane.showMessageDialog(this, "No se ha digitado los datos necesarios para la busqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Double[] resultado = new Double[2];
            String cedula = tfCedulaPaciente.getText();
            String tipo = cbTipoId.getSelectedItem().toString();
            String identificacion = tipo+cedula;
            Paciente miPaciente = miGerente.buscarPaciente(identificacion);
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
            
            if(radioButonAnio.isSelected()){
                
                String anio = tfAnio.getText();
                System.out.println("consultara anio");
                resultado = miControlHistoria.contularCostosAnio(cedula,anio);
            }else{
                if(radioButonMes.isSelected()){
                    String anio = tfAnioMes.getText();
                    String mes = comboMeses.getSelectedItem().toString();
                    if(mes.equals("Enero")){ mes = "01";}
                    if(mes.equals("Febrero")){ mes = "02";}
                    if(mes.equals("Marzo")){ mes = "03";}
                    if(mes.equals("Abril")){ mes = "04";}
                    if(mes.equals("Mayo")){ mes = "05";}
                    if(mes.equals("Junio")){ mes = "06";}
                    if(mes.equals("Julio")){ mes = "07";}
                    if(mes.equals("Agosto")){ mes = "08";}
                    if(mes.equals("Septiembre")){ mes = "09";}
                    if(mes.equals("Octubre")){ mes = "10";}
                    if(mes.equals("Noviembre")){ mes = "11";}
                    if(mes.equals("Diciembre")){ mes = "12";}
                    System.out.println("consultara mes");
                    resultado = miControlHistoria.contularCostosAnioMes(cedula, anio,  mes);
                    
                }
                    
            }
            
            DefaultTableModel dfRegistros = new DefaultTableModel();
            dfRegistros.setColumnIdentifiers(new Object[] {"Costos por Formula", "Costos por Citas"});
            dfRegistros.addRow(new Object[]{resultado[0],resultado[1]});
            }            
            repaint();
            pack();
      
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void radioButonMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButonMesActionPerformed
        radioButonAnio.setSelected(false);
    }//GEN-LAST:event_radioButonMesActionPerformed

    private void radioButonAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButonAnioActionPerformed
        radioButonMes.setSelected(false);
    }//GEN-LAST:event_radioButonAnioActionPerformed

    private void comboMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMesesActionPerformed

    private void tfAnioMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnioMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAnioMesActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void tfAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAnioActionPerformed

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
            java.util.logging.Logger.getLogger(PanelFacturaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelFacturaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelFacturaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelFacturaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelFacturaPaciente().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actividadEconomicaPaciente;
    private javax.swing.JLabel apellidosPaciente;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cbTipoId;
    private javax.swing.JLabel cedulaPaciente;
    private javax.swing.JComboBox comboMeses;
    private javax.swing.JLabel direccionPaciente;
    private javax.swing.JLabel estadoPaciente;
    private javax.swing.JLabel fechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelActividadEconomica;
    private javax.swing.JLabel labelAnio;
    private javax.swing.JLabel labelAnioMes;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelFacturas;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelInformacionGeneral;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumeroDeSeguro;
    private javax.swing.JLabel labelPaciente;
    private javax.swing.JLabel labelPacienteFac;
    private javax.swing.JLabel labelResultados;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel nombrePaciente;
    private javax.swing.JLabel numeroDeSeguroPaciente;
    private javax.swing.JPanel panelInformacionGenerla;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JRadioButton radioButonAnio;
    private javax.swing.JRadioButton radioButonMes;
    private javax.swing.JLabel telefonoPaciente;
    private javax.swing.JTextField tfAnio;
    private javax.swing.JTextField tfAnioMes;
    private javax.swing.JTextField tfCedulaPaciente;
    // End of variables declaration//GEN-END:variables
}
