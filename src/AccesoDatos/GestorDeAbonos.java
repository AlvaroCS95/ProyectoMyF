package AccesoDatos;

import Modelos.Abono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GestorDeAbonos extends Coneccion {

    public GestorDeAbonos() {
    }
    public ResultSet IngresarAbono(Abono elAbono) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call NuevoAbono " + "(" + elAbono.getIdCuenta()
                    + "," + elAbono.getMontoDeAbono() + ",'" + elAbono.getTipoDePago() + "');");
            return resultadoConsulta;
        } catch (Exception e) {
           
            return resultadoConsulta;
        }
     
    }
     public ResultSet IngresarAbonoVentas(Abono elAbono) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            resultadoConsulta = consulta.executeQuery("call NuevoAbonoVentas " + "(" + elAbono.getIdCuenta()
                    + "," + elAbono.getMontoDeAbono() + ",'" + elAbono.getTipoDePago() + "');");
            return resultadoConsulta;
        } catch (Exception e) {
           
            return resultadoConsulta;
        }
     
    }
}
