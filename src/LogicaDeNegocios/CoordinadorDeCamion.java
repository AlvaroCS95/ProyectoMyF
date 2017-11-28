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

    public ResultSet InsertarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.InsertarCamion(elCamion);

    }

    public ResultSet EliminarCargas(int id) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.EliminarCargas(id);
    }

    public int ObtenerUltimoIdCarga() throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        ResultSet r = elGestorDeCamion.ObtenerUltimaIdFacturaCarga();
        if (r.next()) {
            return r.getInt(1);

        } else {
            return -1;
        }

    }

    public int InsertarCarga(Carga laCarga) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        ResultSet insertóCarga = elGestorDeCamion.InsertarCarga(laCarga);
        if (insertóCarga.next()) {
            if (insertóCarga.getString(1).equals("1")) {
                if (!laCarga.getLaListaDeCarga().isEmpty()) {
                    for (DetalleCarga detalle : laCarga.getLaListaDeCarga()) {
                        elGestorDeCamion.InsertarDetalleCarga(detalle);
                    }
                }
                return 1; // exitio
            } else if (insertóCarga.getString(1).equals("3")) {
                return 2;// usuario ya agregado

            } else {
                return 3;// error de llaves
            }

        }
        return 0;
    }

    public ResultSet EditarCamion(Camion elCamion) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.EditarCamion(elCamion);

    }

    public boolean EditarCarga(Carga laCarga) throws ClassNotFoundException, SQLException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.EditarCarga(laCarga);

    }

    public ResultSet ListarCamionesActivos() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.ListarCamionesActivos();
    }

    public ResultSet ListarDetalleDeCarga(int IdCarga) throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.ListarDetalleDeCarga(IdCarga);
    }

    public ResultSet ListarTodasLasPlacas() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.ListartodasLasPlacas();
    }

    public ResultSet ListarCargas() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.ListarCargas();
    }

    public ResultSet ListarTodosLosCamiones() throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.ListarTodosLosCamiones();
    }

    public ResultSet CambiarEstadoCamion(String Placa) throws SQLException, ClassNotFoundException {
        GestorDeCamiones elGestorDeCamion = new GestorDeCamiones();
        return elGestorDeCamion.CambiarEstadoCamion(Placa);
    }

}
