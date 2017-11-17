package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class IngresarClasificacion extends javax.swing.JFrame {

    DefaultTableModel modelo;
    private TableRowSorter trsFiltro;
    Object[] filas;

    public IngresarClasificacion() {
        initComponents();
        ListarClasificaciones();

    }

    public void IngresarClasificacion() {

        if (txtNombre_IngresarClasificacion.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            return;
        } else {
            try {
                String elNombre = txtNombre_IngresarClasificacion.getText();

                CoordinadorDeInventario elCoordinadorDeInventario = new CoordinadorDeInventario();
                Modelos.Clasificacion laClasificacion = new Modelos.Clasificacion(0, elNombre);
                if (elCoordinadorDeInventario.AgregarClasificacion(laClasificacion) == true) {
                    txtNombre_IngresarClasificacion.setText("");
                    JOptionPane.showMessageDialog(null, "Clasificación insertada exitosamente");
                    ListarClasificaciones();
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la inserción");
                }
            } catch (Exception e) {
            }
        }
    }

    public void ListarClasificaciones() {
        try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modelo.addColumn("Nombre");
            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarClasificaciones();
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getString("Nombre");

                    }
                    modelo.addRow(filas);

                }
            }
            tbClasificacion_IngresarClasificacion.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void EliminarClasificacion() {
        boolean eliminado = false;
        if (tbClasificacion_IngresarClasificacion.getSelectedRowCount() > 0) {
            int eliminarProducto = JOptionPane.showConfirmDialog(null, "¿Desea eliminar item(s) seleccionado(s)\n en la tabla superior?", "Eliminar Producto", 1);
            if (JOptionPane.YES_OPTION == eliminarProducto) {
                while (tbClasificacion_IngresarClasificacion.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) tbClasificacion_IngresarClasificacion.getModel();
                    String Nombre = (String) tbClasificacion_IngresarClasificacion.getValueAt(tbClasificacion_IngresarClasificacion.getSelectedRow(), 0);
                    CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                    try {
                        int codigo = elCoordinador.ObtenerIdClasificacion(Nombre);
                        eliminado = elCoordinador.EliminarClasificacion(codigo);
                    } catch (SQLException ex) {

                    } catch (ClassNotFoundException ex) {

                    }
                    if (eliminado) {
                        dtm.removeRow(tbClasificacion_IngresarClasificacion.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "¡Clasificación eliminada correctamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        ListarClasificaciones();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Producto seleccionado no se ha podido eliminar correctamente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public void txtBuscar() {
        txtBuscar_IngresarClasificacion.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_IngresarClasificacion.getText());
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
                trsFiltro.setRowFilter(RowFilter.regexFilter("(?i).*" + cadena + ".*", 0));
            }
        });

        trsFiltro = new TableRowSorter(tbClasificacion_IngresarClasificacion.getModel());
        tbClasificacion_IngresarClasificacion.setRowSorter(trsFiltro);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombre_IngresarClasificacion = new javax.swing.JLabel();
        txtNombre_IngresarClasificacion = new javax.swing.JTextField();
        btAceptar_IngresarClasificacion = new javax.swing.JButton();
        btCancelar_IngresarClasificacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClasificacion_IngresarClasificacion = new javax.swing.JTable();
        txtBuscar_IngresarClasificacion = new javax.swing.JTextField();
        lbBuscar_IngresarClasificacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbTitulo_IngresarClasificacion = new javax.swing.JLabel();
        lbSubtitulo_IngresarClasificacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 250));
        setResizable(false);

        lbNombre_IngresarClasificacion.setText("Nombre");

        btAceptar_IngresarClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarClasificacion.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_IngresarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarClasificacionActionPerformed(evt);
            }
        });

        btCancelar_IngresarClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarClasificacion.setToolTipText("Oprima para cancelar");
        btCancelar_IngresarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarClasificacionActionPerformed(evt);
            }
        });

        tbClasificacion_IngresarClasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbClasificacion_IngresarClasificacion);

        txtBuscar_IngresarClasificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_IngresarClasificacionKeyTyped(evt);
            }
        });

        lbBuscar_IngresarClasificacion.setText("Buscar:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbTitulo_IngresarClasificacion.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        lbTitulo_IngresarClasificacion.setText("Gestión de Clasificaciones");

        lbSubtitulo_IngresarClasificacion.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        lbSubtitulo_IngresarClasificacion.setText("Ingreso de Clasificaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(lbNombre_IngresarClasificacion)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre_IngresarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btAceptar_IngresarClasificacion)
                                .addGap(30, 30, 30)
                                .addComponent(btCancelar_IngresarClasificacion))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(lbSubtitulo_IngresarClasificacion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBuscar_IngresarClasificacion)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar_IngresarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lbTitulo_IngresarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo_IngresarClasificacion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBuscar_IngresarClasificacion)
                            .addComponent(txtBuscar_IngresarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbSubtitulo_IngresarClasificacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre_IngresarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNombre_IngresarClasificacion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar_IngresarClasificacion)
                            .addComponent(btAceptar_IngresarClasificacion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptar_IngresarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarClasificacionActionPerformed
        IngresarClasificacion();
        IngresarProductos.ListarClasificaciones();
        EditarProducto.ListarClasificaciones();
    }//GEN-LAST:event_btAceptar_IngresarClasificacionActionPerformed

    private void btCancelar_IngresarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarClasificacionActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelar_IngresarClasificacionActionPerformed

    private void txtBuscar_IngresarClasificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_IngresarClasificacionKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_IngresarClasificacionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarClasificacion;
    public static javax.swing.JButton btCancelar_IngresarClasificacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBuscar_IngresarClasificacion;
    private javax.swing.JLabel lbNombre_IngresarClasificacion;
    private javax.swing.JLabel lbSubtitulo_IngresarClasificacion;
    private javax.swing.JLabel lbTitulo_IngresarClasificacion;
    private javax.swing.JTable tbClasificacion_IngresarClasificacion;
    private javax.swing.JTextField txtBuscar_IngresarClasificacion;
    private javax.swing.JTextField txtNombre_IngresarClasificacion;
    // End of variables declaration//GEN-END:variables
}
