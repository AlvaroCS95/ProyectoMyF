package LogicaDeNegocios;

import AccesoDatos.GestorDeUsuarios;
import Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeUsuarios {

    public CoordinadorDeUsuarios() {
    }

    public boolean AgregarUsuario(Usuario elUsuario) throws ClassNotFoundException, SQLException {
        boolean Respuesta;
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();

        Respuesta = elGestorDeUsuarios.InsertarUsuario(elUsuario);

        return Respuesta;

    }

    public ResultSet EditarUsuario(Usuario elUsuario) throws ClassNotFoundException, SQLException {
        ResultSet Respuesta;
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();

        Respuesta = elGestorDeUsuarios.EditarUsuario(elUsuario);

        return Respuesta;

    }

    public ResultSet ListarUsuariosActivos() throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.ListarUsuariosActivos();
    }

    public ResultSet ListarTodosLosUsuariosActivos() throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.ListarTodosLosUsuariosActivos();
    }

    public ResultSet BuscarUsuario(String CedulaUsuarioABuscar) throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.BuscarUsuario(CedulaUsuarioABuscar);
    }

    public ResultSet CambiarEstadoUsuario(String CedulaUsuarioABuscar) throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.CambiarEstadoUsuario(CedulaUsuarioABuscar);
    }

    public ResultSet CambiarContraseña(String cedula, String contraseñaActual, String contraseñaNueva) throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.CambiarContraseña(cedula, contraseñaActual, contraseñaNueva);
    }

    public int DevolverIdUsuarioActivo() throws SQLException, ClassNotFoundException {
        GestorDeUsuarios elGestorDeUsuarios = new GestorDeUsuarios();
        return elGestorDeUsuarios.ObtenerIdUsuarioActivo();
    }
}
