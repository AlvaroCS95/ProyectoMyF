/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeProveedores;
import Modelos.Proveedor;
import static UI.BuscarProveedores.BuscarProveedor;
import static UI.BuscarProveedores.txtCedulaABuscar_BuscarProveedor;
import UI.ListarProveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarProveedor extends javax.swing.JDialog {

    String Cedula, Nombre, Direccion, Telefono, Correo;

    public EditarProveedor(java.awt.Frame parent, boolean modal, String cedula, String nombre, String direccion, String correo, String telefono) {
        super(parent, modal);
        initComponents();
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Correo = correo;
        this.Telefono = telefono;
        setLocationRelativeTo(null);
        cargarDatos();
        cerrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        txtCorreo_EditarProveedor = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtCedulaJuridica_EditarProveedor = new javax.swing.JTextField();
        btAceptar_EditarProveedor = new javax.swing.JButton();
        btLimpiar_EditarProveedor = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        txtDireccion_EditarProveedor = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtTelefono_EditarProveedor = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtNombre_EditarProveedor = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCorreo_EditarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCorreo_EditarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtCorreo_EditarProveedor.setToolTipText("Muestra correo.");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel59.setText("Cedúla juridica");

        txtCedulaJuridica_EditarProveedor.setEditable(false);
        txtCedulaJuridica_EditarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedulaJuridica_EditarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtCedulaJuridica_EditarProveedor.setToolTipText("Muestra cédula del proveedor.");
        txtCedulaJuridica_EditarProveedor.setEnabled(false);

        btAceptar_EditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarProveedor.setToolTipText("Oprimir para guardar proveedor");
        btAceptar_EditarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAceptar_EditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarProveedorActionPerformed(evt);
            }
        });

        btLimpiar_EditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_EditarProveedor.setToolTipText("Oprima para limpiar campos");
        btLimpiar_EditarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel57.setText("Editar de proveedor");

        txtDireccion_EditarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDireccion_EditarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtDireccion_EditarProveedor.setToolTipText("Muestra dirección.");

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setAlignmentX(5.0F);

        txtTelefono_EditarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTelefono_EditarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtTelefono_EditarProveedor.setToolTipText("Muestra teléfono.");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setText("Nombre");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel60.setText("Teléfono");

        txtNombre_EditarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombre_EditarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtNombre_EditarProveedor.setToolTipText("Muestra nombre proveedor.");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel58.setText("Dirección");

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setText("Corréo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(72, 72, 72)
                                .addComponent(txtNombre_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(77, 77, 77)
                                .addComponent(txtCorreo_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(27, 27, 27)
                                .addComponent(txtCedulaJuridica_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(62, 62, 62)
                                .addComponent(txtDireccion_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(67, 67, 67)
                                .addComponent(txtTelefono_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btLimpiar_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAceptar_EditarProveedor)))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel57)
                .addGap(50, 50, 50)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(txtCorreo_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(txtCedulaJuridica_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(txtDireccion_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel60))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTelefono_EditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btLimpiar_EditarProveedor)
                        .addGap(59, 59, 59)
                        .addComponent(btAceptar_EditarProveedor)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      public void Limpiar() {
        txtCedulaJuridica_EditarProveedor.setText("");
        txtCorreo_EditarProveedor.setText("");
        txtDireccion_EditarProveedor.setText("");
        txtNombre_EditarProveedor.setText("");
        txtTelefono_EditarProveedor.setText("");

    }

    public void cerrar() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int Decision = JOptionPane.showConfirmDialog(
                        null,
                        "Desea salir de esta ventana",
                        "Salir",
                        JOptionPane.YES_NO_OPTION);

                if (Decision == JOptionPane.YES_OPTION) {
                    ListarUsuarios.panel = false;
                    dispose();
                }
            }
        });
    }

    public void cargarDatos() {
        txtCedulaJuridica_EditarProveedor.setText(Cedula);
        txtNombre_EditarProveedor.setText(Nombre);
        txtDireccion_EditarProveedor.setText(Direccion);
        txtTelefono_EditarProveedor.setText(Telefono);
        txtCorreo_EditarProveedor.setText(Correo);
    }

    public boolean VerificaCamposVacios() {
        if (txtCedulaJuridica_EditarProveedor.getText().equals("")
                || txtNombre_EditarProveedor.getText().equals("")) {
            return true;
        } else {
            return false;
        }

    }

    public void editarProveedor() throws ClassNotFoundException, SQLException {
        if (VerificaCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");

        } else {
            Nombre = txtNombre_EditarProveedor.getText();
            Direccion = txtDireccion_EditarProveedor.getText();
            Correo = txtCorreo_EditarProveedor.getText();
            Telefono = txtTelefono_EditarProveedor.getText();
            Proveedor elProveedor = new Proveedor(Cedula, Nombre, Direccion, Correo, Telefono);

            CoordinadorDeProveedores elCoordinadorDeProveedores = new CoordinadorDeProveedores();
            ResultSet respuestas = null;
            respuestas = elCoordinadorDeProveedores.EditarProveedor(elProveedor);
            if (respuestas.next()) {
                if (respuestas.getString(1).equals("1")) {
                    JOptionPane.showMessageDialog(null, "Proveedor editado con exito");
                    Limpiar();
                    dispose();
                    ListarProveedor.VisualizarProveedores();
                    if (ListarProveedor.panelHabilitado == true) {

                        BuscarProveedores.VisualizarTodosLosProveedores();

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Fallo en la edicion del proveedor ");
                }
            }

        }
    }
    private void btAceptar_EditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarProveedorActionPerformed
        try {
            editarProveedor();        // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAceptar_EditarProveedorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_EditarProveedor;
    public static javax.swing.JButton btLimpiar_EditarProveedor;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField txtCedulaJuridica_EditarProveedor;
    public static javax.swing.JTextField txtCorreo_EditarProveedor;
    public static javax.swing.JTextField txtDireccion_EditarProveedor;
    public static javax.swing.JTextField txtNombre_EditarProveedor;
    public static javax.swing.JTextField txtTelefono_EditarProveedor;
    // End of variables declaration//GEN-END:variables
}
