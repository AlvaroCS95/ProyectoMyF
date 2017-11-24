package AccesoDatos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorEstadistico extends Coneccion {

    CallableStatement llamadaAlMetodo;
    ResultSet resultadoConsulta = null;
    Statement consulta;

    public ResultSet ConsultarListaDeProductos() {
        try {
            EstablecerConexion();
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("CALL ConsultarListaDeProductos();");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultadoConsulta;
    }

    public ResultSet ConsultarListaDeVentas(String codigoProducto, String fechaDesde, String fechaHasta) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL ConsultarGananciaPorCodigo(?, ?, ?);");
            llamadaAlMetodo.setString(1, codigoProducto);
            llamadaAlMetodo.setString(2, fechaDesde);
            llamadaAlMetodo.setString(3, fechaHasta);
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

    public ResultSet ConsultarListaDeCompras(String codigoProducto, String fechaDesde, String fechaHasta) {
        try {
            EstablecerConexion();
            llamadaAlMetodo = conexion.prepareCall("CALL ConsultarInversionPorCodigo(?, ?, ?);");
            llamadaAlMetodo.setString(1, codigoProducto);
            llamadaAlMetodo.setString(2, fechaDesde);
            llamadaAlMetodo.setString(3, fechaHasta);
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(GestorFacturaDeCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoConsulta;
    }

}
