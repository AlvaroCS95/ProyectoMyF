//Edicion desde web

package AccesoDatos;
import UI.IngresoAlSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Coneccion {

  
    Connection conexion = null;
    public Connection ConexionBD(String NombreUsuario, String Contraseña) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdmyffinal", NombreUsuario, Contraseña);
           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.printf(e.getMessage());
                return conexion;
        }
        return conexion;
    }
     public void EstablecerConexion() throws ClassNotFoundException{
       Coneccion coneccion = new Coneccion();
         char[] contraseña = IngresoAlSistema.pswContraseña_IngresoAlSistema.getPassword();
        String ContraseñaUsuario = new String(contraseña);
        conexion=coneccion.ConexionBD(IngresoAlSistema.txtNombreUsario_IngresoAlSistema.getText(),ContraseñaUsuario);
}
}
