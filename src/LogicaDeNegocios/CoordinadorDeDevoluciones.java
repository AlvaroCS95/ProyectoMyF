/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;
import AccesoDatos.GestorDeDevoluciones;
import Modelos.Devolucion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */

public class CoordinadorDeDevoluciones {
    
     
    public boolean AgregarDevoluciones(Devolucion LaDevolucion) throws ClassNotFoundException, SQLException {
        
        GestorDeDevoluciones elGestorDeDevoluciones = new GestorDeDevoluciones();
        return  elGestorDeDevoluciones.IngresarDevolucion(LaDevolucion);
    

    }
    public int DevolverIdDevolucion(String NumeroFactura) throws ClassNotFoundException, SQLException {
              GestorDeDevoluciones elGestorDeDevoluciones = new GestorDeDevoluciones();
              return elGestorDeDevoluciones.ObtenerIdDevolucionPorIdFactura(NumeroFactura);
    }
    
}
