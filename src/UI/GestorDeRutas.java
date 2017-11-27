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

    static boolean estado = false;

    public GestorDeRutas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Asignacion = new javax.swing.JMenuItem();
        EliminarRuta = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableListarRutas_GestorDeRutas = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        AgregarRuta = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        BuscarRuta = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDetallesRuta = new javax.swing.JTable();
        NombreRuta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Asignacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Asignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        Asignacion.setText("Asignaciones de ruta");
        Asignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignacionActionPerformed(evt);
            }
        });
        Menu.add(Asignacion);

        EliminarRuta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        EliminarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        EliminarRuta.setText("Eliminar ruta");
        EliminarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarRutaActionPerformed(evt);
            }
        });
        Menu.add(EliminarRuta);

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EditIcon.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.setActionCommand("");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Menu.add(Editar);

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DeleteIcon.png"))); // NOI18N
        Eliminar.setText("Eliminar cliente de la ruta");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        MenuClientes.add(Eliminar);

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

        TablaDetallesRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaDetallesRuta.setComponentPopupMenu(MenuClientes);
        TablaDetallesRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDetallesRutaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TablaDetallesRuta);

        NombreRuta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NombreRuta.setText("  ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Clientes asignados a la ruta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NombreRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreRuta)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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
        int dialogResult = JOptionPane.showConfirmDialog(null, "<html><h4>¿ Desea elimar la ruta: " + Ruta + "?</h4></html>", "Confirmar eliminación",
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
        modeloVerClientes.addColumn("Dia de asignacion");
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
        modeloVerCamiones.addColumn("Dia de asignacion");
        modeloVerCamiones.addColumn("Modelo");

        filas = new Object[modeloVerCamiones.getColumnCount()];
        Listar.setModel(modeloVerCamiones);
    }


    private void TableListarRutas_GestorDeRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListarRutas_GestorDeRutasMousePressed
        FilaSeleccionadaParaEliminar = TableListarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;
        try {
            NombreRuta.setText(TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString());
            ListarClientesPorBusqueda((int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TableListarRutas_GestorDeRutasMousePressed

    private void AgregarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarRutaActionPerformed
        IngresarRutas ingresoRuta = new IngresarRutas(null, true);
        ingresoRuta.setVisible(true);
    }//GEN-LAST:event_AgregarRutaActionPerformed

    private void BuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarRutaActionPerformed
        BuscarRutas laRuta = new BuscarRutas(null, true);
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
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String Nombre = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        AsignacionesDeRuta laAsignacion = new AsignacionesDeRuta(null, true, id, Nombre);
        laAsignacion.setVisible(true);
    }//GEN-LAST:event_AsignacionActionPerformed
    public void editar() {
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String Nombre = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String Detalle = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        EditarRutas editar = new EditarRutas(null, true, id, Nombre, Detalle);
        editar.setVisible(true);
    }
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        editar();
    }//GEN-LAST:event_EditarActionPerformed

    private void TablaDetallesRutaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetallesRutaMousePressed
        FilaSeleccionadaParaEliminar = TablaDetallesRuta.getSelectedRow();
        SeleccionDeFila = true;

    }//GEN-LAST:event_TablaDetallesRutaMousePressed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(TableListarRutas_GestorDeRutas.getSelectedRow(), 0);
        try {
            elimiarClienteDeRuta(id);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }//GEN-LAST:event_EliminarActionPerformed

//**************************************************************************//
    public static void ListarClientesPorBusqueda(int id) throws ClassNotFoundException {
        try {
            modeloVerClientes = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloVerClientes.addColumn("Codigo");
            modeloVerClientes.addColumn("Nombre de local");
            modeloVerClientes.addColumn("Cedula");
            modeloVerClientes.addColumn("Nombre del Cliente");
            modeloVerClientes.addColumn("Razón Social");
            modeloVerClientes.addColumn("Dirección");
            modeloVerClientes.addColumn("Dia de visita");
            filas = new Object[modeloVerClientes.getColumnCount()];

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();

            resultadoConsulta = elCoordinador.ListarClientesRutasPorId(id);

            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {

                for (int i = 0; i < modeloVerClientes.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modeloVerClientes.addRow(filas);

            }
            TablaDetallesRuta.setModel(modeloVerClientes);
        } catch (SQLException ex) {

        }
    }

    public int obtenerDia(String NombreDia) {
        int dia = 0;
        if (NombreDia.equals("Domingo")) {
            dia = 1;
        }if (NombreDia.equals("Lunes")) {
            dia = 2;
        }if (NombreDia.equals("Martes")) {
            dia = 3;
        }
        if (NombreDia.equals("Miercoles")) {
            dia = 4;
        }
        if (NombreDia.equals("Jueves")) {
            dia = 5;
        }
        if (NombreDia.equals("Viernes")) {
            dia = 6;
        }if (NombreDia.equals("Sabado")) {
            dia = 7;
        }
        return dia;
    }

    public void elimiarClienteDeRuta(int idR) throws SQLException, ClassNotFoundException {

        Icon icono = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));

        String cedula = TablaDetallesRuta.getValueAt(TablaDetallesRuta.getSelectedRow(), 2).toString();
        String dia = TablaDetallesRuta.getValueAt(TablaDetallesRuta.getSelectedRow(), 6).toString();
        int dialogResult = JOptionPane.showConfirmDialog(null, "<html><h4>¿ Desea elimar el cliente? </h4></html>", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono);
     
        if (dialogResult == JOptionPane.YES_OPTION) {

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet respuesta;
            respuesta = elCoordinador.EliminarClienteDeRuta(cedula, obtenerDia(dia), idR);

            if (respuesta.next()) {

                if (respuesta.getString(1).equals("1")) {
                    try {
                         JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado con exito");
                        ListarClientesPorBusqueda((int) TableListarRutas_GestorDeRutas.getValueAt(TableListarRutas_GestorDeRutas.getSelectedRow(), 0));

                    } catch (Exception e) {
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error en la eliminación");
                }
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton AgregarRuta;
    private javax.swing.JMenuItem Asignacion;
    public static javax.swing.JButton BuscarRuta;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem EliminarRuta;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JPopupMenu MenuClientes;
    public static javax.swing.JLabel NombreRuta;
    public static javax.swing.JTable TablaDetallesRuta;
    public static javax.swing.JTable TableListarRutas_GestorDeRutas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    // End of variables declaration//GEN-END:variables
}
