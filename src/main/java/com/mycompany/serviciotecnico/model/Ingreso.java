package com.mycompany.serviciotecnico.model;

import java.math.BigDecimal;
import java.util.Date;

public class Ingreso {
    private int id_ingreso;
    private BigDecimal monto;
    private String descripcion;
    private Date fecha;
    private int id_cliente;
    private int id_servicio_realizado;
    private BigDecimal costo_servicio;
    private String metodo_pago;

    // Constructor
    public Ingreso(int id_ingreso, BigDecimal monto, String descripcion, Date fecha, 
                   int id_cliente, int id_servicio_realizado, BigDecimal costo_servicio, 
                   String metodo_pago) {
        this.id_ingreso = id_ingreso;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.id_servicio_realizado = id_servicio_realizado;
        this.costo_servicio = costo_servicio;
        this.metodo_pago = metodo_pago;
    }

    // Getters y setters
    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_servicio_realizado() {
        return id_servicio_realizado;
    }

    public void setId_servicio_realizado(int id_servicio_realizado) {
        this.id_servicio_realizado = id_servicio_realizado;
    }

    public BigDecimal getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(BigDecimal costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
