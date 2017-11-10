package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import static UI.BuscarUsuarios.BuscarUsuario;
import static UI.BuscarUsuarios.VisualizarTodosLosUsuarios;
import static UI.BuscarUsuarios.txtCedulaABuscar_BuscarUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarClientes extends javax.swing.JPanel {

    public static boolean panelHabilitado = false;
    static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    EditarCliente elClienteAEditar = null;

    public ListarClientes() {
        initComponents();
//       

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClientes = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jLabel52 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        btAgregar_ListarUsuarios = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarClientes_ListarClientes = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        btAgregar_ListarUsuarios1 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuClientes.add(Editar);

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuClientes.add(Eliminar);

        setMinimumSize(new java.awt.Dimension(1046, 539));
        setPreferredSize(new java.awt.Dimension(960, 539));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Clientes");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 137, -1));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setAlignmentX(5.0F);
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 205, -1));

        btAgregar_ListarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarUC.png"))); // NOI18N
        btAgregar_ListarUsuarios.setToolTipText("Oprima para cancelar");
        btAgregar_ListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregar_ListarUsuariosActionPerformed(evt);
            }
        });
        add(btAgregar_ListarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, -1, -1));

        TablaListarClientes_ListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaListarClientes_ListarClientes.setColumnSelectionAllowed(true);
        TablaListarClientes_ListarClientes.setComponentPopupMenu(menuClientes);
        TablaListarClientes_ListarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaListarClientes_ListarClientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarClientes_ListarClientes);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 1300, 360));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 112));
        jLabel51.setText("Ingresar Cliente");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, -1));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel50.setText("Lista de Clientes Activos");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setAlignmentX(5.0F);
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 205, -1));

        btAgregar_ListarUsuarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BuscarUsuario.png"))); // NOI18N
        btAgregar_ListarUsuarios1.setToolTipText("Oprima para cancelar");
        btAgregar_ListarUsuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregar_ListarUsuarios1ActionPerformed(evt);
            }
        });
        add(btAgregar_ListarUsuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, -1, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 112));
        jLabel53.setText("Buscar Cliente");
        add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 173, -1));
    }// </editor-fold>//GEN-END:initComponents
private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    public static void VisualizarClientes(JTable Listar) {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeClientes elCoordinador = new CoordinadorDeClientes();
            ResultSet resultadoConsulta = elCoordinador.ListarClientes();
            modelo.addColumn("Código");
            modelo.addColumn("Cédula");
            modelo.addColumn("Primer nombre");
            modelo.addColumn("Segundo nombre");
            modelo.addColumn("Primer apellido");
            modelo.addColumn("Segundo apellido");
            modelo.addColumn("Nivel");

            modelo.addColumn("Dirección");
            modelo.addColumn("Nombre de local");
            modelo.addColumn("Razón Social");
            Listar.setModel(modelo);
            filas = new Object[modelo.getColumnCount()];
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {

                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);
                }
                modelo.addRow(filas);
                Listar.setModel(modelo);

            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void EliminarCliente(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
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
                    if (ListarUsuarios.panel == true) {

                        txtCedulaABuscar_BuscarUsuario.setText("");
                        BuscarUsuario();
                        VisualizarTodosLosUsuarios();
                        ListarUsuarios.panel = false;
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

    public void ActivarCliente(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {
            String CedulaDelClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String NombreClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea Activar el cliente: " + NombreClienteSeleccionadoAEliminar
                    + " \ncon la cedula número: " + CedulaDelClienteSeleccionadoAEliminar + "?", "Activar cliente");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                CoordinadorDeClientes elCoordinadorDeClientes = new CoordinadorDeClientes();
                try {
                    elCoordinadorDeClientes.CambiarEstadoCliente(CedulaDelClienteSeleccionadoAEliminar);
                    VisualizarClientes(TablaListarClientes_ListarClientes);
                    if (ListarUsuarios.panel == true) {

                        txtCedulaABuscar_BuscarUsuario.setText("");
                        BuscarUsuario();
                        VisualizarTodosLosUsuarios();
                        ListarUsuarios.panel = false;
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

    public void EditarCliente(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {
            String CedulaDelClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            String PrimerNombreClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
            String SegundoNombreClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
            String PrimerApellidoClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
            String SegundoApellidoClienteSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 5).toString();
            String Nivel = Lista.getValueAt(FilaSeleccionadaParaEliminar, 6).toString();
            String Direccion = Lista.getValueAt(FilaSeleccionadaParaEliminar, 7).toString();
            String Razon = Lista.getValueAt(FilaSeleccionadaParaEliminar, 9).toString();

            String NombreLocalSeleccionadoAEditar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 8).toString();
            elClienteAEditar = new EditarCliente(null, true, Nivel, CedulaDelClienteSeleccionadoAEditar, PrimerNombreClienteSeleccionadoAEditar,
                    SegundoNombreClienteSeleccionadoAEditar, PrimerApellidoClienteSeleccionadoAEditar,
                    SegundoApellidoClienteSeleccionadoAEditar, NombreLocalSeleccionadoAEditar, Razon, Direccion);
            elClienteAEditar.setVisible(true);
        }
    }
    private void btAgregar_ListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregar_ListarUsuariosActionPerformed
        IngresarClientes ingresoCliente = new IngresarClientes(null, true);
        ingresoCliente.setVisible(true);
    }//GEN-LAST:event_btAgregar_ListarUsuariosActionPerformed


    private void btAgregar_ListarUsuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregar_ListarUsuarios1ActionPerformed
        panelHabilitado = true;
        BuscarClientes elCliente = new BuscarClientes(null, true);
        elCliente.setVisible(true);
    }//GEN-LAST:event_btAgregar_ListarUsuarios1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        EditarCliente(TablaListarClientes_ListarClientes);
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        EliminarCliente(TablaListarClientes_ListarClientes);
    }//GEN-LAST:event_EliminarActionPerformed

    private void TablaListarClientes_ListarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarClientes_ListarClientesMouseClicked
        FilaSeleccionadaParaEliminar = TablaListarClientes_ListarClientes.getSelectedRow();
        SeleccionDeFila = true;       
    }//GEN-LAST:event_TablaListarClientes_ListarClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaListarClientes_ListarClientes;
    public static javax.swing.JButton btAgregar_ListarUsuarios;
    public static javax.swing.JButton btAgregar_ListarUsuarios1;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu menuClientes;
    // End of variables declaration//GEN-END:variables
}
