package UI;

import LogicaDeNegocios.CoordinadorDeRutas;
import static UI.DetallesDeRuta.filas;
//import static UI.GestorDeRutas.modeloVerCamiones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class GestorDeRutas extends javax.swing.JPanel {

    static char c;
    static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    static boolean opcionBusqueda = false;
    static boolean opcionFiltro = false;
    static DefaultTableModel modeloRutas;
    static DefaultTableModel modeloVerClientes, modeloVerCamiones;
    public static TableRowSorter trsFiltro;
    static ResultSet resultadoConsulta;

    public GestorDeRutas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Asignacion = new javax.swing.JMenuItem();
        MostrarInformacion = new javax.swing.JMenuItem();
        EliminarRuta = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableListarRutas_GestorDeRutas = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        AgregarRuta = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        BuscarRuta = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();

        Asignacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Asignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        Asignacion.setText("Asignaciones de Ruta");
        Asignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignacionActionPerformed(evt);
            }
        });
        Menu.add(Asignacion);

        MostrarInformacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        MostrarInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RutaInformacion.png"))); // NOI18N
        MostrarInformacion.setText("Mostrar detalles de ruta");
        MostrarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarInformacionActionPerformed(evt);
            }
        });
        Menu.add(MostrarInformacion);

        EliminarRuta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        EliminarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        EliminarRuta.setText("Eliminar ruta");
        EliminarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarRutaActionPerformed(evt);
            }
        });
        Menu.add(EliminarRuta);

        TableListarRutas_GestorDeRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableListarRutas_GestorDeRutas.setComponentPopupMenu(Menu);
        TableListarRutas_GestorDeRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableListarRutas_GestorDeRutasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableListarRutas_GestorDeRutas);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Rutas");

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setAlignmentX(5.0F);

        AgregarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InsertarRuta.png"))); // NOI18N
        AgregarRuta.setToolTipText("Oprima para cancelar");
        AgregarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarRutaActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 112));
        jLabel51.setText("Ingresar Ruta");

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setAlignmentX(5.0F);

        BuscarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        BuscarRuta.setToolTipText("Oprima para cancelar");
        BuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarRutaActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 112));
        jLabel53.setText("Buscar Rutas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel51))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(BuscarRuta)
                                .addGap(174, 174, 174)
                                .addComponent(AgregarRuta)))
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(BuscarRuta))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgregarRuta))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel52)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public static void VisualizarRutasActivas() throws ClassNotFoundException {
        try {

            DefaultTableModel modeloV = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloV.addColumn("N°Ruta");
            modeloV.addColumn("Nombre");
            modeloV.addColumn("Descripción");

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarRutasActivas();

            filas = new Object[modeloV.getColumnCount()];
            TableListarRutas_GestorDeRutas.setModel(modeloV);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modeloV.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modeloV.addRow(filas);
                TableListarRutas_GestorDeRutas.setModel(modeloV);
            }
        } catch (SQLException ex) {

        }
    }

    public void eliminarRutas(int id) throws ClassNotFoundException, SQLException {
        Icon icono = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));

        String Ruta = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        int dialogResult = JOptionPane.showConfirmDialog(null,"<html><h4>¿ Desea elimar la ruta: " + Ruta + "?</h4></html>", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono);

        if (dialogResult == JOptionPane.YES_OPTION) {

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet respuesta;
            respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
            if (respuesta.next()) {
                if (respuesta.getString(1).equals("2")) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");

                    VisualizarRutasActivas();

                } else {
                    JOptionPane.showMessageDialog(null, "Error en la eliminación");
                }
            }
        }
    }
        public static void InicializarFiltroClientes(JTable Listar) {
        modeloVerClientes = new DefaultTableModel() {

            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloVerClientes.addColumn("Nombre de local");
        modeloVerClientes.addColumn("Cedula");
        modeloVerClientes.addColumn("Dirección");
        filas = new Object[modeloVerClientes.getColumnCount()];
        Listar.setModel(modeloVerClientes);
    }

    public static void InicializarFiltroCamiones(JTable Listar) {
        modeloVerCamiones = new DefaultTableModel() {

            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloVerCamiones.addColumn("N° Placa");
        modeloVerCamiones.addColumn("Marca");
        modeloVerCamiones.addColumn("Estilo");
        modeloVerCamiones.addColumn("Modelo");
        filas = new Object[modeloVerCamiones.getColumnCount()];
        Listar.setModel(modeloVerCamiones);
    }
//     public static void filtro() {
//        int columnaABuscar = 0;
//        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "N°Ruta") {
//            opcionBusqueda = true;
//            columnaABuscar = 0;
//        }
//        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "Nombre") {
//            opcionBusqueda = false;
//            columnaABuscar = 1;
//        }
//
//        trsFiltro.setRowFilter(RowFilter.regexFilter(txtBuscarRuta_GestorDeRuta.getText(), columnaABuscar));
//    }
//     public void activarRutas(int id) throws ClassNotFoundException, SQLException {
//        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
//        ResultSet respuesta;
//        respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
//        if (respuesta.next()) {
//            if (respuesta.getString(1).equals("2")) {
//                JOptionPane.showMessageDialog(null, "Activacion exitosa");
//                VisualizarRutas();
//                VisualizarTodasLasRutas();
//                txtBuscarRuta_GestorDeRuta.setText("");
//            } else {
//                JOptionPane.showMessageDialog(null, "Error en la activacion");
//            }
//        }
//    }
//      public static void BuscarRuta() {
//
//         txtBuscarRuta_GestorDeRuta.addKeyListener(new KeyAdapter() {
//            public void keyReleased(final KeyEvent e) {
//                String cadena = (txtBuscarRuta_GestorDeRuta.getText());
//                txtBuscarRuta_GestorDeRuta.setText(cadena);
//
//                filtro();
//ListarClientesPorBusqueda();
// ListarCamionesPorBusqueda();
//              
//            }
//        });
//        trsFiltro = new TableRowSorter(TableBuscarRutas_GestorDeRutas.getModel());
//        TableBuscarRutas_GestorDeRutas.setRowSorter(trsFiltro);
//    }
//public static void VisualizarTodasLasRutas() {
//        try {
//
//            DefaultTableModel modeloV = new DefaultTableModel() {
//
//                public boolean isCellEditable(int fila, int columna) {
//                    return false;
//                }
//            };
//            modeloV.addColumn("N°Ruta");
//            modeloV.addColumn("Nombre");
//            modeloV.addColumn("Descripción");
//            modeloV.addColumn("Estado");
//
//            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
//            ResultSet resultadoConsulta = elCoordinador.ListarTodasLasRutas();
//
//            filas = new Object[modeloV.getColumnCount()];
//            TableBuscarRutas_GestorDeRutas.setModel(modeloV);
//            if (resultadoConsulta == null) {
//                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
//                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            while (resultadoConsulta.next()) {
//                for (int i = 0; i < modeloV.getColumnCount(); i++) {
//
//                    if ((i + 1) == 4) {
//                        if (resultadoConsulta.getBoolean(i + 1) == true) {
//                            filas[i] = "Activo";
//
//                        } else {
//                            filas[i] = "Inactivo";
//                        }
//                    } else {
//                        filas[i] = resultadoConsulta.getObject(i + 1);
//                    }
//
//                }
//                modeloV.addRow(filas);
//                TableBuscarRutas_GestorDeRutas.setModel(modeloV);
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//
//        }
//    }
//  public void LimpiarCampos() {
//        txtNombreRuta_GestorRuta.setText("");
//
//    }

    
//     

//    public static void ListarCamionesPorBusqueda() {
//        try {
//            InicializarFiltroCamiones(TableListarBuscarCamiones);
//
//            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
//            if (txtBuscarRuta_GestorDeRuta.getText().equals("")) {
//                return;
//            } else {
//                if (opcionBusqueda == false) {
//                    resultadoConsulta = elCoordinador.ListarCamionesRutasPorNombre(txtBuscarRuta_GestorDeRuta.getText());
//                } else if (opcionBusqueda == true) {
//                    resultadoConsulta = elCoordinador.ListarCamionesRutasPorId(Integer.parseInt(txtBuscarRuta_GestorDeRuta.getText()));
//                }
//            }
//
//            if (resultadoConsulta == null) {
//                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
//                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            while (resultadoConsulta.next()) {
//               
//                for (int i = 0; i < modeloVerCamiones.getColumnCount(); i++) {
//
//                    filas[i] = resultadoConsulta.getObject(i + 1);
//
//                }
//                modeloVerCamiones.addRow(filas);
//                TableListarBuscarCamiones.setModel(modeloVerCamiones);
//
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//
//        }
//    }
//       public static void InicailaizarTablaRutas() {
//
//        modeloRutas = new DefaultTableModel() {
//
//            public boolean isCellEditable(int fila, int columna) {
//                return false;
//            }
//        };
//        modeloRutas.addColumn("N°Ruta");
//        modeloRutas.addColumn("Nombre");
//        modeloRutas.addColumn("Descripción");
//        TableBuscarRutas_GestorDeRutas.setModel(modeloRutas);
//
//    }

    private void TableListarRutas_GestorDeRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListarRutas_GestorDeRutasMousePressed
        FilaSeleccionadaParaEliminar = TableListarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TableListarRutas_GestorDeRutasMousePressed

    private void AgregarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarRutaActionPerformed
        IngresarRutas ingresoRuta = new IngresarRutas(null, true);
        ingresoRuta.setVisible(true);
    }//GEN-LAST:event_AgregarRutaActionPerformed

    private void BuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarRutaActionPerformed
BuscarRutas laRuta = new BuscarRutas(null,true);
laRuta.setVisible(true);
    }//GEN-LAST:event_BuscarRutaActionPerformed

    private void EliminarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarRutaActionPerformed
        int RutaEliminar = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        try {
            eliminarRutas(RutaEliminar);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EliminarRutaActionPerformed

    private void AsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignacionActionPerformed
     int id=(int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar,0);
     String Nombre=TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar,1).toString();
        AsignacionesDeRuta laAsignacion= new  AsignacionesDeRuta(null,true, id,  Nombre);
        laAsignacion.setVisible(true);
    }//GEN-LAST:event_AsignacionActionPerformed

    private void MostrarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarInformacionActionPerformed
       int id=(int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar,0);
        String Nombre=TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar,1).toString();
        DetallesDeRuta losDetalles= new  DetallesDeRuta(null,true, id,  Nombre);
        losDetalles.setVisible(true);
    }//GEN-LAST:event_MostrarInformacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton AgregarRuta;
    private javax.swing.JMenuItem Asignacion;
    public static javax.swing.JButton BuscarRuta;
    private javax.swing.JMenuItem EliminarRuta;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JMenuItem MostrarInformacion;
    public static javax.swing.JTable TableListarRutas_GestorDeRutas;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    // End of variables declaration//GEN-END:variables
}
