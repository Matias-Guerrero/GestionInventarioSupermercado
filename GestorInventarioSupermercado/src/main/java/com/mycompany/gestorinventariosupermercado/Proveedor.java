package com.mycompany.gestorinventariosupermercado;

import java.util.ArrayList;

public class Proveedor {
    private String nombre;
    private String direccion;
    private String informacionContacto;
    private ArrayList<Producto> productosSuministrados;

    // Constructor
    public Proveedor(String nombre, String direccion, String informacionContacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.informacionContacto = informacionContacto;
        this.productosSuministrados = new ArrayList<>();
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

    public ArrayList<Producto> getProductosSuministrados() {
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