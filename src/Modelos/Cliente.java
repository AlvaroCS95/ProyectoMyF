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
public class Cliente extends Persona{
    String NombreDeLocal ;
    String NivelDeCliente;
    String Direccion;

   
    

    public Cliente(String nivelDeCliente, String direccion, String Cedula,String nombreDeLocal,
            String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido) {
        super(Cedula, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido);
     
        this.NivelDeCliente = nivelDeCliente;
        this.Direccion = direccion;
        this.NombreDeLocal=nombreDeLocal;
    }

    public String getNombreDeLocal() {
        return NombreDeLocal;
    }

    public void setNombreDeLocal(String NombreDeLocal) {
        this.NombreDeLocal = NombreDeLocal;
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
