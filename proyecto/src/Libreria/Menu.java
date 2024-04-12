package Libreria;

import usuarios.Usuario;

import java.util.Scanner;

public class Menu {
    private Libreria libreria = new Libreria();

    private Scanner scanner = new Scanner(System.in);
    boolean datosCorrectos;

    public void iniciarSesion() {
        do {
            System.out.println("****BIENVENIDO A LA BIBLIOTECA****");
            System.out.println("Iniciar sesion:\n ");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contraseña = scanner.nextLine();
            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null) {
                datosCorrectos = true;
                seleccionarMenu(usuarioActual);

            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo");
            }

        } while (!datosCorrectos);
    }

    private void seleccionarMenu(Usuario usuario) {
        switch (usuario.getRol()) {
            case CLIENTE:
                mostrarMenuCliente();
            case ASISTENTE:
                mostrarMenuAsistente();
            case GERENTE:
                mostrarMenuGerente();
        }

    }

    private void mostrarMenuCliente() {
        System.out.println("-----Menu Cliente------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Ver los libros");
        System.out.println("2. Consultar rentas");
        System.out.println("3. Salir");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1" :
                break;
            case "2":
                break;
            case "3":
                break;
        }
    }
    
    private void mostrarMenuAsistente() {
        System.out.println("-----Menu Asistente------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Registrar libro");
        System.out.println("2. Consultar libro");
        System.out.println("3. Modificar libro");
        System.out.println("4. Registrar cliente");
        System.out.println("5. Consultar cliente");
        System.out.println("6. Modificar cliente");
        System.out.println("7. Consultar rentas");
        System.out.println("8. Salir");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1" :
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5" :
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
        }
    }

    private void mostrarMenuGerente() {
        System.out.println("-----Menu Asistente------");
        System.out.println("Elige la opcion: ");
        System.out.println("1. Registrar libro");
        System.out.println("2. Consultar libro");
        System.out.println("3. Modificar libro");
        System.out.println("4. Registrar cliente");
        System.out.println("5. Consultar cliente");
        System.out.println("6. Modificar cliente");
        System.out.println("7. Consultar rentas");
        System.out.println("8. Consultar asistente");
        System.out.println("9. Modificar asistente");
        System.out.println("10. Consultar asistente");
        System.out.println("11. Eliminar rentas");
        System.out.println("12. Modificar cliente");
        System.out.println("13. Consultar rentas");
        System.out.println("14. Salir");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1" :
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5" :
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "9" :
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                break;
            case "13" :
                break;
            case "14":
                break;
        }
    }
}
