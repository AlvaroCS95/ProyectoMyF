
package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import Modelos.Cliente;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class IngresarClientes extends javax.swing.JDialog {

    String Cedula,
            PrimerNombre,
            SegundoNombre,
            PrimerApellido,
            SegundoApellido,
            Direccion,
            NombreLocal,
            NivelDeCliente,
            RazonSocial;

    public IngresarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
        cerrar();
    }

    public void cerrar() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int Decision = JOptionPane.showConfirmDialog(null,"Desea salir de esta ventana","Salir",
                        JOptionPane.YES_NO_OPTION);

                if (Decision == JOptionPane.YES_OPTION) {
                    ListarUsuarios.panel = false;
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxNivel_IngresarCliente = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btAceptar_IngresarCliente = new javax.swing.JButton();
        btLimpiar_IngresarCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNombreLocal_IngresarCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRazonSocial_IngresarCliente = new javax.swing.JTextField();
        txtCedula_IngresarCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txAreaDireccion_IngresarCliente = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de clientes");
        setPreferredSize(new java.awt.Dimension(890, 651));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Ingreso de clientes");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 63, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/list_add_user.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 16, 163, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setAlignmentX(5.0F);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 159, 640, 9));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Primer nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 220, -1, -1));

        txtPrimerNombre_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerNombre_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtPrimerNombre_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 220, 163, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Segundo nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 264, -1, -1));

        txtSegundoNombre_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoNombre_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtSegundoNombre_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 261, 160, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Primer apellido");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, -1));

        txtPrimerApellido_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerApellido_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtPrimerApellido_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 200, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Segundo apellido");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        txtSegundoApellido_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoApellido_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtSegundoApellido_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 200, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Cédula");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 305, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Dirección");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        cbxNivel_IngresarCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "A", "B", "C", "D", "E" }));
        cbxNivel_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivel_IngresarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(cbxNivel_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 160, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Nivel de cliente");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        btAceptar_IngresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarCliente.setToolTipText("Oprimir para guardar cliente");
        btAceptar_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btAceptar_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, -1, -1));

        btLimpiar_IngresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarCliente.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpiar_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 64, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Nombre local");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        txtNombreLocal_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreLocal_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNombreLocal_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 200, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Razón Social");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        txtRazonSocial_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtRazonSocial_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtRazonSocial_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 160, -1));

        txtCedula_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedula_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtCedula_IngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 160, 28));

        txAreaDireccion_IngresarCliente.setColumns(20);
        txAreaDireccion_IngresarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txAreaDireccion_IngresarCliente.setForeground(new java.awt.Color(0, 102, 102));
        txAreaDireccion_IngresarCliente.setLineWrap(true);
        txAreaDireccion_IngresarCliente.setRows(5);
        txAreaDireccion_IngresarCliente.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txAreaDireccion_IngresarCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 200, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void LimpiarCampos() {
        txtCedula_IngresarCliente.setText("");
        txtPrimerNombre_IngresarCliente.setText("");
        txtSegundoNombre_IngresarCliente.setText("");
        txtPrimerApellido_IngresarCliente.setText("");
        txtSegundoApellido_IngresarCliente.setText("");
        txAreaDireccion_IngresarCliente.setText("");
        txtNombreLocal_IngresarCliente.setText("");
        txtRazonSocial_IngresarCliente.setText("");
        cbxNivel_IngresarCliente.setSelectedItem("Seleccione...");
    }

    public boolean VerificarCamposVacios() {

        if (txtPrimerNombre_IngresarCliente.getText().equals("")
                || cbxNivel_IngresarCliente.getSelectedItem().equals("Seleccione...")
                || txtPrimerApellido_IngresarCliente.getText().equals("")
                || txtSegundoApellido_IngresarCliente.getText().equals("")
                || txtCedula_IngresarCliente.getText().equals("")
                || txAreaDireccion_IngresarCliente.getText().equals("")
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
                Direccion = txAreaDireccion_IngresarCliente.getText();
                NombreLocal = txtNombreLocal_IngresarCliente.getText();
                RazonSocial = txtRazonSocial_IngresarCliente.getText();
                CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();
                Cliente elCliente = new Cliente(NivelDeCliente, Direccion, Cedula, NombreLocal, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, RazonSocial);
                ResultSet respuesta = null;
                respuesta = elCoordinadorDeClientes.AgregarCliente(elCliente);
                if (respuesta.next()) {
                    if (respuesta.getString(1).equals("1")) {
                        JOptionPane.showMessageDialog(null, "Cliente insertado exitosamente");
                        LimpiarCampos();
                        ListarClientes.VisualizarClientes(TablaListarClientes_ListarClientes);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error en la inserción");
                    }
                }

            } catch (Exception e) {
            }
        }
    }
    private void cbxNivel_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivel_IngresarClienteActionPerformed
        if (cbxNivel_IngresarCliente.getSelectedItem().equals("A")) {
            NivelDeCliente = "Uno";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("B")) {
            NivelDeCliente = "Dos";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("C")) {
            NivelDeCliente = "Tres";
        } else if (cbxNivel_IngresarCliente.getSelectedItem().equals("D")) {
            NivelDeCliente = "Cuatro";
        } else {
            NivelDeCliente = "Cinco";
        }
    }//GEN-LAST:event_cbxNivel_IngresarClienteActionPerformed

    private void btAceptar_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarClienteActionPerformed
        IngresarCliente();
    }//GEN-LAST:event_btAceptar_IngresarClienteActionPerformed

    private void btLimpiar_IngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarClienteActionPerformed
        LimpiarCampos();     
    }//GEN-LAST:event_btLimpiar_IngresarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarCliente;
    public static javax.swing.JButton btLimpiar_IngresarCliente;
    public static javax.swing.JComboBox cbxNivel_IngresarCliente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txAreaDireccion_IngresarCliente;
    private javax.swing.JTextField txtCedula_IngresarCliente;
    public javax.swing.JTextField txtNombreLocal_IngresarCliente;
    public static javax.swing.JTextField txtPrimerApellido_IngresarCliente;
    public static javax.swing.JTextField txtPrimerNombre_IngresarCliente;
    public static javax.swing.JTextField txtRazonSocial_IngresarCliente;
    public static javax.swing.JTextField txtSegundoApellido_IngresarCliente;
    public static javax.swing.JTextField txtSegundoNombre_IngresarCliente;
    // End of variables declaration//GEN-END:variables
}
