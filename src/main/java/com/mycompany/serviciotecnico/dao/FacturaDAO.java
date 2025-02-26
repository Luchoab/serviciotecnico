package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Factura;
import com.mycompany.serviciotecnico.model.EstadoFactura;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    public boolean insert(Factura factura) {
        String sql = "INSERT INTO Facturas (id_cliente, id_servicio_realizado, fecha_emision, total, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setInt(1, factura.getIdCliente());
            stmt.setInt(2, factura.getIdServicioRealizado());
            stmt.setDate(3, new java.sql.Date(factura.getFechaEmision().getTime()));
            stmt.setBigDecimal(4, factura.getTotal());
            stmt.setString(5, factura.getEstado().name().toLowerCase());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Factura> getAll() {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM Facturas";

        try (Connection cn = DatabaseConnection.getConnection();
             Statement stmt = cn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura factura = new Factura(
                    rs.getInt("id_factura"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_servicio_realizado"),
                    rs.getDate("fecha_emision"),
                    rs.getBigDecimal("total"),
                    EstadoFactura.valueOf(rs.getString("estado").toUpperCase())
                );
                facturas.add(factura);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return facturas;
    }

    public Factura getById(int idFactura) {
        Factura factura = null;
        String sql = "SELECT * FROM Facturas WHERE id_factura = ?";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    factura = new Factura(
                        rs.getInt("id_factura"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_servicio_realizado"),
                        rs.getDate("fecha_emision"),
                        rs.getBigDecimal("total"),
                        EstadoFactura.valueOf(rs.getString("estado").toUpperCase())
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factura;
    }

    public boolean update(Factura factura) {
        String sql = "UPDATE Facturas SET id_cliente = ?, id_servicio_realizado = ?, fecha_emision = ?, total = ?, estado = ? WHERE id_factura = ?";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setInt(1, factura.getIdCliente());
            stmt.setInt(2, factura.getIdServicioRealizado());
            stmt.setDate(3, new java.sql.Date(factura.getFechaEmision().getTime()));
            stmt.setBigDecimal(4, factura.getTotal());
            stmt.setString(5, factura.getEstado().name().toLowerCase());
            stmt.setInt(6, factura.getIdFactura());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int idFactura) {
        String sql = "DELETE FROM Facturas WHERE id_factura = ?";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setInt(1, idFactura);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
