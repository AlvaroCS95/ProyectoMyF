package UI;

import java.awt.Dimension;

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
        JTRutas = new javax.swing.JTabbedPane();
        JTCamiones = new javax.swing.JTabbedPane();
        listarCamiones1 = new UI.ListarCamiones();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameInicio"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        puntoDeVenta1.setPreferredSize(new java.awt.Dimension(1300, 610));
        JTFacturacion.addTab("Facturación", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro.png")), puntoDeVenta1); // NOI18N
        JTFacturacion.addTab("Facturas de compra", ingresoFacturaCompra1);
        JTFacturacion.addTab("Lista de facturas de compra", listarFacturasDeCompra1);

        JTInicio.addTab("Facturación", JTFacturacion);

        JTInventario.addTab("Ingreso de productos", ingresarProductos1);
        JTInventario.addTab("Visualización de productos", visualizarProductos1);
        JTInventario.addTab("Devoluciones", ingresarDevoluciones1);

        JTInicio.addTab("Inventario", JTInventario);

        JTClientes.addTab("Lista de clientes", listarClientes1);

        JTInicio.addTab("Clientes", JTClientes);

        JTUsuarios.addTab("Lista de usuarios", listarUsuarios1);

        JTInicio.addTab("Usuarios", JTUsuarios);

        JTProveedores.addTab("Lista de proveedores", listarProveedor1);

        JTInicio.addTab("Proveedores", JTProveedores);
        JTInicio.addTab("Rutas", JTRutas);

        JTCamiones.addTab("Lista de camiones", listarCamiones1);

        JTInicio.addTab("Camiones", JTCamiones);

        getContentPane().add(JTInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTCamiones;
    private javax.swing.JTabbedPane JTClientes;
    private javax.swing.JTabbedPane JTFacturacion;
    public static javax.swing.JTabbedPane JTInicio;
    private javax.swing.JTabbedPane JTInventario;
    private javax.swing.JTabbedPane JTProveedores;
    private javax.swing.JTabbedPane JTRutas;
    private javax.swing.JTabbedPane JTUsuarios;
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
