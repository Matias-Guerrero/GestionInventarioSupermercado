package gestorsupermercadoinventario;

/**
 * Clase que representa un producto en el inventario de un supermercado.
 */
public class Producto {
    private String nombreProducto;
    private String codigoBarra;
    private double precio;
    private int cantidadStock;
  
    /**
     * Constructor de la clase Producto.
     *
     * @param nombreProducto Nombre del producto.
     * @param precio         Precio del producto.
     * @param cantidadStock  Cantidad en stock del producto.
     */
    public Producto(String nombreProducto,double precio, int cantidadStock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.codigoBarra = Producto.generarCodigoBarra();
    }

    // Getters
    
    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return this.nombreProducto;
    }
    
    /**
     * Obtiene el código de barras del producto.
     *
     * @return Código de barras del producto.
     */
    public String getCodigoBarra() {
        return this.codigoBarra;
    }
    
    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return this.precio;
    }
    
    /**
     * Obtiene la cantidad en stock del producto.
     *
     * @return Cantidad en stock del producto.
     */
    public int getCantidadStock() {
        return this.cantidadStock;
    }

    // Setters
    
    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombreProducto = nombre;
    }
    
    /**
     * Establece el código de barras del producto.
     *
     * @param codigoBarra Código de barras del producto.
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    
    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Establece la cantidad en stock del producto.
     *
     * @param cantidadStock Cantidad en stock del producto.
     */
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    // Métodos

    // Método para generar un codigo de barra aleatorio
    /**
     * Genera un código de barras aleatorio para el producto.
     *
     * @return Código de barras aleatorio.
     */
    public static String generarCodigoBarra() {
        String codigoBarra = "";

        for (int i = 0; i < 13; i++) {
            codigoBarra += (int) (Math.random() * 10);
        }

        return codigoBarra;
    }

    // Métodos de sobrecarga

    // Sobrecarga del método para actualizar el stock
    /**
     * Actualiza el stock del producto.
     *
     * @param nuevaCantidad Nueva cantidad en stock.
     */
    public void actualizarStock(int nuevaCantidad) {
        this.cantidadStock = nuevaCantidad;
    }
    
    /**
     * Actualiza el stock del producto con opción de aumentar o disminuir.
     *
     * @param nuevaCantidad Nueva cantidad en stock.
     * @param aumentar      True para aumentar, False para disminuir.
     */
    public void actualizarStock(int nuevaCantidad, boolean aumentar) {
        if (aumentar) {
            this.cantidadStock += nuevaCantidad;
        } else {
            this.cantidadStock -= nuevaCantidad;
        }
    }
    
    /**
     * Modifica los atributos del producto.
     *
     * @param nombre        Nuevo nombre del producto.
     * @param precio        Nuevo precio del producto.
     * @param cantidadStock Nueva cantidad en stock del producto.
     */
    public void modificarProducto(String nombre, double precio, int cantidadStock) {
        this.nombreProducto = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }
    
    /**
     * Obtiene información detallada del producto.
     *
     * @return Información del producto.
     */
    public String obtenerInformacion(){
        return "Nombre: " + this.nombreProducto +
               "\nCodigo de Barras: " + this.codigoBarra +
               "\nPrecio: " + this.precio +
               "\nCantidad en Stock: " + this.cantidadStock;
    }
}