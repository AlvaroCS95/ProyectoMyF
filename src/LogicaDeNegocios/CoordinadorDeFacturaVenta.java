package LogicaDeNegocios;

import AccesoDatos.GestorFacturaVenta;
import Modelos.FacturaDeVenta;
import UI.DetallesFacturaCompraVenta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CoordinadorDeFacturaVenta {

    ArrayList<Object> listaParaRetornar = new ArrayList<>();
    ResultSet resultado;

    public Object[] BuscarProducto(String codigo, float nuevaCantidadAcumulada, float precioAcumulado,
            float nuevacantidadSolicitada) {
        Object[] fila = new Object[8];
        float precio = 0, subTotal = 0;

        GestorFacturaVenta gestor = new GestorFacturaVenta();
        resultado = gestor.BuscarProductoParaVender(codigo, nuevaCantidadAcumulada);
        try {
            while (resultado.next()) {
                if (resultado.getObject(1).equals("-2")) {
                    return fila = null;

                } else {
                    for (int i = 0; i < 8; i++) {
                        if (i < 4) {
                            if (i == 3) {
                                fila[i] = nuevaCantidadAcumulada;
                                fila[i + 1] = resultado.getObject(i + 1);
                            } else {
                                fila[i] = resultado.getObject(i + 1);
                            }
                        } else if (i == 5) {
                            precio = Float.parseFloat(resultado.getObject(3).toString());
                            fila[i] = (precio * 0.13);
                        } else if (i == 6) {
                            fila[i] = 0;
                        } else if (i == 7) {

                            if (precioAcumulado == 0) {
                                subTotal += ((precio + Float.parseFloat(fila[5].toString())) * nuevaCantidadAcumulada);
                                fila[i] = subTotal;
                            } else {
                                subTotal += precioAcumulado;
                                subTotal += ((precio + Float.parseFloat(fila[5].toString())) * nuevacantidadSolicitada);
                                fila[i] = subTotal;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fila;
    }

    public float ObtenerNuevaCantidad(float cantidadAnterior, float nuevaCantidad) {
        JOptionPane.showMessageDialog(null, "Nueva cantidad solicitada: " + (nuevaCantidad - cantidadAnterior));
        return (nuevaCantidad - cantidadAnterior);
    }

    public void CrearFacturaVentaContado(float monto, int idCliente, int idTipoPago, String nuReferencia) {
        FacturaDeVenta nuevaFactura = new FacturaDeVenta();
        nuevaFactura.CrearFacturaDeVentaContado(monto, idCliente, idTipoPago, nuReferencia);
        GestorFacturaVenta gestor = new GestorFacturaVenta();
        gestor.CrearFacturaVentaContado(nuevaFactura);
    }

    public void CrearFacturaVentaCredito(float monto, int idCliente, int idTipoPago, String nuReferencia, int plazoDias,
            float montoCancelado) {

        FacturaDeVenta nuevaFactura = new FacturaDeVenta();
        nuevaFactura.CrearFacturaVentaCredito(monto, idCliente, idTipoPago, nuReferencia, plazoDias, montoCancelado);
        GestorFacturaVenta gestor = new GestorFacturaVenta();
        gestor.CrearFacturaVentaCredito(nuevaFactura);

    }

    public void AgregarDetalleFacturaVentaContado(String codigo, float cantidadVendida,
            float descuentoAplicado, float precioVendido) {

        FacturaDeVenta nuevoDetalle = new FacturaDeVenta();
        nuevoDetalle.AgregarDetalleFactura(codigo, cantidadVendida, descuentoAplicado, precioVendido);
        GestorFacturaVenta gestor = new GestorFacturaVenta();
        gestor.AgregarDetalleDeFactura(nuevoDetalle);
    }

    public ArrayList<Object> ListarTiposDePago() {
        try {
            listaParaRetornar.clear();
            GestorFacturaVenta listaDeTiposDePago = new GestorFacturaVenta();
            resultado = listaDeTiposDePago.ListarTiposDePago();

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

    public int ObtenerIdClientePorNumeroCedula(String codigoABuscar) {
        GestorFacturaVenta gestor = new GestorFacturaVenta();
        resultado = gestor.ObtenerIDClientePorCodigo(codigoABuscar);
        try {
            if (resultado.next()) {
                return resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; // Error
    }

    public int ObtenerIdTipoPago(String nombreTipoPago) {

        GestorFacturaVenta gestor = new GestorFacturaVenta();
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

    public void ResumenVentaCredito(String Total, String PagaCon, String Dias) {
        UI.ResumenDeVenta nuevoResumen = new UI.ResumenDeVenta(null, true);
        nuevoResumen.LlenarDatosVentaCredito("₡ " + Total, PagaCon, Dias);
        nuevoResumen.setVisible(true);

    }

    public void CalcularVuelto(boolean tipoPago, String Total, String PagaCon) {
        UI.ResumenDeVenta nuevoResumen = new UI.ResumenDeVenta(null, true);
        if (tipoPago) {
            float total = Float.parseFloat(Total);
            float pagaCon = Float.parseFloat(PagaCon);
            float vuelto = pagaCon - total;

            nuevoResumen.LlenarDatos("₡ " + total, "₡ " + pagaCon, ("₡ " + vuelto));

        } else {
            nuevoResumen.LlenarDatos("₡ " + Total, PagaCon, "₡ " + 0);
        }
        nuevoResumen.setVisible(true);
    }

    public ResultSet ListarFacturasDeVentaQueNoTienenDevoluciones() throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.ListarFacturasDeVentaQueNoTienenDevoluciones();
    }

    public ResultSet ListarFacturasDeVenta(){
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.ListarFacturasDeVenta();
    }

    public ResultSet BuscarFacturaDeVentaQueNoTieneDevolucionPorNumeroDeFactura(String NumeroDeFactura) throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.BuscarFacturaDeVentaQueNoTieneDevolucionPorNFactura(NumeroDeFactura);
    }

    public ResultSet ListarFacturasDeVentaQueTienenDevoluciones() throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.ListarFacturasDeVentaQueTienenDevoluciones();
    }

    public ResultSet BuscarFacturaDeVentaQueTieneDevolucionPorNumeroDeFactura(String NumeroDeFactura) throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.BuscarFacturaDeVentaQueTieneDevolucionPorNFactura(NumeroDeFactura);
    }

    public ResultSet BuscarTodosLosProductosDeUnaFacturaDeVenta(String NumeroDeFactura) throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorDeFacturasDeVentas = new GestorFacturaVenta();
        return elGestorDeFacturasDeVentas.BuscarTodosLosProductosDeUnaFacturaDeVenta(NumeroDeFactura);
    }
    
    public ResultSet Buscar(int tipoBusqueda, String criterioUno, String criterioDos) {
        GestorFacturaVenta gestorDeBusqueda = new GestorFacturaVenta();

        switch (tipoBusqueda) {
            case 1:
                resultado = gestorDeBusqueda.BuscarFacturaVentaCodigoUsuario(criterioUno);// busqueda por cod Usuario
                break;
            case 2:
                resultado = gestorDeBusqueda.BuscarFacturaVentaNFactura(criterioUno); // busqueda por N de factura
                break;
            case 3:
                resultado = gestorDeBusqueda.BuscarFacturaNombreLocal(criterioUno); // busqueda por Nombre del local
                break;
            case 4:
                resultado = gestorDeBusqueda.BuscarFacturaPorFecha(criterioUno, criterioDos); // busqueda por fecha
                break;

        }
        return resultado;
    }
    
    public ResultSet ListarFacturasVentaDelUltimoMes() {

        GestorFacturaVenta gestor = new GestorFacturaVenta();
        resultado = gestor.ListarFacturasUltimoMes();

        return resultado;
    }
    
    public void ObtenerDetallesDeFactura(String idFactura) {
        GestorFacturaVenta gestor = new GestorFacturaVenta();
        resultado = gestor.ObtenerDetallesDeFactura(idFactura);
        try {
            if (resultado.next()) {
                DetallesFacturaCompraVenta detalles = new DetallesFacturaCompraVenta(null, true, idFactura, false);
                resultado.previous();
                detalles.LlenarListaDetalles(resultado);
                detalles.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDeFacturaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int DevolverUltimoIdFacturaVenta() throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorFacturaVenta = new GestorFacturaVenta();
        return elGestorFacturaVenta.ObtenerUltimaIdFacturaVenta();
    }
    public String ObtenerFechaDePagoConDiasDePLazo(int PlazoDias) throws SQLException, ClassNotFoundException {
        GestorFacturaVenta elGestorFacturaVenta = new GestorFacturaVenta();
        return elGestorFacturaVenta.ObtenerFechaDePagoConDiasDePLazo(PlazoDias);
    }
}
