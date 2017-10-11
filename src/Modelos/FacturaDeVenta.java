package Modelos;

public class FacturaDeVenta {

    String codigoProducto, nuReferencia;
    float MontoDeVenta, cantidadVendida, montoDescuento, precioVendido, montCancelado;
    int idCliente, idTipoDePago, diasPlazo;

    public void CrearFacturaDeVentaContado(float monto, int idCliente, int idTipoPago, String nuReferencia) {
        this.MontoDeVenta = monto;
        this.idCliente = idCliente;
        this.idTipoDePago = idTipoPago;
        this.nuReferencia = nuReferencia;
    }

    public void AgregarDetalleFactura(String codigo, float cantidad, float descuento, float precioVendido) {
        this.codigoProducto = codigo;
        this.cantidadVendida = cantidad;
        this.montoDescuento = descuento;
        this.precioVendido = precioVendido;
    }
    
    public void CrearFacturaVentaCredito(float monto, int idCliente, int idTipoPago, String nuReferencia, int plazoDias,
            float montoCancelado) {
        this.MontoDeVenta = monto;
        this.idCliente = idCliente;
        this.idTipoDePago = idTipoPago;
        this.nuReferencia = "0";
        this.diasPlazo = plazoDias;
        this.montCancelado = montoCancelado;
    }

    public float getMontCancelado() {
        return montCancelado;
    }

    public void setMontCancelado(float montCancelado) {
        this.montCancelado = montCancelado;
    }

    public int getDiasPlazo() {
        return diasPlazo;
    }

    public void setDiasPlazo(int diasPlazo) {
        this.diasPlazo = diasPlazo;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public float getMontoDeVenta() {
        return MontoDeVenta;
    }

    public void setMontoDeVenta(float MontoDeVenta) {
        this.MontoDeVenta = MontoDeVenta;
    }

    public float getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(float cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public float getPrecioVendido() {
        return precioVendido;
    }

    public void setPrecioVendido(float precioVendido) {
        this.precioVendido = precioVendido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoDePago() {
        return idTipoDePago;
    }

    public void setIdTipoDePago(int idTipoDePago) {
        this.idTipoDePago = idTipoDePago;
    }

    public String getNuReferencia() {
        return nuReferencia;
    }

    public void setNuReferencia(String nuReferencia) {
        this.nuReferencia = nuReferencia;
    }

}
