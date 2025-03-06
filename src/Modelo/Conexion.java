package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {

    //objeto de tipo Connection para almacenar la conexión a la base de datos
    Connection con;
    
    // Método que establece y devuelve la conexión a la base de datos
    public Connection getConnection(){
         // URL de la base de datos MySQL
        String url="jdbc:mysql://localhost:3306/proyectophp";
        // Usuario de la base de datos
        String user="root";
         // Contraseña de la base de datos
        String pass = "";
        
        try {
            // Carga el controlador de MySQL en memoria.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión con la base de datos
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
        }
         // Devuelve la conexión establecida
        return con;
    }
}
