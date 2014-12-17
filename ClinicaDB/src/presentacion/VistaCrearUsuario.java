/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.ControlArea;
import almacenamiento.controlador.ControlEmpleado;
import almacenamiento.controlador.ControlEnfermera;
import almacenamiento.controlador.ControlMedico;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proceso.Area;
import proceso.Empleado;

/**
 *
 * @author family
 */
public class VistaCrearUsuario extends javax.swing.JFrame {
    
    ControlEmpleado ce;
    ControlMedico cm;
    ControlEnfermera cEnf;
    ControlArea ca;
    Connection conn;

    /**
     * Creates new form VistaCrearUsuario
     * @param controlEm control del empleado
     */
    public VistaCrearUsuario(ControlEmpleado controlEm) {
        initComponents();
        
        ce=controlEm;
        conn=ce.getConn();
        cm= new ControlMedico(conn);
        cEnf = new ControlEnfermera(conn);
        ca = new ControlArea(conn);
        
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.setResizable(false);
        lbIdJ.setVisible(false);
        tfIdJ.setVisible(false);
        lbAnos.setVisible(false);
        comboAnos.setVisible(false);
        lbNL.setVisible(false);
        tfNL.setVisible(false);
        lbEspecialidad.setVisible(false);
        tfEspecialidad.setVisible(false);
        lbUniversidad.setVisible(false);
        tfUniversidad.setVisible(false);
        lbHabs1.setVisible(false);
        lbHabs2.setVisible(false);
        jScrollPane3.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        lbIdentificacion = new javax.swing.JLabel();
        tfIdentificacion = new javax.swing.JTextField();
        lbNombres = new javax.swing.JLabel();
        tfNombres = new javax.swing.JTextField();
        tfApellidos = new javax.swing.JTextField();
        lbApellidos = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        lbSalario = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        comboCargo = new javax.swing.JComboBox();
        lbCargo = new javax.swing.JLabel();
        lbArea = new javax.swing.JLabel();
        tfCE = new javax.swing.JTextField();
        lbCE = new javax.swing.JLabel();
        lbContrasena = new javax.swing.JLabel();
        cbAJ = new javax.swing.JCheckBox();
        lbIdJ = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbAnos = new javax.swing.JLabel();
        comboAnos = new javax.swing.JComboBox();
        lbNL = new javax.swing.JLabel();
        lbEspecialidad = new javax.swing.JLabel();
        lbUniversidad = new javax.swing.JLabel();
        tfContrasena = new javax.swing.JTextField();
        tfUniversidad = new javax.swing.JTextField();
        tfNL = new javax.swing.JTextField();
        tfEspecialidad = new javax.swing.JTextField();
        tfArea = new javax.swing.JTextField();
        tfIdJ = new javax.swing.JTextField();
        lbHabs1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taHabs = new javax.swing.JTextArea();
        lbHabs2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(715, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(660, 1125));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("<html>Aquí encontrará el formulario de creación de usuarios. Seleccione el cargo para empezar a digitar los datos.</html>");

        lbIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbIdentificacion.setText("Identificación:");

        tfIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdentificacionActionPerformed(evt);
            }
        });

        lbNombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNombres.setText("Nombres:");

        lbApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbApellidos.setText("Apellidos:");

        lbTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTelefono.setText("Teléfono:");

        lbDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDireccion.setText("Dirección:");

        lbSalario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSalario.setText("Salario:");

        comboCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerente", "Medico", "Enfermera", "Secretaria", "Bodeguero", "Administrador" }));
        comboCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCargoItemStateChanged(evt);
            }
        });
        comboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargoActionPerformed(evt);
            }
        });

        lbCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCargo.setText("Cargo:");

        lbArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbArea.setText("Código de área:");

        lbCE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCE.setText("Correo electrónico:");

        lbContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbContrasena.setText("Contraseña:");

        cbAJ.setText("¿Asignar Jefe?");
        cbAJ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAJItemStateChanged(evt);
            }
        });
        cbAJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAJActionPerformed(evt);
            }
        });

        lbIdJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbIdJ.setText("Identificación del Jefe:");
        lbIdJ.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tfIdJComponentHidden(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setPreferredSize(new java.awt.Dimension(72, 29));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbAnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAnos.setText("Años experiencia:");

        comboAnos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "67", "68", "69", "70" }));

        lbNL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNL.setText("Numero de Licencia:");

        lbEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEspecialidad.setText("Especialidad:");

        lbUniversidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUniversidad.setText("Universidad:");

        tfContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContrasenaActionPerformed(evt);
            }
        });

        tfUniversidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUniversidadActionPerformed(evt);
            }
        });

        tfNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNLActionPerformed(evt);
            }
        });

        tfEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEspecialidadActionPerformed(evt);
            }
        });

        lbHabs1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHabs1.setText("Habilidades:");

        taHabs.setColumns(20);
        taHabs.setRows(5);
        taHabs.setBorder(null);
        jScrollPane3.setViewportView(taHabs);

        lbHabs2.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        lbHabs2.setText("<html>Por cada salto de línea se cuenta una habilidad distinta.</html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdJ)
                            .addComponent(lbCargo)
                            .addComponent(lbUniversidad)
                            .addComponent(lbEspecialidad)
                            .addComponent(lbNL)
                            .addComponent(lbAnos)
                            .addComponent(cbAJ))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSalario)
                                    .addComponent(lbDireccion))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbTelefono)
                                            .addComponent(lbIdentificacion)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbApellidos)
                                                .addComponent(lbNombres))
                                            .addComponent(lbCE)
                                            .addComponent(lbContrasena)
                                            .addComponent(lbArea)
                                            .addComponent(lbHabs1)
                                            .addComponent(lbHabs2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfApellidos)
                                            .addComponent(tfTelefono)
                                            .addComponent(tfDireccion)
                                            .addComponent(tfSalario)
                                            .addComponent(tfCE)
                                            .addComponent(tfContrasena)
                                            .addComponent(tfArea)
                                            .addComponent(tfIdJ)
                                            .addComponent(tfNL)
                                            .addComponent(tfEspecialidad)
                                            .addComponent(tfUniversidad)
                                            .addComponent(comboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfIdentificacion)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(comboAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(tfNombres)))
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdentificacion)
                    .addComponent(tfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombres)
                    .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidos)
                    .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefono)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSalario)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContrasena)
                    .addComponent(tfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbArea)
                    .addComponent(tfArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbAJ)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdJ)
                    .addComponent(tfIdJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCargo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAnos)
                    .addComponent(comboAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNL)
                    .addComponent(tfNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEspecialidad)
                    .addComponent(tfEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUniversidad)
                    .addComponent(tfUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lbHabs1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHabs2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jScrollPane1.setViewportView(jPanel1);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("Crear Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdJComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tfIdJComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdJComponentHidden

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //Se declara objeto de la clase usuario
        String identificacion=tfIdentificacion.getText();
        String nombres=tfNombres.getText();
        String apellidos=tfApellidos.getText();
        String telefono=tfTelefono.getText();
        String direccion=tfDireccion.getText();
        String salario= tfSalario.getText();
        String email= tfCE.getText();
        String contrasena=tfContrasena.getText();
        String codigoArea = tfArea.getText();
        String jefe;
        if(cbAJ.isSelected()){
            jefe=tfIdJ.getText();
        }else{
            jefe="-1";
        }
        String numLic="";
        String especialidad="";
        String universidad = "";
        int anosExperiencia=0;
        String habs[] = null;
        int cCargo =  comboCargo.getSelectedIndex();
        switch(cCargo){
            case 1://Medico
                numLic = tfNL.getText();
                especialidad = tfEspecialidad.getText();
                universidad = tfUniversidad.getText();
                break;
            case 2: //Enfermera
                anosExperiencia = comboAnos.getSelectedIndex();
                habs = taHabs.getText().split("\n");
                break;
        }
        String cargo = comboCargo.getSelectedItem().toString();
        
        boolean empty = validateInformation(identificacion, nombres, apellidos, telefono, direccion, salario, email, contrasena, jefe);
        
        if (empty){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Empleado em;
            Area ar;
            try{
                if(cCargo!=5) ar = ca.readArea(Integer.parseInt(codigoArea));
                else ar=null;
                
            
                if(cCargo!=5 && (ar==null || !ar.getEstado())){
                    JOptionPane.showMessageDialog(this, "Posiblemente estas ingresando un código de un área que no existe o fue desactivada.","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                
                    int result;
                    //Se instancia la clase controlador para hacer uso de ella
                    switch(cCargo){
                        case 1: //Medico
                            if(especialidad.trim().length()!=0 || universidad.trim().length()!=0){
                                result= cm.createMedico(identificacion, nombres, apellidos, telefono, direccion, Integer.parseInt(salario), email, cargo, contrasena, jefe, ar, true, Integer.parseInt(numLic), especialidad, universidad, 0);
                            }else{
                                result = -3;
                            }
                            break;
                        case 2: //Enfermera
                            if(habs.length!=0){
                                result= cEnf.createEnfermera(identificacion, nombres, apellidos, telefono, direccion, Integer.parseInt(salario), email, cargo, contrasena, jefe, ar, true, anosExperiencia, habs, 0);
                            }else{
                                result =-3;
                            }
                            break;
                        default: 
                            result = ce.createEmpleado(identificacion, nombres, apellidos, telefono, direccion, Integer.parseInt(salario), email, cargo, contrasena, jefe, ar, true);
                    }
                    if(result == -1 || result == -2){
                        JOptionPane.showMessageDialog(this, "Posiblemente estas ingresando a una persona que ya existe \nIntenta ingresar a una persona diferente (identificacion y/o correo electrónico diferente)\nSi el problema persiste ha ocurrido un error en la base de datos,consulta al personal encargado","Error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(result== -3){//para campos vacíos de enfermera o médico
                            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            //Se imprime el mensaje para informar el exito de la operacion
                            JOptionPane.showMessageDialog(this, "El usuario "+ nombres+" se ha creado con éxito", "Mensaje de éxito",JOptionPane.INFORMATION_MESSAGE);
                            //Cerramos la ventana
                            this.dispose();
                        }
                    }
                
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "El código del área, el salario y número de licencia, en caso del médico, deben ser números enteros.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed
    public boolean validateInformation(String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9){
        return (d1.trim().length()==0 || d2.trim().length()==0 || d3.trim().length()==0|| d4.trim().length()==0|| d5.trim().length()==0|| d6.trim().length()==0|| d7.trim().length()==0|| d8.trim().length()==0|| d9.trim().length()==0);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbAJItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAJItemStateChanged
        if(cbAJ.isSelected()){
            lbIdJ.setVisible(true);
            tfIdJ.setVisible(true);
        }else{
            lbIdJ.setVisible(false);
            tfIdJ.setVisible(false);
        }
    }//GEN-LAST:event_cbAJItemStateChanged

    private void comboCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCargoItemStateChanged
        switch(comboCargo.getSelectedIndex()){
            case 1://Médico
                tfArea.setEditable(true);
                lbAnos.setVisible(false);
                comboAnos.setVisible(false);
                lbNL.setVisible(true);
                tfNL.setVisible(true);
                lbEspecialidad.setVisible(true);
                tfEspecialidad.setVisible(true);
                lbUniversidad.setVisible(true);
                tfUniversidad.setVisible(true);
                lbHabs1.setVisible(false);
                lbHabs2.setVisible(false);
                jScrollPane3.setVisible(false);
                break;
            case 2://Enfermera
                tfArea.setEditable(true);
                lbAnos.setVisible(true);
                comboAnos.setVisible(true);
                lbNL.setVisible(false);
                tfNL.setVisible(false);
                lbEspecialidad.setVisible(false);
                tfEspecialidad.setVisible(false);
                lbUniversidad.setVisible(false);
                tfUniversidad.setVisible(false);
                lbHabs1.setVisible(true);
                lbHabs2.setVisible(true);
                jScrollPane3.setVisible(true);
                break;
            case 5:
                tfArea.setText("");
                tfArea.setEditable(false);
                lbAnos.setVisible(false);
                comboAnos.setVisible(false);
                lbNL.setVisible(false);
                tfNL.setVisible(false);
                lbEspecialidad.setVisible(false);
                tfEspecialidad.setVisible(false);
                lbUniversidad.setVisible(false);
                tfUniversidad.setVisible(false);
                lbHabs1.setVisible(false);
                lbHabs2.setVisible(false);
                jScrollPane3.setVisible(false);
            default:
                tfArea.setEditable(true);
                lbAnos.setVisible(false);
                comboAnos.setVisible(false);
                lbNL.setVisible(false);
                tfNL.setVisible(false);
                lbEspecialidad.setVisible(false);
                tfEspecialidad.setVisible(false);
                lbUniversidad.setVisible(false);
                tfUniversidad.setVisible(false);
                lbHabs1.setVisible(false);
                lbHabs2.setVisible(false);
                jScrollPane3.setVisible(false);
        }
    }//GEN-LAST:event_comboCargoItemStateChanged

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCargoActionPerformed

    private void tfContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContrasenaActionPerformed

    private void tfUniversidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUniversidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUniversidadActionPerformed

    private void tfNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNLActionPerformed

    private void tfEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEspecialidadActionPerformed

    private void cbAJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAJActionPerformed

    private void tfIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdentificacionActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JCheckBox cbAJ;
    private javax.swing.JComboBox comboAnos;
    private javax.swing.JComboBox comboCargo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAnos;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbArea;
    private javax.swing.JLabel lbCE;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbEspecialidad;
    private javax.swing.JLabel lbHabs1;
    private javax.swing.JLabel lbHabs2;
    private javax.swing.JLabel lbIdJ;
    private javax.swing.JLabel lbIdentificacion;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNL;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbSalario;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbUniversidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea taHabs;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfArea;
    private javax.swing.JTextField tfCE;
    private javax.swing.JTextField tfContrasena;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEspecialidad;
    private javax.swing.JTextField tfIdJ;
    private javax.swing.JTextField tfIdentificacion;
    private javax.swing.JTextField tfNL;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfUniversidad;
    // End of variables declaration//GEN-END:variables

}
