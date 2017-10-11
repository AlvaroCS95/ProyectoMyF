package UI;

import LogicaDeNegocios.CoordinadorDeInventario;
import Modelos.Producto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VisualizarProductos extends javax.swing.JPanel {

    private TableRowSorter trsFiltro;
    Object[] filas;
    DefaultTableModel modelo;

    public VisualizarProductos() {

        initComponents();
//        VisualizarTodosProductos();
    }

    public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "Codigo") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "Clasificación") {
            columnaABuscar = 2;
        }
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "Existencias") {
            columnaABuscar = 3;
        }
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "Precio") {
            columnaABuscar = 4;
        }
        if (cmbxFiltrar2_VisualizarProductos1.getSelectedItem() == "UME") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }

    public void cbxFiltrar1() {
        txtBuscarExistencias_VisualizarProductos.setText("");
        panelOculto_VisualizarProductos.setVisible(false);
        cmbxFiltrar2_VisualizarProductos.setVisible(true);
        cmbxFiltrar2_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione..."}));
        cmbxFiltrar2_VisualizarProductos.setSelectedItem("Seleccione...");

        if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Todos")) {
            VisualizarProductos(null);
            cmbxFiltrar2_VisualizarProductos.setVisible(false);
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por clasificación")) {

            ListarClasificaciones();
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por UME")) {

            ListarUMES();
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por código")) {

            ListarIdProductos();
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por nombre")) {

            ListarNombreProductos();
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por existencias")) {
            cmbxFiltrar2_VisualizarProductos.setVisible(false);
            panelOculto_VisualizarProductos.setVisible(true);
            btBuscar_VisualizarProductos.setVisible(true);

        } else {
            cmbxFiltrar2_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
            cmbxFiltrar2_VisualizarProductos.setSelectedItem("");
        }
    }

    public void ELiminar1() {
        boolean eliminado = false;
        if (Tabla1_ActualizacionProductos.getSelectedRowCount() > 0) {
            int eliminarProducto = JOptionPane.showConfirmDialog(null, "¿Desea eliminar item(s) seleccionado(s)\n en la tabla superior?", "Eliminar Producto", 1);
            if (JOptionPane.YES_OPTION == eliminarProducto) {
                while (Tabla1_ActualizacionProductos.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) Tabla1_ActualizacionProductos.getModel();
                    String codigo = (String) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 0);
                    CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                    try {
                        eliminado = elCoordinador.EliminarProducto(codigo);
                    } catch (SQLException ex) {

                    } catch (ClassNotFoundException ex) {

                    }
                    if (eliminado) {
                        dtm.removeRow(Tabla1_ActualizacionProductos.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "¡Producto eliminado correctamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        VisualizarTodosProductos();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Producto seleccionado no se ha podido eliminar correctamente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
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
        trsFiltro = new TableRowSorter(Tabla2_ActualizacionProductos.getModel());
        Tabla2_ActualizacionProductos.setRowSorter(trsFiltro);
    }

    public void cbxFiltrar2() {

        if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por UME")) {
            VisualizarProductos("UME");
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por clasificación")) {
            VisualizarProductos("clasificación");
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por código")) {
            VisualizarProductos("codigo");
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Por nombre")) {
            VisualizarProductos("nombre");
        } else if (cmbxFiltrar1_VisualizarProductos.getSelectedItem().equals("Palabra clave")) {
            txtBuscar_VisualizarProductos.setVisible(true);
        }
    }

    public void btBuscar() {
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
            if (txtBuscarExistencias_VisualizarProductos.getText() != null || txtBuscarExistencias_VisualizarProductos.getText() != "") {
                if (cmbxFiltrar1_VisualizarProductos.getSelectedItem() == "Por existencias") {

                    int cantidad = Integer.parseInt(txtBuscarExistencias_VisualizarProductos.getText());

                    ResultSet resultadoConsulta = elCoordinador.ListarProductosPorExistencias(cantidad);
                    if (resultadoConsulta.next() && resultadoConsulta != null) {
                        resultadoConsulta.beforeFirst();
                        while (resultadoConsulta.next()) {
                            for (int i = 0; i < modelo.getColumnCount(); i++) {

                                filas[i] = resultadoConsulta.getObject(i + 1);

                            }
                            modelo.addRow(filas);

                        }
                    }
                    Tabla1_ActualizacionProductos.setModel(modelo);
                }

            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void txtBuscarExistencias(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
    }

    public void btEditar1() {
        try {
            if (Tabla1_ActualizacionProductos.getSelectedRowCount() > 0) {

                DefaultTableModel dtm = (DefaultTableModel) Tabla1_ActualizacionProductos.getModel();
                Producto elProductoAEditar = new Producto();
                elProductoAEditar.setCodigo((String) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 0));
                elProductoAEditar.setNombre((String) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 1));
                String clasificacion = (String) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 2);
                CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                elProductoAEditar.setIdClasificacion(elCoordinador.ObtenerIdClasificacion(clasificacion));
                elProductoAEditar.setExistencias((int) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 3));
                elProductoAEditar.setPrecio((float) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 4));
                String UME = (String) Tabla1_ActualizacionProductos.getValueAt(Tabla1_ActualizacionProductos.getSelectedRow(), 5);
                elProductoAEditar.setIdUME(elCoordinador.ObtenerIdUME(UME));
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditarProducto(elProductoAEditar).setVisible(true);
                    }
                });
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void btEliminar2() {
        boolean eliminado = false;
        if (Tabla2_ActualizacionProductos.getSelectedRowCount() > 0) {
            int eliminarProducto = JOptionPane.showConfirmDialog(null, "¿Desea eliminar item(s) seleccionado(s)\n en la tabla inferior?", "Eliminar Producto", 1);
            if (JOptionPane.YES_OPTION == eliminarProducto) {
                while (Tabla2_ActualizacionProductos.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) Tabla2_ActualizacionProductos.getModel();
                    String codigo = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 0);
                    CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                    try {
                        eliminado = elCoordinador.EliminarProducto(codigo);
                    } catch (SQLException ex) {

                    } catch (ClassNotFoundException ex) {

                    }
                    if (eliminado) {
                        dtm.removeRow(Tabla2_ActualizacionProductos.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "¡Producto eliminado correctamente!", "Eliminado", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "¡Producto seleccionado no se ha podido eliminar correctamente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }

    public void btEditar2() {
        try {
            if (Tabla2_ActualizacionProductos.getSelectedRowCount() > 0) {

                DefaultTableModel dtm = (DefaultTableModel) Tabla2_ActualizacionProductos.getModel();
                Producto elProductoAEditar = new Producto();
                elProductoAEditar.setCodigo((String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 0));
                elProductoAEditar.setNombre((String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 1));
                String clasificacion = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 2);
                CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
                elProductoAEditar.setIdClasificacion(elCoordinador.ObtenerIdClasificacion(clasificacion));
                elProductoAEditar.setExistencias(Float.parseFloat(Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 3).toString()));
                elProductoAEditar.setPrecio((float) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 4));
                String UME = (String) Tabla2_ActualizacionProductos.getValueAt(Tabla2_ActualizacionProductos.getSelectedRow(), 5);
                elProductoAEditar.setIdUME(elCoordinador.ObtenerIdUME(UME));
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new EditarProducto(elProductoAEditar).setVisible(true);
                    }
                });
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void ListarClasificaciones() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarClasificaciones();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Quite setmodel
            while (resultadoConsulta.next()) {
                cmbxFiltrar2_VisualizarProductos.addItem(resultadoConsulta.getString(2));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void ListarIdProductos() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarProductos();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                cmbxFiltrar2_VisualizarProductos.addItem(resultadoConsulta.getString("IdProducto"));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void ListarNombreProductos() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarProductos();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (resultadoConsulta.next()) {
                cmbxFiltrar2_VisualizarProductos.addItem(resultadoConsulta.getString("Nombre"));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void ListarUMES() {
        try {
            CoordinadorDeInventario elCoordinador = new CoordinadorDeInventario();
            ResultSet resultadoConsulta = elCoordinador.ListarUMES();
            if (resultadoConsulta == null) {
                JOptionPane.showMessageDialog(null, "Verifique que tenga permisos de administrador", "Error de permisos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cmbxFiltrar2_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione..."}));
            cmbxFiltrar2_VisualizarProductos.setSelectedItem("Seleccione...");
            while (resultadoConsulta.next()) {
                cmbxFiltrar2_VisualizarProductos.addItem(resultadoConsulta.getString(2));
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void VisualizarTodosProductos() {
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
            Tabla2_ActualizacionProductos.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void VisualizarProductos(String Filtro) {
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
            if (Filtro == null) {

                resultadoConsulta = elCoordinador.ListarProductos();
            } else if ("UME".equals(Filtro)) {

                String laUME = (String) cmbxFiltrar2_VisualizarProductos.getSelectedItem();
                resultadoConsulta = elCoordinador.ListarProductosPorUME(laUME);

            } else if ("clasificación".equals(Filtro)) {

                String laClasificacion = (String) cmbxFiltrar2_VisualizarProductos.getSelectedItem();
                resultadoConsulta = elCoordinador.ListarProductosPorClasificacion(laClasificacion);

            } else if ("codigo".equals(Filtro)) {

                String codigo = (String) cmbxFiltrar2_VisualizarProductos.getSelectedItem();
                resultadoConsulta = elCoordinador.BuscarProductoPorId(codigo);

            } else if ("nombre".equals(Filtro)) {

                String nombre = (String) cmbxFiltrar2_VisualizarProductos.getSelectedItem();
                resultadoConsulta = elCoordinador.BuscarProductoPorNombre(nombre);

            }
            
            if (resultadoConsulta.next()) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
                Tabla1_ActualizacionProductos.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "No existen productos registrados con esta clasificación",
                        "¡Error en los datos de busqueda!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla2_ActualizacionProductos = new javax.swing.JTable();
        cmbxFiltrar1_VisualizarProductos = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        cmbxFiltrar2_VisualizarProductos = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        btEliminartb1_VisualizarProductos = new javax.swing.JButton();
        btEditartb1_VisualizarProductos = new javax.swing.JButton();
        panelOculto_VisualizarProductos = new javax.swing.JPanel();
        btBuscar_VisualizarProductos = new javax.swing.JButton();
        txtBuscarExistencias_VisualizarProductos = new javax.swing.JTextField();
        txtBuscar_VisualizarProductos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbxFiltrar2_VisualizarProductos1 = new javax.swing.JComboBox<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla1_ActualizacionProductos = new javax.swing.JTable();
        btEliminartb2_VisualizarProductos = new javax.swing.JButton();
        btEditartb2_VisualizarProductos1 = new javax.swing.JButton();
        btActualizar_VisualizarProductos = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla2_ActualizacionProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Clasificación", "Existencias", "Precio", "UME"
            }
        ));
        jScrollPane1.setViewportView(Tabla2_ActualizacionProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 810, 150));

        cmbxFiltrar1_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...","Todos", "Por código", "Por nombre", "Por clasificación","Por UME","Por existencias"}));
        cmbxFiltrar1_VisualizarProductos.setSelectedItem("");
        cmbxFiltrar1_VisualizarProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxFiltrar1_VisualizarProductosItemStateChanged(evt);
            }
        });
        add(cmbxFiltrar1_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 164, -1));

        jLabel2.setText("Filtrar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        cmbxFiltrar2_VisualizarProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cmbxFiltrar2_VisualizarProductos.setSelectedItem("");
        cmbxFiltrar2_VisualizarProductos.setVisible(false);
        cmbxFiltrar2_VisualizarProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxFiltrar2_VisualizarProductosItemStateChanged(evt);
            }
        });
        add(cmbxFiltrar2_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel1.setText("Visualizar Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 230, -1));

        btEliminartb1_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubo-de-basura.png"))); // NOI18N
        btEliminartb1_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminartb1_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btEliminartb1_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 50, 45));

        btEditartb1_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditartb1_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditartb1_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btEditartb1_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, 50, 45));

        panelOculto_VisualizarProductos.setVisible(false);

        btBuscar_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-para-buscar.png"))); // NOI18N
        btBuscar_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscar_VisualizarProductosActionPerformed(evt);
            }
        });

        txtBuscarExistencias_VisualizarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarExistencias_VisualizarProductosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelOculto_VisualizarProductosLayout = new javax.swing.GroupLayout(panelOculto_VisualizarProductos);
        panelOculto_VisualizarProductos.setLayout(panelOculto_VisualizarProductosLayout);
        panelOculto_VisualizarProductosLayout.setHorizontalGroup(
            panelOculto_VisualizarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOculto_VisualizarProductosLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(txtBuscarExistencias_VisualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar_VisualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOculto_VisualizarProductosLayout.setVerticalGroup(
            panelOculto_VisualizarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOculto_VisualizarProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOculto_VisualizarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscar_VisualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOculto_VisualizarProductosLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtBuscarExistencias_VisualizarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        add(panelOculto_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));

        txtBuscar_VisualizarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarProductosKeyTyped(evt);
            }
        });
        add(txtBuscar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 158, -1));

        jLabel3.setText("Filtrar por palabra clave:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        cmbxFiltrar2_VisualizarProductos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Seleccione...","Código","Nombre","Clasificación","Existencias","Precio","UME"}));
        cmbxFiltrar2_VisualizarProductos1.setSelectedItem("");
        cmbxFiltrar2_VisualizarProductos.setVisible(false);
        add(cmbxFiltrar2_VisualizarProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 150, -1));

        Tabla1_ActualizacionProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Clasificación", "Existencias", "Precio", "UME"
            }
        ));
        jScrollPane3.setViewportView(Tabla1_ActualizacionProductos);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 810, 191));

        btEliminartb2_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubo-de-basura.png"))); // NOI18N
        btEliminartb2_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminartb2_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btEliminartb2_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 50, 45));

        btEditartb2_VisualizarProductos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditartb2_VisualizarProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditartb2_VisualizarProductos1ActionPerformed(evt);
            }
        });
        add(btEditartb2_VisualizarProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, 50, 45));

        btActualizar_VisualizarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_VisualizarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_VisualizarProductosActionPerformed(evt);
            }
        });
        add(btActualizar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 390, 57, 42));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbxFiltrar1_VisualizarProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxFiltrar1_VisualizarProductosItemStateChanged
        cbxFiltrar1();
    }//GEN-LAST:event_cmbxFiltrar1_VisualizarProductosItemStateChanged

    private void btEliminartb1_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminartb1_VisualizarProductosActionPerformed
        ELiminar1();
    }//GEN-LAST:event_btEliminartb1_VisualizarProductosActionPerformed

    private void txtBuscar_VisualizarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarProductosKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarProductosKeyTyped

    private void cmbxFiltrar2_VisualizarProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxFiltrar2_VisualizarProductosItemStateChanged
        cbxFiltrar2();
    }//GEN-LAST:event_cmbxFiltrar2_VisualizarProductosItemStateChanged

    private void btBuscar_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscar_VisualizarProductosActionPerformed
        btBuscar();
    }//GEN-LAST:event_btBuscar_VisualizarProductosActionPerformed

    private void txtBuscarExistencias_VisualizarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarExistencias_VisualizarProductosKeyTyped
        txtBuscarExistencias(evt);
    }//GEN-LAST:event_txtBuscarExistencias_VisualizarProductosKeyTyped

    private void btEditartb1_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditartb1_VisualizarProductosActionPerformed
        btEditar1();
    }//GEN-LAST:event_btEditartb1_VisualizarProductosActionPerformed

    private void btEliminartb2_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminartb2_VisualizarProductosActionPerformed
        btEliminar2();
    }//GEN-LAST:event_btEliminartb2_VisualizarProductosActionPerformed

    private void btEditartb2_VisualizarProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditartb2_VisualizarProductos1ActionPerformed
        btEditar2();
    }//GEN-LAST:event_btEditartb2_VisualizarProductos1ActionPerformed

    private void btActualizar_VisualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_VisualizarProductosActionPerformed
        VisualizarTodosProductos();
    }//GEN-LAST:event_btActualizar_VisualizarProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1_ActualizacionProductos;
    private javax.swing.JTable Tabla2_ActualizacionProductos;
    private javax.swing.JButton btActualizar_VisualizarProductos;
    private javax.swing.JButton btBuscar_VisualizarProductos;
    private javax.swing.JButton btEditartb1_VisualizarProductos;
    private javax.swing.JButton btEditartb2_VisualizarProductos1;
    private javax.swing.JButton btEliminartb1_VisualizarProductos;
    private javax.swing.JButton btEliminartb2_VisualizarProductos;
    private javax.swing.JComboBox<String> cmbxFiltrar1_VisualizarProductos;
    private javax.swing.JComboBox<String> cmbxFiltrar2_VisualizarProductos;
    private javax.swing.JComboBox<String> cmbxFiltrar2_VisualizarProductos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelOculto_VisualizarProductos;
    private javax.swing.JTextField txtBuscarExistencias_VisualizarProductos;
    private javax.swing.JTextField txtBuscar_VisualizarProductos;
    // End of variables declaration//GEN-END:variables
}
