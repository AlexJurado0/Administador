package Modelo;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO extends BaseDAO {

    public List<Administrador> listar() {
        List<Administrador> datos = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Administrador a = new Administrador();
                a.setId_administrador(rs.getInt("id_administrador"));
                a.setNombreCompleto(rs.getString("nombre_usuario"));
                a.setEdad(rs.getInt("edad"));
                a.setTelefono(rs.getString("telefono"));
                a.setDomicilio(rs.getString("domicilio"));
                a.setCorreo(rs.getString("correo"));
                a.setId_usuario(rs.getInt("id_usuario"));
                a.setPago(rs.getInt("pago")); // Cambiado a getInt
                datos.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public int actualizar(Administrador a) {
        int r = 0;
        String sql = "UPDATE administrador SET nombre_usuario=?, edad=?, telefono=?, domicilio=?, correo=?, id_usuario=?, pago=? WHERE id_administrador=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getNombreCompleto());
            ps.setInt(2, a.getEdad());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getDomicilio());
            ps.setString(5, a.getCorreo());
            ps.setInt(6, a.getId_usuario());
            ps.setInt(7, a.getPago()); // Cambiado a setInt
            ps.setInt(8, a.getId_administrador());
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM administrador WHERE id_administrador=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}