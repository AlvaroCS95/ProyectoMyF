package UI;

import static UI.GestorDeRutas.InicializarFiltroCamiones;
import static UI.ListarCamiones.VisualizarCamion;
import static UI.ListarClientes.VisualizarClientes;
import static UI.GestorDeRutas.InicializarFiltroClientes;

import LogicaDeNegocios.CoordinadorDeRutas;
import static UI.GestorDeRutas.ListarClientesPorBusqueda;
import static UI.GestorDeRutas.VisualizarRutasActivas;
import static UI.GestorDeRutas.modeloVerCamiones;
import static UI.GestorDeRutas.modeloVerClientes;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AsignacionesDeRuta extends javax.swing.JDialog {

    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    int idRuta, idDIa;
    static Object[] filas;
    String NombreRuta;
    static int contador = 0;
    static int Asignaciones = 0;
    static boolean opcionFiltro = false;

    public AsignacionesDeRuta(java.awt.Frame parent, boolean modal, int id, String Nombre) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.idRuta = id;
        RutaDeAsignacion.setText(Nombre);

        InicializarFiltroClientes(TablaAsignarCliente);
        VisualizarClientes(TablaAsignaciones);
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
                    
                   
                    try {
                        ListarClientesPorBusqueda(idRuta);
                        dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AsignacionesDeRuta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
        });
    }

    public boolean verificarexistencia(JTable tabla, String dia) {
        String obj = "";
        String ced = TablaAsignaciones.getValueAt(TablaAsignaciones.getSelectedRow(), 1).toString();
        for (int i = 0; i < tabla.getRowCount(); i++) {

            if (tabla.getValueAt(i, 1).toString().equals(ced)
                    && tabla.getValueAt(i, 3).toString().equals(dia)) {
                obj = tabla.getValueAt(i, 0).toString();
                JOptionPane.showMessageDialog(null, obj + "\t  ha sido asigando con anterioridad al dia" + " " + dia);
                return true;
            }
        }
        return false;
    }

    public void AgregarTablaCliente(String dia) {

        if (SeleccionDeFila == false) {
            JOptionPane.showMessageDialog(null, "Primero selecione un cliente de la lista.");
        } else {

            if (verificarexistencia(TablaAsignarCliente, dia) == false) {
                btnAceptar_GestorRutas.setEnabled(true);
                String Cliente[] = new String[4];
                Cliente[0] = TablaAsignaciones.getValueAt(FilaSeleccionadaParaEliminar, 8).toString();
                Cliente[1] = TablaAsignaciones.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
                Cliente[2] = TablaAsignaciones.getValueAt(FilaSeleccionadaParaEliminar, 7).toString();
                Cliente[3] = dia;
                modeloVerClientes.addRow(Cliente);
                TablaAsignarCliente.setModel(modeloVerClientes);
            }
        }

    }

    public void AgregarClientes() throws ClassNotFoundException, SQLException {

        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();

        try {
            if (modeloVerClientes.getRowCount() != 0) {
                for (int i = 0; i < TablaAsignarCliente.getRowCount(); i++) {
                    String cedula = TablaAsignarCliente.getValueAt(i, 1).toString();
                    String Local = TablaAsignarCliente.getValueAt(i, 0).toString();
                    String diaLetras = TablaAsignarCliente.getValueAt(i, 3).toString();
                    ResultSet Respuesta;
                  
                    Respuesta = elCoordinador.AgregarClienteARuta(idRuta, cedula, diaAsignacion(TablaAsignarCliente, i));
                    try {
                        if (Respuesta.next()) {

                            if (Respuesta.getString(1).equals("1")) {

                            } else if (Respuesta.getString(1).equals("3")) {

                                JOptionPane.showMessageDialog(null, "El local " + Local + "\t se ha asignado con anterioridad a otra ruta el dia \t" + diaLetras);

                            } else if (Respuesta.getString(1).equals("2")) {

                                JOptionPane.showMessageDialog(null, "El local " + Local + "\t se ha asignado con anterioridad a esta ruta el dia \t" + diaLetras);

                            }
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No tiene permisos");

                        return;
                    }

                }
                JOptionPane.showMessageDialog(null, "Se ha finalizado la operación.");
            }

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        }

    }

    public int diaAsignacion(JTable tabla, int i) {
        int dia = 0;
        if (tabla.getValueAt(i, 3).toString().equals("Lunes")) {
            dia = 2;
        }
        if (tabla.getValueAt(i, 3).toString().equals("Martes")) {
            dia = 3;
        }
        if (tabla.getValueAt(i, 3).toString().equals("Miercoles")) {
            dia = 4;
        }
        if (tabla.getValueAt(i, 3).toString().equals("Jueves")) {
            dia = 5;
        }
        if (tabla.getValueAt(i, 3).toString().equals("Viernes")) {
            dia = 6;
        }
        if (tabla.getValueAt(i, 3).toString().equals("Sabado")) {
            dia = 7;

        }
        if (tabla.getValueAt(i, 3).toString().equals("Domingo")) {
            dia = 1;
        }
        return dia;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        Agregar = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JPopupMenu();
        RemoverCliente = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        RutaDeAsignacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAsignaciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAsignarCliente = new javax.swing.JTable();
        Asignados = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiar_GestorRutas1 = new javax.swing.JButton();
        btnAceptar_GestorRutas = new javax.swing.JButton();
        Martes = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        Lunes = new javax.swing.JCheckBox();
        Miercoles = new javax.swing.JCheckBox();
        Juevez = new javax.swing.JCheckBox();
        Viernes = new javax.swing.JCheckBox();
        Sabado = new javax.swing.JCheckBox();
        Domingo = new javax.swing.JCheckBox();

        Agregar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ingresar-boton-de-flecha-en-esquema-de-cuadrado.png"))); // NOI18N
        Agregar.setText("Asignar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        menu.add(Agregar);

        RemoverCliente.setText("Remover");
        RemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverClienteActionPerformed(evt);
            }
        });
        menuClientes.add(RemoverCliente);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Selecciones los Clientes o/y Camiones que desea asignar a la ruta");

        RutaDeAsignacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RutaDeAsignacion.setText("Ruta");

        TablaAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaAsignaciones.setComponentPopupMenu(menu);
        TablaAsignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAsignacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAsignaciones);

        TablaAsignarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaAsignarCliente.setComponentPopupMenu(menuClientes);
        TablaAsignarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAsignarClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaAsignarCliente);

        Asignados.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Asignados.setText("Clientes asignados");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Asignar");

        btnLimpiar_GestorRutas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btnLimpiar_GestorRutas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar_GestorRutas1ActionPerformed(evt);
            }
        });

        btnAceptar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btnAceptar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar_GestorRutasingresarRutas(evt);
            }
        });

        Martes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Martes.setText("M");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Los dias");

        Lunes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Lunes.setText("L");
        Lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LunesActionPerformed(evt);
            }
        });

        Miercoles.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Miercoles.setText("K");

        Juevez.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Juevez.setText("J");

        Viernes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Viernes.setText("V");

        Sabado.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Sabado.setText("S");

        Domingo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Domingo.setText("D");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Asignados)
                                    .addGap(726, 726, 726))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addGap(28, 28, 28)
                                                .addComponent(Lunes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Martes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Miercoles)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Juevez)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Viernes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Sabado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Domingo)
                                                .addGap(37, 37, 37)))
                                        .addGap(81, 81, 81)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAceptar_GestorRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(btnLimpiar_GestorRutas1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(RutaDeAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(RutaDeAsignacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Martes)
                        .addComponent(jLabel4)
                        .addComponent(Lunes)
                        .addComponent(Miercoles)
                        .addComponent(Juevez)
                        .addComponent(Viernes)
                        .addComponent(Sabado)
                        .addComponent(Domingo)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(Asignados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar_GestorRutas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar_GestorRutas1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiar_GestorRutas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_GestorRutas1ActionPerformed

        InicializarFiltroClientes(TablaAsignarCliente);
    }//GEN-LAST:event_btnLimpiar_GestorRutas1ActionPerformed
    public void Agregar() throws ClassNotFoundException, SQLException {

        AgregarClientes();
        LimpiarTablas();
    }

    public void LimpiarTablas() {
        modeloVerClientes.setRowCount(0);

        InicializarFiltroClientes(TablaAsignarCliente);

    }
    private void btnAceptar_GestorRutasingresarRutas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar_GestorRutasingresarRutas
        try {
            if(TablaAsignarCliente.getRowCount()>0){
            contador = 0;
            Agregar();
            }else{
                JOptionPane.showMessageDialog(null, "<html><h4> Por favor incluya los clientes que desea agregar <br> en la tabla Clientes asignados </h4></html>", "Error", JOptionPane.ERROR_MESSAGE);
            
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionesDeRuta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AsignacionesDeRuta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptar_GestorRutasingresarRutas
    public void OpcionFiltro() {
        if (opcionFiltro == false) {
            if (Lunes.isSelected()) {

                AgregarTablaCliente("Lunes");

            }
            if (Martes.isSelected()) {

                AgregarTablaCliente("Martes");
            }
            if (Miercoles.isSelected()) {

                AgregarTablaCliente("Miercoles");
            }
            if (Juevez.isSelected()) {

                AgregarTablaCliente("Jueves");
            }
            if (Viernes.isSelected()) {

                AgregarTablaCliente("Viernes");
            }
            if (Sabado.isSelected()) {

                AgregarTablaCliente("Sabado");
            }
            if (Domingo.isSelected()) {
                AgregarTablaCliente("Domingo");

            } else if (!Lunes.isSelected() && !Martes.isSelected() && !Miercoles.isSelected()
                    && !Juevez.isSelected() && !Viernes.isSelected() && !Sabado.isSelected()
                    && !Domingo.isSelected()) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione al menos un dia");
            }

        }
    }
    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        OpcionFiltro();
    }//GEN-LAST:event_AgregarActionPerformed

    private void RemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverClienteActionPerformed
        modeloVerClientes.removeRow(TablaAsignarCliente.getSelectedRow());

    }//GEN-LAST:event_RemoverClienteActionPerformed

    private void LunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LunesActionPerformed

    }//GEN-LAST:event_LunesActionPerformed

    private void TablaAsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAsignacionesMouseClicked
        FilaSeleccionadaParaEliminar = TablaAsignaciones.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TablaAsignacionesMouseClicked

    private void TablaAsignarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAsignarClienteMouseClicked
        FilaSeleccionadaParaEliminar = TablaAsignarCliente.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TablaAsignarClienteMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agregar;
    public static javax.swing.JLabel Asignados;
    private javax.swing.JCheckBox Domingo;
    private javax.swing.JCheckBox Juevez;
    private javax.swing.JCheckBox Lunes;
    private javax.swing.JCheckBox Martes;
    private javax.swing.JCheckBox Miercoles;
    private javax.swing.JMenuItem RemoverCliente;
    public static javax.swing.JLabel RutaDeAsignacion;
    private javax.swing.JCheckBox Sabado;
    public static javax.swing.JTable TablaAsignaciones;
    public static javax.swing.JTable TablaAsignarCliente;
    private javax.swing.JCheckBox Viernes;
    public static javax.swing.JButton btnAceptar_GestorRutas;
    public static javax.swing.JButton btnLimpiar_GestorRutas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPopupMenu menuClientes;
    // End of variables declaration//GEN-END:variables
}
