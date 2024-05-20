package Libros.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {

    public static ArrayList<String> registrarLibroDatosComun() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.print("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el nombre del autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ingresa la editorial del libro: ");
        String editorial = scanner.nextLine();

        System.out.print("Ingresa el dia de publicacion del libro: ");
        int diaPublicacion = scanner.nextInt();

        System.out.print("Ingresa el mes de publicacion del libro: ");
        int mesPublicacion = scanner.nextInt();

        System.out.print("Ingresa el año de publicacion del libro: ");
        int añoPublicacion = scanner.nextInt();

        LocalDate fecha = LocalDate.of(añoPublicacion, mesPublicacion, diaPublicacion);

        double precio;
        while (true) {
            scanner.nextLine();
            System.out.print("Ingresa el precio del libro: ");
            String precioStr = scanner.nextLine();
            if (!precioStr.isEmpty()) {
                try {
                    precio = Double.parseDouble(precioStr);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingresa un precio válido.");
                }
            } else {
                System.out.println("Por favor, ingresa un precio válido.");
            }
        }

        System.out.print("Ingresa el stock del libro: ");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, String.valueOf(fecha), String.valueOf(precio), String.valueOf(stock)));

        return datosComun;
    }
}


