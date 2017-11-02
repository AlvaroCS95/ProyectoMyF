/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author usuario
 */
public class DetalleCarga {
String IdProducto;
float Cantidad;

    public DetalleCarga(String IdProducto, float Cantidad) {
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }



}
