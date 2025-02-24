package com.mycompany.serviciotecnico.model;

public class Servicio {
    private int idServicio;  // id_servicio (clave primaria)
    private String descripcion; // descripcion del servicio
    private double costo;      // costo del servicio

    // Constructor vacío
    public Servicio() {}

    // Constructor con parámetros
    public Servicio(int idServicio, String descripcion, double costo) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    // Getters y Setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    // Método toString para mostrar la información del servicio
    @Override
    public String toString() {
        return "Servicio{" +
               "idServicio=" + idServicio +
               ", descripcion='" + descripcion + '\'' +
               ", costo=" + costo +
               '}';
    }
}
