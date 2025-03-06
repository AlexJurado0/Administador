/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.ResultSet;



/**
 *
 * @author coco
 */
public class DatosPersonalesDao extends BaseDAO {
    
    // Método para agregar un nueva administrador a la base de datos
    public int agregar(DatosPersonales l) {
    String sql = "INSERT INTO administrador (nombre_usuario, edad, telefono, domicilio, correo, id_usuario) VALUES(?,?,?,?,?,?)";  // Define la consulta SQL para insertar un nuevo registro
    try {
        con = conectar.getConnection();
        
        // Obtener el último id_usuario de la tabla login
        String lastLoginIdQuery = "SELECT id_usuario FROM login ORDER BY id_usuario DESC LIMIT 1";
        ps = con.prepareStatement(lastLoginIdQuery);
        ResultSet rs = ps.executeQuery();
        
        int id_usuario = 0; // Inicializamos el id_usuario en 0
        if (rs.next()) {
            id_usuario = rs.getInt("id_usuario"); // Obtenemos el último id_usuario de la tabla login
        }
        
        // Ahora, insertamos el nuevo registro en la tabla administrador
        ps = con.prepareStatement(sql);
        ps.setString(1, l.getNombreCompleto());
        ps.setInt(2, l.getEdad());
        ps.setString(3, l.getTelefono());
        ps.setString(4, l.getDomicilio());
        ps.setString(5, l.getCorreo());
        ps.setInt(6, id_usuario);  // Usamos el id_usuario obtenido de la tabla login
        ps.executeUpdate();  // Ejecutamos la inserción
        
    } catch (Exception e) {
        e.printStackTrace();  // Es útil imprimir la excepción para el debugging
    }
    return 1;  // Esto puede ser modificado según el éxito de la operación
}


   
    
}
