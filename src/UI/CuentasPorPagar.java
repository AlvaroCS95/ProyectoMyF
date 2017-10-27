/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCuentasPorPagar;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public CuentasPorPagar() {
        initComponents();
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
            modelo.addColumn("Fecha de ingreso");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Monto total");

            modelo.addColumn("N° Pedido");
            modelo.addColumn("N° Entrega");
            modelo.addColumn("N° Monto cancelado");
            modelo.addColumn("N° Monto pendiente");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        AgregarAbonos = new javax.swing.JMenuItem();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCuentasPorPagar = new javax.swing.JTable();

        AgregarAbonos.setBackground(new java.awt.Color(255, 255, 255));
        AgregarAbonos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AgregarAbonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abono.png"))); // NOI18N
        AgregarAbonos.setText("Agregar abonos");
        menu.add(AgregarAbonos);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Cuentas por pagar");

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
        jScrollPane1.setViewportView(tbCuentasPorPagar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel52)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgregarAbonos;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menu;
    public static javax.swing.JTable tbCuentasPorPagar;
    // End of variables declaration//GEN-END:variables
}
