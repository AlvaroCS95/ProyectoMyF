/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import LogicaDeNegocios.CoordinadorDeRutas;
import LogicaDeNegocios.CoordinadorDeUsuarios;
import Modelos.Carga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class EditarCarga extends javax.swing.JFrame {

    /**
     * Creates new form EditarCarga
     */
    public static String PlacaDeCamion = "", usuario;
    public static Date FechaCarga;
    public static int IdCarga = 0;

    public EditarCarga(String PlacaCamion, Date FechaCarga, int idCamion, String usu) throws ClassNotFoundException {
        initComponents();
        this.PlacaDeCamion = PlacaCamion;
        this.FechaCarga = FechaCarga;
        this.IdCarga = idCamion;
        this.usuario = usu;
        txtIdCarga_EditarCarga.setText("" + IdCarga);

        ListarTodasLasPlacas();
        ListarTodasLosUsuarios();
        ListarTodasLasRutas();
        jComboPlacas_EditarCarga.setSelectedItem(PlacaDeCamion);
        jComboUsuarios_EditarCarga.setSelectedItem(usuario);
        setLocationRelativeTo(null);
    }

    public static void ListarTodasLasPlacas() {
        try {
            CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();
            ResultSet resultadoConsulta = elCoordinador.ListarTodasLasPlacas();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                jComboPlacas_EditarCarga.addItem(resultadoConsulta.getString(1));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }
public static void ListarTodasLasRutas() {
        try {
            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarRutasActivas();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                jComboRuta_EditarCarga.addItem(resultadoConsulta.getString(2));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }
    public static void ListarTodasLosUsuarios() {
        try {
            CoordinadorDeUsuarios elCoordinador = new CoordinadorDeUsuarios();
            ResultSet resultadoConsulta = elCoordinador.ListarUsuariosActivosParaCargas();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                jComboUsuarios_EditarCarga.addItem(resultadoConsulta.getString(2));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }
public int ObtenerIdRuta() throws SQLException, ClassNotFoundException {
        int id = 0;
        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
        ResultSet resultadoConsulta = elCoordinador.ListarRutasActivas();
        if (resultadoConsulta == null) {
            JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);

        } else {
            while (resultadoConsulta.next()) {
                if (resultadoConsulta.getString(2).equals(jComboRuta_EditarCarga.getSelectedItem().toString())) {
                    id = Integer.parseInt(resultadoConsulta.getString(1));

                    return id;
                }
            }
        }
        return id;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCarga_EditarCarga = new javax.swing.JTextField();
        jComboPlacas_EditarCarga = new javax.swing.JComboBox<String>();
        btAceptar_EditarCarga = new javax.swing.JButton();
        btSalir_EditarCarga = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboUsuarios_EditarCarga = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jComboRuta_EditarCarga = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Editar Carga");

        jLabel2.setText("Id de Carga:");

        jLabel3.setText("Placa de Camión:");

        txtIdCarga_EditarCarga.setEnabled(false);

        btAceptar_EditarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarCargaActionPerformed(evt);
            }
        });

        btSalir_EditarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btSalir_EditarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalir_EditarCargaActionPerformed(evt);
            }
        });

        jLabel5.setText("Usuario responsable");

        jComboUsuarios_EditarCarga.setDoubleBuffered(true);

        jLabel6.setText("Ruta asignada");

        jComboRuta_EditarCarga.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdCarga_EditarCarga)
                                    .addComponent(jComboPlacas_EditarCarga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboRuta_EditarCarga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboUsuarios_EditarCarga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAceptar_EditarCarga)
                            .addComponent(btSalir_EditarCarga, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCarga_EditarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboPlacas_EditarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAceptar_EditarCarga)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboUsuarios_EditarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboRuta_EditarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btSalir_EditarCarga))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalir_EditarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalir_EditarCargaActionPerformed
        dispose();
    }//GEN-LAST:event_btSalir_EditarCargaActionPerformed
    public int ObtenerIdUsuario() throws SQLException, ClassNotFoundException {
        int id = 0;
        CoordinadorDeUsuarios elCoordinador = new CoordinadorDeUsuarios();
        ResultSet resultadoConsulta = elCoordinador.ListarUsuariosActivosParaCargas();
        if (resultadoConsulta == null) {
            JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);

        } else {
            while (resultadoConsulta.next()) {
                if (resultadoConsulta.getString(2).equals(jComboUsuarios_EditarCarga.getSelectedItem().toString())) {
                    id = Integer.parseInt(resultadoConsulta.getString(1));

                    return id;
                }
            }
        }
        return id;
    }
    private void btAceptar_EditarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarCargaActionPerformed
        try {

            Carga laCarga = new Carga();
            laCarga.setIdCamion(jComboPlacas_EditarCarga.getSelectedItem().toString());
            laCarga.setUsuario(ObtenerIdUsuario());
            laCarga.setIdRuta(ObtenerIdRuta());

            laCarga.setIdCarga(Integer.parseInt(txtIdCarga_EditarCarga.getText()));
            CoordinadorDeCamion elCoordinadorDeCamion = new CoordinadorDeCamion();
            try {
                ResultSet Exito = elCoordinadorDeCamion.EditarCarga(laCarga);
                if (Exito.next()) {
                    if (Exito.getString(1).equals("1")) {
                        JOptionPane.showMessageDialog(null, "Se edito con exito la carga");
                        VisualizaryEditarCargas.ListarCargas();
                        dispose();
                    } else if (Exito.getString(1).equals("3")) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "La carga no se puede editar porque se encuentra en ruta");
                        
                        dispose();
                    } else {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Se produjo un error a la hora de actualizar la carga");

                    }
                } else {
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarCarga.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EditarCarga.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditarCarga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarCarga.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btAceptar_EditarCargaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar_EditarCarga;
    private javax.swing.JButton btSalir_EditarCarga;
    public static javax.swing.JComboBox<String> jComboPlacas_EditarCarga;
    public static javax.swing.JComboBox<String> jComboRuta_EditarCarga;
    public static javax.swing.JComboBox<String> jComboUsuarios_EditarCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIdCarga_EditarCarga;
    // End of variables declaration//GEN-END:variables
}
