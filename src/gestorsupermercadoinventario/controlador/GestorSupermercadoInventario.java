package gestorsupermercadoinventario.controlador;

import gestorsupermercadoinventario.modelo.Gestor;
import gestorsupermercadoinventario.modelo.StockNegativoException;
import gestorsupermercadoinventario.modelo.PrecioNegativoException;
import gestorsupermercadoinventario.vista.VentanaInicio;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase principal que representa el sistema de gestión de productos suministrados por proveedores.
 * Esta clase contiene el método principal `main` que inicia la aplicación.
 *
 */
public class GestorSupermercadoInventario {
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
        ventana.pack(); 
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}