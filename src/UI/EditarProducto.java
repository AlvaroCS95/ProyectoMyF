package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import Modelos.Producto;
import static UI.IngresarProductos.cmbxClasificacion_IngresarProductos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EditarProducto extends javax.swing.JFrame {

    Producto elProductoAEditar = new Producto();

    public EditarProducto(Producto elProductoAEditar) {
        this.elProductoAEditar = elProductoAEditar;
        initComponents();
        ListarUMES();
        ListarClasificaciones();
        LlenarCampos();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(350, 100);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btLimpiar_IngresarInventario = new javax.swing.JButton();
        btAceptar_IngresarInventario = new javax.swing.JButton();
        btCancelar_IngresarInventario = new javax.swing.JButton();
        btActualizar_IngresarProductos = new javax.swing.JButton();
        txtCodigo_EditarProductos = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtNombre_EditarProductos = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cmbxClasificacion_EditarProductos = new javax.swing.JComboBox<>();
        btIngClasificacion_EditarProductos = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        txtPrecio_EditarProductos = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cmbxUME_EditarProductos = new javax.swing.JComboBox<>();
        btIngUME_IngresarProductos = new javax.swing.JButton();
        lbExistencias_EditarProductos = new javax.swing.JLabel();
        txtExistencias_EditarProductos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel37.setText("Edición de productos");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/records_notes_journal_edited_9479.png"))); // NOI18N

        btLimpiar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarInventario.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarInventarioActionPerformed(evt);
            }
        });

        btAceptar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarInventario.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarInventarioActionPerformed(evt);
            }
        });

        btCancelar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarInventario.setToolTipText("Oprima para cancelar");
        btCancelar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarInventarioActionPerformed(evt);
            }
        });

        btActualizar_IngresarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_IngresarProductosActionPerformed(evt);
            }
        });

        txtCodigo_EditarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCodigo_EditarProductos.setForeground(new java.awt.Color(0, 102, 102));
        txtCodigo_EditarProductos.setEnabled(false);
        txtCodigo_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo_EditarProductosActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("Código");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setText("Nombre");

        txtNombre_EditarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombre_EditarProductos.setForeground(new java.awt.Color(0, 102, 102));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setText("Clasificación");

        cmbxClasificacion_EditarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
        cmbxClasificacion_EditarProductos.setSelectedItem("");
        cmbxClasificacion_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxClasificacion_EditarProductosActionPerformed(evt);
            }
        });

        btIngClasificacion_EditarProductos.setText("Ingresar Clasificación");
        btIngClasificacion_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngClasificacion_EditarProductosActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setText("Precio de Venta");

        txtPrecio_EditarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrecio_EditarProductos.setForeground(new java.awt.Color(0, 102, 102));
        txtPrecio_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_EditarProductosActionPerformed(evt);
            }
        });
        txtPrecio_EditarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio_EditarProductosKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Tipo de medida(UME)");

        cmbxUME_EditarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
        cmbxUME_EditarProductos.setSelectedItem("");
        cmbxUME_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxUME_EditarProductosActionPerformed(evt);
            }
        });

        btIngUME_IngresarProductos.setText("Ingresar UME");
        btIngUME_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngUME_IngresarProductosActionPerformed(evt);
            }
        });

        lbExistencias_EditarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbExistencias_EditarProductos.setText("Existencias");

        txtExistencias_EditarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtExistencias_EditarProductos.setForeground(new java.awt.Color(0, 102, 102));
        txtExistencias_EditarProductos.setEnabled(false);
        txtExistencias_EditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExistencias_EditarProductosActionPerformed(evt);
            }
        });
        txtExistencias_EditarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistencias_EditarProductosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(44, 44, 44)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btIngUME_IngresarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(jLabel33)
                            .addComponent(lbExistencias_EditarProductos))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtExistencias_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbxClasificacion_EditarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre_EditarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo_EditarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio_EditarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxUME_EditarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btIngClasificacion_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLimpiar_IngresarInventario)
                    .addComponent(btActualizar_IngresarProductos)
                    .addComponent(btAceptar_IngresarInventario)
                    .addComponent(btCancelar_IngresarInventario))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpiar_IngresarInventario)
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel37)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(txtCodigo_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(cmbxClasificacion_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btIngClasificacion_EditarProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAceptar_IngresarInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39)
                                .addComponent(txtPrecio_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btCancelar_IngresarInventario))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbExistencias_EditarProductos)
                        .addComponent(txtExistencias_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btActualizar_IngresarProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxUME_EditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIngUME_IngresarProductos)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExistencias_EditarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistencias_EditarProductosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistencias_EditarProductosKeyTyped

    private void txtExistencias_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExistencias_EditarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistencias_EditarProductosActionPerformed

    private void btIngUME_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngUME_IngresarProductosActionPerformed
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
            java.util.logging.Logger.getLogger(IngresarUME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarUME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarUME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarUME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarUME().setVisible(true);
            }
        });
    }//GEN-LAST:event_btIngUME_IngresarProductosActionPerformed

    private void cmbxUME_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxUME_EditarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxUME_EditarProductosActionPerformed

    private void txtPrecio_EditarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_EditarProductosKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtPrecio_EditarProductosKeyTyped

    private void txtPrecio_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_EditarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio_EditarProductosActionPerformed

    private void btIngClasificacion_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngClasificacion_EditarProductosActionPerformed
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
            java.util.logging.Logger.getLogger(IngresarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarClasificacion().setVisible(true);
            }
        });
    }//GEN-LAST:event_btIngClasificacion_EditarProductosActionPerformed

    private void cmbxClasificacion_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxClasificacion_EditarProductosActionPerformed

    }//GEN-LAST:event_cmbxClasificacion_EditarProductosActionPerformed

    private void txtCodigo_EditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo_EditarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo_EditarProductosActionPerformed

    private void btActualizar_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_IngresarProductosActionPerformed
        cmbxClasificacion_EditarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));

        cmbxUME_EditarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));

        ListarUMES();
        ListarClasificaciones();
    }//GEN-LAST:event_btActualizar_IngresarProductosActionPerformed

    private void btCancelar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarInventarioActionPerformed
        int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            setVisible(false);
        }
    }//GEN-LAST:event_btCancelar_IngresarInventarioActionPerformed

    private void btAceptar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarInventarioActionPerformed
        if (VerificarCamposVacios_Producto() == false) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            return;
        } else {
            try {
                CoordinadorDeInventario elCoordinadorDeInventario = new CoordinadorDeInventario();
                String codigo = txtCodigo_EditarProductos.getText();
                String nombre = txtNombre_EditarProductos.getText();

                String clasificacion = (String) cmbxClasificacion_EditarProductos.getSelectedItem();
                int IdClasificacion = elCoordinadorDeInventario.ObtenerIdClasificacion(clasificacion);
                float precio = Float.parseFloat(txtPrecio_EditarProductos.getText());
                String UME = (String) cmbxUME_EditarProductos.getSelectedItem();
                float existencias = Float.parseFloat(txtExistencias_EditarProductos.getText());
                int IdUME = elCoordinadorDeInventario.ObtenerIdUME(UME);
                Modelos.Producto elProducto = new Modelos.Producto(codigo, nombre, IdClasificacion, existencias, precio, IdUME, false);
                if (elCoordinadorDeInventario.EditarProducto(elProducto) == true) {
                    JOptionPane.showMessageDialog(null, "Producto editado exitosamente");
                    VisualizarProductos.VisualizarTodosProductos();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la actualización");
                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btAceptar_IngresarInventarioActionPerformed
    public void LlenarCampos() {
        try {
            txtCodigo_EditarProductos.setText(elProductoAEditar.getCodigo());
            txtNombre_EditarProductos.setText(elProductoAEditar.getNombre());
            String precio = "" + elProductoAEditar.getPrecio();
            txtPrecio_EditarProductos.setText(precio);
            String existencias = "" + elProductoAEditar.getExistencias();
            txtExistencias_EditarProductos.setText(existencias);
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            String clasificacion = elCoordinador.ObtenerClasificacion(elProductoAEditar.getIdClasificacion());
            cmbxClasificacion_EditarProductos.setSelectedItem(clasificacion);
            String UME = elCoordinador.ObtenerUME(elProductoAEditar.getIdUME());
            cmbxUME_EditarProductos.setSelectedItem(UME);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    private void btLimpiar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarInventarioActionPerformed

        txtCodigo_EditarProductos.setText("");
        txtNombre_EditarProductos.setText("");
        txtPrecio_EditarProductos.setText("");
        txtExistencias_EditarProductos.setText("");
        cmbxClasificacion_EditarProductos.setSelectedItem("Seleccione...");
        cmbxUME_EditarProductos.setSelectedItem("Seleccione...");
    }//GEN-LAST:event_btLimpiar_IngresarInventarioActionPerformed
    public boolean VerificarCamposVacios_Producto() {

        if (cmbxUME_EditarProductos.getSelectedItem().equals("Seleccione...") || txtCodigo_EditarProductos.getText().equals("") || txtExistencias_EditarProductos.getText().equals("")
                || txtNombre_EditarProductos.getText().equals("") || cmbxClasificacion_EditarProductos.getSelectedItem().equals("Seleccione...")
                || txtPrecio_EditarProductos.getText().equals("")) {

            return false;
        }
        return true;
    }

    public static void ListarClasificaciones() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarClasificaciones();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
            cmbxClasificacion_EditarProductos.removeAllItems();
             cmbxClasificacion_EditarProductos.addItem("Seleccione...");
            cmbxClasificacion_EditarProductos.setSelectedItem("Seleccione...");
            while (resultadoConsulta.next()) {
                cmbxClasificacion_EditarProductos.addItem(resultadoConsulta.getString(2));
            }}
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public static void ListarUMES() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarUMES();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
              cmbxUME_EditarProductos.removeAllItems();
              cmbxUME_EditarProductos.addItem("Seleccione...");
             cmbxUME_EditarProductos.setSelectedItem("Seleccione...");
            while (resultadoConsulta.next()) {
                cmbxUME_EditarProductos.addItem(resultadoConsulta.getString(2));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarInventario;
    private javax.swing.JButton btActualizar_IngresarProductos;
    public static javax.swing.JButton btCancelar_IngresarInventario;
    private javax.swing.JButton btIngClasificacion_EditarProductos;
    private javax.swing.JButton btIngUME_IngresarProductos;
    public static javax.swing.JButton btLimpiar_IngresarInventario;
    public static javax.swing.JComboBox<String> cmbxClasificacion_EditarProductos;
    private static javax.swing.JComboBox<String> cmbxUME_EditarProductos;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbExistencias_EditarProductos;
    public static javax.swing.JTextField txtCodigo_EditarProductos;
    public static javax.swing.JTextField txtExistencias_EditarProductos;
    public static javax.swing.JTextField txtNombre_EditarProductos;
    public static javax.swing.JTextField txtPrecio_EditarProductos;
    // End of variables declaration//GEN-END:variables
}
