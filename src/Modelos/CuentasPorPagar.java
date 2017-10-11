
package Modelos;

import java.util.Date;


public class CuentasPorPagar {
    String NumeroDeFactura;
    String FechaDeIngreso;
    Date FechaLimiteDePago;

    public CuentasPorPagar(String NumeroDeFactura, String FechaDeIngreso, Date FechaLimiteDePago) {
        this.NumeroDeFactura = NumeroDeFactura;
        this.FechaDeIngreso = FechaDeIngreso;
        this.FechaLimiteDePago = FechaLimiteDePago;
    }

    public String getNumeroDeFactura() {
        return NumeroDeFactura;
    }

    public void setNumeroDeFactura(String NumeroDeFactura) {
        this.NumeroDeFactura = NumeroDeFactura;
    }

    public String getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public void setFechaDeIngreso(String FechaDeIngreso) {
        this.FechaDeIngreso = FechaDeIngreso;
    }

    public Date getFechaLimiteDePago() {
        return FechaLimiteDePago;
    }

    public void setFechaLimiteDePago(Date FechaLimiteDePago) {
        this.FechaLimiteDePago = FechaLimiteDePago;
    }
}
