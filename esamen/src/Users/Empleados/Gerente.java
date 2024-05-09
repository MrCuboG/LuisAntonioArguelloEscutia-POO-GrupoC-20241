package Users.Empleados;

import Sucursales.Sucursal;
import Users.utils.constantes.Rol;

import java.time.LocalDate;

public class Gerente extends Empleado {

    private static int contadorIdEmpleado= 1;

    public Gerente(String nombre, String apellido, String ciudad, String estado, String direccion, String nacimiento, String rfc, String curp, String user, String password, Rol rol, Sucursal sucursal, double salario, LocalDate fechaInicioTrabajo) {
        super(nombre, apellido, ciudad, estado, direccion, nacimiento, rfc, curp, user, password, rol, sucursal, salario, fechaInicioTrabajo);
    }

//    @Override
//    public String toString() {
//        return "GerenteSucursal{" +
//                "numeroEmpleado=" + idEmpleado +
//                ", " + super.toString() +
//                '}';
//    }

}
