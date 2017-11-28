package UI;

import LogicaDeNegocios.CoordinadorDeAbonos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class DetallesAbonos extends javax.swing.JDialog {

    static DefaultTableModel modelo;
    Object[] filas;
    int fila;
    static boolean tipoDeFactura;
    String factura;
    static ResultSet listaDeAbonos = null;

    public DetallesAbonos(java.awt.Frame parent, boolean modal, String nFactura, boolean tipofactura) throws SQLException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.factura = nFactura;
        this.tipoDeFactura = tipofactura;
        EstablecerTituloAbonos();

    }

    public void EstablecerTituloAbonos() {
        if (LlenarListaDetalles()) {
            jlTituloDetalles.setText("Abonos asociados a la factura  N° " + factura);
        } else {
            jlTituloDetalles.setText("NO EXISTEN abonos asociados a la factura N° " + factura);
        }
    }

    public static void EstablecerModelo() {
        modelo = new DefaultTableModel();

        modelo.addColumn("Fecha de abono");
        modelo.addColumn("Monto de abono");
        modelo.addColumn("Tipo de pago");

    }

    public boolean LlenarListaDetalles() {
        EstablecerModelo();
        filas = new Object[modelo.getColumnCount()];
        CoordinadorDeAbonos elcoordinador = new CoordinadorDeAbonos();
        try {
            listaDeAbonos = elcoordinador.ListarAbonos(factura, tipoDeFactura);
            if (listaDeAbonos.next()) {
                listaDeAbonos.beforeFirst();
                while (listaDeAbonos.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {
                        filas[i] = listaDeAbonos.getObject(i + 1);
                    }
                    modelo.addRow(filas);
                }
                tablaAbonos.setModel(modelo);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarFacturas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "¡Esta cuenta no tiene abonos!", "¡Escoja otro registro!",
                    JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetallesAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTituloDetalles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAbonos = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jlTituloDetalles.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        tablaAbonos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAbonos);
        if (tablaAbonos.getColumnModel().getColumnCount() > 0) {
            tablaAbonos.getColumnModel().getColumn(0).setResizable(false);
            tablaAbonos.getColumnModel().getColumn(1).setResizable(false);
            tablaAbonos.getColumnModel().getColumn(2).setResizable(false);
            tablaAbonos.getColumnModel().getColumn(3).setResizable(false);
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
    private javax.swing.JTable tablaAbonos;
    // End of variables declaration//GEN-END:variables
}
