package UI;

import LogicaDeNegocios.CoordinadorDeRutas;

import static UI.GestorDeRutas.VisualizarRutasActivas;
import static UI.GestorDeRutas.modeloVerCamiones;
import static UI.GestorDeRutas.modeloVerClientes;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetallesDeRuta extends javax.swing.JDialog {

    static Object[] filas;
    static ResultSet resultadoConsulta = null;
    static int Id = 0;

    public DetallesDeRuta(java.awt.Frame parent, boolean modal, int id, String Nombre) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Ruta.setText(Nombre);
        this.Id = id;
        //ListarClientesPorBusqueda(Id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        DetallesRuta = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Ruta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalles = new javax.swing.JTable();

        Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DeleteIcon.png"))); // NOI18N
        Eliminar.setText("Eliminar de la ruta ");
        Menu.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Mostrando los ");

        DetallesRuta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DetallesRuta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clientes", "Camiones" }));
        DetallesRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesRutaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("de la ruta");

        Ruta.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Ruta.setText("Ruta");

        TablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaDetalles.setComponentPopupMenu(Menu);
        jScrollPane1.setViewportView(TablaDetalles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DetallesRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetallesRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DetallesRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesRutaActionPerformed

        if (DetallesRuta.getSelectedItem().equals("Clientes")) {
            ListarClientesPorBusqueda(Id);

        } else if (DetallesRuta.getSelectedItem().equals("Camiones")) {
            ListarCamionesPorBusqueda(Id);

        }
    }//GEN-LAST:event_DetallesRutaActionPerformed
    public void activarRutas(int id) throws ClassNotFoundException, SQLException {
        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
        ResultSet respuesta;
        respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
        if (respuesta.next()) {
            if (respuesta.getString(1).equals("2")) {
                JOptionPane.showMessageDialog(null, "Activacion exitosa");

                VisualizarRutasActivas();

            } else {
                JOptionPane.showMessageDialog(null, "Error en la activacion");
            }
        }
    }

    public static void ListarClientesPorBusqueda(int id) {
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

            resultadoConsulta = elCoordinador.ListarClientesRutasPorId(Id);

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
            TablaDetalles.setModel(modeloVerClientes);
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }

    public static void ListarCamionesPorBusqueda(int Id) {
        try {

            modeloVerCamiones = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloVerCamiones.addColumn("N° Placa");
            modeloVerCamiones.addColumn("Marca");
            modeloVerCamiones.addColumn("Estilo");
            modeloVerCamiones.addColumn("Modelo");
            filas = new Object[modeloVerCamiones.getColumnCount()];
            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();

            resultadoConsulta = elCoordinador.ListarCamionesRutasPorId(Id);

            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {

                for (int i = 0; i < modeloVerCamiones.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modeloVerCamiones.addRow(filas);

            }
            TablaDetalles.setModel(modeloVerCamiones);
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DetallesRuta;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JPopupMenu Menu;
    public static javax.swing.JLabel Ruta;
    public static javax.swing.JTable TablaDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
