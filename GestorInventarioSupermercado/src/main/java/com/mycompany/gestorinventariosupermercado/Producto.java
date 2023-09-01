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
    public Producto(String nombreProducto,double precio, int cantidadStock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.codigoBarra = Producto.generarCodigoBarra();
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

    // Métodos

    // Método para generar un codigo de barra aleatorio
    public static String generarCodigoBarra() {
        String codigoBarra = "";

        for (int i = 0; i < 13; i++) {
            codigoBarra += (int) (Math.random() * 10);
        }

        return codigoBarra;
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
