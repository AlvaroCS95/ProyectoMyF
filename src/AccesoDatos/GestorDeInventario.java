/*FINAL */
package AccesoDatos;

import Modelos.Clasificacion;
import Modelos.Producto;
import Modelos.UME;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeInventario extends Coneccion {

    CallableStatement llamadaAlMetodo;
    Connection conect;
    
    public float ObtenerPrecioDeUnProducto(String CodigoProducto) throws ClassNotFoundException, SQLException {
           float PrecioProducto=0;
              try {
                    EstablecerConexion();
                   Statement statement= conexion.createStatement();
                   ResultSet resulset;

               String busca="call DevolverPrecioDeUnProductoPorCodigo('"+CodigoProducto+"')";
                resulset=statement.executeQuery(busca);
            while(resulset.next())
                {
              PrecioProducto = resulset.getFloat(1);}
           } catch (Exception e) {
           }
          return PrecioProducto;
          }

    public GestorDeInventario() throws ClassNotFoundException {

    }

    public boolean InsertarClasificacion(Clasificacion laClasificacion) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call AgregarClasificacion (?)}");
            llamadaAlMetodo.setString(1, laClasificacion.getNombre());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean InsertarUME(UME laUme) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call AgregarUME (?)}");
            llamadaAlMetodo.setString(1, laUme.getUME());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean InsertarProducto(Producto elProducto) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call AgregarUnProductoNuevo (?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elProducto.getCodigo());
            llamadaAlMetodo.setString(2, elProducto.getNombre());
            llamadaAlMetodo.setInt(3, elProducto.getIdClasificacion());
            llamadaAlMetodo.setInt(4, 0);
            llamadaAlMetodo.setFloat(5, elProducto.getPrecio());
            llamadaAlMetodo.setInt(6, elProducto.getIdUME());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean EditarProducto(Producto elProducto) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call ActualizarUnProducto (?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elProducto.getCodigo());
            llamadaAlMetodo.setString(2, elProducto.getNombre());
            llamadaAlMetodo.setInt(3, elProducto.getIdClasificacion());
            llamadaAlMetodo.setFloat(4, elProducto.getExistencias());
            llamadaAlMetodo.setFloat(5, elProducto.getPrecio());
            llamadaAlMetodo.setInt(6, elProducto.getIdUME());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean EliminarProducto(String codigo) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call EliminarProducto (?)}");
            llamadaAlMetodo.setString(1, codigo);
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean EliminarClasificacion(int codigo) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call EliminarClasificacion (?)}");
            llamadaAlMetodo.setInt(1, codigo);
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean EliminarUME(int codigo) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call EliminarUME (?)}");
            llamadaAlMetodo.setInt(1, codigo);
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public ResultSet ListarProductos() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("{call MostrarTodosLosProductos }");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarClasificaciones() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("{call MostrarTodasLasClasificaciones }");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarUMES() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("{call MostrarTodosLosUMES }");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public int ObtenerIdClasificacion(String elNombre) throws ClassNotFoundException, SQLException {
        int IdClasificacion = 0;
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call ObtenerIdClasificacion('" + elNombre + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdClasificacion = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdClasificacion;
    }

    public int ObtenerIdUME(String elNombre) throws ClassNotFoundException, SQLException {
        int IdUME = 0;
        try {
            EstablecerConexion();
            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call ObtenerIdUME('" + elNombre + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdUME = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdUME;
    }

    public String ObtenerClasificacion(int id) throws ClassNotFoundException, SQLException {
        String clasificacion = "";
        try {
            EstablecerConexion();
            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call ObtenerClasificacion('" + id + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                clasificacion = resulset.getString("Nombre");
            }
        } catch (Exception e) {
        }
        return clasificacion;
    }

    public String ObtenerUME(int id) throws ClassNotFoundException, SQLException {
        String UME = "";
        try {
            EstablecerConexion();
            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call ObtenerUME('" + id + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                UME = resulset.getString("UME");
            }
        } catch (Exception e) {
        }
        return UME;
    }

    public ResultSet ListarProductosPorUME(String laUME) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call MostrartodosLosProductosPorUME('" + laUME + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }

    }

    public ResultSet ListarProductosPorClasificacion(String laClasificacion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call MostrarTodosLosProductosPorTipoDeClasificacion('" + laClasificacion + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }

    }

    public ResultSet ListarProductosPorExistencias(int cantidad) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call BuscarProductosQueTenganMenorOIgualCantidadDeExistencias('" + cantidad + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }

    }

    public ResultSet BuscarProductoPorId(String idProducto) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call BuscarUnProductoPorIdProducto('" + idProducto + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }

    }

    public ResultSet BuscarProductoPorNombre(String elNombre) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call BuscarProductoPorNombre('" + elNombre + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }

    }
}
