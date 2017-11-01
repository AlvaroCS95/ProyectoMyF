package LogicaDeNegocios;

import AccesoDatos.GestorFacturaDeCompra;
import Modelos.FacturaDeCompra;
import Modelos.Producto;
import UI.DetallesFacturaCompra;
import UI.EditarFacturaDeCompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CoordinadorDeFacturaCompra {

    ArrayList<Object> listaParaRetornar = new ArrayList<>();
    ResultSet resultado;

    public CoordinadorDeFacturaCompra() {
    }

    public boolean CrearFacturaCompra(FacturaDeCompra nuevaFactura) {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        if (nuevaFactura.isTipoDeCompra()) {
            resultado = gestor.CrearFacturaCompraContado(nuevaFactura);
        } else {
            resultado = gestor.CrearFacturaCompraCredito(nuevaFactura);
        }

        try {
            if (resultado.next()) {
                if ("2".equals(resultado.getString(1))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Object> ListarNombreDeProveedores() {
        try {
            listaParaRetornar.clear();
            GestorFacturaDeCompra listaDeProveedores = new GestorFacturaDeCompra();
            resultado = listaDeProveedores.ListarNombreDeProveedores();

            while (resultado.next()) {
                for (int i = 0; i < 1; i++) {
                    listaParaRetornar.add(resultado.getObject(i + 1));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaParaRetornar;
    }

    public ArrayList<Object> ListarTiposDePago() {
        try {
            listaParaRetornar.clear();
            GestorFacturaDeCompra listaDeProveedores = new GestorFacturaDeCompra();
            resultado = listaDeProveedores.ListarTiposDePago();

            while (resultado.next()) {
                for (int i = 0; i < 1; i++) {
                    listaParaRetornar.add(resultado.getObject(i + 1));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaParaRetornar;
    }

    public int ObtenerIdTipoPago(String nombreTipoPago) {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ObtenerIDTipoPago(nombreTipoPago);
        try {
            if (resultado.next()) {
                return resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; // error!
    }

    public int ObtnerIdProveedor(String nombreProveedor) {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ObtenerIDProveedor(nombreProveedor);
        try {
            if (resultado.next()) {
                return resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1; // error!
    }

    public ResultSet ListarFacturasCompra() {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ListarFacturasDeCompra();

        return resultado;
    }

    public ResultSet ListarFacturasCompraDelUltimoMes() {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ListarFacturasUltimoMes();

        return resultado;
    }

    public ResultSet Buscar(int tipoBusqueda, String criterioUno, String criterioDos) {
        GestorFacturaDeCompra gestorDeBusqueda = new GestorFacturaDeCompra();

        switch (tipoBusqueda) {
            case 1:
                resultado = gestorDeBusqueda.BuscarFacturaCompraCodigoUsuario(criterioUno);// busqueda por cod Usuario
                break;
            case 2:
                resultado = gestorDeBusqueda.BuscarFacturaCompraNFactura(criterioUno); // busqueda por N de factura
                break;
            case 3:
                resultado = gestorDeBusqueda.BuscarFacturaNombreProveedor(criterioUno); // busqueda por Nombre del proveedor
                break;
            case 4:
                resultado = gestorDeBusqueda.BuscarFacturaPorFecha(criterioUno, criterioDos); // busqueda por fecha
                break;

        }
        return resultado;
    }

    public void BuscarParaEditar(String NFactura) {
        String idFacturaCompra, nuPedido, nuEntrega, fechaDeCompra, nombreProveedor, nombreTipoPago, NDeReferencia;
        boolean TipoDeCompra;
        float MontoTotal;
        GestorFacturaDeCompra gestorDeBusqueda = new GestorFacturaDeCompra();
        resultado = gestorDeBusqueda.BuscarFacturaParaEditarCompraNFactura(NFactura);

        try {
            if (resultado.next()) {

                idFacturaCompra = resultado.getString(1);
                fechaDeCompra = resultado.getString(2);
                TipoDeCompra = resultado.getBoolean(3);
                nombreProveedor = resultado.getString(4);
                MontoTotal = resultado.getFloat(5);
                nuPedido = resultado.getString(6);
                nuEntrega = resultado.getString(7);
                nombreTipoPago = resultado.getString(8);
                NDeReferencia = resultado.getString(9);
                EditarFacturaDeCompra facturaAEditar = new EditarFacturaDeCompra(null, true);
                facturaAEditar.LlenarDatosParaEdicion(idFacturaCompra, nuPedido, nuEntrega, nombreProveedor, nombreTipoPago,
                        NDeReferencia, fechaDeCompra, TipoDeCompra, MontoTotal);
                facturaAEditar.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet BuscarParaAgregarDetalle(String codigo) {

        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.BuscarProductoParaAgregarDetalle(codigo);
        try {
            if (!resultado.next()) {
                resultado = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public boolean AgregarDetalle(Producto NuevoDetalle) {
        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        ResultSet resultado = gestor.AgregarDetalleFacturaCompra(NuevoDetalle);
        try {
            if (resultado.next()) {
                if (resultado.getString(1).equals("2")) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int ConsultaUltimoIdDeFactura() {
        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ObtenerUltimoId();
        try {
            if (resultado.next()) {
                return resultado.getInt(1);// retorn resultado obtenido
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;// No trae nada
    }

    public void ObtenerDetallesDeFactura(String idFactura) {
        GestorFacturaDeCompra gestor = new GestorFacturaDeCompra();
        resultado = gestor.ObtenerDetallesDeFactura(idFactura);
        try {
            if (resultado.next()) {
                DetallesFacturaCompra detalles = new DetallesFacturaCompra(null, true);
                resultado.previous();
                detalles.LlenarListaDetalles(resultado);
                detalles.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
