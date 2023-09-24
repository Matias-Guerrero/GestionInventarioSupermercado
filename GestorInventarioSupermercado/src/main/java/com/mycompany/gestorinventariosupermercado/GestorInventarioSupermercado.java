package com.mycompany.gestorinventariosupermercado;

import java.io.*;

public class GestorInventarioSupermercado {
    // Metodos Auxiliares
    public static void limpiarPantalla() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows")) {  
              Runtime.getRuntime().exec("cls");  
            }
            else {  
              Runtime.getRuntime().exec("clear");  
            } 
        }  
        catch (final Exception e) {  
          e.printStackTrace();  
        }
    }

    public static void pausar() {
        System.out.println("Presione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Gestor gestor = new Gestor(); // Crea una instancia del Gestor

        // Cargar datos iniciales
        gestor.cargarDatosDesdeArchivo("datos.txt");
        
        while (true) {
            int opcion;

            limpiarPantalla();
            System.out.println("=============================================================");
            System.out.println("Sistema de Gestion de Productos Suministrados por Proveedores");
            System.out.println("=============================================================");
            System.out.println("1) Agregar Producto a Proveedor");
            System.out.println("2) Eliminar Producto a Proveedor");
            System.out.println("3) Buscar Producto de Proveedor");
            System.out.println("4) Lista de Productos de Proveedor");
            System.out.println("5) Mostrar Productos y su stock");
            System.out.println("6) Salir");
            System.out.println("=============================================================");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    // ================================
                    // Agregar Producto a Proveedor
                    // ================================
                    // Se solicita el nombre del proveedor
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String nombreProveedor = lector.readLine();

                    // Se solicita el nombre del producto y sus datos
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreProducto = lector.readLine();

                    System.out.println("Ingrese el precio del producto: ");
                    double precio = Double.parseDouble(lector.readLine());

                    System.out.println("Ingrese la cantidad en stock del producto: ");
                    int cantidadStock = Integer.parseInt(lector.readLine());

                    // Se crea el producto
                    Producto producto = new Producto(nombreProducto, precio, cantidadStock);

                    // Se agrega el producto al proveedor
                    if (gestor.agregarProductoAProveedor(nombreProveedor, producto)) {
                        System.out.println("Producto agregado con éxito.");
                    } else {
                        System.out.println("No se pudo agregar el producto.");
                    }

                    break;
                case 2:
                    // ================================
                    // Eliminar Proveedor a Proveedor
                    // ================================
                    
                    // Se solicita el nombre del proveedor
                    System.out.println("Ingrese el nombre del proveedor: ");
                    nombreProveedor = lector.readLine();

                    // Se solicita el nombre del producto
                    System.out.println("Ingrese el nombre del producto: ");
                    nombreProducto = lector.readLine();

                    // Se verifica cuanto stock tiene el producto en el proveedor
                    Proveedor proveedor = gestor.buscarProveedor(nombreProveedor);
                    Producto productoExistente = proveedor.buscarProductoSuministrado(nombreProducto);
                    int stockActual = productoExistente.getCantidadStock();

                    // Se solicita la cantidad a eliminar dependiendo del stock actual
                    System.out.println("Ingrese la cantidad a eliminar (Stock actual: " + stockActual + "): ");
                    int cantidadEliminar = Integer.parseInt(lector.readLine());

                    // Se verifica que la cantidad a eliminar no sea mayor al stock actual
                    if (cantidadEliminar > stockActual) {
                        System.out.println("La cantidad a eliminar no puede ser mayor al stock actual.");
                        break;
                    }

                    // Se elimina el producto del proveedor
                    Producto productoEliminado = gestor.eliminarProductoAProveedor(nombreProveedor, nombreProducto, cantidadEliminar);

                    // Se verifica si el producto fue eliminado
                    if (productoEliminado != null) {
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar el producto.");
                    }

                    break;
                case 3:
                    // ================================
                    // Buscar Producto de Proveedor
                    // ================================
                    
                    // Se solicita el nombre del proveedor
                    System.out.println("Ingrese el nombre del proveedor: ");
                    nombreProveedor = lector.readLine();

                    // Se comprueba que el proveedor exista
                    proveedor = gestor.buscarProveedor(nombreProveedor);

                    if (proveedor == null) {
                        System.out.println("No se encontró el proveedor.");
                        break;
                    }

                    // Se solicita el nombre del producto
                    System.out.println("Ingrese el nombre del producto: ");
                    nombreProducto = lector.readLine();

                    // Se busca el producto en el proveedor
                    Producto productoBuscado = proveedor.buscarProductoSuministrado(nombreProducto, nombreProveedor);

                    if (productoBuscado == null) {
                        System.out.println("No se encontró el producto.");
                        break;
                    }

                    System.out.println("========================================");
                    System.out.println("Producto encontrado.");
                    System.out.println("========================================");

                    // Se muestra el producto
                    System.out.println("Nombre: " + productoBuscado.getNombre());
                    System.out.println("Codigo de Barra: " + productoBuscado.getCodigoBarra());
                    System.out.println("Precio: " + productoBuscado.getPrecio());
                    System.out.println("Cantidad en Stock: " + productoBuscado.getCantidadStock());
                    System.out.println("========================================");
                    
                    break;
                case 4:
                    // ========================================
                    // Mostrar Lista de Productos del Proveedor
                    // ========================================
                    
                    // Se solicita el nombre del proveedor
                    System.out.println("Ingrese el nombre del proveedor: ");
                    nombreProveedor = lector.readLine();

                    // Se comprueba que el proveedor exista
                    proveedor = gestor.buscarProveedor(nombreProveedor);

                    if (proveedor == null) {
                        System.out.println("No se encontró el proveedor.");
                        break;
                    }

                    // Se muestran los productos del proveedor
                    gestor.mostrarProductosSuministrados(nombreProveedor);
                    
                    break;
                case 5:
                    // ========================================
                    // Mostrar Productos y su Stock
                    // ========================================
                    
                    // Se muestran los productos y su stock
                    gestor.mostrarProductosStock();
                    break;
                case 6:
                    // ========================================
                    // Salir
                    // ========================================
                    
                    // Guardar datos al salir de la aplicación
                    gestor.guardarDatosEnArchivo("datos.txt");
                    
                    System.out.println("Saliendo...");

                    pausar();

                    lector.close();

                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            pausar();

            // Se limpia el buffer
            lector.readLine();
        }
    }
}