package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import LogicaDeNegocios.CoordinadorDeInventario;
import LogicaDeNegocios.CoordinadorDeRutas;
import LogicaDeNegocios.CoordinadorDeUsuarios;
import LogicaDeNegocios.IMPRIMIR;
import Modelos.Carga;
import Modelos.DetalleCarga;
import Modelos.Producto;
import static UI.GestorDeRutas.filas;
import java.awt.Point;
import java.text.SimpleDateFormat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class IngresarCarga extends javax.swing.JPanel {

    private TableRowSorter trsFiltro;
    static Object[] filas;
    static DefaultTableModel modelo;
    static String usuario, CuerpoDelTextoAImprimir;
    Carga laCarga;
    static int fila, idRUta;
    static String fecha;
    public static Date date = new Date();
    public static DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public IngresarCarga() {
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        Detalles = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        btLimpiar_IngresarCarga = new javax.swing.JButton();
        btAceptar_IngresarCarga = new javax.swing.JButton();
        btCancelar_IngresarCarga = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarCamiones_Cargas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbxFiltrarProductos_IngresarCargas = new javax.swing.JComboBox<>();
        txtBuscar_VisualizarProductos = new javax.swing.JTextField();
        btnAgregar_IngresarCarga = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductos1_IngresarCargas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductosCargados_IngresarCarga = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btEditar_IngresarCarga = new javax.swing.JButton();
        EliminarProducto_IngresarCarga = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaUsuarios_IngresarCarga = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Jdia = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaRutas_IngresarCarga = new javax.swing.JTable();

        Detalles.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Detalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DetalleFactura.png"))); // NOI18N
        Detalles.setText("Mostrar Clientes");
        Detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesActionPerformed(evt);
            }
        });
        Menu.add(Detalles);

        setMaximumSize(new java.awt.Dimension(916, 622));
        setMinimumSize(new java.awt.Dimension(916, 622));
        setPreferredSize(new java.awt.Dimension(916, 622));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Ingresar Carga");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 11, -1, -1));

        btLimpiar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btLimpiar_IngresarCarga.setToolTipText("Para llenar las tablas con los datos ");
        btLimpiar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btLimpiar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 48, -1));

        btAceptar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarCarga.setToolTipText("Para ingresar una carga");
        btAceptar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btAceptar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 540, 51, -1));

        btCancelar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarCarga.setToolTipText("Para salir de la ventana");
        btCancelar_IngresarCarga.setMinimumSize(new java.awt.Dimension(916, 622));
        btCancelar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btCancelar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 540, 47, -1));

        TablaListarCamiones_Cargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaListarCamiones_Cargas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaListarCamiones_CargasMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarCamiones_Cargas);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 838, 133));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Agregar Producto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Filtrar por palabra clave:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        cmbxFiltrarProductos_IngresarCargas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Seleccione...","Código","Nombre","Clasificación","Existencias","Precio","UME"}));
        cmbxFiltrarProductos_IngresarCargas.setSelectedItem("");
        add(cmbxFiltrarProductos_IngresarCargas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 150, -1));

        txtBuscar_VisualizarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarProductosKeyTyped(evt);
            }
        });
        add(txtBuscar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 158, -1));

        btnAgregar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AddIcon.png"))); // NOI18N
        btnAgregar_IngresarCarga.setText("Agregar");
        btnAgregar_IngresarCarga.setToolTipText("Para agregar un producto a la carga");
        btnAgregar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btnAgregar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, -1, -1));

        TablaProductos1_IngresarCargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Clasificación", "Existencias", "Precio", "UME"
            }
        ));
        jScrollPane2.setViewportView(TablaProductos1_IngresarCargas);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 840, 126));

        TablaProductosCargados_IngresarCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Existencias", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProductosCargados_IngresarCarga);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 840, 140));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Productos agregados a carga:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        btEditar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditar_IngresarCarga.setToolTipText("Para editar producto ingresado a la carga");
        btEditar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btEditar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 50, 40));

        EliminarProducto_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubo-de-basura.png"))); // NOI18N
        EliminarProducto_IngresarCarga.setToolTipText("Para llenar las tablas con los datos ");
        EliminarProducto_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProducto_IngresarCargaActionPerformed(evt);
            }
        });
        add(EliminarProducto_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 48, -1));

        TablaUsuarios_IngresarCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario"
            }
        ));
        TablaUsuarios_IngresarCarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaUsuarios_IngresarCargaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TablaUsuarios_IngresarCarga);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 260, 130));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Elegir Camión:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Elegir Usuario:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Fecha de ejecución");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 440, 160, -1));

        Jdia.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JdiaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add(Jdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 150, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Elegir Ruta:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 260, -1, -1));

        TablaRutas_IngresarCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ruta"
            }
        ));
        TablaRutas_IngresarCarga.setComponentPopupMenu(Menu);
        TablaRutas_IngresarCarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaRutas_IngresarCargaMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(TablaRutas_IngresarCarga);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 260, 120));
    }// </editor-fold>//GEN-END:initComponents
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

    public static void VisualizarUsuariosParaCargas() {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            CoordinadorDeUsuarios elCoordinador = new CoordinadorDeUsuarios();
            ResultSet resultadoConsulta = elCoordinador.ListarUsuariosActivosParaCargas();

            modelo.addColumn("Id");
            modelo.addColumn("Usuario");

            filas = new Object[modelo.getColumnCount()];
            TablaUsuarios_IngresarCarga.setModel(modelo);
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) {

                    filas[i] = resultadoConsulta.getObject(i + 1);

                }
                modelo.addRow(filas);
                TablaUsuarios_IngresarCarga.setModel(modelo);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public static void VisualizarRutasParaCargas() throws ClassNotFoundException {
        try {

            DefaultTableModel modeloV = new DefaultTableModel() {

                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            modeloV.addColumn("N°Ruta");
            modeloV.addColumn("Nombre");

            CoordinadorDeRutas elCoordinador = new CoordinadorDeRutas();
            ResultSet resultadoConsulta = elCoordinador.ListarRutasActivas();

            filas = new Object[modeloV.getColumnCount()];
            TablaRutas_IngresarCarga.setModel(modeloV);
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
                TablaRutas_IngresarCarga.setModel(modeloV);
            }
        } catch (SQLException ex) {

        }
    }

    public static void VisualizarTodosProductosCargas() {
        try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Clasificación");
            modelo.addColumn("Existencias");
            modelo.addColumn("Precio");
            modelo.addColumn("UME");

            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = null;

            resultadoConsulta = elCoordinador.ListarProductos();
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
            }
            TablaProductos1_IngresarCargas.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void txtBuscar() {

        txtBuscar_VisualizarProductos.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_VisualizarProductos.getText());
                cadena = cadena.replace("a", "(a|á|A|Á)");
                cadena = cadena.replace("e", "(e|é|E|É)");
                cadena = cadena.replace("i", "(i|í|I|Í)");
                cadena = cadena.replace("o", "(o|ó|O|Ó)");
                cadena = cadena.replace("u", "(u|ú|U|Ú)");
                cadena = cadena.replace("A", "(a|á|A|Á)");
                cadena = cadena.replace("E", "(e|é|E|É)");
                cadena = cadena.replace("I", "(i|í|I|Í)");
                cadena = cadena.replace("O", "(o|ó|O|Ó)");
                cadena = cadena.replace("U", "(u|ú|U|Ú)");

                repaint();
                filtroPalabraClave("(?i).*" + cadena + ".*");
            }
        });
        trsFiltro = new TableRowSorter(TablaProductos1_IngresarCargas.getModel());
        TablaProductos1_IngresarCargas.setRowSorter(trsFiltro);
    }

    public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "Codigo") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "Clasificación") {
            columnaABuscar = 2;
        }
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "Existencias") {
            columnaABuscar = 3;
        }
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "Precio") {
            columnaABuscar = 4;
        }
        if (cmbxFiltrarProductos_IngresarCargas.getSelectedItem() == "UME") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }

    public static void Limpiar() {
        VisualizarCamion(TablaListarCamiones_Cargas);

        VisualizarTodosProductosCargas();

        modelo = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Existencias");
        modelo.addColumn("Cantidad");

        filas = new Object[modelo.getColumnCount()];
        TablaProductosCargados_IngresarCarga.setModel(modelo);
    }
    private void btLimpiar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarCargaActionPerformed
        Limpiar();
    }//GEN-LAST:event_btLimpiar_IngresarCargaActionPerformed
    public static int CantidadDeFilas(String txt) {
        Matcher m = Pattern.compile("\r\n|\r|\n").matcher(txt);
        int lines = 1;
        while (m.find()) {
            lines++;
        }
        return lines;
    }

    public void IngresarCargas() {
        if (TablaListarCamiones_Cargas.getSelectedRowCount() > 0 && TablaProductosCargados_IngresarCarga.getRowCount() > 0
                && TablaUsuarios_IngresarCarga.getSelectedRowCount() > 0 && Jdia.getDate() != null
                && TablaRutas_IngresarCarga.getSelectedRowCount() > 0) {
            fecha = new SimpleDateFormat("yyyy/MM/dd").format(Jdia.getDate());
            try {
                CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();

                String placa = TablaListarCamiones_Cargas.getValueAt(TablaListarCamiones_Cargas.getSelectedRow(), 0).toString();
                int usuario = Integer.parseInt(TablaUsuarios_IngresarCarga.getValueAt(TablaUsuarios_IngresarCarga.getSelectedRow(), 0).toString());
                int Ruta = Integer.parseInt(TablaRutas_IngresarCarga.getValueAt(TablaRutas_IngresarCarga.getSelectedRow(), 0).toString());

                Carga laCarga = new Carga(placa, usuario, fecha, Ruta);
                String NombreUsuario = TablaUsuarios_IngresarCarga.getValueAt(TablaUsuarios_IngresarCarga.getSelectedRow(), 1).toString();
                ArrayList<DetalleCarga> laListaDetalle = new ArrayList();

                int id = elCoordinador.ObtenerUltimoIdCarga();
                int filas = TablaProductosCargados_IngresarCarga.getRowCount();

                CuerpoDelTextoAImprimir = "";
                CuerpoDelTextoAImprimir += "\n-----INFORMACION DE CARGA-----"
                        + "\n\nN.Carga:" + (id + 1)
                        + "\nF.Creacion:" + hourdateFormat.format(date)
                        + "\nU.Responsable:" + NombreUsuario
                        + "\nCamion:" + placa
                        + "\n____________________________\n";
                CuerpoDelTextoAImprimir += "Cod     Cant      Descr";
                // JOptionPane.showMessageDialog(null, id);
                for (int i = 0; i < filas; i++) {
                    String elCodigo = TablaProductosCargados_IngresarCarga.getValueAt(i, 0).toString();
                    float cantidad = Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(i, 3).toString());
                    DetalleCarga detalle = new DetalleCarga(elCodigo, cantidad);
                    laListaDetalle.add(detalle);

                    String Descripcion = TablaProductosCargados_IngresarCarga.getValueAt(i, 1).toString();
                    String des = "";
                    elCodigo = String.format("%1$-4s", elCodigo);
                    if (Descripcion.length() >= 10) {

                        des = Descripcion.replaceAll(" ", "");
                        des = des.substring(0, 10);
                    } else {

                        des = String.format("%1$-10s", Descripcion);

                    }

                    CuerpoDelTextoAImprimir += "\n" + elCodigo + "     " + cantidad + "      " + des;

                }
                CuerpoDelTextoAImprimir += "\n\n\n-------------Fin-------------";

                laCarga.setLaListaDeCarga(laListaDetalle);
                int respuest = elCoordinador.InsertarCarga(laCarga);
                if (respuest == 1) {
                    JOptionPane.showMessageDialog(null, "¡Carga ingresada exitosamente!");
                    IMPRIMIR impresora = new IMPRIMIR(CuerpoDelTextoAImprimir, CantidadDeFilas(CuerpoDelTextoAImprimir), CuerpoDelTextoAImprimir.length());

                    Limpiar();
                    VisualizaryEditarCargas.ListarCargas();
                } else if (respuest == 2) {
                    JOptionPane.showMessageDialog(null, "El usurio seleccionado ya posee una carga\n"
                            + "asignada para el día " + fecha);

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IngresarCarga.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IngresarCarga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Recuerde:\n Seleccionar un camión. "
                    + "\n Ingresar productos a la carga. \n Seleccionar un usuario responsable. \n Seleccionar el día que se ejecutara la carga.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btAceptar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarCargaActionPerformed

        IngresarCargas();


    }//GEN-LAST:event_btAceptar_IngresarCargaActionPerformed

    private void TablaListarCamiones_CargasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarCamiones_CargasMousePressed

    }//GEN-LAST:event_TablaListarCamiones_CargasMousePressed

    private void txtBuscar_VisualizarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarProductosKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarProductosKeyTyped
    public static boolean estáEnLaTabla(String codigo) {
        boolean estáEnLaTabla = false;

        int filas = TablaProductosCargados_IngresarCarga.getRowCount();
        for (int i = 0; i < filas; i++) {
            String elCodigo = TablaProductosCargados_IngresarCarga.getValueAt(i, 0).toString();
            if (elCodigo.equals(codigo)) {
                estáEnLaTabla = true;
                fila = i;
            }
        }
        return estáEnLaTabla;
    }

    public static void cargarProducto(float cantidad, float existencias, String codigo, String nombre, int tipo) {
        if (tipo == 1) {
            if (!estáEnLaTabla(codigo)) {
                existencias = existencias - cantidad;

                modelo = (DefaultTableModel) TablaProductosCargados_IngresarCarga.getModel();
                filas = new Object[modelo.getColumnCount()];
                filas[0] = codigo;
                filas[1] = nombre;
                filas[2] = existencias;
                filas[3] = "" + cantidad;
                modelo.addRow(filas);
                TablaProductosCargados_IngresarCarga.setModel(modelo);
                int fila = DevolverPosicion(codigo);
                TablaProductos1_IngresarCargas.setValueAt("" + existencias, fila, 3);
            } else {
                JOptionPane.showMessageDialog(null, "             ¡¡Producto ingresado anteriormente!!  "
                        + "\n si desea cambiar la cantidad ingresada, edite cantidad del"
                        + "\n       producto en la tabla de productos cargados", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tipo == 2) {
            existencias = existencias - cantidad;

            TablaProductosCargados_IngresarCarga.setValueAt("" + existencias, fila, 2);
            TablaProductosCargados_IngresarCarga.setValueAt("" + cantidad, fila, 3);
            int fila = DevolverPosicion(codigo);
            TablaProductos1_IngresarCargas.setValueAt("" + existencias, fila, 3);

        }
    }
    private void btnAgregar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_IngresarCargaActionPerformed
        if (TablaProductos1_IngresarCargas.getSelectedRowCount() > 0) {
            float existencias = Float.parseFloat(TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 3).toString());
            String codigo = TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 0).toString();
            String nombre = TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 1).toString();
            Producto producto = new Producto(codigo, nombre, 0, existencias, 0, 0, false);
            IngresarDetalleDeCarga detalleCarga = new IngresarDetalleDeCarga(producto, 1);
            detalleCarga.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregar_IngresarCargaActionPerformed
    public static int DevolverPosicion(String codigo) {
        int fila = 0;
        int filas = TablaProductos1_IngresarCargas.getRowCount();
        for (int i = 0; i < filas; i++) {
            String elCodigo = TablaProductos1_IngresarCargas.getValueAt(i, 0).toString();
            if (elCodigo.equals(codigo)) {
                fila = i;
            }
        }
        return fila;
    }

    public void Cancelar() {
        int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            Inicio.JTInicio.setSelectedIndex(0);
        }
    }
    private void btCancelar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarCargaActionPerformed
        Cancelar();
    }//GEN-LAST:event_btCancelar_IngresarCargaActionPerformed

    private void btEditar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar_IngresarCargaActionPerformed
        if (TablaProductosCargados_IngresarCarga.getSelectedRowCount() > 0) {
            float existencias = Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 2).toString());
            String codigo = TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 0).toString();
            String nombre = TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 1).toString();
            float cantidad = Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 3).toString());
            existencias = existencias + cantidad;
            Producto producto = new Producto(codigo, nombre, 0, existencias, 0, 0, false);
            IngresarDetalleDeCarga detalleCarga = new IngresarDetalleDeCarga(producto, 2);
            detalleCarga.setVisible(true);
        }
    }//GEN-LAST:event_btEditar_IngresarCargaActionPerformed
    public void Eliminar() {
        boolean eliminado = false;
        if (TablaProductosCargados_IngresarCarga.getSelectedRowCount() > 0) {

            while (TablaProductosCargados_IngresarCarga.getSelectedRowCount() != 0) {
                DefaultTableModel dtm = (DefaultTableModel) TablaProductosCargados_IngresarCarga.getModel();
                float cantidad = Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 3).toString());
                float existencias = Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 2).toString());
                String codigo = (String) TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 0);
                existencias = existencias + cantidad;
                dtm.removeRow(TablaProductosCargados_IngresarCarga.getSelectedRow());
                int fila = DevolverPosicion(codigo);
                TablaProductos1_IngresarCargas.setValueAt("" + existencias, fila, 3);

            }
        }
    }

    private void EliminarProducto_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProducto_IngresarCargaActionPerformed
        Eliminar();
    }//GEN-LAST:event_EliminarProducto_IngresarCargaActionPerformed

    private void TablaUsuarios_IngresarCargaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaUsuarios_IngresarCargaMousePressed

    }//GEN-LAST:event_TablaUsuarios_IngresarCargaMousePressed

    private void JdiaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JdiaAncestorAdded


    }//GEN-LAST:event_JdiaAncestorAdded

    private void TablaRutas_IngresarCargaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaRutas_IngresarCargaMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
             idRUta = TablaRutas_IngresarCarga.rowAtPoint(p);
