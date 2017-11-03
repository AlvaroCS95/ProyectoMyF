/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import AccesoDatos.GestorDeImpresion;
import Modelos.Impresion;



/**
 *
 * @author Christian
 */
public class CoordinarDeImpresion{

    public void Imprimir(Impresion laImpresion){
            GestorDeImpresion elGestorDeImpresion= new GestorDeImpresion(laImpresion.getCuerpoDeLaImpresion());
            elGestorDeImpresion.Imprimir();
    }

}