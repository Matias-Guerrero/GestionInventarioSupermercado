/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorinventariosupermercado;

/**
 *
 * @author mati1
 */
public class Proveedor {
    private String nombre;
    private String direccion;
    private String informacionContacto;
    private Producto[] productosSuministrados;

    // Constructor
    public Proveedor(String nombre, String direccion, String informacionContacto, Producto[] productosSuministrados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.informacionContacto = informacionContacto;
        this.productosSuministrados = productosSuministrados;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getInformacionContacto() {
        return this.informacionContacto;
    }

    public Producto[] getProductosSuministrados() {
        return this.productosSuministrados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setInformacionContacto(String informacionContacto) {
        this.informacionContacto = informacionContacto;
    }

    public void setProductosSuministrados(Producto[] productosSuministrados) {
        this.productosSuministrados = productosSuministrados;
    }

    // Métodos
    public void agregarProducto(Producto producto) {
        Producto[] productos = new Producto[this.productosSuministrados.length + 1];
        for (int i = 0; i < this.productosSuministrados.length; i++) {
            productos[i] = this.productosSuministrados[i];
        }
        productos[productos.length - 1] = producto;
        this.productosSuministrados = productos;
    }

    public void eliminarProducto(String codigoBarra) {
        Producto[] productos = new Producto[this.productosSuministrados.length - 1];
        int j = 0;
        for (int i = 0; i < this.productosSuministrados.length; i++) {
            if (!this.productosSuministrados[i].getCodigoBarra().equals(codigoBarra)) {
                productos[j] = this.productosSuministrados[i];
                j++;
            }
        }
        this.productosSuministrados = productos;
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
