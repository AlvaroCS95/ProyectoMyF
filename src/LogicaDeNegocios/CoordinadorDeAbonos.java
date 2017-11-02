
package LogicaDeNegocios;

import AccesoDatos.GestorDeAbonos;
import Modelos.Abono;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeAbonos {

    public CoordinadorDeAbonos() {
    }
    public ResultSet IngresarAbonos(Abono elAbono) throws ClassNotFoundException, SQLException{
        GestorDeAbonos elGestor= new GestorDeAbonos();
        return elGestor.IngresarAbono(elAbono);
    }
     public ResultSet IngresarAbonosVentas(Abono elAbono) throws ClassNotFoundException, SQLException{
        GestorDeAbonos elGestor= new GestorDeAbonos();
        return elGestor.IngresarAbonoVentas(elAbono);
    }
}