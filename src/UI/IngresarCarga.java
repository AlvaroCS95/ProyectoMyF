
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import LogicaDeNegocios.CoordinadorDeInventario;
import Modelos.Carga;
import Modelos.DetalleCarga;
import Modelos.Producto;
import static UI.VisualizarProductos.Tabla1_ActualizacionProductos;
import static UI.VisualizarProductos.VisualizarTodosProductos;
import static UI.VisualizaryEditarCargas.ListarCargas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
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
    String usuario;
    Carga laCarga;
    static int fila;
    public IngresarCarga() {
        initComponents();
         //VisualizarCamion(TablaListarCamiones_ListarCamiones);
        //VisualizarTodosProductos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btLimpiar_IngresarCarga = new javax.swing.JButton();
        btAceptar_IngresarCarga = new javax.swing.JButton();
        btCancelar_IngresarCarga = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaListarCamiones_ListarCamiones = new javax.swing.JTable();
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
        add(btLimpiar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 48, -1));

        btAceptar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarCarga.setToolTipText("Para ingresar una carga");
        btAceptar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btAceptar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1121, 37, 51, -1));

        btCancelar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarCarga.setToolTipText("Para salir de la ventana");
        btCancelar_IngresarCarga.setMinimumSize(new java.awt.Dimension(916, 622));
        btCancelar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btCancelar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1178, 37, 47, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Elegir Camión:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

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
        TablaListarCamiones_ListarCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaListarCamiones_ListarCamionesMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TablaListarCamiones_ListarCamiones);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 838, 133));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Agregar Producto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Filtrar por palabra clave:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        cmbxFiltrarProductos_IngresarCargas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Seleccione...","Código","Nombre","Clasificación","Existencias","Precio","UME"}));
        cmbxFiltrarProductos_IngresarCargas.setSelectedItem("");
        add(cmbxFiltrarProductos_IngresarCargas, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 259, 150, -1));

        txtBuscar_VisualizarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_VisualizarProductosKeyTyped(evt);
            }
        });
        add(txtBuscar_VisualizarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 259, 158, -1));

        btnAgregar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AddIcon.png"))); // NOI18N
        btnAgregar_IngresarCarga.setText("Agregar");
        btnAgregar_IngresarCarga.setToolTipText("Para agregar un producto a la carga");
        btnAgregar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btnAgregar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(827, 257, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 458, 840, 140));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Productos agregados a carga:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, -1, -1));

        btEditar_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btEditar_IngresarCarga.setToolTipText("Para editar producto ingresado a la carga");
        btEditar_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar_IngresarCargaActionPerformed(evt);
            }
        });
        add(btEditar_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, 50, 40));

        EliminarProducto_IngresarCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubo-de-basura.png"))); // NOI18N
        EliminarProducto_IngresarCarga.setToolTipText("Para llenar las tablas con los datos ");
        EliminarProducto_IngresarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProducto_IngresarCargaActionPerformed(evt);
            }
        });
        add(EliminarProducto_IngresarCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 450, 48, -1));
    }// </editor-fold>//GEN-END:initComponents
