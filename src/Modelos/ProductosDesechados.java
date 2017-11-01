/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Christian
 */
public class ProductosDesechados {
    int IdDevoluciones;
    String CodigoDelProducto;
    float CantidadDesechada;
    String DetalleDesecho;

    public ProductosDesechados() {
    }

    public ProductosDesechados(int IdDevoluciones, String CodigoDelProducto, float CantidadDesechada) {
        this.IdDevoluciones = IdDevoluciones;
        this.CodigoDelProducto = CodigoDelProducto;
        this.CantidadDesechada = CantidadDesechada;
    }

    public int getIdDevoluciones() {
        return IdDevoluciones;
    }

    public String getCodigoDelProducto() {
        return CodigoDelProducto;
    }

    public float getCantidadDesechada() {
        return CantidadDesechada;
    }

    public String getDetalleDesecho() {
        return DetalleDesecho;
    }

    public void setIdDevoluciones(int IdDevoluciones) {
        this.IdDevoluciones = IdDevoluciones;
    }

    public void setCodigoDelProducto(String CodigoDelProducto) {
        this.CodigoDelProducto = CodigoDelProducto;
    }

    public void setCantidadDesechada(float CantidadDesechada) {
        this.CantidadDesechada = CantidadDesechada;
    }

    public void setDetalleDesecho(String DetalleDesecho) {
        this.DetalleDesecho = DetalleDesecho;
    }
    
    
    
}
