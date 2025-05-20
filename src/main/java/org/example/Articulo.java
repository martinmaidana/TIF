package org.example;

public class Articulo {
    int id;
    String nombre;
    double precio;

    public Articulo(int id, String nombre, double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    void mostrar(){
        System.out.println("ID: "+ id + " | Nombre " + nombre + " |Precio: $" + precio);
    }
}
