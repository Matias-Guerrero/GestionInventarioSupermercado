package gestorsupermercadoinventario.excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta establecer un precio negativo
 * para un producto.
 */
public class PrecioNegativoException extends Exception {
    
    /**
     * Constructor de la excepción PrecioNegativoException.
     *
     * @param mensaje Mensaje de error que describe la razón de la excepción.
     */
    public PrecioNegativoException(String mensaje) {
        super(mensaje);
    }
}
