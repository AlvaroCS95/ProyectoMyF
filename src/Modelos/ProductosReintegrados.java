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
public class ProductosReintegrados {
    String CodigoProducto;
    int IdDevoluciones;
    float CantidadReintegrada;

    public ProductosReintegrados() {
    }

    public ProductosReintegrados(String CodigoProducto, int IdDevoluciones, float CantidadReintegrada) {
        this.CodigoProducto = CodigoProducto;
        this.IdDevoluciones = IdDevoluciones;
        this.CantidadReintegrada = CantidadReintegrada;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public int getIdDevoluciones() {
        return IdDevoluciones;
    }

    public float getCantidadReintegrada() {
        return CantidadReintegrada;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public void setIdDevoluciones(int IdDevoluciones) {
        this.IdDevoluciones = IdDevoluciones;
    }

    public void setCantidadReintegrada(float CantidadReintegrada) {
        this.CantidadReintegrada = CantidadReintegrada;
    }
    
    
    
    
}
