package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String salir = "6";
        TarjetasDebito tarjetaDebito = null;

        while (salir != "5") {
            Scanner scanner = new Scanner(System.in);
            System.out.println("BANCO");
            System.out.println("OPCIONES");
            System.out.println("1. TARJETA DEBITO");
            System.out.println("2. VER TARJETAS");
            System.out.println("3. AGREGAR O RETIRAR DINERO");
            System.out.println("4. SOLICITAR TARJETA DE CREDITO");
            System.out.println("5. SALIR");
            String opcion = scanner.nextLine();

            switch (opcion){
                case "1":
                    System.out.println("1. Debito");
                    System.out.println("--------- TARJETA DE DEBITO ---------");
                    tarjetaDebito = TarjetasDebito.crearTarjetaDeDebito();
                    break;
                case "2":
                    if (tarjetaDebito != null) {
                        System.out.println("--------- TARJETA DE DEBITO ---------");
                        System.out.println(tarjetaDebito.toString());
                    } else {
                        System.out.println("No se ha creado ninguna tarjeta de débito.");
                    }
                    break;
                case "3":
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
                case "4":
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
                            System.out.println("1. Solicitar Simplicity 2. Solicitar Platino 3. Solicitar Oro, 4. Rechazar");
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
                case "5":
                    salir = "5";
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
