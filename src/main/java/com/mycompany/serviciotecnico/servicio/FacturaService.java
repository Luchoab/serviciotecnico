package com.mycompany.serviciotecnico.servicio;

import com.mycompany.serviciotecnico.dao.FacturaDAO;
import com.mycompany.serviciotecnico.model.Factura;
import com.mycompany.serviciotecnico.model.EstadoFactura;
import java.util.List;

public class FacturaService {

    private final FacturaDAO facturaDAO;

    public FacturaService() {
        this.facturaDAO = new FacturaDAO(); // Inicializamos el DAO
    }

    // Método para insertar una nueva factura
    public boolean insertarFactura(Factura factura) {
        if (factura == null) {
            throw new IllegalArgumentException("La factura no puede ser nula");
        }
        // Validaciones adicionales si es necesario (por ejemplo, verificar que el total sea positivo)
        return facturaDAO.insert(factura);
    }

    // Método para obtener todas las facturas
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaDAO.getAll();
    }

    // Método para obtener una factura por su ID
    public Factura obtenerFacturaPorId(int idFactura) {
        if (idFactura <= 0) {
            throw new IllegalArgumentException("El ID de factura debe ser mayor que cero");
        }
        return facturaDAO.getById(idFactura);
    }

    // Método para actualizar una factura existente
    public boolean actualizarFactura(Factura factura) {
        if (factura == null || factura.getIdFactura() <= 0) {
            throw new IllegalArgumentException("La factura no es válida");
        }
        return facturaDAO.update(factura);
    }

    // Método para eliminar una factura por su ID
    public boolean eliminarFactura(int idFactura) {
        if (idFactura <= 0) {
            throw new IllegalArgumentException("El ID de factura debe ser mayor que cero");
        }
        return facturaDAO.delete(idFactura);
    }

    // Método para calcular el total de facturas en un estado determinado
    public double calcularTotalPorEstado(List<Factura> facturas, EstadoFactura estado) {
        double total = 0;
        for (Factura factura : facturas) {
            if (factura.getEstado() == estado) {
                total += factura.getTotal().doubleValue();
            }
        }
        return total;
    }

    // Método para proyectar el total de facturas futuras (por ejemplo, si se esperan más facturas del mismo tipo)
    public double proyectarFacturasFuturas(int cantidadFacturasFuturas, double montoPromedioPorFactura) {
        return cantidadFacturasFuturas * montoPromedioPorFactura;
    }

    // Método para generar un resumen de facturación por cliente
    public double generarResumenPorCliente(List<Factura> facturas, int idCliente) {
        double totalCliente = 0;
        for (Factura factura : facturas) {
            if (factura.getIdCliente() == idCliente) {
                totalCliente += factura.getTotal().doubleValue();
            }
        }
        return totalCliente;
    }
}
