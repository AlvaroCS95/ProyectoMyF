
package Modelos;


public class Usuario extends Persona{
    
    String NombreUsuario;
    String Contraseña;

    public Usuario(String NombreUsuario, String Contraseña, String Cedula, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido) {
        super(Cedula, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido);
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }
  

   

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    
    
}
