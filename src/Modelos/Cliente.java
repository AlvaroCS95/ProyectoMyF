/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Laura
 */
public class Cliente extends Persona {

    String NombreDeLocal;
    String NivelDeCliente;
    String Direccion;
    String RazonSocial;

    public Cliente(String nivelDeCliente, String direccion, String Cedula, String nombreDeLocal,
            String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Razon) {
        super(Cedula, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido);

        this.NivelDeCliente = nivelDeCliente;
        this.Direccion = direccion;
        this.NombreDeLocal = nombreDeLocal;
        this.RazonSocial = Razon;
    }

    public String getNombreDeLocal() {
        return NombreDeLocal;
    }

    public void setNombreDeLocal(String NombreDeLocal) {
        this.NombreDeLocal = NombreDeLocal;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNivelDeCliente() {
        return NivelDeCliente;
    }

    public void setNivelDeCliente(String NivelDeCliente) {
        this.NivelDeCliente = NivelDeCliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}
