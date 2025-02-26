package com.mycompany.serviciotecnico.servicio;

import com.mycompany.serviciotecnico.dao.ClienteDAO;
import com.mycompany.serviciotecnico.model.Cliente;
import java.sql.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ClienteService {
    
    private ClienteDAO clienteDAO;
    
    public ClienteService(){
        this.clienteDAO = new ClienteDAO();
    }
    
    public boolean registrarCliente(Cliente cliente){
        // Validaciones
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (cliente.getProcesador() == null || cliente.getProcesador().trim().isEmpty()){
            throw new IllegalArgumentException("El procesador no debe estar vacio");
        }
        if (cliente.getEquipo() == null || cliente.getEquipo().trim().isEmpty()){
            throw new IllegalArgumentException("El equipo no debe estar vacio");
        }
        if(cliente.getModelo() == null || cliente.getModelo().trim().isEmpty()){
            throw new IllegalArgumentException("El modelo no debe estar vacio");
        }
        if(cliente.getTelefono() == null || !cliente.getTelefono().matches("\\d+")){
            throw new IllegalArgumentException("El teléfono debe contener solo números");
        }
        if (cliente.getEmail() == null || !validarEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("El email no es válido");
        }

        // Asignar la fecha de alta al cliente
        if (cliente.getFechaAlta() == null) {
            cliente.setFechaAlta(new Date(System.currentTimeMillis())); 
        }

        // Llamar al DAO para insertar el cliente
        return clienteDAO.insert(cliente);
    }
   
    private boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }
    
    public Cliente obtenerClientePorId(int idCliente) {
        return clienteDAO.getById(idCliente);
    }
    
}
