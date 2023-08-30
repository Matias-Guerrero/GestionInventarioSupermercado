package com.mycompany.gestorinventariosupermercado;

/**
 *
 * @author mati1
 */

public class Producto {
    private String nombreProducto;
    private String codigoBarra;
    private double precio;
    private int cantidadStock;
  
    // Constructor
    public Producto(String nombreProducto, String codigoBarra,double precio, int cantidadStock) {
        this.nombreProducto = nombreProducto;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Getters
    public String getNombre() {
        return this.nombreProducto;
    }

    public String getCodigoBarra() {
        return this.codigoBarra;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidadStock() {
        return this.cantidadStock;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombreProducto = nombre;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }


    // Métodos de sobrecarga

    // Sobrecarga del método para actualizar el stock
    public void actualizarStock(int nuevaCantidad) {
        this.cantidadStock = nuevaCantidad;
    }

    public void actualizarStock(int nuevaCantidad, boolean aumentar) {
        if (aumentar) {
            this.cantidadStock += nuevaCantidad;
        } else {
            this.cantidadStock -= nuevaCantidad;
        }
    }
}