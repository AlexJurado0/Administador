package Modelo; 
import java.util.*;  
 import org.mindrot.jbcrypt.BCrypt;
import java.sql.ResultSet;


public class LoginDAO extends BaseDAO {  

    public List<Login> listar() {
        List<Login> datos = new ArrayList<>();  
        String sql = "select * from login";  
        
        try {
            con = conectar.getConnection(); 
            ps = con.prepareStatement(sql);  
            rs = ps.executeQuery();  


            while (rs.next()) {
                Login l = new Login();  
                l.setId_usuario(rs.getInt(1)); 
                l.setUsuario(rs.getString(2));  
                l.setContraseña(rs.getString(3)); 
                l.setRol(rs.getInt(4)); 
                datos.add(l);  
            }
        } catch (Exception e) {
           
        }
        return datos; 
    }


   

public int agregar(Login l) {
    String sqlCheck = "SELECT COUNT(*) FROM login WHERE usuario = ?"; // Consulta para verificar si el usuario existe
    String sqlInsert = "INSERT INTO login(usuario, contraseña, rol) VALUES(?,?,?)"; // Consulta para insertar el nuevo usuario

    try {
        con = conectar.getConnection(); 

        // Verificar si el usuario ya existe
        ps = con.prepareStatement(sqlCheck);
        ps.setString(1, l.getUsuario());
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            // Si el usuario ya existe, retornar un código de error (por ejemplo, 0)
            return 0;
        }

        // Si el usuario no existe, proceder con la inserción
        ps = con.prepareStatement(sqlInsert);

        // Encriptar la contraseña antes de guardarla
        String contraseñaEncriptada = BCrypt.hashpw(l.getContraseña(), BCrypt.gensalt());

        ps.setString(1, l.getUsuario());  
        ps.setString(2, contraseñaEncriptada);  // Guardamos la contraseña encriptada
        ps.setInt(3, l.getRol()); // Usamos el rol que viene del objeto Login
        ps.executeUpdate();  

        // Retornar un código de éxito (por ejemplo, 1)
        return 1;

    } catch (Exception e) {
        e.printStackTrace(); // Agrega esto para ver el error si ocurre alguno
        return -1; // Retornar un código de error en caso de excepción
    }
}

 
    public int Actualizar(Login l) {
        int r = 0; 
        String sql = "update login set usuario=?, contraseña=?, rol=? where id_usuario=?";  
        try {
            
            ps = con.prepareStatement(sql); 
            ps.setString(1, l.getUsuario());  
            ps.setString(2, l.getContraseña()); 
            ps.setInt(3, l.getRol());  
            ps.setInt(4, l.getId_usuario());  
            r = ps.executeUpdate(); 

            
         
           
            if (r == 1) {
                return 1;  
            } else {
                return 0;  
            }

        } catch (Exception e) {
            
        }
        return r;  
    }

   
    public void eliminar(int id) {
    String sqlRol = "SELECT rol FROM login WHERE id_usuario = ?";
    
    try {
        

        // Verificar el rol del usuario
        ps = con.prepareStatement(sqlRol);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            int rol = rs.getInt("rol");

            // Eliminar registros asociados en otras tablas
            if (rol == 1) { // Administrador
                // Eliminar referencias en la tabla administrador
                String sqlAdmin = "DELETE FROM administrador WHERE id_usuario = ?";
                ps = con.prepareStatement(sqlAdmin);
                ps.setInt(1, id);
                ps.executeUpdate();
            } else if (rol == 2) { // Cliente
                // Eliminar referencias en la tabla cliente
                String sqlCliente = "DELETE FROM cliente WHERE id_usuario = ?";
                ps = con.prepareStatement(sqlCliente);
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            // Eliminar registros asociados en otras tablas (productos, ventas1, carrito)
            String sqlProductos = "DELETE FROM productos WHERE id_usuario = ?";
            ps = con.prepareStatement(sqlProductos);
            ps.setInt(1, id);
            ps.executeUpdate();

            String sqlVentas = "DELETE FROM ventas1 WHERE id_usuario = ?";
            ps = con.prepareStatement(sqlVentas);
            ps.setInt(1, id);
            ps.executeUpdate();

            String sqlCarrito = "DELETE FROM carrito WHERE id_usuario = ?";
            ps = con.prepareStatement(sqlCarrito);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Finalmente, eliminar el registro en la tabla login
            String sqlLogin = "DELETE FROM login WHERE id_usuario = ?";
            ps = con.prepareStatement(sqlLogin);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace(); // Manejo de excepciones
    }
}
}