/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelos.Proveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeProveedores extends Coneccion {

    public GestorDeProveedores() {
    }

    public boolean InsertarProveedor(Proveedor elProveedor) throws ClassNotFoundException {
        EstablecerConexion();
        CallableStatement llamadaAlMetodo;

        try {
            llamadaAlMetodo = conexion.prepareCall("{call IngresarProveedor(?,?,?,?,?)}");
            llamadaAlMetodo.setString(1, elProveedor.getCedulaJuridica());
            llamadaAlMetodo.setString(2, elProveedor.getNombre());
            llamadaAlMetodo.setString(3, elProveedor.getDireccion());
            llamadaAlMetodo.setString(4, elProveedor.getTelefono());
            llamadaAlMetodo.setString(5, elProveedor.getCorreo());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean EditarProveedor(Proveedor elProveedor) throws ClassNotFoundException {
        EstablecerConexion();
        CallableStatement llamadaAlMetodo;

        try {
            llamadaAlMetodo = conexion.prepareCall("call ActualizarProveedor(?,?)");
            llamadaAlMetodo.setString(1, elProveedor.getCedulaJuridica());
            llamadaAlMetodo.setString(2, elProveedor.getNombre());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
 public ResultSet CambiarEstadoProveedores(String Cedula) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call CambiarEstadoProveedor('" + Cedula + "'); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
    public ResultSet ListarProveedoresActivos() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call MosotrarTodoslosProveedoresActivos ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
    
    public ResultSet ListarTodosLosProveedores() throws ClassNotFoundException, SQLException{
    EstablecerConexion();
    Statement consulta;
    ResultSet resultadoConsulta=null;
    consulta= conexion.createStatement();
        try {
            resultadoConsulta=consulta.executeQuery("call MosotrarTodoslosProveedores ");
            return resultadoConsulta;
        } catch (Exception e) {
             return resultadoConsulta;
        }
    
    }
}
