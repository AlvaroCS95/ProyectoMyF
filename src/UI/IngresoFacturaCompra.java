package UI;

import LogicaDeNegocios.CoordinadorDeFacturaCompra;
import Modelos.FacturaDeCompra;
import Modelos.Producto;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IngresoFacturaCompra extends javax.swing.JPanel {

    String tx_idFacturaCompra, tx_nPedido, tx_nEntrega, tx_fechaDeCompra;
    int tx_idProveedor, tx_idTipoPago, tx_nDeReferencia, plazoDias;
    boolean tx_tipoDeCompra;
    float tx_montoTotal, montoCanclado;
  static  ArrayList<Object> listaParaMostrar = new ArrayList<>();
    ResultSet resultadoConsulta;
   static DefaultTableModel modelo;
    static Object[] filas;

    public IngresoFacturaCompra() {
        initComponents();
//        ListarProveedores();
//        ListarTiposDePago();
//        scroll_IngresoFacturaCompra.getVerticalScrollBar().setUnitIncrement(15);
    }

    public void IngresarFacturaCompra() {
        if (VerificarCamposVacios()) {

            tx_idFacturaCompra = txtNumeroDeFactura_IngresarFacturaCompra.getText();
            tx_nPedido = txtN_Pedido.getText();
            tx_nEntrega = txtN_Entrega.getText();
            tx_fechaDeCompra = ObtenerFecha();
            tx_idProveedor = ObtenerIdProveedorSeleccionado();
            if (tx_tipoDeCompra) {
                tx_idTipoPago = ObtenerIdTipoPagoSeleccionado();
            } else {
                tx_idTipoPago = 1;
            }
            tx_nDeReferencia = Integer.parseInt(txtN_Referencia.getText());
            tx_montoTotal = Float.parseFloat(txtMontoDeCompra_IngresarFacturaCompra.getText());
            plazoDias = Integer.parseInt(txtPlazoDias_IngresarFacturaCompra.getText());
            montoCanclado = Float.parseFloat(txtMontoCancelado_IngresarFacturaCompra.getText());

            FacturaDeCompra nuevaFactura = new FacturaDeCompra(tx_idFacturaCompra, tx_nPedido, tx_nEntrega,
                    tx_idProveedor, tx_idTipoPago, tx_nDeReferencia, tx_fechaDeCompra, tx_tipoDeCompra,
                    tx_montoTotal, montoCanclado, plazoDias);

            CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

            boolean resultadoInsercion = coordinador.CrearFacturaCompra(nuevaFactura);
            if (resultadoInsercion) {

                JOptionPane.showMessageDialog(null, "¡Factura N° "
                        + tx_idFacturaCompra + " ha sido agregada exitosamente!");
                LimpiarCampos();

            } else {
                JOptionPane.showMessageDialog(null, "¡Error en ingreso, verifique los datos!");
            }

        }
    }

    public void LimpiarCampos() {

        txtNumeroDeFactura_IngresarFacturaCompra.setText("");
        txtN_Pedido.setText("");
        txtN_Entrega.setText("");
        jDCFecha_Compra.setCalendar(null);
        cbxTipoCompra_IngresarFacturaCompra.setSelectedIndex(0);
        cbxProveedor_IngresarFacturaCompra.setSelectedIndex(0);
        cbxTipoPago_FacturaCompra.setSelectedIndex(0);
        txtN_Referencia.setText("");
        txtMontoDeCompra_IngresarFacturaCompra.setText("");
        txtMontoCancelado_IngresarFacturaCompra.setText("");
        txtPlazoDias_IngresarFacturaCompra.setText("");

    }

    public static void ListarProveedores() {
        listaParaMostrar.clear();

        cbxProveedor_IngresarFacturaCompra.removeAllItems();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        listaParaMostrar = coordinador.ListarNombreDeProveedores();

        cbxProveedor_IngresarFacturaCompra.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cbxProveedor_IngresarFacturaCompra.addItem(listaParaMostrar.get(i));
        }
    }

    public static void ListarTiposDePago() {
        listaParaMostrar.clear();

        cbxTipoPago_FacturaCompra.removeAllItems();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        listaParaMostrar = coordinador.ListarTiposDePago();

        cbxTipoPago_FacturaCompra.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cbxTipoPago_FacturaCompra.addItem(listaParaMostrar.get(i));
        }
    }

    public int ObtenerIdTipoPagoSeleccionado() {

        String tipoPagoSeleccionado = cbxTipoPago_FacturaCompra.getSelectedItem().toString();

        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

        return coordinador.ObtenerIdTipoPago(tipoPagoSeleccionado);
    }

    public int ObtenerIdProveedorSeleccionado() {

        String proveedorSeleccionado = cbxProveedor_IngresarFacturaCompra.getSelectedItem().toString();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

        return coordinador.ObtnerIdProveedor(proveedorSeleccionado);
    }

    public String ObtenerFecha() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(jDCFecha_Compra.getDate()));
    }

    public void EstablecerTipoCompra() {

        switch (cbxTipoCompra_IngresarFacturaCompra.getSelectedItem().toString()) {

            case "Contado":

                tx_tipoDeCompra = true;
                txtPlazoDias_IngresarFacturaCompra.setEnabled(false);
                txtMontoCancelado_IngresarFacturaCompra.setEnabled(false);
                txtMontoCancelado_IngresarFacturaCompra.setText("0");
                txtPlazoDias_IngresarFacturaCompra.setText("0");
                txtN_Referencia.setEnabled(true);
                txtN_Referencia.setText("0");
                cbxTipoPago_FacturaCompra.setEnabled(true);

                break;
            case "Credito":

                tx_tipoDeCompra = false;
                cbxTipoPago_FacturaCompra.setSelectedItem("Seleccione...");
                cbxTipoPago_FacturaCompra.setEnabled(false);
                txtPlazoDias_IngresarFacturaCompra.setEnabled(true);
                txtMontoCancelado_IngresarFacturaCompra.setEnabled(true);
                txtMontoCancelado_IngresarFacturaCompra.setText("");
                txtPlazoDias_IngresarFacturaCompra.setText("");
                txtN_Referencia.setEnabled(false);
                txtN_Referencia.setText("0");

                break;
        }
    }

    public boolean VerificarCamposVacios() {

        String mensaje = "";

        if (txtNumeroDeFactura_IngresarFacturaCompra.getText().isEmpty()) {

            mensaje += "¡Debe ingresar el numero de factura de compra!";
        } else if (cbxProveedor_IngresarFacturaCompra.getSelectedItem() == "Seleccione...") {

            mensaje += "\n¡Debe selecionar un proveedor!";
        } else if (jDCFecha_Compra.getDate() == null) {

            mensaje += "\n¡Debe selecionar una fecha de compra!";
        } else if (cbxTipoCompra_IngresarFacturaCompra.getSelectedItem() == "Seleccione...") {

            mensaje += "\n¡Debe selecionar un tipo de compra!";
        } else if (cbxTipoPago_FacturaCompra.getSelectedItem() == "Seleccione..."
                && !cbxTipoCompra_IngresarFacturaCompra.getSelectedItem().toString().equals("Credito")) {

            mensaje += "\n¡Debe selecionar un tipo de pago!";
        } else if (txtMontoDeCompra_IngresarFacturaCompra.getText().isEmpty()) {

            mensaje += "\n¡Debe ingresar el monto de la compra!";
        } else if (!cbxTipoPago_FacturaCompra.getSelectedItem().toString().equals("Efectivo")
                && txtN_Referencia.getText().isEmpty()) {

            mensaje += "\n¡Debe ingresar el numero de referencia!";
        } else if (((tx_tipoDeCompra == false) && (txtPlazoDias_IngresarFacturaCompra.getText().isEmpty()
                || txtMontoCancelado_IngresarFacturaCompra.getText().isEmpty()))) {
            if (txtPlazoDias_IngresarFacturaCompra.getText().isEmpty()) {
                mensaje += "\n¡Debe ingresar la cantidad de dias para cancelar factura!";
            } else {
                txtMontoCancelado_IngresarFacturaCompra.setText("0");
            }
        }
        if (!mensaje.equals("")) {
            JOptionPane.showMessageDialog(null, mensaje, "Error en la creacion de la Factura", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void ValidacionSoloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (c == KeyEvent.VK_ENTER) {

            getToolkit().beep();

            evt.consume();

            JOptionPane.showMessageDialog(this, "<html><h3><FONT FACE=\"times new roman\">"
                    + "No puede ingresar letras</FONT></h3></html>", "Error", 0);
        }
    }

    public void AgregarProductoComoDetalle() {

        if (!txtCodigoDetalleFactura.getText().isEmpty() && !txtCantidadDetalleFactura.getText().isEmpty()
                && !txtPrecioDeCompra.getText().isEmpty()) {
            try {
                String codigo = txtCodigoDetalleFactura.getText();
                float cantidad = Float.parseFloat(txtCantidadDetalleFactura.getText());
                float precio = Float.parseFloat(txtPrecioDeCompra.getText());
                CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
                resultadoConsulta = coordinador.BuscarParaAgregarDetalle(codigo);

                modelo = (DefaultTableModel) JTIngresoDetalleFacturaCompra.getModel();
                
                filas = new Object[5];
                for (int i = 0; i < 3; i++) {
                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                filas[3] = precio;
                filas[4] = cantidad;
                modelo.addRow(filas);
                JTIngresoDetalleFacturaCompra.setModel(modelo);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "¡Error, verifique que los datos sean correctos!");
            } catch (SQLException ex) {
                Logger.getLogger(IngresoFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>¡Los datos <b><FONT FACE=\"times new roman\">"
                    + "Código </FONT></b>, <b><FONT FACE=\"times new roman\">Cantidad </FONT></b>y "
                    + "<b><FONT FACE=\"times new roman\">Precio de compra</FONT></b> son requeridos!</html>",
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void IngresarDetalles() {
        try {
            CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
            int exitos = 0;
            for (int i = 0; i < JTIngresoDetalleFacturaCompra.getRowCount(); i++) {
                String codigo = JTIngresoDetalleFacturaCompra.getValueAt(i, 0).toString();
                float precio = Float.parseFloat(JTIngresoDetalleFacturaCompra.getValueAt(i, 3).toString());
                float cantidad = Float.parseFloat(JTIngresoDetalleFacturaCompra.getValueAt(i, 4).toString());
                Producto NuevoDetalle = new Producto(codigo, "", 0, cantidad, precio, 0);
                boolean sentinela = coordinador.AgregarDetalle(NuevoDetalle);
                if (sentinela) {
                    exitos++;
                }
            }
            if (exitos == JTIngresoDetalleFacturaCompra.getRowCount()) {
                JOptionPane.showMessageDialog(null, "¡Todos los productos fueron agregados con exito!");
                LimpiarDetalles();
            } else {
                JOptionPane.showMessageDialog(null, "¡Algunos productos no se ingresaron con exito, "
                        + "por favor verifique los datos!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ocurrieron errores durante la inserción!"
                    + "\nPor favor dirijase a la pestaña inventario y verifique que\n los productos se hayan "
                    + "ingresado correctamente, de no ser así, vuelva\n a agregar los productos faltantes.",
                    "¡Oh, algo anda mal!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LimpiarDetalles(){
        txtPrecioDeCompra.setText("");
        txtCantidadDetalleFactura.setText("");
        txtCodigoDetalleFactura.setText("");
        modelo.setRowCount(0);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_IngresoFacturaCompra = new javax.swing.JScrollPane();
        panel_IngreosFacturaCompra = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtNumeroDeFactura_IngresarFacturaCompra = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        cbxProveedor_IngresarFacturaCompra = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        txtMontoDeCompra_IngresarFacturaCompra = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cbxTipoCompra_IngresarFacturaCompra = new javax.swing.JComboBox();
        jDCFecha_Compra = new com.toedter.calendar.JDateChooser();
        btAceptar_IngresarDetalleFacturaCompra = new javax.swing.JButton();
        btLimpiar_IngresarFacturaCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtN_Pedido = new javax.swing.JTextField();
        txtN_Entrega = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtN_Referencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoPago_FacturaCompra = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMontoCancelado_IngresarFacturaCompra = new javax.swing.JTextField();
        txtPlazoDias_IngresarFacturaCompra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTIngresoDetalleFacturaCompra = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        boton_ListoDatosFacturaCompra = new javax.swing.JButton();
        txtCodigoDetalleFactura = new javax.swing.JTextField();
        JBBuscarParaAgregarDetalle = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCantidadDetalleFactura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioDeCompra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(990, 631));
        setLayout(null);

        scroll_IngresoFacturaCompra.setBackground(new java.awt.Color(153, 255, 102));
        scroll_IngresoFacturaCompra.setBorder(null);

        panel_IngreosFacturaCompra.setPreferredSize(new java.awt.Dimension(1343, 1370));
        panel_IngreosFacturaCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel66.setText("Ingreso de factura de compra");
        panel_IngreosFacturaCompra.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/invoice_22150 (1).png"))); // NOI18N
        panel_IngreosFacturaCompra.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        txtNumeroDeFactura_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNumeroDeFactura_IngresarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        panel_IngreosFacturaCompra.add(txtNumeroDeFactura_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 156, -1));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel63.setText("Número de factura ");
        panel_IngreosFacturaCompra.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 29));

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel65.setText("Proveedor");
        panel_IngreosFacturaCompra.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, 29));

        cbxProveedor_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxProveedor_IngresarFacturaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProveedor_IngresarFacturaCompraMouseClicked(evt);
            }
        });
        panel_IngreosFacturaCompra.add(cbxProveedor_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 156, -1));

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel64.setText("Monto de compra");
        panel_IngreosFacturaCompra.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, 35));

        txtMontoDeCompra_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDeCompra_IngresarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        txtMontoDeCompra_IngresarFacturaCompra.setToolTipText("Campo para ingresar nombre del producto");
        txtMontoDeCompra_IngresarFacturaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoDeCompra_IngresarFacturaCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoDeCompra_IngresarFacturaCompraKeyTyped(evt);
            }
        });
        panel_IngreosFacturaCompra.add(txtMontoDeCompra_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 170, -1));

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel62.setText("Tipo de compra");
        panel_IngreosFacturaCompra.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, 35));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setText("Fecha de compra");
        panel_IngreosFacturaCompra.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 113, -1));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel69.setText("Tipo de pago");
        panel_IngreosFacturaCompra.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, 35));

        cbxTipoCompra_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoCompra_IngresarFacturaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Contado", "Credito" }));
        cbxTipoCompra_IngresarFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoCompra_IngresarFacturaCompraActionPerformed(evt);
            }
        });
        panel_IngreosFacturaCompra.add(cbxTipoCompra_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 156, -1));
        panel_IngreosFacturaCompra.add(jDCFecha_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 156, -1));

        btAceptar_IngresarDetalleFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarDetalleFacturaCompra.setToolTipText("Oprima para cancelar");
        btAceptar_IngresarDetalleFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarDetalleFacturaCompraActionPerformed(evt);
            }
        });
        panel_IngreosFacturaCompra.add(btAceptar_IngresarDetalleFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1270, -1, -1));

        btLimpiar_IngresarFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarFacturaCompra.setToolTipText("Oprima para cancelar");
        btLimpiar_IngresarFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarFacturaCompraActionPerformed(evt);
            }
        });
        panel_IngreosFacturaCompra.add(btLimpiar_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("N° de pedido");
        panel_IngreosFacturaCompra.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("N° de referencia");
        panel_IngreosFacturaCompra.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        txtN_Pedido.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtN_Pedido.setForeground(new java.awt.Color(0, 102, 102));
        txtN_Pedido.setText("0");
        panel_IngreosFacturaCompra.add(txtN_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 160, -1));

        txtN_Entrega.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtN_Entrega.setForeground(new java.awt.Color(0, 102, 102));
        txtN_Entrega.setText("0");
        panel_IngreosFacturaCompra.add(txtN_Entrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 170, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("N° de entrega");
        panel_IngreosFacturaCompra.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, -1, -1));

        txtN_Referencia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtN_Referencia.setForeground(new java.awt.Color(0, 102, 102));
        txtN_Referencia.setText("0");
        panel_IngreosFacturaCompra.add(txtN_Referencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 160, -1));

        jLabel4.setText("*");
        panel_IngreosFacturaCompra.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        jLabel5.setText("* Pagos realizados a travez de cheques, transferencias o tarjeta de credito.");
        panel_IngreosFacturaCompra.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 600, -1, -1));

        cbxTipoPago_FacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxTipoPago_FacturaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTipoPago_FacturaCompraMouseClicked(evt);
            }
        });
        panel_IngreosFacturaCompra.add(cbxTipoPago_FacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 160, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Monto Cancelado");
        panel_IngreosFacturaCompra.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Plazo de dias para pagar");
        panel_IngreosFacturaCompra.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, -1, -1));

        txtMontoCancelado_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoCancelado_IngresarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        panel_IngreosFacturaCompra.add(txtMontoCancelado_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 160, -1));

        txtPlazoDias_IngresarFacturaCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPlazoDias_IngresarFacturaCompra.setForeground(new java.awt.Color(0, 102, 102));
        panel_IngreosFacturaCompra.add(txtPlazoDias_IngresarFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 170, 30));

        JTIngresoDetalleFacturaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre del producto", "UME", "Precio de compra", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTIngresoDetalleFacturaCompra);
        if (JTIngresoDetalleFacturaCompra.getColumnModel().getColumnCount() > 0) {
            JTIngresoDetalleFacturaCompra.getColumnModel().getColumn(0).setResizable(false);
            JTIngresoDetalleFacturaCompra.getColumnModel().getColumn(1).setResizable(false);
            JTIngresoDetalleFacturaCompra.getColumnModel().getColumn(2).setResizable(false);
            JTIngresoDetalleFacturaCompra.getColumnModel().getColumn(3).setResizable(false);
            JTIngresoDetalleFacturaCompra.getColumnModel().getColumn(4).setResizable(false);
        }

        panel_IngreosFacturaCompra.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1030, 960, 210));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Ingreso de los detalles de la factura  de compra");
        panel_IngreosFacturaCompra.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 890, 510, -1));

        boton_ListoDatosFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        boton_ListoDatosFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ListoDatosFacturaCompraActionPerformed(evt);
            }
        });
        panel_IngreosFacturaCompra.add(boton_ListoDatosFacturaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, -1, -1));

        txtCodigoDetalleFactura.setPreferredSize(new java.awt.Dimension(6, 23));
        panel_IngreosFacturaCompra.add(txtCodigoDetalleFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 960, 160, -1));

        JBBuscarParaAgregarDetalle.setText("Agregar detalle");
        JBBuscarParaAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarParaAgregarDetalleActionPerformed(evt);
            }
        });
        panel_IngreosFacturaCompra.add(JBBuscarParaAgregarDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 960, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Código:");
        panel_IngreosFacturaCompra.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 960, -1, -1));
        panel_IngreosFacturaCompra.add(txtCantidadDetalleFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 960, 140, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Precio de compra:");
        panel_IngreosFacturaCompra.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 1000, 140, -1));
        panel_IngreosFacturaCompra.add(txtPrecioDeCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1000, 140, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Cantidad:");
        panel_IngreosFacturaCompra.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 960, -1, -1));

        scroll_IngresoFacturaCompra.setViewportView(panel_IngreosFacturaCompra);

        add(scroll_IngresoFacturaCompra);
        scroll_IngresoFacturaCompra.setBounds(0, 0, 1360, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptar_IngresarDetalleFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarDetalleFacturaCompraActionPerformed
        IngresarDetalles();
    }//GEN-LAST:event_btAceptar_IngresarDetalleFacturaCompraActionPerformed

    private void cbxProveedor_IngresarFacturaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProveedor_IngresarFacturaCompraMouseClicked
        ListarProveedores();
    }//GEN-LAST:event_cbxProveedor_IngresarFacturaCompraMouseClicked

    private void btLimpiar_IngresarFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarFacturaCompraActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btLimpiar_IngresarFacturaCompraActionPerformed

    private void cbxTipoCompra_IngresarFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoCompra_IngresarFacturaCompraActionPerformed
        EstablecerTipoCompra();
    }//GEN-LAST:event_cbxTipoCompra_IngresarFacturaCompraActionPerformed

    private void cbxTipoPago_FacturaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoPago_FacturaCompraMouseClicked
        ListarTiposDePago();
    }//GEN-LAST:event_cbxTipoPago_FacturaCompraMouseClicked

    private void txtMontoDeCompra_IngresarFacturaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoDeCompra_IngresarFacturaCompraKeyPressed
        ValidacionSoloNumeros(evt);
    }//GEN-LAST:event_txtMontoDeCompra_IngresarFacturaCompraKeyPressed

    private void txtMontoDeCompra_IngresarFacturaCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoDeCompra_IngresarFacturaCompraKeyTyped

        ValidacionSoloNumeros(evt);
    }//GEN-LAST:event_txtMontoDeCompra_IngresarFacturaCompraKeyTyped

    private void boton_ListoDatosFacturaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ListoDatosFacturaCompraActionPerformed
        IngresarFacturaCompra();
    }//GEN-LAST:event_boton_ListoDatosFacturaCompraActionPerformed

    private void JBBuscarParaAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarParaAgregarDetalleActionPerformed
        AgregarProductoComoDetalle();
    }//GEN-LAST:event_JBBuscarParaAgregarDetalleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscarParaAgregarDetalle;
    private javax.swing.JTable JTIngresoDetalleFacturaCompra;
    private javax.swing.JButton boton_ListoDatosFacturaCompra;
    public static javax.swing.JButton btAceptar_IngresarDetalleFacturaCompra;
    public static javax.swing.JButton btLimpiar_IngresarFacturaCompra;
    public static javax.swing.JComboBox cbxProveedor_IngresarFacturaCompra;
    private javax.swing.JComboBox cbxTipoCompra_IngresarFacturaCompra;
    public static javax.swing.JComboBox cbxTipoPago_FacturaCompra;
    private com.toedter.calendar.JDateChooser jDCFecha_Compra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_IngreosFacturaCompra;
    public static javax.swing.JScrollPane scroll_IngresoFacturaCompra;
    private javax.swing.JTextField txtCantidadDetalleFactura;
    private javax.swing.JTextField txtCodigoDetalleFactura;
    private javax.swing.JTextField txtMontoCancelado_IngresarFacturaCompra;
    public javax.swing.JTextField txtMontoDeCompra_IngresarFacturaCompra;
    private javax.swing.JTextField txtN_Entrega;
    private javax.swing.JTextField txtN_Pedido;
    private javax.swing.JTextField txtN_Referencia;
    public static javax.swing.JTextField txtNumeroDeFactura_IngresarFacturaCompra;
    private javax.swing.JTextField txtPlazoDias_IngresarFacturaCompra;
    private javax.swing.JTextField txtPrecioDeCompra;
    // End of variables declaration//GEN-END:variables
}
