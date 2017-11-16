/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import AccesoDatos.GestorDeCuentasPorPagar;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laura
 */
public class CoordinadorDeCuentasPorPagar {

    public CoordinadorDeCuentasPorPagar() {
    }
    public ResultSet ListarCuentasPorPagar() throws ClassNotFoundException, SQLException{
         GestorDeCuentasPorPagar elGestor= new GestorDeCuentasPorPagar();
         return elGestor.ListarCuentasPorPagar();
    }
    
}
