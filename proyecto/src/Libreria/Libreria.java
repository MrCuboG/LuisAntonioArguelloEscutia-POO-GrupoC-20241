package Libreria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Libreria {
    
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private Usuario usuarioEnSesion;

    public Libreria() {
        Gerente gerente = new Gerente("limy", "Tinajero", "4433544310", "13/11/2005",20000, "hfdgdigfji", "GFHBGFD", "limy13_", "13Noviembre");
        Asistente asistente = new Asistente("Juan", "Rivera", "4433210990","13/11/1985", 15000, "RUJU1234123", "juan3424", "limy13");
        usuarios.put(Rol.GERENTE, new ArrayList<>(Arrays.asList(gerente)));
        usuarios.put(Rol.ASISTENTE, new ArrayList<>(Arrays.asList(asistente)));

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
    

    // Usuario verificarInicioSesion(String nombreUsuario, String contrasena) { 
    //     for(Usuario i : usuarios) {
    //         if(i.getNombreUsuario().equals(nombreUsuario)) {
    //             if(i.getContrasena().equals(contrasena)) {
    //                 usuarioEnSesion = i;
    //                 return i; //puede ser retornar el usuario
    //             }
    //         }
    //     }
    //     return null; //si no retornar un null
    // }

    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String fechaNacimiento = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contraseña = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, telefono, fechaNacimiento, nombreUsuario, contraseña);

        if(!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)

        }

        usuarios.get(Rol.CLIENTE).add(cliente); //aqui lo agrega en un lista especifica de clientes
        System.out.println("\nCliente registrado exitosamente");
    }

    public void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Registrar libro ----");
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nTítulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Libro libro = new Libro(titulo, autor, genero, idioma, precio);
        libros.add(libro);
        System.out.println("\nRegistro exitoso");
    }


    public void registrarAsistente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String fechaNacimiento = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contraseña = datosComun.get(5);
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        

        Asistente asistente = new Asistente(nombre, apellido, telefono, fechaNacimiento, sueldo, rfc.toUpperCase(), nombreUsuario, contraseña);
        
        if(!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)
        }

        usuarios.get(Rol.ASISTENTE).add(asistente); //aqui lo agrega en un lista especifica de clientes

        System.out.println("\nRegistro exitoso");
    }

    public void registrarGerente() {
    ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);

    String nombre = datosComun.get(0);
    String apellido = datosComun.get(1);
    String telefono = datosComun.get(2);
    String fechaNacimiento = datosComun.get(3);
    String nombreUsuario = datosComun.get(4);
    String contraseña = datosComun.get(5);
    System.out.print("RFC: ");
    String rfc = scanner.nextLine();
    System.out.print("INE: ");
    String ine = scanner.nextLine();
    System.out.print("Sueldo: ");
    double sueldo = scanner.nextDouble();

    scanner.nextLine(); // Consume the newline left-over

    Gerente gerente = new Gerente(nombre, apellido, telefono,fechaNacimiento, sueldo, rfc.toUpperCase(), ine.toUpperCase(), nombreUsuario, contraseña);

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
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente"; //operador ternario, es lo mismo que un if y es para no tantas condiciones
       
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        System.out.print("---- Fecha de Nacimiento ----");
        System.out.println("Dia:");
        int day = scanner.nextInt();
        System.out.println("Mes:");
        int month = scanner.nextInt();
        System.out.println("Año:");
        int year = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        String fechaNacimiento = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, fechaNacimiento, nombreUsuario, contraseña)); //te agrega todos estos datos de un jalon
        return datosComun;
    }


    public void mostrarLibros() {
        if(libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados aún");
        }
        else {
            System.out.println("\nLibros en la biblioteca");
            int x = 1;
            for(Libro i : libros) {
                System.out.println("\n---- Libro " + x + " ----\n");
                System.out.println(i.getData());
                x++;
            }
        }
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        int x = 1;

        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) { //iterando hashmap cliente
            Cliente cliente = (Cliente) usuario;         //parseo
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
    
    // public void mostrarAsistentes() {
    //     System.out.println("\nAsistentes en la biblioteca");
    //     int x = 1;
    //     for(Usuario i : usuarios) {
    //         if(i.getRol() == Rol.ASISTENTE) {
    //             Asistente asistente = (Asistente) i;         //parseo
    //             System.out.println("\n---- Asistente " + x + " ----\n");
    //             System.out.println(asistente.toString());
    //             x++;
    //         }
    //     }
    // }

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
    
    // public void mostrarGerentes() {
    //     System.out.println("\nGerentes en la biblioteca");
    //     int x = 1;
    //     for(Usuario i : usuarios) {
    //         if(i.getRol() == Rol.GERENTE) {
    //             Gerente gerente = (Gerente) i;         //parseo
    //             System.out.println("\n---- Gerente " + x + " ----\n");
    //             System.out.println(gerente.toString());
    //             x++;
    //         }
    //     }
    // }


    // public void eliminarUsuario (Rol rol) {
    //     Scanner scanner = new Scanner(System.in);
    //     boolean band = false;
    //     System.out.println("\n---- Eliminar usuario ----\n");
    //     System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
    //     String nombreUsuario = scanner.nextLine();
    //     for (Usuario i : usuarios) {
    //         if (i.getNombreUsuario().equals(nombreUsuario)) {
    //             band = true;
    //             if (i.getRol() == Rol.CLIENTE && rol == Rol.CLIENTE) {
    //                 int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
    //                 int y = i.getId();
    //                 i.setCANTIDAD_USUARIOS();
    //                 usuarios.remove(i);
    //                 for(int c = 0; c < x; c++) {
    //                     usuarios.get(y - 1).setId();;
    //                     y++;
    //                 }
    //             }
    //             else if (i.getRol() == Rol.ASISTENTE && rol == Rol.ASISTENTE) {
    //                 int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
    //                 int y = i.getId();
    //                 i.setCANTIDAD_USUARIOS();
    //                 usuarios.remove(i);
    //                 for(int c = 0; c < x; c++) {
    //                     usuarios.get(y - 1).setId();;
    //                     y++;
    //                 }                    
    //             }   
    //             else {
    //                 if (!usuarioEnSesion.getNombreUsuario().equals(nombreUsuario)) {
    //                     int x = Usuario.getCANTIDAD_USUARIOS() - i.getId();
    //                     int y = i.getId();
    //                     i.setCANTIDAD_USUARIOS();
    //                     usuarios.remove(i);
    //                     for(int c = 0; c < x; c++) {
    //                         usuarios.get(y - 1).setId();
    //                         y++;
    //                     }
    //                 }
    //                 else {
    //                     System.out.println("\nNo puedes eliminarte a ti mismo");
    //                     break;
    //                 }
    //             }
    //             System.out.println("\nUsuario eliminado");
    //             break;
    //         }
    //     }
    //     if(band == false) {
    //         System.out.println("\nEste nombre no pertenece a ningún usuario");
    //     }
    // }
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
    


    // public String registrarTelefonoUsuario() {
    //     Scanner scanner = new Scanner(System.in);
    //     boolean telefonoExistente = true;
    //     String telefono = "";

    //     do {
    //         System.out.println("\nIngresa el telefono: ");
    //         telefono = scanner.nextLine();

    //         telefonoExistente = false;
    //         for(Usuario i : usuarios) {
    //             if(i.getTelefono().equals(telefono)) {
    //                 telefonoExistente = true;
    //                 break;
    //             }
    //         }

    //         if(telefonoExistente) {
    //             System.out.println("El telefono ya se encuentra registrado. Intenta de nuevo.");
    //         }
    //     }
    //     while(telefonoExistente);
    //     return telefono;
    // }
// Definir un solo Scanner como atributo de clase para reutilizarlo
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


    // public String registrarNombreUsuario() {
    //     Scanner scanner = new Scanner(System.in);
    //     String nombreUsuario = "";
    //     boolean nombreUsuarioExistente = true;
    //     do {
    //         System.out.println("\nIngresa el nombre de usuario: ");
    //         nombreUsuario = scanner.nextLine();

    //         nombreUsuarioExistente = false;
    //         for(Usuario i : usuarios) {
    //             if(i.getNombreUsuario().equals(nombreUsuario)) {
    //                 nombreUsuarioExistente = true;
    //                 break;
    //             }
    //         }

    //         if(nombreUsuarioExistente) {
    //             System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
    //         }
    //     }
    //     while(nombreUsuarioExistente);
    //     return nombreUsuario;
    // }
    // Asumiendo que el Scanner se ha movido como atributo de la clase para su reutilización
// private Scanner scanner = new Scanner(System.in);

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
