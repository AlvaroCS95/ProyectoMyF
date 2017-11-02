package UI;

import LogicaDeNegocios.CoordinadorDeAbonos;
import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import Modelos.Abono;
import static UI.CuentasPorPagar.VisualizarCuentasPorCobrar;
import static UI.CuentasPorPagar.VisualizarCuentasPorPagar;
import static UI.CuentasPorPagar.tbCuentasPorPagar;
import static UI.PuntoDeVenta.listaParaMostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IngresarAbono extends javax.swing.JDialog {

    int IdCuenta = 0;
    float MontoPendiente = 0;
    boolean Abono = false;

    public IngresarAbono(java.awt.Frame parent, boolean modal, int idCuenta, float montoPendiente, boolean abono) {
        super(parent, modal);
        this.IdCuenta = idCuenta;
        this.Abono = abono;
        this.MontoPendiente = montoPendiente;
        initComponents();
        txtIdCuenta_Abonos.setText(String.valueOf(idCuenta));
        ListarTiposDePago();
        setLocationRelativeTo(null);
    }

    public String TipoDePago() {
        return cbxTipoPago_Abono.getSelectedItem().toString();

    }

    public static void ListarTiposDePago() {

        listaParaMostrar.clear();

        cbxTipoPago_Abono.removeAllItems();
        CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
        listaParaMostrar = coordinador.ListarTiposDePago();
        cbxTipoPago_Abono.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cbxTipoPago_Abono.addItem(listaParaMostrar.get(i));
        }
        cbxTipoPago_Abono.setSelectedIndex(0);
    }

    public void ValidacionesDePago() {
        if (cbxTipoPago_Abono.getSelectedItem() != null) {
            String formaDePago = cbxTipoPago_Abono.getSelectedItem().toString();

            switch (formaDePago) {
                case "Seleccione...":
                    txtNDeReferencia.setEnabled(false);

                    break;
                case "Cheque":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");

                    break;
                case "Transacción bancaria":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");

                    break;
                case "Efectivo":
                    txtNDeReferencia.setEnabled(false);

                    txtNDeReferencia.setText("0");
                    break;
                case "Tarjeta de crédito":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");

                    break;
            }
        }
    }

    public void IngresarAbono() throws ClassNotFoundException, SQLException {

        if (ContieneCamposVacios() != true) {
            
            if (MontoPendiente >= Integer.parseInt(txtMontoAbono_Abonos.getText())) {
                CoordinadorDeAbonos elCoordinador = new CoordinadorDeAbonos();
                float MontoAbono = Float.parseFloat(txtMontoAbono_Abonos.getText());
                Abono elAbono = new Abono(IdCuenta, MontoAbono, TipoDePago());
                ResultSet ResultadoDeConsulta;
                if (Abono == false) {
                    ResultadoDeConsulta = elCoordinador.IngresarAbonos(elAbono);
                } else {
                    ResultadoDeConsulta = elCoordinador.IngresarAbonosVentas(elAbono);
                }

                if (ResultadoDeConsulta.next()) {
                    if (ResultadoDeConsulta.getString(1).equals("2")) {
                        JOptionPane.showMessageDialog(null, "Se ingreso el abono exitosamente");
                        if (Abono == false) {
                              VisualizarCuentasPorPagar(tbCuentasPorPagar);
                        } else {
                          VisualizarCuentasPorCobrar(tbCuentasPorPagar);
                        }
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error en la insercion:\nPosibles causas:\n1) No tiene permisos para ejecutar esta acción.\n"
                                + "2) El Abono ha sido registrado con anterioridad. \nComuniquese con el administrador.", "Error en la insercion", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El monto de abono no puede ser mayor al monto pendiente. \n"
                        + "El Monto pendiente de la factura es de: " + MontoPendiente);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor indique los "
                    + "\n datos que se le solicitan gracias.");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoPago_Abono = new javax.swing.JComboBox();
        btAceptar_Abono = new javax.swing.JButton();
        btLimpiar_Abono = new javax.swing.JButton();
        txtIdCuenta_Abonos = new javax.swing.JTextField();
        txtNDeReferencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMontoAbono_Abonos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Ingresar Abono");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Id cuenta");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Monto de abono");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Forma de pago");

        cbxTipoPago_Abono.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoPago_Abono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        cbxTipoPago_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoPago_AbonoActionPerformed(evt);
            }
        });

        btAceptar_Abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_Abono.setToolTipText("Oprimir para guardar usuario");
        btAceptar_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_AbonoActionPerformed(evt);
            }
        });

        btLimpiar_Abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_Abono.setToolTipText("Oprima para limpiar campos");
        btLimpiar_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_AbonoActionPerformed(evt);
            }
        });

        txtIdCuenta_Abonos.setEnabled(false);

        txtNDeReferencia.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("N° de referencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMontoAbono_Abonos, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtIdCuenta_Abonos))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNDeReferencia)
                            .addComponent(cbxTipoPago_Abono, 0, 137, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar_Abono)
                .addGap(48, 48, 48)
                .addComponent(btLimpiar_Abono, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(cbxTipoPago_Abono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCuenta_Abonos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNDeReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtMontoAbono_Abonos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAceptar_Abono)
                    .addComponent(btLimpiar_Abono))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       public boolean ContieneCamposVacios() {
        if (txtMontoAbono_Abonos.getText().isEmpty()
                || cbxTipoPago_Abono.getSelectedItem().equals("Seleccion...")
                || txtNDeReferencia.getText().isEmpty()) {
            return true;
        }
        return false;
    }
    private void btAceptar_AbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_AbonoActionPerformed
        try {
            IngresarAbono();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarAbono.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarAbono.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btAceptar_AbonoActionPerformed

    private void btLimpiar_AbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_AbonoActionPerformed

    }//GEN-LAST:event_btLimpiar_AbonoActionPerformed

    private void cbxTipoPago_AbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoPago_AbonoActionPerformed
        ValidacionesDePago();
    }//GEN-LAST:event_cbxTipoPago_AbonoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_Abono;
    public static javax.swing.JButton btLimpiar_Abono;
    public static javax.swing.JComboBox cbxTipoPago_Abono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtIdCuenta_Abonos;
    public static javax.swing.JTextField txtMontoAbono_Abonos;
    public static javax.swing.JTextField txtNDeReferencia;
    // End of variables declaration//GEN-END:variables
}
