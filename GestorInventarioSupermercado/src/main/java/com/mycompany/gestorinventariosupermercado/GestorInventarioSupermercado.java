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

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Gestor gestor = new Gestor(); // Crea una instancia del Gestor
        
        int opcion;
        
        do {
            limpiarPantalla();
            System.out.println("=============================================================");
            System.out.println("Sistema de Gestion de Productos suministrados por Proveedores");
            System.out.println("=============================================================");
            System.out.println("1) Agregar Producto en Proveedor");
            System.out.println("2) Eliminar Producto en Proveedor");
            System.out.println("3) Buscar Producto en Proveedor");
            System.out.println("4) Lista de Productos del Proveedor");
            System.out.println("5) Mostrar Productos y su stock");
            System.out.println("6) Salir");
            System.out.println("=============================================================");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    // ================================
                    // Agregar Proveedor
                    // ================================

                    break;
                case 2:
                    // ================================
                    // Eliminar Proveedor
                    // ================================

                    break;
                case 3:
                    // ================================
                    // Buscar Proveedor
                    // ================================

                    break;
                case 4:
                    // ========================================
                    // Mostrar Lista de Productos del Proveedor
                    // ========================================

                    break;
                case 5:
                    // ========================================
                    // Mostrar Productos y su Stock
                    // ========================================
                    
                    break;
                case 6:
                    // ========================================
                    // Salir
                    // ========================================                    
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            pausar();

        } while (opcion != 6);

        lector.close();
    }
}