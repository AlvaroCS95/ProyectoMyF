/*China*/
package LogicaDeNegocios;

import AccesoDatos.GestorDeInventario;
import Modelos.Clasificacion;
import Modelos.Producto;
import Modelos.UME;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeInventario {
    
    public float DevolverPrecio(String CodigoProducto) throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ObtenerPrecioDeUnProducto(CodigoProducto);
    }

    public boolean AgregarProducto(Producto elProducto) throws ClassNotFoundException, SQLException {
        boolean Respuesta;
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();

        Respuesta = elGestorDeInventario.InsertarProducto(elProducto);

        return Respuesta;

    }

    public boolean EditarProducto(Producto elProducto) throws ClassNotFoundException, SQLException {
        boolean Respuesta;
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();

        Respuesta = elGestorDeInventario.EditarProducto(elProducto);

        return Respuesta;

    }

    public boolean AgregarClasificacion(Clasificacion laClasificacion) throws ClassNotFoundException, SQLException {
        boolean Respuesta;
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();

        Respuesta = elGestorDeInventario.InsertarClasificacion(laClasificacion);

        return Respuesta;

    }

    public boolean AgregarUME(UME laUme) throws ClassNotFoundException, SQLException {
        boolean Respuesta;
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();

        Respuesta = elGestorDeInventario.InsertarUME(laUme);

        return Respuesta;

    }

    public ResultSet ListarProductos() throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarProductos();
    }

    public ResultSet ListarClasificaciones() throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarClasificaciones();
    }

    public ResultSet ListarUMES() throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarUMES();
    }

    public int ObtenerIdClasificacion(String elNombre) throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ObtenerIdClasificacion(elNombre);
    }

    public int ObtenerIdUME(String elNombre) throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ObtenerIdUME(elNombre);
    }

    public String ObtenerClasificacion(int id) throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ObtenerClasificacion(id);
    }

    public String ObtenerUME(int id) throws SQLException, ClassNotFoundException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ObtenerUME(id);
    }

    public ResultSet ListarProductosPorUME(String laUME) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarProductosPorUME(laUME);
    }

    public ResultSet ListarProductosPorClasificacion(String laClasificacion) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarProductosPorClasificacion(laClasificacion);
    }

    public ResultSet BuscarProductoPorId(String idProducto) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.BuscarProductoPorId(idProducto);
    }

    public ResultSet BuscarProductoPorNombre(String elNombre) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.BuscarProductoPorNombre(elNombre);
    }

    public ResultSet ListarProductosPorExistencias(int cantidad) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.ListarProductosPorExistencias(cantidad);
    }

    public boolean EliminarProducto(String codigo) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.EliminarProducto(codigo);
    }

    public boolean EliminarClasificacion(int codigo) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.EliminarClasificacion(codigo);
    }

    public boolean EliminarUME(int codigo) throws ClassNotFoundException, SQLException {
        GestorDeInventario elGestorDeInventario = new GestorDeInventario();
        return elGestorDeInventario.EliminarUME(codigo);
    }

}
