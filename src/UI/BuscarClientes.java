/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import static UI.ListarClientes.VisualizarClientes;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Laura
 */
public class BuscarClientes extends javax.swing.JDialog {

    static Object[] filas;
    public static TableRowSorter trsFiltro;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    static    int columnaABuscar = 1;
    EditarCliente elClienteAEditar = null;

    public BuscarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        VisualizarTodosLosClientes(TablaFiltrarClientes_ListarClientes);
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
                    ListarClientes.panelHabilitado = false;
                    dispose();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFiltro = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        Activar = new javax.swing.JMenuItem();
        jLabel49 = new javax.swing.JLabel();
        txtCedulaABuscar_BuscarCliente = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaFiltrarClientes_ListarClientes = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuFiltro.add(Editar);

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuFiltro.add(Eliminar);

        Activar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActivarMenu.png"))); // NOI18N
        Activar.setText("Activar");
        Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarActionPerformed(evt);
            }
        });
        menuFiltro.add(Activar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setText("Filtrar clientes ");

        txtCedulaABuscar_BuscarCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedulaABuscar_BuscarCliente.setForeground(new java.awt.Color(0, 102, 102));
        txtCedulaABuscar_BuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaABuscar_BuscarClienteKeyTyped(evt);
            }
        });

        cbxFiltro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Nombre", "Apellido" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        TablaFiltrarClientes_ListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaFiltrarClientes_ListarClientes.setColumnSelectionAllowed(true);
        TablaFiltrarClientes_ListarClientes.setComponentPopupMenu(menuFiltro);
        TablaFiltrarClientes_ListarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaFiltrarClientes_ListarClientesMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaFiltrarClientes_ListarClientes);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Busqueda de clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel52)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel49)
                        .addGap(33, 33, 33)
                        .addComponent(txtCedulaABuscar_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCedulaABuscar_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public static void VisualizarTodosLosClientes(JTable Listar) {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeClientes elCoordinador = new CoordinadorDeClientes();
            ResultSet resultadoConsulta = elCoordinador.ListarTodosLosClientes();
            modelo.addColumn("Codigo");
            modelo.addColumn("Cédula");
            modelo.addColumn("Primer nombre");
            modelo.addColumn("Segundo nombre");
            modelo.addColumn("Primer apellido");
            modelo.addColumn("Segundo apellido");
            modelo.addColumn("Nivel");
            modelo.addColumn("Estado");

            modelo.addColumn("Direccion");
            modelo.addColumn("Nombre de local");
            modelo.addColumn("Razon social");
            Listar.setModel(modelo);
            filas = new Object[modelo.getColumnCount()];
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {

                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    if ((i + 1) == 8) {
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
                Listar.setModel(modelo);

            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    private void txtCedulaABuscar_BuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaABuscar_BuscarClienteKeyTyped

        BuscarCliente();
    }//GEN-LAST:event_txtCedulaABuscar_BuscarClienteKeyTyped
    public static void filtro() {
    
        if (cbxFiltro.getSelectedItem() == "Cedula") {
            columnaABuscar = 1;
        }
        if (cbxFiltro.getSelectedItem() == "Nombre") {
            columnaABuscar = 2;
        }
        if (cbxFiltro.getSelectedItem() == "Apellido") {
            columnaABuscar = 4;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+txtCedulaABuscar_BuscarCliente.getText(), columnaABuscar));
    }
    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed

    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void TablaFiltrarClientes_ListarClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFiltrarClientes_ListarClientesMousePressed
        FilaSeleccionadaParaEliminar = TablaFiltrarClientes_ListarClientes.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TablaFiltrarClientes_ListarClientesMousePressed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        EditarCliente(TablaFiltrarClientes_ListarClientes);
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        EliminarCliente(TablaFiltrarClientes_ListarClientes);
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarActionPerformed
        ActivarCliente(TablaFiltrarClientes_ListarClientes);
    }//GEN-LAST:event_ActivarActionPerformed
    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    public void EliminarCliente(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {
            String Estado = Lista.getValueAt(FilaSeleccionadaParaEliminar, 7).toString();
            if (Estado.equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "El cliente seleccionado ha sido eliminado" + "\n"
                        + "con anterioridad");
            } else {
                String CedulaDelClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
                String NombreClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el cliente: " + NombreClienteSeleccionadoAEliminar
                        + " \ncon la cedula número: " + CedulaDelClienteSeleccionadoAEliminar + "?", "Eliminar cliente");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();
                    try {
                        elCoordinadorDeClientes.CambiarEstadoCliente(CedulaDelClienteSeleccionadoAEliminar);
                        VisualizarClientes(TablaListarClientes_ListarClientes);
                        if (ListarClientes.panelHabilitado == true) {

                            txtCedulaABuscar_BuscarCliente.setText("");
                            BuscarCliente();
                            VisualizarTodosLosClientes(Lista);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                SeleccionDeFila = false;
            }
        }
    }

    public void ActivarCliente(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {

            String Estado = Lista.getValueAt(FilaSeleccionadaParaEliminar, 7).toString();
            if (Estado.equals("Activo")) {
                JOptionPane.showMessageDialog(null, "El cliente seleccionado ha sido Activado" + "\n"
                        + "con anterioridad");
            } else {
                String CedulaDelClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
                String NombreClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea Activar el cliente: " + NombreClienteSeleccionadoAEliminar
                        + " \ncon la cedula número: " + CedulaDelClienteSeleccionadoAEliminar + "?", "Activar cliente");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();
                    try {
                        elCoordinadorDeClientes.CambiarEstadoCliente(CedulaDelClienteSeleccionadoAEliminar);
                        VisualizarClientes(TablaListarClientes_ListarClientes);
                        if (ListarClientes.panelHabilitado == true) {

                            txtCedulaABuscar_BuscarCliente.setText("");
                            BuscarCliente();
                            VisualizarTodosLosClientes(Lista);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            SeleccionDeFila = false;
        }
    }

    public void EditarCliente(JTable Lista) {

        String CedulaDelClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String PrimerNombreClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        String SegundoNombreClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
        String PrimerApellidoClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
        String SegundoApellidoClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 5).toString();
        String Nivel = Lista.getValueAt(FilaSeleccionadaParaEliminar, 6).toString();
        String NombreLocalSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 9).toString();
        String RazonSocial = Lista.getValueAt(FilaSeleccionadaParaEliminar, 10).toString();
        String Direccion = Lista.getValueAt(FilaSeleccionadaParaEliminar, 8).toString();
        elClienteAEditar = new EditarCliente(null, true, Nivel, CedulaDelClienteSeleccionadoAEditar, PrimerNombreClienteSeleccionadoAEditar,
                SegundoNombreClienteSeleccionadoAEditar, PrimerApellidoClienteSeleccionadoAEditar,
                SegundoApellidoClienteSeleccionadoAEditar, NombreLocalSeleccionadoAEditar, RazonSocial,Direccion);
        elClienteAEditar.setVisible(true);

    }

    public  void BuscarCliente() {

        txtCedulaABuscar_BuscarCliente.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtCedulaABuscar_BuscarCliente.getText());
                txtCedulaABuscar_BuscarCliente.setText(cadena);
                 repaint();
                filtro();

            }
        });
        trsFiltro = new TableRowSorter(TablaFiltrarClientes_ListarClientes.getModel());
        TablaFiltrarClientes_ListarClientes.setRowSorter(trsFiltro);
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Activar;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaFiltrarClientes_ListarClientes;
    public static javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu menuFiltro;
    public static javax.swing.JTextField txtCedulaABuscar_BuscarCliente;
    // End of variables declaration//GEN-END:variables
}
