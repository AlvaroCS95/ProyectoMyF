
package AccesoDatos;

import Modelos.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeProveedores extends Coneccion {

    public GestorDeProveedores() {
    }

    public ResultSet InsertarProveedor(Proveedor elProveedor) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet Respuesta=null;
        consulta= conexion.createStatement();
        

        try {
            Respuesta= consulta.executeQuery("call IngresarProveedor('"+elProveedor.getCedulaJuridica()
                    +"','"+elProveedor.getNombre()+"','"+elProveedor.getDireccion()
                    +"','"+elProveedor.getTelefono()+"','"+elProveedor.getCorreo()+"')");
            
            return Respuesta;

        } catch (Exception e) {
            return Respuesta;
        }

    }
  public ResultSet EditarProveedor(Proveedor elProveedor) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet Respuesta=null;
        consulta= conexion.createStatement();
        
   

        try {
            Respuesta= consulta.executeQuery("call ActualizarProveedor('"+elProveedor.getCedulaJuridica()
                    +"','"+elProveedor.getNombre()+"','"+elProveedor.getDireccion()
                    +"','"+elProveedor.getTelefono()+"','"+elProveedor.getCorreo()+"')");
            
            return Respuesta;

        } catch (Exception e) {
            return Respuesta;
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
