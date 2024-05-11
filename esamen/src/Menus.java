import java.util.Scanner;


//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
import Sucursales.Sucursal;
import Users.*;
import Users.Empleados.Gerente;
import Users.utils.constantes.Rol;
import utils.UsuarioEnSesion;

public class Menus {
    TarjetasDebito tarjetaDebito = null;
    Scanner scanner = new Scanner(System.in);

    String salir = "6";

    public void inicioSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = false;

        do {
            System.out.println("Bienvenido al sistema del Banco");
            System.out.println("Para continuar sesión\n");
            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contrasena = scanner.nextLine();
            Usuario usuarioActual = Sucursal.obtenerUsuarioPorNombreYContrasena(usuario, contrasena);
            if (usuarioActual != null) {
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.println("\nUsuario o contraseña incorrectos.");
                datosCorrectos = false;
            }
        } while (datosCorrectos);
    }
    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE:
                mostrarMenuCliente(usuario.getUser());
                break;
//            case ASISTENTE:
//                mostrarMenuAsistente(usuario.getNombreUsuario());
//                    break;
            case GERENTE:
//                mostrarMenuGerente(usuario.getNombreUsuario());
                break;
            case INVERSIONISTA:
                mostrarMenuInversionista(usuario.getUser());
                break;
        }
    }
    public void mostrarMenuGerente(String nombreUsuario){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------GERENTE----------------");
        System.out.println("1.Operaciones relacionadas a los clientes");
        System.out.println("2. Solicitudes de tarjetas");
        System.out.println("3. Realizar registro de clientes");
        System.out.println("4. Realizar modificaciones a los clientes");
        System.out.println("5. Ver historial de inversion");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                //Menu.EjecutivoDeCuentaClientes()
                break;
            case 2:
                //Menu.EjecutivoDeCuentaTarjetas()
                break;
        }
    }

    public void mostrarMenuEjecutivoDeCuentas(String nombreUsuario){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------EJECUTIVO DE CUENTAS----------------");
        System.out.println("1.Operaciones relacionadas a los clientes");
        System.out.println("2. Solicitudes de tarjetas");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                //Menu.EjecutivoDeCuentaClientes()
                break;
            case 2:
                //Menu.EjecutivoDeCuentaTarjetas()
                break;
        }
    }
    public void mostrarMenuCapturista(String nombreUsuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------CAPTURISTA----------------");
        System.out.println("1. Realizar registro de clientes");
        System.out.println("2. Realizar modificaciones a los clientes");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                //Menu.RegistroClientes()
                break;
            case 2:
                //Menu.ModificacionClientes()
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida, por favor intente nuevamente.");
                mostrarMenuCapturista(nombreUsuario);
                break;
        }
    }



    public void mostrarMenuInversionista(String nombreUsuario){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------INVERSIONISTA----------------");
        System.out.println("1. Proveer fondos al banco");
        System.out.println("2. Remover fondos del banco");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                //Inversionista.proveerFondos()
                break;
            case 2:
                //Inversionista.removerFondos()
                break;
        }
    }


    public void mostrarMenuCliente(String nombreUsuario){
        int opcion = 0;
        do {
            System.out.println("QUE DESEA HACER?");
            System.out.println("1. Ver Tarjetas");
            System.out.println("2. Agregar o Retirar Dinero");
            System.out.println("3. Solicitar Tarjeta de Credito");
            System.out.println("4. Cerrar Sesion");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    if (tarjetaDebito != null) {
                        System.out.println("--------- TARJETA DE DEBITO ---------");
                        System.out.println(tarjetaDebito.toString());
                    } else {
                        System.out.println("No se ha creado ninguna tarjeta de débito.");
                    }
                    break;
                case 2:
                    if (tarjetaDebito != null) {
                        System.out.println("1. Agregar dinero");
                        System.out.println("2. Retirar dinero");
                        String opcionDinero = scanner.nextLine();

                        switch (opcionDinero) {
                            case "1":
                                System.out.println("Ingrese la cantidad a agregar:");
                                double cantidadAgregar = scanner.nextDouble();
                                tarjetaDebito.agregarDinero(cantidadAgregar);
                                System.out.println("Se agregaron " + cantidadAgregar + " a la tarjeta");
                                break;
                            case "2":
                                System.out.println("Ingrese la cantidad a retirar:");
                                double cantidadRetirar = scanner.nextDouble();
                                boolean retirado = tarjetaDebito.retirarDinero(cantidadRetirar);
                                if (retirado) {
                                    System.out.println("Se retiraron " + cantidadRetirar + " de la tarjeta");
                                }
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } else {
                        System.out.println("No se ha creado ninguna tarjeta de débito");
                    }
                    break;
                case 3:
                    if (tarjetaDebito.getCantidad() >= 50000 || tarjetaDebito.getCantidad() >= 100000 || tarjetaDebito.getCantidad() >= 200000) {
                        if (tarjetaDebito.getCantidad() <= 100000) {
                            System.out.println("Puedes solicitar una tarjeta Simplicity ");
                            System.out.println("1. Solicitar Simplicity 2. Rechazar");
                            String opcionSolicitar = scanner.nextLine();
                            switch (opcionSolicitar) {
                                case "1":


                                    break;
                                case "2":
                                    break;
                            }
                        } else if (tarjetaDebito.getCantidad() <= 200000) {
                            System.out.println("Puedes solicitar alguna de las siguientes tarjetas: Simplicity o Platino ");
                            System.out.println("1. Solicitar Simplicity 2. Solicitar Platino 3. Rechazar");
                            String opcionSolicitar = scanner.nextLine();
                            switch (opcionSolicitar) {
                                case "1":

                                    break;
                                case "2":

                                    break;
                                case "3":
                                    break;
                            }
                        } else {
                            System.out.println("Puedes solicitar alguna de las siguientes tarjetas: Simplicity, Platino u Oro");
                            System.out.println("1. Solicitar Simplicity 2. Solicitar Platino 3. Solicitar Oro");
                            String opcionSolicitar = scanner.nextLine();
                            switch (opcionSolicitar) {
                                case "1":

                                    break;
                                case "2":

                                    break;
                                case "3":
                                    System.out.println("dasf");
                                    break;
                                case "4":
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Por el momento no puedes solicitar una tarjeta de credito");
                    }
                    break;

                case 4:
                    salir = "5";
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    inicioSesion();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 4);
        System.out.println("\nSesión cerrada");
    }

    public void clienteTarjetas(){
        if (tarjetaDebito != null) {
            System.out.println("--------- TARJETA DE DEBITO ---------");
            System.out.println(tarjetaDebito.toString());
        } else {

        }
    }
}
