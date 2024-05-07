package Libreria.libros.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> registarLibrosComun(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();


        System.out.println("\n---- Registrar libro ----");
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nTítulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("------Fecha de Publicacion------");
        System.out.println("Ingera el dia");
        int dia = scanner.nextInt();
        System.out.println("Ingera el mes");
        int mes = scanner.nextInt();
        System.out.println("Inserta el año");
        int ano = scanner.nextInt();
        LocalDate fecha = LocalDate.of(ano, mes, dia);
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.println("Stock");
        int stock = scanner.nextInt();


        datosComun.addAll(Arrays.asList(titulo, autor, idioma, String.valueOf(fecha), String.valueOf(precio), String.valueOf(stock)));
        return datosComun;
    }


}
