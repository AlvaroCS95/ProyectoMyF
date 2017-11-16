
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestorDeCuentasPorCobrar extends Coneccion{

    public GestorDeCuentasPorCobrar() {
    }
       public ResultSet ListarCuentasPorCobrar() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet ResultadoConsulta = null;
        consulta = conexion.createStatement();
        try {
            ResultadoConsulta = consulta.executeQuery("call MostrarTodasLasCuentasPorCobrar");
            return ResultadoConsulta;
        } catch (Exception e) {
            return ResultadoConsulta;
        }
    }
}
