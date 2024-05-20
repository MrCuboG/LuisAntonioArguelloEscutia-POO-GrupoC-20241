package libreria.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import libreria.Libreria;

import static libreria.Libreria.usuarios;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolUsuario = rol == Rol.CLIENTE ? "CLIENTE" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.print("\nIngresa los siguientes datos para continuar");
        System.out.print("\nIngresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa los Apellidos: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        scanner.nextLine(); // Limpiar el buffer del Scanner
        System.out.print("Ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingresa tu día de nacimiento: ");
        int dia = scanner.nextInt();
        System.out.print("Ingresa tu mes de nacimiento (número): ");
        int mes = scanner.nextInt();
        System.out.print("Ingresa tu año de nacimiento: ");
        int año = scanner.nextInt();

        // Formatear la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoFormateada = fechaNacimiento.format(formatter);

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimientoFormateada));
        return datosComun;
    }

    private static String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);

        boolean telefonoExistente = true;
        String telefono = "";
        do {
            System.out.print("Ingresa el teléfono: ");
            telefono = scanner.nextLine();

            telefonoExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Libreria.usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
                }

                if (telefonoExistente) {
                    System.out.println("\nEl telefono ya se encuentra registrado. Intenta de nuevo.");
                }
            }
        } while (telefonoExistente);

        return telefono;
    }

    private static String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);

        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.print("Ingresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Libreria.usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }

                if (nombreUsuarioExistente) {
                    System.out.println("\nYa existe un registro con ese nombre de usuario. Intenta de nuevo.");
                }
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }
}

