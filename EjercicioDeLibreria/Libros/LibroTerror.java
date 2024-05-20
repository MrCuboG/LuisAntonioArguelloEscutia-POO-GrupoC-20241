package Libros;

import Libros.constants.Genero;
import Libros.constants.TerrorSubgenero;
import Libros.util.LibrosUtils;
import libreria.Libreria;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class LibroTerror extends Libro {

    private TerrorSubgenero subgenero;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock, TerrorSubgenero subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.TERROR, stock);
        this.subgenero = subgenero;
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libro de Terror");
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        TerrorSubgenero subgeneroInput = null;
        System.out.println("Ingresa el subgenero del libro");
        System.out.println("1.- Psicológico");
        System.out.println("2.- Monjas");
        System.out.print("Ingresa tu opcion: ");
        int opcionSubgenero = scanner.nextInt();
        Genero genero = Genero.TERROR;
        try {
            switch (opcionSubgenero) {
                case 1:
                    subgeneroInput = TerrorSubgenero.PSICOLOGICO;
                    break;
                case 2:
                    subgeneroInput = TerrorSubgenero.MONJAS;
                    break;
                default:
                    throw new IllegalArgumentException("Opción no válida");
            }

        } catch (Exception e) {
            System.out.println("Ingrese una opcion valida");
            return;
        }
        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fecha, precio, stock, subgeneroInput);
        Libreria.libros.get(Genero.TERROR).add(libroTerror);
    }

    @Override
    public void filtrarPorPrecioMeyorA(double precio) {
        Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getPrecio() > precio)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getAutor().toUpperCase().startsWith(inicial.toUpperCase()))
                .forEach(libro -> System.out.println(libro.toString()));
    }
        //.anyMatch(libro -> libro.getAutor().toLowerCase().contains(inicial));


    @Override
    public void filtrarPorTituloContiene(String palabraClave) {
        Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getNombre().toLowerCase().contains(palabraClave.toLowerCase()))
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarPorAñoPublicacion(int año) {
        boolean encontrado = false;
        for (Libro libro : Libreria.libros.get(Genero.TERROR)) {
            if (libro instanceof LibroTerror && libro.getFechaPublicacion().getYear() == año) {
                System.out.println(libro.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay libros publicados en el año " + año);
        }
    }

    @Override
    public void filtrarPorEditorial(String editorial) {
        Libreria.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getEditorial().equalsIgnoreCase(editorial))
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() +
                "Nombre: " + this.getNombre() +
                ", Autor: " + this.getAutor() +
                ", Editorial: " + this.getEditorial() +
                ", Fecha de Publicación: " + this.getFechaPublicacion() +
                ", Precio: " + this.getPrecio() +
                ", Stock: " + this.getStock() +
                ", Subgénero: " + this.subgenero;
    }


}
