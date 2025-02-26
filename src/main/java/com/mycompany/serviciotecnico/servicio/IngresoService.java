package com.mycompany.serviciotecnico.service;

import com.mycompany.serviciotecnico.dao.IngresoDAO;
import com.mycompany.serviciotecnico.model.Ingreso;
import com.mycompany.serviciotecnico.model.MetodoPago;
import java.util.List;

public class IngresoService {

    private final IngresoDAO ingresoDAO;

    public IngresoService() {
        this.ingresoDAO = new IngresoDAO(); // Se inicializa el DAO
    }

    // Método para insertar un ingreso
    public boolean insertarIngreso(Ingreso ingreso) {
        if (ingreso == null) {
            throw new IllegalArgumentException("Ingreso no puede ser nulo");
        }
        // Se puede agregar validaciones adicionales aquí (por ejemplo, verificación de monto positivo)
        return ingresoDAO.insert(ingreso);
    }

    // Método para obtener todos los ingresos
    public List<Ingreso> obtenerTodosLosIngresos() {
        return ingresoDAO.getAll();
    }

    // Método para obtener un ingreso por su ID
    public Ingreso obtenerIngresoPorId(int idIngreso) {
        if (idIngreso <= 0) {
            throw new IllegalArgumentException("El ID de ingreso debe ser mayor que cero");
        }
        return ingresoDAO.getById(idIngreso);
    }

    // Método para calcular las ganancias totales (ingresos) en un período determinado
    public double calcularGananciaTotal(List<Ingreso> ingresos) {
        double totalGanancia = 0;
        for (Ingreso ingreso : ingresos) {
            totalGanancia += ingreso.getMonto();
        }
        return totalGanancia;
    }

    // Método para calcular las ganancias por método de pago (ejemplo: solo efectivo, tarjeta, etc.)
    public double calcularGananciaPorMetodoPago(List<Ingreso> ingresos, MetodoPago metodoPago) {
        double totalGanancia = 0;
        for (Ingreso ingreso : ingresos) {
            if (ingreso.getMetodoPago() == metodoPago) {
                totalGanancia += ingreso.getMonto();
            }
        }
        return totalGanancia;
    }

    // Método para proyectar ingresos a futuro (por ejemplo, si se espera hacer X servicios más al mes)
    public double proyectarIngresosFuturos(int serviciosAdicionales, double montoPromedioPorServicio) {
        return serviciosAdicionales * montoPromedioPorServicio;
    }
}
