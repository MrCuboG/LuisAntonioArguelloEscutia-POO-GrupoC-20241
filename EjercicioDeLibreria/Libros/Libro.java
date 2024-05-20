package Libros;

import Libros.constants.Genero;

import java.time.LocalDate;
import java.util.Date;

//Streams: Es una coleccion de datos que nos ayudara a concatenar funciones especificas, ejemplo: filter, map, anyMatch

/*
1.- Filtrar los libros que tengan un precio arriba de (parametro)
2.- FIltrar libros que tengan un autor que su nombre inicia con la letra (parametro)
 */

public abstract class Libro {

    private static int CANTIDAD_LIBROS = 1;

    private int id;

    private String nombre;

    private String autor;

    private String editorial;

    private LocalDate fechaPublicacion;

    private double precio;

    private Genero genero;

    private int stock;
    private String subgenero;

    public Libro(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, Genero genero, int stock) {
        this.id = CANTIDAD_LIBROS;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.genero = genero;
        this.stock = stock;
        CANTIDAD_LIBROS++;
    }

    protected abstract void filtrarPorPrecioMeyorA(double precio);

    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);

    public abstract void filtrarPorTituloContiene(String palabraClave);

    public abstract void filtrarPorAñoPublicacion(int año);

    public abstract void filtrarPorEditorial(String editorial);

    public double getPrecio() {
        return precio;
    }

    public String getAutor() {
        return autor;
    }
    @Override
    public String toString() {
        return "ID: " + this.id +
                ", Nombre: " + this.nombre +
                ", Autor: " + this.autor +
                ", Editorial: " + this.editorial +
                ", Fecha de Publicación: " + this.fechaPublicacion +
                ", Precio: " + this.precio +
                ", Stock: " + this.stock;
    }

    public static int getCantidadLibros() {
        return CANTIDAD_LIBROS;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getStock() {
        return 0;
    }

    public void setId(int i) {
    }
}

/*
- Hacer el registro de los 3 tipos de libros
- Hacer la eliminacion
- Listado con filtros, El lsitado tiene que inclir minimo 3 filtros diferentes ( no usar los que vimos en clase)
 */