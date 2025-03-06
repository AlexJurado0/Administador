package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends BaseDAO {
    public List<Cliente> listar() {
        List<Cliente> datos = new ArrayList<>();  
        String sql = "select * from cliente"; 
        
        try {
            con = conectar.getConnection(); 
            ps = con.prepareStatement(sql);  
            rs = ps.executeQuery();  

            
            while (rs.next()) {
                Cliente c= new Cliente();  
                c.setId_cliente(rs.getInt(1));  
                c.setNombreCompleto(rs.getString(2));  
                c.setEdad(rs.getInt(3));
                c.setTelefono(rs.getString(4)); 
                c.setDomicilio(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setId_administrador(rs.getInt(7));
                
                datos.add(c); 
            }
        } catch (Exception e) {
            
        }
        return datos;  
    }    
    public int Actualizar(Cliente c) {
        int r = 0;  
        String sql = "update cliente set nombre_cliente=?, edad=?, telefono=?, domicilio=?, correo=? where id_cliente=?";  
        try {
            ps = con.prepareStatement(sql); 
            ps.setString(1, c.getNombreCompleto());  
            ps.setInt(2, c.getEdad());  
            ps.setString(3, c.getTelefono());  
            ps.setString(4, c.getDomicilio()); 
            ps.setString(5, c.getCorreo());
             ps.setInt(6, c.getId_cliente()); 
            
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
        String sql = "delete from login where id_usuario=" + id;  
        try {
            con = conectar.getConnection(); 
            ps = con.prepareStatement(sql); 
            ps.executeUpdate();  
        } catch (Exception e) {
       
        }
    }
    
    
    
}
