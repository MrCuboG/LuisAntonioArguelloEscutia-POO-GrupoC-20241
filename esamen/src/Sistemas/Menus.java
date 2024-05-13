package Sistemas;

import java.util.Scanner;


//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
//IGNOREN ESTA CLASE ES INUTIL POR EL MOMENTO
import Users.*;
import tarjetas.TarjetasDebito;
import utils.UsuarioEnSesion;
import Users.Empleados.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;
import  Sucursales.*;
import  Users.utils.constantes.Rol;
import java.time.format.DateTimeFormatter;

public class Menus {
    TarjetasDebito tarjetaDebito = null;
    Scanner scanner = new Scanner(System.in);
    static Empleado usuarioActual;
    String salir = "6";
    static int sucur;

    public static void inicioSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean datosIncorrectos = false;

        do {
            System.out.println("Bienvenido al sistema del Banco");
            System.out.println("A cuál sucursal le gustaría ingresar?");
            System.out.println("1.Madero");
            System.out.println("2.Acueducto");
            sucur = scanner.nextInt();
            scanner.nextLine();
            while (true) {
                System.out.println("Para continuar sesión\n");
                System.out.println("Ingresa tu usuario: ");
                String usuario = scanner.nextLine();
                System.out.println("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();
                if (sucur == 1) {
                    usuarioActual = verificarInicioSesionMadero(usuario, contrasena);
                    if (usuarioActual != null) {
                        datosIncorrectos = false;
                        UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                        seleccionarMenu();
                        break;
                    } else {
                        System.out.println("\nUsuario o contraseña incorrectos.");
                        datosIncorrectos = true;
                    }
                }else if (sucur == 2) {
                    usuarioActual = verificarInicioSesionMadero(usuario, contrasena);
                    if (usuarioActual != null) {
                        datosIncorrectos = false;
                        UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                        seleccionarMenu();
                        break;
                    } else {
                        System.out.println("\nUsuario o contraseña incorrectos.");
                        datosIncorrectos = true;
                    }
                }
            }

        } while (datosIncorrectos);
    }

    private static Empleado verificarInicioSesionMadero(String user, String contrasena){
        for (Map.Entry<Rol, ArrayList<Empleado>> entry : SucursalMadero.getEmpleados().entrySet()) {
            ArrayList<Empleado> usuarioList = entry.getValue();
            for (Empleado empleado : usuarioList) {
                if (empleado.getNombreUsuario().equals(user) && empleado.getContraseña().equals(contrasena)) {
                    return empleado;
                }
            }
        }
        return null;
    }
    private Empleado verificarInicioSesionAcueducto(String user, String contrasena){
        for (Map.Entry<Rol, ArrayList<Empleado>> entry : SucursalAcueducto.getEmpleados().entrySet()) {
            ArrayList<Empleado> usuarioList = entry.getValue();
            for (Empleado empleado : usuarioList) {
                if (empleado.getNombreUsuario().equals(user) && empleado.getContraseña().equals(contrasena)) {
                    return empleado;
                }
            }
        }
        return null;
    }

    private static void seleccionarMenu() {
        Empleado usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        if (sucur == 1) {
            switch (usuario.getRol()) {
                case GERENTE_SUCURSAL:
                    menuGerenteMadero();
                    break;
                case INVERSIONISTA:
                    mostrarMenuInversionista(usuario.getNombreUsuario());
                    break;
                case CAPTURISTA:
                    menuCapturistaMadero();
                    break;
                case EJECUTIVO_CUENTA:
                    menuEjecutivoDeCuentaMadero();
                    break;
            }
        }else{
            switch (usuario.getRol()) {
                case GERENTE_SUCURSAL:
                    menuGerenteAcueducto();
                    break;
                case INVERSIONISTA:
                    mostrarMenuInversionista(usuario.getNombreUsuario());
                    break;
                case CAPTURISTA:
                    menuCapturistaAcueducto();
                    break;
                case EJECUTIVO_CUENTA:
                    menuEjecutivoDeCuentaAcueducto();
                    break;
            }
        }

    }


