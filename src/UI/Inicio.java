package UI;

import java.awt.Dimension;
import static UI.CuentasPorPagar.VisualizarCuentasPorPagar;
import static UI.CuentasPorPagar.cbxMostar_Cuentas;
import static UI.CuentasPorPagar.tbCuentasPorPagar;
import static UI.GestorDeRutas.InicializarFiltroClientes;
import static UI.GestorDeRutas.TablaDetallesRuta;
import static UI.GestorDeRutas.VisualizarRutasActivas;
import static UI.IngresarCarga.Limpiar;

import static UI.IngresarCarga.TablaListarCamiones_Cargas;
import static UI.IngresarCarga.VisualizarRutasParaCargas;
import static UI.IngresarCarga.VisualizarTodosProductosCargas;
import static UI.IngresarCarga.VisualizarUsuariosParaCargas;

import static UI.IngresarProductos.ListarClasificaciones;
import static UI.IngresarProductos.ListarUMES;
import static UI.IngresoFacturaCompra.ListarProveedores;
import static UI.IngresoFacturaCompra.scroll_IngresoFacturaCompra;
import static UI.ListarCamiones.TablaListarCamiones_ListarCamiones;
import static UI.ListarCamiones.VisualizarCamion;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import static UI.ListarClientes.VisualizarClientes;
import static UI.ListarFacturas.ListarFacturasDelUltimoMes;
import static UI.ListarProveedor.VisualizarProveedores;
import static UI.ListarUsuarios.VisualizarUsuarios;
import static UI.PuntoDeVenta.ListarTiposDePago;
import static UI.IngresoFacturaCompra.ListarTiposDePagoFC;
import static UI.PuntoDeVenta.jSDiasPlazo_PuntoDeVenta;
import static UI.VisualizarProductos.VisualizarTodosProductos;
import static UI.VisualizaryEditarCargas.ListarCargas;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;

public class Inicio extends javax.swing.JFrame implements Runnable {

    Dimension dim;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    public Timer tiempo;
    Thread hiloNumeroUno;

