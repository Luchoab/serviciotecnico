package com.mycompany.serviciotecnico.model;

import java.math.BigDecimal;
import java.util.Date;

public class Gasto {
    private int id_gasto;
    private BigDecimal monto;
    private String descripcion;
    private Date fecha;
    private String categoria;
    private String proveedor;
    private String metodo_pago;

    // Constructor
    public Gasto(int id_gasto, BigDecimal monto, String descripcion, Date fecha, 
                 String categoria, String proveedor, String metodo_pago) {
        this.id_gasto = id_gasto;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.metodo_pago = metodo_pago;
    }

    // Getters y setters
    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
