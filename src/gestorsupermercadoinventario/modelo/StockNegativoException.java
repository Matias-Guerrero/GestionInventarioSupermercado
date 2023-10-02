package gestorsupermercadoinventario.modelo;

/**
 * Excepción personalizada que se lanza cuando se intenta actualizar el stock de un producto
 * con un valor que resultaría en un stock negativo.
 */
public class StockNegativoException extends Exception {
    
    /**
     * Constructor de la excepción StockNegativoException.
     *
     * @param mensaje Mensaje de error que describe la razón de la excepción.
     */
    public StockNegativoException(String mensaje) {
        super(mensaje);
    }
}