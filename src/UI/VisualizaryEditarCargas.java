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
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   public static void ListarCargas(){
          try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Id de Carga");
            modelo.addColumn("Placa de Camión");
            modelo.addColumn("Fecha de Carga");
             modelo.addColumn("Usuario responsable");
         
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
        jLabel2 = new javax.swing.JLabel();
        txtBuscar_VisualizarCargas = new javax.swing.JTextField();
        cmbxFiltrar_VisualizarCargas = new javax.swing.JComboBox<String>();
        btActualizar_VisualizarCargas = new javax.swing.JButton();

        Editar_VisualizarCargas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar_VisualizarCargas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar_VisualizarCargas.setText("Editar");
        Editar_VisualizarCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_VisualizarCargasActionPerformed(evt);
            }
        });
        menuEmergente_VisualizarCargas.add(Editar_VisualizarCargas);

        detalles_VisualizarCargas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        detalles_VisualizarCargas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DetalleFactura.png"))); // NOI18N
        detalles_VisualizarCargas.setText("Detalles");
        detalles_VisualizarCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalles_VisualizarCargasActionPerformed(evt);
            }
        });
        menuEmergente_VisualizarCargas.add(detalles_VisualizarCargas);

        setPreferredSize(new java.awt.Dimension(1360, 700));

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
        tablaCargas_VisualizarCargas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCargas_VisualizarCargasMouseClicked(evt);
            }
        });
        tablaCargas_VisualizarCargas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaCargas_VisualizarCargasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCargas_VisualizarCargas);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Visualizar cargas");

        jLabel2.setText("Buscar carga:");

        txtBuscar_VisualizarCargas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarCargasKeyTyped(evt);
            }
        });

        cmbxFiltrar_VisualizarCargas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...","Por Id", "Por Camión", "Por Fecha"}));
        cmbxFiltrar_VisualizarCargas.setSelectedItem("Seleccione...");

        btActualizar_VisualizarCargas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_VisualizarCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_VisualizarCargasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxFiltrar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294)
                        .addComponent(btActualizar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(520, 520, 520))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btActualizar_VisualizarCargas))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbxFiltrar_VisualizarCargas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscar_VisualizarCargasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarCargasKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarCargasKeyTyped

    private void Editar_VisualizarCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_VisualizarCargasActionPerformed
    String PlacaDeCamion=tablaCargas_VisualizarCargas.getValueAt(fila, 1).toString();
    Date FechaCarga=ParseFecha(tablaCargas_VisualizarCargas.getValueAt(fila, 2).toString());
    int IdCarga=Integer.parseInt(tablaCargas_VisualizarCargas.getValueAt(fila, 0).toString());
    String usuario=tablaCargas_VisualizarCargas.getValueAt(fila, 3).toString();

        EditarCarga editarCarga;
      try {
          editarCarga = new EditarCarga(PlacaDeCamion, FechaCarga, IdCarga,usuario);
          editarCarga.setVisible(true);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(VisualizaryEditarCargas.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_Editar_VisualizarCargasActionPerformed

    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    private void btActualizar_VisualizarCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_VisualizarCargasActionPerformed
        ListarCargas();
        
    }//GEN-LAST:event_btActualizar_VisualizarCargasActionPerformed
int fila=0;
    private void tablaCargas_VisualizarCargasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaCargas_VisualizarCargasKeyPressed
       
        
        
    }//GEN-LAST:event_tablaCargas_VisualizarCargasKeyPressed

    private void tablaCargas_VisualizarCargasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCargas_VisualizarCargasMouseClicked
        
        if (evt.getButton() == MouseEvent.BUTTON1) {
            fila = tablaCargas_VisualizarCargas.getSelectedRow();
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            fila = tablaCargas_VisualizarCargas.getSelectedRow();
        }
    }//GEN-LAST:event_tablaCargas_VisualizarCargasMouseClicked

    private void detalles_VisualizarCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalles_VisualizarCargasActionPerformed
    String PlacaDeCamion=tablaCargas_VisualizarCargas.getValueAt(fila, 1).toString();
    Date FechaCarga=ParseFecha(tablaCargas_VisualizarCargas.getValueAt(fila, 2).toString());
    int IdCarga=Integer.parseInt(tablaCargas_VisualizarCargas.getValueAt(fila, 0).toString());
    String Usuario=tablaCargas_VisualizarCargas.getValueAt(fila, 3).toString();
        VisualizarDetallesDeCarga visualizarDetalle;
         
         visualizarDetalle = new  VisualizarDetallesDeCarga(IdCarga,PlacaDeCamion,Usuario,FechaCarga);
          visualizarDetalle.setVisible(true);
   
    }//GEN-LAST:event_detalles_VisualizarCargasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar_VisualizarCargas;
    private javax.swing.JButton btActualizar_VisualizarCargas;
    private javax.swing.JComboBox<String> cmbxFiltrar_VisualizarCargas;
    private javax.swing.JMenuItem detalles_VisualizarCargas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuEmergente_VisualizarCargas;
    public static javax.swing.JTable tablaCargas_VisualizarCargas;
    private javax.swing.JTextField txtBuscar_VisualizarCargas;
    // End of variables declaration//GEN-END:variables
}
