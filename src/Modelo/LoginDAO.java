package Modelo; 
import java.sql.Connection; 
import java.sql.*;  
import java.util.*;  

// Declaración de la clase PersonaDAO que interactúa con la base de datos
public class LoginDAO {  
    
    Conexion conectar = new Conexion();  // Crea un objeto de la clase Conexion que maneja la conexión a la base de datos
    Connection con;  // Declara la variable que almacenará la conexión a la base de datos
    PreparedStatement ps;  // Declara la variable que prepara consultas SQL parametrizadas
    ResultSet rs;  // Declara la variable que almacenará los resultados de las consultas SQL

    // Método para listar todas las personas desde la base de datos
    public List<Login> listar() {
        List<Login> datos = new ArrayList<>();  // Crea una lista vacía de objetos Persona para almacenar los resultados
        String sql = "select * from login";  // Define la consulta SQL para obtener todos los registros de la tabla 'usuario'
        
        try {
            con = conectar.getConnection();  // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql);  // Prepara la consulta SQL
            rs = ps.executeQuery();  // Ejecuta la consulta y obtiene los resultados

            // Recorre el conjunto de resultados
            while (rs.next()) {
                Login l = new Login();  // Crea una nueva instancia de la clase Persona
                l.setId_usuario(rs.getInt(1));  // Asigna el valor del primer campo de la consulta al campo 'id' de la persona
                l.setUsuario(rs.getString(2));  // Asigna el valor del segundo campo al campo 'nombre' de la persona
                l.setContraseña(rs.getString(3));  // Asigna el valor del tercer campo al campo 'correo' de la persona
                l.setRol(rs.getInt(4));  // Asigna el valor del cuarto campo al campo 'telefono' de la persona
                datos.add(l);  // Añade la persona a la lista de datos
            }
        } catch (Exception e) {
            // Si ocurre algún error en la ejecución, no se realiza ninguna acción
        }
        return datos;  // Retorna la lista con los datos obtenidos de la base de datos
    }

    // Método para agregar una nueva persona a la base de datos
    public int agregar(Login l) {
        String sql = "insert into login(usuario, contraseña, rol) values(?,?,?)";  // Define la consulta SQL para insertar un nuevo registro
        try {
            con = conectar.getConnection();  // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql);  // Prepara la consulta SQL para la ejecución
            ps.setString(1, l.getUsuario());  // Establece el nombre de la persona en el primer parámetro de la consulta
            ps.setString(2, l.getContraseña());  // Establece el correo de la persona en el segundo parámetro de la consulta
            ps.setInt(3, l.getRol());  // Establece el teléfono de la persona en el tercer parámetro de la consulta
            ps.executeUpdate();  // Ejecuta la consulta SQL para insertar el nuevo registro
        } catch (Exception e) {
            // Si ocurre algún error en la ejecución, no se realiza ninguna acción
        }
        return 1;  // Retorna 1 para indicar que la inserción fue exitosa (aunque no se verifica si realmente se insertó)
    }

    // Método para actualizar los datos de una persona existente en la base de datos
    public int Actualizar(Login l) {
        int r = 0;  // Declara una variable para almacenar el número de filas afectadas por la actualización
        String sql = "update login set usuario=?, contraseña=?, rol=? where id_usuario=?";  // Define la consulta SQL para actualizar un registro
        try {
            con = conectar.getConnection();  // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql);  // Prepara la consulta SQL para la ejecución
            ps.setString(1, l.getUsuario());  // Establece el nuevo nombre de la persona en el primer parámetro
            ps.setString(2, l.getContraseña());  // Establece el nuevo correo de la persona en el segundo parámetro
            ps.setInt(3, l.getRol());  // Establece el nuevo teléfono de la persona en el tercer parámetro
            ps.setInt(4, l.getId_usuario());  // Establece el ID de la persona en el cuarto parámetro (para identificar el registro a actualizar)
            r = ps.executeUpdate();  // Ejecuta la consulta SQL y obtiene el número de filas afectadas

            // Si la actualización se realizó correctamente, retorna 1
            if (r == 1) {
                return 1;  
            } else {
                return 0;  // Si no se actualizó ninguna fila, retorna 0
            }

        } catch (Exception e) {
            // Si ocurre algún error en la ejecución, no se realiza ninguna acción
        }
        return r;  // Retorna el valor de 'r', que es el número de filas afectadas (0 o 1)
    }

    // Método para eliminar una persona de la base de datos por su ID
    public void eliminar(int id) {
        String sql = "delete from login where id_usuario=" + id;  // Define la consulta SQL para eliminar un registro por ID
        try {
            con = conectar.getConnection();  // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql);  // Prepara la consulta SQL para la ejecución
            ps.executeUpdate();  // Ejecuta la consulta SQL para eliminar el registro
        } catch (Exception e) {
            // Si ocurre algún error en la ejecución, no se realiza ninguna acción
        }
    }
}
