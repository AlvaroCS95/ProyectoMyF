/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeProveedores;
import Modelos.Proveedor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class IngresarProveedor extends javax.swing.JDialog {

    String Nombre, Correo, Direccion, Telefono, Cedula;
    public IngresarProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLimpiar_IngresarProveedor = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        txtDireccion_IngresarProveedor = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtTelefono_IngresarProveedor = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtNombre_IngresarProveedor = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtCorreo_IngresarProveedor = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtCedulaJuridica_IngresarProveedor = new javax.swing.JTextField();
        btAceptar_IngresarProveedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btLimpiar_IngresarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarProveedor.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarProveedorActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel57.setText("Ingreso de proveedores");

        txtDireccion_IngresarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDireccion_IngresarProveedor.setForeground(new java.awt.Color(0, 102, 102));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Insertar.png"))); // NOI18N

        txtTelefono_IngresarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTelefono_IngresarProveedor.setForeground(new java.awt.Color(0, 102, 102));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setAlignmentX(5.0F);

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel60.setText("Teléfono");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setText("Nombre");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel58.setText("Dirección");

        txtNombre_IngresarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombre_IngresarProveedor.setForeground(new java.awt.Color(0, 102, 102));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setText("Corréo");

        txtCorreo_IngresarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCorreo_IngresarProveedor.setForeground(new java.awt.Color(0, 102, 102));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel59.setText("Cedúla juridica");

        txtCedulaJuridica_IngresarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedulaJuridica_IngresarProveedor.setForeground(new java.awt.Color(0, 102, 102));

        btAceptar_IngresarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarProveedor.setToolTipText("Oprimir para guardar proveedor");
        btAceptar_IngresarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(72, 72, 72)
                                .addComponent(txtNombre_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(77, 77, 77)
                                .addComponent(txtCorreo_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtCedulaJuridica_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addGap(62, 62, 62)
                                        .addComponent(txtDireccion_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtTelefono_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btLimpiar_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAceptar_IngresarProveedor))))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel57))
                    .addComponent(jLabel56))
                .addGap(24, 24, 24)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(txtCorreo_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(txtCedulaJuridica_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel58))
                            .addComponent(txtDireccion_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono_IngresarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpiar_IngresarProveedor)
                        .addGap(49, 49, 49)
                        .addComponent(btAceptar_IngresarProveedor)
                        .addGap(70, 70, 70))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void Limpiar() {
        txtCedulaJuridica_IngresarProveedor.setText("");
        txtCorreo_IngresarProveedor.setText("");
        txtDireccion_IngresarProveedor.setText("");
        txtNombre_IngresarProveedor.setText("");
        txtTelefono_IngresarProveedor.setText("");

    }
public boolean VerificaCamposVacios() {
        if (txtCedulaJuridica_IngresarProveedor.getText().equals("")
                || txtCorreo_IngresarProveedor.getText().equals("")
                || txtDireccion_IngresarProveedor.getText().equals("")
                || txtNombre_IngresarProveedor.getText().equals("")
                || txtTelefono_IngresarProveedor.getText().equals("")) {
            return true;
        } else {
            return false;
        }

    }
public void IngresarProveedor() throws ClassNotFoundException {
        if (VerificaCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");

        } else {
            Nombre = txtNombre_IngresarProveedor.getText();
            Cedula = txtCedulaJuridica_IngresarProveedor.getText();
            Correo = txtCorreo_IngresarProveedor.getText();
            Direccion = txtDireccion_IngresarProveedor.getText();
            Telefono = txtTelefono_IngresarProveedor.getText();
            CoordinadorDeProveedores elCoordinadorDeProveedores = new CoordinadorDeProveedores();
            Proveedor elProveedor = new Proveedor(Nombre, Direccion, Correo, Cedula, Telefono);
            if (elCoordinadorDeProveedores.InsertarProveedor(elProveedor) == true) {
                JOptionPane.showMessageDialog(null, "Proveedor insertado con exito");
                Limpiar();
                ListarProveedor.VisualizarProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "Fallo en la inserción ");
            }

        }
    }

    private void btLimpiar_IngresarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarProveedorActionPerformed
        Limpiar();        // TODO add your handling code here:
    }//GEN-LAST:event_btLimpiar_IngresarProveedorActionPerformed

    private void btAceptar_IngresarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarProveedorActionPerformed
        try {
            IngresarProveedor();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAceptar_IngresarProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarProveedor;
    public static javax.swing.JButton btLimpiar_IngresarProveedor;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JSeparator jSeparator7;
    public static javax.swing.JTextField txtCedulaJuridica_IngresarProveedor;
    public static javax.swing.JTextField txtCorreo_IngresarProveedor;
    public static javax.swing.JTextField txtDireccion_IngresarProveedor;
    public static javax.swing.JTextField txtNombre_IngresarProveedor;
    public static javax.swing.JTextField txtTelefono_IngresarProveedor;
    // End of variables declaration//GEN-END:variables
}
