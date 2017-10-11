
package Modelos;

import java.util.Date;

public class Carga {
    float Cantidad;
    String Codigo;
    Date FechaDeCarga;

    public Carga(float Cantidad, String Codigo, Date FechaDeCarga) {
        this.Cantidad = Cantidad;
        this.Codigo = Codigo;
        this.FechaDeCarga = FechaDeCarga;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public Date getFechaDeCarga() {
        return FechaDeCarga;
    }

    public void setFechaDeCarga(Date FechaDeCarga) {
        this.FechaDeCarga = FechaDeCarga;
    }
}
