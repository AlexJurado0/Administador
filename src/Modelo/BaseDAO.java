package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDAO {
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected Conexion conectar = new Conexion();
}