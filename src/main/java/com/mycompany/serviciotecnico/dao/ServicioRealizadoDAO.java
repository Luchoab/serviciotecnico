package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Cliente;
import com.mycompany.serviciotecnico.model.Servicio;
import com.mycompany.serviciotecnico.model.ServicioRealizado;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ServicioRealizadoDAO {

    public boolean insert(ServicioRealizado sr) {
        String sql = "INSERT INTO ServiciosRealizados (id_cliente, id_servicio, fecha_entrada, total, estado) VALUES (?, ?, ?, ? ,?)";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, sr.getIdCliente());
            stmt.setInt(2, sr.getIdServicio());
            stmt.setDate(3, sr.getFechaEntrada());
            stmt.setDouble(4, sr.getTotal());
            stmt.setString(5, sr.getEstado());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEstado(int idServicioRealizado, String estado) {
        String sql = "UPDATE ServiciosRealizados SET estado = ? WHERE id_servicio_realizado = ?";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {

            // Verifica que el estado sea válido
            if (!estado.equalsIgnoreCase("pendiente")
                    && !estado.equalsIgnoreCase("en progreso")
                    && !estado.equalsIgnoreCase("entregado")) {
                throw new IllegalArgumentException("Estado no válido.");
            }

            stmt.setString(1, estado);
            stmt.setInt(2, idServicioRealizado);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public List<ServicioRealizado> getAll() {
        List<ServicioRealizado> srs = new ArrayList<>();
        String sql = "SELECT * FROM ServiciosRealizados";
        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ServicioRealizado sr = new ServicioRealizado();
                sr.setIdServicioRealizado(rs.getInt("id_servicio_realizado"));
                sr.setIdCliente(rs.getInt("id_cliente"));
                sr.setIdServicio(rs.getInt("id_servicio"));
                sr.setFechaEntrada(rs.getDate("fecha_entrada"));
                sr.setTotal(rs.getDouble("total"));
                sr.setEstado(rs.getString("estado"));
                srs.add(sr);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return srs;
    }

    public ServicioRealizado getById(int idServicioRealizado) {
        ServicioRealizado sr = null;
        String sql = "SELECT * FROM ServiciosRealizados WHERE id_servicio_realizado = ?";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, idServicioRealizado);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    sr = new ServicioRealizado();
                    sr.setIdServicioRealizado(rs.getInt("id_servicio_realizado"));
                    sr.setIdCliente(rs.getInt("id_cliente"));
                    sr.setIdServicio(rs.getInt("id_servicio"));
                    sr.setFechaEntrada(rs.getDate("fecha_entrada"));
                    sr.setTotal(rs.getDouble("total"));
                    sr.setEstado(rs.getString("estado"));
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sr;
    }
}
