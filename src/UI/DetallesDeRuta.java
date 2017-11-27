package UI;

import LogicaDeNegocios.CoordinadorDeRutas;


import static UI.GestorDeRutas.modeloVerClientes;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetallesDeRuta extends javax.swing.JDialog {

    static Object[] filas;
    static ResultSet resultadoConsulta = null;
    static int Id = 0;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    static boolean estado = false;

    public DetallesDeRuta(java.awt.Frame parent, boolean modal, int id, String Nombre) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Ruta.setText(Nombre);
        this.Id = id;
        ListarClientesPorBusqueda(Id);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Ruta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Mostrando los clientes de la ruta:");

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
        TablaDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDetallesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDetalles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
   
    private void TablaDetallesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetallesMousePressed
        FilaSeleccionadaParaEliminar = TablaDetalles.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TablaDetallesMousePressed

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

   
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Ruta;
    public static javax.swing.JTable TablaDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