    public static void mostrarMenuInversionista(String nombreUsuario){
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
            System.out.println("1. Ver tarjetas.Tarjetas");
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

    ///////////////////////////MENU EMPLEADOS//////////////////////////////////
    ///////////////////////////MENU EMPLEADOS//////////////////////////////////

        private static int contadorIdEmpleado=1;
        public static final List<EjecutivoDeCuenta> ejecutivosMadero = new ArrayList<>();
        public static final List<EjecutivoDeCuenta> ejecutivosAcueducto = new ArrayList<>();
        public static final List<GerenteSucursal> gerentesMadero = new ArrayList<>();
        public static final List<GerenteSucursal> gerentesAcueducto = new ArrayList<>();
        public static final List<Capturista> capturistasMadero = new ArrayList<>();
        public static final List<Capturista> capturistasAcueducto = new ArrayList<>();
        public static GerenteSucursal gerenteMadero;
        public static GerenteSucursal gerenteAcueducto;
        static Scanner scaner = new Scanner(System.in);


    public static void mostrarMenuEmpleado (){
        //////////////////ASIGNAR GERENTE POR DEFAULT EN SUCURSAL MADERO

        int idGerenteMadero = 1;
        String nombreGerenteMadero = "Diana";
        String apellidosGerenteMadero = "Campos Rosas";
        LocalDate fechaNacimientoGerenteMadero = LocalDate.of(2005, 10, 24);
        String ciudadGerenteMadero= "Morelia";
        String estadoGerenteMadero= "Michoacán";
        String curpGerenteMadero = "CARD051024MMNMSNA5";
        String direccionGerenteMadero = "Calle Morelos #456";
        Sucursal sucursalGerenteMadero = new SucursalMadero("Madero", "Av. Madero #123");
        double salarioGerenteMadero = 50000.00;
        Rol rolGerenteMadero = Rol.GERENTE_SUCURSAL;
        LocalDate fechaInicioTrabajoGerenteMadero = LocalDate.of(2020, 01, 01);
        String contraseñaGerenteMadero = "gerente madero";
        String nombreUsuarioGerenteMadero = "diana_campos";

        gerenteMadero = new GerenteSucursal(idGerenteMadero,nombreGerenteMadero, apellidosGerenteMadero, fechaNacimientoGerenteMadero, ciudadGerenteMadero,estadoGerenteMadero, curpGerenteMadero, direccionGerenteMadero, sucursalGerenteMadero,
                salarioGerenteMadero, rolGerenteMadero, fechaInicioTrabajoGerenteMadero, contraseñaGerenteMadero, nombreUsuarioGerenteMadero);

        SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123", gerenteMadero);
        sucursalMadero.setGerenteSucursal(gerenteMadero);
        Map<String, Sucursal> sucursales = new HashMap<>();
        sucursales.put("Madero", sucursalMadero);
//        System.out.println(sucursalMadero.toString());
//        System.out.println(gerenteMadero.toString());


//////////////// ASIGNAR GERENTE POR DEFAULT EN SUCURSAL ACUEDUCTO
        int idGerenteAcueducto = 2;
        String nombreGerenteAcueducto = "Michelle";
        String apellidosGerenteAcueducto = "Mandujano Chávez";
        LocalDate fechaNacimientoGerenteAcueducto = LocalDate.of(2003,12,21);
        String ciudadGerenteAcueducto= "Morelia";
        String estadoGerenteAcueducto=  "Michoacán";
        String curpGerenteAcueducto = "CAMA001221MGTHNBA1";
        String direccionGerenteAcueducto = "Calle Rio mayo #456";
        Sucursal sucursalGerenteAcueducto = new SucursalAcueducto("Acueducto", "Av. Acueducto #220");
        double salarioGerenteAcueducto = 50000.00;
        Rol rolGerenteAcueducto = Rol.GERENTE_SUCURSAL;
        LocalDate fechaInicioTrabajoGerenteAcueducto = LocalDate.of(2020, 01, 01);
        String contraseñaGerenteAcueducto = "gerente acueducto";
        String nombreUsuarioGerenteAcueducto = "michelle_chavez";

        gerenteAcueducto = new GerenteSucursal(idGerenteAcueducto, nombreGerenteAcueducto, apellidosGerenteAcueducto, fechaNacimientoGerenteAcueducto, ciudadGerenteAcueducto, estadoGerenteAcueducto, curpGerenteAcueducto, direccionGerenteAcueducto, sucursalGerenteAcueducto,
                salarioGerenteAcueducto, rolGerenteAcueducto, fechaInicioTrabajoGerenteAcueducto, contraseñaGerenteAcueducto, nombreUsuarioGerenteAcueducto);

        SucursalAcueducto sucursalAcueducto = new SucursalAcueducto("Acueducto","Av. Acueducto #220", gerenteAcueducto);
        sucursales.put("Acueducto", sucursalAcueducto);

//        System.out.println(sucursalAcueducto.toString());


        /////////////////////////////////////////



        Scanner leer1 = new Scanner(System.in);
        int opcionSucursal;
        do{
            System.out.println("\n**Bienvenido al sistema de registro de empleados**");
            System.out.println("\nSeleccione la sucursal a la que desea entrar:");
            System.out.println("1. Sucursal Madero");
            System.out.println("2. Sucursal Acueducto");
            System.out.print("Opción: ");

            opcionSucursal = leer1.nextInt();
            leer1.nextLine();
        } while (opcionSucursal < 1 || opcionSucursal > 2);

        int opcionMenu;
        switch (opcionSucursal) {
            case 1: //Sucursal Madero
                System.out.println(sucursalMadero.toString());

                do{
                    System.out.println("¿A qué menu desea acceder?(se requiere la contraseña)\n1. Gerente"
                            + "\n2. Capturista\n3. Ejecutivos de cuenta");
                    opcionMenu= scaner.nextInt();
                    switch(opcionMenu){
                        case 1://Menú gernete
                            System.out.println(gerenteMadero.toString());
                            menuGerenteMadero();
                            break;
                        case 2: //menu capturistas
                            if (capturistasMadero.isEmpty()) {
                                registrarCapturistaMadero(); // Solicitar registro de capturista
                            } else {
                                menuCapturistaMadero();//Línea 145
                            }
                            break;
                        case 3: //Menu ejecutivos de cuenta
                            menuEjecutivoDeCuentaMadero();
                            break;
                    }
                }while(opcionMenu!=4);
            case 2://Sucursal acueducto
                System.out.println(sucursalAcueducto.toString());

                do{
                    System.out.println("¿A qué menu desea acceder?(se requiere la contraseña)\n1. Gerente"
                            + "\n2. Capturista\n3. Ejecutivos de cuenta");
                    opcionMenu= scaner.nextInt();
                    switch(opcionMenu){
                        case 1:
                            System.out.println(gerenteAcueducto.toString());
                            menuGerenteAcueducto();
                            break;
                        case 2:
                            if (capturistasAcueducto.isEmpty()) {
                                registrarCapturistaAcueducto();
                            } else {
                                menuCapturistaAcueducto();
                            }
                            break;
                        case 3:
                            menuEjecutivoDeCuentaAcueducto();
                            break;
                    }
                }while(opcionMenu!=4);
            default:
                System.out.println("Opción no válida.");
        }

        leer1.close();
    }
    public static void menuGerenteMadero(){
            Scanner scan = new Scanner(System.in);
            AltaCliente s = new AltaCliente();
            int opcion;
                do{
                    System.out.println("¿Qué desea hacer? ");
                    System.out.println("1. Registrar ejecutivo de cuenta\n2. Modificar ejecutivo de cuenta"
                            + "\n3.Eliminar ejecutivo de cuenta\n4. Mostrar ejecutivos de cuenta registrados en la sucursal Madero"
                            + "\n5. Registrar capturista\n6. Modificar capturista\n7.Eliminar capturista\n8. Registrar cliente"
                            + "\n9.Modificar cliente\n10.Eliminar cliente\n11. Autorizar tarjeta de crédito\n"
                            + "12. Registrar inversionista\n13. Modificar inversionista\n14. Eliminar inversionisrta\n15. Salir");
                    opcion= scan.nextInt();
                    switch (opcion){
                        case 1:
                            registrarEjecutivoDeCuentaMadero();
                            break;
                        case 2:
                            scan.nextLine();
                            System.out.print("Ingrese el nombre de usuario del ejecutivo de cuenta que desea modificar: ");
                            String nombreUsuario1= scan.nextLine();
                            modificarEjecutivosMadero(nombreUsuario1);
                            break;
                        case 3:
                            System.out.print("Ingrese el nombre de usuario del ejecutivo de cuenta que desea eliminar: ");
                            String nombreUsuario2= scan.nextLine();
                            eliminarEjecutivoMadero(nombreUsuario2);
                        case 4:
                            mostrarEjecutivosRegistradosMadero();
                            break;
                        case 5:
                            registrarCapturistaMadero();
                            break;
                        case 6:
                            System.out.print("Ingrese el nombre de usuario del capturista que desea modificar: ");
                            String nombreUsuario3= scan.nextLine();
                            modificarCapturistaMadero(nombreUsuario3);
                            break;
                        case 7:
                            System.out.print("Ingrese el nombre de usuario del capturista que desea eliminar: ");
                            String nombreUsuario4= scan.nextLine();
                            eliminarCapturistaMadero(nombreUsuario4);
                            break;
                        case 8: //Registrar cliente

                            s.DarAltaCliente();
                            break;
                        case 9://Modificar datos del cliente
                            s.modificarDatosCliente();
                            break;

                        case 10: //Eliminar cliente
                            System.out.print("Ingrese el nombre de usuario del cliente que desea eliminar: ");
                            String nombreUsuario5= scan.nextLine();
                            s.eliminarCliente(nombreUsuario5);
                            break;

                        case 11: //Autorizar tarjeta de crédito

                            break;
                        case 12: //Registrar inversionista

                            break;
                        case 13: //Modificar inversionista
                            break;
                        case 14: // Eliminar inversionista
                            break;
                        case 15:
                            break;

                    }
                }while (opcion!=15);
                inicioSesion();
        }
    public static void menuGerenteAcueducto(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scan.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scan.nextLine();
        AltaCliente s = new AltaCliente();

        boolean usuarioValido = false;
        if (gerenteAcueducto.getNombreUsuario().equals(nombreUsuario) && gerenteMadero.getContraseña().equals(contraseña)) {
            usuarioValido = true;
        }
        if (usuarioValido){
            int opcion;
            do{
                System.out.println("¿Qué desea hacer? ");
                System.out.println("1. Registrar ejecutivo de cuenta\n2. Modificar ejecutivo de cuenta"
                        + "\n3.Eliminar ejecutivo de cuenta\n4. Mostrar ejecutivos de cuenta registrados en la sucursal Madero"
                        + "\n5. Registrar capturista\n6. Modificar capturista\n7.Eliminar capturista\n8. Registrar cliente"
                        + "\n9.Modificar cliente\n10.Eliminar cliente\n11. Autorizar tarjeta de crédito\n"
                        + "12. Registrar inversionista\n13. Modificar inversionista\n14. Eliminar inversionisrta\n15. Salir");
                opcion= scan.nextInt();
                switch (opcion){
                    case 1:
                        registrarEjecutivoDeCuentaAcueducto();
                        break;
                    case 2:
                        scan.nextLine();
                        System.out.print("Ingrese el nombre de usuario del ejecutivo de cuenta que desea modificar: ");
                        String nombreUsuario1= scan.nextLine();
                        modificarEjecutivosAcueducto(nombreUsuario1);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre de usuario del ejecutivo de cuenta que desea eliminar: ");
                        String nombreUsuario2= scan.nextLine();
                        eliminarEjecutivoAcueducto(nombreUsuario2);
                    case 4:
                        mostrarEjecutivosRegistradosAcueducto();
                        break;
                    case 5:
                        registrarCapturistaAcueducto();
                        break;
                    case 6:
                        System.out.print("Ingrese el nombre de usuario del capturista que desea modificar: ");
                        String nombreUsuario3= scan.nextLine();
                        modificarCapturistaAcueducto(nombreUsuario3);
                        break;
                    case 7:
                        System.out.print("Ingrese el nombre de usuario del capturista que desea eliminar: ");
                        String nombreUsuario4= scan.nextLine();
                        eliminarCapturistaAcueducto(nombreUsuario4);
                        break;
                    case 8: //Registrar cliente
                        s.DarAltaCliente();
                        break;
                    case 9://Modificar datos del cliente
                        s.modificarDatosCliente();
                        break;

                    case 10: //Eliminar cliente
                        System.out.print("Ingrese el nombre de usuario del cliente que desea eliminar: ");
                        String nombreUsuario5= scan.nextLine();
                        s.eliminarCliente(nombreUsuario5);
                        break;

                    case 11: //Autorizar tarjeta de crédito

                        break;
                    case 12: //Registrar inversionista

                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;

                }
            }while (opcion!=15);
            inicioSesion();
        }else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    public static void menuCapturistaMadero(){

        // Solicitar nombre de usuario y contraseña
        scaner.nextLine();
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scaner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scaner.nextLine();

        boolean usuarioValido = false;
        for (Capturista capturista : capturistasMadero) {
            if (capturista.getNombreUsuario().equals(nombreUsuario) && capturista.getContraseña().equals(contraseña)) {
                usuarioValido = true;
                break;
            }
        }
        if (usuarioValido){
            int opcion;
            do{
                System.out.println("¿Qué desea hacer? ");
                System.out.println("1. Registrar ejecutivo de cuenta\n2. Modificar ejecutivo de cuenta"
                        + "\n3.Eliminar ejecutivo de cuenta\n4. Mostrar ejecutivos de cuenta registrados en la sucursal Madero"
                        + "\n5. Salir");
                opcion= scaner.nextInt();
                switch (opcion){
                    case 1:
                        registrarEjecutivoDeCuentaMadero();
                        break;
                    case 2:
                        scaner.nextLine();
                        System.out.print("Ingrese el nombre de usuario del empleado que desea modificar: ");
                        String nombreUsuario1= scaner.nextLine();
                        modificarEjecutivosMadero(nombreUsuario1);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre de usuario del empleado que desea eliminar: ");
                        String nombreUsuario2= scaner.nextLine();
                        eliminarEjecutivoMadero(nombreUsuario2);
                    case 4:
                        mostrarEjecutivosRegistradosMadero();
                        break;
                    case 5:
                        break;
                }
            }while (opcion!=5);
        }else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }


    public static void registrarEjecutivoDeCuentaMadero(){

        Scanner scanner1= new Scanner(System.in);
        System.out.println("\n**Registro de empleado con rol de ejecutivo de cuenta en sucursal Madero**");

        System.out.print("Nombre: ");
        String nombre = scanner1.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner1.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner1.nextLine();

        boolean datoValido = false;
        LocalDate fechaNacimiento= LocalDate.now();
        while(!datoValido){
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoString = scanner1.nextLine();
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, DateTimeFormatter.ISO_DATE);
                break;
            }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido=false;
                scaner.nextLine();
            }
        }

