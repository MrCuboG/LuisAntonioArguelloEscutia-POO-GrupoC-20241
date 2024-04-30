package Usuarios;
import java.time.LocalDate;

import Usuarios.utils.Rol;

public class Gerente extends Usuario implements EmpleadoUtils{
    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc, ine;
    
    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String ine, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena);
        this.sueldo = sueldo;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaInicio = LocalDate.now();
    }

    @Override

    public String toString() { //Aqui  lo estamos sobreescribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %.2f, RFC: %s, INE: %s",
         super.toString(), this.sueldo, this.rfc, this.ine) + "Fecha de inicio: " + this.fechaInicio;
    }

    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada con huella");
    }
    @Override
    public void checarSalida(){
        System.out.println("Checar salida con huella");
    }

}
