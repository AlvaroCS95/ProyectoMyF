
package Modelos;

import java.util.Date;


public class CuentasPorCobrar {
    String CedulaCliente;
    Date FechaDePago;

    public CuentasPorCobrar(String CedulaCliente, Date FechaDePago) {
        this.CedulaCliente = CedulaCliente;
        this.FechaDePago = FechaDePago;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    public Date getFechaDePago() {
        return FechaDePago;
    }

    public void setFechaDePago(Date FechaDePago) {
        this.FechaDePago = FechaDePago;
    }
    
}
