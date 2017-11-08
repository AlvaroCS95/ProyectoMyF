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

public class IngresarUME extends javax.swing.JFrame {

    DefaultTableModel modelo;
    private TableRowSorter trsFiltro;
    Object[] filas;

    public IngresarUME() {
        initComponents();
        ListarUMES();
    }

    public void ListarUMES() {
        try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modelo.addColumn("Nombre");
            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarUMES();
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getString("UME");

                    }
                    modelo.addRow(filas);

                }
            }
            tbUME_IngresarUME.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void IngresarUME() {
        if (txtNombre_IngresarUME.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            return;
        } else {
            try {
                String ume = txtNombre_IngresarUME.getText();

                CoordinadorDeInventario elCoordinadorDeInventario = new CoordinadorDeInventario();
                Modelos.UME laUme = new Modelos.UME(0, ume);
                if (elCoordinadorDeInventario.AgregarUME(laUme) == true) {
                    txtNombre_IngresarUME.setText("");
                    JOptionPane.showMessageDialog(null, "UME insertada exitosamente");
                    ListarUMES();
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la inserción");
                }
            } catch (Exception e) {
            }
        }
    }

    public void BuscarUME() {
        txtBuscar_IngresarUME.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_IngresarUME.getText());
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

        trsFiltro = new TableRowSorter(tbUME_IngresarUME.getModel());
        tbUME_IngresarUME.setRowSorter(trsFiltro);
    }

    public void ELiminarUME() {

        boolean eliminado = false;
        if (tbUME_IngresarUME.getSelectedRowCount() > 0) {
            int eliminarProducto = JOptionPane.showConfirmDialog(null, "¿Desea eliminar item(s) seleccionado(s)\n en la tabla superior?", "Eliminar Producto", 1);
            if (JOptionPane.YES_OPTION == eliminarProducto) {
                while (tbUME_IngresarUME.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) tbUME_IngresarUME.getModel();
                    String Nombre = (String) tbUME_IngresarUME.getValueAt(tbUME_IngresarUME.getSelectedRow(), 0);
                    CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                    try {
                        int codigo = elCoordinador.ObtenerIdUME(Nombre);
                        eliminado = elCoordinador.EliminarUME(codigo);
                    } catch (SQLException ex) {

                    } catch (ClassNotFoundException ex) {

                    }
                    if (eliminado) {
                        dtm.removeRow(tbUME_IngresarUME.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "¡Clasificación eliminada correctamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        ListarUMES();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Producto seleccionado no se ha podido eliminar correctamente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bNombre_IngresarUME = new javax.swing.JLabel();
        txtNombre_IngresarUME = new javax.swing.JTextField();
        btAceptar_IngresarUME = new javax.swing.JButton();
        btCancelar_IngresarUME = new javax.swing.JButton();
        lbTitulo_IngresarUME = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbBuscar_IngresarClasificacion = new javax.swing.JLabel();
        txtBuscar_IngresarUME = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUME_IngresarUME = new javax.swing.JTable();
        btEliminar_IngresarUME = new javax.swing.JButton();
        lbSubtitulo_IngresarUME = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 250));
        setResizable(false);

        bNombre_IngresarUME.setText("Nombre");

        btAceptar_IngresarUME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarUME.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_IngresarUME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarUMEActionPerformed(evt);
            }
        });

        btCancelar_IngresarUME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarUME.setToolTipText("Oprima para cancelar");
        btCancelar_IngresarUME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarUMEActionPerformed(evt);
            }
        });

        lbTitulo_IngresarUME.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        lbTitulo_IngresarUME.setText("Gestión de UMES");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbBuscar_IngresarClasificacion.setText("Buscar:");

        txtBuscar_IngresarUME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_IngresarUMEKeyTyped(evt);
            }
        });

        tbUME_IngresarUME.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbUME_IngresarUME);

        btEliminar_IngresarUME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubo-de-basura.png"))); // NOI18N
        btEliminar_IngresarUME.setToolTipText("Oprimir para guardar datos de camión");
        btEliminar_IngresarUME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminar_IngresarUMEActionPerformed(evt);
            }
        });

        lbSubtitulo_IngresarUME.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        lbSubtitulo_IngresarUME.setText("Ingreso de UMES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btAceptar_IngresarUME)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar_IngresarUME))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(bNombre_IngresarUME)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre_IngresarUME, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lbSubtitulo_IngresarUME)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBuscar_IngresarClasificacion)
                        .addGap(32, 32, 32)
                        .addComponent(txtBuscar_IngresarUME, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEliminar_IngresarUME))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(lbTitulo_IngresarUME, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo_IngresarUME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbBuscar_IngresarClasificacion)
                                .addComponent(txtBuscar_IngresarUME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btEliminar_IngresarUME))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbSubtitulo_IngresarUME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bNombre_IngresarUME)
                            .addComponent(txtNombre_IngresarUME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAceptar_IngresarUME)
                            .addComponent(btCancelar_IngresarUME)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptar_IngresarUMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarUMEActionPerformed
        IngresarUME();
        IngresarProductos.ListarUMES();
        EditarProducto.ListarUMES();
    }//GEN-LAST:event_btAceptar_IngresarUMEActionPerformed

    private void btCancelar_IngresarUMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarUMEActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelar_IngresarUMEActionPerformed

    private void txtBuscar_IngresarUMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_IngresarUMEKeyTyped
        BuscarUME();
    }//GEN-LAST:event_txtBuscar_IngresarUMEKeyTyped

    private void btEliminar_IngresarUMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminar_IngresarUMEActionPerformed
        ELiminarUME();
    }//GEN-LAST:event_btEliminar_IngresarUMEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bNombre_IngresarUME;
    public static javax.swing.JButton btAceptar_IngresarUME;
    public static javax.swing.JButton btCancelar_IngresarUME;
    public static javax.swing.JButton btEliminar_IngresarUME;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBuscar_IngresarClasificacion;
    private javax.swing.JLabel lbSubtitulo_IngresarUME;
    private javax.swing.JLabel lbTitulo_IngresarUME;
    private javax.swing.JTable tbUME_IngresarUME;
    private javax.swing.JTextField txtBuscar_IngresarUME;
    private javax.swing.JTextField txtNombre_IngresarUME;
    // End of variables declaration//GEN-END:variables
}
