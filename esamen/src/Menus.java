import java.util.Scanner;


//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO


public class Menus {
    TarjetasDebito tarjetaDebito = null;
    Scanner scanner = new Scanner(System.in);

    String salir = "6";
    public void inicioSesion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------- BANCO --------------------");
        System.out.println("            BIENVENIDO AL SISTEMA");
        System.out.println("Ingrese su usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();
        Sistema sistema = new Sistema();
        sistema.verificarInicioSesion();
    }

    public void inversionista(){
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


    public void cliente(){
        System.out.println("QUE DESEA HACER?");
        System.out.println("1. Ver Tarjetas");
        System.out.println("2. Agregar o Retirar Dinero");
        System.out.println("3. Solicitar Tarjeta de Credito");
        System.out.println("4. Salir");
        String opcion = scanner.nextLine();

        switch (opcion){
            case "1":
                if (tarjetaDebito != null) {
                    System.out.println("--------- TARJETA DE DEBITO ---------");
                    System.out.println(tarjetaDebito.toString());
                } else {
                    System.out.println("No se ha creado ninguna tarjeta de débito.");
                }
                break;
            case "2":
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
            case "3":
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

            case "4":
                salir = "5";
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public void clienteTarjetas(){
        if (tarjetaDebito != null) {
            System.out.println("--------- TARJETA DE DEBITO ---------");
            System.out.println(tarjetaDebito.toString());
        } else {
            System.out.println("No se ha creado ninguna tarjeta de débito.");
        }
    }


}
