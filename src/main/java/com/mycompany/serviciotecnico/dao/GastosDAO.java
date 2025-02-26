package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Gasto;
import com.mycompany.serviciotecnico.model.MetodoPago;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GastosDAO {

    public boolean insert(Gasto gasto) {
        String sql = "INSERT INTO Gastos (monto,descripcion,fecha,categoria,proveedor,metodo_pago) VALUES (?,?,?,?,?,?)";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setBigDecimal(1, gasto.getMonto());
            stmt.setString(2, gasto.getDescripcion());
            stmt.setDate(3, gasto.getFecha());
            stmt.setString(4, gasto.getCategoria());
            stmt.setString(5, gasto.getProveedor());
            stmt.setString(6, gasto.getMetodo_pago().toString());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Gasto> getAll() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM Gastos";

        try (Connection cn = DatabaseConnection.getConnection(); Statement stmt = cn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gasto g = new Gasto();
                g.setMonto(rs.getBigDecimal("monto"));
                g.setDescripcion(rs.getString("descripcion"));
                g.setFecha(rs.getDate("fecha"));
                g.setCategoria(rs.getString("categoria"));
                g.setProveedor(rs.getString("proveedor"));
                g.setMetodo_pago(MetodoPago.valueOf(rs.getString("metodo_pago")));
                gastos.add(g);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return gastos;
    }

    public Gasto getById(int idGasto) {
        Gasto g = null;
        String sql = "SELECT * FROM Gastos WHERE = ?";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareCall(sql)) {
            stmt.setInt(1, idGasto);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    g = new Gasto();
                    g.setMonto(rs.getBigDecimal("monto"));
                    g.setDescripcion(rs.getString("descripcion"));
                    g.setFecha(rs.getDate("fecha"));
                    g.setCategoria(rs.getString("categoria"));
                    g.setProveedor(rs.getString("proveedor"));
                    g.setMetodo_pago(MetodoPago.valueOf(rs.getString("metodo_pago")));

                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return g;
    }
}
