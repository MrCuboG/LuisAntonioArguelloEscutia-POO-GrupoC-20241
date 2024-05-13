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
    String nombre;
    String apellido;
    String domicilio;
    String nacimiento;
    String rfc;
    String curp;
    String user;
    String password;
    double saldo;
    LocalDate localDate;
    Inversion inversion;
    Scanner sc = new Scanner(System.in);

    Inversionista(String nombre, String apellido, String direccion, String nacimiento,
                  String rfc, String curp, String user, String password,
                  double saldo){
        super(nombre, apellido, direccion, nacimiento, rfc, curp, user, password, Rol.INVERSIONISTA);
    }
    public void registrarInversionista(){
        ArrayList<String> datosComun = UsuarioUtils.registarUsuarioComun();
        this.nombre = datosComun.get(0);
        this.apellido = datosComun.get(1);
        this.domicilio = datosComun.get(2);
        this.nacimiento = datosComun.get(3);
        this.rfc = datosComun.get(4);
        this.curp = datosComun.get(5);
        this.user = datosComun.get(6);
        this.password = datosComun.get(7);
        System.out.println("Inserte el saldo inicial del inversionista");
        this.saldo = sc.nextDouble();

        Inversionista inversionista = new Inversionista(nombre, apellido, domicilio, nacimiento, rfc, curp, user, password, saldo);
    }

    public void proveerFondos(/**Sucursal, cantidad**/){
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


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