        boolean datoValido2 = false;
        LocalDate fechaIngreso= LocalDate.now();
        while(!datoValido2){
            try {
                System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
                String fechaIngresoString = scanner1.nextLine();
                fechaIngreso = LocalDate.parse(fechaIngresoString, DateTimeFormatter.ISO_DATE);
                break;                }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido2=false;
                scaner.nextLine();
            }
        }

        System.out.print("ciudad: ");
        String ciudad = scanner1.nextLine();

        System.out.print("estado: ");
        String estado = scanner1.nextLine();

        System.out.print("CURP: ");
        String CURP = scanner1.nextLine();

        double salario = 0;
        boolean datoValido3 = false;
        while(!datoValido3) {
            try {
                System.out.print("Salario: ");
                salario = scanner1.nextDouble();
                break;
            } catch (Exception error) {
                System.out.println("El argumento no es válido");
                datoValido3 = false;
                scanner1.nextLine();
            }
        }

        System.out.print("Contraseña: ");
        String contraseña= scanner1.nextLine();
        if (contraseña.isEmpty()){
            System.out.println("Ingrese de nuevo la contraseña:");
            contraseña= scanner1.nextLine();
        }

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner1.nextLine();


        int idEmpleado = contadorIdEmpleado++;

        SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123");
        EjecutivoDeCuenta ejecutivoDeCuenta = new EjecutivoDeCuenta(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion, sucursalMadero, salario, Rol.EJECUTIVO_CUENTA, fechaIngreso, contraseña, nombreUsuario);
        ejecutivosMadero.add(ejecutivoDeCuenta);

        System.out.println("\nEmpleado registrado exitosamente!");

    }

    public static void mostrarEjecutivosRegistradosMadero() {
        if (ejecutivosMadero.isEmpty()) {
            System.out.println("No hay ejecutivos de cuenta registrados.");
            return;
        }

        System.out.println("\n**Lista de ejecutivos de cuenta registrados:**");
        for (EjecutivoDeCuenta ejecutivo : ejecutivosMadero) {
            System.out.println(ejecutivo);
        }
    }
    public static void modificarEjecutivosMadero(String nombreUsuario) {

        EjecutivoDeCuenta empleado = null;

        if (ejecutivosMadero.isEmpty()){
            System.out.println("No hay ejecutivos de cuenta registrados en esta sucursal");
            return;
        }
        for (EjecutivoDeCuenta empleadoAux : ejecutivosMadero) {
            if (empleadoAux.getNombreUsuario().equals(nombreUsuario)) {
                empleado = empleadoAux;
                break;
            }
        }

        if (empleado != null) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellidos: " + empleado.getApellidos());
            System.out.println("Fecha de nacimiento: " + empleado.getFechaNacimiento());
            System.out.println("Fecha de ingreso: " + empleado.getFechaInicioTrabajo());
            System.out.println("CURP: " + empleado.getCURP());
            System.out.println("Salario: " + empleado.getSalario());
            System.out.println("Rol: " + empleado.getRol());

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("¿Qué datos desea modificar? (Introduzca el número):");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Fecha de nacimiento");
            System.out.println("4. Fecha de ingreso");
            System.out.println("5. CURP");
            System.out.println("6. Salario");

            int opcion = scanner2.nextInt();
            scanner2.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner2.nextLine();
                    empleado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Ingrese los nuevos apellidos: ");
                    String nuevosApellidos = scanner2.nextLine();
                    empleado.setApellidos(nuevosApellidos);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                    String nuevaFechaNacimientoString = scanner2.nextLine();
                    LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoString, DateTimeFormatter.ISO_DATE);
                    empleado.setFechaNacimiento(nuevaFechaNacimiento);
                    break;
                case 4:
                    System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
                    String nuevaFechaIngresoString = scanner2.nextLine();
                    LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoString, DateTimeFormatter.ISO_DATE);
                    empleado.setFechaInicioTrabajo(nuevaFechaIngreso);
                    break;
                case 5:
                    System.out.print("Ingrese la nueva CURP: ");
                    String nuevaCurp = scanner2.nextLine();
                    empleado.setCURP(nuevaCurp);
                    break;
                case 6:
                    System.out.print("Ingrese el nuevo salario: ");
                    double nuevoSalario = scanner2.nextDouble();
                    empleado.setSalario(nuevoSalario);
                    break;
            }

            System.out.println("Datos del empleado modificados exitosamente!");
        } else {
            System.out.println("No se encontró un empleado con el nombre de usuario " + nombreUsuario);
        }
    }
    public static void eliminarEjecutivoMadero(String nombreUsuario) {
        EjecutivoDeCuenta empleado = null;
        for (EjecutivoDeCuenta empleadoAux : ejecutivosMadero) {
            if (empleadoAux.getNombreUsuario().equals(nombreUsuario)) {
                empleado = empleadoAux;
                break;
            }
        }
        if (empleado != null) {
            ejecutivosMadero.remove(empleado);
            System.out.println("Empleado eliminado exitosamente!");
        } else {
            System.out.println("No se encontró un empleado con el nombre de usuario " + nombreUsuario);
        }
    }



    public static void registrarCapturistaMadero(){

        Scanner scanner1= new Scanner(System.in);
        System.out.println("\n**Registro de empleado con rol de capturista en sucursal Madero**");

        System.out.print("Nombre: ");
        String nombre = scanner1.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner1.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner1.nextLine();

        boolean datoValido = false;
        LocalDate fechaNacimiento= LocalDate.now();
        while(!datoValido){
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoString = scanner1.nextLine();
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, DateTimeFormatter.ISO_DATE);
                break;
            }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido=false;
                scaner.nextLine();
            }
        }

        boolean datoValido2 = false;
        LocalDate fechaIngreso= LocalDate.now();
        while(!datoValido2){
            try {
                System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
                String fechaIngresoString = scanner1.nextLine();
                fechaIngreso = LocalDate.parse(fechaIngresoString, DateTimeFormatter.ISO_DATE);
                break;                }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido2=false;
                scaner.nextLine();
            }
        }

        System.out.print("ciudad: ");
        String ciudad = scanner1.nextLine();

        System.out.print("estado: ");
        String estado = scanner1.nextLine();

        System.out.print("CURP: ");
        String CURP = scanner1.nextLine();

        double salario = 0;
        boolean datoValido3 = false;
        while(!datoValido3) {
            try {
                System.out.print("Salario: ");
                salario = scanner1.nextDouble();
                break;
            } catch (Exception error) {
                System.out.println("El argumento no es válido");
                datoValido3 = false;
                scanner1.nextLine();
            }
        }
        scanner1.nextLine();
        System.out.print("Contraseña: ");
        String contraseña= scanner1.nextLine();

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner1.nextLine();

        int idEmpleado = contadorIdEmpleado++;

        SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123");
        Capturista capturista = new Capturista(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion, sucursalMadero, salario, Rol.CAPTURISTA, fechaIngreso, contraseña, nombreUsuario);
        capturistasMadero.add(capturista);

        System.out.println("\nEmpleado registrado exitosamente!");

    }
    public static void modificarCapturistaMadero(String nombreUsuario) {
        Scanner scanner2 = new Scanner(System.in);

        Capturista capturistaAModificar = null;
        for (Capturista capturista : capturistasMadero) {
            if (capturista.getNombreUsuario().equals(nombreUsuario)) {
                capturistaAModificar = capturista;
                break;
            }
        }
        if (capturistaAModificar != null) {
            System.out.println("\nInformación actual del capturista:");
            System.out.println("  Nombre: " + capturistaAModificar.getNombre());
            System.out.println("  Apellidos: " + capturistaAModificar.getApellidos());
            System.out.println("  Fecha de nacimiento: " + capturistaAModificar.getFechaNacimiento());
            System.out.println("  Fecha de ingreso: " + capturistaAModificar.getFechaInicioTrabajo());
            System.out.println("  CURP: " + capturistaAModificar.getCURP());
            System.out.println("  Salario: "+capturistaAModificar.getSalario());

            System.out.println("¿Qué datos desea modificar? (Introduzca el número):");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Fecha de nacimiento");
            System.out.println("4. Fecha de ingreso");
            System.out.println("5. CURP");
            System.out.println("6. Salario");
            System.out.println("0. Salir");

            int opcion = scanner2.nextInt();
            scanner2.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner2.nextLine();
                    capturistaAModificar.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Ingrese los nuevos apellidos: ");
                    String nuevosApellidos = scanner2.nextLine();
                    capturistaAModificar.setApellidos(nuevosApellidos);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                    String nuevaFechaNacimientoString = scanner2.nextLine();
                    LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoString, DateTimeFormatter.ISO_DATE);
                    capturistaAModificar.setFechaNacimiento(nuevaFechaNacimiento);
                    break;
                case 4:
                    System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
                    String nuevaFechaIngresoString = scanner2.nextLine();
                    LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoString, DateTimeFormatter.ISO_DATE);
                    capturistaAModificar.setFechaInicioTrabajo(nuevaFechaIngreso);
                    break;
                case 5:
                    System.out.print("Ingrese la nueva CURP: ");
                    String nuevaCurp = scanner2.nextLine();
                    capturistaAModificar.setCURP(nuevaCurp);
                    break;
                case 6:
                    boolean datoValido = false;
                    double nuevoSalario = 0;
                    while (!datoValido) {
                        try {
                            System.out.print("Ingrese el nuevo salario: ");
                            nuevoSalario = scaner.nextDouble();
                            datoValido = true;
                        } catch (Exception error) {
                            System.out.println("El argumento no es válido");
                            datoValido = false;
                            scaner.nextLine();
                        }
                    }
                    capturistaAModificar.setSalario(nuevoSalario);
                    scanner2.nextLine();
                    break;
                case 0:
                    break;
            }

            System.out.println("\nInformación del capturista modificada con éxito.");
        } else {
            System.out.println("No se encontró ningún capturista con el nombre de usuario: " + nombreUsuario);
        }
    }


    public static void menuCapturistaAcueducto(){

        // Solicitar nombre de usuario y contraseña
        scaner.nextLine();
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scaner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scaner.nextLine();

        boolean usuarioValido = false;
        for (Capturista capturista : capturistasAcueducto) {
            if (capturista.getNombreUsuario().equals(nombreUsuario) && capturista.getContraseña().equals(contraseña)) {
                usuarioValido = true;
                break;
            }
        }
        if (usuarioValido){
            int opcion;
            do{
                System.out.println("¿Qué desea hacer? ");
                System.out.println("1. Registrar ejecutivo de cuenta\n2. Modificar ejecutivo de cuenta"
                        + "\n3.Eliminar ejecutivo de cuenta\n4. Mostrar ejecutivos de cuenta registrados en la sucursal Madero"
                        + "\n5. Salir");
                opcion= scaner.nextInt();
                switch (opcion){
                    case 1:
                        registrarEjecutivoDeCuentaAcueducto();
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre de usuario del empleado que desea modificar: ");
                        String nombreUsuario1= scaner.nextLine();
                        modificarEjecutivosAcueducto(nombreUsuario1);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre de usuario del empleado que desea eliminar: ");
                        String nombreUsuario2= scaner.nextLine();
                        eliminarEjecutivoAcueducto(nombreUsuario2);
                    case 4:
                        mostrarEjecutivosRegistradosAcueducto();
                        break;
                    case 5:
                        break;
                }
            }while(opcion!=5);
        }else {
            System.out.println("Nombre de usuaurio o contraseña inválidos");
        }
    }
    public static void registrarEjecutivoDeCuentaAcueducto(){

        Scanner scanner1= new Scanner(System.in);
        System.out.println("\n**Registro de empleado con rol de ejecutivo de cuenta en sucursal Acueducto**");

        System.out.print("Nombre: ");
        String nombre = scanner1.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner1.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner1.nextLine();

        boolean datoValido = false;
        LocalDate fechaNacimiento= LocalDate.now();
        while(!datoValido){
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoString = scanner1.nextLine();
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, DateTimeFormatter.ISO_DATE);
                break;
            }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido=false;
                scaner.nextLine();
            }
        }

        boolean datoValido2 = false;
        LocalDate fechaIngreso= LocalDate.now();
        while(!datoValido2){
            try {
                System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
                String fechaIngresoString = scanner1.nextLine();
                fechaIngreso = LocalDate.parse(fechaIngresoString, DateTimeFormatter.ISO_DATE);
                break;                }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido2=false;
                scaner.nextLine();
            }
        }

        System.out.print("ciudad: ");
        String ciudad = scanner1.nextLine();

        System.out.print("estado: ");
        String estado = scanner1.nextLine();

        System.out.print("CURP: ");
        String CURP = scanner1.nextLine();

        double salario = 0;
        boolean datoValido3 = false;
        while(!datoValido3) {
            try {
                System.out.print("Salario: ");
                salario = scanner1.nextDouble();
                break;
            } catch (Exception error) {
                System.out.println("El argumento no es válido");
                datoValido3 = false;
                scanner1.nextLine();
            }
        }
        scanner1.nextLine();
        System.out.print("Contraseña: ");
        String contraseña= scanner1.nextLine();

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner1.nextLine();


        int idEmpleado = contadorIdEmpleado++;

        SucursalAcueducto sucursalAcueducto = new SucursalAcueducto("Acueducto", "Av. Acueducto #256");
        EjecutivoDeCuenta ejecutivoDeCuenta = new EjecutivoDeCuenta(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion, sucursalAcueducto, salario, Rol.EJECUTIVO_CUENTA, fechaIngreso, contraseña, nombreUsuario);
        ejecutivosAcueducto.add(ejecutivoDeCuenta);

        System.out.println("\nEmpleado registrado exitosamente!");


    }
    public static void mostrarEjecutivosRegistradosAcueducto(){
        if (ejecutivosAcueducto.isEmpty()) {
            System.out.println("No hay ejecutivos de cuenta registrados.");
            return;
        }

        System.out.println("\n**Lista de ejecutivos de cuenta registrados:**");
        for (EjecutivoDeCuenta ejecutivo : ejecutivosAcueducto) {
            System.out.println(ejecutivo);
        }
    }


    public static void registrarCapturistaAcueducto(){

        Scanner scanner1= new Scanner(System.in);
        System.out.println("\n**Registro de empleado con rol de capturista en sucursal Acueducto**");

        System.out.print("Nombre: ");
        String nombre = scanner1.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner1.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner1.nextLine();

        boolean datoValido = false;
        LocalDate fechaNacimiento= LocalDate.now();
        while(!datoValido){
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoString = scanner1.nextLine();
                fechaNacimiento = LocalDate.parse(fechaNacimientoString, DateTimeFormatter.ISO_DATE);
                break;
            }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido=false;
                scaner.nextLine();
            }
        }
        System.out.print("ciudad: ");
        String ciudad = scanner1.nextLine();

        System.out.print("estado: ");
        String estado = scanner1.nextLine();

        boolean datoValido2 = false;
        LocalDate fechaIngreso= LocalDate.now();
        while(!datoValido2){
            try {
                System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
                String fechaIngresoString = scanner1.nextLine();
                fechaIngreso = LocalDate.parse(fechaIngresoString, DateTimeFormatter.ISO_DATE);
                break;                }
            catch(Exception error){
                System.out.println("Ingrese la fecha con el formato adecuado (YYYY-MM-DD)");
                datoValido2=false;
                scaner.nextLine();
            }
        }

        System.out.print("CURP: ");
        String CURP = scanner1.nextLine();

        double salario = 0;
        boolean datoValido3 = false;
        while(!datoValido3) {
            try {
                System.out.print("Salario: ");
                salario = scanner1.nextDouble();
                break;
            } catch (Exception error) {
                System.out.println("El argumento no es válido");
                datoValido3 = false;
                scanner1.nextLine();
            }
        }
        scanner1.nextLine();
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner1.nextLine();

        System.out.print("Contraseña: ");
        String contraseña= scanner1.nextLine();


        int idEmpleado = contadorIdEmpleado++;

        SucursalAcueducto sucursalAcueducto = new SucursalAcueducto("Acueducto", "Av. Acueducto #256");
        Capturista capturista = new Capturista(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion, sucursalAcueducto, salario, Rol.CAPTURISTA, fechaIngreso, contraseña, nombreUsuario);
        capturistasAcueducto.add(capturista);

        System.out.println("\n**Empleado registrado exitosamente!");


        System.out.println("\n**Capturistas registrados en Sucursal Acueducto:**");
        for (Capturista empleado : capturistasAcueducto) {
            System.out.println(empleado.toString());
        }
    }
    public static void modificarEjecutivosAcueducto(String nombreUsuario) {

        EjecutivoDeCuenta empleado = null;
        if (ejecutivosAcueducto.isEmpty()){
            System.out.println("No hay ejecutivos de cuenta registrados en esta sucursal");
            return;
        }
        else{
            for (EjecutivoDeCuenta empleadoAux : ejecutivosAcueducto) {
                if (empleadoAux.getNombreUsuario().equals(nombreUsuario)) {
                    empleado = empleadoAux;
                    break;
                }
            }

            if (empleado != null) {
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellidos: " + empleado.getApellidos());
                System.out.println("Fecha de nacimiento: " + empleado.getFechaNacimiento());
                System.out.println("Fecha de ingreso: " + empleado.getFechaInicioTrabajo());
                System.out.println("CURP: " + empleado.getCURP());
                System.out.println("Salario: " + empleado.getSalario());
                System.out.println("Rol: " + empleado.getRol());

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("¿Qué datos desea modificar? (Introduzca el número):");
                System.out.println("1. Nombre");
                System.out.println("2. Apellidos");
                System.out.println("3. Fecha de nacimiento");
                System.out.println("4. Fecha de ingreso");
                System.out.println("5. CURP");
                System.out.println("6. Salario");

                int opcion = scanner2.nextInt();
                scanner2.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner2.nextLine();
                        empleado.setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.print("Ingrese los nuevos apellidos: ");
                        String nuevosApellidos = scanner2.nextLine();
                        empleado.setApellidos(nuevosApellidos);
                        break;
                    case 3:
                        System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                        String nuevaFechaNacimientoString = scanner2.nextLine();
                        LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoString, DateTimeFormatter.ISO_DATE);
                        empleado.setFechaNacimiento(nuevaFechaNacimiento);
                        break;
                    case 4:
                        System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
                        String nuevaFechaIngresoString = scanner2.nextLine();
                        LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoString, DateTimeFormatter.ISO_DATE);
                        empleado.setFechaInicioTrabajo(nuevaFechaIngreso);
                        break;
                    case 5:
                        System.out.print("Ingrese la nueva CURP: ");
                        String nuevaCurp = scanner2.nextLine();
                        empleado.setCURP(nuevaCurp);
                        break;
                    case 6:
                        System.out.print("Ingrese el nuevo salario: ");
                        double nuevoSalario = scanner2.nextDouble();
                        empleado.setSalario(nuevoSalario);
                        break;
                }

                System.out.println("Datos del empleado modificados exitosamente!");
            } else {
                System.out.println("No se encontró un empleado con el nombre de usuario " + nombreUsuario);
            }
        }
    }

    public static void eliminarEjecutivoAcueducto(String nombreUsuario) {
        EjecutivoDeCuenta empleado = null;
        for (EjecutivoDeCuenta empleadoAux : ejecutivosAcueducto) {
            if (empleadoAux.getNombreUsuario().equals(nombreUsuario)) {
                empleado = empleadoAux;
                break;
            }
        }
        if (empleado != null) {
            ejecutivosAcueducto.remove(empleado);
            System.out.println("Empleado eliminado exitosamente!");
        } else {
            System.out.println("No se encontró un empleado con el nombre de usuario " + nombreUsuario);
        }
    }

    public static void eliminarCapturistaMadero(String nombreUsuario) {
        Scanner scanner4 = new Scanner(System.in);

        // Find the capturista to remove
        Capturista capturistaAEliminar = null;
        for (Capturista capturista : capturistasMadero) {
            if (capturista.getNombreUsuario().equals(nombreUsuario)) {
                capturistaAEliminar = capturista;
                break;
            }
        }

        if (capturistaAEliminar != null) {
            System.out.println("\n¿Está seguro de que desea eliminar al capturista con el nombre de usuario: " + nombreUsuario + "?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int opcion = scanner4.nextInt();
            if (opcion == 1) {
                capturistasMadero.remove(capturistaAEliminar);
                System.out.println("\nCapturista eliminado con éxito.");
            } else {
                System.out.println("\nEliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún capturista con el nombre de usuario: " + nombreUsuario);
        }

    }
    public static void modificarCapturistaAcueducto(String nombreUsuario) {
        Scanner scanner2 = new Scanner(System.in);

        Capturista capturistaAModificar = null;
        for (Capturista capturista : capturistasAcueducto) {
            if (capturista.getNombreUsuario().equals(nombreUsuario)) {
                capturistaAModificar = capturista;
                break;
            }
        }
        if (capturistaAModificar != null) {
            System.out.println("\nInformación actual del capturista:");
            System.out.println("  Nombre: " + capturistaAModificar.getNombre());
            System.out.println("  Apellidos: " + capturistaAModificar.getApellidos());
            System.out.println("  Fecha de nacimiento: " + capturistaAModificar.getFechaNacimiento());
            System.out.println("  Fecha de ingreso: " + capturistaAModificar.getFechaInicioTrabajo());
            System.out.println("  CURP: " + capturistaAModificar.getCURP());
            System.out.println("  Salario: "+capturistaAModificar.getSalario());

            System.out.println("¿Qué datos desea modificar? (Introduzca el número):");
            System.out.println("1. Nombre");
            System.out.println("2. Apellidos");
            System.out.println("3. Fecha de nacimiento");
            System.out.println("4. Fecha de ingreso");
            System.out.println("5. CURP");
            System.out.println("6. Salario");
            System.out.println("0. Salir");

            int opcion = scanner2.nextInt();
            scanner2.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner2.nextLine();
                    capturistaAModificar.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Ingrese los nuevos apellidos: ");
                    String nuevosApellidos = scanner2.nextLine();
                    capturistaAModificar.setApellidos(nuevosApellidos);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                    String nuevaFechaNacimientoString = scanner2.nextLine();
                    LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoString, DateTimeFormatter.ISO_DATE);
                    capturistaAModificar.setFechaNacimiento(nuevaFechaNacimiento);
                    break;
                case 4:
                    System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
                    String nuevaFechaIngresoString = scanner2.nextLine();
                    LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFechaIngresoString, DateTimeFormatter.ISO_DATE);
                    capturistaAModificar.setFechaInicioTrabajo(nuevaFechaIngreso);
                    break;
                case 5:
                    System.out.print("Ingrese la nueva CURP: ");
                    String nuevaCurp = scanner2.nextLine();
                    capturistaAModificar.setCURP(nuevaCurp);
                    break;
                case 6:
                    boolean datoValido = false;
                    double nuevoSalario = 0;
                    while (!datoValido) {
                        try {
                            System.out.print("Ingrese el nuevo salario: ");
                            nuevoSalario = scaner.nextDouble();
                            datoValido = true;
                        } catch (Exception error) {
                            System.out.println("El argumento no es válido");
                            datoValido = false;
                            scaner.nextLine();
                        }
                    }
                    capturistaAModificar.setSalario(nuevoSalario);
                    scanner2.nextLine();
                    break;
                case 0:
                    break;
            }

            System.out.println("\nInformación del capturista modificada con éxito.");
        } else {
            System.out.println("No se encontró ningún capturista con el nombre de usuario: " + nombreUsuario);
        }
    }
    public static void eliminarCapturistaAcueducto(String nombreUsuario) {
        Scanner scanner4 = new Scanner(System.in);

        // Find the capturista to remove
        Capturista capturistaAEliminar = null;
        for (Capturista capturista : capturistasAcueducto) {
            if (capturista.getNombreUsuario().equals(nombreUsuario)) {
                capturistaAEliminar = capturista;
                break;
            }
        }
        if (capturistaAEliminar != null) {
            System.out.println("\n¿Está seguro de que desea eliminar al capturista con el nombre de usuario: " + nombreUsuario + "?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int opcion = scanner4.nextInt();
            if (opcion == 1) {
                capturistasAcueducto.remove(capturistaAEliminar);
                System.out.println("\nCapturista eliminado con éxito.");
            } else {
                System.out.println("\nEliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún capturista con el nombre de usuario: " + nombreUsuario);
        }

    }
    public static void menuEjecutivoDeCuentaMadero(){
        Scanner scan1= new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scan1.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scan1.nextLine();

        boolean usuarioValido = false;
        for (EjecutivoDeCuenta ejecutivo : ejecutivosMadero) {
            if (ejecutivo.getNombreUsuario().equals(nombreUsuario) && ejecutivo.getContraseña().equals(contraseña)) {
                usuarioValido = true;
                break;
            }
        }
        if (usuarioValido){
            int opcion;
            do{
                System.out.println("¿Qué desea hacer? ");
                System.out.println("1. Registrar cliente\n2. Modificar cliente"
                        + "\n3.Eliminar cliente\n4. Mostrar clientes registrados en la sucursal Madero"
                        + "\n5. Autorizar tarjeta de crédito\n6. Salir");
                opcion= scan1.nextInt();
                switch (opcion){
                    case 1:
                        break;
                    case 2:
                        scan1.nextLine();
                        System.out.print("Ingrese el nombre de usuario del cliente que desea modificar: ");
                        String nombreUsuario1= scan1.nextLine();
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre de usuario del cliente que desea eliminar: ");
                        String nombreUsuario2= scan1.nextLine();
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }while (opcion!=6);
        }else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    public static void menuEjecutivoDeCuentaAcueducto() {
        AltaCliente s= new AltaCliente();
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scan2.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scan2.nextLine();

        boolean usuarioValido = false;
        for (EjecutivoDeCuenta ejecutivo : ejecutivosAcueducto) {
            if (ejecutivo.getNombreUsuario().equals(nombreUsuario) && ejecutivo.getContraseña().equals(contraseña)) {
                usuarioValido = true;
                break;
            }
        }
        if (usuarioValido) {
            int opcion;
            do {
                System.out.println("¿Qué desea hacer? ");
                System.out.println("1. Registrar cliente\n2. Modificar cliente"
                        + "\n3.Eliminar cliente\n4. Mostrar clientes registrados en la sucursal Acueducto"
                        + "\n5. Autorizar tarjeta de crédito\n6. Salir");
                opcion = scan2.nextInt();
                switch (opcion) {
                    case 1:
                        s.DarAltaCliente();
                        break;
                    case 2:
                        scan2.nextLine();
                        s.modificarDatosCliente();
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre de usuario del cliente que desea eliminar: ");
                        String nombreUsuario2= scan2.nextLine();
                        s.eliminarCliente((nombreUsuario2));
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            } while (opcion != 6);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

    }
    }
