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
    public int ObtenerUltimaIdFacturaAbonos() throws ClassNotFoundException, SQLException {
        int IdUsuarioActivo = 0;
        try {
            EstablecerConexion();

            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevolverUltimoIdFacturaAbono()";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdUsuarioActivo = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdUsuarioActivo;
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
