package AccesoDatos;

import Modelos.Camion;
import Modelos.Carga;
import Modelos.DetalleCarga;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeCamiones extends Coneccion {

    Connection conect;
    CallableStatement llamadaAlMetodo;

    public GestorDeCamiones() {
    }

    public boolean InsertarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();

        try {
            llamadaAlMetodo = conexion.prepareCall("{Call IngresarCamion(?,?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elCamion.getNumeroDePlaca());
            llamadaAlMetodo.setString(2, elCamion.getMarca());
            llamadaAlMetodo.setString(3, elCamion.getEstilo());
            llamadaAlMetodo.setString(4, elCamion.getColor());
            llamadaAlMetodo.setString(5, elCamion.getFechaDeCompra());
            llamadaAlMetodo.setFloat(6, elCamion.getCapacidad());
            llamadaAlMetodo.setString(7, elCamion.getModelo());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean EditarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        EstablecerConexion();

        try {
            llamadaAlMetodo = conexion.prepareCall("{Call ActualizarCamion(?,?,?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elCamion.getNumeroDePlaca());
            llamadaAlMetodo.setString(2, elCamion.getMarca());
            llamadaAlMetodo.setString(3, elCamion.getEstilo());
            llamadaAlMetodo.setString(4, elCamion.getColor());
            llamadaAlMetodo.setString(5, elCamion.getFechaDeCompra());
            llamadaAlMetodo.setFloat(6, elCamion.getCapacidad());
            llamadaAlMetodo.setString(7, elCamion.getModelo());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {
            return false;
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
