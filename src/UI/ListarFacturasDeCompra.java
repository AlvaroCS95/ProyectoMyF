package UI;

import LogicaDeNegocios.CoordinadorDeFacturaCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFacturasDeCompra extends javax.swing.JPanel {

    ArrayList<Object> listaParaMostrar = new ArrayList<>();
    Object[] filas;
    DefaultTableModel modelo;
    ResultSet resultadoConsulta;
    int tipoBusqueda;
    boolean sentinela;

    public ListarFacturasDeCompra() {

        initComponents();
        ListarFacturasDelUltimoMes();

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

    public void EstablecerModelo(ResultSet lista) {

        modelo = new DefaultTableModel();
        modelo.addColumn("N° Factura");
        modelo.addColumn("Usuario encargado");
        modelo.addColumn("Fecha de compra");
        modelo.addColumn("Tipo de compra");
        modelo.addColumn("Nombre del proveedor");
        modelo.addColumn("Monto total");
        modelo.addColumn("N° pedido");
        modelo.addColumn("N° entrega");
        modelo.addColumn("Tipo de pago");
        modelo.addColumn("N° de referencia");
        filas = new Object[modelo.getColumnCount()];

        try {
            while (lista.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    if (i == 3) {
                        if (lista.getBoolean(i + 1) == true) {
                            filas[i] = "Contado";
                        } else {
                            filas[i] = "Credito";
                        }
                    } else {
                        filas[i] = lista.getObject(i + 1);
                    }
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarFacturasDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        jt_ListarFacturasDeCompra.setModel(modelo);

    }

    public void ListarFacturas() {
        jLTitulo.setText("Se está mostrando todas las facturas de compra.");
        jbListarFacturas.setText("Listar facturas ultimo mes");

        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        EstablecerModelo(coordinador.ListarFacturasCompra());

    }

    public void ListarFacturasDelUltimoMes() {
        jLTitulo.setText("Se está mostrando las facturas de compra del ultimo mes.");
        jbListarFacturas.setText("Listar todas las facturas");

        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();
        EstablecerModelo(coordinador.ListarFacturasCompraDelUltimoMes());

    }

    public void SeleccionFormaDeBusqueda() {
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
            case "Codigo de usuario":
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

    public ResultSet ValidarBusquedas() {
        CoordinadorDeFacturaCompra coordinador = new CoordinadorDeFacturaCompra();

        switch (tipoBusqueda) {
            case 1:
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el codigo de usuario para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 2:
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el N° factura de compra para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 3:
                if (!txt_IngresoFormaBusqueda.getText().isEmpty()) {
                    resultadoConsulta = coordinador.Buscar(tipoBusqueda, txt_IngresoFormaBusqueda.getText(), null);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Debe ingresar el nombre del proveedor para poder"
                            + "realizar la busqueda!", "¡Error, faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case 4:
                if ((jdc_FechaDesde.getDate() != null) && (jdc_FechaHasta.getDate() != null)) {
                    resultadoConsulta = coordinador.Buscar(tipoBusqueda, ObtenerFechaDesde(), ObtenerFechaHasta());
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

            EstablecerModelo(ValidarBusquedas());
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
        
        if (sentinela) {
            ListarFacturasDelUltimoMes();
            sentinela = false;
        } else {
            ListarFacturas();
            sentinela = true;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppEditarFactura = new javax.swing.JPopupMenu();
        jmIEditar = new javax.swing.JMenuItem();
        jmIEliminar = new javax.swing.JMenuItem();
        jmIAgregarAbono = new javax.swing.JMenuItem();
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

        jmIEditar.setText("Editar");
        jmIEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIEditarActionPerformed(evt);
            }
        });
        jppEditarFactura.add(jmIEditar);

        jmIEliminar.setText("Eliminar");
        jmIEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIEliminarActionPerformed(evt);
            }
        });
        jppEditarFactura.add(jmIEliminar);

        jmIAgregarAbono.setText("jMenuItem2");
        jppEditarFactura.add(jmIAgregarAbono);

        setPreferredSize(new java.awt.Dimension(990, 631));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt_ListarFacturasDeCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Factura", "Usuario encargado", "Fecha de compra", "Tipo de compra", "Nombre del proveedor", "Monto total", "N° pedido", "N° entrega", "Tipo de pago", "N° de referencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_ListarFacturasDeCompra.setComponentPopupMenu(jppEditarFactura);
        jScrollPane1.setViewportView(jt_ListarFacturasDeCompra);
        if (jt_ListarFacturasDeCompra.getColumnModel().getColumnCount() > 0) {
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(0).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(1).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(2).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(3).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(4).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(5).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(6).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(7).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(8).setResizable(false);
            jt_ListarFacturasDeCompra.getColumnModel().getColumn(9).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 1010, 400));

        jLTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLTitulo.setText("Lista de facturas de compra");
        add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/invoice_22150 (1).png"))); // NOI18N
        add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        txt_IngresoFormaBusqueda.setEnabled(false);
        add(txt_IngresoFormaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 20));

        jb_Buscar.setText("Buscar");
        jb_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_BuscarActionPerformed(evt);
            }
        });
        add(jb_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, 50));

        cbx_SeleccionBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Nombre de proveedor", "Codigo de usuario", "Fecha de compra", "N° de factura" }));
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

    private void jmIEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIEliminarActionPerformed

    }//GEN-LAST:event_jmIEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_SeleccionBusqueda;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbListarFacturas;
    private javax.swing.JButton jb_Buscar;
    private com.toedter.calendar.JDateChooser jdc_FechaDesde;
    private com.toedter.calendar.JDateChooser jdc_FechaHasta;
    private javax.swing.JLabel jl_Desde;
    private javax.swing.JLabel jl_Hasta;
    private javax.swing.JMenuItem jmIAgregarAbono;
    private javax.swing.JMenuItem jmIEditar;
    private javax.swing.JMenuItem jmIEliminar;
    private javax.swing.JPopupMenu jppEditarFactura;
    private javax.swing.JTable jt_ListarFacturasDeCompra;
    private javax.swing.JTextField txt_IngresoFormaBusqueda;
    // End of variables declaration//GEN-END:variables
}