    public Inicio(String NombreUsuario) {
        dim = getToolkit().getScreenSize();
        initComponents();
        setSize(dim.width, dim.height - 40);
        this.setTitle("Bienvenido:  " + NombreUsuario + ".");
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/Logo_Ventana_M&f.jpeg")));
        MostrarHora();
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTInicio = new javax.swing.JTabbedPane();
        JTFacturacion = new javax.swing.JTabbedPane();
        puntoDeVenta1 = new UI.PuntoDeVenta();
        ingresoFacturaCompra1 = new UI.IngresoFacturaCompra();
        listarFacturasDeCompra1 = new UI.ListarFacturas();
        cuentasPorPagar1 = new UI.CuentasPorPagar();
        JTInventario = new javax.swing.JTabbedPane();
        ingresarProductos2 = new UI.IngresarProductos();
        visualizarProductos1 = new UI.VisualizarProductos();
        ingresarDevoluciones1 = new UI.IngresarDevoluciones();
        visualizarYEditarDevoluciones1 = new UI.VisualizarYEditarDevoluciones();
        resumenEstadistico1 = new UI.ResumenEstadistico();
        JTClientes = new javax.swing.JTabbedPane();
        listarClientes1 = new UI.ListarClientes();
        JTUsuarios = new javax.swing.JTabbedPane();
        listarUsuarios1 = new UI.ListarUsuarios();
        JTProveedores = new javax.swing.JTabbedPane();
        listarProveedor1 = new UI.ListarProveedor();
        JTCamiones = new javax.swing.JTabbedPane();
        listarCamiones1 = new UI.ListarCamiones();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingresarCarga1 = new UI.IngresarCarga();
        visualizaryEditarCargas1 = new UI.VisualizaryEditarCargas();
        gestorDeRutas1 = new UI.GestorDeRutas();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameInicio"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTInicio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        JTFacturacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        puntoDeVenta1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                puntoDeVenta1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTFacturacion.addTab("Facturación", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro.png")), puntoDeVenta1); // NOI18N

        ingresoFacturaCompra1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ingresoFacturaCompra1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTFacturacion.addTab("Ingreso de facturas de compra", ingresoFacturaCompra1);

        listarFacturasDeCompra1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarFacturasDeCompra1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTFacturacion.addTab("Lista de facturas ", listarFacturasDeCompra1);

        cuentasPorPagar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cuentasPorPagar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTFacturacion.addTab("Cuentas pendientes", cuentasPorPagar1);

        JTInicio.addTab("Facturación", JTFacturacion);

        JTInventario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        ingresarProductos2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ingresarProductos2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTInventario.addTab("Ingresar Productos", ingresarProductos2);

        visualizarProductos1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                visualizarProductos1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTInventario.addTab("Visualización de productos", visualizarProductos1);
        JTInventario.addTab("Devoluciones", ingresarDevoluciones1);
        JTInventario.addTab("Visualizar Devoluciones", visualizarYEditarDevoluciones1);
        JTInventario.addTab("Resumen de ventas", resumenEstadistico1);

        JTInicio.addTab("Inventario", JTInventario);

        JTClientes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

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

        JTUsuarios.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        listarUsuarios1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarUsuarios1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTUsuarios.addTab("Lista de usuarios", listarUsuarios1);

        JTInicio.addTab("Usuarios", JTUsuarios);

        JTProveedores.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        listarProveedor1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarProveedor1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTProveedores.addTab("Lista de proveedores", listarProveedor1);

        JTInicio.addTab("Proveedores", JTProveedores);

        JTCamiones.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        listarCamiones1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarCamiones1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTCamiones.addTab("Lista de camiones", listarCamiones1);

        ingresarCarga1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                ingresarCarga1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ingresarCarga1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(ingresarCarga1);

        JTCamiones.addTab("Ingresar Cargas", jScrollPane1);

        visualizaryEditarCargas1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                visualizaryEditarCargas1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTCamiones.addTab("Visualización de cargas", visualizaryEditarCargas1);

        JTInicio.addTab("Camiones", JTCamiones);

        gestorDeRutas1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gestorDeRutas1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        JTInicio.addTab("Rutas", gestorDeRutas1);

        getContentPane().add(JTInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu2.setText("Salir");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CerrarSesionIcon.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.setToolTipText("Sale del sistema.");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ExitIcon.png"))); // NOI18N
        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.setToolTipText("Cierra secion.");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Ayuda");

        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seo.png"))); // NOI18N
        jMenuItem4.setText("Manual de usuario");
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("jMenu3");
        jMenu3.setToolTipText("Fecha del sistema");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");
        jMenu4.setToolTipText("Hora del sistema");
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuentasPorPagar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cuentasPorPagar1AncestorAdded
        try {
            VisualizarCuentasPorPagar(tbCuentasPorPagar);
            cbxMostar_Cuentas.setSelectedIndex(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cuentasPorPagar1AncestorAdded

    private void listarClientes1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarClientes1AncestorAdded
        VisualizarClientes(TablaListarClientes_ListarClientes);
    }//GEN-LAST:event_listarClientes1AncestorAdded

    private void listarUsuarios1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarUsuarios1AncestorAdded
        VisualizarUsuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_listarUsuarios1AncestorAdded

    private void listarProveedor1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarProveedor1AncestorAdded
        VisualizarProveedores();        // TODO add your handling code here:
    }//GEN-LAST:event_listarProveedor1AncestorAdded

    private void listarCamiones1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarCamiones1AncestorAdded
        VisualizarCamion(TablaListarCamiones_ListarCamiones);        // TODO add your handling code here:
    }//GEN-LAST:event_listarCamiones1AncestorAdded

    private void ingresarProductos1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresarProductos1AncestorAdded
        IngresarProductos.ListarUMES();
        IngresarProductos.ListarClasificaciones();        // TODO add your handling code here:
    }//GEN-LAST:event_ingresarProductos1AncestorAdded

    private void ingresoFacturaCompra1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresoFacturaCompra1AncestorAdded
        ListarProveedores();
        ListarTiposDePagoFC();
        scroll_IngresoFacturaCompra.getVerticalScrollBar().setUnitIncrement(15);
    }//GEN-LAST:event_ingresoFacturaCompra1AncestorAdded

    private void listarFacturasDeCompra1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarFacturasDeCompra1AncestorAdded
        ListarFacturasDelUltimoMes();        // TODO add your handling code here:
    }//GEN-LAST:event_listarFacturasDeCompra1AncestorAdded

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea Salir?", "Cerrar Salir");
        if (OpcionDelUsuario == JOptionPane.YES_OPTION) {

            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == hiloNumeroUno) {
            calcula();
            jMenu4.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void activar() {
        tiempo.start();
    }

    public void MostrarHora() {
        hiloNumeroUno = new Thread((Runnable) this);
        hiloNumeroUno.start();
        Date fechaActual = new Date();
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        jMenu3.setText(fecha.format(fechaActual));
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        int OpcionDelUsuario = YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea cerrar sesion?", "Cerrar sesion");

        if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
            this.dispose();

            IngresoAlSistema Login = new IngresoAlSistema();
            Login.setVisible(true);

        } else {
            return;
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void gestorDeRutas1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gestorDeRutas1AncestorAdded
        try {
            VisualizarRutasActivas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        InicializarFiltroClientes(TablaDetallesRuta);
    }//GEN-LAST:event_gestorDeRutas1AncestorAdded

    private void visualizarProductos1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_visualizarProductos1AncestorAdded
        VisualizarTodosProductos();      // TODO add your handling code here:
    }//GEN-LAST:event_visualizarProductos1AncestorAdded

    private void ingresarProductos2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresarProductos2AncestorAdded
        ListarClasificaciones();
        ListarUMES();
    }//GEN-LAST:event_ingresarProductos2AncestorAdded

    private void visualizaryEditarCargas1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_visualizaryEditarCargas1AncestorAdded
        ListarCargas();
    }//GEN-LAST:event_visualizaryEditarCargas1AncestorAdded

    private void ingresarCarga1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresarCarga1AncestorAdded
        VisualizarCamion(TablaListarCamiones_Cargas);

        VisualizarTodosProductosCargas();
        VisualizarUsuariosParaCargas();// TODO add your handling code here:
       Limpiar();
        try {
            VisualizarRutasParaCargas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ingresarCarga1AncestorAdded

    private void ingresarCarga1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresarCarga1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresarCarga1AncestorMoved

    private void puntoDeVenta1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_puntoDeVenta1AncestorAdded
        ListarTiposDePago();
    }//GEN-LAST:event_puntoDeVenta1AncestorAdded

    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame) {
        int OpcionDelUsuario = JOptionPane.showConfirmDialog(null, ConsultaAlUsuario, TituloDelFrame, JOptionPane.YES_NO_OPTION);
        return OpcionDelUsuario;
    }
    ;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTCamiones;
    private javax.swing.JTabbedPane JTClientes;
    public javax.swing.JTabbedPane JTFacturacion;
    public static javax.swing.JTabbedPane JTInicio;
    private javax.swing.JTabbedPane JTInventario;
    private javax.swing.JTabbedPane JTProveedores;
    private javax.swing.JTabbedPane JTUsuarios;
    private UI.CuentasPorPagar cuentasPorPagar1;
    private UI.GestorDeRutas gestorDeRutas1;
    private UI.IngresarCarga ingresarCarga1;
    private UI.IngresarDevoluciones ingresarDevoluciones1;
    private UI.IngresarProductos ingresarProductos2;
    private UI.IngresoFacturaCompra ingresoFacturaCompra1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.ListarCamiones listarCamiones1;
    private UI.ListarClientes listarClientes1;
    private UI.ListarFacturas listarFacturasDeCompra1;
    private UI.ListarProveedor listarProveedor1;
    private UI.ListarUsuarios listarUsuarios1;
    private UI.PuntoDeVenta puntoDeVenta1;
    private UI.ResumenEstadistico resumenEstadistico1;
    private UI.VisualizarProductos visualizarProductos1;
    private UI.VisualizarYEditarDevoluciones visualizarYEditarDevoluciones1;
    private UI.VisualizaryEditarCargas visualizaryEditarCargas1;
    // End of variables declaration//GEN-END:variables
}
