
package Modelos;

public class Inventario {
    int Codigo;
    String NombreDeProducto;
    String DescripcionDeProducto;
    double Cantidad;
    float Precio;
    String FacturaPertenecienteDeCompra;

    public Inventario(int Codigo, String NombreDeProducto, String DescripcionDeProducto, double Cantidad, float Precio, String FacturaPertenecienteDeCompra) {
        this.Codigo = Codigo;
        this.NombreDeProducto = NombreDeProducto;
        this.DescripcionDeProducto = DescripcionDeProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.FacturaPertenecienteDeCompra = FacturaPertenecienteDeCompra;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombreDeProducto() {
        return NombreDeProducto;
    }

    public void setNombreDeProducto(String NombreDeProducto) {
        this.NombreDeProducto = NombreDeProducto;
    }

    public String getDescripcionDeProducto() {
        return DescripcionDeProducto;
    }

    public void setDescripcionDeProducto(String DescripcionDeProducto) {
        this.DescripcionDeProducto = DescripcionDeProducto;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getFacturaPertenecienteDeCompra() {
        return FacturaPertenecienteDeCompra;
    }

    public void setFacturaPertenecienteDeCompra(String FacturaPertenecienteDeCompra) {
        this.FacturaPertenecienteDeCompra = FacturaPertenecienteDeCompra;
    }
}
