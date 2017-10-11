/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import Modelos.Cliente;
import static UI.BuscarClientes.BuscarCliente;
import static UI.BuscarClientes.TablaFiltrarClientes_ListarClientes;
import static UI.BuscarClientes.VisualizarTodosLosClientes;

import static UI.BuscarClientes.txtCedulaABuscar_BuscarCliente;

import static UI.ListarClientes.TablaListarClientes_ListarClientes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarCliente extends javax.swing.JDialog {

    String Cedula, PrimerNombreUsuario,
            SegundoNombreUsuario,
            PrimerApellido,
            SegundoApellido,
            NombreLocal,
            NivelDeCliente;
    public static int index = 0;

    public EditarCliente(java.awt.Frame parent, boolean modal, String Nivel, String cedula, String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, String Nombrelocal) {
        super(parent, modal);
        this.Cedula = cedula;
        this.PrimerNombreUsuario = primerNombre;
        this.SegundoNombreUsuario = segundoNombre;
        this.PrimerApellido = primerApellido;
        this.SegundoApellido = segundoApellido;
        this.NombreLocal = Nombrelocal;
        this.NivelDeCliente = Nivel;
        initComponents();
        JOptionPane.showMessageDialog(null, NivelDeCliente);
        CargarDatos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        txtSegundoApellido_EditarCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCedula_EditarCliente = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btCancelar_EditarUsuario = new javax.swing.JButton();
        txtPrimerNombre_EditarCliente = new javax.swing.JTextField();
        btAceptar_EditarUsuario = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btLimpiar_EditarUsuario = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtSegundoNombre_EditarCliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPrimerApellido_EditarCliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxNivel_EditarCliente = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txtNombreLocal_EditarCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Nivel de cliente");

        txtSegundoApellido_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoApellido_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Editar cliente");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Cedúla");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_Male_User_Icon_128.png"))); // NOI18N

        txtCedula_EditarCliente.setEditable(false);
        txtCedula_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedula_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));
        txtCedula_EditarCliente.setEnabled(false);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setAlignmentX(5.0F);

        btCancelar_EditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_EditarUsuario.setToolTipText("Oprima para cancelar");
        btCancelar_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_EditarUsuarioActionPerformed(evt);
            }
        });

        txtPrimerNombre_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerNombre_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));

        btAceptar_EditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarUsuario.setToolTipText("Oprimir para guardar usuario");
        btAceptar_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarUsuarioActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Primer nombre");

        btLimpiar_EditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_EditarUsuario.setToolTipText("Oprima para limpiar campos");
        btLimpiar_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_EditarUsuarioActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Segundo nombre");

        txtSegundoNombre_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoNombre_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Primer apellido");

        txtPrimerApellido_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerApellido_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Segundo apellido");

        cbxNivel_EditarCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "★", "★★", "★★★", "★★★★", "★★★★★" }));
        cbxNivel_EditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivel_EditarClienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Nombre local");

        txtNombreLocal_EditarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreLocal_EditarCliente.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel15)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel18)
                        .addGap(36, 36, 36)
                        .addComponent(txtPrimerNombre_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNivel_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel21)
                        .addGap(36, 36, 36)
                        .addComponent(txtPrimerApellido_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel20)
                        .addGap(27, 27, 27)
                        .addComponent(txtSegundoApellido_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel22)
                        .addGap(87, 87, 87)
                        .addComponent(txtCedula_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btCancelar_EditarUsuario)
                        .addGap(49, 49, 49)
                        .addComponent(btAceptar_EditarUsuario)
                        .addGap(48, 48, 48)
                        .addComponent(btLimpiar_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19)
                        .addGap(27, 27, 27)
                        .addComponent(txtSegundoNombre_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel14)
                        .addGap(34, 34, 34)
                        .addComponent(txtNombreLocal_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel15))
                    .addComponent(jLabel17))
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtPrimerNombre_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cbxNivel_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtSegundoNombre_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14))
                    .addComponent(txtNombreLocal_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txtPrimerApellido_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtSegundoApellido_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(txtCedula_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar_EditarUsuario)
                    .addComponent(btAceptar_EditarUsuario)
                    .addComponent(btLimpiar_EditarUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public int nivel() {

        if (NivelDeCliente.equals("Uno")) {
            index = 0;
        }
        if (NivelDeCliente.equals("Dos")) {
            index = 1;
        }
        if (NivelDeCliente.equals("Tres")) {
            index = 2;
        }
        if (NivelDeCliente.equals("Cuatro")) {
            index = 3;
        }
        if (NivelDeCliente.equals("Cinco")) {
            index = 4;
        }
        return index;
    }

    public void CargarDatos() {

        txtCedula_EditarCliente.setText(Cedula);
        txtPrimerNombre_EditarCliente.setText(PrimerNombreUsuario);
        txtSegundoNombre_EditarCliente.setText(SegundoNombreUsuario);
        txtPrimerApellido_EditarCliente.setText(PrimerApellido);
        txtSegundoApellido_EditarCliente.setText(SegundoApellido);
        txtNombreLocal_EditarCliente.setText(NombreLocal);
        cbxNivel_EditarCliente.setSelectedIndex(nivel());

    }

    public boolean VerificarCamposVacios() {

        if (txtPrimerNombre_EditarCliente.getText().equals("")
                || txtPrimerApellido_EditarCliente.getText().equals("")
                || txtSegundoApellido_EditarCliente.getText().equals("")
                || txtCedula_EditarCliente.equals("")
                || txtNombreLocal_EditarCliente.getText().equals("")) {

            return true;
        }
        return false;
    }

    public void LimpiarCampos() {

        txtPrimerNombre_EditarCliente.setText("");
        txtSegundoNombre_EditarCliente.setText("");
        txtPrimerApellido_EditarCliente.setText("");
        txtSegundoApellido_EditarCliente.setText("");

        txtNombreLocal_EditarCliente.setText("");
    }
    private void btAceptar_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarUsuarioActionPerformed
        if (VerificarCamposVacios() == true) {

            JOptionPane.showMessageDialog(null, "Por favor rellene los campos obligatorios");
            return;
        } else {

            try {

                PrimerNombreUsuario = txtPrimerNombre_EditarCliente.getText();
                SegundoNombreUsuario = txtSegundoNombre_EditarCliente.getText();
                PrimerApellido = txtPrimerApellido_EditarCliente.getText();
                SegundoApellido = txtSegundoApellido_EditarCliente.getText();
                NombreLocal = txtNombreLocal_EditarCliente.getText();

                CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();

                Cliente elCliente = new Cliente(NivelDeCliente, null, Cedula, NombreLocal, PrimerNombreUsuario, SegundoNombreUsuario, PrimerApellido, SegundoApellido);

                ResultSet Respuesta = elCoordinadorDeClientes.EditarCliente(elCliente);
                if (Respuesta.next()) {
                    if (Respuesta.getString(1).equals("1")) {
                        JOptionPane.showMessageDialog(null, "El cliente se edito correctamente");

                        dispose();

                        ListarClientes.VisualizarClientes(TablaListarClientes_ListarClientes);
                        if (ListarClientes.panelHabilitado == true) {
                            txtCedulaABuscar_BuscarCliente.setText("");
                            BuscarCliente();
                            VisualizarTodosLosClientes(TablaFiltrarClientes_ListarClientes);
                           
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error en la modificiòn");
                    }
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btAceptar_EditarUsuarioActionPerformed

    private void btLimpiar_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_EditarUsuarioActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_EditarUsuarioActionPerformed

    private void cbxNivel_EditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivel_EditarClienteActionPerformed
        if (cbxNivel_EditarCliente.getSelectedItem().equals("★")) {
            NivelDeCliente = "Uno";
        } else if (cbxNivel_EditarCliente.getSelectedItem().equals("★★")) {
            NivelDeCliente = "Dos";
        } else if (cbxNivel_EditarCliente.getSelectedItem().equals("★★★")) {
            NivelDeCliente = "Tres";
        } else if (cbxNivel_EditarCliente.getSelectedItem().equals("★★★★")) {
            NivelDeCliente = "Cuatro";
        } else {
            NivelDeCliente = "Cinco";
        }
    }//GEN-LAST:event_cbxNivel_EditarClienteActionPerformed

    private void btCancelar_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_EditarUsuarioActionPerformed
        int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btCancelar_EditarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_EditarUsuario;
    private javax.swing.JButton btCancelar_EditarUsuario;
    public static javax.swing.JButton btLimpiar_EditarUsuario;
    public static javax.swing.JComboBox cbxNivel_EditarCliente;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField txtCedula_EditarCliente;
    public javax.swing.JTextField txtNombreLocal_EditarCliente;
    public static javax.swing.JTextField txtPrimerApellido_EditarCliente;
    public static javax.swing.JTextField txtPrimerNombre_EditarCliente;
    public static javax.swing.JTextField txtSegundoApellido_EditarCliente;
    public static javax.swing.JTextField txtSegundoNombre_EditarCliente;
    // End of variables declaration//GEN-END:variables
}
