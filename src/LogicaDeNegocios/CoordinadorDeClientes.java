package LogicaDeNegocios;

import AccesoDatos.GestorDeClientes;

import Modelos.Cliente;
import java.sql.ResultSet;

import java.sql.SQLException;

public class CoordinadorDeClientes {

    public CoordinadorDeClientes() {
    }

    public ResultSet AgregarCliente(Cliente elCliente) throws ClassNotFoundException, SQLException {
       
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();

      return  elGestorDeClientes.InsertarCliente(elCliente);

       

    }

    public ResultSet EditarCliente(Cliente elCliente) throws ClassNotFoundException, SQLException {
      
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();

        return elGestorDeClientes.EditarCliente(elCliente);

    }public ResultSet ListarClientesParaSeleccionPV() throws SQLException, ClassNotFoundException {
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();
        return elGestorDeClientes.ListarClientesParaSeleccionPV();
    }

    public ResultSet ListarClientes() throws SQLException, ClassNotFoundException {
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();
        return elGestorDeClientes.ListarClientes();
    }
  public ResultSet ListarTodosLosClientes() throws SQLException, ClassNotFoundException {
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();
        return elGestorDeClientes.ListarTodosLosClientes();
    }
    public ResultSet CambiarEstadoCliente(String CedulaCliente) throws SQLException, ClassNotFoundException {
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();
        return elGestorDeClientes.CambiarEstadoCliente(CedulaCliente);
    }

    public String ObtenerNombreLocalPorCodigoCliente(String CedulaCliente) throws SQLException, ClassNotFoundException {
        GestorDeClientes elGestorDeClientes = new GestorDeClientes();
        return elGestorDeClientes.ObtenerNombreLocalPorId(CedulaCliente);
    }

    
}
