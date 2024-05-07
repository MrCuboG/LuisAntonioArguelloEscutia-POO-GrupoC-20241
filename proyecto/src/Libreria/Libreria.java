package Libreria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import Libreria.libros.Libro;
import Libreria.libros.utils.constants.Genero;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

public class Libreria {
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<Genero, ArrayList<Libro>>();
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private Usuario usuarioEnSesion;

    public Libreria() {
        Gerente gerente = new Gerente("limy", "Tinajero", "4433544310", 20000, "hfdgdigfji", "GFHBGFD", "limy13_",
                "13Noviembre");
        Asistente asistente = new Asistente("Juan", "Rivera", "4433210990", 15000, "RUJU1234123", "juan3424", "limy13");
        usuarios.put(Rol.GERENTE, new ArrayList<>(Arrays.asList(gerente)));
        usuarios.put(Rol.ASISTENTE, new ArrayList<>(    Arrays.asList(asistente)));

    }

    Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    usuarioEnSesion = usuario;
                    return usuario;
                }
            }
        }
        return null;
    }

    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>()); // eso va a entrar cuando la llave no exista, o sea que
                                                                 // el hash este vacio, si no lo va a ignorar (en la
                                                                 // segunda vez)

        }

        usuarios.get(Rol.CLIENTE).add(cliente); // aqui lo agrega en un lista especifica de clientes
        System.out.println("\nCliente registrado exitosamente");
    }

    

    public void registrarAsistente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc.toUpperCase(), nombreUsuario,
                contraseña);

        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>()); // eso va a entrar cuando la llave no exista, o sea
                                                                   // que el hash este vacio, si no lo va a ignorar (en
                                                                   // la segunda vez)
        }

        usuarios.get(Rol.ASISTENTE).add(asistente); // aqui lo agrega en un lista especifica de clientes

        System.out.println("\nRegistro exitoso");
    }

    public void registrarGerente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("INE: ");
        String ine = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left-over

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc.toUpperCase(), ine.toUpperCase(),
                nombreUsuario, contraseña);

        // Agregar al HashMap, verificando si la llave ya existe
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nRegistro exitoso");
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente"; 

        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña)); // te agrega todos
                                                                                                 // estos datos de un
                                                                                                 // jalon
        return datosComun;
    }


    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        int x = 1;

        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) { // iterando hashmap cliente
            Cliente cliente = (Cliente) usuario; // parseo
            System.out.println("\n---- Cliente " + x + " ----\n");
            System.out.println(cliente.toString());
            x++;
        }
    }

    public void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        int x = 1;
        if (usuarios.containsKey(Rol.ASISTENTE)) {
            for (Usuario usuario : usuarios.get(Rol.ASISTENTE)) {
                Asistente asistente = (Asistente) usuario;
                System.out.println("\n---- Asistente " + x + " ----\n");
                System.out.println(asistente.toString());
                x++;
            }
        }
    }

    public void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca");
        int x = 1;
        if (usuarios.containsKey(Rol.GERENTE)) {
            for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
                Gerente gerente = (Gerente) usuario;
                System.out.println("\n---- Asistente " + x + " ----\n");
                System.out.println(gerente.toString());
                x++;
            }
        }
    }

    public void eliminarUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Eliminar usuario ----\n");
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String nombreUsuario = scanner.nextLine();

        if (usuarios.containsKey(rol)) {
            ArrayList<Usuario> listaUsuarios = usuarios.get(rol);
            boolean encontrado = false;

            Iterator<Usuario> it = listaUsuarios.iterator();
            while (it.hasNext()) {
                Usuario usuario = it.next();
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    if (!usuarioEnSesion.getNombreUsuario().equals(nombreUsuario)) {
                        it.remove(); // Elimina de forma segura usando Iterator
                        System.out.println("\nUsuario eliminado exitosamente.");
                    } else {
                        System.out.println("\nNo puedes eliminarte a ti mismo.");
                    }
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\nEste nombre no pertenece a ningún usuario en el rol de " + rol);
            }
        } else {
            System.out.println("\nNo hay usuarios registrados con el rol de " + rol);
        }
    }

    private Scanner scanner = new Scanner(System.in);

    public String registrarTelefonoUsuario() {
        boolean telefonoExistente = true;
        String telefono = "";

        do {
            System.out.println("\nIngresa el teléfono: ");
            telefono = scanner.nextLine();
            telefonoExistente = false;

            // Iterar sobre todas las listas de usuarios en el HashMap
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        System.out.println("El teléfono ya se encuentra registrado. Intenta de nuevo.");
                        break;
                    }
                }
                if (telefonoExistente) {
                    break; // Salir del bucle externo si se encuentra el teléfono
                }
            }
        } while (telefonoExistente);

        return telefono;
    }

    public String registrarNombreUsuario() {
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;

        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;

            // Iterar sobre todas las listas de usuarios en el HashMap
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
                        break;
                    }
                }
                if (nombreUsuarioExistente) {
                    break; // Salir del bucle externo si se encuentra el nombre de usuario
                }
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

}
