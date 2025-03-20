package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseDAO {
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected Conexion conectar = new Conexion();
    
}