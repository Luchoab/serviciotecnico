package com.mycompany.serviciotecnico.servicio;

import com.mycompany.serviciotecnico.dao.ServicioRealizadoDAO;
import com.mycompany.serviciotecnico.model.ServicioRealizado;
import java.util.List;

public class ServicioRealizadoService {

    private ServicioRealizadoDAO servicioRealizadoDAO;

    public ServicioRealizadoService() {
        this.servicioRealizadoDAO = new ServicioRealizadoDAO();
    }

    // Insertar un servicio realizado
    public boolean insertarServicioRealizado(ServicioRealizado sr) {
        // Validaciones
        if (sr.getIdCliente() <= 0) {
            throw new IllegalArgumentException("El ID del cliente debe ser válido");
        }
        if (sr.getIdServicio() <= 0) {
            throw new IllegalArgumentException("El ID del servicio debe ser válido");
        }
        if (sr.getFechaEntrada() == null) {
            throw new IllegalArgumentException("La fecha de entrada no puede estar vacía");
        }
        if (sr.getTotal() <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a 0");
        }
        if (sr.getEstado() == null || sr.getEstado().trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }

        return servicioRealizadoDAO.insert(sr);
    }

    // Actualizar estado de un servicio realizado
    public boolean actualizarEstado(int idServicioRealizado, String estado) {
        // Validaciones
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }
        if (!estado.equalsIgnoreCase("pendiente") && !estado.equalsIgnoreCase("en progreso") && !estado.equalsIgnoreCase("entregado")) {
            throw new IllegalArgumentException("Estado no válido. Debe ser pendiente, en progreso o entregado.");
        }
        return servicioRealizadoDAO.updateEstado(idServicioRealizado, estado);
    }

    // Obtener todos los servicios realizados
    public List<ServicioRealizado> obtenerServiciosRealizados() {
        return servicioRealizadoDAO.getAll();
    }

    // Obtener servicio realizado por ID
    public ServicioRealizado obtenerServicioRealizadoPorId(int idServicioRealizado) {
        return servicioRealizadoDAO.getById(idServicioRealizado);
    }
}
