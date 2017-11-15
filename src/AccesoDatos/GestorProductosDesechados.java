
package AccesoDatos;
import Modelos.ProductosDesechados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorProductosDesechados extends Coneccion{
     CallableStatement llamadaAlMetodo;
     Connection conect;

    public GestorProductosDesechados() throws ClassNotFoundException {
    }
     
    public boolean IngresarProductosDesechados(ProductosDesechados ProductosDesechados) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call AgregarUnNuevoProductoDesechado (?,?,?,?)}");
            llamadaAlMetodo.setInt(1, ProductosDesechados.getIdDevoluciones());
            llamadaAlMetodo.setString(2, ProductosDesechados.getCodigoDelProducto());
            llamadaAlMetodo.setFloat(3, ProductosDesechados.getCantidadDesechada());
            llamadaAlMetodo.setString(4, ProductosDesechados.getDetalleDesecho());
            llamadaAlMetodo.execute();
            ResultSet Resultado = llamadaAlMetodo.getResultSet();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    
     public ResultSet MostrartodosLosProductoDesechadosPorNDevolución(int IdDevolucion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrartodosLosProductoDesechadosPorNDevolución('" + IdDevolucion + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
     }
}
