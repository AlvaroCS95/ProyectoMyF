
package AccesoDatos;

import Modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GestorDeUsuarios extends Coneccion {

    CallableStatement llamadaAlMetodo;
    Connection conect;

    public GestorDeUsuarios() throws ClassNotFoundException {

    }

    public ResultSet InsertarUsuario(Usuario elUsuario) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;
        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call IngresarUsuario"
                    + "('" + elUsuario.getCedula() + "','" + elUsuario.getPrimerNombre()
                    + "','" + elUsuario.getSegundoNombre() + "','" + elUsuario.getPrimerApellido() + "','"+elUsuario.getSegundoApellido()
                    +"','"+elUsuario.getNombreUsuario()+"','"+elUsuario.getContraseña()+"');");
            return resultadoConsulta;
            
           
        } catch (Exception e) {

           return resultadoConsulta;
           
        }

    }
    
     public ResultSet CambiarContraseña(String cedula, String contraseña, String nuevaContraseña) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarContraseña"
                    + "('" + cedula + "','" + nuevaContraseña + "','" + contraseña + "') ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarUsuariosActivos() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MosotrarTodoslosUsuariosActivos ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
    
     public ResultSet ListarTodosLosUsuariosActivos() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MosotrarTodoslosUsuarios ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet BuscarUsuario(String CedulaUsuarioABuscar) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call BuscarUsuario('" + CedulaUsuarioABuscar + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet CambiarEstadoUsuario(String CedulaUsuarioAEliminar) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarEstadoUsuario('" + CedulaUsuarioAEliminar + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
    
    public ResultSet EditarUsuario(Usuario elUsuarioEditar) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;
        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("{ call ActualizarUsuario('" + elUsuarioEditar.getCedula()
                    + "','" + elUsuarioEditar.getPrimerNombre() + "','" + elUsuarioEditar.getSegundoNombre()
                    + "','" + elUsuarioEditar.getPrimerApellido() + "','" + elUsuarioEditar.getSegundoApellido()
                    + "','" + elUsuarioEditar.getNombreUsuario() + "','" + elUsuarioEditar.getContraseña() + "')}");
            return resultadoConsulta;

        } catch (SQLException ex) {

            return resultadoConsulta;

        }

    }

    public int ObtenerIdUsuarioActivo() throws ClassNotFoundException, SQLException {
        int IdUsuarioActivo = 0;
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevolverElIdUsuarioDelUsuarioActivo()";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdUsuarioActivo = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdUsuarioActivo;
    }

}
