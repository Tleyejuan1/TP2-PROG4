package com.utn.restaurante.model; // Ruta completa de carpetas

// Esta clase es el molde para cada plato del menú [cite: 5]
public class Plato {
    private int numeroPlato; // El ID que pide el ejercicio [cite: 5]
    private String nombre;
    private double precio;
    private String descripcion;

    // Constructor vacío para Spring [cite: 12]
    public Plato() {}

    // Constructor para cargar datos rápido desde la consola
    public Plato(int numeroPlato, String nombre, double precio, String descripcion) {
        this.numeroPlato = numeroPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters y Setters para que la API pueda manejar los datos [cite: 8]
    public int getNumeroPlato() { return numeroPlato; }
    public void setNumeroPlato(int numeroPlato) { this.numeroPlato = numeroPlato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}