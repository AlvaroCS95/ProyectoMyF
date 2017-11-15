/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laura
 */
public class GestorDeCuentasPorPagar extends Coneccion {

    public GestorDeCuentasPorPagar() {
    }
    public ResultSet ListarCuentasPorPagar() throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet ResultadoConsulta = null;
        consulta = conexion.createStatement();
        try {
            ResultadoConsulta = consulta.executeQuery("call MostrarTodasLasCuentasPorPagar");
            return ResultadoConsulta;
        } catch (Exception e) {
            return ResultadoConsulta;
        }

    }
}
