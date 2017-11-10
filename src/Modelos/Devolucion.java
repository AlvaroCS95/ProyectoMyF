
package Modelos;

import java.util.Date;


public class Devolucion {

  int CedulaUsuario;
  int NumeroFactura;
  float ValorTotal;
  float ReintegroAlCliente;

    public Devolucion( int CedulaUsuario, int NumeroFactura, float ValorTotal, float ReintegroAlCliente) {
        
        this.CedulaUsuario = CedulaUsuario;
        this.NumeroFactura = NumeroFactura;
        this.ValorTotal = ValorTotal;
        this.ReintegroAlCliente = ReintegroAlCliente;
    }
    
    public Devolucion(){};
    
   

    public int getCedulaUsuario() {
        return CedulaUsuario;
    }

    public int getNumeroFactura() {
        return NumeroFactura;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public float getReintegroAlCliente() {
        return ReintegroAlCliente;
    }

    

    public void setCedulaUsuario(int CedulaUsuario) {
        this.CedulaUsuario = CedulaUsuario;
    }

    public void setNumeroFactura(int NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public void setReintegroAlCliente(float ReintegroAlCliente) {
        this.ReintegroAlCliente = ReintegroAlCliente;
    }
 

   
}
