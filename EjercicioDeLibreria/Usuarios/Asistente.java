package Usuarios;

import Usuarios.utils.EmpleadoUtils;
import libreria.Libreria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Usuarios.utils.Rol;

import static libreria.Libreria.usuarios;
import static libreria.util.DatosComun.obtenerDatosComun;

import libreria.util.DatosComun;


public class Asistente extends Usuario implements EmpleadoUtils {

    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String rfc, String nombreUsuario, String contraseña, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contraseña, fechaNacimiento);
        this.fechaInicio = LocalDate.now();
        this.sueldo = sueldo;
        this.rfc = rfc;
    }


    @Override
    public String toString() { //Aqui  lo estamos sobreescribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Fecha de inicio: %s, Sueldo: %.3f, RFC: %s", super.toString(), fechaInicio, sueldo, rfc);
        // super.toString(), this.fechaInicio, this.sueldo, this.rfc, this.INE);
    }

    public static void registrarAsistentes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrando Asistente");
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.ASISTENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        System.out.print("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingresa el RFC: ");
        String rfc = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc, nombreUsuario, contraseña, fechaNacimiento);
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);
        System.out.println("\n Cliente registrado exitosamente...");

    }

    public static void mostrarAsistentes() {
        System.out.println("\n Asistentes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.ASISTENTE)) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(asistente.toString());
            }
        }
    }

    public static void EliminarAsistente(int idAsistente) {
        boolean encontrado = false;
        Iterator<Usuario> iterator = usuarios.get(Rol.ASISTENTE).iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario instanceof Asistente && ((Asistente) usuario).getId() == idAsistente) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nCliente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }

    @Override
    public void checarEntrada() {
        System.out.println("Checar entrada por correo");
    }

    @Override
    public void checarSalida() {
        System.out.println("Checar Salida por correo");
    }
}
