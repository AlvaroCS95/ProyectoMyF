package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;

public class IngresarProductos extends javax.swing.JPanel {

    public IngresarProductos() {
        initComponents();
       //ListarUMES();
       //ListarClasificaciones();
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
            cmbxClasificacion_IngresarProductos.removeAllItems();
            cmbxClasificacion_IngresarProductos.addItem("Seleccione...");
            cmbxClasificacion_IngresarProductos.setSelectedItem("Seleccione...");
            while (resultadoConsulta.next()) {
        cmbxClasificacion_IngresarProductos.addItem(resultadoConsulta.getString(2));
            }}
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public boolean VerificarCamposVacios_Producto() {

        if (cmbxUME_IngresarProductos.getSelectedItem().equals("Seleccione...") || txtCodigo_IngresarInventario.getText().equals("")
                || txtNombre_IngresarInventario.getText().equals("") || cmbxClasificacion_IngresarProductos.getSelectedItem().equals("Seleccione...")
                || txtPrecio_IngresarInventario.getText().equals("")) {

            return false;
        }
        return true;
    }

    public void IngresarNuevaClsificacion() {

    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarClasificacion().setVisible(true);
            }
        });
    }

    public void NuevoProducto() {
        if (VerificarCamposVacios_Producto() == false) {

            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
           
        } else {
            try {
                CoordinadorDeInventario elCoordinadorDeInventario = new CoordinadorDeInventario();
                String codigo =txtCodigo_IngresarInventario.getText();
                String nombre = txtNombre_IngresarInventario.getText();

                String clasificacion = (String) cmbxClasificacion_IngresarProductos.getSelectedItem();
                int IdClasificacion = elCoordinadorDeInventario.ObtenerIdClasificacion(clasificacion);
                float precio = Float.parseFloat(txtPrecio_IngresarInventario.getText());
                String UME = (String) cmbxUME_IngresarProductos.getSelectedItem();
                int IdUME = elCoordinadorDeInventario.ObtenerIdUME(UME);
                Modelos.Producto elProducto = new Modelos.Producto(codigo, nombre, IdClasificacion, 0, precio, IdUME, false);
                if (elCoordinadorDeInventario.AgregarProducto(elProducto) == true) {
                    JOptionPane.showMessageDialog(null, "Producto insertado exitosamente");
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la inserción","ERROR",JOptionPane.ERROR_MESSAGE);
                   
                }
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error proveniente de la base de datos","ERROR",JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "Error de clase no encontrada","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        }
    }

    public void Cancelar() {
        int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            Inicio.JTInicio.setSelectedIndex(0);
        }
    }

    public static void ListarUMES() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarUMES();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                
            }
            else{
               cmbxUME_IngresarProductos.removeAllItems();
               cmbxUME_IngresarProductos.addItem("Seleccione...");
            cmbxUME_IngresarProductos.setSelectedItem("Seleccione...");
            while (resultadoConsulta.next()) {
                cmbxUME_IngresarProductos.addItem(resultadoConsulta.getString(2));
            }}
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void Actualizar() {
    
        ListarUMES();
        ListarClasificaciones();
    }

    public void ValidarSoloNumeros(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();

        }
        if (txtCodigo_IngresarInventario.getText().length()== 3)
        {    getToolkit().beep();
            evt.consume();
}
    }

    public void IngresarNuevoUME() {
     
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarUME().setVisible(true);
            }
        });
    }

    public void Limpiar() {
        txtCodigo_IngresarInventario.setText("");
        txtNombre_IngresarInventario.setText("");
        txtPrecio_IngresarInventario.setText("");
        cmbxClasificacion_IngresarProductos.setSelectedItem("");
        cmbxUME_IngresarProductos.setSelectedItem("");
        cmbxClasificacion_IngresarProductos.setSelectedItem("Seleccione...");
        cmbxUME_IngresarProductos.setSelectedItem("Seleccione...");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtCodigo_IngresarInventario = new javax.swing.JTextField();
        txtNombre_IngresarInventario = new javax.swing.JTextField();
        cmbxClasificacion_IngresarProductos = new javax.swing.JComboBox<>();
        btIngClasificacion_IngresarProductos = new javax.swing.JButton();
        btLimpiar_IngresarInventario = new javax.swing.JButton();
        btAceptar_IngresarInventario = new javax.swing.JButton();
        btCancelar_IngresarInventario = new javax.swing.JButton();
        btActualizar_IngresarProductos = new javax.swing.JButton();
        txtPrecio_IngresarInventario = new javax.swing.JTextField();
        cmbxUME_IngresarProductos = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btIngUME_IngresarProductos = new javax.swing.JButton();
        lbClasificacion_IngresarProductos = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel37.setText("Ingreso de productos");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/business_package_box_accept_productorpackagetoaccept_negocio_paquet_2334.png"))); // NOI18N
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("Código");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setText("Nombre");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setText("Clasificación");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        txtCodigo_IngresarInventario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCodigo_IngresarInventario.setForeground(new java.awt.Color(0, 102, 102));
        txtCodigo_IngresarInventario.setToolTipText("Codigo del nuevo producto");
        txtCodigo_IngresarInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigo_IngresarInventarioKeyTyped(evt);
            }
        });
        add(txtCodigo_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 50, -1));

        txtNombre_IngresarInventario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombre_IngresarInventario.setForeground(new java.awt.Color(0, 102, 102));
        txtNombre_IngresarInventario.setToolTipText("Nombre del nuevo producto ");
        add(txtNombre_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 163, -1));

        cmbxClasificacion_IngresarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione..."}));
        cmbxClasificacion_IngresarProductos.setSelectedItem("");
        JScrollPane pane = new JScrollPane(cmbxClasificacion_IngresarProductos,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cmbxClasificacion_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxClasificacion_IngresarProductosActionPerformed(evt);
            }
        });
        add(cmbxClasificacion_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 163, -1));

        btIngClasificacion_IngresarProductos.setText("Ingresar Clasificación");
        btIngClasificacion_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngClasificacion_IngresarProductosActionPerformed(evt);
            }
        });
        add(btIngClasificacion_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 163, -1));

        btLimpiar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_IngresarInventario.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarInventarioActionPerformed(evt);
            }
        });
        add(btLimpiar_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, -1, -1));

        btAceptar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarInventario.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarInventarioActionPerformed(evt);
            }
        });
        add(btAceptar_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, -1, -1));

        btCancelar_IngresarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarInventario.setToolTipText("Oprima para cancelar");
        btCancelar_IngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarInventarioActionPerformed(evt);
            }
        });
        add(btCancelar_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, -1, -1));

        btActualizar_IngresarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_IngresarProductosActionPerformed(evt);
            }
        });
        add(btActualizar_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 470, -1, -1));

        txtPrecio_IngresarInventario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPrecio_IngresarInventario.setForeground(new java.awt.Color(0, 102, 102));
        txtPrecio_IngresarInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio_IngresarInventarioKeyTyped(evt);
            }
        });
        add(txtPrecio_IngresarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 163, -1));

        cmbxUME_IngresarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione..."}));
        cmbxUME_IngresarProductos.setSelectedItem("");
        add(cmbxUME_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 163, -1));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setText("Precio de Venta");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Tipo de medida(UME)");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        btIngUME_IngresarProductos.setText("Ingresar UME");
        btIngUME_IngresarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngUME_IngresarProductosActionPerformed(evt);
            }
        });
        add(btIngUME_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 163, -1));

        lbClasificacion_IngresarProductos.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lbClasificacion_IngresarProductos.setText("-");
        add(lbClasificacion_IngresarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 20, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btIngClasificacion_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngClasificacion_IngresarProductosActionPerformed
        IngresarNuevaClsificacion();
    }//GEN-LAST:event_btIngClasificacion_IngresarProductosActionPerformed

    private void btAceptar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarInventarioActionPerformed
        NuevoProducto();
        Limpiar();
    }//GEN-LAST:event_btAceptar_IngresarInventarioActionPerformed

    private void btCancelar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarInventarioActionPerformed
        Cancelar();
    }//GEN-LAST:event_btCancelar_IngresarInventarioActionPerformed

    private void btActualizar_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_IngresarProductosActionPerformed
        Actualizar();
    }//GEN-LAST:event_btActualizar_IngresarProductosActionPerformed

    private void txtPrecio_IngresarInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_IngresarInventarioKeyTyped
         char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecio_IngresarInventarioKeyTyped

    private void btIngUME_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngUME_IngresarProductosActionPerformed
        IngresarNuevoUME();
    }//GEN-LAST:event_btIngUME_IngresarProductosActionPerformed

    private void btLimpiar_IngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarInventarioActionPerformed
        Limpiar();
    }//GEN-LAST:event_btLimpiar_IngresarInventarioActionPerformed

    private void cmbxClasificacion_IngresarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxClasificacion_IngresarProductosActionPerformed
       try{
           if(!cmbxClasificacion_IngresarProductos.getSelectedItem().equals("Seleccione...")){

        String clasificacion=(String)cmbxClasificacion_IngresarProductos.getSelectedItem();
        clasificacion=clasificacion.toUpperCase();
        char [] inicioDeCodigo= clasificacion.toCharArray();
        lbClasificacion_IngresarProductos.setText(""+inicioDeCodigo[0]);}
           else{
           lbClasificacion_IngresarProductos.setText("-");
           }
       }
       catch(NullPointerException n){
       
       }
    }//GEN-LAST:event_cmbxClasificacion_IngresarProductosActionPerformed
    
    private void txtCodigo_IngresarInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo_IngresarInventarioKeyTyped
        ValidarSoloNumeros(evt);
    }//GEN-LAST:event_txtCodigo_IngresarInventarioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAceptar_IngresarInventario;
    private javax.swing.JButton btActualizar_IngresarProductos;
    public static javax.swing.JButton btCancelar_IngresarInventario;
    private javax.swing.JButton btIngClasificacion_IngresarProductos;
    private javax.swing.JButton btIngUME_IngresarProductos;
    public static javax.swing.JButton btLimpiar_IngresarInventario;
    public static javax.swing.JComboBox<String> cmbxClasificacion_IngresarProductos;
    public static javax.swing.JComboBox<String> cmbxUME_IngresarProductos;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel lbClasificacion_IngresarProductos;
    public static javax.swing.JTextField txtCodigo_IngresarInventario;
    public static javax.swing.JTextField txtNombre_IngresarInventario;
    public static javax.swing.JTextField txtPrecio_IngresarInventario;
    // End of variables declaration//GEN-END:variables
}
