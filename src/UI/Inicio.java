package UI;

import java.awt.Dimension;
import UI.CuentasPorPagar;
import static UI.CuentasPorPagar.VisualizarCuentasPorPagar;
import static UI.CuentasPorPagar.tbCuentasPorPagar;
import static UI.GestorDeRutas.InicailaizarTablaRutas;
import static UI.GestorDeRutas.InicializarFiltroCamiones;
import static UI.GestorDeRutas.InicializarFiltroClientes;
import static UI.GestorDeRutas.TableListarBuscarCamiones;
import static UI.GestorDeRutas.TableListarBuscarClientes;
import static UI.GestorDeRutas.VisualizarTodasLasRutas;
import static UI.IngresarProductos.ListarClasificaciones;
import static UI.IngresarProductos.ListarUMES;
import static UI.IngresoFacturaCompra.ListarProveedores;
import static UI.IngresoFacturaCompra.scroll_IngresoFacturaCompra;
import static UI.ListarCamiones.TablaListarCamiones_ListarCamiones;
import static UI.ListarCamiones.VisualizarCamion;
import static UI.ListarClientes.TablaListarClientes_ListarClientes;
import static UI.ListarClientes.VisualizarClientes;
import static UI.ListarFacturasDeCompra.ListarFacturasDelUltimoMes;
import static UI.ListarProveedor.VisualizarProveedores;
import static UI.ListarUsuarios.VisualizarUsuarios;
import static UI.PuntoDeVenta.ListarTiposDePago;
import static UI.PuntoDeVenta.jSDiasPlazo_PuntoDeVenta;
import static UI.VisualizarProductos.VisualizarTodosProductos;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;

public class Inicio extends javax.swing.JFrame implements Runnable{

    Dimension dim;
    private UI.GestorDeRutas rutas = new UI.GestorDeRutas();
    
   String hora, minutos, segundos, ampm;
   Calendar calendario;
   public Timer tiempo;
   Thread hiloNumeroUno;

    public Inicio(String NombreUsuario) {
        dim = getToolkit().getScreenSize();
        initComponents();
        setSize(dim.width, dim.height - 40);
        this.setTitle("Bienvenido:  " + NombreUsuario + ".");
         setIconImage(Toolkit.getDefaultToolkit().getImage
        (this.getClass().getResource("/Imagenes/Logo_Ventana_M&f.jpeg")));
         MostrarHora();


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTInicio = new javax.swing.JTabbedPane();
        JTFacturacion = new javax.swing.JTabbedPane();
        puntoDeVenta1 = new UI.PuntoDeVenta();
        listarFacturasDeCompra1 = new UI.ListarFacturasDeCompra();
        cuentasPorPagar1 = new UI.CuentasPorPagar();
        JTInventario = new javax.swing.JTabbedPane();
        visualizarProductos1 = new UI.VisualizarProductos();
        ingresarDevoluciones1 = new UI.IngresarDevoluciones();
        visualizarYEditarDevoluciones1 = new UI.VisualizarYEditarDevoluciones();
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
        gestorDeRutas1 = new UI.GestorDeRutas();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameInicio"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTInicio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        JTFacturacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        puntoDeVenta1.setPreferredSize(new java.awt.Dimension(1300, 610));
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

        listarFacturasDeCompra1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listarFacturasDeCompra1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
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
        JTFacturacion.addTab("Cuentas pendientes", cuentasPorPagar1);

        JTInicio.addTab("Facturación", JTFacturacion);

        JTInventario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

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
        JTInventario.addTab("Visualizar y Editar Devoluciones", visualizarYEditarDevoluciones1);

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

        jScrollPane1.setViewportView(ingresarCarga1);

        JTCamiones.addTab("Ingresar Cargas", jScrollPane1);

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

        getContentPane().add(JTInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CerrarSesionIcon.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ExitIcon.png"))); // NOI18N
        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

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

    private void listarUsuarios1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarUsuarios1AncestorAdded
        VisualizarUsuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_listarUsuarios1AncestorAdded

    private void listarProveedor1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarProveedor1AncestorAdded
        VisualizarProveedores();        // TODO add your handling code here:
    }//GEN-LAST:event_listarProveedor1AncestorAdded

    private void listarCamiones1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarCamiones1AncestorAdded
        VisualizarCamion(TablaListarCamiones_ListarCamiones);        // TODO add your handling code here:
    }//GEN-LAST:event_listarCamiones1AncestorAdded

