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

    ResultSet listaProductos = null, listaVentas = null, listaCompras = null, listaNombres = null;
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

    public DefaultTableModel MontarListaDetalles(DefaultTableModel modelo, String fechaDesde, String fechaHasta) {
        try {
            ConsultarListaDeProductos();
            for (int i = 0; i < lista.size(); i++) {
                ObtenerComprasDeProducto(lista.get(i), fechaDesde, fechaHasta);
                ObtenerVentasDeProducto(lista.get(i), fechaDesde, fechaHasta);

                fila[0] = lista.get(i);
                fila[1] = BuscarNombreProducto(lista.get(i));

                if (listaCompras.next()) {
                    fila[2] = ObtenerCantidadComprada();
                    fila[3] = ObtenerInversion();
                } else {
                    fila[2] = "0";
                    fila[3] = "0";
                }

                if (listaVentas.next()) {
                    fila[4] = ObtenerCantidadVendida();
                    fila[5] = ObtenerPrecioVenta();
                    fila[6] = Float.parseFloat(fila[5].toString()) - Float.parseFloat(fila[3].toString());
                } else {
                    fila[4] = "0";
                    fila[5] = "0";
                    fila[6] = "0";
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorEstadistico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public String BuscarNombreProducto(String codigo) {
        GestorEstadistico gestor = new GestorEstadistico();
        listaNombres = gestor.COnsultarCodigoYNombreProducto(codigo);
        try {
            if (listaNombres.next()) {
                codigo = listaNombres.getString(2);
            } else {
                codigo = "Desconocido";
            }
        } catch (SQLException ex) {
            codigo = "Desconocido";
        }
        return codigo;
    }

    public Float ObtenerCantidadComprada() {
        float cantidad = 0;
        try {
            listaCompras.beforeFirst();
            while (listaCompras.next()) {
                cantidad += Float.parseFloat(listaCompras.getString(3));
            }
        } catch (SQLException ex) {
            return cantidad;
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
            return inversion;
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
            return cantidad;
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
            return totalVendido;
        }
        return totalVendido;
    }
}
