package com.mycompany.serviciotecnico.model;

import java.math.BigDecimal;
import java.util.Date;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idServicioRealizado;
    private Date fechaEmision;
    private BigDecimal total;
    private EstadoFactura estado;

    public Factura(int idFactura, int idCliente, int idServicioRealizado, Date fechaEmision, BigDecimal total, EstadoFactura estado) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idServicioRealizado = idServicioRealizado;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdServicioRealizado() { return idServicioRealizado; }
    public void setIdServicioRealizado(int idServicioRealizado) { this.idServicioRealizado = idServicioRealizado; }
    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public EstadoFactura getEstado() { return estado; }
    public void setEstado(EstadoFactura estado) { this.estado = estado; }
}
