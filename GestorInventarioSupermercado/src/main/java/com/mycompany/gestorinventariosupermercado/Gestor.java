package com.mycompany.gestorinventariosupermercado;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mati1
 */
public class Gestor {
    private ArrayList<Proveedor> proveedores;
    private HashMap<String, Producto> mapaProductos;

    // Constructor
    public Gestor() {
        this.proveedores = new ArrayList<Proveedor>(); // Inicializa el ArrayList de proveedores
        this.mapaProductos = new HashMap<>(); // Inicializa el HashMap de productos
    }
    
    // Metodos
    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);

        // Actualiza el HashMap de productos con los productos del nuevo proveedor
        for (Producto producto : proveedor.getProductosSuministrados()) {
            mapaProductos.put(producto.getCodigoBarra(), producto);
        }
    }

    public void eliminarProveedor(String nombre) {
        Proveedor proveedor = this.buscarProveedor(nombre);
        if (proveedor != null) {
            this.proveedores.remove(proveedor);

            // Elimina los productos del proveedor del HashMap de productos
            for (Producto producto : proveedor.getProductosSuministrados()) {
                mapaProductos.remove(producto.getCodigoBarra());
            }
        }
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