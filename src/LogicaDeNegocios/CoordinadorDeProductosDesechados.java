/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import AccesoDatos.GestorProductosDesechados;
import Modelos.ProductosDesechados;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class CoordinadorDeProductosDesechados {

    public boolean IngresarProductosDesechados(ProductosDesechados ElProductosDesechado) throws ClassNotFoundException, SQLException {
        GestorProductosDesechados elGestorProductosDesechados = new GestorProductosDesechados();
        return elGestorProductosDesechados.IngresarProductosDesechados(ElProductosDesechado);
    }
    
    public ResultSet MostrartodosLosProductoDesechadosPorNDevolución(int IdDevolucion) throws SQLException, ClassNotFoundException {
         GestorProductosDesechados elGestorProductosDesechados = new GestorProductosDesechados();
        return elGestorProductosDesechados.MostrartodosLosProductoDesechadosPorNDevolución(IdDevolucion);
    }
}
