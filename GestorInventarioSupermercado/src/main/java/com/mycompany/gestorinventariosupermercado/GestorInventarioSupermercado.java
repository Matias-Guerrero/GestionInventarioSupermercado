package com.mycompany.gestorinventariosupermercado;

import java.io.*;

public class GestorInventarioSupermercado {
    // Metodos Auxiliares
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
        
        int opcionPrincipal;

        do {
            limpiarPantalla();
            System.out.println("=============================================");
            System.out.println("Sistema de Gestión de Productos y Proveedores");
            System.out.println("=============================================");
            System.out.println("Seleccione una opción:");
            System.out.println("1) Trabajar con Proveedores");
            System.out.println("2) Trabajar con Productos");
            System.out.println("3) Salir");
            System.out.print("Opción: ");
            
            opcionPrincipal = Integer.parseInt(lector.readLine());
            
            switch (opcionPrincipal) {
                case 1:
                    // Menú de Proveedores
                    int opcionProveedor;
                    do {
                        limpiarPantalla();
                        System.out.println("=============================================");
                        System.out.println("Menú de Proveedores");
                        System.out.println("=============================================");
                        System.out.println("1) Agregar Proveedor");
                        System.out.println("2) Eliminar Proveedor");
                        System.out.println("3) Buscar Proveedor");
                        System.out.println("4) Mostrar Lista de Productos Suministrados");
                        System.out.println("5) Regresar al Menú Principal");
                        System.out.print("Opción: ");
                        
                        opcionProveedor = Integer.parseInt(lector.readLine());
                        
                        switch (opcionProveedor) {
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
                                // Mostrar Lista de Productos Suministrados
                                // ========================================

                                break;
                            case 5:
                                // Regresar al Menú Principal
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        
                        System.out.println();
                        pausar();
                        lector.readLine(); // Limpia el buffer del lector

                    } while (opcionProveedor != 5);
                    break;

                case 2:
                    // Menú de Productos
                    int opcionProducto;
                    do {
                        limpiarPantalla();
                        System.out.println("=============================================");
                        System.out.println("Menú de Productos");
                        System.out.println("=============================================");
                        System.out.println("1) Agregar Producto");
                        System.out.println("2) Eliminar Producto");
                        System.out.println("3) Buscar Producto");
                        System.out.println("4) Mostrar Productos y su stock");
                        System.out.println("5) Regresar al Menú Principal");
                        System.out.print("Opción: ");
                        
                        opcionProducto = Integer.parseInt(lector.readLine());
                        
                        switch (opcionProducto) {
                            case 1:
                                // Agregar Producto
                                // ... (Código para agregar producto)
                                break;
                            case 2:
                                // Eliminar Producto
                                // ... (Código para eliminar producto)
                                break;
                            case 3:
                                // Buscar Producto
                                // ... (Código para buscar producto)
                                break;
                            case 4:
                                // Mostrar Productos y su stock
                                // ... (Código para mostrar productos y su stock)
                                break;
                            case 5:
                                // Regresar al Menú Principal
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        
                        System.out.println();
                        pausar();
                        lector.readLine(); // Limpia el buffer del lector

                    } while (opcionProducto != 5);
                    break;

                case 3:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
            System.out.println();
            pausar();
            lector.readLine(); // Limpia el buffer del lector

        } while (opcionPrincipal != 3);

        lector.close();
    }
}