package LogicaDeNegocios;

import AccesoDatos.GestorDeCamiones;
import Modelos.Camion;
import Modelos.Carga;
import Modelos.DetalleCarga;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeCamion {

    public CoordinadorDeCamion() {
    }

    public boolean InsertarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.InsertarCamion(elCamion);

    }
     public boolean InsertarCarga(Carga laCarga) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        boolean insertóCarga=elGestorDeCamion.InsertarCarga(laCarga);
        if(insertóCarga){
            if(!laCarga.getLaListaDeCarga().isEmpty()){
            for(DetalleCarga detalle:laCarga.getLaListaDeCarga()){
            elGestorDeCamion.InsertarDetalleCarga(detalle);
            }
            }
        }
      return insertóCarga;
    }
     public boolean EditarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.EditarCamion(elCamion);

    }
     public ResultSet ListarCamionesActivos() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeUsuarios = new GestorDeCamiones();
        return elGestorDeUsuarios.ListarCamionesActivos();
    }
      public ResultSet ListarTodosLosCamiones() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeUsuarios = new GestorDeCamiones();
        return elGestorDeUsuarios.ListarTodosLosCamiones();
    }
     public ResultSet CambiarEstadoCamion(String Placa) throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeClientes = new GestorDeCamiones();
        return elGestorDeClientes.CambiarEstadoCamion(Placa);
    }
     
}
