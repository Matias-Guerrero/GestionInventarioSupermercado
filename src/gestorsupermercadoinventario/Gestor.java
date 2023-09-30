package gestorsupermercadoinventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Clase que representa un gestor para administrar proveedores y productos en un supermercado.
 */
public class Gestor {
    private ArrayList proveedores;
    private HashMap<String, Producto> mapaProductos;

    /**
     * Constructor de la clase Gestor.
     * Inicializa el ArrayList de proveedores y el HashMap de productos.
     */
    public Gestor() {
        this.proveedores = new ArrayList(); // Inicializa el ArrayList de proveedores
        this.mapaProductos = new HashMap<String, Producto>(); // Inicializa el HashMap de productos
    }
    
    // Metodos
    /**
     * Agrega un producto a un proveedor existente.
     *
     * @param nombreProveedor Nombre del proveedor.
     * @param producto        Producto a agregar.
     * @return True si se agrega con éxito, False en caso contrario.
     */
    public boolean agregarProductoAProveedor(String nombreProveedor, Producto producto) throws StockNegativoException, PrecioNegativoException {
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
    
    /**
     * Elimina un producto de un proveedor.
     *
     * @param nombreProveedor  Nombre del proveedor.
     * @param nombreProducto   Nombre del producto a eliminar.
     * @param cantidadEliminar Cantidad del producto a eliminar.
     * @return Producto eliminado o null si no se encuentra.
     */
    public Producto eliminarProductoAProveedor(String nombreProveedor, String nombreProducto, int cantidadEliminar) throws StockNegativoException{
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
    
    /**
     * Busca un proveedor por nombre.
     *
     * @param nombreProveedor Nombre del proveedor a buscar.
     * @return Proveedor encontrado o null si no se encuentra.
     */
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
    
    /**
     * Muestra la lista de productos suministrados por un proveedor.
     *
     * @param nombreProveedor Nombre del proveedor.
     */
    public void mostrarProductosSuministrados(String nombreProveedor) {
        Proveedor proveedor = this.buscarProveedor(nombreProveedor);
        
        if (proveedor != null) {
            proveedor.mostrarProductosSuministrados();
        }
        else {
            System.out.println("No se encontró el proveedor");
        }
    }
    
    /**
     * Muestra la lista de productos y su stock.
     */
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
    
    /**
     * Carga datos desde un archivo en el formato especificado.
     *
     * @param nombreArchivo Nombre del archivo desde donde cargar datos.
     */
    public void cargarDatosDesdeArchivo(String nombreArchivo) throws StockNegativoException, PrecioNegativoException {
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
    
    /**
     * Guarda datos en un archivo en el formato especificado.
     *
     * @param nombreArchivo Nombre del archivo donde guardar datos.
     */
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
    
    /**
     * Filtra productos por rango de stock.
     *
     * @param stockMinimo Stock mínimo.
     * @param stockMaximo Stock máximo.
     * @return Lista de productos filtrados.
     */
    public ArrayList<Producto> filtrarProductosPorStock(int stockMinimo, int stockMaximo) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : mapaProductos.values()) {
            int cantidadStock = producto.getCantidadStock();
            if (cantidadStock >= stockMinimo && cantidadStock <= stockMaximo) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }
    
    public StringBuilder generarInformeCSV() {
        StringBuilder informe = new StringBuilder();

        // Encabezados del informe
        informe.append("NombreProveedor,CorreoElectronico,NombreProducto,CodigoBarra,Precio,CantidadStock,TipoProveedor\n");

        // Iterar sobre los proveedores y sus productos
        for (Object objProveedor : proveedores) {
            if (objProveedor instanceof Proveedor) {
                Proveedor proveedor = (Proveedor) objProveedor;
                String tipoProveedor = proveedor instanceof ProveedorLocal ? "Local" : "Internacional";

                for (Producto producto : proveedor.getProductosSuministrados()) {
                    // Agregar información al informe
                    informe.append(proveedor.getNombre()).append(",");
                    informe.append(proveedor.getCorreoElectronico()).append(",");
                    informe.append(producto.getNombre()).append(",");
                    informe.append(producto.getCodigoBarra()).append(",");
                    informe.append(producto.getPrecio()).append(",");
                    informe.append(producto.getCantidadStock()).append(",");
                    informe.append(tipoProveedor).append("\n");
                }
            }
        }

        return informe;
    }
    
    
    public void generarInformeExcel() {
        try {
            // Crear un nuevo libro de Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File("informe.xls"));

            // Crear una hoja de Excel
            WritableSheet sheet = workbook.createSheet("Informe", 0);

            // Encabezados del informe
            String[] headers = {"NombreProveedor", "CorreoElectronico", "NombreProducto", "CodigoBarra", "Precio", "CantidadStock", "TipoProveedor"};

            // Crear la primera fila con encabezados
            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            // Iterar sobre los proveedores y sus productos
            int rowNum = 1; // Comenzar desde la segunda fila
            for (Object objProveedor : proveedores) {
                if (objProveedor instanceof Proveedor) {
                    Proveedor proveedor = (Proveedor) objProveedor;
                    String tipoProveedor = proveedor instanceof ProveedorLocal ? "Local" : "Internacional";

                    for (Producto producto : proveedor.getProductosSuministrados()) {
                        // Agregar información a la fila
                        sheet.addCell(new Label(0, rowNum, proveedor.getNombre()));
                        sheet.addCell(new Label(1, rowNum, proveedor.getCorreoElectronico()));
                        sheet.addCell(new Label(2, rowNum, producto.getNombre()));
                        sheet.addCell(new Label(3, rowNum, producto.getCodigoBarra()));
                        sheet.addCell(new jxl.write.Number(4, rowNum, producto.getPrecio()));
                        sheet.addCell(new jxl.write.Number(5, rowNum, producto.getCantidadStock()));
                        sheet.addCell(new Label(6, rowNum, tipoProveedor));

                        rowNum++;
                    }
                }
            }

            // Escribir y cerrar el libro
            workbook.write();
            workbook.close();

            System.out.println("Informe generado y guardado en informe.xls");
        } catch (IOException | jxl.write.WriteException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el informe en archivo Excel.");
        }
    }

}