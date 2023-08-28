package com.mycompany.gestorinventariosupermercado;

import java.util.ArrayList;

/**
 *
 * @author mati1
 */
public class Gestor {
    private ArrayList<Proveedor> proveedores;

    // Constructor
    public Gestor() {
        this.proveedores = new ArrayList<Proveedor>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    public Proveedor buscarProveedor(String nombre) {
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getNombre().equals(nombre)) {
                return proveedor;
            }
        }
        return null;
    }

    public void eliminarProveedor(String nombre) {
        Proveedor proveedor = this.buscarProveedor(nombre);
        if (proveedor != null) {
            this.proveedores.remove(proveedor);
        }
    }
}
