package com.mycompany.serviciotecnico.model;

import com.mycompany.serviciotecnico.model.MetodoPago;
import java.sql.Date;

public class Ingreso {

    private int idIngreso;
    private double monto;
    private String descripcion;
    private Date fecha;
    private int idCliente;
    private int idServicioRealizado;
    private double costoServicio;
    private MetodoPago metodoPago;  // Aquí cambia el tipo a Enum

    public Ingreso(){};
    // Constructor con el Enum MetodoPago
    public Ingreso(int idIngreso, double monto, String descripcion, Date fecha, int idCliente, int idServicioRealizado, double costoServicio, MetodoPago metodoPago) {
        this.idIngreso = idIngreso;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idServicioRealizado = idServicioRealizado;
        this.costoServicio = costoServicio;
        this.metodoPago = metodoPago;
    }

    // Getters y setters
    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicioRealizado() {
        return idServicioRealizado;
    }

    public void setIdServicioRealizado(int idServicioRealizado) {
        this.idServicioRealizado = idServicioRealizado;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
