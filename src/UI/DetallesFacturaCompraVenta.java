package UI;

import LogicaDeNegocios.IMPRIMIR;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetallesFacturaCompraVenta extends javax.swing.JDialog {

    static DefaultTableModel modelo;
    Object[] filas;
    int fila;
    static String numeroFac;
    static boolean tipoDeFactura; // (true -> Compra) -- (false -> Venta)
    static String txt="";

    public DetallesFacturaCompraVenta(java.awt.Frame parent, boolean modal, String nFactura,
            boolean tipoFactura, String Nombre, String tipo, String fecha, String total) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        factura.setText(nFactura);
        nombrecliente.setText(Nombre);
        TipoPago.setText(tipo);
        Fecha.setText(fecha);
        Total.setText(total);
        this.numeroFac = nFactura;
        this.tipoDeFactura = tipoFactura;
    }

    public void imprimir() {

    }

    public static int CantidadDeFilas(String txt) {
        Matcher m = Pattern.compile("\r\n|\r|\n").matcher(txt);
        int lines = 1;
        while (m.find()) {
            lines++;
        }
        return lines;
    }

    public static void EstablecerModelo() {
        modelo = new DefaultTableModel();
        if (tipoDeFactura) {
            jlTituloDetalles.setText("Detalles de factura de compra a proveedores");
            Nom.setText("Proveedor");
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");
        } else {
            jlTituloDetalles.setText("Detalles de factura de compra a clientes");
            Nom.setText("Cliente");
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

    public void Detalles() {
        txt="";
        String elCodigo = "";
        String cantidad = "";
        String precio = "";
        String descr = "";
        String descu = "";
        ;
        if (tipoDeFactura) {
               txt += "\n-------FACTURA DE COMPRA-------"
                    + "\n\nN.F:" + numeroFac
                    + "\nFecha:" + Fecha.getText()
                    + "\nN.Prove:" + nombrecliente.getText()
                    + "\nT.Pago:" + TipoPago.getText()
                    + "\n____________________________\n";
            txt += "\nCod   Precio   Cant   Descr";
            
            for (int i = 0; i < jtDetallesFacturaCompra.getRowCount(); i++) {
                elCodigo = jtDetallesFacturaCompra.getValueAt(i, 0).toString();
                descr = jtDetallesFacturaCompra.getValueAt(i, 1).toString();
                precio = jtDetallesFacturaCompra.getValueAt(i, 2).toString();
                cantidad = jtDetallesFacturaCompra.getValueAt(i, 3).toString();
                elCodigo = String.format("%1$-4s", elCodigo);
                
                if (descr.length() >= 10) {

                        descr = descr.replaceAll(" ", "");
                        descr = descr.substring(0, 10);
                    } else {

                        descr = String.format("%1$-9s", descr);

                    }
                txt += "\n" + elCodigo + "  " + precio + "    " + cantidad + "   " + descr;

            }
             txt += "\n______________________________\n"
                    + "\nTotal a pagar: "+ Total.getText();
        } else {
            txt += "\n-------FACTURA DE VENTA-------"
                    + "\n\nN.F:" + numeroFac
                    + "\nFecha:" + Fecha.getText()
                    + "\nN.Cli:" + nombrecliente.getText()
                    + "\nT.Pago:" + TipoPago.getText()
                    + "\n______________________________\n";
            txt += "\nCod  Precio  Descu  Cant  Descr";
            for (int i = 0; i < jtDetallesFacturaCompra.getRowCount(); i++) {
                elCodigo = jtDetallesFacturaCompra.getValueAt(i, 0).toString();
                descr = jtDetallesFacturaCompra.getValueAt(i, 1).toString();
                precio = jtDetallesFacturaCompra.getValueAt(i, 4).toString();
                cantidad = jtDetallesFacturaCompra.getValueAt(i, 2).toString();
                descu = jtDetallesFacturaCompra.getValueAt(i, 3).toString();
                elCodigo = String.format("%1$-4s", elCodigo);
                if (descr.length() >= 10) {

                        descr = descr.replaceAll(" ", "");
                        descr = descr.substring(0, 10);
                    } else {

                        descr = String.format("%1$-9s", descr);

                    }
                txt += "\n" + elCodigo + "  " + precio + "  " + descu + "    " + cantidad + "  " + descr;
            }

            txt += "\n______________________________\n"
                    + "\nTotal a pagar: " + Total.getText();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTituloDetalles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetallesFacturaCompra = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Nom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        factura = new javax.swing.JLabel();
        nombrecliente = new javax.swing.JLabel();
        TipoPago = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jlTituloDetalles.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlTituloDetalles.setText("Informacion factura");

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

        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printer_78349.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("N°Factura");

        Nom.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Nom.setText("Nombre cliente");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de pago ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Hora-Fecha");

        factura.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        factura.setForeground(new java.awt.Color(0, 153, 153));
        factura.setText("Numero");

        nombrecliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nombrecliente.setForeground(new java.awt.Color(0, 153, 153));
        nombrecliente.setText("Nombre");

        TipoPago.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        TipoPago.setForeground(new java.awt.Color(0, 153, 153));
        TipoPago.setText("Tipo");

        Fecha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 153, 153));
        Fecha.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Total");

        Total.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 153, 153));
        Total.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlTituloDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(Nom)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha)
                            .addComponent(TipoPago)
                            .addComponent(nombrecliente)
                            .addComponent(factura)
                            .addComponent(Total))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(factura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nom)
                    .addComponent(nombrecliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TipoPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCerrar)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Detalles();
        IMPRIMIR imprimir=new IMPRIMIR(txt,CantidadDeFilas(txt),txt.length());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    public static javax.swing.JLabel Nom;
    private javax.swing.JLabel TipoPago;
    public static javax.swing.JLabel Total;
    private javax.swing.JLabel factura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    public static javax.swing.JLabel jlTituloDetalles;
    private javax.swing.JTable jtDetallesFacturaCompra;
    private javax.swing.JLabel nombrecliente;
    // End of variables declaration//GEN-END:variables
}
