package Users.Empleados;
import Users.utils.constantes.Rol;
import java.time.LocalDate;
import Sucursales.*;
import tarjetas.SolicitudTarjeta;

public class EjecutivoDeCuenta extends Empleado {

    /*private List<SolicitudTarjeta> solicitud;

    public EjecutivoDeCuenta() {
        this.requests = new ArrayList<>();
    }*/

    public EjecutivoDeCuenta(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento,
                             String ciudad, String estado, String CURP, String direccion, Sucursal sucursal,
                             double salario, Rol rol, LocalDate fechaInicioTrabajo, String contraseña, String nombreUsuario) {
        super(idEmpleado, nombre, apellidos, fechaNacimiento, ciudad, estado, CURP, direccion,
                sucursal, salario, Rol.EJECUTIVO_CUENTA, fechaInicioTrabajo, contraseña, nombreUsuario);
    }

    public void setRfc(String rfc) {
        this.rfc = generarRFC();
    }

    /*public void verSolicitudes() {
        for (SolicitudTarjeta request : solicitud) {

            System.out.println("Cliente: " + solicitud.Cliente.getNombre);//nombre
            System.out.println("Tipo de tarjeta: " + );//tipo
            System.out.println("Saldo Debe: " + );//saldo
            System.out.println("Estado: " + );//estado
            Sistema.out.println();


        }
    }*/
}
