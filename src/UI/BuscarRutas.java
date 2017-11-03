/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeRutas;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Laura
 */
public class BuscarRutas extends javax.swing.JDialog {

    static char c;
    static Object[] filas;
    int FilaSeleccionadaParaEliminar;
    boolean SeleccionDeFila = false;
    static boolean opcionBusqueda = false;
    static boolean opcionFiltro = false;
    static DefaultTableModel modeloRutas;
    static DefaultTableModel modeloVerClientes, modeloVerCamiones;
    public static TableRowSorter trsFiltro;
    static ResultSet resultadoConsulta;
    public BuscarRutas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocale(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        cbxOpcionesBuscarRuta_GestorDeRutas = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBuscarRutas_GestorDeRutas = new javax.swing.JTable();
        txtBuscarRuta_GestorDeRuta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Buscar rutas por");

        cbxOpcionesBuscarRuta_GestorDeRutas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbxOpcionesBuscarRuta_GestorDeRutas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "N°Ruta" }));
        cbxOpcionesBuscarRuta_GestorDeRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda(evt);
            }
        });

        TableBuscarRutas_GestorDeRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableBuscarRutas_GestorDeRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableBuscarRutas_GestorDeRutasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TableBuscarRutas_GestorDeRutas);

        txtBuscarRuta_GestorDeRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarRuta_GestorDeRutaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda

    }//GEN-LAST:event_cbxOpcionesBuscarRuta_GestorDeRutastipoDeBusqueda

    private void TableBuscarRutas_GestorDeRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBuscarRutas_GestorDeRutasMousePressed
        FilaSeleccionadaParaEliminar = TableBuscarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TableBuscarRutas_GestorDeRutasMousePressed

    private void txtBuscarRuta_GestorDeRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRuta_GestorDeRutaKeyTyped


    }//GEN-LAST:event_txtBuscarRuta_GestorDeRutaKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TableBuscarRutas_GestorDeRutas;
    public static javax.swing.JComboBox cbxOpcionesBuscarRuta_GestorDeRutas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField txtBuscarRuta_GestorDeRuta;
    // End of variables declaration//GEN-END:variables
}
