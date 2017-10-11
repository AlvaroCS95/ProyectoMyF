package Modelos;

public class Producto {

    String Codigo;
    String Nombre;
    int IdClasificacion;
    float Existencias;
    float Precio;
    int IdUME;

    public Producto() {
    }

    public Producto(String Codigo, String Nombre, int IdClasificacion, float Existencias, float Precio, int IdUME) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.IdClasificacion = IdClasificacion;
        this.Existencias = Existencias;
        this.Precio = Precio;
        this.IdUME = IdUME;
    }

    public float getExistencias() {
        return Existencias;
    }

    public void setExistencias(float Existencias) {
        this.Existencias = Existencias;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdClasificacion() {
        return IdClasificacion;
    }

    public void setIdClasificacion(int IdClasificacion) {
        this.IdClasificacion = IdClasificacion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getIdUME() {
        return IdUME;
    }

    public void setIdUME(int IdUME) {
        this.IdUME = IdUME;
    }

}
