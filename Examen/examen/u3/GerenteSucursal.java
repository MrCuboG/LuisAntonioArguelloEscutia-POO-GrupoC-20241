
package examen.u3;

import java.time.LocalDate;

public class GerenteSucursal extends Empleado {
    
    private static int contadorIdEmpleado= 1;
    
    public GerenteSucursal() {
        super();
    }
    
    public GerenteSucursal(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento,
                           String rfc, String CURP, String direccion,
                           Sucursal sucursal, double salario, String rol, LocalDate fechaInicioTrabajo) {
        super(idEmpleado, nombre, apellidos, fechaNacimiento, rfc, CURP, direccion, 
                sucursal, salario , rol, fechaInicioTrabajo);
    }

    
    @Override
    public String toString() {
        return "GerenteSucursal{" +
                "numeroEmpleado=" + idEmpleado +
                ", " + super.toString() +
                '}';
    }
    
}
