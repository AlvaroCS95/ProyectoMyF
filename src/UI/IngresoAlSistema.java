package UI;

import AccesoDatos.Coneccion;
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
        btIcono_IngresoAlistema = new javax.swing.JButton();
        lbUsuario_IngresoAlSistema = new javax.swing.JLabel();
        lbContraseña_IngresoAlSistema = new javax.swing.JLabel();
        MostrarContraseña = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreUsario_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNombreUsario_IngresoAlSistema.setText("root");
        txtNombreUsario_IngresoAlSistema.setToolTipText("Ingrese AQUÍ su nombre de usuario");

        pswContraseña_IngresoAlSistema.setText("2895");
        pswContraseña_IngresoAlSistema.setToolTipText("Ingrese AQUÍ su contraseña");
        pswContraseña_IngresoAlSistema.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pswContraseña_IngresoAlSistemaKeyTyped(evt);
            }
        });

        btIngresar_IngresoAlSistema.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        btIngresar_IngresoAlSistema.setText("Ingresar");
        btIngresar_IngresoAlSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresar_IngresoAlSistemaActionPerformed(evt);
            }
        });

        btIcono_IngresoAlistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N

        lbUsuario_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbUsuario_IngresoAlSistema.setText("Usuario:");

        lbContraseña_IngresoAlSistema.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbContraseña_IngresoAlSistema.setText("Contraseña:");

        MostrarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"))); // NOI18N
        MostrarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarContraseñaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btIcono_IngresoAlistema, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btIngresar_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbContraseña_IngresoAlSistema, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsuario_IngresoAlSistema, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(pswContraseña_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombreUsario_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(MostrarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btIcono_IngresoAlistema, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreUsario_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUsuario_IngresoAlSistema))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pswContraseña_IngresoAlSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContraseña_IngresoAlSistema)
                            .addComponent(MostrarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(btIngresar_IngresoAlSistema)))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel MostrarContraseña;
    private javax.swing.JButton btIcono_IngresoAlistema;
    private javax.swing.JButton btIngresar_IngresoAlSistema;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbContraseña_IngresoAlSistema;
    private javax.swing.JLabel lbUsuario_IngresoAlSistema;
    public static javax.swing.JPasswordField pswContraseña_IngresoAlSistema;
    public static javax.swing.JTextField txtNombreUsario_IngresoAlSistema;
    // End of variables declaration//GEN-END:variables
}
