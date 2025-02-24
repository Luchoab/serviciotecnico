package com.mycompany.serviciotecnico.model;

import java.math.BigDecimal;
import java.util.Date;

public class Factura {
    private int id_factura;
    private int id_cliente;
    private int id_servicio_realizado;
    private Date fecha_emision;
    private BigDecimal total;
    private String estado;

    // Constructor
    public Factura(int id_factura, int id_cliente, int id_servicio_realizado, Date fecha_emision, 
                   BigDecimal total, String estado) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.id_servicio_realizado = id_servicio_realizado;
        this.fecha_emision = fecha_emision;
        this.total = total;
        this.estado = estado;
    }

    // Getters y setters
    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
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

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
