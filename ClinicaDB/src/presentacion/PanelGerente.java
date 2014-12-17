/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlArea;
import almacenamiento.controlador.ControlEmpleado;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JOptionPane;
import proceso.Area;
import proceso.Empleado;

/**
 *
 * @author Alkomprar
 */
public class PanelGerente extends javax.swing.JFrame {
    VistaCrearArea vca;
    Connection conn;
    ControlArea ca;
    ControlEmpleado controlEmp;
    
    /**
     * Creates new form PanelGerente
     * @param conn conexion
     */
    public PanelGerente(Connection conn,ControlEmpleado ce) {
        this.conn=conn;
        ca =  new ControlArea(conn);
        controlEmp = ce;
        initComponents();
        setResizable(false);
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
        jPanel1 = new javax.swing.JPanel();
        botonBuscarHojasDeVida = new javax.swing.JButton();
        botonFacturaPaciente = new javax.swing.JButton();
        butonEmpleadosPorAreas = new javax.swing.JButton();
        botonCitas = new javax.swing.JButton();
        botonAgenda = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        labelReporte = new javax.swing.JLabel();
        labelGestionDeArea = new javax.swing.JLabel();
        labelPanelGerente = new javax.swing.JLabel();
        labelBinvenido = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        botonBuscarHojasDeVida.setText("Buscar Historia Clinica");
        botonBuscarHojasDeVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarHojasDeVidaActionPerformed(evt);
            }
        });

        botonFacturaPaciente.setText("Factura Paciente");
        botonFacturaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacturaPacienteActionPerformed(evt);
            }
        });

        butonEmpleadosPorAreas.setText("Empleados por Areas");
        butonEmpleadosPorAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonEmpleadosPorAreasActionPerformed(evt);
            }
        });

        botonCitas.setText("Numero de Citas Atendidas ");
        botonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCitasActionPerformed(evt);
            }
        });

        botonAgenda.setText("Agenda de un Medico");
        botonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonFacturaPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBuscarHojasDeVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butonEmpleadosPorAreas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(botonBuscarHojasDeVida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFacturaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonEmpleadosPorAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        botonCrear.setText("Crear");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        labelReporte.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelReporte.setForeground(new java.awt.Color(153, 153, 153));
        labelReporte.setText("Reportes");

        labelGestionDeArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelGestionDeArea.setForeground(new java.awt.Color(153, 153, 153));
        labelGestionDeArea.setText("Gestion de Area");

        labelPanelGerente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelPanelGerente.setText("PANEL GERENTE");

        labelBinvenido.setText("Bienvenido ");

        botonCerrarSesion.setForeground(new java.awt.Color(153, 153, 153));
        botonCerrarSesion.setText("Cerrar Sesion");
        botonCerrarSesion.setBorderPainted(false);
        botonCerrarSesion.setContentAreaFilled(false);
        botonCerrarSesion.setFocusPainted(false);
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(labelReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelGestionDeArea)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonCerrarSesion))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelPanelGerente)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelBinvenido)
                        .addGap(231, 231, 231))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCerrarSesion)
                .addGap(15, 15, 15)
                .addComponent(labelPanelGerente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBinvenido)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelReporte)
                    .addComponent(labelGestionDeArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarHojasDeVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarHojasDeVidaActionPerformed
        PanelBusquedaHojasDeVida pbh = new PanelBusquedaHojasDeVida(conn);
        pbh.setVisible(true);
    }//GEN-LAST:event_botonBuscarHojasDeVidaActionPerformed

    private void botonFacturaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturaPacienteActionPerformed
        PanelFacturaPaciente pn = new PanelFacturaPaciente();
        pn.setVisible(true);
    }//GEN-LAST:event_botonFacturaPacienteActionPerformed

    private void butonEmpleadosPorAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonEmpleadosPorAreasActionPerformed
        // TODO add your handling code here:
        Area[] areas = ca.listArea();
        Vector<Empleado[]> empleados = controlEmp.listEmpleadoPorArea();
        panelListarAreas empleadosXArea= new panelListarAreas(areas, empleados);
        empleadosXArea.setVisible(true);
        
    }//GEN-LAST:event_butonEmpleadosPorAreasActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        vca = new VistaCrearArea(conn,1);
        vca.setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(ca.listArea().length== 0){
            JOptionPane.showMessageDialog(null, "No hay áreas para eliminar","", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            vca = new VistaCrearArea(conn,3);
            vca.setVisible(true);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        if(ca.listArea().length== 0){
            JOptionPane.showMessageDialog(null, "No hay áreas para editar","", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            vca = new VistaCrearArea(conn,2);
            vca.setVisible(true);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCitasActionPerformed
        // TODO add your handling code here:
        panelNumeroCitas panelCantidadCitas = new panelNumeroCitas(conn);
        panelCantidadCitas.setVisible(true);
        
    }//GEN-LAST:event_botonCitasActionPerformed

    private void botonAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgendaActionPerformed
        // TODO add your handling code here:
        PanelAgenda agendaMedico = new PanelAgenda(conn);
        agendaMedico.setVisible(true);
        
    }//GEN-LAST:event_botonAgendaActionPerformed

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelGerente().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgenda;
    private javax.swing.JButton botonBuscarHojasDeVida;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonCitas;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFacturaPaciente;
    private javax.swing.JButton butonEmpleadosPorAreas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelBinvenido;
    private javax.swing.JLabel labelGestionDeArea;
    private javax.swing.JLabel labelPanelGerente;
    private javax.swing.JLabel labelReporte;
    // End of variables declaration//GEN-END:variables
}
