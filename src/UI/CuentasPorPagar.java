/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCuentasPorCobrar;
import LogicaDeNegocios.CoordinadorDeCuentasPorPagar;
import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import static UI.PuntoDeVenta.listaParaMostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class CuentasPorPagar extends javax.swing.JPanel {

    public static boolean panelHabilitado = false;
    static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
   static boolean  abono=false;

    public CuentasPorPagar() {
        initComponents();
    }

    public static void VisualizarCuentasPorCobrar(JTable Listar) throws ClassNotFoundException {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeCuentasPorCobrar elCoordinador = new CoordinadorDeCuentasPorCobrar();
            ResultSet resultadoConsulta = elCoordinador.ListarCuentasPorCobrar();

            modelo.addColumn("Factura");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha de venta");
            modelo.addColumn("N° Monto pendiente");
            modelo.addColumn("Cliente");

            modelo.addColumn("Monto total");

            modelo.addColumn("N° Monto cancelado");

            modelo.addColumn("Fecha limite de pago");
            Listar.setModel(modelo);
            filas = new Object[modelo.getColumnCount()];
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
        } catch (SQLException ex) {

        }

    }

    public static void VisualizarCuentasPorPagar(JTable Listar) throws ClassNotFoundException {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeCuentasPorPagar elCoordinador = new CoordinadorDeCuentasPorPagar();
            ResultSet resultadoConsulta = elCoordinador.ListarCuentasPorPagar();

            modelo.addColumn("Factura");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha de compra");
            modelo.addColumn("N° Monto pendiente");
            modelo.addColumn("Fecha de ingreso");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Monto total");

            modelo.addColumn("N° Pedido");
            modelo.addColumn("N° Entrega");
            modelo.addColumn("N° Monto cancelado");

            modelo.addColumn("Fecha limite de pago");
            Listar.setModel(modelo);
            filas = new Object[modelo.getColumnCount()];
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
        } catch (SQLException ex) {

        }

    }

    public void MostrarFacturas() throws ClassNotFoundException {
        if (cbxMostar_Cuentas.getSelectedItem().equals("Cuentas por pagar a proveedores.")) {
            VisualizarCuentasPorPagar(tbCuentasPorPagar);
            Tutulo_Cuentas.setText("Mostrando cuentas por pagar a los proveedores");
            abono=false;
        } else if (cbxMostar_Cuentas.getSelectedItem().equals("Cuentas por cobrar a clientes.")) {
            VisualizarCuentasPorCobrar(tbCuentasPorPagar);
            Tutulo_Cuentas.setText("Mostrando cuentas por cobrar a los clientes.");
            abono=true;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        AgregarAbonos = new javax.swing.JMenuItem();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCuentasPorPagar = new javax.swing.JTable();
        Tutulo_Cuentas = new javax.swing.JLabel();
        cbxMostar_Cuentas = new javax.swing.JComboBox();

        AgregarAbonos.setBackground(new java.awt.Color(255, 255, 255));
        AgregarAbonos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AgregarAbonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abono.png"))); // NOI18N
        AgregarAbonos.setText("Agregar abonos");
        AgregarAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAbonosActionPerformed(evt);
            }
        });
        menu.add(AgregarAbonos);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Mostar");

        tbCuentasPorPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCuentasPorPagar.setComponentPopupMenu(menu);
        tbCuentasPorPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCuentasPorPagarMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCuentasPorPagar);

        Tutulo_Cuentas.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        Tutulo_Cuentas.setForeground(new java.awt.Color(0, 102, 112));
        Tutulo_Cuentas.setText("Mostrando cuentas por pagar a los proveedores");

        cbxMostar_Cuentas.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        cbxMostar_Cuentas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cuentas por pagar a proveedores.", "Cuentas por cobrar a clientes." }));
        cbxMostar_Cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMostar_CuentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMostar_Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Tutulo_Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(cbxMostar_Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(Tutulo_Cuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAbonosActionPerformed
        int IdCuenta = Integer.parseInt(tbCuentasPorPagar.getValueAt(FilaSeleccionadaParaEliminar, 0).toString());
        float monto = Float.parseFloat(tbCuentasPorPagar.getValueAt(FilaSeleccionadaParaEliminar, 3).toString());
        IngresarAbono elAbono = new IngresarAbono(null, true, IdCuenta, monto,abono);
        elAbono.setVisible(true);
    }//GEN-LAST:event_AgregarAbonosActionPerformed

    private void tbCuentasPorPagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCuentasPorPagarMousePressed
        FilaSeleccionadaParaEliminar = tbCuentasPorPagar.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_tbCuentasPorPagarMousePressed

    private void cbxMostar_CuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMostar_CuentasActionPerformed
        try {
            MostrarFacturas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CuentasPorPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxMostar_CuentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgregarAbonos;
    public static javax.swing.JLabel Tutulo_Cuentas;
    public static javax.swing.JComboBox cbxMostar_Cuentas;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menu;
    public static javax.swing.JTable tbCuentasPorPagar;
    // End of variables declaration//GEN-END:variables

}
