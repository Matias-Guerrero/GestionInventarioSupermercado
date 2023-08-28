package com.mycompany.gestorinventariosupermercado;

import java.time.LocalDate;

/**
 *
 * @author mati1
 */
public class Producto {
    private String nombre;
    private String codigoBarra;
    private String descripcion;
    private double precio;
    private String categoria;
    private int cantidadStock;
    private LocalDate fechaVencimiento; // Si es un producto perecedero

    // Constructor
    public Producto(String nombre, String codigoBarra, String descripcion, double precio, String categoria,
            int cantidadStock, LocalDate fechaVencimiento) {
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidadStock = cantidadStock;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getCodigoBarra() {
        return this.codigoBarra;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getCantidadStock() {
        return this.cantidadStock;
    }

    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Otros métodos
    public void aumentarStock(int cantidad) {
        this.cantidadStock += cantidad;
    }

    public void disminuirStock(int cantidad) {
        this.cantidadStock -= cantidad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Código de barra: " + this.codigoBarra);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Precio: " + this.precio);
        System.out.println("Categoría: " + this.categoria);
        System.out.println("Cantidad en stock: " + this.cantidadStock);
        System.out.println("Fecha de vencimiento: " + this.fechaVencimiento);
    }
}
