package Modelos;



public class Camion {

    String NumeroDePlaca;
    String Marca;
    String Modelo;
    String Estilo;
    String Color;

    String FechaDeCompra;
    float Capacidad;

    public Camion(String NumeroDePlaca, String Marca, String Modelo, String Estilo, String Color, String FechaDeCompra, float Capacidad) {
        this.NumeroDePlaca = NumeroDePlaca;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Estilo = Estilo;
        this.Color = Color;
        this.FechaDeCompra = FechaDeCompra;
        this.Capacidad = Capacidad;
    }

    public String getNumeroDePlaca() {
        return NumeroDePlaca;
    }

    public void setNumeroDePlaca(String NumeroDePlaca) {
        this.NumeroDePlaca = NumeroDePlaca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getFechaDeCompra() {
        return FechaDeCompra;
    }

    public void setFechaDeCompra(String FechaDeCompra) {
        this.FechaDeCompra = FechaDeCompra;
    }

    public float getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(float Capacidad) {
        this.Capacidad = Capacidad;
    }

    @Override
    public String toString() {
        return "Camion{" + "NumeroDePlaca=" + NumeroDePlaca + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Estilo=" + Estilo + ", Color=" + Color + ", FechaDeCompra=" + FechaDeCompra + ", Capacidad=" + Capacidad + '}';
    }


    
}
