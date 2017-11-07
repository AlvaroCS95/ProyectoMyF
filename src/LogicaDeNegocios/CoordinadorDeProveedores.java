/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import AccesoDatos.GestorDeProveedores;
import Modelos.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDeProveedores {

    public CoordinadorDeProveedores() {
    }

    public ResultSet InsertarProveedor(Proveedor elProveedor) throws ClassNotFoundException, SQLException {
        GestorDeProveedores elGestorDeProveedores = new GestorDeProveedores();
        return elGestorDeProveedores.InsertarProveedor(elProveedor);
    }
 
    
    public ResultSet EditarProveedor(Proveedor elProveedor) throws ClassNotFoundException, SQLException {
        GestorDeProveedores elGestorDeProveedores = new GestorDeProveedores();
        return elGestorDeProveedores.EditarProveedor(elProveedor);
    }

    public ResultSet ListarProveedoresActivos() throws SQLException, ClassNotFoundException {
        GestorDeProveedores elGestorDeProveedores = new GestorDeProveedores();
        return elGestorDeProveedores.ListarProveedoresActivos();
    }
    public ResultSet ListarTodosLosProveedores() throws SQLException, ClassNotFoundException {
        GestorDeProveedores elGestorDeProveedores = new GestorDeProveedores();
        return elGestorDeProveedores.ListarTodosLosProveedores();
    }
    public ResultSet CambiarEstadoProveedor(String CedulaUsuarioABuscar) throws SQLException, ClassNotFoundException {
        GestorDeProveedores elGestorDeUsuarios = new GestorDeProveedores();
        return elGestorDeUsuarios.CambiarEstadoProveedores(CedulaUsuarioABuscar);
    }
}
