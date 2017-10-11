package Modelos;

public class Proveedor {

    String Nombre;
    String Direccion;
    String Correo;
    String CedulaJuridica;
    String Telefono;

    public Proveedor(String CedulaJuridica, String nombre, String direccion, String correo, String Telefono) {

        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Correo = correo;
        this.CedulaJuridica = CedulaJuridica;
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCedulaJuridica() {
        return CedulaJuridica;
    }

    public void setCedulaJuridica(String CedulaJuridica) {
        this.CedulaJuridica = CedulaJuridica;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

  
}
