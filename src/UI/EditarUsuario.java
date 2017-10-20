/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeUsuarios;
import Modelos.Usuario;
import static UI.BuscarUsuarios.BuscarUsuario;
import static UI.BuscarUsuarios.VisualizarTodosLosUsuarios;
import static UI.BuscarUsuarios.txtCedulaABuscar_BuscarUsuario;
import static UI.ListarUsuarios.VisualizarUsuarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarUsuario extends javax.swing.JDialog {

      String Cedula, PrimerNombreUsuario,
            SegundoNombreUsuario,
            PrimerApellido,
            SegundoApellido,
            NombreUsuario,
            ClaveUsuario;
    public EditarUsuario(java.awt.Frame parent, boolean modal,String cedula,String primerNombre,String segundoNombre,String primerApellido,
    
   String segundoApellido,String nombreUsuario) {
        super(parent, modal);
       this.Cedula=cedula;
        this.PrimerNombreUsuario=primerNombre;
        this.SegundoNombreUsuario=segundoNombre;
        this.PrimerApellido=primerApellido;
        this.SegundoApellido=segundoApellido;
        this.NombreUsuario=nombreUsuario;
        initComponents();
        setLocationRelativeTo(null);
        CargarDatos();
        cerrar();
    }

    EditarUsuario(Object object, boolean b, String Cedula, String Nombre, String Nombre0, String Direccion, String correo, String Nombre1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
 public void CargarDatos(){
    
        txtCedula_EditarUsuario.setText(Cedula);
        txtPrimerNombre_EditarUsuario.setText(PrimerNombreUsuario);
        txtSegundoNombre_EditarUsuario.setText(SegundoNombreUsuario);
        txtPrimerApellido_EditarUsuario.setText(PrimerApellido);
        txtSegundoApellido_EditarUsuario.setText(SegundoApellido);
        txtNombreUsuario_EditarUsuario.setText(NombreUsuario);
        
    }
public boolean VerificarCamposVacios() {

                if (txtPrimerNombre_EditarUsuario.getText().equals("")
               
                || txtPrimerApellido_EditarUsuario.getText().equals("")
                || txtSegundoApellido_EditarUsuario.getText().equals("")              
                || txtNombreUsuario_EditarUsuario.getText().equals("")
                || jpwsContraseña_EditarUsuario.getPassword().equals("")) {

            return true;
        }
        return false;
    }
public void LimpiarCampos() {
        
        txtPrimerNombre_EditarUsuario.setText("");
        txtSegundoNombre_EditarUsuario.setText("");
        txtPrimerApellido_EditarUsuario.setText("");
        txtSegundoApellido_EditarUsuario.setText("");
        txtNombreUsuario_EditarUsuario.setText("");
        jpwsContraseña_EditarUsuario.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPrimerNombre_EditarUsuario = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSegundoNombre_EditarUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPrimerApellido_EditarUsuario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSegundoApellido_EditarUsuario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCedula_EditarUsuario = new javax.swing.JTextField();
        btAceptar_EditarUsuario = new javax.swing.JButton();
        btLimpiar_EditarUsuario = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpwsContraseña_EditarUsuario = new javax.swing.JPasswordField();
        txtNombreUsuario_EditarUsuario = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Editar usuario");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_Male_User_Icon_128.png"))); // NOI18N

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setAlignmentX(5.0F);

        txtPrimerNombre_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerNombre_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Primer nombre");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Segundo nombre");

        txtSegundoNombre_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoNombre_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Primer apellido");

        txtPrimerApellido_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrimerApellido_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Segundo apellido");

        txtSegundoApellido_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSegundoApellido_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Cedúla");

        txtCedula_EditarUsuario.setEditable(false);
        txtCedula_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedula_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));
        txtCedula_EditarUsuario.setEnabled(false);

        btAceptar_EditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarUsuario.setToolTipText("Oprimir para guardar usuario");
        btAceptar_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarUsuarioActionPerformed(evt);
            }
        });

        btLimpiar_EditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_EditarUsuario.setToolTipText("Oprima para limpiar campos");
        btLimpiar_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_EditarUsuarioActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Contraseña actual");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("* Debe digitar su contraseña actual para efectuar el cambio");

        jpwsContraseña_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jpwsContraseña_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));
        jpwsContraseña_EditarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        txtNombreUsuario_EditarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreUsuario_EditarUsuario.setForeground(new java.awt.Color(0, 102, 102));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Nombre de usuarios");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cambiar contraseña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addComponent(txtPrimerNombre_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel23)
                        .addGap(27, 27, 27)
                        .addComponent(txtNombreUsuario_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel21)
                        .addGap(36, 36, 36)
                        .addComponent(txtPrimerApellido_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel20)
                        .addGap(27, 27, 27)
                        .addComponent(txtSegundoApellido_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel22)
                        .addGap(87, 87, 87)
                        .addComponent(txtCedula_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(btAceptar_EditarUsuario)
                        .addGap(48, 48, 48)
                        .addComponent(btLimpiar_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19)
                        .addGap(27, 27, 27)
                        .addComponent(txtSegundoNombre_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(38, 38, 38)
                                .addComponent(jpwsContraseña_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
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
                    .addComponent(txtPrimerNombre_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel23))
                    .addComponent(txtNombreUsuario_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtSegundoNombre_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jpwsContraseña_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txtPrimerApellido_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtSegundoApellido_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(txtCedula_EditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAceptar_EditarUsuario)
                    .addComponent(btLimpiar_EditarUsuario))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptar_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarUsuarioActionPerformed
        if (VerificarCamposVacios() == true) {

            JOptionPane.showMessageDialog(null, "Por favor rellene los campos obligatorios");
            return;
        } else {
          
            try {
                Cedula = txtCedula_EditarUsuario.getText();
                PrimerNombreUsuario = txtPrimerNombre_EditarUsuario.getText();
                SegundoNombreUsuario = txtSegundoNombre_EditarUsuario.getText();
                PrimerApellido = txtPrimerApellido_EditarUsuario.getText();
                SegundoApellido = txtSegundoApellido_EditarUsuario.getText();
                NombreUsuario = txtNombreUsuario_EditarUsuario.getText();

                char[] contraseña = EditarUsuario.jpwsContraseña_EditarUsuario.getPassword();
                ClaveUsuario = new String(contraseña);
                CoordinadorDeUsuarios elCoordinadorDeUsuarios = new CoordinadorDeUsuarios();
                Usuario elUsuario = new Usuario(NombreUsuario, ClaveUsuario, Cedula, PrimerNombreUsuario, SegundoNombreUsuario, PrimerApellido, SegundoApellido);
                ResultSet Respuesta=elCoordinadorDeUsuarios.EditarUsuario(elUsuario); 
                if(Respuesta.next()){
                    if(Respuesta.getString(1).equals("1")){
                        JOptionPane.showMessageDialog(null,"El usuario se edito correctamente");
                        LimpiarCampos();
                      
                         VisualizarUsuarios();
                        if (ListarUsuarios.panel == true) {
                           
                            txtCedulaABuscar_BuscarUsuario.setText("");
                            BuscarUsuario();
                             VisualizarTodosLosUsuarios();
                            ListarUsuarios.panel=false;
                        }
                          dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"La contraseña que proporciono no es la correcta");
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           
           
        }
    }//GEN-LAST:event_btAceptar_EditarUsuarioActionPerformed

    private void btLimpiar_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_EditarUsuarioActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_EditarUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       CambiarContraseña cambiarContraseña= new CambiarContraseña(null, true);
       cambiarContraseña.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_EditarUsuario;
    public static javax.swing.JButton btLimpiar_EditarUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JPasswordField jpwsContraseña_EditarUsuario;
    public static javax.swing.JTextField txtCedula_EditarUsuario;
    public static javax.swing.JTextField txtNombreUsuario_EditarUsuario;
    public static javax.swing.JTextField txtPrimerApellido_EditarUsuario;
    public static javax.swing.JTextField txtPrimerNombre_EditarUsuario;
    public static javax.swing.JTextField txtSegundoApellido_EditarUsuario;
    public static javax.swing.JTextField txtSegundoNombre_EditarUsuario;
    // End of variables declaration//GEN-END:variables
}
