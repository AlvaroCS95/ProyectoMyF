package UI;

import LogicaDeNegocios.CoordinadorDeAbonos;
import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import LogicaDeNegocios.IMPRIMIR;
import Modelos.Abono;
import static UI.CuentasPorPagar.VisualizarCuentasPorCobrar;
import static UI.CuentasPorPagar.VisualizarCuentasPorPagar;
import static UI.CuentasPorPagar.tbCuentasPorPagar;
import static UI.PuntoDeVenta.listaParaMostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class IngresarAbono extends javax.swing.JDialog {
    
    String IdCuenta = "";
    float MontoPendiente = 0;
    boolean Abono = false;
    static String txt = "", cliente;
    public static Date date = new Date();
    public static DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    
    public IngresarAbono(java.awt.Frame parent, boolean modal, String idCuenta, float montoPendiente, boolean abono, String Cli) {
        super(parent, modal);
        this.IdCuenta = idCuenta;
        this.Abono = abono;
        this.MontoPendiente = montoPendiente;
        this.cliente = Cli;
        initComponents();
        txtIdCuenta_Abonos.setText(String.valueOf(idCuenta));
        txt_MontoPendiente.setText("" + MontoPendiente);
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
            
            if (MontoPendiente >= Float.parseFloat(txtMontoAbono_Abonos.getText())) {
                CoordinadorDeAbonos elCoordinador = new CoordinadorDeAbonos();
                float MontoAbono = Float.parseFloat(txtMontoAbono_Abonos.getText());
                Abono elAbono = new Abono(IdCuenta, MontoAbono, TipoDePago());
                ResultSet ResultadoDeConsulta = null;
                String tipo = "";
                if (Abono == false) {
                    ResultadoDeConsulta = elCoordinador.IngresarAbonos(elAbono);
                } else if (Abono == true) {
                    ResultadoDeConsulta = elCoordinador.IngresarAbonosVentas(elAbono);
                }
                
                if (ResultadoDeConsulta.next()) {
                    if (ResultadoDeConsulta.getString(1).equals("2")) {
                        JOptionPane.showMessageDialog(null, "Se ingreso el abono exitosamente");
                        
                        if (Abono == false) {
                            VisualizarCuentasPorPagar(tbCuentasPorPagar);
                            tipo = "Proveedor";
                        } else {
                            VisualizarCuentasPorCobrar(tbCuentasPorPagar);
                            tipo = "Cliente";
                        }
                        imprimir(tipo);
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
    
    public static int CantidadDeFilas(String txt) {
        Matcher m = Pattern.compile("\r\n|\r|\n").matcher(txt);
        int lines = 1;
        while (m.find()) {
            lines++;
        }
        return lines;
    }
    
    public void imprimir(String abonar) throws SQLException, ClassNotFoundException {
        txt = "";
        CoordinadorDeAbonos elCoordinador = new CoordinadorDeAbonos();
        int Id = elCoordinador.DevolverUltimoIdFacturaAbono();
        txt += "         FACTURA DE ABONO"
                + "\nN.Fac de abono:" + Id
                + "\nN.Fac a abonar:" + txtIdCuenta_Abonos.getText()
                + "\n" + abonar + ":" + cliente
                + "\nFec.Abn:" + hourdateFormat.format(date)
                + "\nT.Pago:" + TipoDePago()
                + "\nMonto de abono:" + txtMontoAbono_Abonos.getText()
                + "\nMonto pendiente:" + (MontoPendiente - (Float.parseFloat(txtMontoAbono_Abonos.getText())))
                + "\n\n\n\n______________________________"
                + "\n\t\t\t       Firma autorizada";
        
        IMPRIMIR imprimir = new IMPRIMIR(txt, CantidadDeFilas(txt), txt.length());
        
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
        jLabel6 = new javax.swing.JLabel();
        txt_MontoPendiente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abono de cuentas");
        setPreferredSize(new java.awt.Dimension(640, 310));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Ingresar Abono");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 46, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Id cuenta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 105, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Monto de abono");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 194, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Forma de pago");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 105, -1, -1));

        cbxTipoPago_Abono.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoPago_Abono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        cbxTipoPago_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoPago_AbonoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxTipoPago_Abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 99, 137, 28));

        btAceptar_Abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_Abono.setToolTipText("Oprimir para guardar usuario");
        btAceptar_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_AbonoActionPerformed(evt);
            }
        });
        getContentPane().add(btAceptar_Abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 201, -1, -1));

        btLimpiar_Abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_Abono.setToolTipText("Oprima para limpiar campos");
        btLimpiar_Abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_AbonoActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpiar_Abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 201, 64, -1));

        txtIdCuenta_Abonos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtIdCuenta_Abonos.setEnabled(false);
        getContentPane().add(txtIdCuenta_Abonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 99, 147, 28));

        txtNDeReferencia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNDeReferencia.setEnabled(false);
        getContentPane().add(txtNDeReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 145, 137, 27));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("N° de referencia");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 149, -1, -1));

        txtMontoAbono_Abonos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(txtMontoAbono_Abonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 190, 150, 27));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Monto pendiente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 151, -1, -1));

        txt_MontoPendiente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_MontoPendiente.setEnabled(false);
        getContentPane().add(txt_MontoPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 145, 147, 30));

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
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtIdCuenta_Abonos;
    public static javax.swing.JTextField txtMontoAbono_Abonos;
    public static javax.swing.JTextField txtNDeReferencia;
    private javax.swing.JTextField txt_MontoPendiente;
    // End of variables declaration//GEN-END:variables
}