public void VisualizarCamion(JTable Listar) {
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
   public void Limpiar(){
   VisualizarCamion(TablaListarCamiones_ListarCamiones);
        
        VisualizarTodosProductos();

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
        TablaProductosCargados_IngresarCarga.setModel(modelo);}
    private void btLimpiar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_IngresarCargaActionPerformed
        Limpiar();
    }//GEN-LAST:event_btLimpiar_IngresarCargaActionPerformed

    private void btAceptar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarCargaActionPerformed
        try {
            if(TablaListarCamiones_ListarCamiones.getSelectedRowCount()>0&&TablaProductosCargados_IngresarCarga.getRowCount()>0){

                String placa=TablaListarCamiones_ListarCamiones.getValueAt(TablaListarCamiones_ListarCamiones.getSelectedRow(),0).toString();
                Carga laCarga=new Carga(placa);
                ArrayList <DetalleCarga> laListaDetalle=new ArrayList();
                int filas=TablaProductosCargados_IngresarCarga.getRowCount();
                for(int i=0;i<filas;i++){
                    String elCodigo=TablaProductosCargados_IngresarCarga.getValueAt(i,0).toString();
                    float cantidad=Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(i,3).toString());
                    DetalleCarga detalle=new DetalleCarga(elCodigo,cantidad);
                    laListaDetalle.add(detalle);
                }
                laCarga.setLaListaDeCarga(laListaDetalle);
                CoordinadorDeCamion elCoordinador=new CoordinadorDeCamion();

                if(elCoordinador.InsertarCarga(laCarga)){
                    JOptionPane.showMessageDialog(null, "¡Carga ingresada exitosamente!");
                    Limpiar();
                    VisualizaryEditarCargas.ListarCargas();
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "Recuerde seleccionar un camión "
                                           + "\ny ingresar productos a la carga", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }//GEN-LAST:event_btAceptar_IngresarCargaActionPerformed

    private void TablaListarCamiones_ListarCamionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaListarCamiones_ListarCamionesMousePressed

    }//GEN-LAST:event_TablaListarCamiones_ListarCamionesMousePressed

    private void txtBuscar_VisualizarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_VisualizarProductosKeyTyped
        txtBuscar();
    }//GEN-LAST:event_txtBuscar_VisualizarProductosKeyTyped
    public static boolean estáEnLaTabla(String codigo){
      boolean estáEnLaTabla=false;
     
      int filas=TablaProductosCargados_IngresarCarga.getRowCount();
      for(int i=0;i<filas;i++){
      String elCodigo=TablaProductosCargados_IngresarCarga.getValueAt(i,0).toString();
      if(elCodigo.equals(codigo)){
      estáEnLaTabla= true;
      fila=i;
      }
      }
      return estáEnLaTabla;
      } 
    public static void cargarProducto(float cantidad, float existencias,String codigo, String nombre){
       
                  if(!estáEnLaTabla(codigo)){
                    existencias=existencias-cantidad;
                    modelo = (DefaultTableModel)TablaProductosCargados_IngresarCarga.getModel();
                    filas = new Object[modelo.getColumnCount()];
                    filas[0] = codigo;
                    filas[1] = nombre;
                    filas[2] = existencias;
                    filas[3]= ""+cantidad;
                    modelo.addRow(filas);
                    TablaProductosCargados_IngresarCarga.setModel(modelo);

                    TablaProductos1_IngresarCargas.setValueAt(""+existencias,TablaProductos1_IngresarCargas.getSelectedRow(), 3);
                  }
                  else{
                    existencias=existencias-cantidad;
                    TablaProductosCargados_IngresarCarga.setValueAt(""+existencias, fila, 2);
                     TablaProductosCargados_IngresarCarga.setValueAt(""+cantidad, fila, 3);
                     int fila=DevolverPosicion(codigo);
                    TablaProductos1_IngresarCargas.setValueAt(""+existencias,fila, 3);
                  
                  }
    }
    private void btnAgregar_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_IngresarCargaActionPerformed
        if(TablaProductos1_IngresarCargas.getSelectedRowCount() > 0){
            float existencias=Float.parseFloat(TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 3).toString());
            String codigo=TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 0).toString();
            String nombre=TablaProductos1_IngresarCargas.getValueAt(TablaProductos1_IngresarCargas.getSelectedRow(), 1).toString();
            Producto producto=new Producto(codigo,nombre,0,existencias,0,0, false);
            IngresarDetalleDeCarga detalleCarga=new IngresarDetalleDeCarga(producto);
            detalleCarga.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregar_IngresarCargaActionPerformed
 public static int DevolverPosicion(String codigo){
     int fila=0;
     int filas=TablaProductos1_IngresarCargas.getRowCount();
      for(int i=0;i<filas;i++){
      String elCodigo=TablaProductos1_IngresarCargas.getValueAt(i,0).toString();
      if(elCodigo.equals(codigo)){
      fila=i;
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
        if(TablaProductosCargados_IngresarCarga.getSelectedRowCount() > 0){
            float existencias=Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 2).toString());
            String codigo=TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 0).toString();
            String nombre=TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 1).toString();
            float cantidad=Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 3).toString());
            existencias=existencias+cantidad;
            Producto producto=new Producto(codigo,nombre,0,existencias,0,0,false);
            IngresarDetalleDeCarga detalleCarga=new IngresarDetalleDeCarga(producto);
            detalleCarga.setVisible(true);
        }
    }//GEN-LAST:event_btEditar_IngresarCargaActionPerformed
public void Eliminar() {
        boolean eliminado = false;
        if (TablaProductosCargados_IngresarCarga.getSelectedRowCount() > 0) {
            
                while (TablaProductosCargados_IngresarCarga.getSelectedRowCount() != 0) {
                    DefaultTableModel dtm = (DefaultTableModel) TablaProductosCargados_IngresarCarga.getModel();
                   float cantidad=Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 3).toString());
                    float existencias=Float.parseFloat(TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 2).toString());
                     String codigo=(String) TablaProductosCargados_IngresarCarga.getValueAt(TablaProductosCargados_IngresarCarga.getSelectedRow(), 0);
                    existencias=existencias+cantidad;
                     dtm.removeRow(TablaProductosCargados_IngresarCarga.getSelectedRow());
                     int fila=DevolverPosicion(codigo);
                    TablaProductos1_IngresarCargas.setValueAt(""+existencias,fila, 3);
  
            }
        }
    }

    private void EliminarProducto_IngresarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProducto_IngresarCargaActionPerformed
        Eliminar();
    }//GEN-LAST:event_EliminarProducto_IngresarCargaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarProducto_IngresarCarga;
    public static javax.swing.JTable TablaListarCamiones_ListarCamiones;
    private static javax.swing.JTable TablaProductos1_IngresarCargas;
    private static javax.swing.JTable TablaProductosCargados_IngresarCarga;
    private javax.swing.JButton btAceptar_IngresarCarga;
    private javax.swing.JButton btCancelar_IngresarCarga;
    private javax.swing.JButton btEditar_IngresarCarga;
    private javax.swing.JButton btLimpiar_IngresarCarga;
    private javax.swing.JButton btnAgregar_IngresarCarga;
    private javax.swing.JComboBox<String> cmbxFiltrarProductos_IngresarCargas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField txtBuscar_VisualizarProductos;
    // End of variables declaration//GEN-END:variables
}
