/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import Modelos.Camion;
import static UI.ListarCamiones.TablaListarCamiones_ListarCamiones;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class IngresarCamiones extends javax.swing.JDialog {

    String NumeroDePlaca;
    String Marca;
    String Modelo = "";
    String Estilo;
    String Color;
    float Capacidad = 0;
    public IngresarCamiones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cerrar();
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
    public boolean VerificarEspacios() {

        if (txtNumeroDePlaca_IngresarCamion.getText().equals("")
                || txtMarca_IngresarCamion.getText().equals("")
                || txtEstilo_IngresarCamion.getText().equals("")
                || txtColor_IngresarCamion.getText().equals("")
               
                ) {
            return true;
        } else {
            return false;
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroDePlaca_IngresarCamion = new javax.swing.JTextField();
        txtMarca_IngresarCamion = new javax.swing.JTextField();
        txtEstilo_IngresarCamion = new javax.swing.JTextField();
        txtColor_IngresarCamion = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btAceptar_IngresarCamion = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        btLimpiar_IngresarCamion = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        date_IngresarCamion = new com.toedter.calendar.JDateChooser();
        YCModelo_IngresarCamion = new com.toedter.calendar.JYearChooser();
        SpinnerCantidad_IngresarCamion = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNumeroDePlaca_IngresarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNumeroDePlaca_IngresarCamion.setForeground(new java.awt.Color(0, 102, 102));
        txtNumeroDePlaca_IngresarCamion.setToolTipText("Ingrese n° de placa.");

        txtMarca_IngresarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMarca_IngresarCamion.setForeground(new java.awt.Color(0, 102, 102));
        txtMarca_IngresarCamion.setToolTipText("Ingrese marca.");

        txtEstilo_IngresarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtEstilo_IngresarCamion.setForeground(new java.awt.Color(0, 102, 102));
        txtEstilo_IngresarCamion.setToolTipText("Ingrese estilo.");

        txtColor_IngresarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtColor_IngresarCamion.setForeground(new java.awt.Color(0, 102, 102));
        txtColor_IngresarCamion.setToolTipText("Ingrese color.");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Color");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Estilo");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setText("Marca");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Número de placa");

        btAceptar_IngresarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarCamion.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_IngresarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarCamionActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Fecha de compra ");

        btLimpiar_IngresarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarCamion.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarCamionActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Módelo");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Capacidad");

        date_IngresarCamion.setToolTipText("Seleccione fecha.");

        YCModelo_IngresarCamion.setToolTipText("Especifiquee año de fabricación.");

        SpinnerCantidad_IngresarCamion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        SpinnerCantidad_IngresarCamion.setToolTipText("Indique capacidad en toneladas.");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setAlignmentX(5.0F);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setText("Ingreso de camiones");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lorry_Green_icon-icons.com_54887 (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(43, 43, 43)
                                                .addComponent(txtNumeroDePlaca_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addGap(107, 107, 107)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtEstilo_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMarca_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtColor_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAceptar_IngresarCamion)
                                .addGap(66, 66, 66)
                                .addComponent(btLimpiar_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel32))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addGap(18, 18, 18)
                                    .addComponent(date_IngresarCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel25))
                                    .addGap(88, 88, 88)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(YCModelo_IngresarCamion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SpinnerCantidad_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(53, 53, 53)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(date_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(YCModelo_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(SpinnerCantidad_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAceptar_IngresarCamion)
                            .addComponent(btLimpiar_IngresarCamion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(txtNumeroDePlaca_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel27))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(txtMarca_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel29))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtEstilo_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel28))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtColor_IngresarCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void LimpiarCampos(){
      txtColor_IngresarCamion.setText("");
      txtEstilo_IngresarCamion.setText("");
      txtMarca_IngresarCamion.setText("");
      txtNumeroDePlaca_IngresarCamion.setText("");
     }
public String ObtenerFechaDesde() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(date_IngresarCamion.getDate()));
    }
public void IngresarCamion() throws ClassNotFoundException, SQLException {
        if (VerificarEspacios() == true) {
            JOptionPane.showMessageDialog(null, "Por favor rellene los compos");
        } else {
            NumeroDePlaca = txtNumeroDePlaca_IngresarCamion.getText();
            Marca = txtMarca_IngresarCamion.getText();
            Estilo = txtEstilo_IngresarCamion.getText();
            Color = txtColor_IngresarCamion.getText();
            Modelo= ""+YCModelo_IngresarCamion.getYear();
            Capacidad= Float.parseFloat(SpinnerCantidad_IngresarCamion.getValue().toString());
           
     

            CoordinadorDeCamion elCoordinadorDeCamion = new CoordinadorDeCamion();
            Camion elCamion = new Camion(NumeroDePlaca, Marca, Modelo, Estilo, Color, ObtenerFechaDesde(), Capacidad);
            if (elCoordinadorDeCamion.InsertarCamion(elCamion) == true) {
                JOptionPane.showMessageDialog(null, "El camion ha sido insertado exitosamente");
                LimpiarCampos();
                 ListarCamiones.VisualizarCamion(TablaListarCamiones_ListarCamiones); 
            } else {
                JOptionPane.showMessageDialog(null, "Error en la insercion");
            }

        }

    }
    private void btAceptar_IngresarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarCamionActionPerformed
        try {
            IngresarCamion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarCamiones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarCamiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAceptar_IngresarCamionActionPerformed

    private void btLimpiar_IngresarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarCamionActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_IngresarCamionActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JSpinner SpinnerCantidad_IngresarCamion;
    public static com.toedter.calendar.JYearChooser YCModelo_IngresarCamion;
    public static javax.swing.JButton btAceptar_IngresarCamion;
    public static javax.swing.JButton btLimpiar_IngresarCamion;
    public static com.toedter.calendar.JDateChooser date_IngresarCamion;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTextField txtColor_IngresarCamion;
    public static javax.swing.JTextField txtEstilo_IngresarCamion;
    public static javax.swing.JTextField txtMarca_IngresarCamion;
    public static javax.swing.JTextField txtNumeroDePlaca_IngresarCamion;
    // End of variables declaration//GEN-END:variables
}
