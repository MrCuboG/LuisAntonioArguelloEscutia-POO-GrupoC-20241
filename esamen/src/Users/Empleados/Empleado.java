package Users.Empleados;

import Sucursales.Sucursal;
import Users.Usuario;
import Users.utils.constantes.Rol;

import java.time.LocalDate;

public class Empleado extends Usuario {
    protected int idEmpleado;
    protected Sucursal sucursal;
    protected double salario;
    protected LocalDate fechaInicioTrabajo;
    private static int contadorIdEmpleado = 1;

    public Empleado(String nombre, String apellido, String direccion, String nacimiento, String rfc, String curp, String user, String password, Rol rol, double salario, LocalDate fechaInicioTrabajo) {
        super(nombre, apellido, direccion, nacimiento, rfc, curp, user, password, rol);
        this.idEmpleado = contadorIdEmpleado++;
        this.salario = salario;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

//    public int getIdEmpleado() {
//        return idEmpleado;
//    }
//
//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//
//    public LocalDate getFechaNacimiento() {
//        return fechaNacimiento;
//    }
//
//    public void setFechaNacimiento(LocalDate fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }
//
//    public String getRfc() {
//        return rfc;
//    }
//
//    public void setRfc(String rfc) {
//        this.rfc = rfc;
//    }
//
//    public String getCURP() {
//        return CURP;
//    }
//
//    public void setCURP(String CURP) {
//        this.CURP = CURP;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//
//    public Sucursal getSucursal() {
//        return sucursal;
//    }
//
//    public void setSucursal(Sucursal sucursal) {
//        this.sucursal = sucursal;
//    }
//
//    public double getSalario() {
//        return salario;
//    }
//
//    public void setSalario(double salario) {
//        this.salario = salario;
//    }
//
//    public String getRol() {
//        return rol;
//    }
//
//    public void setRol(String rol) {
//        this.rol = rol;
//    }
//
//    public LocalDate getFechaInicioTrabajo() {
//        return fechaInicioTrabajo;
//    }
//
//    public void setFechaInicioTrabajo(LocalDate fechaInicioTrabajo) {
//        this.fechaInicioTrabajo = fechaInicioTrabajo;
//    }
//
//    @Override
//    public String toString(){
//        return "Empleado{"+
//                 "idEmpleado=" + idEmpleado +
//                ", nombre='" + nombre + '\'' +
//                ", apellidos='" + apellidos + '\'' +
//                ", fechaNacimiento=" + fechaNacimiento +
//                ", rfc='" + rfc + '\'' +
//                ", curp='" + CURP + '\'' +
//                ", direccion='" + direccion + '\'' +
//                ", sucursal=" + sucursal +
//                ", salario=" + salario +
//                ", rol=" + rol +
//                ", fechaInicioTrabajo=" + fechaInicioTrabajo +
//                '}';
//
//    }
}
