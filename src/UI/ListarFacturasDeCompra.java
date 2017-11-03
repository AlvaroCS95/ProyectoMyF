package UI;

import LogicaDeNegocios.CoordinadorDeFacturaCompra;
import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFacturasDeCompra extends javax.swing.JPanel {

    static ArrayList<Object> listaParaMostrar = new ArrayList<>();
    static Object[] filas;
    static DefaultTableModel modelo;
    static ComboBoxModel modeloComboBox;
    ResultSet resultadoConsulta;
    int tipoBusqueda, fila;
    boolean sentinela;

    public ListarFacturasDeCompra() {

        initComponents();

    }

    public boolean CamposVacios() {
        if ((!cbx_SeleccionBusqueda.getSelectedItem().toString().equals("Seleccione..."))
                && (!txt_IngresoFormaBusqueda.getText().isEmpty()
                || jdc_FechaDesde.getDate() != null
                || jdc_FechaHasta.getDate() != null)) {
            return true;

        }
        return false;
    }

    public static void EstablecerModelo() {
        modelo = new DefaultTableModel();
        switch (cbxMostrar_Facturas.getSelectedItem().toString()) {

            case "Compra":

                modelo.addColumn("N° Factura");
                modelo.addColumn("Usuario encargado");
                modelo.addColumn("Fecha de compra");
                modelo.addColumn("Tipo de compra");
                modelo.addColumn("Nombre del proveedor");
                modelo.addColumn("Monto comprado");
                modelo.addColumn("N° pedido");
                modelo.addColumn("N° entrega");
                modelo.addColumn("Tipo de pago");
                modelo.addColumn("N° de referencia");
                break;

            case "Venta":
                modelo.addColumn("N° Factura");
                modelo.addColumn("Usuario encargado");
                modelo.addColumn("Local del cliente");
                modelo.addColumn("Fecha de venta");
                modelo.addColumn("Monto de venta");
                modelo.addColumn("Tipo de pago");
                modelo.addColumn("Tipo de venta");
                break;
        }

    }

    public static void LlenarDatosTabla(ResultSet listaDeFacturas) {
        switch (cbxMostrar_Facturas.getSelectedItem().toString()) {

            case "Venta":
                EstablecerModelo();

                filas = new Object[modelo.getColumnCount()];
                try {
                    while (listaDeFacturas.next()) {
                        for (int i = 0; i < modelo.getColumnCount(); i++) {
                            if (i == 6) {
                                if (listaDeFacturas.getBoolean(i + 1) == true) {
                                    filas[i] = "Contado";
                                } else {
                                    filas[i] = "Crédito";
                                }
                            } else {
                                filas[i] = listaDeFacturas.getObject(i + 1);
                            }
                        }
                        modelo.addRow(filas);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ListarFacturasDeCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                jt_ListarFacturasDeCompra.setModel(modelo);
                break;

            case "Compra":
                EstablecerModelo();

                filas = new Object[modelo.getColumnCount()];
                try {
                    while (listaDeFacturas.next()) {
                        for (int i = 0; i < modelo.getColumnCount(); i++) {
                            if (i == 3) {
                                if (listaDeFacturas.getBoolean(i + 1) == true) {
                                    filas[i] = "Contado";
                                } else {
                                    filas[i] = "Crédito";
                                }
                            } else {
                                filas[i] = listaDeFacturas.getObject(i + 1);
                            }
                        }
                        modelo.addRow(filas);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ListarFacturasDeCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                jt_ListarFacturasDeCompra.setModel(modelo);
                break;
        }
    }

    public void ListarFacturas() {
        jLTitulo.setText("Se muestran todas las facturas de ");
        jlTitulo2.setText(".");
        jbListarFacturas.setText("Listar facturas último mes");
        if (cbxMostrar_Facturas.getSelectedIndex() == 0) {
            CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
            LlenarDatosTabla(coordinador.ListarFacturasCompra());
        } else {
            CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
            LlenarDatosTabla(coordinador.ListarFacturasDeVenta());
        }

    }

    public static void ListarFacturasDelUltimoMes() {
        jLTitulo.setText("Se están mostrando las facturas de ");
        jlTitulo2.setText(" del último mes.");
        jbListarFacturas.setText("Listar todas las facturas");

        if (cbxMostrar_Facturas.getSelectedIndex() == 0) {
            CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
            LlenarDatosTabla(coordinador.ListarFacturasCompraDelUltimoMes());
        } else {
            CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
            LlenarDatosTabla(coordinador.ListarFacturasVentaDelUltimoMes());
        }

    }

    public void SeleccionFormaDeBusqueda() {

        if (cbx_SeleccionBusqueda.isVisible()) {
            switch (cbx_SeleccionBusqueda.getSelectedItem().toString()) {
                case "Nombre de proveedor":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 3;
                    break;
                case "N° de factura":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 2;
                    break;
                case "Fecha de compra":
                    txt_IngresoFormaBusqueda.setText("");
                    txt_IngresoFormaBusqueda.setEnabled(false);
                    jl_Desde.setEnabled(true);
                    jl_Hasta.setEnabled(true);
                    jdc_FechaDesde.setEnabled(true);
                    jdc_FechaHasta.setEnabled(true);
                    tipoBusqueda = 4;
                    break;
                case "Código de usuario":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 1;
                    break;
                case "Seleccione...":
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(false);
                    txt_IngresoFormaBusqueda.setText("");
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    break;
            }
        } else if (jComboBox1.isVisible()) {
            switch (jComboBox1.getSelectedItem().toString()) {
                case "Nombre de local":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 3;
                    break;
                case "N° de factura":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 2;
                    break;
                case "Fecha de venta":
                    txt_IngresoFormaBusqueda.setText("");
                    txt_IngresoFormaBusqueda.setEnabled(false);
                    jl_Desde.setEnabled(true);
                    jl_Hasta.setEnabled(true);
                    jdc_FechaDesde.setEnabled(true);
                    jdc_FechaHasta.setEnabled(true);
                    tipoBusqueda = 4;
                    break;
                case "Código de usuario":
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    txt_IngresoFormaBusqueda.setText("");
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(true);
                    tipoBusqueda = 1;
                    break;
                case "Seleccione...":
                    jl_Desde.setEnabled(false);
                    jl_Hasta.setEnabled(false);
                    jdc_FechaDesde.setEnabled(false);
                    jdc_FechaHasta.setEnabled(false);
                    txt_IngresoFormaBusqueda.setEnabled(false);
                    txt_IngresoFormaBusqueda.setText("");
                    jdc_FechaDesde.setDate(null);
                    jdc_FechaHasta.setDate(null);
                    break;
            }
        }
    }

    public ResultSet ValidarBusquedas() {
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        CoordinadorDeFacturaVenta coordinadorVenta = new CoordinadorDeFacturaVenta();

        switch (tipoBusqueda) {
            case 1: // código de usuario
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    try {
                        int codigo = Integer.parseInt(txt_IngresoFormaBusqueda.getText());

                        if (cbxMostrar_Facturas.getSelectedItem().equals("Venta")) {
                            resultadoConsulta = coordinadorVenta.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                        } else {
                            resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El código de usuario a buscar debe ser numerico.",
                                "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el codigo de usuario para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 2:// numero de factura
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    if (cbxMostrar_Facturas.getSelectedItem().equals("Venta")) {
                        resultadoConsulta = coordinadorVenta.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                    } else {
                        resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el N° factura de compra para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 3:// nombre proveedor o Nombre de local
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    if (cbxMostrar_Facturas.getSelectedItem().equals("Venta")) {
                        resultadoConsulta = coordinadorVenta.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                    } else {
                        resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el nombre del proveedor para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 4:// fechas
                if ((jdc_FechaDesde.getDate() != null) && (jdc_FechaHasta.getDate() != null)) {
                    if (cbxMostrar_Facturas.getSelectedItem().equals("Venta")) {
                        resultadoConsulta = coordinadorVenta.Buscar(tipoBusqueda, ObtenerFechaDesde(), ObtenerFechaHasta());
                    } else {
                        resultadoConsulta = coordinador.Buscar(tipoBusqueda, ObtenerFechaDesde(), ObtenerFechaHasta());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar un rango de fechas valido para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        return resultadoConsulta;
    }

    public void Buscar() {
        if (CamposVacios()) {
            LlenarDatosTabla(ValidarBusquedas());

        } else {
            JOptionPane.showMessageDialog(null, "¡Debe seleccionar algún criterio de busqueda!",
                    "Error de selección", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String ObtenerFechaDesde() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(jdc_FechaDesde.getDate()));
    }

    public String ObtenerFechaHasta() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(jdc_FechaHasta.getDate()));
    }

    public int ObtenerFilaSeleccionada() {
        return jt_ListarFacturasDeCompra.getSelectedRow();
    }

    public int ObtenerColumnaSeleccionada() {
        return jt_ListarFacturasDeCompra.getSelectedColumn();
    }

    public void BuscarParaEditar() {
        String idFactura = jt_ListarFacturasDeCompra.getValueAt(jt_ListarFacturasDeCompra.getSelectedRow(), 0).toString();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        coordinador.BuscarParaEditar(idFactura);

    }

    public void TiposDeLista() {
        cbx_SeleccionBusqueda.setSelectedIndex(0);
        txt_IngresoFormaBusqueda.setText("");

        if (sentinela) {
            ListarFacturasDelUltimoMes();
            sentinela = false;
        } else {
            ListarFacturas();
            sentinela = true;
        }
    }

    public void VisualizarDetallesDeFactura() {
        String nFactura = jt_ListarFacturasDeCompra.getValueAt(fila, 0).toString();
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        coordinador.ObtenerDetallesDeFactura(nFactura);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppEditarFactura = new javax.swing.JPopupMenu();
        jmIEditar = new javax.swing.JMenuItem();
        jmIVerDetalles = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_ListarFacturasDeCompra = new javax.swing.JTable();
        jLTitulo = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txt_IngresoFormaBusqueda = new javax.swing.JTextField();
        jb_Buscar = new javax.swing.JButton();
        cbx_SeleccionBusqueda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jdc_FechaDesde = new com.toedter.calendar.JDateChooser();
        jdc_FechaHasta = new com.toedter.calendar.JDateChooser();
        jl_Desde = new javax.swing.JLabel();
        jl_Hasta = new javax.swing.JLabel();
        jbListarFacturas = new javax.swing.JButton();
        cbxMostrar_Facturas = new javax.swing.JComboBox();
        jlTitulo2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jmIEditar.setText("Editar");
        jmIEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIEditarActionPerformed(evt);
            }
        });
        jppEditarFactura.add(jmIEditar);

        jmIVerDetalles.setText("Ver detalles de compra");
        jmIVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIVerDetallesActionPerformed(evt);
            }
        });
        jppEditarFactura.add(jmIVerDetalles);

        setPreferredSize(new java.awt.Dimension(990, 631));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt_ListarFacturasDeCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_ListarFacturasDeCompra.setComponentPopupMenu(jppEditarFactura);
        jt_ListarFacturasDeCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_ListarFacturasDeCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_ListarFacturasDeCompra);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 1010, 400));

        jLTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLTitulo.setText("Se está mostrando las facturas de ");
        add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/invoice_22150 (1).png"))); // NOI18N
        add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        txt_IngresoFormaBusqueda.setEnabled(false);
        add(txt_IngresoFormaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 30));

        jb_Buscar.setText("Buscar");
        jb_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_BuscarActionPerformed(evt);
            }
        });
        add(jb_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, 50));

        cbx_SeleccionBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "N° de factura", "Nombre de proveedor", "Código de usuario", "Fecha de compra" }));
        cbx_SeleccionBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_SeleccionBusquedaActionPerformed(evt);
            }
        });
        add(cbx_SeleccionBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 150, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, 20));

        jdc_FechaDesde.setEnabled(false);
        add(jdc_FechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 150, -1));

        jdc_FechaHasta.setEnabled(false);
        add(jdc_FechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 150, -1));

        jl_Desde.setText("Desde:");
        jl_Desde.setEnabled(false);
        add(jl_Desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jl_Hasta.setText("Hasta:");
        jl_Hasta.setEnabled(false);
        add(jl_Hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jbListarFacturas.setText("Listar");
        jbListarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarFacturasActionPerformed(evt);
            }
        });
        add(jbListarFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, -1));

        cbxMostrar_Facturas.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        cbxMostrar_Facturas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compra", "Venta" }));
        cbxMostrar_Facturas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMostrar_FacturasItemStateChanged(evt);
            }
        });
        add(cbxMostrar_Facturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jlTitulo2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        add(jlTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 230, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "N° de factura", "Nombre de local", "Código de usuario", "Fecha de venta" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jb_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_BuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_jb_BuscarActionPerformed

    private void cbx_SeleccionBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_SeleccionBusquedaActionPerformed
        SeleccionFormaDeBusqueda();
    }//GEN-LAST:event_cbx_SeleccionBusquedaActionPerformed

    private void jbListarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarFacturasActionPerformed
        TiposDeLista();
    }//GEN-LAST:event_jbListarFacturasActionPerformed

    private void jmIEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIEditarActionPerformed
        BuscarParaEditar();
    }//GEN-LAST:event_jmIEditarActionPerformed

    private void jmIVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIVerDetallesActionPerformed
        VisualizarDetallesDeFactura();

    }//GEN-LAST:event_jmIVerDetallesActionPerformed

    private void jt_ListarFacturasDeCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_ListarFacturasDeCompraMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            fila = jt_ListarFacturasDeCompra.getSelectedRow();
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            fila = jt_ListarFacturasDeCompra.getSelectedRow();
        }
    }//GEN-LAST:event_jt_ListarFacturasDeCompraMouseClicked

    private void cbxMostrar_FacturasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMostrar_FacturasItemStateChanged
        if (cbxMostrar_Facturas.getSelectedIndex() == 0) {
            cbx_SeleccionBusqueda.setVisible(true);
            jComboBox1.setVisible(false);
            cbx_SeleccionBusqueda.setSelectedIndex(0);
        } else {
            cbx_SeleccionBusqueda.setVisible(false);
            jComboBox1.setVisible(true);
            jComboBox1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbxMostrar_FacturasItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        SeleccionFormaDeBusqueda();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cbxMostrar_Facturas;
    private javax.swing.JComboBox cbx_SeleccionBusqueda;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jbListarFacturas;
    private javax.swing.JButton jb_Buscar;
    private com.toedter.calendar.JDateChooser jdc_FechaDesde;
    private com.toedter.calendar.JDateChooser jdc_FechaHasta;
    public static javax.swing.JLabel jlTitulo2;
    private javax.swing.JLabel jl_Desde;
    private javax.swing.JLabel jl_Hasta;
    private javax.swing.JMenuItem jmIEditar;
    private javax.swing.JMenuItem jmIVerDetalles;
    private javax.swing.JPopupMenu jppEditarFactura;
    public static javax.swing.JTable jt_ListarFacturasDeCompra;
    private javax.swing.JTextField txt_IngresoFormaBusqueda;
    // End of variables declaration//GEN-END:variables
}
