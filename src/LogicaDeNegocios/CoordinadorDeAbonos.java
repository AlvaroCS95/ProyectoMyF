
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
     public ResultSet ListarAbonos(String nfactura,boolean tipofactura) throws ClassNotFoundException, SQLException{
        GestorDeAbonos elGestor= new GestorDeAbonos();
        return elGestor.ListarAbonos(nfactura,tipofactura);
    }
      
     public ResultSet IngresarAbonosVentas(Abono elAbono) throws ClassNotFoundException, SQLException{
        GestorDeAbonos elGestor= new GestorDeAbonos();
        return elGestor.IngresarAbonoVentas(elAbono);
    }
      public int DevolverUltimoIdFacturaAbono() throws SQLException, ClassNotFoundException {
        GestorDeAbonos elGestorFacturaVenta = new GestorDeAbonos();
        return elGestorFacturaVenta.ObtenerUltimaIdFacturaAbonos();
    }
}
