package UI;

import LogicaDeNegocios.CoordinadorDeRutas;
import static UI.GestorDeRutas.VisualizarRutasActivas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Laura
 */
public class BuscarRutas extends javax.swing.JDialog {

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
    static int columnaABuscar = 0;

    public BuscarRutas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        VisualizarTodasLasRutas();
    }

    public static void VisualizarTodasLasRutas() {
        try {

            DefaultTableModel modeloV = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloV.addColumn("N°Ruta");
            modeloV.addColumn("Nombre");
            modeloV.addColumn("Descripción");
            modeloV.addColumn("Estado");

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarTodasLasRutas();

            filas = new Object[modeloV.getColumnCount()];
            TableBuscarRutas_GestorDeRutas.setModel(modeloV);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modeloV.getColumnCount(); i++) {

                    if ((i + 1) == 4) {
                        if (resultadoConsulta.getBoolean(i + 1) == true) {
                            filas[i] = "Activo";

                        } else {
                            filas[i] = "Inactivo";
                        }
                    } else {
                        filas[i] = resultadoConsulta.getObject(i + 1);
                    }

                }
                modeloV.addRow(filas);
                TableBuscarRutas_GestorDeRutas.setModel(modeloV);
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Activar = new javax.swing.JMenuItem();
        Inactivar = new javax.swing.JMenuItem();
        MostarDetalles = new javax.swing.JMenuItem();
        Asignacion = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        jLabel6 = new javax.swing.JLabel();
        cbxOpcionesBuscarRuta_GestorDeRutas = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBuscarRutas_GestorDeRutas = new javax.swing.JTable();
        txtBuscarRuta_GestorDeRuta = new javax.swing.JTextField();

        Activar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActivarMenu.png"))); // NOI18N
        Activar.setText("Activar");
        Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarActionPerformed(evt);
            }
        });
        Menu.add(Activar);

        Inactivar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Inactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sign_Close_Icon_16.png"))); // NOI18N
        Inactivar.setText("Eliminar");
        Inactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactivarActionPerformed(evt);
            }
        });
        Menu.add(Inactivar);

        MostarDetalles.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        MostarDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RutaInformacion.png"))); // NOI18N
        MostarDetalles.setText("Mostrar detalles");
        MostarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostarDetallesActionPerformed(evt);
            }
        });
        Menu.add(MostarDetalles);

        Asignacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Asignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        Asignacion.setText("Asinaciones");
        Asignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignacionActionPerformed(evt);
            }
        });
        Menu.add(Asignacion);

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EditIcon.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Menu.add(Editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Buscar rutas por");

        cbxOpcionesBuscarRuta_GestorDeRutas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxOpcionesBuscarRuta_GestorDeRutas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "N°Ruta" }));
        cbxOpcionesBuscarRuta_GestorDeRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda(evt);
            }
        });

        TableBuscarRutas_GestorDeRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableBuscarRutas_GestorDeRutas.setComponentPopupMenu(Menu);
        TableBuscarRutas_GestorDeRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBuscarRutas_GestorDeRutasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableBuscarRutas_GestorDeRutas);

        txtBuscarRuta_GestorDeRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarRuta_GestorDeRutaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda
        filtro();
    }//GEN-LAST:event_cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda

    private void txtBuscarRuta_GestorDeRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRuta_GestorDeRutaKeyTyped
        BuscarRuta();

    }//GEN-LAST:event_txtBuscarRuta_GestorDeRutaKeyTyped
    public void editar() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un ruta de la lista.");
        } else {
            int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
            String Nombre = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            String Detalle = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
            EditarRutas editar = new EditarRutas(null, true, id, Nombre, Detalle);
            editar.setVisible(true);
        }
    }

    public void eliminarRutas(int id) throws ClassNotFoundException, SQLException {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un ruta de la lista.");
        } else {
            Icon icono = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));

            String estado = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
            if (estado.equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Error,esta ruta se encuentra inactivada");
                return;
            } else {
                int dialogResult = JOptionPane.showConfirmDialog(null, "<html><h4>¿ Desea elimar la ruta ?</h4></html>", "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono);

                if (dialogResult == JOptionPane.YES_OPTION) {

                    CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
                    ResultSet respuesta;
                    respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
                    if (respuesta.next()) {
                        if (respuesta.getString(1).equals("2")) {
                            JOptionPane.showMessageDialog(null, "Eliminación exitosa");

                            VisualizarTodasLasRutas();
                            VisualizarRutasActivas();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error en la eliminación");
                        }
                    }
                }
            }
        }
    }
    private void AsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignacionActionPerformed
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un ruta de la lista.");
        } else {
            int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
            String Nombre = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            AsignacionesDeRuta laAsignacion = new AsignacionesDeRuta(null, true, id, Nombre);
            laAsignacion.setVisible(true);
        }     // TODO add your handling code here:
    }//GEN-LAST:event_AsignacionActionPerformed
    public static void filtro() {

        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "N°Ruta") {
            opcionBusqueda = true;
            columnaABuscar = 0;
        }
        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "Nombre") {
            opcionBusqueda = false;
            columnaABuscar = 1;
        }

        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscarRuta_GestorDeRuta.getText(), columnaABuscar));
    }

    public static void BuscarRuta() {

        txtBuscarRuta_GestorDeRuta.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscarRuta_GestorDeRuta.getText());
                txtBuscarRuta_GestorDeRuta.setText(cadena);

                filtro();
            }
        });
        trsFiltro = new TableRowSorter(TableBuscarRutas_GestorDeRutas.getModel());
        TableBuscarRutas_GestorDeRutas.setRowSorter(trsFiltro);
    }
    private void MostarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostarDetallesActionPerformed
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un ruta de la lista.");
        } else {
            int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
            String Nombre = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            DetallesDeRuta losDetalles = new DetallesDeRuta(null, true, id, Nombre);
            losDetalles.setVisible(true);
        }     // TODO add your handling code here:
    }//GEN-LAST:event_MostarDetallesActionPerformed
    public void activarRutas(int id) throws ClassNotFoundException, SQLException {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un ruta de la lista.");
        } else {
            String estado = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
            if (estado.equals("Activo")) {
                JOptionPane.showMessageDialog(null, "Error,esta ruta se encuentra activa");
                return;
            } else {
                CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
                ResultSet respuesta;
                respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
                if (respuesta.next()) {
                    if (respuesta.getString(1).equals("2")) {
                        JOptionPane.showMessageDialog(null, "Activacion exitosa");

                        VisualizarTodasLasRutas();
                        VisualizarRutasActivas();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error en la activacion");
                    }
                }
            }
        }
    }
    private void InactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactivarActionPerformed
        try {
            int RutaEliminar = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
            eliminarRutas(RutaEliminar);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InactivarActionPerformed

    private void ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarActionPerformed
        int RutaEliminar = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);

        try {
            activarRutas(RutaEliminar);      // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActivarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        editar();        // TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed

    private void TableBuscarRutas_GestorDeRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBuscarRutas_GestorDeRutasMouseClicked
        FilaSeleccionadaParaEliminar = TableBuscarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TableBuscarRutas_GestorDeRutasMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Activar;
    private javax.swing.JMenuItem Asignacion;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Inactivar;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JMenuItem MostarDetalles;
    public static javax.swing.JTable TableBuscarRutas_GestorDeRutas;
    public static javax.swing.JComboBox cbxOpcionesBuscarRuta_GestorDeRutas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField txtBuscarRuta_GestorDeRuta;
    // End of variables declaration//GEN-END:variables
}
