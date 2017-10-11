package UI;

import LogicaDeNegocios.CoordinadorDeFacturaCompra;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarFacturaDeCompra extends javax.swing.JDialog {

    boolean tipoCompra;
    ArrayList<Object> listaParaMostrar = new ArrayList<>();

    public EditarFacturaDeCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        

    }

    public void LlenarDatosParaEdicion(String IdFacturaCompra, String NuPedido, String NuEntrega, String nombreProveedor,
            String nombreTipoPago, String NDeReferencia, String FechaDeCompra, boolean TipoDeCompra, float MontoTotal) {

        txtNumeroDeFactura_EditarFacturaCompra.setText(IdFacturaCompra);
        txtNPedido_EditarFacturaCompra.setText(NuPedido);
        txtNEntrega_EditarFacturaCompra.setText(NuEntrega);
        txtNReferencia_EditarFacturaCompra.setText(NDeReferencia);
        txtMontoDeCompra_EditarFacturaCompra.setText("" + MontoTotal);
        ListarProveedores();
        cbxProveedor_EditarFacturaCompra.setSelectedItem(nombreProveedor);
        ListarTiposDePago();
        cbxTipoPago_EditarFacturaCompra.setSelectedItem(nombreTipoPago);
        LlenarTipoCompra(TipoDeCompra);
        try {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(FechaDeCompra);
            jDCFecha_Compra.setDate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(EditarFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LlenarTipoCompra(boolean TipoCompra) {

        if (TipoCompra) {
            cbxTipoCompra_EditarFacturaCompra.setSelectedItem("Contado");
        } else {
            cbxTipoCompra_EditarFacturaCompra.setSelectedItem("Credito");
        }
    }

    public void ListarTiposDePago() {
        listaParaMostrar.clear();

        cbxTipoPago_EditarFacturaCompra.removeAllItems();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        listaParaMostrar = coordinador.ListarTiposDePago();

        cbxTipoPago_EditarFacturaCompra.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cbxTipoPago_EditarFacturaCompra.addItem(listaParaMostrar.get(i));
        }

    }

    public void ListarProveedores() {
        listaParaMostrar.clear();

        cbxProveedor_EditarFacturaCompra.removeAllItems();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        listaParaMostrar = coordinador.ListarNombreDeProveedores();

        cbxProveedor_EditarFacturaCompra.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cbxProveedor_EditarFacturaCompra.addItem(listaParaMostrar.get(i));
        }
    }

    public void EstablecerTipoCompra() {

        switch (cbxTipoCompra_EditarFacturaCompra.getSelectedItem().toString()) {

            case "Contado":
                tipoCompra = true;
                break;
            case "Credito":
                tipoCompra = false;
                break;
        }
    }

    public String ObtenerFecha() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(jDCFecha_Compra.getDate()));
    }

    public int ObtenerIdTipoPagoSeleccionado() {

        String tipoPagoSeleccionado = cbxTipoPago_EditarFacturaCompra.getSelectedItem().toString();

        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

        return coordinador.ObtenerIdTipoPago(tipoPagoSeleccionado);
    }

    public int ObtenerIdProveedorSeleccionado() {

        String proveedorSeleccionado = cbxProveedor_EditarFacturaCompra.getSelectedItem().toString();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

        return coordinador.ObtnerIdProveedor(proveedorSeleccionado);
    }

    public void EditarFactura() {
        txtNumeroDeFactura_EditarFacturaCompra.getText();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtNumeroDeFactura_EditarFacturaCompra = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        cbxProveedor_EditarFacturaCompra = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        txtMontoDeCompra_EditarFacturaCompra = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cbxTipoCompra_EditarFacturaCompra = new javax.swing.JComboBox();
        jDCFecha_Compra = new com.toedter.calendar.JDateChooser();
        btAceptar_EditarFacturaCompra = new javax.swing.JButton();
        btCancelar_EditarFacturaCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNPedido_EditarFacturaCompra = new javax.swing.JTextField();
        txtNEntrega_EditarFacturaCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNReferencia_EditarFacturaCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoPago_EditarFacturaCompra = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(300, 70));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel66.setText("Editar factura de compra");
        getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 49, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/invoice_22150 (1).png"))); // NOI18N
        getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 5, -1, -1));

        txtNumeroDeFactura_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNumeroDeFactura_EditarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNumeroDeFactura_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 145, 156, -1));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel63.setText("Número de factura ");
        getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 145, -1, 29));

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel65.setText("Proveedor");
        getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 145, -1, 29));

        cbxProveedor_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxProveedor_EditarFacturaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProveedor_EditarFacturaCompraMouseClicked(evt);
            }
        });
        getContentPane().add(cbxProveedor_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 145, 156, -1));

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel64.setText("Monto de compra");
        getContentPane().add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 285, -1, 35));

        txtMontoDeCompra_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDeCompra_EditarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        txtMontoDeCompra_EditarFacturaCompra.setToolTipText("Campo para ingresar nombre del producto");
        txtMontoDeCompra_EditarFacturaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoDeCompra_EditarFacturaCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoDeCompra_EditarFacturaCompraKeyTyped(evt);
            }
        });
        getContentPane().add(txtMontoDeCompra_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 285, 170, -1));

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel62.setText("Tipo de compra");
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 205, -1, 35));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setText("Fecha de compra");
        getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 225, 113, -1));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel69.setText("Tipo de pago");
        getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 285, -1, 35));

        cbxTipoCompra_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoCompra_EditarFacturaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Contado", "Credito" }));
        cbxTipoCompra_EditarFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoCompra_EditarFacturaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(cbxTipoCompra_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 215, 156, -1));
        getContentPane().add(jDCFecha_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 225, 156, -1));

        btAceptar_EditarFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarFacturaCompra.setToolTipText("Oprima para cancelar");
        btAceptar_EditarFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarFacturaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btAceptar_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, -1, 50));

        btCancelar_EditarFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_EditarFacturaCompra.setToolTipText("Oprima para cancelar");
        btCancelar_EditarFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_EditarFacturaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("N° de pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 355, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("N° de referencia");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 425, -1, -1));

        txtNPedido_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNPedido_EditarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNPedido_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 355, 160, -1));

        txtNEntrega_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNEntrega_EditarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNEntrega_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 345, 170, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("N° de entrega");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        txtNReferencia_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNReferencia_EditarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNReferencia_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 415, 160, -1));

        jLabel5.setText("* Pagos realizados a travez de cheques, transferencias o tarjeta de credito.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        cbxTipoPago_EditarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoPago_EditarFacturaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTipoPago_EditarFacturaCompraMouseClicked(evt);
            }
        });
        getContentPane().add(cbxTipoPago_EditarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 285, 160, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos requeridos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, 30));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 350, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProveedor_EditarFacturaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProveedor_EditarFacturaCompraMouseClicked
        ListarProveedores();
    }//GEN-LAST:event_cbxProveedor_EditarFacturaCompraMouseClicked

    private void txtMontoDeCompra_EditarFacturaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoDeCompra_EditarFacturaCompraKeyPressed

    }//GEN-LAST:event_txtMontoDeCompra_EditarFacturaCompraKeyPressed

    private void txtMontoDeCompra_EditarFacturaCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoDeCompra_EditarFacturaCompraKeyTyped


    }//GEN-LAST:event_txtMontoDeCompra_EditarFacturaCompraKeyTyped

    private void cbxTipoCompra_EditarFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoCompra_EditarFacturaCompraActionPerformed
        EstablecerTipoCompra();
    }//GEN-LAST:event_cbxTipoCompra_EditarFacturaCompraActionPerformed

    private void btAceptar_EditarFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarFacturaCompraActionPerformed


    }//GEN-LAST:event_btAceptar_EditarFacturaCompraActionPerformed

    private void btCancelar_EditarFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_EditarFacturaCompraActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelar_EditarFacturaCompraActionPerformed

    private void cbxTipoPago_EditarFacturaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoPago_EditarFacturaCompraMouseClicked
        ListarTiposDePago();
    }//GEN-LAST:event_cbxTipoPago_EditarFacturaCompraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_EditarFacturaCompra;
    public static javax.swing.JButton btCancelar_EditarFacturaCompra;
    public static javax.swing.JComboBox cbxProveedor_EditarFacturaCompra;
    private javax.swing.JComboBox cbxTipoCompra_EditarFacturaCompra;
    private javax.swing.JComboBox cbxTipoPago_EditarFacturaCompra;
    private com.toedter.calendar.JDateChooser jDCFecha_Compra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField txtMontoDeCompra_EditarFacturaCompra;
    private javax.swing.JTextField txtNEntrega_EditarFacturaCompra;
    private javax.swing.JTextField txtNPedido_EditarFacturaCompra;
    private javax.swing.JTextField txtNReferencia_EditarFacturaCompra;
    public static javax.swing.JTextField txtNumeroDeFactura_EditarFacturaCompra;
    // End of variables declaration//GEN-END:variables
}
