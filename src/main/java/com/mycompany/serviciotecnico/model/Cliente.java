package com.mycompany.serviciotecnico.model;

import java.sql.Date;

public class Cliente {
    private int idCliente;       // id_cliente (clave primaria)
    private String nombre;       // nombre
    private String telefono;     // telefono
    private String email;        // email
    private String equipo;       // equipo
    private String modelo;       // modelo
    private String procesador;   // procesador
    private String gpu;          // gpu
    private Date fechaAlta;      // fecha_alta

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(int idCliente, String nombre, String telefono, String email,
                   String equipo, String modelo, String procesador, String gpu, Date fechaAlta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.equipo = equipo;
        this.modelo = modelo;
        this.procesador = procesador;
        this.gpu = gpu;
        this.fechaAlta = fechaAlta;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    // Método toString para mostrar información del cliente
    @Override
    public String toString() {
        return "Cliente{" +
               "idCliente=" + idCliente +
               ", nombre='" + nombre + '\'' +
               ", telefono='" + telefono + '\'' +
               ", email='" + email + '\'' +
               ", equipo='" + equipo + '\'' +
               ", modelo='" + modelo + '\'' +
               ", procesador='" + procesador + '\'' +
               ", gpu='" + gpu + '\'' +
               ", fechaAlta=" + fechaAlta +
               '}';
    }
}
