package UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetallesFacturaCompraVenta extends javax.swing.JDialog {

    static DefaultTableModel modelo;
    Object[] filas;
    int fila;
    static boolean tipoDeFactura; // (true -> Compra) -- (false -> Venta)

    public DetallesFacturaCompraVenta(java.awt.Frame parent, boolean modal, String nFactura, boolean tipoFactura) {
        super(parent, modal);
        initComponents();
        jlTituloDetalles.setText("Detalles de factura de compra # " + nFactura);
        setLocationRelativeTo(null);
        this.tipoDeFactura = tipoFactura;
    }

    public static void EstablecerModelo() {
        modelo = new DefaultTableModel();
        if (tipoDeFactura) {
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");
        } else {
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Monto de descuento");
            modelo.addColumn("Precio de venta");
        }

    }

   public void LlenarListaDetalles(ResultSet listaDetalles) {
        EstablecerModelo();
        filas = new Object[modelo.getColumnCount()];
        try {
            while (listaDetalles.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    filas[i] = listaDetalles.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtDetallesFacturaCompra.setModel(modelo);
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTituloDetalles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetallesFacturaCompra = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jlTituloDetalles.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jtDetallesFacturaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtDetallesFacturaCompra);
        if (jtDetallesFacturaCompra.getColumnModel().getColumnCount() > 0) {
            jtDetallesFacturaCompra.getColumnModel().getColumn(0).setResizable(false);
            jtDetallesFacturaCompra.getColumnModel().getColumn(1).setResizable(false);
            jtDetallesFacturaCompra.getColumnModel().getColumn(2).setResizable(false);
            jtDetallesFacturaCompra.getColumnModel().getColumn(3).setResizable(false);
        }

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTituloDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbCerrar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCerrar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JLabel jlTituloDetalles;
    private javax.swing.JTable jtDetallesFacturaCompra;
    // End of variables declaration//GEN-END:variables
}
