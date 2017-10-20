/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import Modelos.Cliente;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class IngresarClientes extends javax.swing.JDialog {

   String Cedula,
            PrimerNombre,
            SegundoNombre,
            PrimerApellido,
            SegundoApellido,
            Direccion,
            NombreLocal,
            NivelDeCliente;
    public IngresarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       
        initComponents();
         setLocationRelativeTo(null);
         cerrar();
    }

  
    @SuppressWarnings("unchecked")
    public void cerrar(){
addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                 int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            ListarUsuarios.panel=false;
            dispose();
        }
            }
        });
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtPrimerNombre_IngresarCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSegundoNombre_IngresarCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrimerApellido_IngresarCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSegundoApellido_IngresarCliente = new javax.swing.JTextField();
        txtCedula_IngresarCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion_IngresarCliente = new javax.swing.JTextField();
        cbxNivel_IngresarCliente = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btAceptar_IngresarCliente = new javax.swing.JButton();
        btLimpiar_IngresarCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNombreLocal_IngresarCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Ingreso de clientes");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/list_add_user.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setAlignmentX(5.0F);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Primer nombre");

        txtPrimerNombre_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerNombre_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Segundo nombre");

        txtSegundoNombre_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoNombre_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Primer apellido");

        txtPrimerApellido_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerApellido_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Segundo apellido");

        txtSegundoApellido_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoApellido_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        txtCedula_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedula_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Cedúla");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Dirección");

        txtDireccion_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDireccion_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        cbxNivel_IngresarCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "★", "★★", "★★★", "★★★★", "★★★★★" }));
        cbxNivel_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivel_IngresarClienteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Nivel de cliente");

        btAceptar_IngresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarCliente.setToolTipText("Oprimir para guardar cliente");
        btAceptar_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarClienteActionPerformed(evt);
            }
        });

        btLimpiar_IngresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarCliente.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarClienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Nombre local");

        txtNombreLocal_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreLocal_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(btLimpiar_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btAceptar_IngresarCliente)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 26, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(jLabel12)
                            .addGap(287, 287, 287)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel3)
                            .addGap(43, 43, 43)
                            .addComponent(txtPrimerNombre_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(jLabel8)
                            .addGap(79, 79, 79)
                            .addComponent(txtPrimerApellido_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(38, 38, 38)
                            .addComponent(txtSegundoNombre_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)
                            .addComponent(jLabel7)
                            .addGap(71, 71, 71)
                            .addComponent(txtSegundoApellido_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(97, 97, 97)
                            .addComponent(txtCedula_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(jLabel10)
                            .addGap(113, 113, 113)
                            .addComponent(txtDireccion_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(46, 46, 46)
                            .addComponent(cbxNivel_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(jLabel14)
                            .addGap(91, 91, 91)
                            .addComponent(txtNombreLocal_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 27, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAceptar_IngresarCliente)
                    .addComponent(btLimpiar_IngresarCliente))
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel12))
                        .addComponent(jLabel13))
                    .addGap(15, 15, 15)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(txtPrimerNombre_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel8))
                        .addComponent(txtPrimerApellido_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel6))
                        .addComponent(txtSegundoNombre_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtSegundoApellido_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel9))
                        .addComponent(txtCedula_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel10))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(txtDireccion_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxNivel_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreLocal_IngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel14))))
                    .addGap(0, 104, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void LimpiarCampos() {
        txtCedula_IngresarCliente.setText("");
        txtPrimerNombre_IngresarCliente.setText("");
        txtSegundoNombre_IngresarCliente.setText("");
        txtPrimerApellido_IngresarCliente.setText("");
        txtSegundoApellido_IngresarCliente.setText("");
        txtDireccion_IngresarCliente.setText("");
        txtNombreLocal_IngresarCliente.setText("");
    }

 public boolean VerificarCamposVacios() {

        if (txtPrimerNombre_IngresarCliente.getText().equals("")
               
                || txtPrimerApellido_IngresarCliente.getText().equals("")
                || txtSegundoApellido_IngresarCliente.getText().equals("")
                || txtCedula_IngresarCliente.getText().equals("")
                || txtDireccion_IngresarCliente.getText().equals("")
                || txtNombreLocal_IngresarCliente.getText().equals("")) {

            return true;
        }
        return false;
    }
  public void IngresarCliente() {
        if (VerificarCamposVacios() == true) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            return;
        } else {
            try {
                Cedula = txtCedula_IngresarCliente.getText();
                PrimerNombre = txtPrimerNombre_IngresarCliente.getText();
                SegundoNombre = txtSegundoNombre_IngresarCliente.getText();
                PrimerApellido = txtPrimerApellido_IngresarCliente.getText();
                SegundoApellido = txtSegundoApellido_IngresarCliente.getText();
                Direccion = txtDireccion_IngresarCliente.getText();
                NombreLocal = txtNombreLocal_IngresarCliente.getText();

                CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();
                Cliente elCliente = new Cliente(NivelDeCliente, Direccion, Cedula, NombreLocal, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido);
                if (elCoordinadorDeClientes.AgregarCliente(elCliente) == true) {
                    JOptionPane.showMessageDialog(null, "Cliente insertado exitosamente");
                    LimpiarCampos();
                    ListarClientes.VisualizarClientes(TablaListarClientes_ListarClientes); 

                } else {
                    JOptionPane.showMessageDialog(null, "Error en la inserción");
                }
            } catch (Exception e) {
            }
        }
    }
    private void cbxNivel_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivel_IngresarClienteActionPerformed
        if (cbxNivel_IngresarCliente.getSelectedItem().equals("★")) {
            NivelDeCliente = "Uno";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("★★")) {
            NivelDeCliente = "Dos";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("★★★")) {
            NivelDeCliente = "Tres";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("★★★★")) {
            NivelDeCliente = "Cuatro";
        } else {
            NivelDeCliente = "Cinco";
        }
    }//GEN-LAST:event_cbxNivel_IngresarClienteActionPerformed

    private void btAceptar_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarClienteActionPerformed
        IngresarCliente();
    }//GEN-LAST:event_btAceptar_IngresarClienteActionPerformed

    private void btLimpiar_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarClienteActionPerformed
        LimpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btLimpiar_IngresarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarCliente;
    public static javax.swing.JButton btLimpiar_IngresarCliente;
    public static javax.swing.JComboBox cbxNivel_IngresarCliente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextField txtCedula_IngresarCliente;
    public static javax.swing.JTextField txtDireccion_IngresarCliente;
    public javax.swing.JTextField txtNombreLocal_IngresarCliente;
    public static javax.swing.JTextField txtPrimerApellido_IngresarCliente;
    public static javax.swing.JTextField txtPrimerNombre_IngresarCliente;
    public static javax.swing.JTextField txtSegundoApellido_IngresarCliente;
    public static javax.swing.JTextField txtSegundoNombre_IngresarCliente;
    // End of variables declaration//GEN-END:variables
}
