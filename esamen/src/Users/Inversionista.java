package Users;

import Sucursales.SucursalAcueducto;
import Sucursales.SucursalMadero;
import Users.Empleados.Empleado;
import Users.utils.UsuarioUtils;
import Users.utils.constantes.Rol;
import Sistemas.Menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


public class Inversionista extends Usuario {
    static String nombre;
    static String apellido;
    static String domicilio;
    static String nacimiento;
    static String rfc;
    static String curp;
    static String user;
    static String password;
    static double saldo;
    static LocalDate localDate;
    static Inversion inversion;
    static Scanner sc = new Scanner(System.in);

    public Inversionista(String nombre, String apellido, String direccion, String nacimiento,
                  String rfc, String curp, String user, String password,
                  double saldo){
        super(nombre, apellido, direccion, nacimiento, rfc, curp, user, password, Rol.INVERSIONISTA);
    }

    public static void registrarInversionistaMadero(){
        ArrayList<String> datosComun = UsuarioUtils.registarUsuarioComun();
        nombre = datosComun.get(0);
        apellido = datosComun.get(1);
        domicilio = datosComun.get(2);
        nacimiento = datosComun.get(3);
        rfc = datosComun.get(4);
        curp = datosComun.get(5);
        user = datosComun.get(6);
        password = datosComun.get(7);
        System.out.println("Inserte el saldo inicial del inversionista");
        while (true){
            try {
                saldo = sc.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Ingreso un valor invalido intentelo de nuevo");
            }
        }

        Inversionista inversionista = new Inversionista(nombre, apellido, domicilio, nacimiento, rfc, curp, user, password, saldo);
        SucursalMadero.getInversionistas().add(inversionista);
    }
    public void registrarInversionistaAcueducto(){
        ArrayList<String> datosComun = UsuarioUtils.registarUsuarioComun();
        nombre = datosComun.get(0);
        apellido = datosComun.get(1);
        domicilio = datosComun.get(2);
        nacimiento = datosComun.get(3);
        rfc = datosComun.get(4);
        curp = datosComun.get(5);
        user = datosComun.get(6);
        password = datosComun.get(7);
        System.out.println("Inserte el saldo inicial del inversionista");
        while (true){
            try {
                saldo = sc.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Ingreso un valor invalido intentelo de nuevo");
            }
        }

        Inversionista inversionista = new Inversionista(nombre, apellido, domicilio, nacimiento, rfc, curp, user, password, saldo);
        SucursalAcueducto.getInversionistas().add(inversionista);
    }


    public static void proveerFondos(){
        System.out.println("A cual sucursal le gustaria añadir fondos?");
        System.out.println("1.Madero");
        System.out.println("2.Acueducto");
        System.out.println("3.Salir");
        Scanner sc = new Scanner(System.in);
        int sucursal;
        double cantidad;
        while(true){
            try {
                sucursal = sc.nextInt();
                if(sucursal != 1 && sucursal != 2 && sucursal != 3){
                    throw new InputMismatchException();
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("El valor insertado es incorrecto o no existe, intentelo de nuevo:");
                sc.nextLine();
            }
        }
        while (true){
            System.out.println("Ingrese la cantidad a invertir");
            while(true){
                try {
                    cantidad = sc.nextDouble();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Ocurrio un error intentar de nuevo");
                }
            }
            if (cantidad <= saldo){
                localDate = LocalDate.now();
                String fecha = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                inversion = new Inversion(nombre + apellido, fecha, String.valueOf(cantidad));
                System.out.println("Se ah hecho la inversion correctamente");
                break;
            }else{
                System.out.println("La cantidad que se quiere invertir es mayor al saldo actual");
                System.out.println("Intentelo de nuevo");
            }
        }

        switch (sucursal){
            case 1:
                SucursalMadero.setHistorialInversiones(inversion.formated);
                break;
            case 2:
                SucursalAcueducto.setHistorialInversiones(inversion.formated);
                break;
            case 3:
                Menus menu = new Menus();
                menu.mostrarMenuInversionista(user);
                break;
        }
    }
//    public void modificarDatos() {
//        Scanner scanner1 = new Scanner(System.in);
//
//        System.out.println("\n---- Modificar datos de inversionista ----");
//        System.out.println("Datos actuales:");
//        System.out.println("Nombre: " + nombre);
//        System.out.println("Apellido: " + apellido);
//        System.out.println("Domicilio: " + domicilio);
//        System.out.println("Año de nacimiento: " + nacimiento);
//        System.out.println("RFC: " + rfc);
//        System.out.println("CURP: " + curp);
//        System.out.println("Usuario: " + user);
//
//        System.out.println("\n¿Qué datos desea modificar?");
//        System.out.println("1. Nombre");
//        System.out.println("2. Apellido");
//        System.out.println("3. Domicilio");
//        System.out.println("4. Año de nacimiento");
//        System.out.println("5. Usuario");
//        System.out.println("0. Salir");
//
//        int opcion = 1.nextInt();
//        scanner.nextLine(); // Consumir el salto de línea
//
//        switch (opcion) {
//            case 1:
//                System.out.print("Nuevo nombre: ");
//                NuevoNombre = scanner1.nextLine();
//                setNombre(NuevoNombre);
//                break;
//            case 2:
//                System.out.print("Nuevo apellido: ");
//                NuevoApellido = scanner1.nextLine();
//                setApellido(NuevoApellido);
//                break;
//            case 3:
//                scanner1.nextLine();
//                System.out.println("------Modificar domicilio------");
//                System.out.println("Ingera el ciudad");
//                String ciudad = scanner1.nextLine();
//                setCiudad(ciudad);
//                System.out.println("Ingera el estado");
//                String estado = scanner1.nextLine();
//                setEstado(estado);
//                System.out.println("Inserta direccion");
//                String direccion = scanner1.nextLine();
//                setDireccion(direccion);
//                domicilio = ciudad + " " + estado + " " + direccion;
//                System.out.println("-------------------");
//                break;
//            case 4:
//                System.out.print("Nuevo año de nacimiento: ");
//                NuevoNacimiento = scanner1.nextLine();
//                setNacimiento(NuevoNacimiento);
//                break;
//            case 5:
//                System.out.print("Nuevo usuario: ");
//                NuevoUsuario = scanner1.nextLine();
//                setUser(NuevoUsuario);
//                break;
//            case 0:
//                System.out.println("Modificación de datos cancelada.");
//                break;
//            default:
//                System.out.println("Opción no válida.");
//        }
//
//        System.out.println("\nDatos modificados correctamente.");
//    }


    public static void setSaldo(double Nuevsaldo) {
        saldo = Nuevsaldo;
    }
}


