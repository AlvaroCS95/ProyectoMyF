package UI;

import java.awt.Dimension;
import UI.CuentasPorPagar;
import static UI.CuentasPorPagar.VisualizarCuentasPorPagar;
import static UI.CuentasPorPagar.tbCuentasPorPagar;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import static UI.ListarClientes.VisualizarClientes;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Inicio extends javax.swing.JFrame {

    Dimension dim;
    private UI.GestorDeRutas rutas = new UI.GestorDeRutas();

    public Inicio(String NombreUsuario) {
        dim = getToolkit().getScreenSize();
        initComponents();
        setSize(dim.width, dim.height-40);
        this.setTitle("Bienvenido:  " + NombreUsuario + ".");
        JTRutas.addTab("Gestion de rutas", rutas);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTInicio = new javax.swing.JTabbedPane();
        JTFacturacion = new javax.swing.JTabbedPane();
        puntoDeVenta1 = new UI.PuntoDeVenta();
        ingresoFacturaCompra1 = new UI.IngresoFacturaCompra();
        listarFacturasDeCompra1 = new UI.ListarFacturasDeCompra();
        cuentasPorPagar1 = new UI.CuentasPorPagar();
        JTInventario = new javax.swing.JTabbedPane();
        ingresarProductos1 = new UI.IngresarProductos();
        visualizarProductos1 = new UI.VisualizarProductos();
        ingresarDevoluciones1 = new UI.IngresarDevoluciones();
        JTClientes = new javax.swing.JTabbedPane();
        listarClientes1 = new UI.ListarClientes();
        JTUsuarios = new javax.swing.JTabbedPane();
        listarUsuarios1 = new UI.ListarUsuarios();
        JTProveedores = new javax.swing.JTabbedPane();
        listarProveedor1 = new UI.ListarProveedor();
        JTCamiones = new javax.swing.JTabbedPane();
        listarCamiones1 = new UI.ListarCamiones();
        JTRutas = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameInicio"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTInicio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        JTFacturacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        puntoDeVenta1.setPreferredSize(new java.awt.Dimension(1300, 610));
        JTFacturacion.addTab("Facturación", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro.png")), puntoDeVenta1); // NOI18N
        JTFacturacion.addTab("Facturas de compra", ingresoFacturaCompra1);
        JTFacturacion.addTab("Lista de facturas de compra", listarFacturasDeCompra1);

        cuentasPorPagar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cuentasPorPagar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTFacturacion.addTab("Cuentas por pagar", cuentasPorPagar1);

        JTInicio.addTab("Facturación", JTFacturacion);

        JTInventario.addTab("Ingreso de productos", ingresarProductos1);
        JTInventario.addTab("Visualización de productos", visualizarProductos1);
        JTInventario.addTab("Devoluciones", ingresarDevoluciones1);

        JTInicio.addTab("Inventario", JTInventario);

        listarClientes1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarClientes1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTClientes.addTab("Lista de clientes", listarClientes1);

        JTInicio.addTab("Clientes", JTClientes);

        JTUsuarios.addTab("Lista de usuarios", listarUsuarios1);

        JTInicio.addTab("Usuarios", JTUsuarios);

        JTProveedores.addTab("Lista de proveedores", listarProveedor1);

        JTInicio.addTab("Proveedores", JTProveedores);

        JTCamiones.addTab("Lista de camiones", listarCamiones1);

        JTInicio.addTab("Camiones", JTCamiones);
        JTInicio.addTab("Rutas", JTRutas);

        getContentPane().add(JTInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuentasPorPagar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cuentasPorPagar1AncestorAdded
        try {
            VisualizarCuentasPorPagar(tbCuentasPorPagar);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cuentasPorPagar1AncestorAdded

    private void listarClientes1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarClientes1AncestorAdded
         VisualizarClientes(TablaListarClientes_ListarClientes);
    }//GEN-LAST:event_listarClientes1AncestorAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTCamiones;
    private javax.swing.JTabbedPane JTClientes;
    private javax.swing.JTabbedPane JTFacturacion;
    public static javax.swing.JTabbedPane JTInicio;
    private javax.swing.JTabbedPane JTInventario;
    private javax.swing.JTabbedPane JTProveedores;
    private javax.swing.JTabbedPane JTRutas;
    private javax.swing.JTabbedPane JTUsuarios;
    private UI.CuentasPorPagar cuentasPorPagar1;
    private UI.IngresarDevoluciones ingresarDevoluciones1;
    private UI.IngresarProductos ingresarProductos1;
    private UI.IngresoFacturaCompra ingresoFacturaCompra1;
    private UI.ListarCamiones listarCamiones1;
    private UI.ListarClientes listarClientes1;
    private UI.ListarFacturasDeCompra listarFacturasDeCompra1;
    private UI.ListarProveedor listarProveedor1;
    private UI.ListarUsuarios listarUsuarios1;
    private UI.PuntoDeVenta puntoDeVenta1;
    private UI.VisualizarProductos visualizarProductos1;
    // End of variables declaration//GEN-END:variables
}
