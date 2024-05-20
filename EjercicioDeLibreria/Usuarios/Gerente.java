package Usuarios;

import Usuarios.utils.EmpleadoUtils;
import Usuarios.utils.Rol;
import libreria.Libreria;
import libreria.util.DatosComun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static libreria.Libreria.usuarios;
import static libreria.util.DatosComun.obtenerDatosComun;

public class Gerente extends Usuario implements EmpleadoUtils {
    private double sueldo;
    private String rfc;
    private String INE;

    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String INE, String nombreUsuario, String contraseña, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contraseña, fechaNacimiento);
        this.sueldo = sueldo;
        this.INE = INE;
        this.rfc = rfc;
    }

    @Override

    public String toString() { //Aqui  lo estamos sobre escribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",
                super.toString(), this.sueldo, this.rfc, this.INE);
    }

    public static void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrando Gerente.....");
        System.out.println("Ingresar los siguientes datos para continuar");
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        scanner.nextLine(); // Limpiar el buffer del Scanner

        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();

        System.out.print("Ingresa la INE: ");
        String INE = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc, INE, nombreUsuario, contraseña,fechaNacimiento);
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente registrado exitosamente...");
    }


    public static void mostrarGerente() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
            }
        }
    }

    public static void EliminarGerente(int idGerente, String nombreUsuario) {
        Usuario gerente = null;
        Usuario usuarioEliminar = null;

        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            if (usuario instanceof Gerente && usuario.getId() == idGerente) {
                gerente = usuario;
                break;
            }
        }

        if (gerente == null) {
            System.out.println("\nNo se encontró ningún gerente con ese ID.");
            return;
        }

        for (Usuario usuario : usuarios.values().stream().flatMap(List::stream).toList()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                usuarioEliminar = usuario;
                break;
            }
        }

        if (usuarioEliminar != null && usuarioEliminar instanceof Gerente && usuarioEliminar.getNombreUsuario().equals(nombreUsuario)) {
            usuarios.get(Rol.GERENTE).remove(gerente);
            System.out.println("\nGerente eliminado exitosamente.");
        } else {
            System.out.println("\nEl usuario no es un gerente o el nombre de usuario no coincide. No se puede eliminar al gerente.");
        }
    }

    @Override
    public void checarEntrada() {
        System.out.println("Checar entrada con huella");
    }

    @Override
    public void checarSalida() {
        System.out.println("Checar Salida con huella");
    }

}
