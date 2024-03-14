import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Libreria libreria = new Libreria();
        boolean working = true;

        Scanner sInt = new Scanner(System.in);

        Scanner sString = new Scanner(System.in);
        int eleccion;
        int eleccion2;

        while (working) {
            System.out.println("1.-Registrar Usuario");
            System.out.println("2.-Registrar Libro");
            System.out.println("3.-Rentar Libro");
            System.out.println("4.-Devolver Libro");
            System.out.println("5.-Comprar Libro");
            System.out.println("6.-Libros Rentados");
            System.out.println("7.-Libros No Rentados");
            System.out.println("8.-Usuarios que han comprado algun libro");
            System.out.println("9.- Salir");

            switch (sInt.nextInt()) {
                case 1:
                    System.out.println("Inserte el nombre del usuario");
                    libreria.registrarUsuario(sString.nextLine());
                    break;

                case 2:
                    System.out.println("Inserte el titulo del Libro");
                    String titulo = sString.nextLine();
                    System.out.println("Inserte el nombre del autor");
                    String autor = sString.nextLine();
                    libreria.registrarLibro(titulo, autor);
                    break;

                case 3:
                    System.out.println("Seleccione el Usuario Rentador: ");
                    for (int i = 0; i < libreria.getUsuarios().size(); i++) {
                        System.out.println(i + ".- " + libreria.getUsuarios().get(i).getNombre());
                    }
                    eleccion = sInt.nextInt();

                    System.out.println("Seleccione un libro a rentar");
                    for (int i = 0; i < libreria.getLibrosNoRentados().size(); i++) {
                        System.out.println(i + ".-" + libreria.getLibrosNoRentados().get(i).getTitulo());
                    }
                    eleccion2 = sInt.nextInt();
                    libreria.rentarLibro(libreria.getUsuarios().get(eleccion),
                            libreria.getLibrosNoRentados().get(eleccion2));
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Seleccione el Usuario Rentador: ");
                    for (int i = 0; i < libreria.getUsuarios().size(); i++) {
                        System.out.println(i + ".- " + libreria.getUsuarios().get(i).getNombre());
                    }
                    eleccion = sInt.nextInt();
                    if (libreria.getUsuarios().get(eleccion).getLibrosRentados().size() == 0) {
                        System.out.println("Este usuario no tiene ningun libro rentado");
                    } else {
                        System.out.println("Selecciona el libro rentado a devolver");
                        for (int i = 0; i < libreria.getUsuarios().get(eleccion).librosRentados.size(); i++) {
                            System.out.println(i + ".-" + libreria.getLibros().get(i).getTitulo());
                        }
                        eleccion2 = sInt.nextInt();
                        libreria.getUsuarios().get(eleccion)
                                .devolverLibro(libreria.getUsuarios().get(eleccion).librosRentados.get(eleccion2));
                    }
                    break;
                case 5:
                    System.out.println("Seleccione el Usuario Comprador: ");
                    for (int i = 0; i < libreria.getUsuarios().size(); i++) {
                        System.out.println(i + ".- " + libreria.getUsuarios().get(i).getNombre());
                    }
                    eleccion = sInt.nextInt();
                    System.out.println("Seleccione un libro a comprar");
                    for (int i = 0; i < libreria.getLibrosNoRentados().size(); i++) {
                        System.out.println(i + ".-" + libreria.getLibrosNoRentados().get(i).getTitulo());
                    }
                    eleccion2 = sInt.nextInt();
                    libreria.comprarLibro(libreria.getUsuarios().get(eleccion),
                            libreria.getLibrosNoRentados().get(eleccion2));
                    System.out.println();
                    break;
                case 6:
                    for (int i = 0; i < libreria.getLibrosRentados().size(); i++) {
                        System.out.println(i + ".-" + libreria.getLibrosRentados().get(i).getTitulo());
                    }
                    break;
                case 7:
                    for (int i = 0; i < libreria.getLibrosNoRentados().size(); i++) {
                        System.out.println(i + ".-" + libreria.getLibrosNoRentados().get(i).getTitulo());
                    }
                    break;
                case 8:
                    for (int i = 0; i < libreria.getUsuarios().size(); i++) {
                        System.out.println(i + ".- " + libreria.getUsuarios().get(i).getNombre());
                    }
                    break;
                case 9:
                    working = false;
                    break;
                default:
                    System.out.println("Esa opcion no existe, prueba otra vez");
                    break;
            }
        }

    }
}
