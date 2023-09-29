package gestorsupermercadoinventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.List;

public class Gestor {
    private ArrayList<Proveedor> proveedores;
    private HashMap<String, Producto> mapaProductos;

    // Constructor
    public Gestor() {
        this.proveedores = new ArrayList<Proveedor>(); // Inicializa el ArrayList de proveedores
        this.mapaProductos = new HashMap<String, Producto>(); // Inicializa el HashMap de productos
    }

    // Getters
    public ArrayList<Proveedor> getProveedores() {
        return this.proveedores;
    }

    public HashMap<String, Producto> getMapaProductos() {
        return this.mapaProductos;
    }

    // Setters
    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setMapaProductos(HashMap<String, Producto> mapaProductos) {
        this.mapaProductos = mapaProductos;
    }
    
    // Metodos
    public boolean agregarProductoAProveedor(String nombreProveedor, Producto producto) {
        Proveedor proveedor = this.buscarProveedor(nombreProveedor);
        
        if (proveedor != null) {
            if (proveedor.agregarProductoSuministrado(producto)) {

                // Agrega el producto al HashMap de productos
                if (this.mapaProductos.containsKey(producto.getNombre())) {
                    // Se obtiene el codigo de barra del producto que ya existe
                    producto.setCodigoBarra(this.mapaProductos.get(producto.getNombre()).getCodigoBarra());
                    
                    // Se obtiene el producto del HashMap y se actualiza su cantidad en stock
                    Producto productoExistente = this.mapaProductos.get(producto.getNombre());
                    productoExistente.actualizarStock(producto.getCantidadStock(), true);

                } else {
                    producto.setCodigoBarra(Producto.generarCodigoBarra());
                    this.mapaProductos.put(producto.getNombre(), producto);
                }

                return true;
            }
        }
        
        return false;
    }

    public Producto eliminarProductoAProveedor(String nombreProveedor, String nombreProducto, int cantidadEliminar){
        Proveedor proveedor = this.buscarProveedor(nombreProveedor);
        
        if (proveedor != null) {
            Producto producto = proveedor.buscarProductoSuministrado(nombreProducto);
            
            if (producto != null) {
                proveedor.eliminarProductoSuministrado(nombreProducto);

                // Se obtiene el producto del HashMap y se actualiza su cantidad en stock
                Producto productoExistente = this.mapaProductos.get(producto.getNombre());
                productoExistente.actualizarStock(cantidadEliminar, false);

                // Si el producto se queda sin stock, se elimina del HashMap
                if (productoExistente.getCantidadStock() == 0) {
                    this.mapaProductos.remove(producto.getNombre());
                }

                return producto;
            }
        }
        
        return null;
    }
    
    public Proveedor buscarProveedor(String nombreProveedor) {
        
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getNombre().equals(nombreProveedor)) {
                return proveedor;
            }
        }
        
        return null;
    }

    public void mostrarProductosSuministrados(String nombreProveedor) {
        Proveedor proveedor = this.buscarProveedor(nombreProveedor);
        
        if (proveedor != null) {
            proveedor.mostrarProductosSuministrados();
        }
        else {
            System.out.println("No se encontró el proveedor");
        }
    }

    public void mostrarProductosStock() {
        System.out.println("Listado de Productos en Stock");
        System.out.println("=============================");

        // Se muestran los productos y su stock por columnas
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Nombre", "Codigo de Barra", "Precio", "Cantidad en Stock");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "======", "===============", "======", "=================");

        for (Producto producto : this.mapaProductos.values()) {
            System.out.printf("%-20s %-20s %-20s %-20s\n", producto.getNombre(), producto.getCodigoBarra(), producto.getPrecio(), producto.getCantidadStock());
        }
    }
    
    public void cargarDatosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            Proveedor proveedor = null;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // Ignorar líneas en blanco
                }

                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    // Esto indica una línea de proveedor
                    String nombreProveedor = partes[0];
                    String correoElectronico = partes[1];
                    proveedor = new Proveedor(nombreProveedor, correoElectronico);
                    proveedores.add(proveedor);
                } else if (partes.length == 3 && proveedor != null) {
                    // Esto indica una línea de producto
                    String nombreProducto = partes[0];
                    double precio = Double.parseDouble(partes[1]);
                    int cantidadStock = Integer.parseInt(partes[2]);
                    Producto producto = new Producto(nombreProducto, precio, cantidadStock);
                    proveedor.agregarProductoSuministrado(producto);
                    mapaProductos.put(nombreProducto, producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Proveedor proveedor : proveedores) {
                // Escribir los datos del proveedor en una línea
                bw.write(proveedor.getNombre() + "," + proveedor.getCorreoElectronico());
                bw.newLine(); // Nueva línea para separar proveedores de productos

                for (Producto producto : proveedor.getProductosSuministrados()) {
                    // Escribir los datos del producto en una línea
                    bw.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidadStock());
                    bw.newLine(); // Nueva línea para separar productos
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Producto> obtenerProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}