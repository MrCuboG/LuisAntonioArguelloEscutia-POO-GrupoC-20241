package Users.Empleados;

import Sucursales.Sucursal;
import Users.Usuario;
import java.time.LocalDate;
import Users.utils.constantes.Rol;
import java.time.format.DateTimeFormatter;

public class Empleado{
    protected int idEmpleado;
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    protected String ciudad;
    protected String estado;
    protected String rfc;
    protected String CURP;
    protected String direccion;
    protected Sucursal sucursal;
    protected double salario;
    protected Rol rol;
    protected LocalDate fechaInicioTrabajo;
    protected String contraseña;
    protected String nombreUsuario;
    private static int contadorIdEmpleado = 1;

    public Empleado (){

    }

    public Empleado(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String CURP, String direccion, Sucursal sucursal, double salario, Rol rol, LocalDate fechaInicioTrabajo, String contraseña, String nombreUsuario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos != null ? apellidos : "Sin apellidos"; // Asignar valor por defecto si es nulo
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.CURP = CURP;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.salario = salario;
        this.rol = rol;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.contraseña= contraseña;
        this.nombreUsuario= nombreUsuario;
        this.rfc= generarRFC();

    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDate getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(LocalDate fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String generarRFC() {
        String homonimo = "";
        if (apellidos.length() > 1) {
            homonimo = apellidos.substring(0, 2);
        } else {
            homonimo = apellidos;
        }
        String apellidoMaterno = "";
        String primeraLetraApellidoMaterno="";
        if (apellidos.split(" ").length > 1) {
            apellidoMaterno = apellidos.split(" ")[1]; // Obtener el segundo apellido
            primeraLetraApellidoMaterno = apellidoMaterno.substring(0, 1); // Extraer la primera letra
        }
        String nombre = this.nombre.substring(0, 1); // Extraer la primera letra del nombre

        String fechaNacimientoStr;
        try {
            fechaNacimientoStr = fechaNacimiento.format(DateTimeFormatter.ofPattern("yyMMdd"));
        } catch (NullPointerException e) {
            System.err.println("Error al formatear la fecha de nacimiento: " + e.getMessage());
            return null;
        }


        return homonimo.toUpperCase() +primeraLetraApellidoMaterno.toUpperCase()+nombre.toUpperCase()+ fechaNacimientoStr ;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", rfc='" + rfc + '\'' + // Línea para imprimir el RFC
                ", curp='" + CURP + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sucursal=" + sucursal +
                ", salario=" + salario +
                ", rol=" + rol +
                ", fechaInicioTrabajo=" + fechaInicioTrabajo +
                '}';
    }

}
