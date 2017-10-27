package UI;

import LogicaDeNegocios.CoordinadorDeCamion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarCamiones extends javax.swing.JPanel {

    static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
   static boolean panelHabilitado=false;
    EditarProveedor elProveedorAEditar = null;

    public ListarCamiones() {
        initComponents();
//      
    }

    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {

        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuCamiones = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JSeparator();
        btBuscar_ListarCamion = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        btnActualizar_ListarCamion = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarCamiones_ListarCamiones = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarMenu.png"))); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        menuCamiones.add(Editar);

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarMenu.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        menuCamiones.add(Eliminar);

        setPreferredSize(new java.awt.Dimension(960, 539));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setAlignmentX(5.0F);
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 205, -1));

        btBuscar_ListarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        btBuscar_ListarCamion.setToolTipText("Oprima para cancelar");
        btBuscar_ListarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscar_ListarCamionActionPerformed(evt);
            }
        });
        add(btBuscar_ListarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 112));
        jLabel50.setText("Agregar Camión");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, -1, -1));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setAlignmentX(5.0F);
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 206, 11));

        btnActualizar_ListarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        btnActualizar_ListarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar_ListarCamionActionPerformed(evt);
            }
        });
        add(btnActualizar_ListarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, -1));

        TablaListarCamiones_ListarCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaListarCamiones_ListarCamiones.setComponentPopupMenu(menuCamiones);
        TablaListarCamiones_ListarCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaListarCamiones_ListarCamionesMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarCamiones_ListarCamiones);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 940, 326));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 112));
        jLabel52.setText(" Camiones");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 34, 164, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 112));
        jLabel51.setText("Buscar Camión");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
 public void EliminarCamion() {
        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un camion de la lista.");
        } else {
            String PlacaAEliminar = TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
            int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea eliminar el camion con el numero de placa: " + PlacaAEliminar + "?", "Eliminar camión");
            if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

                CoordinadorDeCamion elCoordinadorDeCamiones = new CoordinadorDeCamion();
                try {
                    elCoordinadorDeCamiones.CambiarEstadoCamion(PlacaAEliminar);
                    VisualizarCamion(TablaListarCamiones_ListarCamiones);

                } catch (SQLException ex) {
                    Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListarClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            SeleccionDeFila = false;
        }
    }
    private void btBuscar_ListarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscar_ListarCamionActionPerformed
       panelHabilitado=true;
        BuscarCamiones elCamion = new BuscarCamiones(null,true);
        elCamion.setVisible(true);
    }//GEN-LAST:event_btBuscar_ListarCamionActionPerformed
    public void EditarCamion() {
if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un proveedor de la lista.");
        }else{
        String NumeroDePlaca=TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 0).toString();
        String Marca=TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String Modelo=TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 7).toString();
        String Estilo=TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        String Color=TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 3).toString();
        Date FechaDeCompra=(Date) TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 4);
        float Capacidad=Float.parseFloat(TablaListarCamiones_ListarCamiones.getValueAt(FilaSeleccionadaParaEliminar, 6).toString());
         EditarCamion editarCamion= new EditarCamion(null, true, NumeroDePlaca, Marca, Modelo, Estilo, Color, FechaDeCompra, Capacidad);
        editarCamion.setVisible(true);
}
    }
    private void btnActualizar_ListarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar_ListarCamionActionPerformed
  IngresarCamiones elCamion= new IngresarCamiones(null,true);
  elCamion.setVisible(true);
    }//GEN-LAST:event_btnActualizar_ListarCamionActionPerformed

    private void TablaListarCamiones_ListarCamionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarCamiones_ListarCamionesMousePressed
        FilaSeleccionadaParaEliminar = TablaListarCamiones_ListarCamiones.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TablaListarCamiones_ListarCamionesMousePressed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       EditarCamion();
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
       EliminarCamion();
    }//GEN-LAST:event_EliminarActionPerformed
    public static void VisualizarCamion(JTable Listar) {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();
            ResultSet resultadoConsulta = elCoordinador.ListarCamionesActivos();

            modelo.addColumn("N°Placa");
            modelo.addColumn("Marca");
            modelo.addColumn("Estilo");
            modelo.addColumn("Color");
            modelo.addColumn("Fecha de compra");
            modelo.addColumn("Registrado por usuario");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Modelo");
            filas = new Object[modelo.getColumnCount()];
            Listar.setModel(modelo);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    public static javax.swing.JTable TablaListarCamiones_ListarCamiones;
    public static javax.swing.JButton btBuscar_ListarCamion;
    public static javax.swing.JButton btnActualizar_ListarCamion;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu menuCamiones;
    // End of variables declaration//GEN-END:variables
}
