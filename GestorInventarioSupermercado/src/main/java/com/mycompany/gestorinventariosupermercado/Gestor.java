package com.mycompany.gestorinventariosupermercado;

import java.util.ArrayList;
import java.util.HashMap;

public class Gestor {
    private ArrayList<Proveedor> proveedores;
    private HashMap<String, Producto> mapaProductos;

    // Constructor
    public Gestor() {
        this.proveedores = new ArrayList<Proveedor>(); // Inicializa el ArrayList de proveedores
        this.mapaProductos = new HashMap<>(); // Inicializa el HashMap de productos
    }
    
    // Metodos
    public void agregarProveedor(String nombre, String correo) {
        Proveedor busquedaProveedor = this.buscarProveedor(nombre);
        
        if(busquedaProveedor != null){
            Proveedor proveedor = new Proveedor(nombre, correo);
            
            this.proveedores.add(proveedor);
            
            System.out.println("El Proveedor se agrego exitosamente a la base de datos.");
        }
        else {
            System.out.print("El Proveedor ya existe en la base de datos.");
        }
    }
    
    // Metodo de Sobrecarga
    public void agregarProveedor(String nombre, String correo, ArrayList<Producto> productos) {
        Proveedor busquedaProveedor = this.buscarProveedor(nombre);

        if(busquedaProveedor != null){
            Proveedor proveedor = new Proveedor(nombre, correo);
            
            this.proveedores.add(proveedor);
            
            System.out.println("El Proveedor se agrego exitosamente a la base de datos.");

            // Actualiza el HashMap de productos con los productos del nuevo proveedor y si ya existen, actualiza el stock
            for (Producto producto : productos) {
                Producto busquedaProducto = this.mapaProductos.get(producto.getCodigoBarra());
                if (busquedaProducto != null) {
                    busquedaProducto.actualizarStock(producto.getCantidadStock(), true);
                }
                else {
                    this.mapaProductos.put(producto.getCodigoBarra(), producto);
                }
            }
        }
        else {
            System.out.print("El Proveedor ya existe en la base de datos.");
        }
    }

    public Proveedor eliminarProveedor(String nombre) {
        Proveedor proveedor = this.buscarProveedor(nombre);

        if (proveedor != null) {
            this.proveedores.remove(proveedor);

            // Elimina los productos del proveedor del HashMap de productos y actualiza el stock, si el producto llega a 0, lo elimina del HashMap
            for (Producto producto : proveedor.getProductosSuministrados()) {
                Producto busquedaProducto = this.mapaProductos.get(producto.getCodigoBarra());
                
                if (busquedaProducto != null) {
                    busquedaProducto.actualizarStock(producto.getCantidadStock(), false);
                    
                    if (busquedaProducto.getCantidadStock() == 0) {
                        this.mapaProductos.remove(producto.getCodigoBarra());
                    }
                }
            }

            return proveedor;
        }

        return null;
    }
    
    public Proveedor buscarProveedor(String nombre) {
        
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getNombre().equals(nombre)) {
                return proveedor;
            }
        }
        
        return null;
    }
}