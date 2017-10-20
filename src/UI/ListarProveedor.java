
package UI;

import LogicaDeNegocios.CoordinadorDeProveedores;
import static UI.ListarProveedor.TablaListarProveedores_ListarProveedores;
import static UI.ListarProveedor.filas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarProveedor extends javax.swing.JPanel {
 static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    EditarProveedor elProveedorAEditar = null;
  public static boolean panelHabilitado=false;
    public ListarProveedor() {
        initComponents();
        VisualizarProveedores();
    }

     public  static void VisualizarProveedores() {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeProveedores elCoordinador = new CoordinadorDeProveedores();
            ResultSet resultadoConsulta = elCoordinador.ListarProveedoresActivos();

            modelo.addColumn("Cédula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Correo electronico");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
           
            filas = new Object[modelo.getColumnCount()];
            TablaListarProveedores_ListarProveedores.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modelo.addRow(filas);
                TablaListarProveedores_ListarProveedores.setModel(modelo);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }
private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

 public void EliminarProveedor() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {
            String CedulaDelClienteSeleccionadoAEliminar = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String NombreClienteSeleccionadoAEliminar = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el cliente: " + NombreClienteSeleccionadoAEliminar
                    + " \ncon la cedula número: " + CedulaDelClienteSeleccionadoAEliminar + "?", "Eliminar cliente");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                CoordinadorDeProveedores elCoordinadorDeProveedores = new CoordinadorDeProveedores();
                try {
                    elCoordinadorDeProveedores.CambiarEstadoProveedor(CedulaDelClienteSeleccionadoAEliminar);
                    VisualizarProveedores();

                } catch (SQLException ex) {
                    Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            SeleccionDeFila = false;
        }
    }
 public void editarProveedor(){
 if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un proveedor de la lista.");
        }else{
        String Cedula= TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
        String Nombre = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String Direccion = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
        String Telefono = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
        String correo = TablaListarProveedores_ListarProveedores.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
       
        elProveedorAEditar = new EditarProveedor(null,true, Cedula, Nombre, Direccion,correo, Telefono );
        elProveedorAEditar.setVisible(true);
 }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuProveedor = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarProveedores_ListarProveedores = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        btBuscar_ListarProveedor = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        btnActualizar_ListarProveedor = new javax.swing.JButton();

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        MenuProveedor.add(Eliminar);

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        MenuProveedor.add(Editar);

        setPreferredSize(new java.awt.Dimension(990, 690));

        TablaListarProveedores_ListarProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaListarProveedores_ListarProveedores.setComponentPopupMenu(MenuProveedor);
        TablaListarProveedores_ListarProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaListarProveedores_ListarProveedoresMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarProveedores_ListarProveedores);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText("Proveedores");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 112));
        jLabel51.setText("Buscar Proveedor");

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setAlignmentX(5.0F);

        btBuscar_ListarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BuscarUsuario.png"))); // NOI18N
        btBuscar_ListarProveedor.setToolTipText("Oprima para cancelar");
        btBuscar_ListarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscar_ListarProveedorActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 112));
        jLabel50.setText("Agregar Proveedor");

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setAlignmentX(5.0F);

        btnActualizar_ListarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarUC.png"))); // NOI18N
        btnActualizar_ListarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar_ListarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel50))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(btBuscar_ListarProveedor)))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(btnActualizar_ListarProveedor)))))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscar_ListarProveedor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnActualizar_ListarProveedor))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel52)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaListarProveedores_ListarProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarProveedores_ListarProveedoresMousePressed
        FilaSeleccionadaParaEliminar = TablaListarProveedores_ListarProveedores.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TablaListarProveedores_ListarProveedoresMousePressed

    private void btBuscar_ListarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscar_ListarProveedorActionPerformed
        panelHabilitado=true;
        BuscarProveedores elProveedor= new BuscarProveedores(null, true);
        elProveedor.setVisible(true);
    
    }//GEN-LAST:event_btBuscar_ListarProveedorActionPerformed

    private void btnActualizar_ListarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar_ListarProveedorActionPerformed
  IngresarProveedor elProveedor= new IngresarProveedor(null, true);
  elProveedor.setVisible(true);
    }//GEN-LAST:event_btnActualizar_ListarProveedorActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
       EliminarProveedor();
    }//GEN-LAST:event_EliminarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       editarProveedor();
    }//GEN-LAST:event_EditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JPopupMenu MenuProveedor;
    public static javax.swing.JTable TablaListarProveedores_ListarProveedores;
    public static javax.swing.JButton btBuscar_ListarProveedor;
    public static javax.swing.JButton btnActualizar_ListarProveedor;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    // End of variables declaration//GEN-END:variables
}
