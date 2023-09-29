package gestorsupermercadoinventario;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase principal que representa el sistema de gestión de productos suministrados por proveedores.
 * Esta clase contiene el método principal `main` que inicia la aplicación.
 *
 */
public class GestorSupermercadoInventario {
    
    // Metodos Auxiliares
    
    /**
     * Limpia la pantalla de la consola según el sistema operativo.
     */
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
        catch (final IOException e) {  
        }
    }
    
    /**
     * Pausa la ejecución del programa y espera que el usuario presione ENTER.
     */
    public static void pausar() {
        System.out.println("Presione ENTER para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

    /**
     * Método principal de la aplicación que inicia la interfaz de usuario y maneja las operaciones.
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     * @throws IOException Excepción de E/S en caso de errores.
     */
    public static void main(String[] args) throws IOException, StockNegativoException, PrecioNegativoException {
        // TODO code application logic here
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Gestor gestor = new Gestor(); // Crea una instancia del Gestor

        // Cargar datos iniciales
        gestor.cargarDatosDesdeArchivo("datos.txt");
        
        VentanaInicio ventana = new VentanaInicio(gestor);
        ventana.setVisible(true);
        
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
            System.out.println("6) Editar Producto a Proveedor");
            System.out.println("7) Filtrar Productos por Stock");
            System.out.println("8) Salir");
            System.out.println("=============================================================");
            System.out.print("Opcion: ");

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
                    // ================================
                    // Editar Producto de Proveedor
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
                    Producto productoEditar = proveedor.buscarProductoSuministrado(nombreProducto, nombreProveedor);

                    if (productoEditar == null) {
                        System.out.println("No se encontró el producto.");
                        break;
                    }

                    // Se solicitan los nuevos datos para el producto
                    System.out.println("Ingrese el nuevo nombre del producto: ");
                    String nuevoNombre = lector.readLine();

                    System.out.println("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecio = Double.parseDouble(lector.readLine());

                    System.out.println("Ingrese la nueva cantidad en stock del producto: ");
                    int nuevaCantidadStock = Integer.parseInt(lector.readLine());

                    // Se modifica el producto
                    proveedor.modificarProductoSuministrado(nombreProducto, nuevoNombre, nuevoPrecio, nuevaCantidadStock);
                    System.out.println("Producto modificado con éxito.");
                    break;
                case 7:
                    // ========================================
                    // Filtar por cantidad de Stock
                    // ========================================  
                    
                    // Solicitar la cantidad mínima y máxima
                    System.out.println("Ingrese la cantidad minima de stock: ");
                    int stockMinimo = Integer.parseInt(lector.readLine());
                    
                    System.out.println("Ingrese la cantidad maxima de stock: ");
                    int stockMaximo = Integer.parseInt(lector.readLine());
                    
                    // Se filtran los productos 
                    ArrayList<Producto> productosFiltrados = gestor.filtrarProductosPorStock(stockMinimo, stockMaximo);
                    
                    if(productosFiltrados.isEmpty() == true){
                        System.out.println("No hay Productos con Stock entre " + stockMinimo + " y " + stockMaximo + ":");  
                    }
                    else{
                        //Se muestran los productos filtrados
                        System.out.println("Productos con Stock entre " + stockMinimo + " y " + stockMaximo + ":");

                        for(Producto productoActual: productosFiltrados){
                            System.out.println(productoActual.obtenerInformacion());
                        }
                    }
                    
                    
                   
                    break;
                case 8:
                    // ========================================
                    // Salir
                    // ========================================
                    
                    // Guardar datos al salir de la aplicación
                    gestor.guardarDatosEnArchivo("datos.txt");
                    
                    // Generar Reporte
                    // Llamar al método para generar el informe en formato CSV
                    StringBuilder informeCSV = gestor.generarInformeCSV();

                    // Guardar el informe en un archivo
                    try (PrintWriter writer = new PrintWriter(new FileWriter("informe.csv"))) {
                        writer.println(informeCSV);
                        System.out.println("Informe generado y guardado en informe.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error al guardar el informe en archivo.");
                    }
                    
                    System.out.println("Saliendo...");

                    pausar();

                    lector.close();

                    System.exit(0);
                default:
                    System.out.println("Opcion inválida.");
                    break;
            }

            pausar();

            // Se limpia el buffer
            lector.readLine();
        }
    }
    
}