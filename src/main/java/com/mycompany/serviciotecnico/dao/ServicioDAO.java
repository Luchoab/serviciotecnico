package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Servicio;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    public boolean insert(Servicio servicio) {
        String sql = "INSERT INTO Servicios (nombre, descripcion, costo) VALUES (?,?,?)";
        
        try (Connection cn = DatabaseConnection.getConnection();
                PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombre());
            stmt.setString(2, servicio.getDescripcion());
            stmt.setDouble(3, servicio.getCosto());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } 
        
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

public List<Servicio> getAll() {
    List<Servicio> servicios = new ArrayList<>();
    String sql = "SELECT * FROM Servicios";
    try (Connection cn = DatabaseConnection.getConnection();
         PreparedStatement stmt = cn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {  // Corregido: sin parámetro
        while (rs.next()) {
            Servicio servicio = new Servicio();
            servicio.setDescripcion(rs.getString("descripcion"));
            servicio.setIdServicio(rs.getInt("id_servicio"));
            servicio.setNombre(rs.getString("nombre"));
            servicio.setCosto(rs.getDouble("costo"));  // Corregido: era "precio"
            servicios.add(servicio);
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return servicios;
}


public Servicio getById(int idServicio) {
    Servicio s = null;
    String sql = "SELECT * FROM Servicios WHERE id_servicio = ?";
    try (Connection cn = DatabaseConnection.getConnection();
         PreparedStatement stmt = cn.prepareStatement(sql)) {
        stmt.setInt(1, idServicio);
        try (ResultSet rs = stmt.executeQuery()) {  // Corregido: sin parámetro
            if (rs.next()) {
                s = new Servicio();
                s.setIdServicio(rs.getInt("id_servicio"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setNombre(rs.getString("nombre"));
                s.setCosto(rs.getDouble("costo"));
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return s;
}

public boolean update(Servicio servicio) {
    String sql = "UPDATE Servicios SET nombre=?, descripcion=?, costo=? WHERE id_servicio=?";
    try (Connection cn = DatabaseConnection.getConnection();
         PreparedStatement stmt = cn.prepareStatement(sql)) {
        stmt.setString(1, servicio.getNombre());
        stmt.setString(2, servicio.getDescripcion());
        stmt.setDouble(3, servicio.getCosto());
        stmt.setInt(4, servicio.getIdServicio());  // Corregido: WHERE por ID

        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        return false;
    }
}

    
public boolean delete(int idServicio) {
    String sql = "DELETE FROM Servicios WHERE id_servicio = ?";  // Corregido: nombre tabla
    try (Connection cn = DatabaseConnection.getConnection();
         PreparedStatement stmt = cn.prepareStatement(sql)) {

        stmt.setInt(1, idServicio);
        int rowsDeleted = stmt.executeUpdate();
        return rowsDeleted > 0;

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        return false;
    }
}

}
