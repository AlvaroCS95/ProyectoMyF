package AccesoDatos;

import Modelos.FacturaDeCompra;
import Modelos.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorFacturaDeCompra extends Coneccion {

    CallableStatement llamadaAlMetodo;
    Connection conect;
    ResultSet resultadoConsulta = null;
    Statement consulta;

    public ResultSet CrearFacturaCompraContado(FacturaDeCompra nuevaFactura) {

        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL NuevaFacturaCompraContado(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            llamadaAlMetodo.setString(1, nuevaFactura.getIdFacturaCompra());
            llamadaAlMetodo.setString(2, nuevaFactura.getFechaDeCompra());
            llamadaAlMetodo.setBoolean(3, nuevaFactura.isTipoDeCompra());
            llamadaAlMetodo.setInt(4, nuevaFactura.getIdProveedor());
            llamadaAlMetodo.setFloat(5, nuevaFactura.getMontoTotal());
            llamadaAlMetodo.setString(6, nuevaFactura.getnPedido());
            llamadaAlMetodo.setString(7, nuevaFactura.getnEntrega());
            llamadaAlMetodo.setInt(8, nuevaFactura.getIdTipoPago());
            llamadaAlMetodo.setInt(9, nuevaFactura.getnDeReferencia());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet CrearFacturaCompraCredito(FacturaDeCompra nuevaFactura) {

        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL NuevaFacturaCompraCredito(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            llamadaAlMetodo.setString(1, nuevaFactura.getIdFacturaCompra());
            llamadaAlMetodo.setString(2, nuevaFactura.getFechaDeCompra());
            llamadaAlMetodo.setBoolean(3, nuevaFactura.isTipoDeCompra());
            llamadaAlMetodo.setInt(4, nuevaFactura.getIdProveedor());
            llamadaAlMetodo.setFloat(5, nuevaFactura.getMontoTotal());
            llamadaAlMetodo.setString(6, nuevaFactura.getnPedido());
            llamadaAlMetodo.setString(7, nuevaFactura.getnEntrega());
            llamadaAlMetodo.setInt(8, nuevaFactura.getIdTipoPago());
            llamadaAlMetodo.setInt(9, nuevaFactura.getnDeReferencia());
            llamadaAlMetodo.setFloat(10, nuevaFactura.getMontoCancelado());
            llamadaAlMetodo.setInt(11, nuevaFactura.getPlazoDeDias());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet ListarNombreDeProveedores() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL MostrarNombresDeProveedores");

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

    public ResultSet ObtenerIDProveedor(String nombreProveedor) {

        try {

            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ObtenerIdProveedor ('" + nombreProveedor + "');");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultadoConsulta;
    }

    public ResultSet ListarFacturasDeCompra() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ListarFacturasDeCompra");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultadoConsulta;

    }

    public ResultSet BuscarFacturaPorFecha(String FechaDesde, String FechaHasta) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaCompraPorFecha ('" + FechaDesde
                    + "','" + FechaHasta + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet BuscarFacturaNombreProveedor(String nombreProveedor) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaCompraNombreProveedor ('"
                    + nombreProveedor + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet BuscarFacturaCompraCodigoUsuario(String codigoUsuario) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaCompraIdUsuario ('"
                    + codigoUsuario + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet BuscarFacturaCompraNFactura(String nFactura) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaCompraIdFacturaCompra ('"
                    + nFactura + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet BuscarFacturaParaEditarCompraNFactura(String nFactura) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaCompraParEditarNuFactura ('" + nFactura + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet EditarFacturaDeCompra(FacturaDeCompra facturaAEditar, String NuevaFactura) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL EditarFacturaDeCompra(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            llamadaAlMetodo.setString(1, facturaAEditar.getIdFacturaCompra());
            llamadaAlMetodo.setString(2, NuevaFactura);
            llamadaAlMetodo.setString(2, facturaAEditar.getFechaDeCompra());
            llamadaAlMetodo.setBoolean(3, facturaAEditar.isTipoDeCompra());
            llamadaAlMetodo.setInt(4, facturaAEditar.getIdProveedor());
            llamadaAlMetodo.setFloat(5, facturaAEditar.getMontoTotal());
            llamadaAlMetodo.setString(6, facturaAEditar.getnPedido());
            llamadaAlMetodo.setString(7, facturaAEditar.getnEntrega());
            llamadaAlMetodo.setInt(8, facturaAEditar.getIdTipoPago());
            llamadaAlMetodo.setInt(9, facturaAEditar.getnDeReferencia());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ResultSet ListarFacturasUltimoMes() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ListarFacturasDeCompraDelMes");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultadoConsulta;
    }

    public ResultSet BuscarProductoParaAgregarDetalle(String codigo) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarProductoParaAgregarDetalle('" + codigo + "');");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultadoConsulta;
    }

    public ResultSet AgregarDetalleFacturaCompra(Producto nuevoProducto) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL AgregarDetalleFacturaCompra(?, ?, ?);");
            llamadaAlMetodo.setString(1, nuevoProducto.getCodigo());
            llamadaAlMetodo.setFloat(2, nuevoProducto.getExistencias());
            llamadaAlMetodo.setFloat(3, nuevoProducto.getPrecio());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet ObtenerUltimoId() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ConsultarIdUltimaFacturaCompraIngresada();");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }
    
    public ResultSet ObtenerDetallesDeFactura(String idFactura) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ObtenerDetallesDeFacturaPorID('"+idFactura+"');");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }
}
