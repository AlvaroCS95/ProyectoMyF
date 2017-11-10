package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import static UI.PuntoDeVenta.txtCodigoCliente_PuntoDeVenta;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaDeClientesPuntoDeVenta extends javax.swing.JDialog {
    
    static Object[] filas;
    DefaultTableModel modelo;
    int fila;
    
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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
        jtListarClientesPV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListarClientesPVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListarClientesPV);

        jTextField1.setToolTipText("Código del cliente");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search_Icon_16.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 631, Short.MAX_VALUE)
                        .addComponent(jbAceptar)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jbAceptar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        txtCodigoCliente_PuntoDeVenta.setText(jtListarClientesPV.getValueAt(fila, 0).toString());
        dispose();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jtListarClientesPVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListarClientesPVMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            fila = jtListarClientesPV.getSelectedRow();
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            fila = jtListarClientesPV.getSelectedRow();
        }
    }//GEN-LAST:event_jtListarClientesPVMouseClicked
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbAceptar;
    public static javax.swing.JTable jtListarClientesPV;
    // End of variables declaration//GEN-END:variables
}
