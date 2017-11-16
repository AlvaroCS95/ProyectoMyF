
package AccesoDatos;
import Modelos.ProductosReintegrados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorProductoReintegrados extends Coneccion{
     CallableStatement llamadaAlMetodo;
     Connection conect;

    public GestorProductoReintegrados() throws ClassNotFoundException {
    }
    
    public boolean IngresarProductosReintegrados(ProductosReintegrados ProductosReintegrados) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call AgregarUnNuevoProductoReintegrado (?,?,?)}");
            llamadaAlMetodo.setString(1, ProductosReintegrados.getCodigoProducto());
            llamadaAlMetodo.setInt(2, ProductosReintegrados.getIdDevoluciones());
            llamadaAlMetodo.setFloat(3, ProductosReintegrados.getCantidadReintegrada());
            llamadaAlMetodo.execute();
            ResultSet Resultado = llamadaAlMetodo.getResultSet();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    
     public ResultSet MostrartodosLosProductoReintegradosPorNDevolución(int IdDevolucion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrartodosLosProductoReintegradosPorNDevolución('" + IdDevolucion + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }

    }
}
