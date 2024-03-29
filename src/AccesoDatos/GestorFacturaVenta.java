package AccesoDatos;

import Modelos.FacturaDeVenta;
import java.sql.CallableStatement;
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

    public ResultSet ListarFacturasDeVenta() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ListarFacturasDeVenta");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultadoConsulta;
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

    public ResultSet ObtenerIDClientePorCodigo(String codigo) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ObtenerIdClientePorCodigo ('" + codigo + "');");
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
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaVentaPorFecha ('" + FechaDesde
                    + "','" + FechaHasta + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet BuscarFacturaNombreLocal(String nombreLocal) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaVentaNombreLocal ('"
                    + nombreLocal + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet BuscarFacturaVentaCodigoUsuario(String codigoUsuario) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaVentaIdUsuario ('"
                    + codigoUsuario + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet BuscarFacturaVentaNFactura(String nFactura) {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL BuscarFacturaVentaIdFacturaVenta ('"
                    + nFactura + "');");

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;

    }

    public ResultSet ListarFacturasUltimoMes() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ListarFacturasDeVentaDelMes");

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
            resultadoConsulta = consulta.executeQuery("CALL ObtenerDetallesDeFacturaVentaPorID('" + idFactura + "');");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public int ObtenerUltimaIdFacturaVenta() throws ClassNotFoundException, SQLException {
        int IdUsuarioActivo = 0;
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevolverUltimoIdFactura()";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdUsuarioActivo = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdUsuarioActivo;
    }

    public String ObtenerFechaDePagoConDiasDePLazo(int PlazoDias) throws ClassNotFoundException, SQLException {
        String FechaPago = "";
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevuelveElDiaDePagoConPLazoDeDiasAsignado('" + PlazoDias + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                FechaPago = resulset.getString(1);
            }
        } catch (Exception e) {
        }
        return FechaPago;
    }

    public ResultSet ObtenerCuentasConDeuda(){
        ResultSet resulset = null;
        try {
            EstablecerConexion();
            Statement statement = conexion.createStatement();
            resulset = statement.executeQuery("call BuscarFacturasDeVentaConDeuda()");

        } catch (Exception e) {
            return resulset;
        }
        return resulset;
    }
}
