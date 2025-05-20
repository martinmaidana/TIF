// Archivo: Main.java
package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int ultimoId = 1;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE BIENVENIDA ===");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salida del menú");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulo();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void crearArticulo() {
        System.out.println("\n--- CREAR ARTÍCULO ---");

        System.out.print("Ingrese el nombre del artículo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el precio del artículo: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        Articulo nuevo = new Articulo(ultimoId++, nombre, precio);
        lista.add(nuevo);
        System.out.println("Artículo creado con éxito.");
    }

    public static void listarArticulo() {
        System.out.println("\n--- LISTA DE ARTÍCULOS ---");

        if (lista.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            for (Articulo a : lista) {
                a.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        listarArticulo();

        if (lista.isEmpty()) return;

        System.out.print("\nIngrese el ID del artículo a modificar: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Articulo articulo = null;
        for (Articulo a : lista) {
            if (a.id == id) {
                articulo = a;
                break;
            }
        }

        if (articulo == null) {
            System.out.println("ID no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = sc.nextLine();

        System.out.print("Nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        articulo.nombre = nuevoNombre;
        articulo.precio = nuevoPrecio;

        System.out.println("Artículo modificado con éxito.");
    }

    public static void eliminarArticulo() {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        boolean eliminado = lista.removeIf(a -> a.id == id);

        if (eliminado) {
            System.out.println("Artículo eliminado con éxito.");
        } else {
            System.out.println("No se encontró el artículo con ese ID.");
        }
    }
}
