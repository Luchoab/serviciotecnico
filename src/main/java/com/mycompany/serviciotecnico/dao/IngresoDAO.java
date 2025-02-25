package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Ingreso;
import com.mycompany.serviciotecnico.model.MetodoPago;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngresoDAO {

    public boolean insert(Ingreso ingreso) {
        String sql = "INSERT INTO Ingresos (id_cliente, id_servicio_realizado, monto, descripcion, fecha, metodo_pago, costo_servicio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, ingreso.getIdCliente());
            stmt.setInt(2, ingreso.getIdServicioRealizado());
            stmt.setDouble(3, ingreso.getMonto());
            stmt.setString(4, ingreso.getDescripcion());
            stmt.setDate(5, ingreso.getFecha());
            stmt.setString(6, ingreso.getMetodoPago().toString()); 
            stmt.setDouble(7,ingreso.getCostoServicio());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Ingreso> getAll() {
        List<Ingreso> ingresos = new ArrayList<>();
        String sql = "SELECT * FROM Ingresos";

        try (Connection cn = DatabaseConnection.getConnection(); Statement stmt = cn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ingreso ing = new Ingreso();
                ing.setIdCliente(rs.getInt("id_cliente"));
                ing.setIdServicioRealizado(rs.getInt("id_servicio_realizado"));
                ing.setIdIngreso(rs.getInt("id_ingreso"));
                ing.setDescripcion(rs.getString("descripcion"));
                ing.setFecha(rs.getDate("fecha"));
                ing.setCostoServicio(rs.getDouble("costo_servicio"));
                ing.setMonto(rs.getDouble("monto"));
                ing.setMetodoPago(MetodoPago.valueOf(rs.getString("metodo_pago"))); // Convierte el String a Enum
                ingresos.add(ing);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ingresos;
    }

    public Ingreso getById(int idIngreso) {
        Ingreso ing = null;
        String sql = "SELECT * FROM Ingresos WHERE id_ingreso = ?";

        try (Connection cn = DatabaseConnection.getConnection(); PreparedStatement stmt = cn.prepareStatement(sql)) {

            stmt.setInt(1, idIngreso);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ing = new Ingreso();
                    ing.setIdCliente(rs.getInt("id_cliente"));
                    ing.setIdServicioRealizado(rs.getInt("id_servicio_realizado"));
                    ing.setIdIngreso(rs.getInt("id_ingreso"));
                    ing.setDescripcion(rs.getString("descripcion"));
                    ing.setFecha(rs.getDate("fecha"));
                    ing.setCostoServicio(rs.getDouble("costo_servicio"));
                    ing.setMonto(rs.getDouble("monto"));
                    ing.setMetodoPago(MetodoPago.valueOf(rs.getString("metodo_pago"))); // Convierte el String a Enum
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ing;
    }
}
