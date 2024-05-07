package Libreria.libros;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Libreria.libros.utils.constants.Genero;

public class Libro {

    private static int CANTIDAD_LIBROS = 1;
    private String titulo, autor, idioma;
    private Genero genero;
    private double precio;
    private int id;
    private int stock;

    public Libro(String titulo, String autor, Genero genero, String idioma, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.precio = precio;
        this.id = CANTIDAD_LIBROS;
        this.stock = stock;
        CANTIDAD_LIBROS++;
    }

    public String getData() {
        return String.format("Título: %s \nAutor: %s \nGénero: %s \nID: %d \nIdioma: %s \nPrecio: %.2f", titulo, autor, genero, id, idioma, precio);
    }

    public void registrarLibro() {
        
    }

    
}
