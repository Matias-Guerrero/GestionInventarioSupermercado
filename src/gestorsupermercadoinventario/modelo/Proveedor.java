package gestorsupermercadoinventario.modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un proveedor de productos en el inventario de un supermercado.
 */
public class Proveedor {
    private String nombreProveedor;
    private String correoElectronico;
    private ArrayList<Producto> productosSuministrados;

    // Constructor
    /**
     * Constructor de la clase Proveedor.
     *
     * @param nombreProveedor   Nombre del proveedor.
     * @param correoElectronico Correo electrónico del proveedor.
     */
    public Proveedor(String nombreProveedor, String correoElectronico) {
        this.nombreProveedor = nombreProveedor;
        this.correoElectronico = correoElectronico;
        this.productosSuministrados = new ArrayList<>();
    }

    // Getters
    
    /**
     * Obtiene el nombre del proveedor.
     *
     * @return Nombre del proveedor.
     */
    public String getNombre() {
        return this.nombreProveedor;
    }
    
    /**
     * Obtiene el correo electrónico del proveedor.
     *
     * @return Correo electrónico del proveedor.
     */
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    /**
     * Obtiene la lista de productos suministrados por el proveedor.
     *
     * @return Lista de productos suministrados.
     */
    public ArrayList<Producto> getProductosSuministrados() {
        return this.productosSuministrados;
    }

    // Setters
    
    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre Nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombreProveedor = nombre;
    }
    
    /**
     * Establece el correo electrónico del proveedor.
     *
     * @param correoElectronico Correo electrónico del proveedor.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    /**
     * Establece la lista de productos suministrados por el proveedor.
     *
     * @param productosSuministrados Lista de productos suministrados.
     */
    public void setProductosSuministrados(ArrayList<Producto> productosSuministrados) {
        this.productosSuministrados = productosSuministrados;
    }

    // Metodos
    
    /**
     * Agrega un producto suministrado por el proveedor.
     *
     * @param producto Producto a agregar.
     * @return True si se agregó con éxito, false si el producto ya existe.
     */
    public boolean agregarProductoSuministrado(Producto producto) {
        if (this.buscarProductoSuministrado(producto.getNombre()) == null) {
            this.productosSuministrados.add(producto);
            return true;
        }

        return false;
    }
    
    /**
     * Elimina un producto suministrado por el proveedor.
     *
     * @param nombreProducto Nombre del producto a eliminar.
     * @return Producto eliminado o null si no se encontró.
     */
    public Producto eliminarProductoSuministrado(String nombreProducto) {
        Producto producto = this.buscarProductoSuministrado(nombreProducto);

        if (producto != null) {
            this.productosSuministrados.remove(producto);
        }

        return producto;
    }
    
    /**
     * Busca un producto suministrado por nombre.
     *
     * @param nombreProducto Nombre del producto a buscar.
     * @return Producto encontrado o null si no se encontró.
     */
    public Producto buscarProductoSuministrado(String nombreProducto) {
        for (Producto producto : this.productosSuministrados) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }

        return null;
    }

    // Sobrecarga del metodo
    
    /**
     * Busca un producto suministrado por nombre del producto y por nombre del proveedor.
     *
     * @param nombreProducto Nombre del producto a buscar.
     * @param nombreProveedor Nombre del proveedor a buscar.
     * @return Producto encontrado o null si no se encontró.
     */
    public Producto buscarProductoSuministrado(String nombreProducto, String nombreProveedor){
        for (Producto producto : this.productosSuministrados) {
            if (producto.getNombre().equals(nombreProducto) && this.nombreProveedor.equals(nombreProveedor)) {
                return producto;
            }
        }

        return null;
    }
    
    /**
     * Muestra los productos suministrados por el proveedor.
     */
    public void mostrarProductosSuministrados(){
        System.out.println("Productos suministrados por " + this.nombreProveedor + ":");
        System.out.println("========================================");

        for (Producto producto : this.productosSuministrados) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Codigo de Barra: " + producto.getCodigoBarra());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad en Stock: " + producto.getCantidadStock());
            System.out.println("========================================");
        }
    }
    
    /**
     * Modifica un producto suministrado por el proveedor.
     *
     * @param nombreProducto Nombre del producto a modificar.
     * @param nuevoNombre Nuevo nombre del producto.
     * @param nuevoPrecio Nuevo precio del producto.
     * @param nuevaCantidadStock Nueva cantidad en stock del producto.
     * @return true si la modificación es exitosa, false si el producto no se encuentra.
     */
    public boolean modificarProductoSuministrado(String nombreProducto, String nuevoNombre, double nuevoPrecio, int nuevaCantidadStock) {
        Producto producto = buscarProductoSuministrado(nombreProducto);

        if (producto != null) {
            producto.modificarProducto(nuevoNombre, nuevoPrecio, nuevaCantidadStock);
            return true;
        }

        return false;
    }
}

// Subclases de Proveedor

/**
 * Clase que representa un proveedor local, subclase de Proveedor.
 */
class ProveedorLocal extends Proveedor {
    private String region;
    
    /**
     * Constructor de la clase ProveedorLocal.
     *
     * @param nombreProveedor   Nombre del proveedor.
     * @param correoElectronico Correo electrónico del proveedor.
     * @param region            Región del proveedor local.
     */
    public ProveedorLocal(String nombreProveedor, String correoElectronico, String region) {
        super(nombreProveedor, correoElectronico);
        this.region = region;
    }
    
    /**
     * Sobrescribe el método para mostrar los productos suministrados por el proveedor local.
     */
    @Override
    public void mostrarProductosSuministrados() {
        super.mostrarProductosSuministrados(); // Llama al método de la superclase
        System.out.println("Región: " + region);
    }
    
    /**
     * Obtiene la región del proveedor local.
     *
     * @return Región del proveedor local.
     */
    public String getRegion() {
        return region;
    }
    
    /**
     * Establece la región del proveedor local.
     *
     * @param region Región del proveedor local.
     */
    public void setRegion(String region) {
        this.region = region;
    }
}

/**
 * Clase que representa un proveedor internacional, subclase de Proveedor.
 */
class ProveedorInternacional extends Proveedor {
    private String pais;
    
    /**
     * Constructor de la clase ProveedorInternacional.
     *
     * @param nombreProveedor   Nombre del proveedor.
     * @param correoElectronico Correo electrónico del proveedor.
     * @param pais              País del proveedor internacional.
     */
    public ProveedorInternacional(String nombreProveedor, String correoElectronico, String pais) {
        super(nombreProveedor, correoElectronico);
        this.pais = pais;
    }
    
    /**
     * Sobrescribe el método para mostrar los productos suministrados por el proveedor internacional.
     */
    @Override
    public void mostrarProductosSuministrados() {
        super.mostrarProductosSuministrados(); // Llama al método de la superclase
        System.out.println("Pais: " + pais);
    }
    
    /**
     * Obtiene el país del proveedor internacional.
     *
     * @return País del proveedor internacional.
     */
    public String getPais() {
        return pais;
    }
    
    /**
     * Establece el país del proveedor internacional.
     *
     * @param pais País del proveedor internacional.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}