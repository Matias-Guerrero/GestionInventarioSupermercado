package gestorsupermercadoinventario;

import java.util.ArrayList;
import java.util.Currency;

public class Proveedor {
    private String nombreProveedor;
    private String correoElectronico;
    private ArrayList<Producto> productosSuministrados;

    // Constructor
    public Proveedor(String nombreProveedor, String correoElectronico) {
        this.nombreProveedor = nombreProveedor;
        this.correoElectronico = correoElectronico;
        this.productosSuministrados = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return this.nombreProveedor;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public ArrayList<Producto> getProductosSuministrados() {
        return this.productosSuministrados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombreProveedor = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setProductosSuministrados(ArrayList<Producto> productosSuministrados) {
        this.productosSuministrados = productosSuministrados;
    }

    // Metodos

    public boolean agregarProductoSuministrado(Producto producto) {
        if (this.buscarProductoSuministrado(producto.getNombre()) == null) {
            this.productosSuministrados.add(producto);
            return true;
        }

        return false;
    }

    public Producto eliminarProductoSuministrado(String nombreProducto) {
        Producto producto = this.buscarProductoSuministrado(nombreProducto);

        if (producto != null) {
            this.productosSuministrados.remove(producto);
        }

        return producto;
    }

    public Producto buscarProductoSuministrado(String nombreProducto) {
        for (Producto producto : this.productosSuministrados) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }

        return null;
    }

    // Sobrecarga del metodo
    public Producto buscarProductoSuministrado(String nombreProducto, String nombreProveedor){
        for (Producto producto : this.productosSuministrados) {
            if (producto.getNombre().equals(nombreProducto) && this.nombreProveedor.equals(nombreProveedor)) {
                return producto;
            }
        }

        return null;
    }

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

class ProveedorLocal extends Proveedor {
    private String region;

    public ProveedorLocal(String nombreProveedor, String correoElectronico, String region) {
        super(nombreProveedor, correoElectronico);
        this.region = region;
    }
    
    @Override
    public void mostrarProductosSuministrados() {
        super.mostrarProductosSuministrados(); // Llama al método de la superclase
        System.out.println("Región: " + region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

class ProveedorInternacional extends Proveedor {
    private String pais;

    public ProveedorInternacional(String nombreProveedor, String correoElectronico, String pais) {
        super(nombreProveedor, correoElectronico);
        this.pais = pais;
    }
    
    @Override
    public void mostrarProductosSuministrados() {
        super.mostrarProductosSuministrados(); // Llama al método de la superclase
        System.out.println("Pais: " + pais);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}