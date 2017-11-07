package AccesoDatos;

import Modelos.Camion;
import Modelos.Carga;
import Modelos.DetalleCarga;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeCamiones extends Coneccion {

    Connection conect;
    CallableStatement llamadaAlMetodo;

    public GestorDeCamiones() {
    }

    public ResultSet InsertarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta=null;
        consulta= conexion.createStatement();
        try {
            resultadoConsulta= consulta.executeQuery("call IngresarCamion('"+elCamion.getNumeroDePlaca()+
                    "','"+elCamion.getMarca()+"','"+elCamion.getEstilo()+"','"+elCamion.getColor()+
                    "','"+elCamion.getFechaDeCompra()+"',"+elCamion.getCapacidad()+",'"+elCamion.getModelo()+"')");
            return resultadoConsulta;
        } catch (Exception e) {
             return resultadoConsulta;
        }

       
    }

    public ResultSet EditarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
          EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta=null;
        consulta= conexion.createStatement();
        try {
            resultadoConsulta= consulta.executeQuery("call ActualizarCamion('"+elCamion.getNumeroDePlaca()+
                    "','"+elCamion.getMarca()+"','"+elCamion.getEstilo()+"','"+elCamion.getColor()+
                    "','"+elCamion.getFechaDeCompra()+"',"+elCamion.getCapacidad()+",'"+elCamion.getModelo()+"')");
            return resultadoConsulta;
        } catch (Exception e) {
             return resultadoConsulta;
        }
    }
    
    public boolean EditarCarga(Carga laCarga) throws ClassNotFoundException, SQLException {
        EstablecerConexion();

        try {
            llamadaAlMetodo = conexion.prepareCall("Call ActualizarCarga(?,?,?);");
            llamadaAlMetodo.setInt(1, laCarga.getIdCarga());
            llamadaAlMetodo.setString(2, laCarga.getIdCamion());
            llamadaAlMetodo.setString(3, laCarga.getFechaCarga());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ResultSet CambiarEstadoCamion(String Placa) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarEstadoCamion('" + Placa + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }

    public ResultSet ListarCamionesActivos() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarCamionesActivos ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
 public ResultSet ListarCargas() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarCargas ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
  public ResultSet ListarDetalleDeCarga(int IdCarga) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement statement;
        ResultSet resultadoConsulta = null;
        statement = conexion.createStatement();
        try {

            String busca = "call MostrarDetalleDeCarga ('" + IdCarga + "')";
            resultadoConsulta = statement.executeQuery(busca);
            return resultadoConsulta;

        } catch (Exception e) {
            return resultadoConsulta;
        }
    }

 public ResultSet ListartodasLasPlacas() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrartodasLasPlacas ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
 
    public ResultSet ListarTodosLosCamiones() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarCamiones ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
     public boolean InsertarCarga(Carga laCarga) throws ClassNotFoundException, SQLException {
        EstablecerConexion();

        try {
            llamadaAlMetodo = conexion.prepareCall("{Call NuevaCarga(?)}");
            llamadaAlMetodo.setString(1, laCarga.getIdCamion());
    
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public boolean InsertarDetalleCarga(DetalleCarga elDetalledeCarga) throws ClassNotFoundException, SQLException {
        EstablecerConexion();

        try {
            llamadaAlMetodo = conexion.prepareCall("{Call IngresarDetalleCarga(?,?)}");
            llamadaAlMetodo.setString(1, elDetalledeCarga.getIdProducto());
            llamadaAlMetodo.setFloat(2, elDetalledeCarga.getCantidad());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
