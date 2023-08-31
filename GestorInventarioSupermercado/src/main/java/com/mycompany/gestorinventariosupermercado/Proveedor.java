package com.mycompany.gestorinventariosupermercado;

import java.util.ArrayList;

public class Proveedor {
    private String nombre;
    private String correo; 
    private ArrayList<Producto> productosSuministrados;

    // Constructor
    public Proveedor(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.productosSuministrados = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public ArrayList<Producto> getProductosSuministrados() {
        return this.productosSuministrados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo; 
    }

    public void agregarProducto(Producto producto) {
        this.productosSuministrados.add(producto);
    }

    public void eliminarProducto(String codigoBarra) {
        for (Producto producto : this.productosSuministrados) {
            if (producto.getCodigoBarra().equals(codigoBarra)) {
                this.productosSuministrados.remove(producto);
                break;
            }
        }
    }

    public Producto buscarProducto(String codigoBarra) {
        for (Producto producto : this.productosSuministrados) {
            if (producto.getCodigoBarra().equals(codigoBarra)) {
                return producto;
            }
        }
        return null;
    }
}