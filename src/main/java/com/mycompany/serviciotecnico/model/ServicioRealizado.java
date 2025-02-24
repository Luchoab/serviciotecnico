package com.mycompany.serviciotecnico.model;

import java.sql.Date;

public class ServicioRealizado {
    private int idServicioRealizado;
    private int idCliente;
    private int idServicio;
    private Date fechaEntrada;
    private double total;
    private String estado; // Usamos String para el estado ("pendiente", "en proceso", "completado")

    // Constructor vacío
    public ServicioRealizado() {}

    // Constructor con parámetros
    public ServicioRealizado(int idCliente, int idServicio, Date fechaEntrada, 
                                double total, String estado) {
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fechaEntrada = fechaEntrada;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdServicioRealizado() {
        return idServicioRealizado;
    }

    public void setIdServicioRealizado(int idServicioRealizado) {
        this.idServicioRealizado = idServicioRealizado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método toString para mostrar la información de un servicio realizado
    @Override
    public String toString() {
        return "ServiciosRealizados{" +
               "idServicioRealizado=" + idServicioRealizado +
               ", idCliente=" + idCliente +
               ", idServicio=" + idServicio +
               ", fechaEntrada=" + fechaEntrada +
               ", total=" + total +
               ", estado='" + estado + '\'' +
               '}';
    }
}
