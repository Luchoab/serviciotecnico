package com.mycompany.serviciotecnico.servicio;

import com.mycompany.serviciotecnico.dao.ServicioDAO;
import com.mycompany.serviciotecnico.model.Servicio;
import java.util.List;

public class ServicioService {

    private ServicioDAO servicioDAO;

    public ServicioService() {
        this.servicioDAO = new ServicioDAO();
    }

    // Registrar un servicio
    public boolean registrarServicio(Servicio servicio) {
        // Validaciones
        if (servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacío");
        }
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía");
        }
        if (servicio.getCosto() <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        
        return servicioDAO.insert(servicio);
    }

    // Obtener todos los servicios
    public List<Servicio> obtenerServicios() {
        return servicioDAO.getAll();
    }

    // Obtener un servicio por ID
    public Servicio obtenerServicioPorId(int idServicio) {
        return servicioDAO.getById(idServicio);
    }

    // Actualizar un servicio
    public boolean actualizarServicio(Servicio servicio) {
        if (servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacío");
        }
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía");
        }
        if (servicio.getCosto() <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }

        return servicioDAO.update(servicio);
    }

    // Eliminar un servicio
    public boolean eliminarServicio(int idServicio) {
        if (idServicio <= 0) {
            throw new IllegalArgumentException("El ID del servicio debe ser válido");
        }
        return servicioDAO.delete(idServicio);
    }
}
