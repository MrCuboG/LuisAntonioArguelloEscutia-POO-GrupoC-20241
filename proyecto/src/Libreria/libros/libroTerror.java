package Libreria.libros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Libreria.libros.utils.LibrosUtils;
import Libreria.libros.utils.constants.Genero;
import Libreria.libros.utils.constants.TerorSubgeneros;

public class libroTerror extends Libro {
    private TerorSubgeneros subgenero;
    public libroTerror(String titulo, String autor, String idioma, double precio, int stock, TerorSubgeneros subgenero) {
        super(titulo, autor, Genero.TERROR, idioma, precio, stock);
        this.subgenero = subgenero;
    }

    public static void registarLibro(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.registarLibrosComun();

        String titulo = datosComun.get(0);
        String autor = datosComun.get(1);
        String idioma = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        TerorSubgeneros terorSubgeneros = null;
        int opcionSubgenero = 0;

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("1.Psicologico");
        System.out.println("2.Monjas");
        
        opcionSubgenero = scanner.nextInt();

        if (opcionSubgenero == 1) {
            terorSubgeneros = TerorSubgeneros.PSICOLOGICO;
        }else{
            terorSubgeneros = TerorSubgeneros.MONJAS;
        }
        libroTerror libroTerror = new libroTerror(titulo, autor, idioma, precio, stock, terorSubgeneros);

    }

}
