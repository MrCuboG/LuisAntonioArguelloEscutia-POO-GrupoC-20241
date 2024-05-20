package libreria;

import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.constants.AccionSubgenero;
import Libros.constants.ComediaSubgenero;
import Libros.constants.TerrorSubgenero;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import Libros.Libro;
import Libros.constants.Genero;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.*;

public class Libreria {

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Libreria() {
        inicializarHashMaps();
        Asistente asistente = new Asistente("Juan", "Rivera", "443831893122", 15000, "RUJU231231", "juan123", "12345", "23/02/2004");
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Gerente gerente = new Gerente("Lalo", "Lopez", "4471178990", 20000, "LOME121590A1", "L2919OOME", "Lalito12", "12lolo", "02/03/2000");
        usuarios.get(Rol.GERENTE).add(gerente);

    }

    private void inicializarHashMaps() {
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public void registrarClientes() {
        Cliente.registrarClientes();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void EliminarCliente(int idCliente) {
        Cliente.EliminarCliente(idCliente);
    }

    public void registrarAsistentes() {
        Asistente.registrarAsistentes();
    }

    public void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }

    public void EliminarAsistente(int idAsistente) {
        Asistente.EliminarAsistente(idAsistente);
    }

    public void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void mostrarGerente() {
        Gerente.mostrarGerente();
    }

    public void EliminarGerente(int idGerente, String nombreUsuario) {
        Gerente.EliminarGerente(idGerente, nombreUsuario);
    }

    public void registrarLibroTerror() {
        LibroTerror.registrarLibro();
    }

    public void registrarLibroComedia(){
        LibroComedia.registrarLibro();
    }

    public void registrarLibroAccion(){
        LibroAccion.registrarLibro();
    }

    public void mostrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Mostrar Libros ---");
        System.out.println("1.- Libros de Terror");
        System.out.println("2.- Libros de Comedia");
        System.out.println("3.- Libros de Accion");
        System.out.print("Ingresa tu opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("--- LIBROS DE TERROR ---");
                System.out.println("--- Tipo de muestreo ---");
                System.out.println("1.- General");
                System.out.println("2.- Filtrar por mayor A");
                System.out.println("3.- Filtrar por inicial del autor");
                System.out.println("4.- Filtrar por Palabra clave");
                System.out.println("5.- Filtrar por año de publicacion");
                System.out.println("6.- Filtrar por Editorial");
                System.out.print("Ingresa tu opcion: ");
                int opcionGeneral = scanner.nextInt();
                scanner.nextLine();

                switch (opcionGeneral) {
                    case 1:
                        System.out.println("--- GENERAL ---");
                        List<Libro> librosTerror = Libreria.libros.get(Genero.TERROR);
                        if (librosTerror.isEmpty()) {
                            System.out.println("No hay libros registrados en esta categoría.");
                        } else {
                            for (Libro libro : librosTerror) {
                                System.out.println(libro.toString());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("--- Filtrar por mayor A ---");
                        System.out.print("Ingresa el precio: ");
                        double precioMayorA = scanner.nextDouble();
                        scanner.nextLine();
                        LibroTerror libroTerror = new LibroTerror("", "", "", LocalDate.now(), precioMayorA, 0, TerrorSubgenero.PSICOLOGICO);
                        libroTerror.filtrarPorPrecioMeyorA(precioMayorA);
                        break;
                    case 3:
                        System.out.println("--- Filtrar inicial del Autor ---");
                        System.out.print("Ingresa la inicial del Autor: ");
                        String inicialAutor = scanner.nextLine().toUpperCase();
                        boolean encontradoAutor = false;
                        for (Libro libro : Libreria.libros.get(Genero.TERROR)) {
                            if (libro.getAutor().toUpperCase().startsWith(inicialAutor)) {
                                System.out.println(libro.toString());
                                encontradoAutor = true;
                            }
                        }
                        if (!encontradoAutor) {
                            System.out.println("No se encontraron libros con la inicial del Autor: " + inicialAutor);
                        }
                        break;

                    case 4:
                        System.out.println("--- Filtrar por palabra clave ---");
                        System.out.print("Ingresa una palabra clave del Título: ");
                        String palabraClave = scanner.nextLine().toLowerCase();
                        boolean encontradoPalabraClave = false;
                        for (Libro libro : Libreria.libros.get(Genero.TERROR)) {
                            if (libro.getNombre().toLowerCase().contains(palabraClave)) {
                                System.out.println(libro.toString());
                                encontradoPalabraClave = true;
                            }
                        }
                        if (!encontradoPalabraClave) {
                            System.out.println("No hay libros con el título que contiene la palabra clave: " + palabraClave);
                        }
                        break;

                    case 5:
                        System.out.println("--- Filtrar por Año de Publicacion ---");
                        try {
                            System.out.print("Ingresa el año: ");
                            int año = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            boolean encontradoAño = false;
                            for (Libro libro : Libreria.libros.get(Genero.TERROR)) {
                                if (libro instanceof LibroTerror && libro.getFechaPublicacion().getYear() == año) {
                                    System.out.println(libro.toString());
                                    encontradoAño = true;
                                }
                            }
                            if (!encontradoAño) {
                                System.out.println("No hay libros publicados en el año " + año);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un año válido.");
                            scanner.next(); // Limpiar el buffer
                        }
                        break;

                    case 6:
                        System.out.println("--- Filtrar por Editorial ---");
                        System.out.print("Ingresa la Editorial de libro: ");
                        String editorialLibro = scanner.nextLine();
                        boolean encontradoEditorial = false;
                        for (Libro libro : Libreria.libros.get(Genero.TERROR)) {
                            if (libro.getEditorial().equalsIgnoreCase(editorialLibro)) {
                                System.out.println(libro.toString());
                                encontradoEditorial = true;
                            }
                        }
                        if (!encontradoEditorial) {
                            System.out.println("No se encontraron libros con la editorial: " + editorialLibro);
                        }
                        break;


                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;

            case 2:
                System.out.println("--- LIBROS DE COMEDIA ---");
                System.out.println("--- Tipo de muestreo ---");
                System.out.println("1.- General");
                System.out.println("2.- Filtrar por mayor A");
                System.out.println("3.- Filtrar por inicial del autor");
                System.out.println("4.- Filtrar por Palabra clave");
                System.out.println("5.- Filtrar por año de publicacion");
                System.out.println("6.- Filtrar por Editorial");
                System.out.print("Ingresa tu opcion: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("--- GENERAL ---");
                        List<Libro> librosComedia = Libreria.libros.get(Genero.COMEDIA);
                        if (librosComedia.isEmpty()) {
                            System.out.println("No hay libros registrados en esta categoría.");
                        } else {
                            for (Libro libro : librosComedia) {
                                System.out.println(libro.toString());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("--- Filtrar por mayor A ---");
                        System.out.print("Ingresa el precio: ");
                        double precioMayorA = scanner.nextDouble();
                        scanner.nextLine();
                        LibroComedia libroComedia = new LibroComedia("", "", "", LocalDate.now(), precioMayorA, 0, ComediaSubgenero.ROMANTICA);
                        libroComedia.filtrarPorPrecioMeyorA(precioMayorA);
                        break;
                    case 3:
                        System.out.println("--- Filtrar inicial del Autor ---");
                        scanner.nextLine();
                        System.out.print("Ingresa la inicial del Autor: ");
                        String inicialAutor = scanner.nextLine().toUpperCase();
                        boolean encontradoAutor = false;
                        for (Libro libro : Libreria.libros.get(Genero.COMEDIA)) {
                            if (libro.getAutor().toUpperCase().startsWith(inicialAutor)) {
                                System.out.println(libro.toString());
                                encontradoAutor = true;
                            }
                        }
                        if (!encontradoAutor) {
                            System.out.println("No se encontraron libros con la inicial del Autor: " + inicialAutor);
                        }
                        break;

                    case 4:
                        System.out.println("--- Filtrar por palabra clave ---");
                        scanner.nextLine();
                        System.out.print("Ingresa una palabra clave del Título: ");
                        String palabraClave = scanner.nextLine().toLowerCase();
                        boolean encontradoPalabraClave = false;
                        for (Libro libro : Libreria.libros.get(Genero.COMEDIA)) {
                            if (libro.getNombre().toLowerCase().contains(palabraClave)) {
                                System.out.println(libro.toString());
                                encontradoPalabraClave = true;
                            }
                        }
                        if (!encontradoPalabraClave) {
                            System.out.println("No hay libros con el título que contiene la palabra clave: " + palabraClave);
                        }
                        break;

                    case 5:
                        System.out.println("--- Filtrar por Año de Publicacion ---");
                        scanner.nextLine();
                        try {
                            System.out.print("Ingresa el año: ");
                            int año = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            boolean encontradoAño = false;
                            for (Libro libro : Libreria.libros.get(Genero.COMEDIA)) {
                                if (libro instanceof LibroComedia && libro.getFechaPublicacion().getYear() == año) {
                                    System.out.println(libro.toString());
                                    encontradoAño = true;
                                }
                            }
                            if (!encontradoAño) {
                                System.out.println("No hay libros publicados en el año " + año);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un año válido.");
                            scanner.next(); // Limpiar el buffer
                        }
                        break;

                    case 6:
                        System.out.println("--- Filtrar por Editorial ---");
                        scanner.nextLine();
                        System.out.print("Ingresa la Editorial de libro: ");
                        String editorialLibro = scanner.nextLine();
                        boolean encontradoEditorial = false;
                        for (Libro libro : Libreria.libros.get(Genero.COMEDIA)) {
                            if (libro.getEditorial().equalsIgnoreCase(editorialLibro)) {
                                System.out.println(libro.toString());
                                encontradoEditorial = true;
                            }
                        }
                        if (!encontradoEditorial) {
                            System.out.println("No se encontraron libros con la editorial: " + editorialLibro);
                        }
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;

                }
                break;

            case 3:
                System.out.println("--- LIBROS DE ACCION ---");
                System.out.println("--- Tipo de muestreo ---");
                System.out.println("1.- General");
                System.out.println("2.- Filtrar por mayor A");
                System.out.println("3.- Filtrar por inicial del autor");
                System.out.println("4.- Filtrar por Palabra clave");
                System.out.println("5.- Filtrar por año de publicacion");
                System.out.println("6.- Filtrar por Editorial");
                System.out.print("Ingresa tu opcion: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("--- GENERAL ---");
                        List<Libro> librosAccion = Libreria.libros.get(Genero.ACCION);
                        if (librosAccion.isEmpty()) {
                            System.out.println("No hay libros registrados en esta categoría.");
                        } else {
                            for (Libro libro : librosAccion) {
                                System.out.println(libro.toString());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("--- Filtrar por mayor A ---");
                        System.out.print("Ingresa el precio: ");
                        double precioMayorA = scanner.nextDouble();
                        scanner.nextLine();
                        LibroAccion libroAccion = new LibroAccion("", "", "", LocalDate.now(), precioMayorA, 0, AccionSubgenero.FICCION);
                        libroAccion.filtrarPorPrecioMeyorA(precioMayorA);
                        break;
                    case 3:
                        System.out.println("--- Filtrar inicial del Autor ---");
                        scanner.nextLine();
                        System.out.print("Ingresa la inicial del Autor: ");
                        String inicialAutor = scanner.nextLine().toUpperCase();
                        boolean encontradoAutor = false;
                        for (Libro libro : Libreria.libros.get(Genero.ACCION)) {
                            if (libro.getAutor().toUpperCase().startsWith(inicialAutor)) {
                                System.out.println(libro.toString());
                                encontradoAutor = true;
                            }
                        }
                        if (!encontradoAutor) {
                            System.out.println("No se encontraron libros con la inicial del Autor: " + inicialAutor);
                        }
                        break;

                    case 4:
                        System.out.println("--- Filtrar por palabra clave ---");
                        scanner.nextLine();
                        System.out.print("Ingresa una palabra clave del Título: ");
                        String palabraClave = scanner.nextLine().toLowerCase();
                        boolean encontradoPalabraClave = false;
                        for (Libro libro : Libreria.libros.get(Genero.ACCION)) {
                            if (libro.getNombre().toLowerCase().contains(palabraClave)) {
                                System.out.println(libro.toString());
                                encontradoPalabraClave = true;
                            }
                        }
                        if (!encontradoPalabraClave) {
                            System.out.println("No hay libros con el título que contiene la palabra clave: " + palabraClave);
                        }
                        break;

                    case 5:
                        System.out.println("--- Filtrar por Año de Publicacion ---");
                        scanner.nextLine();
                        try {
                            System.out.print("Ingresa el año: ");
                            int año = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            boolean encontradoAño = false;
                            for (Libro libro : Libreria.libros.get(Genero.ACCION)) {
                                if (libro instanceof LibroAccion && libro.getFechaPublicacion().getYear() == año) {
                                    System.out.println(libro.toString());
                                    encontradoAño = true;
                                }
                            }
                            if (!encontradoAño) {
                                System.out.println("No hay libros publicados en el año " + año);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, ingrese un año válido.");
                            scanner.next(); // Limpiar el buffer
                        }
                        break;

                    case 6:
                        System.out.println("--- Filtrar por Editorial ---");
                        scanner.nextLine();
                        System.out.print("Ingresa la Editorial de libro: ");
                        String editorialLibro = scanner.nextLine();
                        boolean encontradoEditorial = false;
                        for (Libro libro : Libreria.libros.get(Genero.ACCION)) {
                            if (libro.getEditorial().equalsIgnoreCase(editorialLibro)) {
                                System.out.println(libro.toString());
                                encontradoEditorial = true;
                            }
                        }
                        if (!encontradoEditorial) {
                            System.out.println("No se encontraron libros con la editorial: " + editorialLibro);
                        }
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;

        }

    }

    public static void eliminarLibroPorId(Genero genero) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> libros = Libreria.libros.get(genero);

        if (libros.isEmpty()) {
            System.out.println("No hay libros en esta categoría.");
            return;
        }

        // Mostrar libros con sus IDs
        System.out.println("--- Libros ---");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("ID: " + (i + 1) + " - " + libros.get(i).toString());
        }

        // Pedir al usuario que ingrese el ID del libro que desea eliminar
        System.out.print("Ingresa el ID del libro que deseas eliminar: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Verificar si el ID es válido
        if (idLibro < 1 || idLibro > libros.size()) {
            System.out.println("ID de libro no válido.");
            return;
        }

        // Eliminar el libro y ajustar IDs
        libros.remove(idLibro - 1);
        System.out.println("Libro eliminado correctamente.");
        for (int i = idLibro - 1; i < libros.size(); i++) {
            libros.get(i).setId(libros.get(i).getId() - 1);
        }
    }

}

