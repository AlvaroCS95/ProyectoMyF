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
        boolean exito = true;
        EstablecerConexion();
        Statement consulta;
        ResultSet resultadoConsulta = null;
        consulta = conexion.createStatement();
        try {

            try {
            resultadoConsulta = consulta.executeQuery("call IngresarDevolucion"
                    + "(" + LaDevolucion.getNumeroFactura()+ ",'" + LaDevolucion.getCedulaUsuario()
                    + "'," + LaDevolucion.getValorTotal()+ "," + LaDevolucion.getReintegroAlCliente()+ ");");
          exito=true;
            
        } catch (Exception e) {
           return exito=false;        
        }
            while(resultadoConsulta.next()){
            if(resultadoConsulta.getObject(1).equals("2"))
            {exito=true;
            
            }else{
            
            exito=false;
            }
            }
            //llamadaAlMetodo.close();
            return exito;
        } catch (Exception e) {
            exito=false;
            return exito;
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
