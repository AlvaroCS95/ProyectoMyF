
package LogicaDeNegocios;

import AccesoDatos.GestorDeRutas;
import Modelos.Ruta;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeRutas {

    public CoordinadorDeRutas() {
    }
    public ResultSet ListarRutasActivas() throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarRutasActivas();
    }
    public ResultSet EditarRuta(int id,Ruta laRuta) throws SQLException, ClassNotFoundException{
    GestorDeRutas elGestorDeRutas =new GestorDeRutas();
    return  elGestorDeRutas.EditarRuta(id, laRuta);
    }
    public ResultSet EliminarClienteDeRuta(String cedula,int dia,int IdR) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.EliminarClienteDeRuta(cedula, dia,IdR);
    }
     public ResultSet EliminarCamionDeRuta(String cedula,String dia,int IdR) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.EliminarCamionDeRuta(cedula, dia,IdR);
    }
  public ResultSet ListarTodasLasRutas() throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarTodasLasRutas();
    }
    public ResultSet ListarClientesRutasPorNombre(String nombre) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarClientesPorRutasNombre(nombre);
    }

    public ResultSet ListarClientesRutasPorId(int id) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarClientesPorRutasId(id);
    }

    public ResultSet ListarCamionesRutasPorNombre(String nombre) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarCamionesPorRutasNombre(nombre);
    }

    public ResultSet ListarCamionesRutasPorId(int id) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.ListarCamionesPorRutasId(id);
    }

    public ResultSet IngresarRutas(Ruta laRuta) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.IngresarRuta(laRuta);
    }

   

    public ResultSet CambiarEstadoRutaPorId(int id) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRuta = new GestorDeRutas();
        return elGestorDeRuta.CambiarEstadoRutaPorId(id);
    }


    public ResultSet AgregarClienteARuta(int idRuta, String cedula,int idD) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.IngresarClienteARuta(idRuta, cedula,idD);
    }
    
     public ResultSet AgregarCamionARuta(String idCamion,int idRuta,int idDia ) throws ClassNotFoundException, SQLException {
        GestorDeRutas elGestorDeRutas = new GestorDeRutas();
        return elGestorDeRutas.IngresarCamionARutas(idCamion,idRuta, idDia);
    }
}
