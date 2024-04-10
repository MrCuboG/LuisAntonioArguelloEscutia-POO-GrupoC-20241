package Usuarios;

import java.time.LocalDate;

import utils.Rol;

public class Asistente extends Usuario{
    
    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String rfc) {
        super(nombre, apellido, telefono, Rol.ASISTENTE);
        this.fechaInicio = LocalDate.now();
        this.sueldo = sueldo;
        this.rfc = rfc;
    }
    
    @Override
    public String toString() {
        return String.format("%s, Fecha de inicio: %s, Sueldo: %f, RFC: %s",
         super.toString(), this.fechaInicio, this.sueldo, this.rfc);
    }
}
