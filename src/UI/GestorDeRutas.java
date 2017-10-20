package UI;

import LogicaDeNegocios.CoordinadorDeRutas;
import Modelos.Ruta;
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

public class GestorDeRutas extends javax.swing.JPanel {

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

    public GestorDeRutas() {

        initComponents();
        InicailaizarTablaRutas();
        InicializarFiltroClientes(TableListarBuscarClientes);
        InicializarFiltroCamiones(TableListarBuscarCamiones);
        VisualizarTodasLasRutas();
    }

    public void IngresarRuta() throws ClassNotFoundException, SQLException {
        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
        ResultSet respuesta;
        Ruta laRuta = new Ruta(txtNombreRuta_GestorRuta.getText(), txtDescripcion_GestorRuta.getText());
        respuesta = elCoordinador.IngresarRutas(laRuta);
        if (respuesta.next()) {
            if (respuesta.getString(1).equals("2")) {
                JOptionPane.showMessageDialog(null, "La ruta se inserto correctamente");

                VisualizarRutas();
                VisualizarTodasLasRutas();
                LimpiarCampos();               
            } else {
                JOptionPane.showMessageDialog(null, "Error en la inserción");
            }
        }

    }

    public void eliminarRutas(int id) throws ClassNotFoundException, SQLException {
        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
        ResultSet respuesta;
        respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
        if (respuesta.next()) {
            if (respuesta.getString(1).equals("2")) {
                JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                VisualizarRutas();
                VisualizarTodasLasRutas();
                txtBuscarRuta_GestorDeRuta.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la eliminación");
            }
        }
    }

    public void activarRutas(int id) throws ClassNotFoundException, SQLException {
        CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
        ResultSet respuesta;
        respuesta = elCoordinador.CambiarEstadoRutaPorId(id);
        if (respuesta.next()) {
            if (respuesta.getString(1).equals("2")) {
                JOptionPane.showMessageDialog(null, "Activacion exitosa");
                VisualizarRutas();
                VisualizarTodasLasRutas();
                txtBuscarRuta_GestorDeRuta.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la activacion");
            }
        }
    }

