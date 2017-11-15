package Modelos;


public class FacturaDeCompra {

    String idFacturaCompra, nPedido, nEntrega, fechaDeCompra,nDeReferencia;
    int idProveedor, idTipoPago, plazoDeDias;
    boolean tipoDeCompra;
    float montoTotal, montoCancelado;

    public FacturaDeCompra(String IdFacturaCompra, String NuPedido, String NuEntrega, int IDProveedor,
            int IDTipoPago, String NDeReferencia, String FechaDeCompra, boolean TipoDeCompra, float MontoTotal,
            float montoCancelado, int plazoDeDias) {
        this.idFacturaCompra = IdFacturaCompra;
        this.nPedido = NuPedido;
        this.nEntrega = NuEntrega;
        this.idProveedor = IDProveedor;
        this.idTipoPago = IDTipoPago;
        this.nDeReferencia = NDeReferencia;
        this.fechaDeCompra = FechaDeCompra;
        this.tipoDeCompra = TipoDeCompra;
        this.montoTotal = MontoTotal;
        this.montoCancelado = montoCancelado;
        this.plazoDeDias = plazoDeDias;
    }
    public String getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(String idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public String getnPedido() {
        return nPedido;
    }

    public void setnPedido(String nPedido) {
        this.nPedido = nPedido;
    }

    public String getnEntrega() {
        return nEntrega;
    }

    public void setnEntrega(String nEntrega) {
        this.nEntrega = nEntrega;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getnDeReferencia() {
        return nDeReferencia;
    }

    public void setnDeReferencia(String nDeReferencia) {
        this.nDeReferencia = nDeReferencia;
    }

    public String getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(String fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public boolean isTipoDeCompra() {
        return tipoDeCompra;
    }

    public void setTipoDeCompra(boolean tipoDeCompra) {
        this.tipoDeCompra = tipoDeCompra;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getPlazoDeDias() {
        return plazoDeDias;
    }

    public void setPlazoDeDias(int plazoDeDias) {
        this.plazoDeDias = plazoDeDias;
    }

    public float getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(float montoCancelado) {
        this.montoCancelado = montoCancelado;
    }
}
