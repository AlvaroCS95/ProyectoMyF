package AccesoDatos;

import Modelos.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeClientes extends Coneccion {

    CallableStatement llamadaAlMetodo;
    Connection conect;

    public GestorDeClientes() {
    }

    public ResultSet InsertarCliente(Cliente elCliente) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        Statement consulta;
        ResultSet Respuesta = null;
        consulta = conexion.createStatement();

        try {
            Respuesta = consulta.executeQuery("call IngresarCliente ('" + elCliente.getCedula()
                    + "','" + elCliente.getPrimerNombre() + "','" + elCliente.getSegundoNombre()
                    + "','" + elCliente.getPrimerApellido() + "','" + elCliente.getSegundoApellido()
                    + "','" + elCliente.getNivelDeCliente() + "','" + elCliente.getNombreDeLocal()
                    + "','" + elCliente.getDireccion() + "','" + elCliente.getRazonSocial() + "');");

            return Respuesta;

        } catch (Exception e) {

            return Respuesta;
        }

    }
     public ResultSet EditarCliente(Cliente elCliente) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        Statement consulta;
        ResultSet Respuesta = null;
        consulta = conexion.createStatement();

        try {
            Respuesta = consulta.executeQuery("call ActualizarCliente ('" + elCliente.getCedula()
                     + "','" + elCliente.getPrimerNombre() + "','" + elCliente.getSegundoNombre()
                    + "','" + elCliente.getPrimerApellido() + "','" + elCliente.getSegundoApellido()
                    + "','" + elCliente.getNivelDeCliente() + "','" + elCliente.getNombreDeLocal()
                    + "','" + elCliente.getDireccion() + "','" + elCliente.getRazonSocial() + "');");

            return Respuesta;

        } catch (Exception e) {

            return Respuesta;
        }

    }

  

    public ResultSet ListarTodosLosClientes() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MosotrarTodoslosClientes ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarClientesParaSeleccionPV() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarClientesParaSeleccionPV(); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarClientes() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MosotrarTodoslosClientesActivos ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet CambiarEstadoCliente(String CedulaUsuarioAEliminar) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarEstadoCliente('" + CedulaUsuarioAEliminar + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public String ObtenerNombreLocalPorId(String CodigoDelCliente) throws ClassNotFoundException, SQLException {
        String NombreLocal = "";
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevolverNombreClientePorCodigo('" + CodigoDelCliente + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                NombreLocal = resulset.getString(1);
            }
        } catch (Exception e) {
        }
        return NombreLocal;
    }

}
