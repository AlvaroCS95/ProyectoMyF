/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelos.Ruta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

  
public class GestorDeRutas extends Coneccion{
    Connection conect;
    CallableStatement llamadaAlMetodo;
    public GestorDeRutas() {
    }
    
    public ResultSet IngresarRuta(Ruta laRuta) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call IngresarRuta"
                    + "('"+laRuta.getNombre()+"','"+laRuta.getDescripcion()+"') ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
     public ResultSet IngresarCamionARuta(int idRuta,String placa) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call AgregarEnlaceCamionRuta"
                    + "("+idRuta+",'"+placa+"'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
     public ResultSet IngresarClienteARuta(int idRuta, String cedula) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call AgregarEnlaceRutaCliente"
                    + "("+idRuta+",'"+cedula+"'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
    
     public ResultSet ListarRutas() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarRutasActivas ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
        public ResultSet ListarTodasLasRutas() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostrarRutas ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
      public ResultSet ListarClientesPorRutasNombre(String nombre) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostarClientesPorRutaNombre('" + nombre + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
        public ResultSet ListarCamionesPorRutasNombre(String nombre) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostarCamionesPorRutaNombre('" + nombre + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
          public ResultSet ListarClientesPorRutasId(int id) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostarClientesPorRutaId(" + id + "); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
            public ResultSet ListarCamionesPorRutasId(int id) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MostarCamionesPorRutaId(" + id + "); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
              public ResultSet CambiarEstadoRutaPorId(int id) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarEstadoRutas(" + id + "); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
        
         
}
