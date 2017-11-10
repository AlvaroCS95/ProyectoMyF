/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeUsuarios;
import static UI.BuscarClientes.txtCedulaABuscar_BuscarCliente;
import static UI.ListarUsuarios.VisualizarUsuarios;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Laura
 */
public class BuscarUsuarios extends javax.swing.JDialog {

    static Object[] filas;
    public static TableRowSorter trsFiltro;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    EditarUsuario elUsuarioAEditar = null;

    public BuscarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        VisualizarTodosLosUsuarios();
        cerrar();
    }

    public void cerrar() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int Decision = JOptionPane.showConfirmDialog(
                        null,
                        "Desea salir de esta ventana",
                        "Salir",
                        JOptionPane.YES_NO_OPTION);

                if (Decision == JOptionPane.YES_OPTION) {
                    ListarUsuarios.panel = false;
                    dispose();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")

    public static void VisualizarTodosLosUsuarios() {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeUsuarios elCoordinador = new CoordinadorDeUsuarios();
            ResultSet resultadoConsulta = elCoordinador.ListarTodosLosUsuariosActivos();

            modelo.addColumn("Cédula");
            modelo.addColumn("Primer nombre");
            modelo.addColumn("Segundo nombre");
            modelo.addColumn("Primer apellido");
            modelo.addColumn("Segundo apellido");
            modelo.addColumn("Nombre de usuario");
            modelo.addColumn("Estado");
            filas = new Object[modelo.getColumnCount()];
            TablaFiltrarUsuarios_BuscarUsuarios.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    if ((i + 1) == 7) {
                        if (resultadoConsulta.getBoolean(i + 1) == true) {
                            filas[i] = "Activo";

                        } else {
                            filas[i] = "Inactivo";
                        }
                    } else {
                        filas[i] = resultadoConsulta.getObject(i + 1);
                    }

                }
                modelo.addRow(filas);
                TablaFiltrarUsuarios_BuscarUsuarios.setModel(modelo);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame,
                JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    public void EliminarUsuario() throws SQLException, ClassNotFoundException {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un usuario de la lista.");
        } else {
            String Estado = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 6).toString();
            String CedulaDelUsuarioSeleccionadoAEliminar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String NombreUsuarioSeleccionadoAEliminar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            if (Estado.equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Este usuario ha sido eliminado con anterioridad");
            } else {

                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el usuario: " + NombreUsuarioSeleccionadoAEliminar
                        + " \ncon la cedula número: " + CedulaDelUsuarioSeleccionadoAEliminar + "?", "Eliminar Usuario");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeUsuarios elCoordinadorDeUsuarios = new CoordinadorDeUsuarios();
                    try {

                        elCoordinadorDeUsuarios.CambiarEstadoUsuario(CedulaDelUsuarioSeleccionadoAEliminar);
                        VisualizarUsuarios();
                        if (ListarUsuarios.panel == true) {

                            txtCedulaABuscar_BuscarUsuario.setText("");
                            BuscarUsuario();
                            VisualizarTodosLosUsuarios();

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                SeleccionDeFila = false;
            }
        }
    }

    public void ActivarUsuario() throws SQLException, ClassNotFoundException {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un usuario de la lista.");
        } else {
            String Estado = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 6).toString();
            String CedulaDelUsuarioSeleccionadoAEliminar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String NombreUsuarioSeleccionadoAEliminar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            if (Estado.equals("Activo")) {
                JOptionPane.showMessageDialog(null, "Este usuario ha sido activado con anterioridad");
            } else {

                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea activar el usuario: " + NombreUsuarioSeleccionadoAEliminar
                        + " \ncon la cedula número: " + CedulaDelUsuarioSeleccionadoAEliminar + "?", "Activar Usuario");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeUsuarios elCoordinadorDeUsuarios = new CoordinadorDeUsuarios();
                    try {

                        elCoordinadorDeUsuarios.CambiarEstadoUsuario(CedulaDelUsuarioSeleccionadoAEliminar);

                        VisualizarUsuarios();
                        if (ListarUsuarios.panel == true) {

                            txtCedulaABuscar_BuscarUsuario.setText("");
                            BuscarUsuario();
                            VisualizarTodosLosUsuarios();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                SeleccionDeFila = false;
            }
        }
    }

    public static void filtro() {
        int columnaABuscar = 0;
        if (cbxFiltro.getSelectedItem() == "Cedula") {
            columnaABuscar = 0;
        }
        if (cbxFiltro.getSelectedItem() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cbxFiltro.getSelectedItem() == "Apellido") {
            columnaABuscar = 3;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + txtCedulaABuscar_BuscarUsuario.getText(), columnaABuscar));
    }

    public static void BuscarUsuario() {

        txtCedulaABuscar_BuscarUsuario.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtCedulaABuscar_BuscarUsuario.getText());
                txtCedulaABuscar_BuscarUsuario.setText(cadena);
                // repaint();
                filtro();

            }
        });
        trsFiltro = new TableRowSorter(TablaFiltrarUsuarios_BuscarUsuarios.getModel());
        TablaFiltrarUsuarios_BuscarUsuarios.setRowSorter(trsFiltro);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBuscar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        Activar = new javax.swing.JMenuItem();
        jLabel52 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtCedulaABuscar_BuscarUsuario = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaFiltrarUsuarios_BuscarUsuarios = new javax.swing.JTable();

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuBuscar.add(Editar);

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuBuscar.add(Eliminar);

        Activar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActivarMenu.png"))); // NOI18N
        Activar.setText("Activar");
        Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarActionPerformed(evt);
            }
        });
        menuBuscar.add(Activar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Busqueda de usuarios");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setText("Filtrar usuarios ");

        txtCedulaABuscar_BuscarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedulaABuscar_BuscarUsuario.setForeground(new java.awt.Color(0, 102, 102));
        txtCedulaABuscar_BuscarUsuario.setToolTipText("Campo para buscar usuario");
        txtCedulaABuscar_BuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaABuscar_BuscarUsuarioKeyTyped(evt);
            }
        });

        cbxFiltro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Nombre", "Apellido" }));
        cbxFiltro.setToolTipText("Despliegue para seleccionar opciones de busqueda");
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        TablaFiltrarUsuarios_BuscarUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaFiltrarUsuarios_BuscarUsuarios.setToolTipText("");
        TablaFiltrarUsuarios_BuscarUsuarios.setComponentPopupMenu(menuBuscar);
        TablaFiltrarUsuarios_BuscarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaFiltrarUsuarios_BuscarUsuariosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablaFiltrarUsuarios_BuscarUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49)
                        .addGap(25, 25, 25)
                        .addComponent(txtCedulaABuscar_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCedulaABuscar_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaABuscar_BuscarUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaABuscar_BuscarUsuarioKeyTyped
        BuscarUsuario();

    }//GEN-LAST:event_txtCedulaABuscar_BuscarUsuarioKeyTyped

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed

    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarActionPerformed
        try {
            ActivarUsuario();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BuscarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActivarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            EliminarUsuario();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BuscarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EliminarActionPerformed
    public void EditarUsuario() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un usuario de la lista.");
        } else {

            String CedulaDelUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String PrimerNombreUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            String SegundoNombreUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
            String PrimerApellidoUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
            String SegundoApellidoUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
            String NombreUsuarioSeleccionadoAEditar = TablaFiltrarUsuarios_BuscarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 5).toString();

            elUsuarioAEditar = new EditarUsuario(null, true, CedulaDelUsuarioSeleccionadoAEditar, PrimerNombreUsuarioSeleccionadoAEditar, SegundoNombreUsuarioSeleccionadoAEditar, PrimerApellidoUsuarioSeleccionadoAEditar, SegundoApellidoUsuarioSeleccionadoAEditar, NombreUsuarioSeleccionadoAEditar);
            elUsuarioAEditar.setVisible(true);
        }
    }
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        EditarUsuario();
    }//GEN-LAST:event_EditarActionPerformed

    private void TablaFiltrarUsuarios_BuscarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFiltrarUsuarios_BuscarUsuariosMouseClicked
        FilaSeleccionadaParaEliminar = TablaFiltrarUsuarios_BuscarUsuarios.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TablaFiltrarUsuarios_BuscarUsuariosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Activar;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaFiltrarUsuarios_BuscarUsuarios;
    public static javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu menuBuscar;
    public static javax.swing.JTextField txtCedulaABuscar_BuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
