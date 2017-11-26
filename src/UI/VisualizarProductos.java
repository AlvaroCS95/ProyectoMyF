package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import Modelos.Producto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VisualizarProductos extends javax.swing.JPanel {

    private TableRowSorter trsFiltro;
   static Object[] filas;
   static DefaultTableModel modelo;

    public VisualizarProductos() {

        initComponents();
//        VisualizarTodosProductos();
    }

    public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "Codigo") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "Clasificación") {
            columnaABuscar = 2;
        }
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "Existencias") {
            columnaABuscar = 3;
        }
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "Precio") {
            columnaABuscar = 4;
        }
        if (cmbxFiltrar_VisualizarProductos.getSelectedItem() == "UME") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }

   
    public void txtBuscar() {

        txtBuscar_VisualizarProductos.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_VisualizarProductos.getText());
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
        trsFiltro = new TableRowSorter(Tabla2_ActualizacionProductos.getModel());
        Tabla2_ActualizacionProductos.setRowSorter(trsFiltro);
    }

    

   
    

    public void btEliminar2() {
        boolean eliminado = false;
        if (Tabla2_ActualizacionProductos.getSelectedRowCount() > 0) {
            int eliminarProducto = JOptionPane.showConfirmDialog(null, "¿Desea eliminar item(s) seleccionado(s)\n en la tabla inferior?", "Eliminar Producto", 1);
            if (JOptionPane.YES_OPTION == eliminarProducto) {
                while (Tabla2_ActualizacionProductos.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) Tabla2_ActualizacionProductos.getModel();
                    String codigo = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 0);
                    CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                    try {
                        eliminado = elCoordinador.EliminarProducto(codigo);
                    } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "¡Producto seleccionado no se puede eliminar!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                    
                    }
                    if (eliminado) {
                        dtm.removeRow(Tabla2_ActualizacionProductos.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "¡Producto eliminado correctamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        }

    }

    public void btEditar2() {
        try {
            if (Tabla2_ActualizacionProductos.getSelectedRowCount() > 0) {

                DefaultTableModel dtm = (DefaultTableModel) Tabla2_ActualizacionProductos.getModel();
                Producto elProductoAEditar = new Producto();
                elProductoAEditar.setCodigo((String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 0));
                elProductoAEditar.setNombre((String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 1));
                String clasificacion = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 2);
                CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                elProductoAEditar.setIdClasificacion(elCoordinador.ObtenerIdClasificacion(clasificacion));
                elProductoAEditar.setExistencias(Float.parseFloat(Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 3).toString()));
                elProductoAEditar.setPrecio((float) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 4));
                String UME = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 5);
                elProductoAEditar.setIdUME(elCoordinador.ObtenerIdUME(UME));
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditarProducto(elProductoAEditar).setVisible(true);
                    }
                });
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

   

   

   
   

    public static void VisualizarTodosProductos() {
        try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Clasificación");
            modelo.addColumn("Existencias");
            modelo.addColumn("Precio");
            modelo.addColumn("UME");

            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = null;

            resultadoConsulta = elCoordinador.ListarProductos();
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
            }
            Tabla2_ActualizacionProductos.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla2_ActualizacionProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar_VisualizarProductos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbxFiltrar_VisualizarProductos = new javax.swing.JComboBox<>();
        btEditartb2_VisualizarProductos1 = new javax.swing.JButton();
        btActualizar_VisualizarProductos = new javax.swing.JButton();
        btnControlExistencias_VisualizarProductos = new javax.swing.JToggleButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla2_ActualizacionProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Clasificación", "Existencias", "Precio", "UME"
            }
        ));
        jScrollPane1.setViewportView(Tabla2_ActualizacionProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 1170, 410));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel1.setText("Visualizar Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 230, -1));

        txtBuscar_VisualizarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarProductosKeyTyped(evt);
            }
        });
        add(txtBuscar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 200, -1));

        jLabel3.setText("Filtrar por palabra clave:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        cmbxFiltrar_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Seleccione...","Código","Nombre","Clasificación","Existencias","Precio","UME"}));
        cmbxFiltrar_VisualizarProductos.setSelectedItem("");
        add(cmbxFiltrar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 150, -1));

        btEditartb2_VisualizarProductos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditartb2_VisualizarProductos1.setToolTipText("Para editar un producto");
        btEditartb2_VisualizarProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditartb2_VisualizarProductos1ActionPerformed(evt);
            }
        });
        add(btEditartb2_VisualizarProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 50, 50));

        btActualizar_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_VisualizarProductos.setToolTipText("Para actualizar tabla");
        btActualizar_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btActualizar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 57, 50));

        btnControlExistencias_VisualizarProductos.setText("Ir a control de existencias...");
        btnControlExistencias_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlExistencias_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btnControlExistencias_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscar_VisualizarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarProductosKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarProductosKeyTyped

    private void btEditartb2_VisualizarProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditartb2_VisualizarProductos1ActionPerformed
        btEditar2();
    }//GEN-LAST:event_btEditartb2_VisualizarProductos1ActionPerformed

    private void btActualizar_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_VisualizarProductosActionPerformed
        VisualizarTodosProductos();
    }//GEN-LAST:event_btActualizar_VisualizarProductosActionPerformed

    private void btnControlExistencias_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlExistencias_VisualizarProductosActionPerformed
        
           ControlDeExistenciasDeProductos controldeexistencias=  new ControlDeExistenciasDeProductos();
           controldeexistencias.VisualizarTodosProductos();
           controldeexistencias.setVisible(true);
    }//GEN-LAST:event_btnControlExistencias_VisualizarProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabla2_ActualizacionProductos;
    private javax.swing.JButton btActualizar_VisualizarProductos;
    private javax.swing.JButton btEditartb2_VisualizarProductos1;
    private javax.swing.JToggleButton btnControlExistencias_VisualizarProductos;
    public static javax.swing.JComboBox<String> cmbxFiltrar_VisualizarProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txtBuscar_VisualizarProductos;
    // End of variables declaration//GEN-END:variables

}