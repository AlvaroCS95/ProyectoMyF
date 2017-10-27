
package UI;

import LogicaDeNegocios.CoordinadorDeUsuarios;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarUsuarios extends javax.swing.JPanel {

   static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    EditarUsuario elUsuarioAEditar = null;
    public static boolean panel=false;
   

    public ListarUsuarios() {
        initComponents();
//        VisualizarUsuarios();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuUsuarios = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jLabel52 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        btBuscar_ListarUsuarios = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarUsuarios_ListarUsuarios = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        btnActualizarUsuario_ListarUsuario = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();

        Editar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuUsuarios.add(Editar);

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuUsuarios.add(Eliminar);

        setMinimumSize(new java.awt.Dimension(960, 539));
        setPreferredSize(new java.awt.Dimension(1046, 539));
        setVerifyInputWhenFocusTarget(false);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText(" Usuarios");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 112));
        jLabel50.setText("Ingresar Usuario");

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setAlignmentX(5.0F);

        btBuscar_ListarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BuscarUsuario.png"))); // NOI18N
        btBuscar_ListarUsuarios.setToolTipText("Oprima para cancelar");
        btBuscar_ListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscar_ListarUsuariosActionPerformed(evt);
            }
        });

        TablaListarUsuarios_ListarUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaListarUsuarios_ListarUsuarios.setComponentPopupMenu(menuUsuarios);
        TablaListarUsuarios_ListarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaListarUsuarios_ListarUsuariosMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarUsuarios_ListarUsuarios);

        jLabel51.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 112));
        jLabel51.setText("Buscar Usuario");

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setAlignmentX(5.0F);

        btnActualizarUsuario_ListarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarUC.png"))); // NOI18N
        btnActualizarUsuario_ListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuario_ListarUsuarioActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel53.setText("Lista de Usuarios Activos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel51))
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btBuscar_ListarUsuarios)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel50))
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnActualizarUsuario_ListarUsuario)))
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscar_ListarUsuarios))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnActualizarUsuario_ListarUsuario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53)))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    ;

    public static void VisualizarUsuarios() {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeUsuarios elCoordinador = new CoordinadorDeUsuarios();
            ResultSet resultadoConsulta = elCoordinador.ListarUsuariosActivos();

            modelo.addColumn("Cédula");
            modelo.addColumn("Primer nombre");
            modelo.addColumn("Segundo nombre");
            modelo.addColumn("Primer apellido");
            modelo.addColumn("Segundo apellido");
            modelo.addColumn("Nombre de usuario");
            filas = new Object[modelo.getColumnCount()];
            TablaListarUsuarios_ListarUsuarios.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modelo.addRow(filas);
                TablaListarUsuarios_ListarUsuarios.setModel(modelo);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void EliminarUsuario() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un Usuario de la lista.");
        } else {
            String CedulaDelUsuarioSeleccionadoAEliminar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            String NombreUsuarioSeleccionadoAEliminar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el usuario: " + NombreUsuarioSeleccionadoAEliminar
                    + " \ncon la cedula número: " + CedulaDelUsuarioSeleccionadoAEliminar + "?", "Eliminar Usuario");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                CoordinadorDeUsuarios elCoordinadorDeUsuarios = new CoordinadorDeUsuarios();
                try {
                    elCoordinadorDeUsuarios.CambiarEstadoUsuario(CedulaDelUsuarioSeleccionadoAEliminar);
                    VisualizarUsuarios();
                } catch (SQLException ex) {
                    Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             SeleccionDeFila=false;
        }
    }
    
    
    private void btBuscar_ListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscar_ListarUsuariosActionPerformed
         panel=true;  
        BuscarUsuarios elUsuarioBuscar=new BuscarUsuarios(null, true);
          elUsuarioBuscar.setVisible(true);
          
    }//GEN-LAST:event_btBuscar_ListarUsuariosActionPerformed

    private void TablaListarUsuarios_ListarUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarUsuarios_ListarUsuariosMousePressed
        FilaSeleccionadaParaEliminar = TablaListarUsuarios_ListarUsuarios.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TablaListarUsuarios_ListarUsuariosMousePressed
    public void EditarUsuario() {

        String CedulaDelUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
        String PrimerNombreUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String SegundoNombreUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        String PrimerApellidoUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
        String SegundoApellidoUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 4).toString();
        String NombreUsuarioSeleccionadoAEditar = TablaListarUsuarios_ListarUsuarios.getValueAt(FilaSeleccionadaParaEliminar, 5).toString();

        elUsuarioAEditar = new EditarUsuario(null,true,CedulaDelUsuarioSeleccionadoAEditar, PrimerNombreUsuarioSeleccionadoAEditar, SegundoNombreUsuarioSeleccionadoAEditar, PrimerApellidoUsuarioSeleccionadoAEditar, SegundoApellidoUsuarioSeleccionadoAEditar, NombreUsuarioSeleccionadoAEditar);
        elUsuarioAEditar.setVisible(true);

    }
    private void btnActualizarUsuario_ListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuario_ListarUsuarioActionPerformed

        IngresarUsuarios elUsuarioIngresar= new IngresarUsuarios(null, true);
        elUsuarioIngresar.setVisible(true);
    }//GEN-LAST:event_btnActualizarUsuario_ListarUsuarioActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
EditarUsuario();        // TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        EliminarUsuario();
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaListarUsuarios_ListarUsuarios;
    public static javax.swing.JButton btBuscar_ListarUsuarios;
    public static javax.swing.JButton btnActualizarUsuario_ListarUsuario;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu menuUsuarios;
    // End of variables declaration//GEN-END:variables
}
