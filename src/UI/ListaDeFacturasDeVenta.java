
package UI;

import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaDeFacturasDeVenta extends javax.swing.JPanel {
     static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
   static boolean panelHabilitado=false;
    public ListaDeFacturasDeVenta() {
        initComponents();
    }

    public static void VisualizarFacturasDeVenta(JTable Listar) throws ClassNotFoundException{
    try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeFacturaVenta elCoordinador = new CoordinadorDeFacturaVenta();
            ResultSet resultadoConsulta = elCoordinador.ListarFacturasDeVenta();

            modelo.addColumn("N° Factura");
            modelo.addColumn("Fecha de venta");
            modelo.addColumn("Monto total");
            modelo.addColumn("Usuario");
            modelo.addColumn("Nombre del cliente");
            modelo.addColumn("Nombre del local");
            modelo.addColumn("Tipo de venta");
         
            filas = new Object[modelo.getColumnCount()];
            Listar.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    
                        
                        filas[i] = resultadoConsulta.getObject(i + 1);
                    
                }
                modelo.addRow(filas);
                Listar.setModel(modelo);
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }

    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Detalles = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_ListarFacturasDeVenta = new javax.swing.JTable();
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

        Detalles.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Detalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DetalleFactura.png"))); // NOI18N
        Detalles.setText("Ver detalles de factura");
        Menu.add(Detalles);

        jPanel1.setPreferredSize(new java.awt.Dimension(990, 631));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt_ListarFacturasDeVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Factura", "Fecha de venta", "Monto total", "Usuario encargado", "Nombre del cliente", "Nombre del local", "Tipo de venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_ListarFacturasDeVenta.setComponentPopupMenu(Menu);
        jScrollPane1.setViewportView(jt_ListarFacturasDeVenta);
        if (jt_ListarFacturasDeVenta.getColumnModel().getColumnCount() > 0) {
            jt_ListarFacturasDeVenta.getColumnModel().getColumn(1).setResizable(false);
            jt_ListarFacturasDeVenta.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 1010, 400));

        jLTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLTitulo.setText("Lista de facturas de venta");
        jPanel1.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/invoice_22150 (1).png"))); // NOI18N
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        txt_IngresoFormaBusqueda.setEnabled(false);
        jPanel1.add(txt_IngresoFormaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 30));

        jb_Buscar.setText("Buscar");
        jb_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, 50));

        cbx_SeleccionBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Nombre de proveedor", "Codigo de usuario", "Fecha de compra", "N° de factura" }));
        cbx_SeleccionBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_SeleccionBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_SeleccionBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 150, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, 20));

        jdc_FechaDesde.setEnabled(false);
        jPanel1.add(jdc_FechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 150, -1));

        jdc_FechaHasta.setEnabled(false);
        jPanel1.add(jdc_FechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 150, -1));

        jl_Desde.setText("Desde:");
        jl_Desde.setEnabled(false);
        jPanel1.add(jl_Desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jl_Hasta.setText("Hasta:");
        jl_Hasta.setEnabled(false);
        jPanel1.add(jl_Hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jbListarFacturas.setText("Listar");
        jbListarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarFacturasActionPerformed(evt);
            }
        });
        jPanel1.add(jbListarFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1229, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_BuscarActionPerformed
   
    }//GEN-LAST:event_jb_BuscarActionPerformed

    private void cbx_SeleccionBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_SeleccionBusquedaActionPerformed
       
    }//GEN-LAST:event_cbx_SeleccionBusquedaActionPerformed

    private void jbListarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarFacturasActionPerformed
   
    }//GEN-LAST:event_jbListarFacturasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Detalles;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JComboBox cbx_SeleccionBusqueda;
    public static javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jbListarFacturas;
    private javax.swing.JButton jb_Buscar;
    private com.toedter.calendar.JDateChooser jdc_FechaDesde;
    private com.toedter.calendar.JDateChooser jdc_FechaHasta;
    private javax.swing.JLabel jl_Desde;
    private javax.swing.JLabel jl_Hasta;
    public static javax.swing.JTable jt_ListarFacturasDeVenta;
    private javax.swing.JTextField txt_IngresoFormaBusqueda;
    // End of variables declaration//GEN-END:variables
}
