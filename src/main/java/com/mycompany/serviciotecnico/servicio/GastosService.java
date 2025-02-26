package com.mycompany.serviciotecnico.servicio;

import com.mycompany.serviciotecnico.dao.GastosDAO;
import com.mycompany.serviciotecnico.model.Gasto;
import com.mycompany.serviciotecnico.model.MetodoPago;
import java.util.List;

public class GastosService {

    private final GastosDAO gastosDAO;

    public GastosService() {
        this.gastosDAO = new GastosDAO(); // Inicializamos el DAO
    }

    // Método para insertar un gasto
    public boolean insertarGasto(Gasto gasto) {
        if (gasto == null) {
            throw new IllegalArgumentException("El gasto no puede ser nulo");
        }
        // Validaciones adicionales si es necesario (por ejemplo, verificar que el monto sea positivo)
        return gastosDAO.insert(gasto);
    }

    // Método para obtener todos los gastos
    public List<Gasto> obtenerTodosLosGastos() {
        return gastosDAO.getAll();
    }

    // Método para obtener un gasto por su ID
    public Gasto obtenerGastoPorId(int idGasto) {
        if (idGasto <= 0) {
            throw new IllegalArgumentException("El ID de gasto debe ser mayor que cero");
        }
        return gastosDAO.getById(idGasto);
    }

    // Método para calcular el gasto total (sumar todos los gastos)
    public double calcularGastoTotal(List<Gasto> gastos) {
        double totalGasto = 0;
        for (Gasto gasto : gastos) {
            totalGasto += gasto.getMonto().doubleValue(); // Asumimos que el monto es un BigDecimal
        }
        return totalGasto;
    }

    // Método para calcular el gasto total por categoría
    public double calcularGastoPorCategoria(List<Gasto> gastos, String categoria) {
        double totalGasto = 0;
        for (Gasto gasto : gastos) {
            if (gasto.getCategoria().equalsIgnoreCase(categoria)) {
                totalGasto += gasto.getMonto().doubleValue();
            }
        }
        return totalGasto;
    }

    // Método para calcular el gasto total por proveedor
    public double calcularGastoPorProveedor(List<Gasto> gastos, String proveedor) {
        double totalGasto = 0;
        for (Gasto gasto : gastos) {
            if (gasto.getProveedor().equalsIgnoreCase(proveedor)) {
                totalGasto += gasto.getMonto().doubleValue();
            }
        }
        return totalGasto;
    }

    // Método para proyectar gastos futuros
    public double proyectarGastosFuturos(int cantidadGastosAdicionales, double montoPromedioPorGasto) {
        return cantidadGastosAdicionales * montoPromedioPorGasto;
    }
}
