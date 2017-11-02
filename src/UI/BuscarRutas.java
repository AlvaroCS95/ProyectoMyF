/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeRutas;
import static UI.GestorDeRutas.InicailaizarTablaRutas;
import static UI.GestorDeRutas.InicializarFiltroCamiones;
import static UI.GestorDeRutas.InicializarFiltroClientes;
import static UI.GestorDeRutas.TableListarBuscarCamiones;
import static UI.GestorDeRutas.TableListarBuscarClientes;
import static UI.GestorDeRutas.VisualizarTodasLasRutas;

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
        InicailaizarTablaRutas();
        InicializarFiltroClientes(TableListarBuscarClientes);
        InicializarFiltroCamiones(TableListarBuscarCamiones);
        VisualizarTodasLasRutas();  
        
        
    }
     public static void InicializarFiltroClientes(JTable Listar) {
        modeloVerClientes = new DefaultTableModel() {

            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloVerClientes.addColumn("Nombre de local");
        modeloVerClientes.addColumn("Cedula");
        modeloVerClientes.addColumn("Dirección");
        filas = new Object[modeloVerClientes.getColumnCount()];
        Listar.setModel(modeloVerClientes);
    }

    public static void InicializarFiltroCamiones(JTable Listar) {
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
        Listar.setModel(modeloVerCamiones);
    }
     public static void ListarCamionesPorBusqueda() {
        try {
            InicializarFiltroCamiones(TableListarBuscarCamiones);

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            if (txtBuscarRuta_GestorDeRuta.getText().equals("")) {
                return;
            } else {
                if (opcionBusqueda == false) {
                    resultadoConsulta = elCoordinador.ListarCamionesRutasPorNombre(txtBuscarRuta_GestorDeRuta.getText());
                } else if (opcionBusqueda == true) {
                    resultadoConsulta = elCoordinador.ListarCamionesRutasPorId(Integer.parseInt(txtBuscarRuta_GestorDeRuta.getText()));
                }
            }

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
                TableListarBuscarCamiones.setModel(modeloVerCamiones);

            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }
     public static void ListarClientesPorBusqueda() {
        try {
            InicializarFiltroClientes(TableListarBuscarClientes);

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            if (txtBuscarRuta_GestorDeRuta.getText().equals("")) {
                return;
            } else {
                if (opcionBusqueda == false) {
                    if (opcionFiltro == false) {
                        resultadoConsulta = elCoordinador.ListarClientesRutasPorNombre(txtBuscarRuta_GestorDeRuta.getText());
                    } else if (opcionFiltro == true) {
                        resultadoConsulta = elCoordinador.ListarCamionesRutasPorNombre(txtBuscarRuta_GestorDeRuta.getText());
                    }

                } else if (opcionBusqueda == true) {
                    if (opcionFiltro == false) {
                        resultadoConsulta = elCoordinador.ListarClientesRutasPorId(Integer.parseInt(txtBuscarRuta_GestorDeRuta.getText()));
                    } else if (opcionFiltro == true) {
                        resultadoConsulta = elCoordinador.ListarCamionesRutasPorId(Integer.parseInt(txtBuscarRuta_GestorDeRuta.getText()));
                    }
                }
            }

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
                TableListarBuscarClientes.setModel(modeloVerClientes);

            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }

public static void filtro() {
        int columnaABuscar = 0;
        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "N°Ruta") {
            opcionBusqueda = true;
            columnaABuscar = 0;
        }
        if (cbxOpcionesBuscarRuta_GestorDeRutas.getSelectedItem() == "Nombre") {
            opcionBusqueda = false;
            columnaABuscar = 1;
        }

        trsFiltro.setRowFilter(RowFilter.regexFilter(txtBuscarRuta_GestorDeRuta.getText(), columnaABuscar));
    }

   public static void BuscarRuta() {

         txtBuscarRuta_GestorDeRuta.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscarRuta_GestorDeRuta.getText());
                txtBuscarRuta_GestorDeRuta.setText(cadena);

                filtro();
 ListarClientesPorBusqueda();
 ListarCamionesPorBusqueda();
              
            }
        });
        trsFiltro = new TableRowSorter(TableBuscarRutas_GestorDeRutas.getModel());
        TableBuscarRutas_GestorDeRutas.setRowSorter(trsFiltro);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        cbxOpcionesBuscarRuta_GestorDeRutas = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBuscarRutas_GestorDeRutas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableListarBuscarCamiones = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();
        txtBuscarRuta_GestorDeRuta = new javax.swing.JTextField();
        Titulo1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableListarBuscarClientes = new javax.swing.JTable();

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

        TableListarBuscarCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TableListarBuscarCamiones);

        Titulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Titulo.setText("Camiones");

        txtBuscarRuta_GestorDeRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarRuta_GestorDeRutaKeyTyped(evt);
            }
        });

        Titulo1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Titulo1.setText("Clientes");

        TableListarBuscarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(TableListarBuscarClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                        .addComponent(jScrollPane5)
                        .addComponent(jScrollPane3))
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxOpcionesBuscarRuta_GestorDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarRuta_GestorDeRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177)
                .addComponent(Titulo1)
                .addGap(155, 155, 155)
                .addComponent(Titulo)
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(90, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 25, Short.MAX_VALUE)))
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
        BuscarRuta();

    }//GEN-LAST:event_txtBuscarRuta_GestorDeRutaKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TableBuscarRutas_GestorDeRutas;
    public static javax.swing.JTable TableListarBuscarCamiones;
    public static javax.swing.JTable TableListarBuscarClientes;
    public static javax.swing.JLabel Titulo;
    public static javax.swing.JLabel Titulo1;
    public static javax.swing.JComboBox cbxOpcionesBuscarRuta_GestorDeRutas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextField txtBuscarRuta_GestorDeRuta;
    // End of variables declaration//GEN-END:variables
}
