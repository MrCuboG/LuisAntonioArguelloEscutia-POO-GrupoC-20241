package Users.Empleados;
import java.time.LocalDate;
import java.util.Scanner;
import Users.utils.constantes.Rol;
import Sucursales.Sucursal;


public class GerenteSucursal extends Empleado {
    private static int contadorIdEmpleado= 1;
//    public GerenteSucursal() {
//        super();
//    }

    public GerenteSucursal(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento,
                           String ciudad, String estado, String CURP, String direccion, Sucursal sucursal,
                           double salario, Rol rol, LocalDate fechaInicioTrabajo, String contraseña, String nombreUsuario) {
        super(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion,
                sucursal, salario, Rol.GERENTE_SUCURSAL, fechaInicioTrabajo, contraseña, nombreUsuario);
        this.idEmpleado= idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos != null ? apellidos : "Sin apellidos"; // Asignar valor por defecto si es nulo
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.CURP = CURP;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.salario = salario;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.contraseña= contraseña;
        setRfc(CURP);
    }


    public void setRfc(String rfc) {
        this.rfc = generarRFC();
    }


    @Override
    public String toString() {
        return "GerenteSucursal{" +
                "numeroEmpleado=" + idEmpleado +
                ", " + super.toString() +
                '}';
    }
}

