/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelos.Devolucion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class GestorDeDevoluciones extends Coneccion {

    CallableStatement llamadaAlMetodo;
    Connection conect;

    public GestorDeDevoluciones() throws ClassNotFoundException {

    }

    public boolean IngresarDevolucion(Devolucion LaDevolucion) throws SQLException, ClassNotFoundException {

        EstablecerConexion();
        try {

            llamadaAlMetodo = conexion.prepareCall("{call IngresarDevolucion (?,?,?,?)}");
            llamadaAlMetodo.setString(1, LaDevolucion.getNumeroFactura());
            llamadaAlMetodo.setInt(2, LaDevolucion.getCedulaUsuario());
            llamadaAlMetodo.setFloat(3, LaDevolucion.getValorTotal());
            llamadaAlMetodo.setFloat(4, LaDevolucion.getReintegroAlCliente());
            llamadaAlMetodo.execute();
            llamadaAlMetodo.getResultSet();
            llamadaAlMetodo.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public int ObtenerIdDevolucionPorIdFactura(String NumeroFactura) throws ClassNotFoundException, SQLException {
        int IdDevolucionBuscada = 0;
        try {
            EstablecerConexion();
            Statement statement = conexion.createStatement();
            ResultSet resulset;

            String busca = "call DevolverIdDevolucionMedianteIdFacturaDeVenta('" + NumeroFactura + "')";
            resulset = statement.executeQuery(busca);
            while (resulset.next()) {
                IdDevolucionBuscada = resulset.getInt(1);
            }
        } catch (Exception e) {
        }
        return IdDevolucionBuscada;
    }

}
