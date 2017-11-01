/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import AccesoDatos.GestorDeCuentasPorCobrar;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CoordinadorDeCuentasPorCobrar {

    public CoordinadorDeCuentasPorCobrar() {
    }
     public ResultSet ListarCuentasPorCobrar() throws ClassNotFoundException, SQLException{
         GestorDeCuentasPorCobrar elGestor= new GestorDeCuentasPorCobrar();
         return elGestor.ListarCuentasPorCobrar();
    }
}
