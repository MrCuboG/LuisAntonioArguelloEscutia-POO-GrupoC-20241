package examen.u3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamenU3 {

    static Scanner scanner = new Scanner(System.in);
    static int contadorIdEmpleado= 1;
    private static final ArrayList<Empleado> empleados = new ArrayList<>();

    
    public static void main(String[] args) {
//            registrarEjecutivoDeCuenta();
//            mostrarEjecutivosRegistrados();
//////////////////ASIGNAR GERENTE POR DEFAULT EN SUCURSAL MADERO
        int idGerente = 1;
        String nombreGerente = "Diana";
        String apellidosGerente = "Campos";
        LocalDate fechaNacimientoGerente = LocalDate.of(1980, 10, 15);
        String rfcGerente = "PEJH801015HMNXXX";
        String curpGerente = "PEJH801015MCMNXXX";
        String direccionGerente = "Calle Morelos #456";
        Sucursal sucursalGerente = new SucursalMadero("Madero", "Av. Madero #123");
        double salarioGerente = 50000.00;
        String rolGerente = "Gerente";
        LocalDate fechaInicioTrabajoGerente = LocalDate.of(2020, 01, 01);

        GerenteSucursal gerenteMadero = new GerenteSucursal(idGerente, nombreGerente, apellidosGerente, fechaNacimientoGerente, rfcGerente, curpGerente, direccionGerente, sucursalGerente, salarioGerente, rolGerente, fechaInicioTrabajoGerente);

        SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123", gerenteMadero);
        System.out.println(sucursalMadero.toString()+gerenteMadero.toString());
//////////////// ASIGNAR GERENTE POR DEFAULT EN SUCURSAL ACUEDUCTO
    }
    
    public static void registrarEjecutivoDeCuenta(){
        
        Scanner scanner1= new Scanner(System.in);
        System.out.println("\n**Registro de empleado con rol de ejecutivo de cuenta**");

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
                scanner.nextLine();
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
                scanner.nextLine();
            }
        }

        System.out.print("RFC: ");
        String rfc = scanner1.nextLine();

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


        int idEmpleado = contadorIdEmpleado++;

        SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123");
        Empleado ejecutivoDeCuenta = new Empleado(idEmpleado, nombre, apellidos, fechaNacimiento, rfc, CURP, direccion, sucursalMadero, salario, "ejecutivo de cuenta", fechaIngreso);
        empleados.add(ejecutivoDeCuenta);
        
        List<Empleado> listaEjecutivos = empleados.stream().filter(x->x.getRol().equalsIgnoreCase("ejecutivo de cuenta")).collect(Collectors.toList());


        System.out.println("\nEmpleado registrado exitosamente!");
        
    }
    public static void mostrarEjecutivosRegistrados(){
        System.out.println(empleados);
    }
}
