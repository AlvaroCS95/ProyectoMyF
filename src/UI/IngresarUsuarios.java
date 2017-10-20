/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeUsuarios;
import Modelos.Usuario;
import static UI.ListarUsuarios.VisualizarUsuarios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class IngresarUsuarios extends javax.swing.JDialog {

    String Cedula, PrimerNombreUsuario,
            SegundoNombreUsuario,
            PrimerApellido,
            SegundoApellido,
            NombreUsuario,
            ClaveUsuario;
    Object[] filas;
    public IngresarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cerrar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtSegundoNombre_IngresarUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrimerApellido_IngresarUsuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombreUsuario_IngresarUsuario = new javax.swing.JTextField();
        txtSegundoApellido_IngresarUsuario = new javax.swing.JTextField();
        jpwsContraseña_IngresarUsuario = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCedula_IngresarUsuario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btAceptar_IngresarUsuario = new javax.swing.JButton();
        txtPrimerNombre_IngresarUsuario = new javax.swing.JTextField();
        btLimpiar_IngresarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Primer nombre");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setAlignmentX(5.0F);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Segundo nombre");

        txtSegundoNombre_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoNombre_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Primer apellido");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Ingreso de usuarios");

        txtPrimerApellido_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerApellido_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Insertar.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Segundo apellido");

        txtNombreUsuario_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreUsuario_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        txtSegundoApellido_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoApellido_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jpwsContraseña_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jpwsContraseña_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Cedúla");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Contraseña");

        txtCedula_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedula_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Nombre de usuario");

        btAceptar_IngresarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarUsuario.setToolTipText("Oprimir para guardar usuario");
        btAceptar_IngresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarUsuarioActionPerformed(evt);
            }
        });

        txtPrimerNombre_IngresarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerNombre_IngresarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        btLimpiar_IngresarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarUsuario.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(309, 309, 309)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtPrimerNombre_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel19)
                                            .addGap(29, 29, 29)
                                            .addComponent(txtSegundoNombre_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(40, 40, 40)
                                                .addComponent(txtPrimerApellido_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(31, 31, 31)
                                                .addComponent(txtSegundoApellido_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpwsContraseña_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(91, 91, 91)
                                .addComponent(txtCedula_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAceptar_IngresarUsuario)
                        .addGap(41, 41, 41)
                        .addComponent(btLimpiar_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel15)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel18))
                            .addComponent(txtPrimerNombre_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel19))
                            .addComponent(txtSegundoNombre_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreUsuario_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jpwsContraseña_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrimerApellido_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtSegundoApellido_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtCedula_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAceptar_IngresarUsuario)
                    .addComponent(btLimpiar_IngresarUsuario))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void LimpiarCampos() {
        txtCedula_IngresarUsuario.setText("");
        txtPrimerNombre_IngresarUsuario.setText("");
        txtSegundoNombre_IngresarUsuario.setText("");
        txtPrimerApellido_IngresarUsuario.setText("");
        txtSegundoApellido_IngresarUsuario.setText("");
        txtNombreUsuario_IngresarUsuario.setText("");
        jpwsContraseña_IngresarUsuario.setText("");
    }
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
   public boolean VerificarCamposVacios() {

        if (txtPrimerNombre_IngresarUsuario.getText().equals("")
                || txtPrimerNombre_IngresarUsuario.getText().equals("")
                || txtSegundoApellido_IngresarUsuario.getText().equals("")
                || txtCedula_IngresarUsuario.getText().equals("")
                || txtNombreUsuario_IngresarUsuario.getText().equals("")
                || jpwsContraseña_IngresarUsuario.getPassword().equals("")) {

            return false;
        }
        return true;
    }
   public void IngresarUsuario(){
     if (VerificarCamposVacios() == false) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            return;
        } else {
            try {
                 ResultSet Respuesta; 
                Cedula = txtCedula_IngresarUsuario.getText();
                PrimerNombreUsuario = txtPrimerNombre_IngresarUsuario.getText();
                SegundoNombreUsuario = txtSegundoNombre_IngresarUsuario.getText();
                PrimerApellido = txtPrimerApellido_IngresarUsuario.getText();
                SegundoApellido = txtSegundoApellido_IngresarUsuario.getText();
                NombreUsuario = txtNombreUsuario_IngresarUsuario.getText();
                
                char[] contraseña = IngresarUsuarios.jpwsContraseña_IngresarUsuario.getPassword();
                ClaveUsuario = new String(contraseña);
                CoordinadorDeUsuarios elCoordinadorDeUsuarios = new CoordinadorDeUsuarios();
                Usuario elUsuario = new Usuario(NombreUsuario, ClaveUsuario, Cedula, PrimerNombreUsuario, SegundoNombreUsuario, PrimerApellido, SegundoApellido);
                 Respuesta=elCoordinadorDeUsuarios.AgregarUsuario(elUsuario);
                if(Respuesta.next()){
                    if(Respuesta.getString(1).equals("1")){
                        JOptionPane.showMessageDialog(null,"Se ingreso el usuario exitosamente");
                        LimpiarCampos();
                        dispose();
                        ListarUsuarios.VisualizarUsuarios();
                        
                    }else {
                        JOptionPane.showMessageDialog(null,"Error en la insercion:\nPosibles causas:\n1) No tiene permisos para ejecutar esta acción.\n"
                                + "2) El usuario ha sido registrado con anterioridad. \nComuniquese con el administrador.","Error en la insercion",JOptionPane.ERROR_MESSAGE);
                    }
                }
               
            } catch (Exception e) {
            }
        }
}
    private void btAceptar_IngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarUsuarioActionPerformed
        
        IngresarUsuario();
    }//GEN-LAST:event_btAceptar_IngresarUsuarioActionPerformed

    private void btLimpiar_IngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarUsuarioActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_IngresarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarUsuario;
    public static javax.swing.JButton btLimpiar_IngresarUsuario;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JPasswordField jpwsContraseña_IngresarUsuario;
    public static javax.swing.JTextField txtCedula_IngresarUsuario;
    public static javax.swing.JTextField txtNombreUsuario_IngresarUsuario;
    public static javax.swing.JTextField txtPrimerApellido_IngresarUsuario;
    public static javax.swing.JTextField txtPrimerNombre_IngresarUsuario;
    public static javax.swing.JTextField txtSegundoApellido_IngresarUsuario;
    public static javax.swing.JTextField txtSegundoNombre_IngresarUsuario;
    // End of variables declaration//GEN-END:variables
}