    public static void InicailaizarTablaRutas() {

        modeloRutas = new DefaultTableModel() {

            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloRutas.addColumn("N°Ruta");
        modeloRutas.addColumn("Nombre");
        modeloRutas.addColumn("Descripción");
        TableBuscarRutas_GestorDeRutas.setModel(modeloRutas);

    }

    public static void VisualizarRutas() {
        try {

            DefaultTableModel modeloV = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloV.addColumn("N°Ruta");
            modeloV.addColumn("Nombre");
            modeloV.addColumn("Descripción");

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarRutas();

            filas = new Object[modeloV.getColumnCount()];
            TableListarRutas_GestorDeRutas.setModel(modeloV);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modeloV.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modeloV.addRow(filas);
                TableListarRutas_GestorDeRutas.setModel(modeloV);
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

    public static void VisualizarTodasLasRutas() {
        try {

            DefaultTableModel modeloV = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloV.addColumn("N°Ruta");
            modeloV.addColumn("Nombre");
            modeloV.addColumn("Descripción");
            modeloV.addColumn("Estado");

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarTodasLasRutas();

            filas = new Object[modeloV.getColumnCount()];
            TableBuscarRutas_GestorDeRutas.setModel(modeloV);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador",
                        "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modeloV.getColumnCount(); i++) {

                    if ((i + 1) == 4) {
                        if (resultadoConsulta.getBoolean(i + 1) == true) {
                            filas[i] = "Activo";

                        } else {
                            filas[i] = "Inactivo";
                        }
                    } else {
                        filas[i] = resultadoConsulta.getObject(i + 1);
                    }

                }
                modeloV.addRow(filas);
                TableBuscarRutas_GestorDeRutas.setModel(modeloV);
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuListar = new javax.swing.JPopupMenu();
        menuEditar_GestorRutas = new javax.swing.JMenuItem();
        menuEliminar_GestorRutas = new javax.swing.JMenuItem();
        Asignar = new javax.swing.JMenuItem();
        MenuBuscar = new javax.swing.JPopupMenu();
        Asignar1 = new javax.swing.JMenuItem();
        menuEliminar_GestorRutas1 = new javax.swing.JMenuItem();
        menuEditar_GestorRutas1 = new javax.swing.JMenuItem();
        Activar = new javax.swing.JMenuItem();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbxOpcionesBuscarRuta_GestorDeRutas = new javax.swing.JComboBox();
        btnLimpiar_GestorRutas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBuscarRutas_GestorDeRutas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableListarBuscarCamiones = new javax.swing.JTable();
        txtNombreRuta_GestorRuta = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableListarRutas_GestorDeRutas = new javax.swing.JTable();
        txtBuscarRuta_GestorDeRuta = new javax.swing.JTextField();
        btnAceptar_GestorRutas = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion_GestorRuta = new javax.swing.JTextArea();
        Titulo1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableListarBuscarClientes = new javax.swing.JTable();

        MenuListar.setBackground(new java.awt.Color(0, 0, 102));

        menuEditar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar16.png"))); // NOI18N
        menuEditar_GestorRutas.setText("Editar");
        menuEditar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditar_GestorRutasActionPerformed(evt);
            }
        });
        MenuListar.add(menuEditar_GestorRutas);

        menuEliminar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        menuEliminar_GestorRutas.setText("Eliminar");
        menuEliminar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarRuta(evt);
            }
        });
        MenuListar.add(menuEliminar_GestorRutas);

        Asignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        Asignar.setText("Asignar clientes y camiones");
        Asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarActionPerformed(evt);
            }
        });
        MenuListar.add(Asignar);

        Asignar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        Asignar1.setText("Asignar clientes y camiones");
        Asignar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Asignar1ActionPerformed(evt);
            }
        });
        MenuBuscar.add(Asignar1);

        menuEliminar_GestorRutas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        menuEliminar_GestorRutas1.setText("Eliminar");
        menuEliminar_GestorRutas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminar_GestorRutas1EliminarRuta(evt);
            }
        });
        MenuBuscar.add(menuEliminar_GestorRutas1);

        menuEditar_GestorRutas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar16.png"))); // NOI18N
        menuEditar_GestorRutas1.setText("Editar");
        menuEditar_GestorRutas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditar_GestorRutas1ActionPerformed(evt);
            }
        });
        MenuBuscar.add(menuEditar_GestorRutas1);

        Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActivarMenu.png"))); // NOI18N
        Activar.setText("Activar");
        Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivarActionPerformed(evt);
            }
        });
        MenuBuscar.add(Activar);

        setPreferredSize(new java.awt.Dimension(923, 638));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Buscar rutas por");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 20, 530));

        cbxOpcionesBuscarRuta_GestorDeRutas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbxOpcionesBuscarRuta_GestorDeRutas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "N°Ruta" }));
        cbxOpcionesBuscarRuta_GestorDeRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDeBusqueda(evt);
            }
        });
        add(cbxOpcionesBuscarRuta_GestorDeRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 84, -1));

        btnLimpiar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btnLimpiar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar_GestorRutasActionPerformed(evt);
            }
        });
        add(btnLimpiar_GestorRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 50, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Ingresar rutas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

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
        TableBuscarRutas_GestorDeRutas.setComponentPopupMenu(MenuBuscar);
        TableBuscarRutas_GestorDeRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableBuscarRutas_GestorDeRutasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TableBuscarRutas_GestorDeRutas);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 371, 97));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nombre ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 371, 130));
        add(txtNombreRuta_GestorRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 270, -1));

        Titulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Titulo.setText("Camiones");
        add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 80, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Lista de rutas activas");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        TableListarRutas_GestorDeRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableListarRutas_GestorDeRutas.setComponentPopupMenu(MenuListar);
        TableListarRutas_GestorDeRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableListarRutas_GestorDeRutasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableListarRutas_GestorDeRutas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 500, 312));

        txtBuscarRuta_GestorDeRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarRuta_GestorDeRutaKeyTyped(evt);
            }
        });
        add(txtBuscarRuta_GestorDeRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 371, 28));

        btnAceptar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btnAceptar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarRutas(evt);
            }
        });
        add(btnAceptar_GestorRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 50, -1));

        txtDescripcion_GestorRuta.setColumns(20);
        txtDescripcion_GestorRuta.setRows(5);
        jScrollPane4.setViewportView(txtDescripcion_GestorRuta);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 270, 58));

        Titulo1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Titulo1.setText("Clientes");
        add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 80, -1));

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

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 371, 110));
    }// </editor-fold>//GEN-END:initComponents
       public void LimpiarCampos() {
        txtNombreRuta_GestorRuta.setText("");

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
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        VisualizarRutas();        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void ingresarRutas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarRutas
        try {
            IngresarRuta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ingresarRutas


    private void tipoDeBusqueda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDeBusqueda

    }//GEN-LAST:event_tipoDeBusqueda

    private void EliminarRuta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarRuta
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        try {
            eliminarRutas(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EliminarRuta

    private void TableListarRutas_GestorDeRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListarRutas_GestorDeRutasMousePressed
        FilaSeleccionadaParaEliminar = TableListarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;
    }//GEN-LAST:event_TableListarRutas_GestorDeRutasMousePressed

    private void menuEditar_GestorRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditar_GestorRutasActionPerformed
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String nombre = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String descripcion = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        EditarRutas Editar = new EditarRutas(null, true, id, nombre, descripcion);
        Editar.setVisible(true);
    }//GEN-LAST:event_menuEditar_GestorRutasActionPerformed

    private void btnLimpiar_GestorRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_GestorRutasActionPerformed
        txtDescripcion_GestorRuta.setText("");
        txtNombreRuta_GestorRuta.setText("");
    }//GEN-LAST:event_btnLimpiar_GestorRutasActionPerformed

    private void AsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarActionPerformed
        int id = (int) TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String nombre = TableListarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        AsignacionesDeRuta Asignacion = new AsignacionesDeRuta(null, true, id, nombre);
        Asignacion.setVisible(true);
    }//GEN-LAST:event_AsignarActionPerformed

    private void Asignar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Asignar1ActionPerformed
        int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String nombre = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        AsignacionesDeRuta Asignacion = new AsignacionesDeRuta(null, true, id, nombre);
        Asignacion.setVisible(true);
    }//GEN-LAST:event_Asignar1ActionPerformed

    private void menuEliminar_GestorRutas1EliminarRuta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminar_GestorRutas1EliminarRuta
        int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        try {
            eliminarRutas(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuEliminar_GestorRutas1EliminarRuta

    private void menuEditar_GestorRutas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditar_GestorRutas1ActionPerformed
        int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        String nombre = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 1).toString();
        String descripcion = TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 2).toString();
        EditarRutas Editar = new EditarRutas(null, true, id, nombre, descripcion);
        Editar.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuEditar_GestorRutas1ActionPerformed

    private void txtBuscarRuta_GestorDeRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRuta_GestorDeRutaKeyTyped
        BuscarRuta();
        
    }//GEN-LAST:event_txtBuscarRuta_GestorDeRutaKeyTyped

    private void ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivarActionPerformed
        int id = (int) TableBuscarRutas_GestorDeRutas.getValueAt(FilaSeleccionadaParaEliminar, 0);
        try {
            activarRutas(id);        // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActivarActionPerformed

    private void TableBuscarRutas_GestorDeRutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBuscarRutas_GestorDeRutasMousePressed
        FilaSeleccionadaParaEliminar = TableBuscarRutas_GestorDeRutas.getSelectedRow();
        SeleccionDeFila = true;        // TODO add your handling code here:
    }//GEN-LAST:event_TableBuscarRutas_GestorDeRutasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Activar;
    private javax.swing.JMenuItem Asignar;
    private javax.swing.JMenuItem Asignar1;
    private javax.swing.JPopupMenu MenuBuscar;
    private javax.swing.JPopupMenu MenuListar;
    public static javax.swing.JTable TableBuscarRutas_GestorDeRutas;
    public static javax.swing.JTable TableListarBuscarCamiones;
    public static javax.swing.JTable TableListarBuscarClientes;
    public static javax.swing.JTable TableListarRutas_GestorDeRutas;
    public static javax.swing.JLabel Titulo;
    public static javax.swing.JLabel Titulo1;
    public static javax.swing.JButton btnAceptar_GestorRutas;
    public static javax.swing.JButton btnLimpiar_GestorRutas;
    public static javax.swing.JComboBox cbxOpcionesBuscarRuta_GestorDeRutas;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JMenuItem menuEditar_GestorRutas;
    public static javax.swing.JMenuItem menuEditar_GestorRutas1;
    public static javax.swing.JMenuItem menuEliminar_GestorRutas;
    public static javax.swing.JMenuItem menuEliminar_GestorRutas1;
    public static javax.swing.JTextField txtBuscarRuta_GestorDeRuta;
    public static javax.swing.JTextArea txtDescripcion_GestorRuta;
    public static javax.swing.JTextField txtNombreRuta_GestorRuta;
    // End of variables declaration//GEN-END:variables

}
