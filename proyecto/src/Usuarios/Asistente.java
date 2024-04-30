package Usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import Usuarios.utils.Rol;

public class Asistente extends Usuario implements EmpleadoUtils {
    
    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String rfc, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
        this.fechaInicio = LocalDate.now();
        this.sueldo = sueldo;
        this.rfc = rfc;
    }
    
    @Override

    public String toString() { //Aqui  lo estamos sobreescribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Fecha de inicio: %s, Sueldo: %.2f, RFC: %s",
         super.toString(), this.fechaInicio, this.sueldo, this.rfc) + ", Fecha de inicio: " + this.fechaInicio;
    }

    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada con correo");
    }
    @Override
    public void checarSalida(){
        System.out.println("Checar salida con correo");
    }
}
