
package UI;


import LogicaDeNegocios.CoordinadorDeUsuarios;
import static UI.EditarUsuario.txtCedula_EditarUsuario;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class CambiarContraseña extends javax.swing.JDialog {

    public boolean indicador;
    Icon icono;

    public CambiarContraseña(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cerrar();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpsContraseñaActual_CambiarContraseña = new javax.swing.JPasswordField();
        jpsNuevaContraseña_CambiarContraseña = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btCancelar_CambiarContraseña = new javax.swing.JButton();
        btAceptar_CambiarContraseña = new javax.swing.JButton();
        btLimpiar_CambiarContraseña = new javax.swing.JButton();
        VerContraseña = new javax.swing.JLabel();
        VerContraseñaNueva = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cambio de contraseña");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Cambio de contraseña");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña actual");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nueva contraseña");

        btCancelar_CambiarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_CambiarContraseña.setToolTipText("Oprima para cancelar");
        btCancelar_CambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_CambiarContraseñaActionPerformed(evt);
            }
        });

        btAceptar_CambiarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_CambiarContraseña.setToolTipText("Oprimir para guardar usuario");
        btAceptar_CambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_CambiarContraseñaActionPerformed(evt);
            }
        });

        btLimpiar_CambiarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_CambiarContraseña.setToolTipText("Oprima para limpiar campos");
        btLimpiar_CambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_CambiarContraseñaActionPerformed(evt);
            }
        });

        VerContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"))); // NOI18N
        VerContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerContraseñaMouseClicked(evt);
            }
        });

        VerContraseñaNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"))); // NOI18N
        VerContraseñaNueva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerContraseñaNueva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerContraseñaNuevaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(jpsNuevaContraseña_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VerContraseñaNueva)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jpsContraseñaActual_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VerContraseña)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btCancelar_CambiarContraseña)
                        .addGap(40, 40, 40)
                        .addComponent(btAceptar_CambiarContraseña)
                        .addGap(48, 48, 48)
                        .addComponent(btLimpiar_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jpsContraseñaActual_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(VerContraseña)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jpsNuevaContraseña_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(VerContraseñaNueva)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar_CambiarContraseña)
                    .addComponent(btAceptar_CambiarContraseña)
                    .addComponent(btLimpiar_CambiarContraseña))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void btCancelar_CambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_CambiarContraseñaActionPerformed
        int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            // JTPGestor.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btCancelar_CambiarContraseñaActionPerformed
    public void verContraseña(JPasswordField campoMostar, JLabel Etiqueta) {

        if (indicador == false) {
            campoMostar.setEchoChar((char) 0);
            indicador = true;
            icono = new ImageIcon(getClass().getResource("/Imagenes/OcultarContraseña.png"));
            Etiqueta.setIcon(icono);
        } else {

            campoMostar.setEchoChar('*');
            indicador = false;
            icono = new ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"));
            Etiqueta.setIcon(icono);
        }

    }

    public boolean VerificarCamposVacios() {

        if (jpsContraseñaActual_CambiarContraseña.getText().equals("")
                || jpsNuevaContraseña_CambiarContraseña.getText().equals("")) {

            return true;
        }
        return false;
    }

    public void LimpiarCampos() {

        jpsContraseñaActual_CambiarContraseña.setText("");
        jpsNuevaContraseña_CambiarContraseña.setText("");

    }
    private void btAceptar_CambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_CambiarContraseñaActionPerformed
        if (VerificarCamposVacios() == true) {

            JOptionPane.showMessageDialog(null, "Por favor rellene los campos obligatorios");
            return;
        } else {
             CoordinadorDeUsuarios elCoordinadorDeUsuarios= new CoordinadorDeUsuarios();
             String cedula=txtCedula_EditarUsuario.getText();
              char[] contraseña = jpsContraseñaActual_CambiarContraseña.getPassword();
             String   contraseñaActual = new String(contraseña);
              char[] contraseñaN = jpsNuevaContraseña_CambiarContraseña.getPassword();
             String   contraseñaNueva = new String(contraseñaN);
           ResultSet Respuesta = null; 
            try {
                Respuesta = elCoordinadorDeUsuarios.CambiarContraseña(cedula,contraseñaActual,contraseñaNueva);
            } catch (SQLException ex) {
                Logger.getLogger(CambiarContraseña.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CambiarContraseña.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(Respuesta.next()){
                   
                    if(Respuesta.getString(1).equals("1")){
                        JOptionPane.showMessageDialog(null,"Cambio de contraseña exitoso");
                        LimpiarCampos();
                        dispose();
                        ListarUsuarios.VisualizarUsuarios();
                        
                    }else {
                        JOptionPane.showMessageDialog(null,"La contraseña que proporciono no es la correcta intente de nuevo");
                         dispose();
                     
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CambiarContraseña.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btAceptar_CambiarContraseñaActionPerformed

    private void btLimpiar_CambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_CambiarContraseñaActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_CambiarContraseñaActionPerformed

    private void VerContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerContraseñaMouseClicked
        verContraseña(jpsContraseñaActual_CambiarContraseña, VerContraseña);
    }//GEN-LAST:event_VerContraseñaMouseClicked

    private void VerContraseñaNuevaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerContraseñaNuevaMouseClicked
        verContraseña(jpsNuevaContraseña_CambiarContraseña, VerContraseñaNueva);
    }//GEN-LAST:event_VerContraseñaNuevaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel VerContraseña;
    public javax.swing.JLabel VerContraseñaNueva;
    public static javax.swing.JButton btAceptar_CambiarContraseña;
    public static javax.swing.JButton btCancelar_CambiarContraseña;
    public static javax.swing.JButton btLimpiar_CambiarContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JPasswordField jpsContraseñaActual_CambiarContraseña;
    public javax.swing.JPasswordField jpsNuevaContraseña_CambiarContraseña;
    // End of variables declaration//GEN-END:variables
}
