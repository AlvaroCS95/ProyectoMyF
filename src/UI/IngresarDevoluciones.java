/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import LogicaDeNegocios.CoordinadorDeUsuarios;
import LogicaDeNegocios.CoordinadorDeDevoluciones;
import LogicaDeNegocios.CoordinadorDeProductosReintegrados;
import LogicaDeNegocios.CoordinadorDeProductosDesechados;
import Modelos.Devolucion;
import Modelos.ProductosDesechados;
import Modelos.ProductosReintegrados;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IngresarDevoluciones extends javax.swing.JPanel {

    DetalleProductoDesechado detalleProductoDesechado = new DetalleProductoDesechado();
    DetalleProductoReintegrados DetalleProductoReintegrados = new DetalleProductoReintegrados();
    BuscarFacturasDeVenta buscarFacturaDeVenta = new BuscarFacturasDeVenta();
    public static int FilaSeleccionadaDetalleFactura;
    public boolean SeleccionDetalleFactura = false;
    public static int FilaSeleccionadaReintegro;
    public boolean SeleccionReintegro = false;
    public static int FilaSeleccionadaDesechado;
    public boolean SeleccionDesechado = false;
    public float ReintegradoAlCliente = 0;

    public IngresarDevoluciones() {
        initComponents();
    }
    
    public static DefaultTableModel ModeloProductosReintegrados = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    public static DefaultTableModel ModeloProductosDesechados = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    
    public static DefaultTableModel ModeloDetalleProductos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel44 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btLimpiar_IngresarDevoluciones = new javax.swing.JButton();
        txtNombreLocal_IngresarDevoluciones = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btReintegro_IngresarDevoluciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNFactura_IngresarDevoluciones = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaDeVenta_IngresarDevoluciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMontoDeVenta_IngresarDevoluciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreUsuario_IngresarDevoluciones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleFacturaDeVenta_Devoluciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaReintegro_Devoluciones = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaProductosDesechados_Devoluciones = new javax.swing.JTable();
        btAgregarDesechados_Devoluciones = new javax.swing.JButton();
        btQuitarReintegro_Devoluciones = new javax.swing.JButton();
        btAgegarReintegro_Devoluciones = new javax.swing.JButton();
        btQuitarDesechado_Devoluciones = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1260, 690));
        setVerifyInputWhenFocusTarget(false);

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 3, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 112));
        jLabel44.setText("Ingreso de devoluciones");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setAlignmentX(5.0F);

        btLimpiar_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btLimpiar_IngresarDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CancelIconn.png"))); // NOI18N
        btLimpiar_IngresarDevoluciones.setText("Limpiar tablas");
        btLimpiar_IngresarDevoluciones.setToolTipText("Oprima para limpiar campos");
        btLimpiar_IngresarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarDevolucionesActionPerformed(evt);
            }
        });

        txtNombreLocal_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreLocal_IngresarDevoluciones.setForeground(new java.awt.Color(0, 102, 102));
        txtNombreLocal_IngresarDevoluciones.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setText("Nombre del local: ");

        btReintegro_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btReintegro_IngresarDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AddIcon.png"))); // NOI18N
        btReintegro_IngresarDevoluciones.setText("Ingresar Devolucion");
        btReintegro_IngresarDevoluciones.setToolTipText("Oprimir para guardar datos de devolución");
        btReintegro_IngresarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReintegro_IngresarDevolucionesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 112));
        jLabel1.setText("Primero seleccione la factura de venta que desea ingresar la devolucion.");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search_Icon_16.png"))); // NOI18N
        jButton1.setText("Seleccionar Factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Número de Factura: ");

        txtNFactura_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNFactura_IngresarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtNFactura_IngresarDevoluciones.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Fecha Venta: ");

        txtFechaDeVenta_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtFechaDeVenta_IngresarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtFechaDeVenta_IngresarDevoluciones.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Monto de la venta: ");

        txtMontoDeVenta_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDeVenta_IngresarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtMontoDeVenta_IngresarDevoluciones.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nombre Usuario: ");

        txtNombreUsuario_IngresarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreUsuario_IngresarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtNombreUsuario_IngresarDevoluciones.setEnabled(false);

        TablaDetalleFacturaDeVenta_Devoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Cantidad Vendida", "Cantidad Restante"
            }
        ));
        TablaDetalleFacturaDeVenta_Devoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDetalleFacturaDeVenta_DevolucionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDetalleFacturaDeVenta_Devoluciones);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 112));
        jLabel6.setText("Productos Reintegrados");

        TablaReintegro_Devoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre producto", "Cantidad Reintegada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaReintegro_Devoluciones.getTableHeader().setReorderingAllowed(false);
        TablaReintegro_Devoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaReintegro_DevolucionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaReintegro_DevolucionesMousePressed(evt);
            }
        });
        TablaReintegro_Devoluciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaReintegro_DevolucionesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TablaReintegro_DevolucionesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TablaReintegro_Devoluciones);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 112));
        jLabel7.setText("Lista de productos vendidos");

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 112));
        jLabel8.setText("Productos Desechados");

        TablaProductosDesechados_Devoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Cantidad Desechada", "Detalle"
            }
        ));
        TablaProductosDesechados_Devoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosDesechados_DevolucionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaProductosDesechados_DevolucionesMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TablaProductosDesechados_Devoluciones);

        btAgregarDesechados_Devoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/derecha-flecha-negro_318-33109.jpg"))); // NOI18N
        btAgregarDesechados_Devoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarDesechados_DevolucionesActionPerformed(evt);
            }
        });

        btQuitarReintegro_Devoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/derecha-flecha-negro_318-33109.jpg"))); // NOI18N
        btQuitarReintegro_Devoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuitarReintegro_DevolucionesActionPerformed(evt);
            }
        });

        btAgegarReintegro_Devoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/izquierda-flecha-negro_318-33109.jpg"))); // NOI18N
        btAgegarReintegro_Devoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgegarReintegro_DevolucionesActionPerformed(evt);
            }
        });

        btQuitarDesechado_Devoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/izquierda-flecha-negro_318-33109.jpg"))); // NOI18N
        btQuitarDesechado_Devoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuitarDesechado_DevolucionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jLabel44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(txtMontoDeVenta_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreUsuario_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(txtNFactura_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(txtNombreLocal_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFechaDeVenta_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(btLimpiar_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btReintegro_IngresarDevoluciones)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btQuitarReintegro_Devoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAgegarReintegro_Devoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btQuitarDesechado_Devoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAgregarDesechados_Devoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel44)
                .addGap(11, 11, 11)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtNFactura_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel42))
                    .addComponent(txtNombreLocal_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMontoDeVenta_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreUsuario_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDeVenta_IngresarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btQuitarDesechado_Devoluciones)
                        .addGap(39, 39, 39)
                        .addComponent(btAgregarDesechados_Devoluciones))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btQuitarReintegro_Devoluciones)
                        .addGap(46, 46, 46)
                        .addComponent(btAgegarReintegro_Devoluciones)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLimpiar_IngresarDevoluciones)
                    .addComponent(btReintegro_IngresarDevoluciones))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btLimpiar_IngresarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarDevolucionesActionPerformed
        // TODO add your handling code here:
        int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("Seguro que desea limpiar todas las tablas", "Limpiar tablas");
        if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
            try {
                LimpiarTablas(TablaReintegro_Devoluciones, ModeloProductosReintegrados);
                LimpiarTablas(TablaDetalleFacturaDeVenta_Devoluciones, ModeloDetalleProductos);
                LimpiarTablas(TablaProductosDesechados_Devoluciones, ModeloProductosDesechados);
                LimpiarCamposDeLaFactura();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de borrar las tablas, por favor vuelva intentarlo");
            }

        } else {
            return;
        }

    }//GEN-LAST:event_btLimpiar_IngresarDevolucionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (buscarFacturaDeVenta.isVisible() == true) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "ya tiene una ventana de buscar factura abierta.");
            buscarFacturaDeVenta.toFront();
        } else {
            buscarFacturaDeVenta.setVisible(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btReintegro_IngresarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReintegro_IngresarDevolucionesActionPerformed
        int UsuarioActivo = 0;
        Devolucion LaDevolucionAIngresar = new Devolucion();
        CoordinadorDeDevoluciones ElCoordinadorDeDevoluciones = new CoordinadorDeDevoluciones();
        int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("Seguro que desea ingesar esta devolución", "IngresarTablas");
        if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
            //try {
                UsuarioActivo = DevolverIdUsuarioActivo();
                if (VerificarQueAlMenosUnaTablaNoEsteVacia() == true) {
                    JOptionPane.showMessageDialog(null, "Primero debe de ingresar un producto a desecho o rintegro");
                    return;
                } else {
                    LaDevolucionAIngresar.setCedulaUsuario(UsuarioActivo);
                    LaDevolucionAIngresar.setNumeroFactura(txtNFactura_IngresarDevoluciones.getText());
                    LaDevolucionAIngresar.setValorTotal(RecolectarElValorTotalDeLaDevoluciónAdemasDelTotalReintegradoAlCliente());
                    LaDevolucionAIngresar.setReintegroAlCliente(ReintegradoAlCliente);
                   
                    try {
                        if (ElCoordinadorDeDevoluciones.AgregarDevoluciones(LaDevolucionAIngresar) == true) {
                            JOptionPane.showMessageDialog(null, "Se ingreso exitosamente");
                             try {
                            boolean SeIngresoLosDetalles = IngresarDetalleDeLaDevolucion(txtNFactura_IngresarDevoluciones.getText());
                            if (SeIngresoLosDetalles == true) {
                            JOptionPane.showMessageDialog(null, "Se ingreso la devolucion con exito");
                            LimpiarTablas(TablaReintegro_Devoluciones, ModeloProductosReintegrados);
                            LimpiarTablas(TablaDetalleFacturaDeVenta_Devoluciones, ModeloDetalleProductos);
                            LimpiarTablas(TablaProductosDesechados_Devoluciones, ModeloProductosDesechados);
                            LimpiarCamposDeLaFactura();
                            } else {
                            JOptionPane.showMessageDialog(null, "No se puede ingresar los detalles");
                            }
                             } catch (Exception e) {
                             JOptionPane.showMessageDialog(null, "Error en la inserción de los detalle");
                             }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error en la inserción");
                        }//fin else se inserto
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(IngresarDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(IngresarDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }//fin else si las tablas estan vacias.
          //  } catch (Exception e) {
          //      JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de ingresar las devoluciones, por favor vuelva intentarlo");
           // }

        } else {
            return;
        }
    }//GEN-LAST:event_btReintegro_IngresarDevolucionesActionPerformed

    private void TablaDetalleFacturaDeVenta_DevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleFacturaDeVenta_DevolucionesMousePressed
        FilaSeleccionadaDetalleFactura = TablaDetalleFacturaDeVenta_Devoluciones.getSelectedRow();
        SeleccionDetalleFactura = true;
    }//GEN-LAST:event_TablaDetalleFacturaDeVenta_DevolucionesMousePressed

    private void btQuitarDesechado_DevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuitarDesechado_DevolucionesActionPerformed
        // TODO add your handling code here:
        String CodigoDelProducto = "";
        String NombreDelProducto = "";
        float NuevaCantidadaRestante = 0;

        float Cantidad = 0;
        if (SeleccionDesechado == false) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Primero seleccione un producto que quiere quitar de desechos");
        } else {

            try {
                CodigoDelProducto = TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionadaDesechado, 0).toString();
                NombreDelProducto = TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionadaDesechado, 1).toString();
                Cantidad = Float.parseFloat(TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionadaDesechado, 2).toString());
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿esta seguro que desea quitar a: " + NombreDelProducto + " de desechos?", "Quitar producto Producto");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
                    if (quitarFila(TablaProductosDesechados_Devoluciones, ModeloProductosDesechados, FilaSeleccionadaDesechado) == true) {
                        int FilaDelProductoAAgregar = DevolverFilaDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoDelProducto);
                        float CantidadRestante = BuscarCantidadRestanteDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoDelProducto);
                        NuevaCantidadaRestante = CantidadRestante + Cantidad;
                        TablaDetalleFacturaDeVenta_Devoluciones.setValueAt(NuevaCantidadaRestante, FilaDelProductoAAgregar, 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de quitar su producto, por favor vuelva intentarlo");
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de quitar su producto, por favor vuelva intentarlo");
            }
        }
    }//GEN-LAST:event_btQuitarDesechado_DevolucionesActionPerformed

    private void TablaProductosDesechados_DevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosDesechados_DevolucionesMousePressed
        FilaSeleccionadaDesechado = TablaProductosDesechados_Devoluciones.getSelectedRow();
        SeleccionDesechado = true; // TODO add your handling code here:
    }//GEN-LAST:event_TablaProductosDesechados_DevolucionesMousePressed

    private void TablaReintegro_DevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesMousePressed
        // TODO add your handling code here:
        FilaSeleccionadaReintegro = TablaReintegro_Devoluciones.getSelectedRow();
        SeleccionReintegro = true;
    }//GEN-LAST:event_TablaReintegro_DevolucionesMousePressed

    private void btAgregarDesechados_DevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarDesechados_DevolucionesActionPerformed
        // TODO add your handling code here:
        String CodigoDelProducto = "";
        String NombreDelProducto = "";
        float Cantidad = 0;
        float CantidadMaxima = 0;
        float CantidadVendidaParaComprar = 0;
        float CantidadRestanteParaComparar = 0;

        if (SeleccionDetalleFactura == false) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Primero seleccione el producto al que quiera agregar a desechos");
        } else {
            CodigoDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 0).toString();
            if (BuscarSiExisteUnProductoEnUnaTablaDeterminada(TablaProductosDesechados_Devoluciones, CodigoDelProducto) == true) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Ya tiene este producto agregado para desecharlo.\n"
                        + "Si desea hacer un cambio, dirijase al producto y con un doble clic en el podrá editarlo.");
            } else {
                if (detalleProductoDesechado.isVisible() == true) {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "ya tiene una ventana producto desechado abierta.");
                    detalleProductoDesechado.toFront();
                } else {
                    try {
                        CodigoDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 0).toString();
                        NombreDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 1).toString();
                        Cantidad = Float.parseFloat(TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 2).toString());
                        CantidadMaxima = Float.parseFloat(TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 3).toString());
                    } catch (Exception e) {
                    }
                    String NumeroFactura = txtNFactura_IngresarDevoluciones.getText();
                    detalleProductoDesechado = new DetalleProductoDesechado(NumeroFactura, CodigoDelProducto, NombreDelProducto, Cantidad, CantidadMaxima);
                    detalleProductoDesechado.setVisible(true);
                }//fin else si esta abierto el jframe
            }//fin else si existe el producto
        }//fin else seleccionfactura
    }//GEN-LAST:event_btAgregarDesechados_DevolucionesActionPerformed

    private void btQuitarReintegro_DevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuitarReintegro_DevolucionesActionPerformed
        // TODO add your handling code here:
        String CodigoDelProducto = "";
        String NombreDelProducto = "";
        float NuevaCantidadaRestante = 0;

        float Cantidad = 0;
        if (SeleccionReintegro == false) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Primero seleccione un producto que quiere quitar de reintegros");
        } else {

            try {
                CodigoDelProducto = TablaReintegro_Devoluciones.getValueAt(FilaSeleccionadaReintegro, 0).toString();
                NombreDelProducto = TablaReintegro_Devoluciones.getValueAt(FilaSeleccionadaReintegro, 1).toString();
                Cantidad = Float.parseFloat(TablaReintegro_Devoluciones.getValueAt(FilaSeleccionadaReintegro, 2).toString());
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿esta seguro que desea quitar a: " + NombreDelProducto + " de reintegros?", "Quitar producto Producto");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
                    if (quitarFila(TablaReintegro_Devoluciones, ModeloProductosReintegrados, FilaSeleccionadaReintegro) == true) {
                        int FilaDelProductoAAgregar = DevolverFilaDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoDelProducto);
                        float CantidadRestante = BuscarCantidadRestanteDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoDelProducto);
                        NuevaCantidadaRestante = CantidadRestante + Cantidad;
                        TablaDetalleFacturaDeVenta_Devoluciones.setValueAt(NuevaCantidadaRestante, FilaDelProductoAAgregar, 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de quitar su producto, por favor vuelva intentarlo");
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de quitar su producto, por favor vuelva intentarlo");
            }
        }
    }//GEN-LAST:event_btQuitarReintegro_DevolucionesActionPerformed

    private void btAgegarReintegro_DevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgegarReintegro_DevolucionesActionPerformed
        // TODO add your handling code here:
          String CodigoDelProducto = "";
        String NombreDelProducto = "";
        float Cantidad = 0;
        float CantidadMaxima = 0;

        if (SeleccionDetalleFactura == false) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Primero seleccione el producto que quiera agregar a desechados");

        } else {
            CodigoDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 0).toString();
            if (BuscarSiExisteUnProductoEnUnaTablaDeterminada(TablaReintegro_Devoluciones, CodigoDelProducto) == true) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Ya tiene este producto agregado para reintegrar.\n"
                        + "Si desea hacer un cambio, dirijase al producto y con un doble clic en el podrá editarlo.");
            } else {
                if (DetalleProductoReintegrados.isVisible() == true) {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "ya tiene una ventana de productos desechados abierta.");
                    DetalleProductoReintegrados.toFront();
                } else {
                    try {
                        CodigoDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 0).toString();
                        NombreDelProducto = TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 1).toString();
                        Cantidad = Float.parseFloat(TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 2).toString());
                        CantidadMaxima = Float.parseFloat(TablaDetalleFacturaDeVenta_Devoluciones.getValueAt(FilaSeleccionadaDetalleFactura, 3).toString());
                    } catch (Exception e) {
                    }
                    try {
                        String NumeroFactura = txtNFactura_IngresarDevoluciones.getText();
                        DetalleProductoReintegrados = new DetalleProductoReintegrados(NumeroFactura, CodigoDelProducto, NombreDelProducto, Cantidad, CantidadMaxima);
                        DetalleProductoReintegrados.setVisible(true);
                    } catch (Exception ex) {
                    }
                }//fin else si esta abierto el jframe

            }//fin else si exite el producto
        }//fin else seleccion factura
    }//GEN-LAST:event_btAgegarReintegro_DevolucionesActionPerformed

    private void TablaReintegro_DevolucionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesKeyPressed

    }//GEN-LAST:event_TablaReintegro_DevolucionesKeyPressed

    private void TablaReintegro_DevolucionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesKeyTyped

    }//GEN-LAST:event_TablaReintegro_DevolucionesKeyTyped

    private void TablaReintegro_DevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesMouseClicked
        // TODO add your handling code here:
        String NombreProducto = "";
        String CodigoProducto = "";
        float CantidadIngresada = 0;
        float CantidadActual = 0;
        float CantidadAModificar = 0;
        float DiferenciaEntreCantidades = 0;
        float CantidadMaximaParaEditar = 0;
        float CantidadRestante = 0;
        int FilaSeleccionada = TablaReintegro_Devoluciones.getSelectedRow();
        NombreProducto = TablaReintegro_Devoluciones.getValueAt(FilaSeleccionada, 1).toString();
        CodigoProducto = TablaReintegro_Devoluciones.getValueAt(FilaSeleccionada, 0).toString();
        CantidadActual = Float.parseFloat(TablaReintegro_Devoluciones.getValueAt(FilaSeleccionada, 2).toString());
        CantidadRestante = BuscarCantidadRestanteDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoProducto);
        CantidadMaximaParaEditar = CantidadActual + CantidadRestante;
        
        if(evt.getButton()==MouseEvent.BUTTON3){
        FilaSeleccionadaReintegro = TablaReintegro_Devoluciones.getSelectedRow();
        }else 
        if (evt.getClickCount() == 2) {
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿esta seguro que desea editar a: " + NombreProducto + "?", "Editar Producto");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
                try {
                    CantidadIngresada = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad que desea actualizar"
                            + "\nRecuerde que la cantidad máxima para ingresar es: " + CantidadMaximaParaEditar + "            "));

                    if (CantidadIngresada > CantidadMaximaParaEditar || CantidadIngresada == 0 || CantidadActual == CantidadIngresada) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Ingreso una cantidad mayor, igual o no permitida", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (CantidadIngresada > CantidadActual) {
                            DiferenciaEntreCantidades = CantidadIngresada - CantidadActual;
                            CantidadAModificar = CantidadRestante - DiferenciaEntreCantidades;

                        } else {
                            DiferenciaEntreCantidades = CantidadActual - CantidadIngresada;
                            CantidadAModificar = CantidadRestante + DiferenciaEntreCantidades;
                        }
                        TablaReintegro_Devoluciones.setValueAt(CantidadIngresada, FilaSeleccionada, 2);
                        TablaDetalleFacturaDeVenta_Devoluciones.setValueAt(CantidadAModificar, DevolverFilaDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoProducto), 3);
                    }
                } catch (Exception e) {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo se puede ingresar números", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                return;
            }
        }//fin else doble clicke
        
    }//GEN-LAST:event_TablaReintegro_DevolucionesMouseClicked

    private void TablaProductosDesechados_DevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosDesechados_DevolucionesMouseClicked
        // TODO add your handling code here:
        String NombreProducto = "";
        String CodigoProducto = "";
        float CantidadIngresada = 0;
        float CantidadActual = 0;
        float CantidadAModificar = 0;
        float DiferenciaEntreCantidades = 0;
        float CantidadMaximaParaEditar = 0;
        float CantidadRestante = 0;
        int FilaSeleccionada = TablaProductosDesechados_Devoluciones.getSelectedRow();
        NombreProducto = TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionada, 1).toString();
        CodigoProducto = TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionada, 0).toString();
        CantidadActual = Float.parseFloat(TablaProductosDesechados_Devoluciones.getValueAt(FilaSeleccionada, 2).toString());
        CantidadRestante = BuscarCantidadRestanteDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoProducto);
        CantidadMaximaParaEditar = CantidadActual + CantidadRestante;

        if (evt.getClickCount() == 2) {
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿esta seguro que desea editar a: " + NombreProducto + "?", "Editar Producto");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
                try {
                    CantidadIngresada = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad que desea actualizar"
                            + "\nRecuerde que la cantidad máxima para ingresar es: " + CantidadMaximaParaEditar + "        "));

                    if (CantidadIngresada > CantidadMaximaParaEditar || CantidadIngresada == 0 || CantidadActual == CantidadIngresada) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Ingreso una cantidad mayor, igual o no permitida", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (CantidadIngresada > CantidadActual) {
                            DiferenciaEntreCantidades = CantidadIngresada - CantidadActual;
                            CantidadAModificar = CantidadRestante - DiferenciaEntreCantidades;

                        } else {
                            DiferenciaEntreCantidades = CantidadActual - CantidadIngresada;
                            CantidadAModificar = CantidadRestante + DiferenciaEntreCantidades;
                        }
                        TablaProductosDesechados_Devoluciones.setValueAt(CantidadIngresada, FilaSeleccionada, 2);
                        TablaDetalleFacturaDeVenta_Devoluciones.setValueAt(CantidadAModificar, DevolverFilaDeUnProducto(TablaDetalleFacturaDeVenta_Devoluciones, CodigoProducto), 3);

                    }

                } catch (Exception e) {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo se puede ingresar números", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                return;
            }
        }//fin else doble click
        else if(evt.getButton()==MouseEvent.BUTTON3){
          FilaSeleccionadaDesechado = TablaProductosDesechados_Devoluciones.getSelectedRow();}
    }//GEN-LAST:event_TablaProductosDesechados_DevolucionesMouseClicked

    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;

    }

    ;
    
    
    public boolean quitarFila(JTable TablaAEliminar, DefaultTableModel modelo, int FilaSeleccionada) {

        boolean exito = false;
        try {
            modelo = (DefaultTableModel) TablaAEliminar.getModel();
            modelo.removeRow(TablaAEliminar.getSelectedRow());
            exito = true;

        } catch (Exception e) {

            exito = false;
        }
        return exito;
    }

    private void AgregarProductosAReintegro(String CodigoProducto, String NombreProducto, int Cantidad)
            throws SQLException// metodo para mostrar la tabla co un parametro que tendra el resultado de la peticion
    {
        ModeloProductosReintegrados.setColumnIdentifiers(new Object[]{"Codigo Producto", "Nombre Producto", "Cantidad Reintegrada"});
        TablaReintegro_Devoluciones.setModel(ModeloProductosReintegrados);

        try {

            ModeloProductosReintegrados.addRow(new Object[]{CodigoProducto, NombreProducto, Cantidad});

        } catch (Exception e) {
        }
    }

    private void AgregarProductosADetalleFactura(String CodigoProducto, String NombreProducto, int Cantidad)
            throws SQLException// metodo para mostrar la tabla co un parametro que tendra el resultado de la peticion
    {
        ModeloDetalleProductos.setColumnIdentifiers(new Object[]{"Codigo Producto", "Nombre Producto", "Cantidad"});
        TablaDetalleFacturaDeVenta_Devoluciones.setModel(ModeloDetalleProductos);

        try {

            ModeloDetalleProductos.addRow(new Object[]{CodigoProducto, NombreProducto, Cantidad});

        } catch (Exception e) {
        }
    }

    private void AgregarProductosADesecho(String CodigoProducto, String NombreProducto, int Cantidad)
            throws SQLException// metodo para mostrar la tabla co un parametro que tendra el resultado de la peticion
    {
        ModeloProductosDesechados.setColumnIdentifiers(new Object[]{"Codigo Producto", "Nombre Producto", "Cantidad Desechada"});
        TablaProductosDesechados_Devoluciones.setModel(ModeloProductosDesechados);

        try {

            ModeloProductosDesechados.addRow(new Object[]{CodigoProducto, NombreProducto, Cantidad});

        } catch (Exception e) {
        }

    }

    public void LimpiarTablas(JTable TablaALimpiar, DefaultTableModel ModeloALimpiar) {

        for (int contador = 0; contador < TablaALimpiar.getRowCount(); contador++) {
            ModeloALimpiar.removeRow(contador);
            contador -= 1;
        }

    }

    private boolean BuscarSiExisteUnProductoEnUnaTablaDeterminada(JTable TablaABuscar, String CodigoProductoABuscar) {
        boolean ExisteProducto = false;
        String CodigoProductoEnLaTabla = "";
        for (int contador = 0; contador < TablaABuscar.getRowCount(); contador++) {
            CodigoProductoEnLaTabla = TablaABuscar.getValueAt(contador, 0).toString();
            if (CodigoProductoEnLaTabla.equals(CodigoProductoABuscar)) {
                ExisteProducto = true;
            }
        }
        return ExisteProducto;
    }

    private float BuscarCantidadRestanteDeUnProducto(JTable TablaABuscar, String CodigoProductoABuscar) {
        float CantidadRestante = 0;
        String CodigoProductoEnLaTabla = "";
        for (int contador = 0; contador < TablaABuscar.getRowCount(); contador++) {
            CodigoProductoEnLaTabla = TablaABuscar.getValueAt(contador, 0).toString();
            if (CodigoProductoEnLaTabla.equals(CodigoProductoABuscar)) {
                CantidadRestante = Float.parseFloat(TablaABuscar.getValueAt(contador, 3).toString());

            }
        }
        return CantidadRestante;
    }

    private int DevolverFilaDeUnProducto(JTable TablaABuscar, String CodigoProductoABuscar) {
        int Fila = 0;
        String CodigoProductoEnLaTabla = "";
        for (int contador = 0; contador < TablaABuscar.getRowCount(); contador++) {
            CodigoProductoEnLaTabla = TablaABuscar.getValueAt(contador, 0).toString();
            if (CodigoProductoEnLaTabla.equals(CodigoProductoABuscar)) {
                Fila = contador;

            }
        }
        return Fila;
    }

    private int DevolverIdUsuarioActivo() {
        int IdDelUsuarioActivo = 0;
        CoordinadorDeUsuarios ElUsuarioActivo = new CoordinadorDeUsuarios();
        try {
            IdDelUsuarioActivo = ElUsuarioActivo.DevolverIdUsuarioActivo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando idusuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return IdDelUsuarioActivo;
    }

    private int DevolverIdDevolucionPOrcodigoFactura(String NumeroFactura) {
        int IdDevolucionBuscada = 0;
        CoordinadorDeDevoluciones LaDevolucion = new CoordinadorDeDevoluciones();
        try {
            IdDevolucionBuscada = LaDevolucion.DevolverIdDevolucion(NumeroFactura);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando iddevolucion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return IdDevolucionBuscada;
    }

    private float DevolverPrecioDeUnProducto(String CodigoProducto) {
        float ElPrecioDelProductoBuscado = 0;
        CoordinadorDeInventario ElProductoBuscado = new CoordinadorDeInventario();
        try {
            ElPrecioDelProductoBuscado = ElProductoBuscado.DevolverPrecio(CodigoProducto);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando el precio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ElPrecioDelProductoBuscado;
    }

    private boolean VerificarQueAlMenosUnaTablaNoEsteVacia() {
        boolean LasTablasEstanVacias;
        if (TablaReintegro_Devoluciones.getRowCount() == 0 && TablaProductosDesechados_Devoluciones.getRowCount() == 0) {
            LasTablasEstanVacias = true;
        } else {
            LasTablasEstanVacias = false;
        }
        return LasTablasEstanVacias;
    }

    private boolean VerificarQueTablaReintegrosNoEstaVacia() {
        boolean LasTablasEstanVacias;
        if (TablaReintegro_Devoluciones.getRowCount() == 0) {
            LasTablasEstanVacias = true;
        } else {
            LasTablasEstanVacias = false;
        }
        return LasTablasEstanVacias;
    }

    private boolean VerificarQueTablaDesechosNoEstaVacia() {
        boolean LasTablasEstanVacias;
        if (TablaProductosDesechados_Devoluciones.getRowCount() == 0) {
            LasTablasEstanVacias = true;
        } else {
            LasTablasEstanVacias = false;
        }
        return LasTablasEstanVacias;
    }

    private float RecolectarElValorTotalDeLaDevoluciónAdemasDelTotalReintegradoAlCliente() {
        float ValorTotalDeLaDevolucion = 0;

        if (VerificarQueTablaDesechosNoEstaVacia() == false) {
            if (VerificarQueTablaReintegrosNoEstaVacia() == false) {
                ValorTotalDeLaDevolucion = RecogerValortotalDeUnaTabla(TablaProductosDesechados_Devoluciones);
                ValorTotalDeLaDevolucion += RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
                ReintegradoAlCliente = RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
               
            } else {
                ValorTotalDeLaDevolucion = RecogerValortotalDeUnaTabla(TablaProductosDesechados_Devoluciones);
                ReintegradoAlCliente=0;
           
            }

        } else if (VerificarQueTablaReintegrosNoEstaVacia() == false) {
            if (VerificarQueTablaDesechosNoEstaVacia() == false) {
                ReintegradoAlCliente = RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
                ValorTotalDeLaDevolucion = RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
                ValorTotalDeLaDevolucion += RecogerValortotalDeUnaTabla(TablaProductosDesechados_Devoluciones);

            } else {
                ValorTotalDeLaDevolucion = RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
                ReintegradoAlCliente = RecogerValortotalDeUnaTabla(TablaReintegro_Devoluciones);
               
            }
        }
        return ValorTotalDeLaDevolucion;
    }

    private float RecogerValortotalDeUnaTabla(JTable TablaARecogerPrecios) {
        float PrecioRecogido = 0;
        float PrecioVenta = 0;
        float Cantidad = 0;
        String CodigoProducto = "";
        for (int Contador = 0; Contador < TablaARecogerPrecios.getRowCount(); Contador++) {
            CodigoProducto = TablaARecogerPrecios.getValueAt(Contador, 0).toString();
            Cantidad = Float.parseFloat(TablaARecogerPrecios.getValueAt(Contador, 2).toString());
            PrecioVenta = DevolverPrecioDeUnProducto(CodigoProducto);
            PrecioRecogido += Cantidad * PrecioVenta;
        }
        return PrecioRecogido;
    }

    private boolean IngresarDetalleDeLaDevolucion(String NumeroFactura) {
        boolean Exito = false;
        int IdDevolucion = DevolverIdDevolucionPOrcodigoFactura(NumeroFactura);
        if (VerificarQueTablaDesechosNoEstaVacia() == false) {
            if (VerificarQueTablaReintegrosNoEstaVacia() == false) {
                Exito = IngresarProductosDesechados(IdDevolucion);
                Exito = IngresarProductosReintegrados(IdDevolucion);
            } else {
                Exito = IngresarProductosDesechados(IdDevolucion);
            }

        } else if (VerificarQueTablaReintegrosNoEstaVacia() == false) {
            if (VerificarQueTablaDesechosNoEstaVacia() == false) {
                Exito = IngresarProductosReintegrados(IdDevolucion);
                Exito = IngresarProductosDesechados(IdDevolucion);
            } else {
                Exito = IngresarProductosReintegrados(IdDevolucion);
            }
        }

        return Exito;
    }

    private boolean IngresarProductosDesechados(int IdDevolucion) {
        ProductosDesechados ElProductoDesechado = new ProductosDesechados();
        boolean Exito = false;
        CoordinadorDeProductosDesechados ElCoordinadorDeProductosDesechados = new CoordinadorDeProductosDesechados();

        for (int Contador = 0; Contador < TablaProductosDesechados_Devoluciones.getRowCount(); Contador++) {

            ElProductoDesechado.setCodigoDelProducto(TablaProductosDesechados_Devoluciones.getValueAt(Contador, 0).toString());
            ElProductoDesechado.setCantidadDesechada(Float.parseFloat(TablaProductosDesechados_Devoluciones.getValueAt(Contador, 2).toString()));
            ElProductoDesechado.setIdDevoluciones(IdDevolucion);
            ElProductoDesechado.setDetalleDesecho(TablaProductosDesechados_Devoluciones.getValueAt(Contador, 3).toString());
            try {
                Exito = ElCoordinadorDeProductosDesechados.IngresarProductosDesechados(ElProductoDesechado);
            } catch (Exception e) {
                Exito = false;
            }
        }
        return Exito;
    }

    private boolean IngresarProductosReintegrados(int IdDevolucion) {
        ProductosReintegrados ElProductosReintegrado = new ProductosReintegrados();
        boolean Exito = false;

        CoordinadorDeProductosReintegrados ElCoordinadorDeProductosReintegrados = new CoordinadorDeProductosReintegrados();

        for (int Contador = 0; Contador < TablaReintegro_Devoluciones.getRowCount(); Contador++) {

            ElProductosReintegrado.setCodigoProducto(TablaReintegro_Devoluciones.getValueAt(Contador, 0).toString());
            ElProductosReintegrado.setCantidadReintegrada(Float.parseFloat(TablaReintegro_Devoluciones.getValueAt(Contador, 2).toString()));
            ElProductosReintegrado.setIdDevoluciones(IdDevolucion);

            try {
                Exito = ElCoordinadorDeProductosReintegrados.AgregarProductoReintegrado(ElProductosReintegrado);
            } catch (Exception e) {
                Exito = false;
                JOptionPane.showMessageDialog(null, "error aqui");
            }
        }
        return Exito;
    }

    private void LimpiarCamposDeLaFactura() {
        txtFechaDeVenta_IngresarDevoluciones.setText("");
        txtMontoDeVenta_IngresarDevoluciones.setText("");
        txtNFactura_IngresarDevoluciones.setText("");
        txtNombreLocal_IngresarDevoluciones.setText("");
        txtNombreUsuario_IngresarDevoluciones.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaDetalleFacturaDeVenta_Devoluciones;
    public static javax.swing.JTable TablaProductosDesechados_Devoluciones;
    public static javax.swing.JTable TablaReintegro_Devoluciones;
    private javax.swing.JButton btAgegarReintegro_Devoluciones;
    private javax.swing.JButton btAgregarDesechados_Devoluciones;
    public static javax.swing.JButton btLimpiar_IngresarDevoluciones;
    private javax.swing.JButton btQuitarDesechado_Devoluciones;
    private javax.swing.JButton btQuitarReintegro_Devoluciones;
    public static javax.swing.JButton btReintegro_IngresarDevoluciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator6;
    public static javax.swing.JTextField txtFechaDeVenta_IngresarDevoluciones;
    public static javax.swing.JTextField txtMontoDeVenta_IngresarDevoluciones;
    public static javax.swing.JTextField txtNFactura_IngresarDevoluciones;
    public static javax.swing.JTextField txtNombreLocal_IngresarDevoluciones;
    public static javax.swing.JTextField txtNombreUsuario_IngresarDevoluciones;
    // End of variables declaration//GEN-END:variables
}
