/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import LogicaDeNegocios.CoordinadorDeInventario;
import static UI.IngresarProductos.cmbxUME_IngresarProductos;
import static UI.VisualizarProductos.cmbxFiltrar2_VisualizarProductos1;
import static UI.VisualizarProductos.modelo;
import static UI.VisualizarProductos.txtBuscar_VisualizarProductos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class VisualizaryEditarCargas extends javax.swing.JPanel {
  private TableRowSorter trsFiltro;
   static Object[] filas;
   static DefaultTableModel modelo;
    public VisualizaryEditarCargas() {
        initComponents();
    }
     public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrar_VisualizarCargas.getSelectedItem() == "Por Id") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrar_VisualizarCargas.getSelectedItem() == "Por Camión") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrar_VisualizarCargas.getSelectedItem() == "Por Fecha") {
            columnaABuscar = 2;
        }
      
        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }
 public void txtBuscar() {

       txtBuscar_VisualizarCargas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_VisualizarCargas.getText());
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
        trsFiltro = new TableRowSorter(tablaCargas_VisualizarCargas.getModel());
        tablaCargas_VisualizarCargas.setRowSorter(trsFiltro);
    }
   public void ListarCargas(){
          try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Id de Carga");
            modelo.addColumn("Placa de Camión");
            modelo.addColumn("Fecha de Carga");
         
            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();
            ResultSet resultadoConsulta = null;

            resultadoConsulta = elCoordinador.ListarCargas();
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
            }
            tablaCargas_VisualizarCargas.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
   }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEmergente_VisualizarCargas = new javax.swing.JPopupMenu();
        Editar_VisualizarCargas = new javax.swing.JMenuItem();
        detalles_VisualizarCargas = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCargas_VisualizarCargas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar_VisualizarCargas = new javax.swing.JTextField();
        cmbxFiltrar_VisualizarCargas = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        Editar_VisualizarCargas.setText("Editar");
        Editar_VisualizarCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_VisualizarCargasActionPerformed(evt);
            }
        });

        detalles_VisualizarCargas.setText("Detalles");

        tablaCargas_VisualizarCargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de Carga", "Placa", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCargas_VisualizarCargas.setComponentPopupMenu(menuEmergente_VisualizarCargas);
        jScrollPane1.setViewportView(tablaCargas_VisualizarCargas);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Visualizar y editar cargas");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N

        jLabel2.setText("Buscar carga:");

        txtBuscar_VisualizarCargas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarCargasKeyTyped(evt);
            }
        });

        cmbxFiltrar_VisualizarCargas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...","Por Id", "Por Camión", "Por Fecha"}));
        cmbxFiltrar_VisualizarCargas.setSelectedItem("Seleccione...");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VerContraseña.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbxFiltrar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtBuscar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbxFiltrar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscar_VisualizarCargasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarCargasKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarCargasKeyTyped

    private void Editar_VisualizarCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_VisualizarCargasActionPerformed
        EditarCarga editarCarga=new EditarCarga();
        editarCarga.setVisible(true);
    }//GEN-LAST:event_Editar_VisualizarCargasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar_VisualizarCargas;
    private javax.swing.JComboBox<String> cmbxFiltrar_VisualizarCargas;
    private javax.swing.JMenuItem detalles_VisualizarCargas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuEmergente_VisualizarCargas;
    private javax.swing.JTable tablaCargas_VisualizarCargas;
    private javax.swing.JTextField txtBuscar_VisualizarCargas;
    // End of variables declaration//GEN-END:variables
}
