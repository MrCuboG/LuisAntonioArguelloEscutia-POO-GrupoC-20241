package Empleados;
import java.time.LocalDate;
import Users.utils.constants.Rol;

public class GerenteSucursal extends Empleado {


    public GerenteSucursal() {
        super();
    }


    public GerenteSucursal(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento,
                           String rfc, String CURP, String direccion,
                           Sucursal sucursal, double salario, Rol rol, LocalDate fechaInicioTrabajo) {
        super(idEmpleado, nombre, apellidos, fechaNacimiento, rfc, CURP, direccion,
                sucursal, salario, Rol.GERENTE_SUCURSAL, fechaInicioTrabajo);
    }


    @Override
    public String toString() {
        return "GerenteSucursal{" +
                ", " + super.toString() +
                '}';
    }



    public void autorizarSolicitudTarjetaCredito() {

    }

    private void rechazarSolicitudTarjetaCredito (){

    }

}

