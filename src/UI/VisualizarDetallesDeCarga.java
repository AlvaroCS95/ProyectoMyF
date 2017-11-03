/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import static UI.VisualizaryEditarCargas.modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class VisualizarDetallesDeCarga extends javax.swing.JFrame {

      private TableRowSorter trsFiltro;
   static Object[] filas;
   static DefaultTableModel modelo;
   int IDCarga;
    public VisualizarDetallesDeCarga(int IdCarga) {
        initComponents();
        IDCarga=IdCarga;
    }
 public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Id") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Camión") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Fecha") {
            columnaABuscar = 2;
        }
      
        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }
 public void txtBuscar() {

       txtBuscar_VisualizarDetalleDeCarga.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_VisualizarDetalleDeCarga.getText());
                cadena = cadena.replace("a", "(a|á|A|Á)");
                cadena = cadena.replace("e", "(e|é|E|É)");
                cadena = cadena.replace("i", "(i|í|I|Í)");
                cadena = cadena.replace("o", "(o|ó|O|Ó)");
                cadena = cadena.replace("u", "(u|ú|U|Ú)");
                cadena = cadena.replace("A", "(a|á|A|Á)");
                cadena = cadena.replace("E", "(e|é|E|É)");
                cadena = cadena.replace("I", "(i|í|I|Í)");
                cadena = cadena.replace("O", "(o|ó|O|Ó)");
                cadena = cadena.replace("U", "(u|ú|U|Ú)");

                repaint();
                filtroPalabraClave("(?i).*" + cadena + ".*");
            }
        });
        trsFiltro = new TableRowSorter(Tabla_VisualizarDetalleDeCarga.getModel());
        Tabla_VisualizarDetalleDeCarga.setRowSorter(trsFiltro);
    }
    public void ListarDetalleDeCarga(){
      try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Id de Detalle");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");
         
            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();
            ResultSet resultadoConsulta = null;

            resultadoConsulta = elCoordinador.ListarDetalleDeCarga(IDCarga);
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
            }
            Tabla_VisualizarDetalleDeCarga.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_VisualizarDetalleDeCarga = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbxFiltrar_VisualizarDetalleDeCarga = new javax.swing.JComboBox<>();
        txtBuscar_VisualizarDetalleDeCarga = new javax.swing.JTextField();
        btCancelar_VisualizarDetalleDeCarga = new javax.swing.JButton();
        btActualizar_VisualizarDetalleDeCarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Visualizar detalle de carga");

        Tabla_VisualizarDetalleDeCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de Detalle", "Producto", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(Tabla_VisualizarDetalleDeCarga);

        jLabel2.setText("Buscar:");

        cmbxFiltrar_VisualizarDetalleDeCarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Por Id", "Por Producto", "Por Cantidad" }));

        btCancelar_VisualizarDetalleDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_VisualizarDetalleDeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_VisualizarDetalleDeCargaActionPerformed(evt);
            }
        });

        btActualizar_VisualizarDetalleDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_VisualizarDetalleDeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_VisualizarDetalleDeCargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbxFiltrar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btActualizar_VisualizarDetalleDeCarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar_VisualizarDetalleDeCarga)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmbxFiltrar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCancelar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btActualizar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelar_VisualizarDetalleDeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_VisualizarDetalleDeCargaActionPerformed
       dispose();
    }//GEN-LAST:event_btCancelar_VisualizarDetalleDeCargaActionPerformed

    private void btActualizar_VisualizarDetalleDeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_VisualizarDetalleDeCargaActionPerformed
      ListarDetalleDeCarga();
    }//GEN-LAST:event_btActualizar_VisualizarDetalleDeCargaActionPerformed

    /**
     * @param args the command line arguments
     */  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_VisualizarDetalleDeCarga;
    private javax.swing.JButton btActualizar_VisualizarDetalleDeCarga;
    private javax.swing.JButton btCancelar_VisualizarDetalleDeCarga;
    private javax.swing.JComboBox<String> cmbxFiltrar_VisualizarDetalleDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar_VisualizarDetalleDeCarga;
    // End of variables declaration//GEN-END:variables
}
