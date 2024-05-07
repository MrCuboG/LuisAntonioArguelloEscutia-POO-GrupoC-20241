package Empleados;
import java.time.LocalDate;
import utils.Rol;


public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String rfc;
    String CURP;
    private String direccion;
    private Sucursal sucursal;
    private double salario;
    private Rol rol;
    private LocalDate fechaInicioTrabajo;
    private static int nextId = 0;


    public Empleado() {

    }

    public Empleado(int idEmpleado, String nombre, String apellidos, LocalDate fechaNacimiento, String rfc, String CURP, String direccion, Sucursal sucursal, double salario, Rol rol, LocalDate fechaInicioTrabajo) {
        this.idEmpleado = nextId++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.CURP = CURP;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.salario = salario;
        this.rol = rol;
        this.fechaInicioTrabajo = fechaInicioTrabajo;

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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", rfc='" + rfc + '\'' +
                ", curp='" + CURP + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sucursal=" + sucursal +
                ", salario=" + salario +
                ", rol=" + rol +
                ", fechaInicioTrabajo=" + fechaInicioTrabajo +
                '}';

    }
}
