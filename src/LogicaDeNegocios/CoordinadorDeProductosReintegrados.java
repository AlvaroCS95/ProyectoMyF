/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;
import AccesoDatos.GestorProductoReintegrados;
import Modelos.ProductosReintegrados;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Christian
 */
public class CoordinadorDeProductosReintegrados {
   
    public boolean AgregarProductoReintegrado(ProductosReintegrados ElProductosReintegrados) throws ClassNotFoundException, SQLException {
        GestorProductoReintegrados elGestorProductoReintegrados = new GestorProductoReintegrados();
        return elGestorProductoReintegrados.IngresarProductosReintegrados(ElProductosReintegrados);
    }
   
    public ResultSet MostrartodosLosProductoReintegradosPorNDevolución(int IdDevolucion) throws SQLException, ClassNotFoundException {
         GestorProductoReintegrados elGestorProductoReintegrados = new GestorProductoReintegrados();
        return elGestorProductoReintegrados.MostrartodosLosProductoReintegradosPorNDevolución(IdDevolucion);
    }
}
