package gestorsupermercadoinventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Gestor {
    private ArrayList proveedores;
    private HashMap<String, Producto> mapaProductos;

    // Constructor
    public Gestor() {
        this.proveedores = new ArrayList(); // Inicializa el ArrayList de proveedores
        this.mapaProductos = new HashMap<String, Producto>(); // Inicializa el HashMap de productos
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
                    Producto productoNuevo = new Producto(producto.getNombre(), producto.getPrecio(), producto.getCantidadStock());
                    
                    productoNuevo.setCodigoBarra(Producto.generarCodigoBarra());
                    this.mapaProductos.put(producto.getNombre(), productoNuevo);
                }

                return true;
            }
        }
        
        return false;
    }

    public Producto eliminarProductoAProveedor(String nombreProveedor, String nombreProducto, int cantidadEliminar){
        Proveedor proveedor = this.buscarProveedor(nombreProveedor);
        
        if (proveedor != null) {
            Producto producto = proveedor.buscarProductoSuministrado(nombreProducto, nombreProveedor);
            
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
        for (Object proveedorObj : this.proveedores) {
            if (proveedorObj instanceof Proveedor) {
                Proveedor proveedor = (Proveedor) proveedorObj;
                if (proveedor.getNombre().equals(nombreProveedor)) {
                    return proveedor;
                }
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
            ProveedorLocal proveedorLocal = null;
            ProveedorInternacional proveedorInternacional = null;
            
            boolean local = false;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // Ignorar líneas en blanco
                }

                String[] partes = linea.split(",");
                
                if (partes.length == 4) {
                    // Esto indica una línea de proveedor
                    String nombreProveedor = partes[0];
                    String correoElectronico = partes[1];

                    if (linea.contains("Local,")) {
                        // Proveedor local
                        String region = partes[2];
                        proveedorLocal = new ProveedorLocal(nombreProveedor, correoElectronico, region);
                        proveedores.add(proveedorLocal);
                        local = true;
                    } else {
                        // Proveedor internacional
                        String pais = partes[2];
                        proveedorInternacional = new ProveedorInternacional(nombreProveedor, correoElectronico, pais);
                        proveedores.add(proveedorInternacional);
                        local = false;
                    }
                } else if (partes.length == 3) {
                    // Esto indica una línea de producto
                    String nombreProducto = partes[0];
                    double precio = Double.parseDouble(partes[1]);
                    int cantidadStock = Integer.parseInt(partes[2]);
                    Producto producto = new Producto(nombreProducto, precio, cantidadStock);
                    
                    System.out.println(producto.getCantidadStock());

                    // Agregar el producto al proveedor correspondiente
                    if (local == true) {
                        this.agregarProductoAProveedor(proveedorLocal.getNombre(), producto);
                    } else {
                        this.agregarProductoAProveedor(proveedorInternacional.getNombre(), producto);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Object proveedorObj : proveedores) {
                if (proveedorObj instanceof ProveedorLocal) {
                    ProveedorLocal proveedorLocal = (ProveedorLocal) proveedorObj;
                    // Escribir los datos del proveedor local en una línea
                    bw.write(proveedorLocal.getNombre() + "," + proveedorLocal.getCorreoElectronico() + ",Local," + proveedorLocal.getRegion());
                    bw.newLine(); // Nueva línea para separar proveedores de productos

                    // Escribir los datos de los productos suministrados por el proveedor local
                    for (Producto producto : proveedorLocal.getProductosSuministrados()) {
                        bw.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidadStock());
                        bw.newLine(); // Nueva línea para separar productos
                    }
                } else if (proveedorObj instanceof ProveedorInternacional) {
                    ProveedorInternacional proveedorInternacional = (ProveedorInternacional) proveedorObj;
                    // Escribir los datos del proveedor internacional en una línea
                    bw.write(proveedorInternacional.getNombre() + "," + proveedorInternacional.getCorreoElectronico() + ",Internacional," + proveedorInternacional.getPais());
                    bw.newLine(); // Nueva línea para separar proveedores de productos

                    // Escribir los datos de los productos suministrados por el proveedor internacional
                    for (Producto producto : proveedorInternacional.getProductosSuministrados()) {
                        bw.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidadStock());
                        bw.newLine(); // Nueva línea para separar productos
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}