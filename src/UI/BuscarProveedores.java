/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeClientes;
import LogicaDeNegocios.CoordinadorDeProveedores;
import static UI.BuscarClientes.TablaFiltrarClientes_ListarClientes;
import static UI.BuscarClientes.txtCedulaABuscar_BuscarCliente;

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
public class BuscarProveedores extends javax.swing.JDialog {

    static Object[] filas;
    public static TableRowSorter trsFiltro;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
     static int columnaABuscar = 0;
    EditarProveedor elProveedorAEditar = null;

    public BuscarProveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        VisualizarTodosLosProveedores();
        cerrar();
    }
public void cerrar(){
addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                 int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            ListarProveedor.panelHabilitado=false;
            dispose();
        }
            }
        });
}
    @SuppressWarnings("unchecked")
    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    public void editarProveedor() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un proveedor de la lista.");
        } else {
            String Cedula = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String Nombre = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            String Direccion = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
            String Telefono = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 5).toString();
            String correo = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();

            elProveedorAEditar = new EditarProveedor(null, true, Cedula, Nombre, Direccion, correo, Telefono);
            elProveedorAEditar.setVisible(true);
        }
    }

    public static void VisualizarTodosLosProveedores() {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeProveedores elCoordinador = new CoordinadorDeProveedores();
            ResultSet resultadoConsulta = elCoordinador.ListarTodosLosProveedores();

            modelo.addColumn("Cédula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Estado");
            modelo.addColumn("Correo electronico");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");

            filas = new Object[modelo.getColumnCount()];
            TablaBuscarProveedores_BuscarProveedores.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {

                   if ((i + 1) == 3) {
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
                TablaBuscarProveedores_BuscarProveedores.setModel(modelo);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public static void filtro() {
      
        if (cbxFiltro.getSelectedItem() == "Cedula") {
            columnaABuscar = 0;
        }
        if (cbxFiltro.getSelectedItem() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cbxFiltro.getSelectedItem() == "Direccion") {
            columnaABuscar = 4;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+txtCedulaABuscar_BuscarProveedor.getText(), columnaABuscar));
    }

    public void EliminarProveedor(JTable Lista) {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un proveedor de la lista.");
        } else {
            String Estado = Lista.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
            if (Estado.equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "El proveedor seleccionado ha sido eliminado" + "\n"
                        + "con anterioridad");
            } else {
                String CedulaDelClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
                String NombreClienteSeleccionadoAEliminar = Lista.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el proveedor: " + NombreClienteSeleccionadoAEliminar
                        + " \ncon la cedula número: " + CedulaDelClienteSeleccionadoAEliminar + "?", "Eliminar proveedor");
                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeProveedores elCoordinadorDeProveedores = new CoordinadorDeProveedores();
                    try {
                        elCoordinadorDeProveedores.CambiarEstadoProveedor(CedulaDelClienteSeleccionadoAEliminar);
                        ListarProveedor.VisualizarProveedores();
                        if (ListarProveedor.panelHabilitado == true) {

                            txtCedulaABuscar_BuscarProveedor.setText("");
                            BuscarProveedor();
                            VisualizarTodosLosProveedores();

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ListarProveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ListarProveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                SeleccionDeFila = false;
            }
        }
    }

    public static void BuscarProveedor() {

        txtCedulaABuscar_BuscarProveedor.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtCedulaABuscar_BuscarProveedor.getText());
                txtCedulaABuscar_BuscarProveedor.setText(cadena);
                // repaint();
                filtro();

            }
        });
        trsFiltro = new TableRowSorter(TablaBuscarProveedores_BuscarProveedores.getModel());
        TablaBuscarProveedores_BuscarProveedores.setRowSorter(trsFiltro);
    }

    public void ActivarProveedor() throws SQLException, ClassNotFoundException {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un proveedor de la lista.");
        } else {
            String Estado = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
            if (Estado.equals("Activo")) {
                JOptionPane.showMessageDialog(null, "Este proveedor ha sido activado con anterioridad");
            } else {
                String Cedula = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
                String Nombre = TablaBuscarProveedores_BuscarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
                int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea activar el proveedor: "
                        + Nombre
                        + " \ncon la cedula número: " + Cedula + "?", "Activar proveedor");

                if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                    CoordinadorDeProveedores elCoordinadorDeProveedores = new CoordinadorDeProveedores();
                    elCoordinadorDeProveedores.CambiarEstadoProveedor(Cedula);
                   ListarProveedor.VisualizarProveedores();
                        if (ListarProveedor.panelHabilitado == true) {

                            txtCedulaABuscar_BuscarProveedor.setText("");
                            BuscarProveedor();
                            VisualizarTodosLosProveedores();

                        }

                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFiltar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        Activar = new javax.swing.JMenuItem();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaBuscarProveedores_BuscarProveedores = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        txtCedulaABuscar_BuscarProveedor = new javax.swing.JTextField();
        cbxFiltro = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuFiltar.add(Editar);

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuFiltar.add(Eliminar);

        Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActivarMenu.png"))); // NOI18N
        Activar.setText("Activar");
        Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarActionPerformed(evt);
            }
        });
        menuFiltar.add(Activar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        TablaBuscarProveedores_BuscarProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaBuscarProveedores_BuscarProveedores.setToolTipText("Muestra los proveedores.");
        TablaBuscarProveedores_BuscarProveedores.setComponentPopupMenu(menuFiltar);
        TablaBuscarProveedores_BuscarProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBuscarProveedores_BuscarProveedoresMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablaBuscarProveedores_BuscarProveedores);

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setText("Ingrese pista:");

        txtCedulaABuscar_BuscarProveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCedulaABuscar_BuscarProveedor.setForeground(new java.awt.Color(0, 102, 102));
        txtCedulaABuscar_BuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaABuscar_BuscarProveedorKeyTyped(evt);
            }
        });

        cbxFiltro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Nombre", "Direccion" }));
        cbxFiltro.setToolTipText("Opciones de búsqueda.");
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Busqueda de proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel49)
                        .addGap(33, 33, 33)
                        .addComponent(txtCedulaABuscar_BuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaABuscar_BuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaABuscar_BuscarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaABuscar_BuscarProveedorKeyTyped
        BuscarProveedor();

    }//GEN-LAST:event_txtCedulaABuscar_BuscarProveedorKeyTyped

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed

    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        editarProveedor();
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        EliminarProveedor(TablaBuscarProveedores_BuscarProveedores);        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarActionPerformed
        try {
            ActivarProveedor();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BuscarProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActivarActionPerformed

    private void TablaBuscarProveedores_BuscarProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBuscarProveedores_BuscarProveedoresMouseClicked
FilaSeleccionadaParaEliminar = TablaBuscarProveedores_BuscarProveedores.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TablaBuscarProveedores_BuscarProveedoresMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Activar;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaBuscarProveedores_BuscarProveedores;
    public static javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu menuFiltar;
    public static javax.swing.JTextField txtCedulaABuscar_BuscarProveedor;
    // End of variables declaration//GEN-END:variables
}
