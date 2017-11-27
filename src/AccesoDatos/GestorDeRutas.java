
package AccesoDatos;
//O
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
     public ResultSet EditarRuta(int id, Ruta laRuta) throws SQLException, ClassNotFoundException{
     EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        resultadoConsulta = consulta.executeQuery("call EditarRuta"
                + "("+id+",'"+laRuta.getNombre()+"','"+laRuta.getDescripcion()+"') ");
        return resultadoConsulta;
     }
     public ResultSet IngresarClienteARuta(int idRuta, String cedula,int idD) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call AgregarEnlaceRutaCliente"
                    + "("+idRuta+",'"+cedula+"',"+idD+"); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
       public ResultSet IngresarCamionARutas(String placa,int idRuta, int idD) throws 
        ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call AgregarEnlaceCamionRuta"
                    + "('"+placa+"',"+idRuta+","+idD+"); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
     public ResultSet EliminarClienteDeRuta(String cedula,int idD,int IdR) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call EliminarClienteDeRuta"
                    + "('"+cedula+"',"+idD+","+IdR+"); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
      public ResultSet EliminarCamionDeRuta(String placa,String idD,int Idr) throws 
            ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call EliminarCamionDeRuta"
                    + "('"+placa+"','"+idD+"',"+Idr+"); ");
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
     public ResultSet ListarRutasActivas() throws ClassNotFoundException, SQLException {
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
