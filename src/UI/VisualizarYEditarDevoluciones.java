
package UI;

import LogicaDeNegocios.IMPRIMIR;
import static UI.IngresarCarga.CantidadDeFilas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VisualizarYEditarDevoluciones extends javax.swing.JPanel {
    static String txt="";

    BuscarFacturasDeVentaQueTieneDevoluciones ElBuscarFacturasDeVentaQueTieneDevoluciones = new BuscarFacturasDeVentaQueTieneDevoluciones();
    public static DefaultTableModel ModeloProductosReintegradosVisualizar = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    public static DefaultTableModel ModeloProductosDesechadosVisualizar = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    public static DefaultTableModel ModeloDetalleProductosVisualizar = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public VisualizarYEditarDevoluciones() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNFactura_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaDeVenta_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMontoDeVenta_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreUsuario_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtNombreLocal_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFechaDevolucion_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMontoReintegrado_VisualizarDevoluciones = new javax.swing.JTextField();
        txtMontoDevolucion_VisualizarDevoluciones = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaProductosDesechados_VisualizarDevoluciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaReintegro_Devoluciones = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleFacturaDeVenta_VisualizarDevoluciones = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Imprimir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1260, 690));

        btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search_Icon_16.png"))); // NOI18N
        btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones.setText("Seleccionar Factura");
        btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarFacturaDeVentaConDevolucion_EditarDevolucionesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Número de Factura: ");

        txtNFactura_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNFactura_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtNFactura_VisualizarDevoluciones.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Fecha Venta: ");

        txtFechaDeVenta_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtFechaDeVenta_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtFechaDeVenta_VisualizarDevoluciones.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Monto de la venta: ");

        txtMontoDeVenta_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDeVenta_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtMontoDeVenta_VisualizarDevoluciones.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nombre Usuario: ");

        txtNombreUsuario_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreUsuario_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtNombreUsuario_VisualizarDevoluciones.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 3, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 112));
        jLabel44.setText("Visualizar Devoluciones");

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setAlignmentX(5.0F);

        txtNombreLocal_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreLocal_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 102));
        txtNombreLocal_VisualizarDevoluciones.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setText("Nombre del local: ");

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 112));
        jLabel1.setText("Primero seleccione la factura de venta que desea visualizar su devolución");
        jLabel1.setPreferredSize(new java.awt.Dimension(1260, 22));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Devolución: ");

        txtFechaDevolucion_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtFechaDevolucion_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtFechaDevolucion_VisualizarDevoluciones.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Monto Reintegrado: ");

        txtMontoReintegrado_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoReintegrado_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 112));
        txtMontoReintegrado_VisualizarDevoluciones.setEnabled(false);

        txtMontoDevolucion_VisualizarDevoluciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDevolucion_VisualizarDevoluciones.setForeground(new java.awt.Color(0, 102, 102));
        txtMontoDevolucion_VisualizarDevoluciones.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setText("Monto Devolucion: ");

        TablaProductosDesechados_VisualizarDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Cantidad Desechada", "Detalle"
            }
        ));
        TablaProductosDesechados_VisualizarDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosDesechados_VisualizarDevolucionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaProductosDesechados_VisualizarDevolucionesMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TablaProductosDesechados_VisualizarDevoluciones);

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

        TablaDetalleFacturaDeVenta_VisualizarDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Producto", "Nombre Producto", "Cantidad Vendida"
            }
        ));
        TablaDetalleFacturaDeVenta_VisualizarDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDetalleFacturaDeVenta_VisualizarDevolucionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDetalleFacturaDeVenta_VisualizarDevoluciones);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 112));
        jLabel8.setText("Productos Reintegrados");

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 112));
        jLabel9.setText("Lista de productos vendidos");

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 112));
        jLabel10.setText("Productos Desechados");

        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printer_78349.png"))); // NOI18N
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones)
                        .addGap(171, 171, 171))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331)
                        .addComponent(jLabel44)
                        .addContainerGap(401, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNFactura_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMontoDeVenta_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMontoDevolucion_VisualizarDevoluciones)
                            .addComponent(txtMontoReintegrado_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreLocal_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaDevolucion_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaDeVenta_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaDeVenta_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaDevolucion_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44)
                            .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtNFactura_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtMontoDeVenta_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel42)
                                        .addComponent(txtNombreLocal_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtNombreUsuario_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtMontoDevolucion_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMontoReintegrado_VisualizarDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel43)
                                    .addGap(29, 29, 29))))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void imprimir(){

                                       txt = "      FACTURA DE DEVOLUCION\n"
                                    + "N.Fac:" + txtNFactura_VisualizarDevoluciones.getText()
                                    + "\nCli:" + txtNombreLocal_VisualizarDevoluciones.getText()
                                    + "\nUsuario::" + txtNombreUsuario_VisualizarDevoluciones.getText()
                                    + "\nFecha V:" + txtFechaDeVenta_VisualizarDevoluciones.getText()
                                    + "\nMonto de venta:" + txtMontoDeVenta_VisualizarDevoluciones.getText()
                                    
                                    + "\nFecha D: " + txtFechaDevolucion_VisualizarDevoluciones.getText();

                            if (TablaProductosDesechados_VisualizarDevoluciones.getRowCount() != 0) {

                                txt += "\n*Detalle\n\n"
                                        + "      Productos desechados\n"
                                        + "\nCod   Cant     Descr";
                                for (int i = 0; i < TablaProductosDesechados_VisualizarDevoluciones.getRowCount(); i++) {
                                    String codigo = TablaProductosDesechados_VisualizarDevoluciones.getValueAt(i, 0).toString();
                                    String Descripcion = TablaProductosDesechados_VisualizarDevoluciones.getValueAt(i, 1).toString();
                                    float Cantidad = Float.parseFloat(TablaProductosDesechados_VisualizarDevoluciones.getValueAt(i, 2).toString());
                                    String Detalle = TablaProductosDesechados_VisualizarDevoluciones.getValueAt(i, 3).toString();

                                    String des = "";
                                    if (Descripcion.length() >= 10) {

                                        des = Descripcion.replaceAll(" ", "");
                                        des = des.substring(0, 10);
                                    } else {

                                        des = String.format("%1$-10s", Descripcion);

                                    }

                                    txt += "\n" + codigo + "    " + Cantidad + "      " + Descripcion;

                                    txt += "\n*" + Detalle;
                                }
                                 
                            }
                            if (TablaReintegro_Devoluciones.getRowCount() != 0) {

                                txt += "\n\n      Productos Reintegrados\n"
                                        +"\nCod   Cant     Descr";
                                for (int i = 0; i < TablaReintegro_Devoluciones.getRowCount(); i++) {
                                    String codigo = TablaReintegro_Devoluciones.getValueAt(i, 0).toString();
                                    String Descripcion = TablaReintegro_Devoluciones.getValueAt(i, 1).toString();
                                    float Cantidad = Float.parseFloat(TablaReintegro_Devoluciones.getValueAt(i, 2).toString());

                                    String des = "";
                                    if (Descripcion.length() >= 10) {

                                        des = Descripcion.replaceAll(" ", "");
                                        des = des.substring(0, 10);
                                    } else {

                                        des = String.format("%1$-10s", Descripcion);

                                    }

                                    txt += "\n" + codigo + "    " + Cantidad + "      " + Descripcion;

                                }
                            }
                                   txt+= "\n\n------*---------------*---------"+
                                    "\nTotal de devolucion:"+txtMontoDevolucion_VisualizarDevoluciones.getText()
                                    +"\nTotal de  reintegro:"+txtMontoReintegrado_VisualizarDevoluciones.getText()
                                    +"\nTotal de desecho:"+txtMontoDevolucion_VisualizarDevoluciones.getText()
                                    + "\n\n------------Fin--------------";
                            IMPRIMIR imprimir = new IMPRIMIR(txt, CantidadDeFilas(txt), txt.length());
}
    private void btBuscarFacturaDeVentaConDevolucion_EditarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarFacturaDeVentaConDevolucion_EditarDevolucionesActionPerformed

        if (ElBuscarFacturasDeVentaQueTieneDevoluciones.isVisible() == true) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ya tiene una ventana de buscar factura que tiene devolucion abierta.");
            ElBuscarFacturasDeVentaQueTieneDevoluciones.toFront();
        } else {
            ElBuscarFacturasDeVentaQueTieneDevoluciones.setVisible(true);
        }

    }//GEN-LAST:event_btBuscarFacturaDeVentaConDevolucion_EditarDevolucionesActionPerformed

    private void TablaProductosDesechados_VisualizarDevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosDesechados_VisualizarDevolucionesMouseClicked

    }//GEN-LAST:event_TablaProductosDesechados_VisualizarDevolucionesMouseClicked

    private void TablaProductosDesechados_VisualizarDevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosDesechados_VisualizarDevolucionesMousePressed

    }//GEN-LAST:event_TablaProductosDesechados_VisualizarDevolucionesMousePressed

    private void TablaReintegro_DevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesMouseClicked

    }//GEN-LAST:event_TablaReintegro_DevolucionesMouseClicked

    private void TablaReintegro_DevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesMousePressed

    }//GEN-LAST:event_TablaReintegro_DevolucionesMousePressed

    private void TablaReintegro_DevolucionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesKeyPressed

    }//GEN-LAST:event_TablaReintegro_DevolucionesKeyPressed

    private void TablaReintegro_DevolucionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaReintegro_DevolucionesKeyTyped

    }//GEN-LAST:event_TablaReintegro_DevolucionesKeyTyped

    private void TablaDetalleFacturaDeVenta_VisualizarDevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleFacturaDeVenta_VisualizarDevolucionesMousePressed

    }//GEN-LAST:event_TablaDetalleFacturaDeVenta_VisualizarDevolucionesMousePressed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_ImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Imprimir;
    public static javax.swing.JTable TablaDetalleFacturaDeVenta_VisualizarDevoluciones;
    public static javax.swing.JTable TablaProductosDesechados_VisualizarDevoluciones;
    public static javax.swing.JTable TablaReintegro_Devoluciones;
    public javax.swing.JButton btBuscarFacturaDeVentaConDevolucion_EditarDevoluciones;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel42;
    public javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JSeparator jSeparator6;
    public static javax.swing.JTextField txtFechaDeVenta_VisualizarDevoluciones;
    public static javax.swing.JTextField txtFechaDevolucion_VisualizarDevoluciones;
    public static javax.swing.JTextField txtMontoDeVenta_VisualizarDevoluciones;
    public static javax.swing.JTextField txtMontoDevolucion_VisualizarDevoluciones;
    public static javax.swing.JTextField txtMontoReintegrado_VisualizarDevoluciones;
    public static javax.swing.JTextField txtNFactura_VisualizarDevoluciones;
    public static javax.swing.JTextField txtNombreLocal_VisualizarDevoluciones;
    public static javax.swing.JTextField txtNombreUsuario_VisualizarDevoluciones;
    // End of variables declaration//GEN-END:variables
}
