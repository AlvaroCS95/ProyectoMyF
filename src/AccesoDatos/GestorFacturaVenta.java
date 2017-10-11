package AccesoDatos;

import Modelos.FacturaDeVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorFacturaVenta extends Coneccion {

    CallableStatement llamadaAlMetodo;
    ResultSet resultadoConsulta = null;
    Statement consulta;

    public ResultSet BuscarProductoParaVender(String codigoProducto, float cantidadSolicitada) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarProductoParaVender ('" + codigoProducto
                    + "', " + cantidadSolicitada + ");");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultadoConsulta;
    }

    public ResultSet ListarTiposDePago() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL MostrarTipoPago");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultadoConsulta;

    }

    public void CrearFacturaVentaContado(FacturaDeVenta nuevaFactura) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("call NuevaFacturaDeVentaContado(?, ?, ?, ?);");
            llamadaAlMetodo.setFloat(1, nuevaFactura.getMontoDeVenta());
            llamadaAlMetodo.setInt(2, nuevaFactura.getIdCliente());
            llamadaAlMetodo.setInt(3, nuevaFactura.getIdTipoDePago());
            llamadaAlMetodo.setString(4, nuevaFactura.getNuReferencia());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AgregarDetalleDeFactura(FacturaDeVenta nuevaFactura) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("call AgregarDetalleDeFacturaVenta(?, ?, ?, ?);");
            llamadaAlMetodo.setString(1, nuevaFactura.getCodigoProducto());
            llamadaAlMetodo.setFloat(2, nuevaFactura.getCantidadVendida());
            llamadaAlMetodo.setFloat(3, nuevaFactura.getMontoDescuento());
            llamadaAlMetodo.setFloat(4, nuevaFactura.getPrecioVendido());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CrearFacturaVentaCredito(FacturaDeVenta nuevaFactura) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("call NuevaFacturaDeVentaCredito(?, ?, ?, ?, ?, ?);");
            llamadaAlMetodo.setFloat(1, nuevaFactura.getMontoDeVenta());
            llamadaAlMetodo.setInt(2, nuevaFactura.getIdCliente());
            llamadaAlMetodo.setInt(3, nuevaFactura.getIdTipoDePago());
            llamadaAlMetodo.setString(4, nuevaFactura.getNuReferencia());
            llamadaAlMetodo.setInt(5, nuevaFactura.getDiasPlazo());
            llamadaAlMetodo.setFloat(6, nuevaFactura.getMontCancelado());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ListarFacturasDeVentaQueNoTienenDevoluciones() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarFacturasDeVentaSinDevoluciones(); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet BuscarFacturaDeVentaQueNoTieneDevolucionPorNFactura(String NumeroFactura) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call BuscarFacturaDeVentaQueNoTieneDevolucion('" + NumeroFactura + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }

    }

    public ResultSet ListarFacturasDeVentaQueTienenDevoluciones() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarLasFacturasQueTienenDevolucion(); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet BuscarFacturaDeVentaQueTieneDevolucionPorNFactura(String NumeroFactura) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call BuscarFacturaDeVentaQueTieneDevolucion('" + NumeroFactura + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }

    }

    public ResultSet BuscarTodosLosProductosDeUnaFacturaDeVenta(String NumeroFactura) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call BuscarTodosLosProductosDeUnaFacturaDeVenta('" + NumeroFactura + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }

    }

    public ResultSet ObtenerIDTipoPago(String nombreTipoPago) {

        try {

            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ObtnerIdTipoPago ('" + nombreTipoPago + "');");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultadoConsulta;
    }
    
    public ResultSet ObtenerIDClientePorNumeroDeCedula(String numeroDeCedula) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ObtnerIdClientePorNumeroDeCedula ('" + numeroDeCedula + "');");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultadoConsulta;
    }

}
