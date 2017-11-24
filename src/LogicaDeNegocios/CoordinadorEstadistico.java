package LogicaDeNegocios;

import AccesoDatos.GestorEstadistico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CoordinadorEstadistico {

    ResultSet listaProductos = null, listaVentas = null, listaCompras = null;
    ArrayList<String> lista;
    Object[] fila = new Object[7];
    GestorEstadistico gestor = new GestorEstadistico();
    

    public void ConsultarListaDeProductos() {
        try {
            listaProductos = gestor.ConsultarListaDeProductos();
            lista = new ArrayList<>();
            while (listaProductos.next()) {
                for (int i = 0; i < 1; i++) {
                    lista.add(listaProductos.getString(i + 1));
//                    JOptionPane.showMessageDialog(null, listaProductos.getObject(i + 1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ObtenerVentasDeProducto(String codigoProducto, String fechaDesde, String fechaHasta) {
        listaVentas = gestor.ConsultarListaDeVentas(codigoProducto, fechaDesde, fechaHasta);
    }

    public void ObtenerComprasDeProducto(String codigoProducto, String fechaDesde, String fechaHasta) {
        listaCompras = gestor.ConsultarListaDeCompras(codigoProducto, fechaDesde, fechaHasta);
    }

    public DefaultTableModel MontarListaDetalles(DefaultTableModel modelo,String fechaDesde, String fechaHasta) {
        try {
            ConsultarListaDeProductos();
            for (int i = 0; i < lista.size(); i++) {
                ObtenerComprasDeProducto(lista.get(i), fechaDesde, fechaHasta);
                ObtenerVentasDeProducto(lista.get(i), fechaDesde, fechaHasta);
                if (listaCompras.next() || listaVentas.next()) {

                    fila[0] = listaCompras.getObject(1);
                    // cantidad comprada

                    fila[1] = listaCompras.getObject(2);
                    fila[2] = ObtenerCantidadComprada();

                    // Inversion realizada
                    fila[3] = ObtenerInversion();

                    // Cantidad vendida
                    fila[4] = ObtenerCantidadVendida();

                    // Ganancia obtendia
                    fila[5] = ObtenerPrecioVenta();

                    fila[6] = Float.parseFloat(fila[5].toString()) - Float.parseFloat(fila[3].toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Lista vacía");
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public Float ObtenerCantidadComprada() {
        float cantidad = 0;
        try {
            listaCompras.beforeFirst();
            while (listaCompras.next()) {
                cantidad += Float.parseFloat(listaCompras.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    public Float ObtenerInversion() {
        float inversion = 0;
        try {
            listaCompras.beforeFirst();
            while (listaCompras.next()) {
                inversion += (Float.parseFloat(listaCompras.getString(3)) * Float.parseFloat(listaCompras.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inversion;
    }

    public Float ObtenerCantidadVendida() {
        float cantidad = 0;
        try {
            listaVentas.beforeFirst();
            while (listaVentas.next()) {
                cantidad += Float.parseFloat(listaVentas.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    public Float ObtenerPrecioVenta() {
        float totalVendido = 0;
        try {
            listaVentas.beforeFirst();
            while (listaVentas.next()) {
                totalVendido += Float.parseFloat(listaVentas.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalVendido;
    }
}