    private void gestorDeRutas1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gestorDeRutas1AncestorAdded
        InicailaizarTablaRutas();
        InicializarFiltroClientes(TableListarBuscarClientes);
        InicializarFiltroCamiones(TableListarBuscarCamiones);
        VisualizarTodasLasRutas();        // TODO add your handling code here:
    }//GEN-LAST:event_gestorDeRutas1AncestorAdded

    private void puntoDeVenta1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_puntoDeVenta1AncestorAdded
        ListarTiposDePago();
        ((JSpinner.DefaultEditor) jSDiasPlazo_PuntoDeVenta.getEditor()).getTextField().setEditable(false);
        jSDiasPlazo_PuntoDeVenta.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_puntoDeVenta1AncestorAdded

    private void visualizarProductos1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_visualizarProductos1AncestorAdded
        VisualizarTodosProductos();      // TODO add your handling code here:
    }//GEN-LAST:event_visualizarProductos1AncestorAdded

    private void ingresarProductos1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresarProductos1AncestorAdded
        ListarUMES();
        ListarClasificaciones();        // TODO add your handling code here:
    }//GEN-LAST:event_ingresarProductos1AncestorAdded

    private void ingresoFacturaCompra1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ingresoFacturaCompra1AncestorAdded
        ListarProveedores();
        ListarTiposDePago();
        scroll_IngresoFacturaCompra.getVerticalScrollBar().setUnitIncrement(15);
    }//GEN-LAST:event_ingresoFacturaCompra1AncestorAdded

    private void listarFacturasDeCompra1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listarFacturasDeCompra1AncestorAdded
    ListarFacturasDelUltimoMes();        // TODO add your handling code here:
    }//GEN-LAST:event_listarFacturasDeCompra1AncestorAdded

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int OpcionDelUsuario=YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea Salir?","Cerrar Salir");
	if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
           
       
        System.exit(0);
        
        }
        else{
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
        // TODO add your handling code here:
        
        int OpcionDelUsuario=YesNoQuestionParaConsultaAlUsuario("¿Seguro que desea cerrar sesion?","Cerrar sesion");
        
        if (OpcionDelUsuario == JOptionPane.YES_OPTION) {
            this.dispose();
            
        IngresoAlSistema Login= new IngresoAlSistema();
        Login.setVisible(true);
        
        }
        else{
        return;
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    private int YesNoQuestionParaConsultaAlUsuario(String ConsultaAlUsuario, String TituloDelFrame){
    
    int OpcionDelUsuario = JOptionPane.showConfirmDialog(null,ConsultaAlUsuario,TituloDelFrame,JOptionPane.YES_NO_OPTION);
    return OpcionDelUsuario;
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTCamiones;
    private javax.swing.JTabbedPane JTClientes;
    private javax.swing.JTabbedPane JTFacturacion;
    public static javax.swing.JTabbedPane JTInicio;
    private javax.swing.JTabbedPane JTInventario;
    private javax.swing.JTabbedPane JTProveedores;
    private javax.swing.JTabbedPane JTUsuarios;
    private UI.CuentasPorPagar cuentasPorPagar1;
    private UI.GestorDeRutas gestorDeRutas1;
    private UI.IngresarCarga ingresarCarga1;
    private UI.IngresarDevoluciones ingresarDevoluciones1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private UI.ListarCamiones listarCamiones1;
    private UI.ListarClientes listarClientes1;
    private UI.ListarFacturasDeCompra listarFacturasDeCompra1;
    private UI.ListarProveedor listarProveedor1;
    private UI.ListarUsuarios listarUsuarios1;
    private UI.PuntoDeVenta puntoDeVenta1;
    private UI.VisualizarProductos visualizarProductos1;
    private UI.VisualizarYEditarDevoluciones visualizarYEditarDevoluciones1;
    // End of variables declaration//GEN-END:variables
}