//            idRUta = TablaRutas_IngresarCarga.geti();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TablaRutas_IngresarCargaMousePressed

    private void DetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesActionPerformed
        int id = (int) TablaRutas_IngresarCarga.getValueAt(idRUta, 0);
        String Nombre = TablaRutas_IngresarCarga.getValueAt(idRUta, 1).toString();
        DetallesDeRuta losDetalles = new DetallesDeRuta(null, true, id, Nombre);
        losDetalles.setVisible(true);
    }//GEN-LAST:event_DetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Detalles;
    private javax.swing.JButton EliminarProducto_IngresarCarga;
    public static com.toedter.calendar.JDateChooser Jdia;
    private javax.swing.JPopupMenu Menu;
    public static javax.swing.JTable TablaListarCamiones_Cargas;
    private static javax.swing.JTable TablaProductos1_IngresarCargas;
    private static javax.swing.JTable TablaProductosCargados_IngresarCarga;
    public static javax.swing.JTable TablaRutas_IngresarCarga;
    public static javax.swing.JTable TablaUsuarios_IngresarCarga;
    private javax.swing.JButton btAceptar_IngresarCarga;
    private javax.swing.JButton btCancelar_IngresarCarga;
    private javax.swing.JButton btEditar_IngresarCarga;
    private javax.swing.JButton btLimpiar_IngresarCarga;
    private javax.swing.JButton btnAgregar_IngresarCarga;
    private javax.swing.JComboBox<String> cmbxFiltrarProductos_IngresarCargas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField txtBuscar_VisualizarProductos;
    // End of variables declaration//GEN-END:variables
}
