/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coco
 */
public class AdministradorDAO extends BaseDAO{
    public List<DatosPersonales> listar() {
        List<DatosPersonales> datos = new ArrayList<>();  // Crea una lista vacía de objetos Persona para almacenar los resultados
        String sql = "select * from administrador";  // Define la consulta SQL para obtener todos los registros de la tabla 'usuario'
        
        try {
            con = conectar.getConnection();  // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql);  // Prepara la consulta SQL
            rs = ps.executeQuery();  // Ejecuta la consulta y obtiene los resultados

            // Recorre el conjunto de resultados
            while (rs.next()) {
                DatosPersonales p = new DatosPersonales(); 
                p.setId_administrador(rs.getInt(1)); 
                p.setNombreCompleto(rs.getString(2));
                p.setEdad(rs.getInt(3));
                p.setTelefono(rs.getString(4)); 
                p.setDomicilio(rs.getString(5)); 
                p.setCorreo(rs.getString(6)); 
                p.setId_usuario(rs.getInt(7)); 
                datos.add(p);  // Añade la persona a la lista de datos
            }
        } catch (Exception e) {
            // Si ocurre algún error en la ejecución, no se realiza ninguna acción
        }
        return datos;  // Retorna la lista con los datos obtenidos de la base de datos
    }
}
