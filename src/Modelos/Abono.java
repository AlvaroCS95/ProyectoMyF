
package Modelos;

import java.util.Date;


public class Abono {
    int IdCuenta=0;
    float MontoDeAbono=0;

    String TipoDePago;


    public Abono(int idCuenta,float montoAbono, String TipoDePago) {
        this.IdCuenta=idCuenta;
        this.MontoDeAbono=montoAbono;
      
        this.TipoDePago = TipoDePago;
      
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public float getMontoDeAbono() {
        return MontoDeAbono;
    }

    public void setMontoDeAbono(float MontoDeAbono) {
        this.MontoDeAbono = MontoDeAbono;
    }

   

    public String getTipoDePago() {
        return TipoDePago;
    }

    public void setTipoDePago(String TipoDePago) {
        this.TipoDePago = TipoDePago;
    }

    
}
