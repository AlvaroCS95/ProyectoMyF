package UI;

import LogicaDeNegocios.CoordinadorDeClientes;

import static UI.BuscarClientes.columnaABuscar;

import static UI.PuntoDeVenta.txtCodigoCli_PuntoDeVenta;
import static UI.PuntoDeVenta.txtCantidadDeProducto_PuntoDeVenta;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListaDeClientesPuntoDeVenta extends javax.swing.JDialog {
    
    static Object[] filas;
    DefaultTableModel modelo;
    int fila;
    public static TableRowSorter trsFiltro;
    public ListaDeClientesPuntoDeVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        VisualizarClientes();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListarClientesPV = new javax.swing.JTable();
        txtBuscar_PuntoDeVenta = new javax.swing.JTextField();
        cbxFiltroCliente = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Lista de clientes disponibles");

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jtListarClientesPV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Primer nombre", "Primer apellido", "Segundo apellido", "Nombre del local", "Razón social"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListarClientesPV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtListarClientesPV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListarClientesPVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListarClientesPV);

        txtBuscar_PuntoDeVenta.setToolTipText("Código del cliente");
        txtBuscar_PuntoDeVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_PuntoDeVentaKeyTyped(evt);
            }
        });

        cbxFiltroCliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbxFiltroCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Cédula", "Nombre del propietario", "Nombre del local", "Razón social" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar_PuntoDeVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cbxFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAceptar)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar_PuntoDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jbAceptar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        String s = jtListarClientesPV.getValueAt(fila, 0).toString();
        txtCodigoCli_PuntoDeVenta.setText(jtListarClientesPV.getValueAt(fila, 0).toString());
        txtCantidadDeProducto_PuntoDeVenta.setText(jtListarClientesPV.getValueAt(fila, 0).toString());
        dispose();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jtListarClientesPVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListarClientesPVMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            fila = jtListarClientesPV.getSelectedRow();
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            fila = jtListarClientesPV.getSelectedRow();
        }
    }//GEN-LAST:event_jtListarClientesPVMouseClicked

    private void txtBuscar_PuntoDeVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_PuntoDeVentaKeyTyped
BuscarCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_PuntoDeVentaKeyTyped
    public static void filtro() {
    
        if (cbxFiltroCliente.getSelectedItem() == "Código") {
            columnaABuscar = 0;
        }
        if (cbxFiltroCliente.getSelectedItem() == "Cédula") {
            columnaABuscar = 1;
        }
        if (cbxFiltroCliente.getSelectedItem() == "Nombre del propietario") {
            columnaABuscar = 2;
        }
        if (cbxFiltroCliente.getSelectedItem() == "Razón social") {
            columnaABuscar = 6;
        }
        if (cbxFiltroCliente.getSelectedItem() == "Nombre del local") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar_PuntoDeVenta.getText(), columnaABuscar));
    }
    public  void BuscarCliente() {

        txtBuscar_PuntoDeVenta.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_PuntoDeVenta.getText());
                txtBuscar_PuntoDeVenta.setText(cadena);
                repaint();
                filtro();

            }
        });
        trsFiltro = new TableRowSorter(jtListarClientesPV.getModel());
        jtListarClientesPV.setRowSorter(trsFiltro);
    }
    public void VisualizarClientes() {
        try {
            modelo = (DefaultTableModel) jtListarClientesPV.getModel();
            
            CoordinadorDeClientes elCoordinador = new CoordinadorDeClientes();
            ResultSet resultadoConsulta = elCoordinador.ListarClientesParaSeleccionPV();
            
            filas = new Object[modelo.getColumnCount()];
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos "
                        + "de administrador", "Error de permisos",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {
                        filas[i] = resultadoConsulta.getObject(i + 1);
                    }
                    modelo.addRow(filas);
                    jtListarClientesPV.setModel(modelo);
                }
            }
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cbxFiltroCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAceptar;
    public static javax.swing.JTable jtListarClientesPV;
    public static javax.swing.JTextField txtBuscar_PuntoDeVenta;
    // End of variables declaration//GEN-END:variables
}
