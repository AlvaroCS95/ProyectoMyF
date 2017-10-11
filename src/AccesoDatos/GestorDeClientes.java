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

    public boolean InsertarCliente(Cliente elCliente) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call IngresarCliente (?,?,?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elCliente.getCedula());
            llamadaAlMetodo.setString(2, elCliente.getPrimerNombre());
            llamadaAlMetodo.setString(3, elCliente.getSegundoNombre());
            llamadaAlMetodo.setString(4, elCliente.getPrimerApellido());
            llamadaAlMetodo.setString(5, elCliente.getSegundoApellido());
            llamadaAlMetodo.setString(6, elCliente.getNivelDeCliente());
            llamadaAlMetodo.setString(7, elCliente.getNombreDeLocal());
            llamadaAlMetodo.setString(8, elCliente.getDireccion());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public ResultSet EditarCliente(Cliente elCliente) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        ResultSet resultadoConsulta = null;
        try {

            llamadaAlMetodo = conexion.prepareCall("{call ActualizarCliente (?,?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elCliente.getCedula());
            llamadaAlMetodo.setString(2, elCliente.getPrimerNombre());
            llamadaAlMetodo.setString(3, elCliente.getSegundoNombre());
            llamadaAlMetodo.setString(4, elCliente.getPrimerApellido());
            llamadaAlMetodo.setString(5, elCliente.getSegundoApellido());
            llamadaAlMetodo.setString(6, elCliente.getNivelDeCliente());
            llamadaAlMetodo.setString(7, elCliente.getNombreDeLocal());
            llamadaAlMetodo.execute();
            resultadoConsulta = llamadaAlMetodo.getResultSet();
            

            return resultadoConsulta;

        } catch (Exception e) {

            return resultadoConsulta;
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

}
