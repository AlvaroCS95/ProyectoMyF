package AccesoDatos;

import Modelos.Abono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
      
       public ResultSet ListarAbonos(String nfactura,boolean tipofactura) throws ClassNotFoundException, SQLException {
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;

        consulta = conexion.createStatement();
        try {
            if(tipofactura==false){
           
              resultadoConsulta = consulta.executeQuery(" call MostrarAbonosAproveedores ('"+nfactura+"');");
            }else if(tipofactura==true){
                int id= Integer.parseInt(nfactura);
              resultadoConsulta = consulta.executeQuery(" call MostrarAbonosAclientes ("+id+");");
            }
          
            return resultadoConsulta;
        } catch (SQLException ex) {
            return resultadoConsulta;
        }
    }
}
