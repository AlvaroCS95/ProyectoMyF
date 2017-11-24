package UI;

import AccesoDatos.Coneccion;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IngresoAlSistema extends javax.swing.JFrame {

    public boolean indicador;

    String ContraseñaDeUsuario;
    Icon icono;

    public IngresoAlSistema() {
        initComponents();
        setLocationRelativeTo(null);
        indicador = false;
        this.setTitle("Login de usuario");
         setIconImage(Toolkit.getDefaultToolkit().getImage
        (this.getClass().getResource("/Imagenes/Logo_Ventana_M&f.jpeg")));

    }

    public void IniciarSesion() {
        Coneccion cc = new Coneccion();

        if (!pswContraseña_IngresoAlSistema.getText().isEmpty()) {
            
            if (!txtNombreUsario_IngresoAlSistema.getText().isEmpty()) {
                char[] Contraseña = pswContraseña_IngresoAlSistema.getPassword();
                ContraseñaDeUsuario = new String(Contraseña);

                Connection cn = cc.ConexionBD(txtNombreUsario_IngresoAlSistema.getText(), ContraseñaDeUsuario);

                if (cn == null) {
                    JOptionPane.showMessageDialog(null, "Datos de inicio no validos\nverifiquelos e intentelo de nuevo.",
                            "¡Datos incorrectos!", JOptionPane.ERROR_MESSAGE);
                } else {

                    Inicio principal = new Inicio(txtNombreUsario_IngresoAlSistema.getText());
                    principal.setVisible(true);
                    this.setVisible(false);

                }
            }
        }
    }

    public void verContraseña() {
        if (indicador == false) {
            pswContraseña_IngresoAlSistema.setEchoChar((char) 0);
            indicador = true;
            icono = new ImageIcon(getClass().getResource("/Imagenes/ocultarInicio.png"));
            MostrarContraseña.setIcon(icono);
        } else {

            pswContraseña_IngresoAlSistema.setEchoChar('*');
            indicador = false;
            icono = new ImageIcon(getClass().getResource("/Imagenes/verInicio.png"));
            MostrarContraseña.setIcon(icono);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombreUsario_IngresoAlSistema = new javax.swing.JTextField();
        pswContraseña_IngresoAlSistema = new javax.swing.JPasswordField();
        btIngresar_IngresoAlSistema = new javax.swing.JButton();
        lbUsuario_IngresoAlSistema = new javax.swing.JLabel();
        lbContraseña_IngresoAlSistema = new javax.swing.JLabel();
        MostrarContraseña = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 246, 255));

        txtNombreUsario_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreUsario_IngresoAlSistema.setText("root");
        txtNombreUsario_IngresoAlSistema.setToolTipText("Ingrese AQUÍ su nombre de usuario");

        pswContraseña_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pswContraseña_IngresoAlSistema.setText("12345");
        pswContraseña_IngresoAlSistema.setToolTipText("Ingrese AQUÍ su contraseña");
        pswContraseña_IngresoAlSistema.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pswContraseña_IngresoAlSistemaKeyTyped(evt);
            }
        });

        btIngresar_IngresoAlSistema.setBackground(new java.awt.Color(0, 153, 153));
        btIngresar_IngresoAlSistema.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        btIngresar_IngresoAlSistema.setText("Ingresar");
        btIngresar_IngresoAlSistema.setToolTipText("Ingresar al sistema (Enter)");
        btIngresar_IngresoAlSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btIngresar_IngresoAlSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresar_IngresoAlSistemaActionPerformed(evt);
            }
        });

        lbUsuario_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbUsuario_IngresoAlSistema.setText("Usuario:");

        lbContraseña_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbContraseña_IngresoAlSistema.setText("Contraseña:");

        MostrarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"))); // NOI18N
        MostrarContraseña.setToolTipText("Precione para mostrar/ocultar la contraseña.");
        MostrarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarContraseñaMouseClicked(evt);
            }
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoM&F.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbContraseña_IngresoAlSistema, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsuario_IngresoAlSistema, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pswContraseña_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsario_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(MostrarContraseña))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btIngresar_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsuario_IngresoAlSistema)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtNombreUsario_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MostrarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pswContraseña_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbContraseña_IngresoAlSistema)))
                        .addGap(18, 18, 18)
                        .addComponent(btIngresar_IngresoAlSistema)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresar_IngresoAlSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresar_IngresoAlSistemaActionPerformed
        IniciarSesion();
    }//GEN-LAST:event_btIngresar_IngresoAlSistemaActionPerformed

    private void pswContraseña_IngresoAlSistemaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswContraseña_IngresoAlSistemaKeyTyped
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            btIngresar_IngresoAlSistema.doClick();
        }
    }//GEN-LAST:event_pswContraseña_IngresoAlSistemaKeyTyped

    private void MostrarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarContraseñaMouseClicked
        verContraseña();
    }//GEN-LAST:event_MostrarContraseñaMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresoAlSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoAlSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoAlSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoAlSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoAlSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MostrarContraseña;
    private javax.swing.JButton btIngresar_IngresoAlSistema;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbContraseña_IngresoAlSistema;
    private javax.swing.JLabel lbUsuario_IngresoAlSistema;
    public static javax.swing.JPasswordField pswContraseña_IngresoAlSistema;
    public static javax.swing.JTextField txtNombreUsario_IngresoAlSistema;
    // End of variables declaration//GEN-END:variables
}
