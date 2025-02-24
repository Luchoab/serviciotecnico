package com.mycompany.serviciotecnico.dao;

import com.mycompany.serviciotecnico.model.Cliente;
import com.mycompany.serviciotecnico.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean insert(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, email, equipo, modelo, procesador, gpu, fecha_alta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTelefono());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEquipo());
            stmt.setString(5, cliente.getModelo());
            stmt.setString(6, cliente.getProcesador());
            stmt.setString(7, cliente.getGpu());
            stmt.setDate(8, cliente.getFechaAlta());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEquipo(rs.getString("equipo"));
                cliente.setModelo(rs.getString("modelo"));
                cliente.setProcesador(rs.getString("procesador"));
                cliente.setGpu(rs.getString("gpu"));
                cliente.setFechaAlta(rs.getDate("fecha_alta"));
                clientes.add(cliente);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente getById(int idCliente) {
        Cliente cl = null;
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";

        try (Connection cn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = cn.prepareStatement(sql)){

            stmt.setInt(1, idCliente);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        cl = new Cliente();
                        cl.setIdCliente(rs.getInt("id_cliente"));
                        cl.setNombre(rs.getString("nombre"));
                        cl.setTelefono(rs.getString("telefono"));
                        cl.setEmail(rs.getString("email"));
                        cl.setEquipo(rs.getString("equipo"));
                        cl.setModelo(rs.getString("modelo"));
                        cl.setProcesador(rs.getString("procesador"));
                        cl.setGpu(rs.getString("gpu"));
                        cl.setFechaAlta(rs.getDate("fecha_alta"));
                    }
                }

            }catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

            return cl;
        }
    
    public boolean update(Cliente cl){
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, email = ?, equipo = ?, modelo = ?, procesador = ?, gpu = ?, fecha_alta = ? WHERE id_cliente = ?";
        
        try(Connection cn = DatabaseConnection.getConnection();
                PreparedStatement stmt = cn.prepareStatement(sql)){
            
                stmt.setString(1, cl.getNombre());
                stmt.setString(2, cl.getTelefono());
                stmt.setString(3, cl.getEmail());
                stmt.setString(4, cl.getEquipo());
                stmt.setString(5, cl.getModelo());
                stmt.setString(6, cl.getProcesador());
                stmt.setString(7, cl.getGpu());
                stmt.setDate(8, new java.sql.Date(cl.getFechaAlta().getTime()));
                stmt.setInt(9, cl.getIdCliente());
                
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean delete(int idCliente) {
    String sql = "DELETE FROM clientes WHERE id_cliente = ?";
    try (Connection cn = DatabaseConnection.getConnection();
         PreparedStatement stmt = cn.prepareStatement(sql)) {
         
        stmt.setInt(1, idCliente);

        int rowsDeleted = stmt.executeUpdate();
        return rowsDeleted > 0;

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        return false;
    }
}


}

